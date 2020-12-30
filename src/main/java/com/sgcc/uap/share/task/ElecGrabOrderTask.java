package com.sgcc.uap.share.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.electrician.services.IOrderElectricianService;


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
		orderElectricianService.qiangdantanchuang(orderCustomer);
		if(null!=orderCustomer){
			//orderElectricianService.qiangdantanchuang(orderCustomer);
		}
			
		logger.info("In ElecGrabOrder end ! "+ Thread.currentThread().getId() + ":" + Thread.currentThread().getName() 
				+ " ,date =" + new Date( System.currentTimeMillis()));
	}
}

