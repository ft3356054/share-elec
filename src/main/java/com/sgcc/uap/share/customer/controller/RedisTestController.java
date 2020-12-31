package com.sgcc.uap.share.customer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgcc.uap.rest.annotation.QueryRequestParam;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.share.customer.services.impl.OrderCustomerService;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.util.MapUtil;
import com.sgcc.uap.util.Md5Util;
import com.sgcc.uap.utils.security.AESUtil;
import com.sgcc.uap.utils.stream.StreamUtil;

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
    
    //AES加解密 http://localhost:8083/llbTest/aesAdd/?params={"filter":["content=089b56b5535042d5ab63898b7a97f1d7","keyseed=123asd"]}
    @RequestMapping(value = "/aesAdd")
	public WrappedResult aesAdd(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			Map<String, String> map = MapUtil.getParam(requestCondition);
			String content = map.get("content");
			String keyseed = map.get("keyseed");
			aesAddMethod(content, keyseed);
			return WrappedResult.successWrapedResult("123");
		} catch (Exception e) {
			String errorMessage = "查询异常";
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
    
    private void aesAddMethod(String content,String keyseed) throws Exception{
    	String jiami = AESUtil.encrypt(content, keyseed);
		System.out.println("AESUtil.encrypt jiami = "+ jiami);
		byte[] jiamiByte = StreamUtil.StringTObyte(jiami);
		System.out.println("AESUtil.encrypt jiamiByte = "+ jiamiByte);
		
		byte[] jiemiByte = AESUtil.decrypt(jiamiByte, keyseed);
		System.out.println("AESUtil.encrypt jiemiByte = "+ jiemiByte);
		String jiemi = StreamUtil.byteTOString(jiemiByte);
		System.out.println("AESUtil.encrypt jiemi = "+ jiemi);
    }
    
    //MD5 加解密
    @RequestMapping(value = "/md5Add")
	public WrappedResult md5Add(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			Map<String, String> map = MapUtil.getParam(requestCondition);
			String content = map.get("content");
			md5AddMethod(content);
			return WrappedResult.successWrapedResult("123");
		} catch (Exception e) {
			String errorMessage = "查询异常";
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
    
    private void md5AddMethod(String content) throws Exception{
    	com.sgcc.uap.utils.security.MD5 md5 = new com.sgcc.uap.utils.security.MD5();
		String jiami = md5.getMD5ofStr(content);
		System.out.println("md5.getMD5ofStr jiami = "+ jiami);
		String jiami2 = Md5Util.string2MD5(content);
		System.out.println("md5.getMD5ofStr jiami2 = "+ jiami2);
    }
    
    public static void main(String[] args) throws Exception {
    	String content = "{\"successful\":true,\"resultValue\":{\"itemCount\":0,\"items\":[{\"announceId\":\"089b56b5535042d5ab63898b7a97f1d7\",\"serderId\":\"ADMIN\",\"title\":\"待付勘察费\",\"content\":\"您已下单，请支付勘察费\",\"createTime\":1607998870000,\"notifyType\":\"2\",\"orderId\":\"2020121510205980fe3bd8444e4a0299ec131eefdf8d2e\",\"remark\":\"\",\"mxVirtualId\":null}],\"dicts\":[]},\"resultHint\":\"\",\"errorPage\":\"\",\"type\":\"\"}";
		String keyseed = "321";
		RedisTestController redisTestController = new RedisTestController();
		redisTestController.aesAddMethod(content, keyseed);
		redisTestController.md5AddMethod(content);
	}
   
}
