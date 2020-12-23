package com.sgcc.uap.share.task;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;
import com.sgcc.uap.share.domain.OrderCustomer;


/*
 * 自动派单
 * 20分钟没有被抢到的订单，会自动派给电工
 * */
public class AutoSendOrderTask  extends TimerTask{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(AutoSendOrderTask.class);
	
	private OrderCustomerRepository orderCustomerRepository = 
			(OrderCustomerRepository) ApplicationContextUtil.getBean("orderCustomerRepository");
	

	@Override
	public void run() {
		try {
			Thread.sleep(1000*60*40);
		
			ArrayList<String> orderIds = new ArrayList<String>();
			
			List<OrderCustomer> orderCustomers = orderCustomerRepository.findNotAcceptOrder("20");
			logger.info("MoveTask orderCustomers = "+orderCustomers);
			
			if(orderCustomers.size()>0){
				for(OrderCustomer orderCustomer:orderCustomers){
					orderIds.add(orderCustomer.getOrderId());
				}
				
				
				//搬迁客户订单表
				orderCustomerRepository.insertToHis(orderIds);
				orderCustomerRepository.deleteNowTable(orderIds);
			}
		
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}

}
