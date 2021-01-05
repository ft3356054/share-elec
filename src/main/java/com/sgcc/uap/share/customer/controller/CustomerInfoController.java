package com.sgcc.uap.share.customer.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
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
import com.sgcc.uap.rest.utils.RestUtils;
import com.sgcc.uap.rest.utils.ViewAttributeUtils;
import com.sgcc.uap.service.validator.ServiceValidatorBaseException;
import com.sgcc.uap.share.customer.services.ICustomerInfoService;
import com.sgcc.uap.share.customer.vo.CustomerInfoVO;

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
@RequestMapping("/customerInfo")
public class CustomerInfoController {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(CustomerInfoController.class);
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
     * CustomerInfo服务
     */
	@Autowired
	private ICustomerInfoService customerInfoService;
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
	
	/**
	 * @getByCustomerId:根据customerId查询
	 * @param customerId
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping(value = "/{customerId}")
	public WrappedResult getByCustomerId(@PathVariable String customerId) {
		try {
			QueryResultObject result = customerInfoService.getCustomerInfoByCustomerId(customerId);
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
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WrappedResult deleteByIds(@RequestBody IDRequestObject idObject) {
		try {
			customerInfoService.remove(idObject);
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
	 * @date 2020-11-26 14:32:47
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
			logger.info("saveOrUpdate items="+items); 
			if(items != null && !items.isEmpty()){
				for(Map<String,Object> map : items){
					result.setFormItems(customerInfoService.saveCustomerInfo(map));
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
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping("/")
	public WrappedResult query(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			QueryResultObject queryResult = customerInfoService.query(requestCondition);
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
	 * @date 2020-11-26 14:32:47
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
			datas = ViewAttributeUtils.getViewAttributes(columns, CustomerInfoVO.class);
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
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setDisallowedFields(DISALLOWED_PARAMS);
	}

	
	/**
	 * @saveOrUpdate:保存位置
	 * @param params
	 * @return WrappedResult 保存或更新的结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 * http://localhost:8083/customerInfo/locationPut/?params={"filter":["userId=customerId001","area=123212","lon=13.144","lat=251.21465"]}	
	 */
	/*@RequestMapping(value = "/locationPut")
	public WrappedResult locationPut(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			Map<String, String> map = MapUtil.getParam(requestCondition);
			String jsonMap = JsonUtils.mapToJson(map);
			stringRedisTemplate.opsForValue().set(map.get("customerId"), jsonMap, 1L, TimeUnit.HOURS);
			List result = new ArrayList();
			long count = 1;
			logger.info("存储位置信息保存成功"); 
			return WrappedResult.successWrapedResult(RestUtils.wrappQueryResult(result, count));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "存储位置信息异常";
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}*/
	
	/**
	 * @saveOrUpdate:获取位置测试
	 * @param params
	 * @return WrappedResult 保存或更新的结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 * http://localhost:8083/customerInfo/locationGet/customerId001
	 */
	/*@RequestMapping(value = "/locationGet/{customerId}")
	public WrappedResult locationGetTest(@PathVariable String customerId) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String json = stringRedisTemplate.opsForValue().get(customerId);
			map = JsonUtils.parseJSONstr2Map(json);
			logger.info("区:"+map.get("area"));
			logger.info("经度:"+map.get("lon")); 
			logger.info("纬度:"+map.get("lat")); 
			
			
			List result = new ArrayList();
			long count = 1;
			return WrappedResult.successWrapedResult(RestUtils.wrappQueryResult(result, count));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "存储位置信息异常";
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}*/
	
	@RequestMapping(value = "/testjson", method = RequestMethod.POST)
	public WrappedResult testjson(
		@RequestParam(value = "items", required = false) String items
		) throws IOException {
		logger.info("黄老板:"+items);
		return WrappedResult.successWrapedResult(RestUtils.wrappQueryResult("黄老板:"+items));
	}
	
	@RequestMapping(value = "/testfile", method = RequestMethod.POST)
	public WrappedResult testfile(
		@RequestParam("myFile") MultipartFile file
		) throws IOException {
		String fileName = file.getName();
		logger.info("黄老板:"+fileName);
		return WrappedResult.successWrapedResult(RestUtils.wrappQueryResult("黄老板:"+fileName));
	}
	
	@RequestMapping(value = "/testfile1", method = RequestMethod.POST)
	public WrappedResult testfile1(
		@RequestParam("myFile") File file
		) throws IOException {
		String fileName = file.getName();
		logger.info("黄老板:"+fileName);
		return WrappedResult.successWrapedResult(RestUtils.wrappQueryResult("黄老板:"+fileName));
	}
}
