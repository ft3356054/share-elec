package com.sgcc.uap.share.task;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;
import com.sgcc.uap.share.customer.repositories.OrderFlowRepository;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.electrician.repositories.OrderElectricianRepository;


/*
 * 现表搬迁历史表
 * */
@Component
public class MoveOrderTask{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(MoveOrderTask.class);
	
	private OrderCustomerRepository orderCustomerRepository = (OrderCustomerRepository) ApplicationContextUtil.getBean("orderCustomerRepository");
	private OrderFlowRepository orderFlowRepository = (OrderFlowRepository) ApplicationContextUtil.getBean("orderFlowRepository");
	private OrderElectricianRepository orderElectricianRepository = (OrderElectricianRepository) ApplicationContextUtil.getBean("orderElectricianRepository");
	
	

    @Async
	public void run() {
			logger.info("MoveOrderTask start ! ");
		
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
		
		
	}
	
}
