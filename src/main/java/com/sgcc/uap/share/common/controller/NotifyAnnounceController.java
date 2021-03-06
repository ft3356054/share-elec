package com.sgcc.uap.share.common.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RestController;

import com.sgcc.uap.WebSocketServer;
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
import com.sgcc.uap.share.services.INotifyAnnounceService;
import com.sgcc.uap.share.vo.NotifyAnnounceVO;
import com.sgcc.uap.util.MapUtil;
import com.sgcc.uap.utils.json.JsonUtils;


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
@RequestMapping("/notifyAnnounce")
public class NotifyAnnounceController {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(NotifyAnnounceController.class);
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
     * NotifyAnnounce服务
     */
	@Autowired
	private INotifyAnnounceService notifyAnnounceService;
	
	/**
	 * @getByAnnounceId:根据announceId查询
	 * @param announceId
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping(value = "/{announceId}")
	public WrappedResult getByAnnounceId(@PathVariable String announceId) {
		try {
			QueryResultObject result = notifyAnnounceService.getNotifyAnnounceByAnnounceId(announceId,"");
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
	 * @getByAnnounceId:根据announceId查询，并更新user notify
	 * @param announceId
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping(value = "/read/")
	public WrappedResult getByAnnounceId(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			Map<String, String> map = MapUtil.getParam(requestCondition);
			String announceId = map.get("announceId");
			String announceUserId = map.get("announceUserId");
			
			QueryResultObject result = notifyAnnounceService.getNotifyAnnounceByAnnounceId(announceId,announceUserId);
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
			notifyAnnounceService.remove(idObject);
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
	 * @return WrappedResult 保存的结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public WrappedResult save(@RequestBody FormRequestObject<Map<String,Object>> params) {
		try {
			if(params == null){
				throw new NullArgumentException("params");
			}
			QueryResultObject result = new QueryResultObject();
			List<Map<String,Object>> items = params.getItems();
			if(items != null && !items.isEmpty()){
				for(Map<String,Object> map : items){
					result.setFormItems(notifyAnnounceService.saveNotifyAnnounce(map));
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
	 * @getByAnnounceId:根据announceId查询
	 * @param announceId
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping(value = "/hasten/{orderId}")
	public WrappedResult hastenByCustomer(@PathVariable String orderId) {
		try {
			QueryResultObject result = notifyAnnounceService.hastenByCustomer(orderId);
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
	 * @query:查询
	 * @param requestCondition
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping("/")
	public WrappedResult query(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			QueryResultObject queryResult = notifyAnnounceService.query(requestCondition);
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
			datas = ViewAttributeUtils.getViewAttributes(columns, NotifyAnnounceVO.class);
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
	
	@RequestMapping(value = "/testWebsocket1")
	public WrappedResult testWebsocket1() {
		try {
			WebSocketServer.sendInfo("群发客户端",null);
			logger.info("查询成功"); 
			return WrappedResult.successWrapedResult("");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	@RequestMapping(value = "/testWebsocket2")
	public WrappedResult testWebsocket2() {
		try {
			WebSocketServer.sendInfo("单发客户端","123");
			logger.info("查询成功"); 
			return WrappedResult.successWrapedResult("");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	//http://localhost:8083/notifyAnnounce/testWebsocket/?params={"filter":["orderId=2020113016481399b534d5707d4b11bdbb0c979e800a6c","content=您有一笔待支付订单","userId=089b56b5535042d5ab63898b7a97f1d7"]}
    @RequestMapping(value = "/testWebsocket")
	public WrappedResult testWebsocket(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			Map<String, String> map = MapUtil.getParam(requestCondition);
			String orderId = map.get("orderId");
			String content = map.get("content");
			String userId = map.get("userId");

			Map<String,String> mapString = new HashMap<String,String>();
			mapString.put("orderId", orderId);
			mapString.put("content", content);
			String jsonString1 = JsonUtils.toJson(mapString);
			String jsonString2 = com.sgcc.uap.util.JsonUtils.mapToJson(mapString);
			
			//单发
			WebSocketServer.sendInfo(jsonString1,userId);
			//群发
			WebSocketServer.sendInfo(jsonString2,null);
			
			return WrappedResult.successWrapedResult("发送成功");
		} catch (Exception e) {
			String errorMessage = "查询异常";
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
}
