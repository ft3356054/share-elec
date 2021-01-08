package com.sgcc.uap.share.task;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.services.IGetOrderElectricianService;
import com.sgcc.uap.share.customer.services.IOrderCustomerService;
import com.sgcc.uap.share.domain.BaseSystemConfig;
import com.sgcc.uap.share.domain.ElecPosition;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.electrician.services.IElecPositionService;
import com.sgcc.uap.share.services.IBaseSystemConfigService;


/*
 * 自动重派单
 * 系统派发给电工的订单，若电工在指定时间内未接单。系统将重新派单给其他电工
 * */
@Component
public class AutoReSendOrderTask {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(AutoReSendOrderTask.class);
	
	IGetOrderElectricianService getOrderElectricianService = (IGetOrderElectricianService) ApplicationContextUtil.getBean("getOrderElectricianService");
	IBaseSystemConfigService baseSystemConfigService = (IBaseSystemConfigService) ApplicationContextUtil.getBean("baseSystemConfigService");
	IOrderCustomerService orderCustomerService = (IOrderCustomerService) ApplicationContextUtil.getBean("orderCustomerService");
	IElecPositionService elecPositionService = (IElecPositionService) ApplicationContextUtil.getBean("elecPositionService");
	@SuppressWarnings("rawtypes")
	@Autowired
    private RedisTemplate redisTemplate;

    @Async
	public void run() {
			logger.info("AutoReSendOrderTask start ! ");

			BaseSystemConfig baseSystemConfig = baseSystemConfigService.getBaseSystemConfigByConfigType("7");
			
			List<OrderElectrician> orderElectricians = getOrderElectricianService.findByOrderElectricianStatus("2", baseSystemConfig.getConfigValue());
		
			//修改状态 
			List<String> orderIds = new ArrayList<String>();
			if(orderElectricians.size()>0){
				Timestamp nowDate =new Timestamp(System.currentTimeMillis());
				//String nowString = TimeStamp.toString(new Date());
				for(OrderElectrician orderElectrician :orderElectricians){
					orderIds.add(orderElectrician.getOrDERId());
					orderElectrician.setUpdateTime(nowDate);
					orderElectrician.setOrderElectricianStatus("1");
					orderElectrician.setFinishTime(nowDate);
					getOrderElectricianService.updateOrderElectricianStatus(orderElectrician);
					
					ElecPosition elecPosition = elecPositionService.getElecPositionByElectricianId(orderElectrician.getElectricianId());
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("electricianId", elecPosition.getElectricianId());
					map.put("status", elecPosition.getStatus());
					try {
						elecPositionService.saveElecPosition(map);
					} catch (Exception e) {
						// {"items":[{"electricianId":"123","areaId":"1","lon":"12.546","lat":"52.698","status":"1"}]}
						e.printStackTrace();
					}
				}
				List<OrderCustomer> orderCustomers = orderCustomerService.getOrderCustomerByOrderIds(orderIds);
				for(OrderCustomer orderCustomer :orderCustomers){
					//放入派单队列中
					redisTemplate.opsForList().rightPush("assignCustomerOrder", orderCustomer);
				}
				
				
			}
			
	}

}
