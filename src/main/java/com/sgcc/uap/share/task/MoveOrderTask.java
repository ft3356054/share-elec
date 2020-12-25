package com.sgcc.uap.share.task;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;
import com.sgcc.uap.share.customer.repositories.OrderFlowRepository;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.electrician.repositories.OrderElectricianRepository;


/*
 * 现表搬迁历史表
 * */
@Component
public class MoveOrderTask  extends TimerTask{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(MoveOrderTask.class);
	
	private OrderCustomerRepository orderCustomerRepository = (OrderCustomerRepository) ApplicationContextUtil.getBean("orderCustomerRepository");
	private OrderFlowRepository orderFlowRepository = (OrderFlowRepository) ApplicationContextUtil.getBean("orderFlowRepository");
	private OrderElectricianRepository orderElectricianRepository = (OrderElectricianRepository) ApplicationContextUtil.getBean("orderElectricianRepository");
	
	

	@Override
    @Async
    @Scheduled(fixedDelay = 60000*60) //每小时执行一次
	public void run() {
		try {
			Thread.sleep(1000*60*5);//延迟5分钟执行
		
			ArrayList<String> orderIds = new ArrayList<String>();
			
			List<OrderCustomer> orderCustomers = orderCustomerRepository.findFinishOrder("15");
			logger.info("MoveTask orderCustomers = "+orderCustomers);
			
			if(orderCustomers.size()>0){
				for(OrderCustomer orderCustomer:orderCustomers){
					orderIds.add(orderCustomer.getOrderId());
				}
				
				//搬迁流水表
				orderFlowRepository.insertToHis(orderIds);
				orderFlowRepository.deleteNowTable(orderIds);
				
				//搬迁电工订单表
				orderElectricianRepository.insertToHis(orderIds);
				orderElectricianRepository.deleteNowTable(orderIds);
				
				//搬迁客户订单表
				orderCustomerRepository.insertToHis(orderIds);
				orderCustomerRepository.deleteNowTable(orderIds);
				
				//订单经纬度表删除
				
			}
		
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		
	}
	
}