package com.sgcc.uap.share.task;

import java.util.List;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.services.IGetOrderElectricianService;
import com.sgcc.uap.share.domain.BaseSystemConfig;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.services.IBaseSystemConfigService;


/*
 * 自动重派单
 * 系统派发给电工的订单，若电工在指定时间内未接单。系统将重新派单给其他电工
 * */
@Component
public class AutoReSendOrderTask  extends TimerTask{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(AutoReSendOrderTask.class);
	
	IGetOrderElectricianService orderElectricianService = null;
	IBaseSystemConfigService baseSystemConfigService = null;
	

	@Override
    @Async
    @Scheduled(initialDelay = 1000*60*5 ,fixedDelay = 60000*5) //每5分钟执行一次
	public void run() {
			logger.info("AutoReSendOrderTask start ! ");
			
			orderElectricianService = (IGetOrderElectricianService) ApplicationContextUtil.getBean("getOrderElectricianService");
			baseSystemConfigService = (IBaseSystemConfigService) ApplicationContextUtil.getBean("baseSystemConfigService");

			BaseSystemConfig baseSystemConfig = baseSystemConfigService.getBaseSystemConfigByConfigType("7");
			
			List<OrderElectrician> orderElectricians = orderElectricianService.findByOrderElectricianType("2", baseSystemConfig.getConfigValue());
		
			//修改状态 待郭庆提供接口
			
			
			//放入派单队列中
			
			
	}

}
