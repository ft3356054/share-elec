package com.sgcc.uap.share.task;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.services.IOrderCustomerService;
import com.sgcc.uap.share.domain.BaseSystemConfig;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.services.IBaseSystemConfigService;


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
				for(OrderCustomer orderCustomer :orderCustomers){
					redisTemplate.opsForList().rightPush("assignCustomerOrder", orderCustomer);
				}
			}
	}

}
