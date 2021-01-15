package com.sgcc.uap.share.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.services.IOrderCustomerService;


/* 15天未验收，且没有投诉的订单，自动完结，并划转
 * 15天内可以投诉
 * 15天后，默认好评
 * */
@Component
public class EvaluateTask{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(EvaluateTask.class);
	
	IOrderCustomerService orderCustomerService = (IOrderCustomerService) ApplicationContextUtil.getBean("orderCustomerService");
	
	
    @Async
	public void run() {
		logger.info("EvaluateTask start ! ");
		boolean flag = orderCustomerService.runElecEvaluateTask();
		logger.info("EvaluateTask end ! result =  " + flag);
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
