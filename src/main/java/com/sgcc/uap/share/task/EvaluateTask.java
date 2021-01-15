package com.sgcc.uap.share.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sgcc.uap.share.customer.bo.EvaluateTaskBo;
import com.sgcc.uap.share.customer.repositories.EvaluateTaskRepository;
import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;
import com.sgcc.uap.share.domain.BaseSystemConfig;
import com.sgcc.uap.share.services.IBaseSystemConfigService;
import com.sgcc.uap.util.TimeStamp;


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
	
	OrderCustomerRepository orderCustomerRepository = (OrderCustomerRepository) ApplicationContextUtil.getBean("orderCustomerRepository");
	IBaseSystemConfigService baseSystemConfigService = (IBaseSystemConfigService) ApplicationContextUtil.getBean("baseSystemConfigService");
	EvaluateTaskRepository evaluateTaskRepository = (EvaluateTaskRepository) ApplicationContextUtil.getBean("evaluateTaskRepository");
	
	
    @Async
	public void run() {
		logger.info("EvaluateTask start ! ");
		BaseSystemConfig baseSystemConfig = baseSystemConfigService.getBaseSystemConfigByConfigType("3");
		Integer days = Integer.parseInt(baseSystemConfig.getConfigValue());
		Integer updateCount = 0;
		String dateString = TimeStamp.toString(new Date());
		//修改用户待评价   5星 状态8 15天
		//updateCount = orderCustomerRepository.getNotEvaluate(5, "默认好评",  "默认好评", 8, days,dateString);
		logger.info("EvaluateTask updateCount = "+updateCount);
		
		//修改用户待验收
		List<String> orderIds = new ArrayList<String>();
		List<String> beComplantOrderIds = new ArrayList<String>();
		
		//查询满足条件的orderid 和 投诉状态 
		List<EvaluateTaskBo> list = evaluateTaskRepository.getNotPay(23, days);
		if(null!=list&&!"".equals(list)){
			for(EvaluateTaskBo evaluateTaskBo : list){
				String complaintStatus = evaluateTaskBo.getComplaintStatus();
				if("0".equals(complaintStatus)){
					beComplantOrderIds.add(evaluateTaskBo.getOrderId());
				}else{
					orderIds.add(evaluateTaskBo.getOrderId());
				}
			}
			//集合去重
			orderIds.removeAll(beComplantOrderIds);
		}
		logger.info("UnpaidTask orderIds = "+orderIds);
	}
    
    private static void Deduplication(ArrayList<String> list1,ArrayList<String> list2){
        ArrayList tempList = new ArrayList();
        //将list1里的所有元素添加到tempList里
        tempList.addAll(list1);
        //从list1中移除掉同时在list2中存在的元素（去重）
        list1.removeAll(list2);
        //从list2中移除掉同时在list1中存在的元素（去重）
        list2.removeAll(tempList);
        
        System.out.println(list1);
        System.out.println(list2);
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
