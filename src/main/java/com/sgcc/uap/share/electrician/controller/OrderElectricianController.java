package com.sgcc.uap.share.electrician.controller;

import java.sql.Timestamp;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.sgcc.uap.share.customer.services.impl.OrderCustomerService;
import com.sgcc.uap.share.customer.services.impl.OrderFlowService;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.domain.OrderFlow;
import com.sgcc.uap.share.electrician.services.IOrderElectricianService;
import com.sgcc.uap.share.electrician.vo.OrderElectricianVO;
import com.sgcc.uap.share.services.impl.NotifyAnnounceService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceUserService;
import com.sgcc.uap.util.MapUtil;
import com.sgcc.uap.util.TimeStamp;
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
@RequestMapping("/orderElectrician")
public class OrderElectricianController {
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(OrderElectricianController.class);
	/**
	 * 方法绑定属性中不允许的参数.
	 */
	private final static String[] DISALLOWED_PARAMS = new String[]{"idObject.primarykey"};
	
	
	
	
	/**
	 * 是否为开发模式
	 */
	@Value("${uapmicServer.dev}")
	private boolean isDev;
	/** 
     * OrderElectrician服务
     */
	@Autowired
	private IOrderElectricianService orderElectricianService;
	
	
	/**
	 * TODO
	 * guoqing 
	 */
	@Autowired
	private OrderCustomerService orderCustomerService;
	
	@Autowired
	private OrderFlowService orderFlowService;
	
	@Autowired
	private NotifyAnnounceService notifyAnnounceService;
	
	@Autowired
	private NotifyAnnounceUserService notifyAnnounceUserService;
	
	/**
	 * @getByOrderElectricianId:根据orderElectricianId查询
	 * @param orderElectricianId
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping(value = "/{orderElectricianId}")
	public WrappedResult getByOrderElectricianId(@PathVariable String orderElectricianId) {
		try {
			QueryResultObject result = orderElectricianService.getOrderElectricianByOrderElectricianId(orderElectricianId);
			logger.info("查询成功"); 
			logger.info("我使用的是自动生成的代码");
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
			orderElectricianService.remove(idObject);
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
			if(items != null && !items.isEmpty()){
				for(Map<String,Object> map : items){
					result.setFormItems(orderElectricianService.saveOrderElectrician(map));
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
	
	/*public WrappedResult saveOrUpdate(@RequestBody FormRequestObject<Map<String,Object>> params) {*/
	
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
			QueryResultObject queryResult = orderElectricianService.query(requestCondition);
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
			datas = ViewAttributeUtils.getViewAttributes(columns, OrderElectricianVO.class);
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
	 * 以下是测试代码
	 */
	@RequestMapping(value="/electrician_evaluate",name="查询待评价的订单")
	@ResponseBody
	public List<OrderElectrician> findByElectricianEvaluateIsNullAndOrderElectricianTypeEquals(){
		List<OrderElectrician> list=orderElectricianService.findByElectricianEvaluateIsNullAndOrderElectricianTypeEquals("8");
		return list;
	}
	

	
	
	
	/**
	 * 一打开首页抢单按钮，需要将所有的未抢的订单全部查询只需要考虑没有人接的就行
	 * 1.先查询客户订单表的状态是0,1,11三种状态的订单    findByOrderStatus
	 * 			SELECT * FROM order_customer WHERE ORDER_STATUS=1 OR ORDER_STATUS=11 OR ORDER_STATUS=0
	 * 
	 */
	
	@RequestMapping(value="/qiangdan",name="首页中点击抢单按钮的功能")
	@ResponseBody
	public List<OrderCustomer> qiangdan(){
		
		List<OrderCustomer> list=orderElectricianService.findByOrderStatusOrderByCreateTime(1,11);
		
		return list;
	}
	
	/**
	 * 抢单页面 点击抢单按钮，
	 * 		1.需要接收前段页面传送过来的订单表，
	 * 		2.判断客户订单表的订单状态是1，新的订单，则进行创建一张电工订单表，更新客户订单表的状态，订单流水表，支付订单表
	 * @throws Exception 
	 * 
	 */
	@RequestMapping(value="/qiangdanrecept",name="电工接受了用户的订单")
	
