package com.sgcc.uap.share.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskConfig {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(TaskConfig.class);
	
	@Autowired
    private ElecGrabOrderTask elecGrabOrderTask;
	@Autowired
    private ElecGrabOrder2Task elecGrabOrder2Task;
	@Autowired
    private ElecAssignOrderTask elecAssignOrderTask;
	@Autowired
    private AutoSendOrderTask autoSendOrderTask;
	@Autowired
    private AutoReSendOrderTask autoReSendOrderTask;
	@Autowired
    private EvaluateTask evaluateTask;
	
	
	/*
	//电工抢单弹框
	@Scheduled(initialDelay = 1000*5 , fixedDelay = 1000*5)
	public void elecGrabOrderTask() {
		elecGrabOrderTask.start();
	}
	
	//电工抢单弹框 扩大范围
	@Scheduled(initialDelay = 1000*10 , fixedDelay = 1000*10)
	public void elecGrabOrder2Task() {
		elecGrabOrder2Task.start();
	}
	
	//20分钟没有被抢到的订单，会自动派给电工  
	@Scheduled(initialDelay = 1000*60 , fixedDelay = 1000*30)
	public void autoSendOrderTask() {
		autoSendOrderTask.run();
	}
	
	//系统派发给电工的订单，若电工在指定时间内未接单。系统将重新派单给其他电工
	@Scheduled(initialDelay = 1000*60 , fixedDelay = 1000*40)
	public void autoReSendOrderTask() {
		autoReSendOrderTask.run();
	}
	
	//电工派单弹框
	@Scheduled(initialDelay = 1000*10 , fixedDelay = 1000*20)
	public void elecAssignOrderTask() {
		elecAssignOrderTask.start();
	}
	*/
	
	/*
	//自动评价
	@Scheduled(initialDelay = 1000*60 , fixedDelay = 1000*50)
	public void evaluateTask() {
		evaluateTask.run();
	}
	*/
}
