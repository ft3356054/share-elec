package com.sgcc.uap.share.task;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.domain.NotifyAnnounce;
import com.sgcc.uap.share.repositories.NotifyAnnounceRepository;
import com.sgcc.uap.share.repositories.NotifyAnnounceUserRepository;


/*
 * 消息通知搬迁
 * */
@Component
public class MoveNotifyTask  extends TimerTask{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(MoveNotifyTask.class);
	
	private NotifyAnnounceRepository notifyAnnounceRepository = 
			(NotifyAnnounceRepository) ApplicationContextUtil.getBean("notifyAnnounceRepository");
	private NotifyAnnounceUserRepository notifyAnnounceUserRepository = 
			(NotifyAnnounceUserRepository) ApplicationContextUtil.getBean("notifyAnnounceUserRepository");
	
	

	@Override
    @Async
    @Scheduled(initialDelay = 1000*60*5 ,fixedDelay = 60000*60*24) //每天执行一次
	public void run() {
			logger.info("MoveNotifyTask start ! ");
		
			ArrayList<String> orderIds = new ArrayList<String>();
			
			List<NotifyAnnounce> notifyAnnounces = notifyAnnounceRepository.findFinishNotify("180");
			logger.info("MoveNotifyTask notifyAnnounces = "+notifyAnnounces);
			
			if(notifyAnnounces.size()>0){
				for(NotifyAnnounce notifyAnnounce:notifyAnnounces){
					orderIds.add(notifyAnnounce.getAnnounceId());
				}
				
				//搬迁通知表
				notifyAnnounceRepository.insertToHis(orderIds);
				notifyAnnounceRepository.deleteNowTable(orderIds);
				
				//搬迁通知用户表
				notifyAnnounceUserRepository.insertToHis(orderIds);
				notifyAnnounceUserRepository.deleteNowTable(orderIds);
				
			}
		
	}
	
}
