package com.sgcc.uap.share.login.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.share.customer.bo.IndexPageBo;
import com.sgcc.uap.share.customer.services.ICustomerInfoService;
import com.sgcc.uap.share.customer.services.IGetElectricianInfoService;
import com.sgcc.uap.share.domain.CustomerInfo;
import com.sgcc.uap.share.domain.ElectricianInfo;
import com.sgcc.uap.util.UuidUtil;

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
@RequestMapping("/index")
public class IndexController {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(IndexController.class);
	/**
	 * 是否为开发模式
	 */
	@Value("${uapmicServer.dev}")
	private boolean isDev;
	
	@Autowired
    private ICustomerInfoService customerInfoService;
	
	@Autowired
    private IGetElectricianInfoService iGetElectricianInfoService;
	
	
	@RequestMapping(value = "/findIndexPage", method = RequestMethod.POST)
	public WrappedResult authCodeVerify() {
		try {
			IndexPageBo indexPageBo = new IndexPageBo();
			
			//调用国网接口 获取登录用户的信息
			String openId = "123456";
			indexPageBo.setOpenId(openId);
			
			//查询是否为电工
			ElectricianInfo electricianInfo = iGetElectricianInfoService.getElectricianInfoByOpenId(openId);
			
			if(null==electricianInfo){
				//查询是否为用户
				CustomerInfo customerInfo = customerInfoService.getCustomerInfoByOpenId(openId);
				indexPageBo.setToPage("0");
				if(null==customerInfo){
					//注册一个客户
					String getNewId = UuidUtil.getIntUuid32();
					Map<String, Object> customerInfoMap = new HashMap<String, Object>();
					customerInfoMap.put("customerId", getNewId);
					customerInfoMap.put("realNameAuth", "0");
					customerInfoService.saveCustomerInfo(customerInfoMap);
				}else{
					indexPageBo.setUserId(customerInfo.getCustomerId());
				}
			}else{
				indexPageBo.setUserId(electricianInfo.getElectricianId());
				indexPageBo.setToPage("1");
			}
			return WrappedResult.successWrapedResult(indexPageBo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "登录异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	
}