	public String qiangdanrecept(@RequestParam(value="orderId" )String orderId,
			@RequestParam(value="electricianId") String electricianId
			) throws Exception{
		OrderCustomer orderCustomer=new OrderCustomer();
		
		//1.查询出来客户表
		orderCustomer=orderCustomerService.findByOrderId(orderId);
		
		//插入一个条件，如果查询出来的客户表订单为2，表明是已经有人接了单子
		if(orderCustomer.getOrderStatus().equals("2")){
			return "0"; //0表示返回的是false,该订单已经有人接下，直接返回，不再向下执行
		}
		
		//2.判断客户表是否是新表
		if(orderCustomer.getOrderStatus().equals("11")){
			//2.1电工接单的单子是11，说明是老单子设置客户订单表单状态为2，
			orderCustomer.setOrderStatus("2");
		    orderCustomerService.saveOrderCustomertwice(orderCustomer);
			
		}else {//3. 状态是11,则是新单子
			//3.1获取电工的左右信息
			
	
			Map<String,Object> mapOrderElectrician=new HashMap<String, Object>();
			mapOrderElectrician.put("orderElectricianId",UuidUtil.getUuid46());
			mapOrderElectrician.put("electricianId",electricianId);
			mapOrderElectrician.put("electricianName",null);
			mapOrderElectrician.put("electricianPhonenumber",null);
			mapOrderElectrician.put("electricianAddress",null);
			mapOrderElectrician.put("otherElectricianId",null);
			mapOrderElectrician.put("orderTypeId",null);
			mapOrderElectrician.put("electricianPrice",null);
			mapOrderElectrician.put("orderElectricianType",null);
			mapOrderElectrician.put("payStatus",orderCustomer.getPayStatus());
			mapOrderElectrician.put("createTime",(Timestamp) new Date());
			mapOrderElectrician.put("beginTime",null);
			mapOrderElectrician.put("updateTime",null);
			mapOrderElectrician.put("finishTime",null);
			mapOrderElectrician.put("electricianDescrive",null);
			mapOrderElectrician.put("electricianDescriveIcon",null);
			mapOrderElectrician.put("electricianGrade",null);
			mapOrderElectrician.put("electricianEvaluate",null);
			mapOrderElectrician.put("chargebackReason",null);
			mapOrderElectrician.put("orderContract",null);
			mapOrderElectrician.put("inspectionReport",null);
			mapOrderElectrician.put("remarkStr1",null);
			mapOrderElectrician.put("remarkStr2",null);
			mapOrderElectrician.put("remarkStr3",null);
			mapOrderElectrician.put("remarkNum1",null);
			mapOrderElectrician.put("remarkNum2",null);
			mapOrderElectrician.put("orDERId",orderCustomer.getOrderId());
			
			orderElectricianService.saveOrderElectrician(mapOrderElectrician);
			
			
			
			
		}
		
		//3.增加一张流水表
		
		Map<String,Object> mapOrderFlow = new HashMap<String,Object>();
		//mapOrderFlow.put("orDERId", getNewOrderId);
		mapOrderFlow.put("flowType", 0);
		mapOrderFlow.put("currStatus", 0);
		//mapOrderFlow.put("operatorId", orderCustomer.get("customerId"));
		mapOrderFlow.put("operatorId", orderCustomer.getCustomerId());
		mapOrderFlow.put("operatorTime", TimeStamp.toString(new Date()));
		mapOrderFlow.put("operatorType", 0);
		mapOrderFlow.put("remark", "新增orderCustomer订单");
		orderFlowService.saveOrderFlow(mapOrderFlow);
		
		//新增通知
		String announceId = UuidUtil.getUuid32();
		
		Map<String,Object> mapNotify = new HashMap<String,Object>();
		mapNotify.put("announceId",announceId);
		mapNotify.put("serderId", "SYSTEM_ADMIN");
		mapNotify.put("title", "待付勘察费");
		mapNotify.put("content", "待付勘察费，内容");
		mapNotify.put("createTime", TimeStamp.toString(new Date()));
		mapNotify.put("remark", "新增客户待付款通知");
		notifyAnnounceService.saveNotifyAnnounce(mapNotify);
		
		/*
		Map<String,Object> mapNotifyUser = new HashMap<String,Object>();
		mapNotifyUser.put("announceUserId", orderCustomer.getCustomerId());
		mapNotifyUser.put("announceId", announceId);
		mapNotifyUser.put("recipientType", 0);
		mapNotifyUser.put("state", 0);
		mapNotifyUser.put("createTime", TimeStamp.toString(new Date()));
		//mapNotifyUser.put("readTime", "");
		mapNotifyUser.put("remark", "新增客户待付款通知");
		notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);
		*/
		
		Map<String,Object> mapNotifyUser = 
				MapUtil.notifyUserAdd((String)orderCustomer.getCustomerId(), announceId, 0, 0, TimeStamp.toString(new Date()), "新增客户待付款通知");
		notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);
		System.out.println("我执行完成了");
		return "1";   //1表示接单成功，页面可以判断订单是否成功
		
	}
	
	
	/**
	 * 待办按钮点下后需要显示的东西
	 * 		查询条件：电工订单表的订单状态是未完结的那种,+电工ID
	 * 
	 */
	
	@RequestMapping(value="/waitToDo",name="待办事项")
	public List<OrderElectrician> waitToDo(@RequestParam(value="electricianId") String electricianId){
		//根据电工ID，查询出所有有关他未完结的电工订单
		List<OrderElectrician> list=orderElectricianService.findByElectricianIdAndOrderElectricianTypeEqualsOrderByCreateTime(electricianId,"9");
		
		return list;
	}
	
	/**
	 * 我的订单    ---->从首页点击过去后默认显示的是全部订单
	 * 		参数：电工ID
	 * 
	 */
	
	@RequestMapping(value="/queryAllOrder",name="查询当前电工所有的订单：未完成+历史订单")
	public List<OrderElectrician> queryAllOrder(@RequestParam(value="electricianId") String electricianId){
		//1.查询新的电工订单，
		
		List<OrderElectrician> listNew=orderElectricianService.findByElectricianIdAndOrderByCreateTimeAsc(electricianId);
		
		
		//2.查询电工订单的历史
		
		List<OrderElectrician> listOld=orderElectricianService.findByElectricianId(electricianId);
		for (OrderElectrician orderElectrician : listOld) {
			listNew.add(orderElectrician);
			
		}
		
		
		return listNew;
		
	}
	
	
}
