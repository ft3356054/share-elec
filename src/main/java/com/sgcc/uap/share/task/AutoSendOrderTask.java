package com.sgcc.uap.share.task;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.services.ICustomerInfoService;


/*
 * 自动派单
 * 20分钟没有被抢到的订单，会自动派给电工
 * */
@Component
public class AutoSendOrderTask  extends TimerTask{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(AutoSendOrderTask.class);
	
	
	/*private OrderCustomerRepository orderCustomerRepository = 
			(OrderCustomerRepository) ApplicationContextUtil.getBean("orderCustomerRepository");*/
	ICustomerInfoService customerInfoService = null;

	

	@Override
    @Async
    @Scheduled(fixedDelay = 60000*5) //每5分钟执行一次
	public void run() {
		try {
			//Thread.sleep(1000*60*40);
			customerInfoService = (ICustomerInfoService) ApplicationContextUtil.getBean("customerInfoService");
		
			/*ArrayList<String> orderIds = new ArrayList<String>();
			
			List<OrderCustomer> orderCustomers = orderCustomerRepository.findNotAcceptOrder("20");
			logger.info("MoveTask orderCustomers = "+orderCustomers);
			*/
			customerInfoService.getCustomerInfoByCustomerId("asdfasdfsfsa");
			/*
			if(orderCustomers.size()>0){
				for(OrderCustomer orderCustomer:orderCustomers){
					//orderIds.add(orderCustomer.getOrderId());
					
					//通过orderid 查询获取经纬度信息
					//custPositionService.getCustPositionByOrderId(orderCustomer.getOrderId());
					
					
					
				}
				
			}*/
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
