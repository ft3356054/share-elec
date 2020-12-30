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
    private ElecAssignOrderTask elecAssignOrderTask;
	
	
	@Scheduled(initialDelay = 1000*5 , fixedDelay = 1000*5)
	public void elecGrabOrderTask1() {
		elecGrabOrderTask.start();
	}
	
	@Scheduled(initialDelay = 1000*10 , fixedDelay = 1000*6)
	public void elecGrabOrderTask2() {
		elecAssignOrderTask.start();
	}
}
