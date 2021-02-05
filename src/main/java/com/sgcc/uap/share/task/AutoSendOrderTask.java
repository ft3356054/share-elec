package com.sgcc.uap.share.task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.services.IOrderCustomerService;
import com.sgcc.uap.share.customer.services.IOrderFlowService;
import com.sgcc.uap.share.domain.BaseEnums;
import com.sgcc.uap.share.domain.BaseSystemConfig;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.login.controller.WebSocketServer;
import com.sgcc.uap.share.services.IBaseEnumsService;
import com.sgcc.uap.share.services.IBaseSystemConfigService;
import com.sgcc.uap.share.services.INotifyAnnounceService;
import com.sgcc.uap.share.services.INotifyAnnounceUserService;
import com.sgcc.uap.util.MapUtil;
import com.sgcc.uap.util.TimeStamp;
import com.sgcc.uap.util.UuidUtil;
import com.sgcc.uap.utils.json.JsonUtils;


/*
 * 自动派单
 * 20分钟没有被抢到的订单，会自动派给电工
 * */
@Component
public class AutoSendOrderTask{
	
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(AutoSendOrderTask.class);
	
	IOrderCustomerService orderCustomerService = (IOrderCustomerService) ApplicationContextUtil.getBean("orderCustomerService");
	IBaseSystemConfigService baseSystemConfigService = (IBaseSystemConfigService) ApplicationContextUtil.getBean("baseSystemConfigService");
	IOrderFlowService orderFlowService = (IOrderFlowService) ApplicationContextUtil.getBean("orderFlowService");
	INotifyAnnounceService notifyAnnounceService = (INotifyAnnounceService) ApplicationContextUtil.getBean("notifyAnnounceService");
	IBaseEnumsService baseEnumsService = (IBaseEnumsService) ApplicationContextUtil.getBean("baseEnumsService");
	INotifyAnnounceUserService notifyAnnounceUserService = (INotifyAnnounceUserService) ApplicationContextUtil.getBean("notifyAnnounceUserService");
	@SuppressWarnings("rawtypes")
	@Autowired
    private RedisTemplate redisTemplate;

    @Async
	public void run() {
			logger.info("AutoSendOrderTask start ! ");
			
			BaseSystemConfig baseSystemConfig = baseSystemConfigService.getBaseSystemConfigByConfigType("2");
			List<String> orderStatus = new ArrayList<>();
			orderStatus.add("1");
			orderStatus.add("11");
			
			List<OrderCustomer> orderCustomers = orderCustomerService.findByOrderStatus(orderStatus, baseSystemConfig.getConfigValue());
			
			//放入队列中，电工侧获取队列消息，单发给电工
			if(orderCustomers.size()>0){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				String now = df.format(new Date()); 
				for(OrderCustomer orderCustomer :orderCustomers){
					//大于2小时的单子，自动完结；小于2小时的单子，自动派单
					String updateTime = orderCustomer.getUpdateTime();
					int chaZhi = TimeStamp.minCha(now, updateTime);
					if(chaZhi>120){
						String dateString = TimeStamp.toString(new Date());
						Map<String,Object> map = new HashMap<String, Object>();
						map.put("orderId", orderCustomer.getOrderId());
						map.put("updateTime", dateString);
						map.put("finishTime", dateString);
						map.put("status", "4");
						
						//获取Enum通知类
						BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("2",  "4");	
						
						try {
							//修改主订单
							orderCustomerService.saveOrderCustomer(map, null);
							
							//新增流水
							Map<String,Object> mapOrderFlow = null;
							mapOrderFlow = MapUtil.flowAdd(orderCustomer.getOrderId(), 0,  4, "SYSTEM", dateString, 2,  baseEnums.getEnumsA());
							
							orderFlowService.saveOrderFlow(mapOrderFlow);
						
						
							String announceId = UuidUtil.getUuid32();
							Map<String,Object> mapNotify =
									MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", baseEnums.getEnumsB(), baseEnums.getEnumsC(),dateString, 
											"5","");
							notifyAnnounceService.saveNotifyAnnounce(mapNotify);
							
							Map<String,Object> mapNotifyUser = 
									MapUtil.notifyUserAdd(orderCustomer.getCustomerId(), announceId, 1, 0, dateString, baseEnums.getEnumsD(),orderCustomer.getOrderId());
							notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);
							
							//发送websocket消息
							Map<String,String> mapString = new HashMap<String,String>();
							mapString.put("orderId", "");
							mapString.put("content", baseEnums.getEnumsC());
							String jsonString = JsonUtils.toJson(mapString);
							WebSocketServer.sendInfo(jsonString,orderCustomer.getCustomerId());
						
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else{
						redisTemplate.opsForList().rightPush("assignCustomerOrder", orderCustomer);
					}
				}
			}
	}

}
