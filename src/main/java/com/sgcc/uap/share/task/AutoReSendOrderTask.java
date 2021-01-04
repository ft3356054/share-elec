package com.sgcc.uap.share.task;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.services.IGetOrderElectricianService;
import com.sgcc.uap.share.customer.services.IOrderCustomerService;
import com.sgcc.uap.share.domain.BaseSystemConfig;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.electrician.services.IOrderElectricianService;
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
	IOrderElectricianService orderElectricianService = (IOrderElectricianService) ApplicationContextUtil.getBean("orderElectricianService");
	IBaseSystemConfigService baseSystemConfigService = (IBaseSystemConfigService) ApplicationContextUtil.getBean("baseSystemConfigService");
	IOrderCustomerService orderCustomerService = (IOrderCustomerService) ApplicationContextUtil.getBean("orderCustomerService");
	@SuppressWarnings("rawtypes")
	@Autowired
    private RedisTemplate redisTemplate;

    @Async
	public void run() {
			logger.info("AutoReSendOrderTask start ! ");

			BaseSystemConfig baseSystemConfig = baseSystemConfigService.getBaseSystemConfigByConfigType("7");
			
			List<OrderElectrician> orderElectricians = getOrderElectricianService.findByOrderElectricianStatus("2", baseSystemConfig.getConfigValue());
		
			//修改状态 待郭庆提供接口
			List<String> orderIds = null;
			if(orderElectricians.size()>0){
				for(OrderElectrician orderElectrician :orderElectricians){
					orderIds.add(orderElectrician.getOrDERId());
					orderElectricianService.esc(orderElectrician.getOrderElectricianId(), "1");
				}
				List<OrderCustomer> orderCustomers = orderCustomerService.getOrderCustomerByOrderIds(orderIds);
				for(OrderCustomer orderCustomer :orderCustomers){
					//放入派单队列中
					redisTemplate.opsForList().rightPush("assignCustomerOrder", orderCustomer);
				}
				
				
			}
			
	}

}
