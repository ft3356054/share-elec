package com.sgcc.uap.share.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.share.customer.services.impl.OrderCustomerService;
import com.sgcc.uap.share.domain.OrderCustomer;

/**
 * 测试接口使用 
 */

@RestController
@Transactional
@RequestMapping("/llbTest")
public class RedisTestController {

    @Autowired
    OrderCustomerService orderCustomerService;
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    //http://localhost:8083/llbTest/push/20201222091414840565
    @RequestMapping(value = "/push/{orderId}")
	public WrappedResult rightPushCustomerOrder(@PathVariable String orderId) {
		try {
			QueryResultObject result = orderCustomerService.getOrderCustomerByOrderId(orderId);
			OrderCustomer orderCustomer = (OrderCustomer) result.getItems().get(0);
			redisTemplate.opsForList().rightPush("newCustomerOrder", orderCustomer);
			
			return WrappedResult.successWrapedResult(result);
		} catch (Exception e) {
			String errorMessage = "查询异常";
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
    
    @RequestMapping(value = "/pop")
	public WrappedResult leftPopCustomerOrder() {
		try {
			OrderCustomer orderCustomer = null;
			orderCustomer = (OrderCustomer) redisTemplate.opsForList().leftPop("newCustomerOrder");
			
			return WrappedResult.successWrapedResult(orderCustomer);
		} catch (Exception e) {
			String errorMessage = "查询异常";
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
   
}
