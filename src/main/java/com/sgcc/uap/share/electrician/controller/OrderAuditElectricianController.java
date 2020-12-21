package com.sgcc.uap.share.electrician.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sgcc.uap.exception.NullArgumentException;
import com.sgcc.uap.rest.annotation.ColumnRequestParam;
import com.sgcc.uap.rest.annotation.QueryRequestParam;
import com.sgcc.uap.rest.annotation.attribute.ViewAttributeData;
import com.sgcc.uap.rest.support.FormRequestObject;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.ViewMetaData;
import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.rest.utils.ViewAttributeUtils;
import com.sgcc.uap.service.validator.ServiceValidatorBaseException;
import com.sgcc.uap.share.domain.ElectricianInfo;
import com.sgcc.uap.share.domain.ElectricianStatus;
import com.sgcc.uap.share.domain.OrderAuditElectrician;
import com.sgcc.uap.share.electrician.services.IOrderAuditElectricianService;
import com.sgcc.uap.share.electrician.services.impl.ElectricianInfoService;
import com.sgcc.uap.share.electrician.services.impl.ElectricianStatusService;
import com.sgcc.uap.share.electrician.vo.OrderAuditElectricianVO;
import com.sgcc.uap.util.DateTimeUtil;
import com.sgcc.uap.util.JsonUtils;
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
@RequestMapping("/orderAuditElectrician")
public class OrderAuditElectricianController {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(OrderAuditElectricianController.class);
	/**
	 * 方法绑定属性中不允许的参数
	 */
	private final static String[] DISALLOWED_PARAMS = new String[]{"idObject.primarykey"};
	/**
	 * 是否为开发模式
	 */
	@Value("${uapmicServer.dev}")
	private boolean isDev;
	/** 
     * OrderAuditElectrician服务
     */
	@Autowired
	private IOrderAuditElectricianService orderAuditElectricianService;
	
	@Autowired
	private ElectricianInfoService electricianInfoService ;
	
