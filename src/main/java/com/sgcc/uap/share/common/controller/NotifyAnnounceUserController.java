package com.sgcc.uap.share.common.controller;

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
import com.sgcc.uap.share.services.INotifyAnnounceUserService;
import com.sgcc.uap.share.vo.NotifyAnnounceUserVO;


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
@RequestMapping("/notifyAnnounceUser")
public class NotifyAnnounceUserController {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(NotifyAnnounceUserController.class);
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
     * NotifyAnnounceUser服务
     */
	@Autowired
	private INotifyAnnounceUserService notifyAnnounceUserService;
	@Autowired
	private INotifyAnnounceService notifyAnnounceService;
	
	
	/**
	 * @getById:根据id查询
	 * @param id
	 * @return WrappedResult 查询结果
	 * @date 2020-11-30 16:13:38
	 * @author 18511
	 */
	@RequestMapping(value = "/{id}")
	public WrappedResult getById(@PathVariable String id) {
		try {
			QueryResultObject result = notifyAnnounceUserService.getNotifyAnnounceUserById(id);
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
	 * @getById:根据userId查询 （没有分页不用了）
	 * @param id
	 * @return WrappedResult 查询结果
	 * @date 2020-11-30 16:13:38
	 * @author 18511
	 */
	@RequestMapping(value = "/userId/{id}")
	public WrappedResult getByUserId(@PathVariable String id) {
		try {
			/*List<NotifyAnnounceUser> notifyAnnounceUserList = notifyAnnounceUserService.getNotifyAnnounceUserByUserId(id);
			List<String> list = new ArrayList<String>(); 
			
			if(notifyAnnounceUserList.size()>0){
				for(NotifyAnnounceUser notifyAnnounceUser :notifyAnnounceUserList){
					list.add(notifyAnnounceUser.getAnnounceId());
				}
			}*/
			QueryResultObject result = notifyAnnounceService.getNotifyAnnounceByAnnounceIds(id);
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
	 * @getByOrderId:根据userId查询全部
	 * @param orderId
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping("/queryAll")
	public WrappedResult getAllByCustomerId(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			QueryResultObject queryResult = notifyAnnounceService.getAllNotifyAnnounceByAnnounceIds(requestCondition);
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
	
	@RequestMapping(value = "/notReadNum/{id}")
	public WrappedResult getNotReadNum(@PathVariable String id) {
		try {
			Long num = 0L ;
			num = notifyAnnounceService.getNotReadNum(id);
			logger.info("查询成功"); 
			return WrappedResult.successWrapedResult(num);
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
	 * @date 2020-11-30 16:13:38
	 * @author 18511
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WrappedResult deleteByIds(@RequestBody IDRequestObject idObject) {
		try {
			notifyAnnounceUserService.remove(idObject);
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
	 * @date 2020-11-30 16:13:38
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
					result.setFormItems(notifyAnnounceUserService.saveNotifyAnnounceUser(map));
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
	 * @date 2020-11-30 16:13:38
	 * @author 18511
	 */
	@RequestMapping("/")
	public WrappedResult query(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			QueryResultObject queryResult = notifyAnnounceUserService.query(requestCondition);
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
	 * @date 2020-11-30 16:13:38
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
			datas = ViewAttributeUtils.getViewAttributes(columns, NotifyAnnounceUserVO.class);
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
	 * @date 2020-11-30 16:13:38
	 * @author 18511
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setDisallowedFields(DISALLOWED_PARAMS);
	}

}
