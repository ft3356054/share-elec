package com.sgcc.uap.share.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
 * 电工抢单弹框
 * 超出新发时限无人接单则扩大范围
 * */

@Component
public class ElecGrabOrder2Task {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(ElecGrabOrder2Task.class);
	
	IOrderCustomerService orderCustomerService = (IOrderCustomerService) ApplicationContextUtil.getBean("orderCustomerService");
	IBaseSystemConfigService baseSystemConfigService = (IBaseSystemConfigService) ApplicationContextUtil.getBean("baseSystemConfigService");
	@SuppressWarnings("rawtypes")
	@Autowired
    private RedisTemplate redisTemplate;
	
	

	@Async
	public void start() {
		
		logger.info("ElecGrabOrder2Task start ! ");
		
		BaseSystemConfig baseSystemConfig = baseSystemConfigService.getBaseSystemConfigByConfigType("8");
		Integer value = Integer.parseInt(baseSystemConfig.getConfigValue());
		
		List<String> orderStatus = new ArrayList<>();
		orderStatus.add("1");
		orderStatus.add("11");
		
		List<OrderCustomer> orderCustomers = orderCustomerService.findByOrderStatus(orderStatus, value, (value+5));
		
		//放入队列中
		if(orderCustomers.size()>0){
			for(OrderCustomer orderCustomer :orderCustomers){
				String newKey = "qd"+orderCustomer.getOrderId();
				boolean flag = redisTemplate.hasKey(newKey);
				if(!flag){
					redisTemplate.opsForList().rightPush("new2CustomerOrder", orderCustomer);
					redisTemplate.opsForValue().set(newKey, orderCustomer, 5L, TimeUnit.MINUTES);
					//stringRedisTemplate.opsForValue().set(newKey, newKey, 5L, TimeUnit.MINUTES);
				}
				
			}
		}
		
	}
}