	@Autowired
	private ElectricianStatusService electricianStatusService;
	
	
	/**
	 * @getByOrderId:根据orderId查询
	 * @param orderId
	 * @return WrappedResult 查询结果
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	@RequestMapping(value = "/{orderId}")
	public WrappedResult getByOrderId(@PathVariable String orderId) {
		try {
			QueryResultObject result = orderAuditElectricianService.getOrderAuditElectricianByOrderId(orderId);
			logger.info("查询成功"); 
			return WrappedResult.successWrapedResult(result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	/**
	 * @deleteByIds:删除
	 * @param idObject  封装ids主键值数组和idName主键名称
	 * @return WrappedResult 删除结果
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WrappedResult deleteByIds(@RequestBody IDRequestObject idObject) {
		try {
			orderAuditElectricianService.remove(idObject);
			logger.info("删除成功");  
			return WrappedResult.successWrapedResult(true);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "删除异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	/**
	 * @saveOrUpdate:保存或更新
	 * @param params
	 * @return WrappedResult 保存或更新的结果
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public WrappedResult saveOrUpdate(@RequestBody FormRequestObject<Map<String,Object>> params) {
		try {
			if(params == null){
				throw new NullArgumentException("params");
			}
			QueryResultObject result = new QueryResultObject();
			List<Map<String,Object>> items = params.getItems();
			if(items != null && !items.isEmpty()){
				for(Map<String,Object> map : items){
					result.setFormItems(orderAuditElectricianService.saveOrderAuditElectrician(map));
				}
			}
			logger.info("保存数据成功"); 
			return WrappedResult.successWrapedResult(result);
		} catch (ServiceValidatorBaseException e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "校验异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedValidateWrappedResult(errorMessage);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "保存异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	/**
	 * @query:查询
	 * @param requestCondition
	 * @return WrappedResult 查询结果
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	@RequestMapping("/")
	public WrappedResult query(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			QueryResultObject queryResult = orderAuditElectricianService.query(requestCondition);
			logger.info("查询数据成功"); 
			return WrappedResult.successWrapedResult(queryResult);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	/**
	 * @getMetaData:从vo中获取页面展示元数据信息
	 * @param columns  将请求参数{columns:["id","name"]}封装为字符串数组
	 * @return WrappedResult 元数据
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	@RequestMapping("/meta")
	public 	WrappedResult getMetaData(
			@ColumnRequestParam("params") String[] columns) {
		try{
			if(columns == null){
				throw new NullArgumentException("columns");
			}
			List<ViewAttributeData> datas = null;
			datas = ViewAttributeUtils.getViewAttributes(columns, OrderAuditElectricianVO.class);
			WrappedResult wrappedResult = WrappedResult
					.successWrapedResult(new ViewMetaData(datas));
			return wrappedResult;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			String errorMessage = "异常处理";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}

	/**
	 * @initBinder:初始化binder
	 * @param binder  绑定器引用，用于控制各个方法绑定的属性
	 * @return void
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setDisallowedFields(DISALLOWED_PARAMS);
	}
	
	
	/**
	 * 电工认证
	 */
	@RequestMapping(value="/certification",name="电工进行认证")
	public WrappedResult certification(@RequestParam(value = "items", required = false) String items,
			@RequestParam("myFile") MultipartFile file1,@RequestParam("myFile") MultipartFile file2){
		
		OrderAuditElectrician orderAuditElectrician2=new OrderAuditElectrician();
		try {
			
		
			
			QueryResultObject result = new QueryResultObject();
			
			
			if(items != null && !items.isEmpty()){
				Map<String,Object> map = JsonUtils.parseJSONstr2Map(items);
				System.out.println(map.toString());
				
				String electricianId=(String) map.get("electricianId");
				//根据电工ID查询出电工信息，然后创建电工审核订单
				ElectricianInfo electricianInfo=electricianInfoService.findInfo(electricianId);
				
				//根据电工ID查询电工状态表
				ElectricianStatus electricianStatus=electricianStatusService.findOne(electricianId);
				
				//创建一个新的电工审核订单
				OrderAuditElectrician orderAuditElectrician=new OrderAuditElectrician();
				
				
				
				/*
				return "OrderAuditElectrician ["
				+ ", orderId=" + orderId
				+ ", orderType=" + orderType
				+ ", createTime=" + createTime
				+ ", updateTime=" + updateTime
				+ ", finishTime=" + finishTime
				+ ", auditorId=" + auditorId
				+ ", auditorComment=" + auditorComment
				+ ", subCompanyId=" + subCompanyId
				+ ", companyId=" + companyId
				+ ", companyName=" + companyName
				+ ", companyPhonenumber=" + companyPhonenumber
				+ ", companyAddress=" + companyAddress
				+ ", addressLongitude=" + addressLongitude
				+ ", addressLatitude=" + addressLatitude
				+ ", companyLevel=" + companyLevel
				+ ", ratingCertificate=" + ratingCertificate
				+ ", companyContract=" + companyContract
				*/
				map.put("orderId", UuidUtil.getIntUuid32());
				map.put("orderType", 0);
				map.put("createTime",DateTimeUtil.formatDateTime(new Date()) );
				map.put("electricianId", electricianInfo.getElectricianId());
				map.put("electricianName", electricianInfo.getElectricianName());
				map.put("electricianPhonenumber", electricianInfo.getElectricianPhonenumber());
				map.put("electriciaStatus", electricianStatus.getElectricianStatus());
				//暂时先进行评比，因为没有字段
				
				map.put("subCompanyId",electricianInfo.getSubCompanyId());
				map.put("companyName",electricianInfo.getCompanyName() );
				
				
				 orderAuditElectrician2=orderAuditElectricianService.save(map,file1,file2);
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
				
		
		return WrappedResult.successWrapedResult(orderAuditElectrician2);
		
			
		//return null;
	}
	

}
