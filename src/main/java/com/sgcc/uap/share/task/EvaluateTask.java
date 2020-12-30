package com.sgcc.uap.share.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;


/*
 * 15天内可以投诉
 * 15天后，默认好评
 * */
@Component
public class EvaluateTask{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(EvaluateTask.class);
	
	private OrderCustomerRepository orderCustomerRepository = (OrderCustomerRepository) ApplicationContextUtil.getBean("orderCustomerRepository");

    @Async
	public void run() {
		logger.info("EvaluateTask start ! ");
		
		Integer updateCount = 0;
		//5星 状态8 15天
		updateCount = orderCustomerRepository.getNotEvaluate(5, "默认好评",  "默认好评", 8, 15);
		logger.info("EvaluateTask updateCount = "+updateCount);
			
	}
	
	/*
	@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
	字段　　允许值　　允许的特殊字符 
	秒     　 0-59 　　　　, - * / 
	分     　 0-59　　　　 , - * / 
	小时      0-23 　　　　, - * / 
	日期      1-31 　　　　, - * ? / L W C 
	月份      1-12 　　　　, - * / 
	星期      1-7 　　　　  , - * ? / L C # 
	年     1970-2099 　　, - * /
	
	
	 * */

}
