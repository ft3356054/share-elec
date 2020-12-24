package com.sgcc.uap.share.task;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;


/*
 * 15天内可以投诉
 * 15天后，默认好评
 * */
@Component
public class EvaluateTask  extends TimerTask{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(EvaluateTask.class);
	
	private OrderCustomerRepository orderCustomerRepository = (OrderCustomerRepository) ApplicationContextUtil.getBean("orderCustomerRepository");

	@Override
    @Async
    @Scheduled(fixedDelay = 60000*60*24) //每1天执行一次
	public void run() {
		
		try {
			Thread.sleep(1000*60*2);
			Integer updateCount = 0;
			//5星 状态8 15天
			updateCount = orderCustomerRepository.getNotEvaluate(5, "默认好评",  "默认好评", 8, 15);
			logger.info("EvaluateTask updateCount = "+updateCount);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
