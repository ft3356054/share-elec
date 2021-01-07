package com.sgcc.uap.share.customer.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.share.customer.services.ICustomerInfoService;
import com.sgcc.uap.share.customer.services.IGetElectricianInfoService;
import com.sgcc.uap.share.electrician.services.IElecPositionService;

/**
 * <b>概述</b>：<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
@RestController
@Transactional
@RequestMapping("/userLogin")
public class LoginController {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(LoginController.class);
	/**
	 * 是否为开发模式
	 */
	@Value("${uapmicServer.dev}")
	private boolean isDev;
	
	@Autowired
	private ICustomerInfoService customerInfoService;
	@Autowired
	private IGetElectricianInfoService getElectricianInfoService;
	@Autowired
	private IElecPositionService elecPositionService;
	
	
	/**
	 * 登录方法的编写——用户登录后，通过判断是否为电工，如果为电工则跳转电工首页，并获取位置信息储存，如果没有获取到，则提示打开定位；
	 * 如果不为电工，则查询用户信息，如果没有则录入信息，然后跳转用户首页。
	 * 用户下单后储存位置信息，电工登录后储存位置信息
	 */
	@RequestMapping(value = "/{userId}")
	public WrappedResult getLoginUserId(@PathVariable String userId) {
		try {
			
			boolean isElec = getElectricianInfoService.getElectricianInfoNumberByElectricianId(userId);
			
			if(isElec){
				//录入电工位置信息
				//{"items":[{"electricianId":"123","areaId":"1","lon":"12.546","lat":"52.698","status":"1"}]}
				HashMap<String, Object> map = new HashMap<String,Object>();
				map.put("electricianId", "electricianId");
				map.put("areaId", "areaId");
				map.put("lon", "lon");
				map.put("lat", "lat");
				elecPositionService.saveElecPosition(map);
				
				//跳转到电工首页
				
			}else{
				boolean isCust = customerInfoService.getNumberByCustomerId(userId);
				if(isCust){
					//跳转到客户首页
					
				}else{
					//调用国网接口，获取用户信息
					
					
					//用户信息录入
					
					
					//跳转到客户首页
					
				}
			}
			logger.info("登录跳转成功"); 
			return WrappedResult.successWrapedResult("登录跳转成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
}
