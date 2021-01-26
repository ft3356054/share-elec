package com.sgcc.uap.share.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.domain.BaseSystemConfig;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.electrician.services.IOrderElectricianService;
import com.sgcc.uap.share.services.IBaseSystemConfigService;


/*
 * 电工抢单弹框
 * */

@Component
public class ElecGrabOrderTask {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(ElecGrabOrderTask.class);
	
	IOrderElectricianService orderElectricianService = (IOrderElectricianService) ApplicationContextUtil.getBean("orderElectricianService");
	IBaseSystemConfigService baseSystemConfigService = (IBaseSystemConfigService) ApplicationContextUtil.getBean("baseSystemConfigService");
	@SuppressWarnings("rawtypes")
	@Autowired
    private RedisTemplate redisTemplate;

	@Async
	public void start() {
		
		logger.info("In ElecGrabOrder begin ! "+ Thread.currentThread().getId() + ":" + Thread.currentThread().getName() 
				+ " ,date =" + new Date( System.currentTimeMillis()));
		
		
		//从队列中获取用户刚下单的订单
		OrderCustomer orderCustomer = null;
		orderCustomer = (OrderCustomer) redisTemplate.opsForList().leftPop("newCustomerOrder");
		logger.info("获取并删除 orderCustomer = "+ orderCustomer);
		
		//调用抢单弹框方法
		if(null!=orderCustomer){
			BaseSystemConfig baseSystemConfig = baseSystemConfigService.getBaseSystemConfigByConfigType("1");
			orderElectricianService.qiangdantanchuang(orderCustomer,Integer.parseInt(baseSystemConfig.getConfigValue()));
		}
		
		
		//从队列中获取用户刚下单的订单
		OrderCustomer orderCustomer2 = null;
		orderCustomer2 = (OrderCustomer) redisTemplate.opsForList().leftPop("new2CustomerOrder");
		logger.info("获取并删除 orderCustomer 2 = "+ orderCustomer);
		
		//调用抢单弹框方法
		if(null!=orderCustomer2){
			BaseSystemConfig baseSystemConfig2 = baseSystemConfigService.getBaseSystemConfigByConfigType("10");
			orderElectricianService.qiangdantanchuang(orderCustomer,Integer.parseInt(baseSystemConfig2.getConfigValue()));
		}
			
	}
}

