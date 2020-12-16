package com.sgcc.uap.share.electrician.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
import com.sgcc.uap.rest.utils.CrudUtils;
import com.sgcc.uap.rest.utils.RestUtils;
import com.sgcc.uap.rest.utils.ViewAttributeUtils;
import com.sgcc.uap.service.validator.ServiceValidatorBaseException;
import com.sgcc.uap.share.customer.services.impl.OrderCustomerService;
import com.sgcc.uap.share.customer.services.impl.OrderFlowService;
import com.sgcc.uap.share.customer.vo.OrderCustomerVO;
import com.sgcc.uap.share.domain.ElectricianInfo;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.domain.OrderFlow;
import com.sgcc.uap.share.electrician.services.IOrderElectricianService;
import com.sgcc.uap.share.electrician.services.impl.ElectricianInfoService;
import com.sgcc.uap.share.electrician.services.impl.OrderElectricianHisService;
import com.sgcc.uap.share.electrician.vo.OrderElectricianVO;
import com.sgcc.uap.share.services.impl.NotifyAnnounceService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceUserService;
import com.sgcc.uap.util.JsonUtils;
import com.sgcc.uap.util.MapUtil;
import com.sgcc.uap.util.PointUtil;
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
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private OrderElectricianHisService  orderElectricianHisService;
	
	@Autowired
	private ElectricianInfoService ElectricianInfoService;
	
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
	/*
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
	/*
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
		/*
		Map<String,Object> mapNotifyUser = 
				MapUtil.notifyUserAdd((String)orderCustomer.getCustomerId(), announceId, 0, 0, TimeStamp.toString(new Date()), "新增客户待付款通知");
		notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);
		System.out.println("我执行完成了");
		return "1";   //1表示接单成功，页面可以判断订单是否成功
		
	}
*/
	
	
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
	 * 开始用统一的数据结构做返回
	 * http://localhost:8083/electricianCompanyInfo/queryMore/?params={"pageIndex":1,"pageSize":20,
	 * "filter":[""electricianId=2256"","orderElectricianType=8","regiseterTimeBegin=2020-11-10 18:20:00","regiseterTimeEnd=2020-12-10 18:20:00"],
	 * "sorter":"DESC=createTime"}
	 */
	
	@RequestMapping("/queryMore")
	public WrappedResult queryMore(@QueryRequestParam("params") RequestCondition requestCondition,@RequestParam("electricianId")String electricianId) {
		Random r=new Random();
		
		try {
			//1.先查询当前电工的电工订单，查询条件是根据当前电工的Id,查询订单状态不是9的订单
			//1.1查询电工所有待办订单
			QueryResultObject queryResult = orderElectricianService.queryMore(requestCondition,electricianId);
			
			//
			//1.2查询出来的电工订单，如果订单状态是2(系统派单)，则随机生成公里数
			
			
			List<OrderElectrician> list=queryResult.getItems();
			List<OrderElectricianVO> oevList=new ArrayList<>();
			 
			 
			for (OrderElectrician orderElectrician : list) {
				OrderElectricianVO oev=new OrderElectricianVO();
				BeanUtils.copyProperties(orderElectrician, oev);
				
				if(oev.getOrderElectricianType().equals("2")){
					//随机生成50公里以下的数值
					oev.setDistance((r.nextInt(50)+1)+"KM");
					//oevList[i].add(oev);
				}
				
				System.out.println("************oov的值是：**********"+oev);
				oevList.add(oev);
				
			}
			
			
			queryResult.setItems(oevList);
			
			
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
	
	
	
	
	@RequestMapping("/queryWaitToDo")
	public WrappedResult queryWaitToDo(@QueryRequestParam("params") RequestCondition requestCondition,@RequestParam("electricianId")String electricianId) {
			
		try {
			
			
			QueryResultObject queryResult = orderElectricianService.queryWaitToDo(requestCondition,electricianId);
			
			
			
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
	
	
	
	
	
	
	
	
	/*
	 * @saveOrUpdate:保存位置
	 * @param params
	 * @return WrappedResult 保存或更新的结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 * http://localhost:8083/customerInfo/locationPut/?params={"filter":["customerId=customerId001","lon=13.144","lat=251.21465"]}	
	 */
	
	@RequestMapping(value = "/locationPut")
	public WrappedResult locationPut(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			Map<String, String> map = MapUtil.getParam(requestCondition);
			String jsonMap = JsonUtils.mapToJson(map);
			stringRedisTemplate.opsForValue().set(map.get("electricianId"), jsonMap, 1L, TimeUnit.HOURS);
			List result = new ArrayList();
			long count = 1;
			logger.info("存储位置信息保存成功"); 
			return WrappedResult.successWrapedResult(RestUtils.wrappQueryResult(result, count));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "存储位置信息异常";
			return WrappedResult.failedWrappedResult(errorMessage);
		}
	}
	
	
	/**
	 * @saveOrUpdate:获取位置测试
	 * @param params
	 * @return WrappedResult 保存或更新的结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 * http://localhost:8083/customerInfo/locationGet/customerId001
	 */
	
	@RequestMapping(value = "/locationGet/{electricianId}")
	public WrappedResult locationGetTest(@PathVariable String electricianId) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String json = stringRedisTemplate.opsForValue().get(electricianId);
			map = JsonUtils.parseJSONstr2Map(json);
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
	}
	

	
	
	
	
	
	/**
	 * 进行抢单页面，进行展示
	 * 		查询条件：查询所有客户订单，订单状态是1和11的订单，然后根据经纬度计算距离
	 * select * from order_customer where ORDER_STATUS like 1%;
	 */
	@RequestMapping("/queryAllOrder/{electricianId}")
	public WrappedResult queryAllOrder(@PathVariable String electricianId){
		
		stringRedisTemplate.opsForValue().get(electricianId);
		
		Map<String, Object> electricianLocation = new HashMap<String, Object>();
		String json = stringRedisTemplate.opsForValue().get(electricianId);
		electricianLocation = JsonUtils.parseJSONstr2Map(json);
		logger.info("经度:"+electricianLocation.get("lon")); 
		logger.info("纬度:"+electricianLocation.get("lat")); 
		
		try {
			
			//1.查询客户订单
			QueryResultObject queryResult=orderCustomerService.findByOrderStatusLike();
			
			List<OrderCustomer> orderCustomersList=queryResult.getItems();
			List<OrderCustomerVO> ovcList=new ArrayList<>();
			//list
			 Map<Double, OrderCustomerVO> map = new TreeMap<Double, OrderCustomerVO>(
		                new Comparator<Double>() {
		                    public int compare(Double obj1, Double obj2) {
		                        // 降序排序
		                        return obj1.compareTo(obj2);
		                    }
		                });
			
			 Double distanceDouble=null;
			
			for (OrderCustomer orderCustomer : orderCustomersList) {
				OrderCustomerVO orderCustomerVO=new OrderCustomerVO();
				BeanUtils.copyProperties(orderCustomer, orderCustomerVO);
				//获取订单 的位置,即经纬度，进行对比
				String orderCustomerLon=orderCustomerVO.getAddressLongitude();
				String orderCustomerLat=orderCustomerVO.getAddressLatitude();
				logger.info("从数据库获取的经度:"+orderCustomerLon);
				logger.info("从数据库获取的纬度:"+orderCustomerLat);
				
				distanceDouble=PointUtil.getDistanceString(String.valueOf(electricianLocation.get("lon")), String.valueOf(electricianLocation.get("lat")), orderCustomerLon, orderCustomerLat);
				System.out.println("计算的距离是："+distanceDouble);
				orderCustomerVO.setDistance(String.valueOf(distanceDouble)+"KM");
      
				        map.put(distanceDouble, orderCustomerVO);
	
			}
			
			Set<Double> keySet = map.keySet();
	        Iterator<Double> iter = keySet.iterator();
	        while (iter.hasNext()) {
	            Double key = iter.next();
	            System.out.println(key + ":" + map.get(key));
	            ovcList.add(map.get(key));
	        }
	        queryResult.setItems(ovcList);

			logger.info("查询数据成功"); 
			return WrappedResult.successWrapedResult(queryResult);
			
		} catch (Exception e) {
			// TODO: handle exception

			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}

	}
	
	
	/**
	 * 进行抢单按钮，点击后将客户订单生成到电工订单中
	 * 
	 */
	
	@RequestMapping(value = "/saveOrderCustomer", method = RequestMethod.POST)
	public WrappedResult saveOrUpdateOrderCustomer(@RequestBody FormRequestObject<Map<String,Object>> params,@RequestParam(value="electricianId")String electricianId) {

		//logger.info("传送过来的electricianId数据是："+electricianId);
		System.out.println("传送过来的electricianId数据是："+electricianId);
		try {
			if(params == null){
				throw new NullArgumentException("params");
			}
			QueryResultObject result = new QueryResultObject();
			List<Map<String,Object>> items = params.getItems();
			if(items != null && !items.isEmpty()){
				
				for(Map<String,Object> map : items){
					//查询电工订单，如果订单状态是2，则代表已经接单了
					String orderId=(String) map.get("orderId");
					OrderElectrician orElectrician=orderElectricianService.findByOrDERIdAndOrderElectricianType(orderId);
					//查询出来订单存在，则直接返回错误信息
					
					if(orElectrician!=null){
						String errorMessage = "订单已被抢";
						if(isDev){
							
						}
						return WrappedResult.failedWrappedResult(errorMessage);
					}
					
					result.setFormItems(orderElectricianService.saveOrderElectrician2(map,electricianId));
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
	 * 订单详情，查询的是状态21和2的客户订单，因为只有客户订单里有预约时间这个字段，应该是新的订单，电工已经接单，电工这边还未预约时间
	 * 此订单应该是电工已经接了的，所以可以传电工的ID
	 */
	
	@RequestMapping(value="/findOrderAllInfo/{electricianId}",name="查询电工所接订单的信息")
	public WrappedResult findOrderAllInfo(@PathVariable String electricianId){
		try {
		
		
		//1.根据电工ID查询电工订单表中的order_id,然后载根据order_id查询客户订单，进行显示
		//1.1 查询电工订单，只返回order_id
		 OrderElectrician order_idsString=orderElectricianService.findByOrderId(electricianId);
		//获取order_id
		String orderId=order_idsString.getOrDERId();
		//获取客户订单的信息
		
		//OrderCustomer orderCustomer=orderCustomerService.findByOrderId(orderId);
		
		//QueryResultObject queryResult
		QueryResultObject queryResult=orderCustomerService.findByOrderId(orderId);
		List<OrderCustomer> listOrderCustomers=queryResult.getItems();
		List<OrderCustomerVO> list=new ArrayList<>();
		for (OrderCustomer orderCustomer2 : listOrderCustomers) {
			
			OrderCustomerVO orderCustomerVO=null;
			BeanUtils.copyProperties(orderCustomer2, orderCustomerVO);
			list.add(orderCustomerVO);
		}
		
		
		
		
		queryResult.setItems(list);
		
		return WrappedResult.successWrapedResult(queryResult);
		}
		catch (ServiceValidatorBaseException e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "校验异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedValidateWrappedResult(errorMessage);
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
	 * 我的订单模块
	 * 全部已完成的订单  ，，，根据电工ID查询所有订单
	 */
	@RequestMapping(value="/queryAllHaveDone/{electricianId}",name="查询所有已经完结的订单")
	public WrappedResult queryAllHaveDone(@PathVariable String electricianId){
		
		try {
	
		
		QueryResultObject queryResult=orderElectricianHisService.findqQueryAllHaveDone(electricianId);
		
		return WrappedResult.successWrapedResult(queryResult);
		
	}
	catch (Exception e) {
		logger.error(e.getMessage(), e);
		String errorMessage = "查询异常";
		if(isDev){
			errorMessage = e.getMessage();
		}
		return WrappedResult.failedWrappedResult(errorMessage);
	}
	}

	
	
	/**
	 * 我的订单模块
	 * 全部已完成的订单  ，，，根据电工ID查询所有订单
	 */
	@RequestMapping(value="/queryAllDoing/{electricianId}",name="查询所有正在进行的订单")
	public WrappedResult queryAllDoing(@PathVariable String electricianId){
		
		try {
	
		
		QueryResultObject queryResult=orderElectricianService.queryAllDoing(electricianId);
		
		return WrappedResult.successWrapedResult(queryResult);
		
	}
	catch (Exception e) {
		logger.error(e.getMessage(), e);
		String errorMessage = "查询异常";
		if(isDev){
			errorMessage = e.getMessage();
		}
		return WrappedResult.failedWrappedResult(errorMessage);
	}
	}

	
	
	
	
	/**
	 * 我的订单模块
	 * 全部已取消的订单  ，，，根据电工ID查询所有订单
	 */
	@RequestMapping(value="/queryAllHaveEsc/{electricianId}",name="查询所有已经取消的订单")
	public WrappedResult queryAllHaveEsc(@PathVariable String electricianId){
		
		try {
			
		
		
		
		QueryResultObject queryResult=orderElectricianHisService.queryAllHaveEsc(electricianId);
		
		return WrappedResult.successWrapedResult(queryResult);
		
	}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
		}
}
	
	
	
	/**
	 * 电工个人信息查询
	 * 
	 */
	@RequestMapping(value="/queryElectricianInfo/{electricianId}",name="查询电工的个人信息")
	public WrappedResult queryElectricianInfo(@PathVariable String electricianId){
		try {
			
			QueryResultObject queryResult=ElectricianInfoService.queryElectricianInfo(electricianId);
			
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
	 * 电工评价，采用POST方式接收
	 */
	@RequestMapping(value="/electrician_evaluate",name="电工评价客户",method = RequestMethod.POST)
	
public WrappedResult electrician_evaluate(
		@RequestParam(value = "items", required = false) String items,@RequestParam("myFile") MultipartFile file
		){
		
		try {
			QueryResultObject result = new QueryResultObject();
			
			if(items != null && !items.isEmpty()){
				Map<String,Object> map = JsonUtils.parseJSONstr2Map(items); 
				//result.setFormItems(orderCustomerService.saveOrderCustomer(map,file));
				//保存电工的评价和图片
				result.setFormItems(orderElectricianService.saveElectricianEvaluate(map,file));
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
	 * 订单详情   查询的是电工状态为0，还未预约的状态
	 * 
	 */
	
	@RequestMapping(value="/orderDetails/{orderId}",name="电工订单详情页")
	public WrappedResult queryOrderDetails(@PathVariable(value="orderId") String orderId){
		try {
			//查询客户订单
			QueryResultObject queryResult=orderCustomerService.getOrderCustomerByOrderId(orderId);
			List<OrderCustomer> orderCustomersList=queryResult.getItems();
			List<OrderCustomerVO> orderCustomersVOList=new ArrayList<>();
			
			OrderCustomer orderCustomer=orderCustomersList.get(0);
			OrderCustomerVO orderCustomerVO=new OrderCustomerVO();
			
			//如果客户订单是11，则说明是一个旧的订单，还需要查询电工订单，查询出电工描述
			if (orderCustomer.getOrderStatus().equals("11")) {//说明是一个老订单，则需要查询电工订单
				OrderElectrician electrician=orderElectricianService.findByOrderId(orderId);
				//将查询出来的电工描述插入到VO中
				orderCustomerVO.setCustomerDescrive(electrician.getElectricianDescrive());
				
				
			} 
			//else {//订单直接转换vo，返回到前端

			//}
			
			BeanUtils.copyProperties(orderCustomer, orderCustomerVO);
			orderCustomersVOList.add(orderCustomerVO);
			queryResult.setItems(orderCustomersVOList);
			
			System.out.println("我查询成功了");
			return WrappedResult.successWrapedResult(queryResult);
			
			
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
	 * 电工预约时间去维修
	 * 直接传送一个VO对象,设置订单状态是21
	 * 
	 * http://localhost:8083/orderCustomer/save

		{"orderId":"2020120115365773cd37ab87f44dbaaed5c9976b70de26","orderStatus":"8"}
	 */
	@RequestMapping(value="/booking",name="电工预约去维修")
	public WrappedResult booking(@RequestParam(value = "items", required = false) String items,@RequestParam("myFile") MultipartFile file){
	
		
		try {
			
			QueryResultObject result = new QueryResultObject();
			
			if(items != null && !items.isEmpty()){
				Map<String,Object> map = JsonUtils.parseJSONstr2Map(items); 
				//在这里进行分化，分别保存客户订单和电工订单
				//获取订单的状态
				Map<String,Object> orderCustomerMap=new HashMap<>();
				Map<String,Object> orderElectricianMap=new HashMap<>();
				
				
				String orderElectricianType=(String) map.get("orderElectricianType");//获取电工订单的订单状态是否是5
				if(orderElectricianType.equals("5")){//说明是电工的退单，则将旧订单查出来后保存成新 的订单
					//查询出客户订单的详情
					String orderId=(String) map.get("orderId");
					QueryResultObject resultObject=new QueryResultObject();
					resultObject=orderCustomerService.findByOrderId(orderId);
					List<OrderCustomer> orderCustomers=resultObject.getItems();
					//获取一个客户订单
					OrderCustomer orderCustomerNew=orderCustomers.get(0);
					
					//获取电工订单,状态是：5的订单
					OrderElectrician orderElectrician=orderElectricianService.findByOrderId(orderId,orderElectricianType);
					
					//查询电工的详细信息
					String electricianId=(String) map.get("electricianId");
					ElectricianInfo electricianInfo=ElectricianInfoService.findInfo(electricianId);
					
					//创建一个新的电工订单
					orderElectricianMap.put("orderId", orderId);
					orderElectricianMap.put("electricianId",electricianId);
					orderElectricianMap.put("electricianName",electricianInfo.getElectricianName() );
					orderElectricianMap.put("electricianPhonenumber",electricianInfo.getElectricianPhonenumber());
					orderElectricianMap.put("electricianAddress",electricianInfo);
					orderElectricianMap.put("electricianPrice",orderCustomerNew.getCustomerPrice());
					orderElectricianMap.put("orderTypeId",0);
					orderElectricianMap.put("payStatus",orderCustomerNew.getPayStatus());
					orderElectricianMap.put("createTime",orderCustomerNew.getCreateTime());
					orderElectricianMap.put("electricianDescrive",orderElectrician.getElectricianDescrive());
					orderElectricianMap.put("electricianDescriveIcon",orderElectrician.getElectricianDescriveIcon());
					orderElectricianMap.put("chargebackReason",orderElectrician.getChargebackReason());
					
					
					
					
					
				}
				//如果状态是：1，等待接单（用户已支付上门费）状态转为2 
				orderCustomerMap.put("appointmentTime", map.get("appointmentTime"));//给客户订单设置更新时间
					orderCustomerMap.put("orderStatus", "2");
					orderElectricianMap.put("orderElectricianType", "21");
					result.setFormItems(orderCustomerService.saveOrderCustomer(map,file));
					result.setFormItems(orderElectricianService.saveOrderElectrician(orderElectricianMap,file));
				
				
				
				
				//result.setFormItems(orderCustomerService.saveOrderCustomer(map,file));
			}
			
			logger.info("保存数据成功"); 
			return WrappedResult.successWrapedResult(result);
		}
		
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "保存异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult(errorMessage);
			
		
		
	}
	
	}
	
	
	
}