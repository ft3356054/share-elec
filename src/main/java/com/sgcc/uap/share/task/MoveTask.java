package com.sgcc.uap.share.task;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;


/*
 * 现表搬迁历史表
 * */
@Component
public class MoveTask  extends TimerTask{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(MoveTask.class);
	
	private OrderCustomerRepository orderCustomerRepository = (OrderCustomerRepository) ApplicationContextUtil.getBean("orderCustomerRepository");

	@Override
    @Async
    @Scheduled(fixedDelay = 60000*60*24) //每1天执行一次
	public void run() {
		Integer updateCount = 0;
		//5星 状态8 15天
		updateCount = orderCustomerRepository.getNotEvaluate(5, "默认好评",  "默认好评", 8, 15);
		logger.info("EvaluateTask updateCount = "+updateCount);
		
	}

}
