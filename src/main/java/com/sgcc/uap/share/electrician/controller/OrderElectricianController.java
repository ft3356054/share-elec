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
import com.sgcc.uap.share.customer.services.impl.CustPositionService;
import com.sgcc.uap.share.customer.services.impl.OrderCustomerService;
import com.sgcc.uap.share.customer.services.impl.OrderFlowService;
import com.sgcc.uap.share.customer.vo.OrderCustomerVO;
import com.sgcc.uap.share.domain.CustPosition;
import com.sgcc.uap.share.domain.ElecPosition;
import com.sgcc.uap.share.domain.ElectricianInfo;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.domain.OrderElectricianHis;
import com.sgcc.uap.share.domain.OrderFlow;
import com.sgcc.uap.share.electrician.services.IOrderElectricianService;
import com.sgcc.uap.share.electrician.services.impl.ElecPositionService;
import com.sgcc.uap.share.electrician.services.impl.ElectricianInfoService;
import com.sgcc.uap.share.electrician.services.impl.OrderElectricianHisService;
import com.sgcc.uap.share.electrician.services.impl.OrderElectricianService;
import com.sgcc.uap.share.electrician.vo.OrderElectricianVO;
import com.sgcc.uap.share.services.impl.NotifyAnnounceService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceUserService;
import com.sgcc.uap.util.DateTimeUtil;
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
	private ElectricianInfoService electricianInfoService;
	
	
	@Autowired
	private ElecPositionService  elecPositionService;
	
	@Autowired
	private CustPositionService   custPositionService;
	
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
	
	@RequestMapping(value="/qiangdanrecept",name="电工接受了用户的订单")
	
	public WrappedResult qiangdanrecept(@RequestParam(value="orderId" )String orderId,
			@RequestParam(value="electricianId") String electricianId
			) throws Exception{
		//OrderElectrician saveOrderElectrician=null;
		QueryResultObject resultObject=new QueryResultObject();
		try {
			
			/*
		//新的客户订单
		OrderCustomer orderCustomer=new OrderCustomer();
		//新的电工订单
		OrderElectrician orderElectrician=new OrderElectrician();
		//查询出的当前电工信息
		ElectricianInfo electricianInfo=electricianInfoService.findInfo(electricianId);
		
		Map<String,Object> map=new HashMap<String, Object>();
		
		
		
		
		//1.查询出来客户表
		resultObject=orderCustomerService.findByOrderId(orderId);
		List<OrderCustomer> list=resultObject.getItems();
		
		//插入一个条件，如果查询出来的客户表订单为20，表明是已经有人接了单子
		if(list.get(0).getOrderStatus().equals("20")){
			String msg="已经有人接了客户订单";
			return WrappedResult.failedWrappedResult(msg);
			 
		}
		
		//2.判断客户表是否是新表
		if(list.get(0).getOrderStatus().equals("11")){
			//2.1电工接单的单子是11，说明是老单子设置客户订单表单状态为2，只需要将电工的填写的信息挪到新的电工订单就好
			List<OrderElectrician> orderElectricianOlds=orderElectricianService.findByOrderIdAndOrderElectricianTypeOrderByFinishTimeDesc(orderId,"5");
			OrderElectrician orderElectricianOld=orderElectricianOlds.get(0);
			//电工描述
			map.put("electricianDescrive", orderElectricianOld.getElectricianDescrive());
			//电工拍照
			map.put("electricianDescriveIcon", orderElectricianOld.getElectricianDescriveIcon());
			
			
		}
		map.put("orderElectricianId",UuidUtil.getUuid32());
		map.put("electricianId",electricianId);
		map.put("electricianName",electricianInfo.getElectricianName());
		map.put("electricianPhonenumber",electricianInfo.getElectricianPhonenumber());
		map.put("electricianAddress",null);
		map.put("otherElectricianId",null);
		map.put("orderTypeId",null);
		map.put("electricianPrice",null);
		map.put("orderElectricianType","20");
		map.put("payStatus",orderCustomer.getPayStatus());
		map.put("createTime",DateTimeUtil.formatDateTime(new Date()));
		
		map.put("orDERId",orderId);
		map.put("orderId", orderId);
		
		saveOrderElectrician = orderElectricianService.saveOrderElectrician(map);
		
		*/
			
			//1.查询出来客户表
			resultObject=orderCustomerService.findByOrderId(orderId);
			List<OrderCustomer> list=resultObject.getItems();
			
			//插入一个条件，如果查询出来的客户表订单为20，表明是已经有人接了单子
			if(list.get(0).getOrderStatus().equals("20")){
				String msg="已经有人接了客户订单";
				return WrappedResult.failedWrappedResult(msg);
				 
			}
			
			OrderElectrician orderElectrician=orderElectricianService.saveNewOrderElectrician(orderId,electricianId);
			
			
			return WrappedResult.successWrapedResult(orderElectrician);
		
				
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			return WrappedResult.failedWrappedResult(errorMessage);
		}
		
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
		
		
		//1.先根据电工的ID获取区域ID
		//2.根据电工的区域ID获取此区域下的客户区域ID集合
		//3.根据客户区域ID集合查询客户名下的订单ID
		//4.根据查询出来的订单ID,进行距离计算，然后进行排序，筛选出一定距离内的客户
		
		
		//1.先根据电工的ID获取区域ID
		
		QueryResultObject resultObject=elecPositionService.getElecPositionByElectricianId(electricianId);
		List<ElecPosition> elecPositionList=resultObject.getItems();
		ElecPosition elecPosition=elecPositionList.get(0);
		String eleArea=elecPosition.getAreaId();
		
		//2获取此电工的经纬度范围
		double[] around=PointUtil.getAround(Double.valueOf(elecPosition.getLon()), Double.valueOf(elecPosition.getLat()), 100000);
		
		//地理经纬度在范围内的客户集合
		List<CustPosition> list=new ArrayList<>();
		
		//3.根据电工的区域ID获取此区域下的客户区域ID集合
		List<CustPosition> custPositionList=custPositionService.getByAreaId(eleArea);
		
		int i=custPositionList.size();
		
		for (CustPosition custPosition : custPositionList) {
			if (Double.valueOf(custPosition.getLon())>around[0] && Double.valueOf(custPosition.getLon())<around[2]){
				if (Double.valueOf(custPosition.getLat())>around[1] && Double.valueOf(custPosition.getLat())<around[3]) {
					list.add(custPosition);
					i++;
				}
			}
					
				
			}
	
		List<OrderCustomer> orderCustomerList= new ArrayList<>();
		
		//4.根据  地理经纬度在范围内的客户集合  中的ID去查询客户订单中存在的订单
		for (CustPosition custPosition : list) {
			//获取客户的ID，
			String orderId=custPosition.getOrderId();
			OrderCustomer orderCustomer=orderCustomerService.findByOrderIdAndOrderStatus(orderId);
			if (orderCustomer !=null) {
				orderCustomerList.add(orderCustomer);
			}
		}
		
		
		//5.创建的是前端展示的VO对象集合
		List<OrderCustomerVO> ovcList=new ArrayList<>();
		
		 Map<Double, OrderCustomerVO> map = new TreeMap<Double, OrderCustomerVO>(
	                new Comparator<Double>() {
	                    public int compare(Double obj1, Double obj2) {
	                        // 降序排序
	                        return obj1.compareTo(obj2);
	                    }
	                });
		
		 Double distanceDouble=null;
		//6.将查询到的客户订单进行距离排序
		
			for (OrderCustomer orderCustomer : orderCustomerList) {
				OrderCustomerVO orderCustomerVO=new OrderCustomerVO();
				BeanUtils.copyProperties(orderCustomer, orderCustomerVO);
				//获取订单 的位置,即经纬度，进行对比
				String orderCustomerLon=orderCustomerVO.getAddressLongitude();
				String orderCustomerLat=orderCustomerVO.getAddressLatitude();
				
				
				distanceDouble=PointUtil.getDistanceString(String.valueOf(elecPosition.getLon()), String.valueOf(elecPosition.getLat()), orderCustomerLon, orderCustomerLat);
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
	        
			logger.info("查询数据成功"); 
			return WrappedResult.successWrapedResult(ovcList);
			
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
			
		
		
		//查询电工历史订单
		QueryResultObject queryResult=orderElectricianHisService.queryAllHaveEsc(electricianId);
		
		//查询电工订单
		QueryResultObject queryResult2=orderElectricianService.queryAllHaveEsc(electricianId);
		
		OrderElectrician orderElectrician=new OrderElectrician();
		List<OrderElectrician> list2=queryResult2.getItems();
		List<OrderElectricianHis> list=queryResult.getItems();
		for (OrderElectricianHis orderElectricianHis : list) {
			BeanUtils.copyProperties(orderElectricianHis, orderElectrician);
			list2.add(orderElectrician);
		}
		queryResult2.setItems(list2);
		queryResult2.setItemCount(list2.size());
		
		return WrappedResult.successWrapedResult(queryResult2);
		
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
			
			QueryResultObject queryResult=electricianInfoService.queryElectricianInfo(electricianId);
			
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
	 * 订单详情   查询的是电工状态为0，还未预约的状态
	 * 
	 */
	
	
	
	@RequestMapping(value="/orderDetails/{orderId}",name="电工订单详情页")
	public WrappedResult queryOrderDetails(@PathVariable(value="orderId") String orderId,
			@RequestParam(value="electricianId") String electricianId){
		try {
			//查询客户订单
			QueryResultObject queryResult=orderCustomerService.getOrderCustomerByOrderId(orderId);
			List<OrderCustomer> orderCustomersList=queryResult.getItems();
			List<OrderCustomerVO> orderCustomersVOList=new ArrayList<>();
			
			OrderCustomer orderCustomer=orderCustomersList.get(0);
			OrderCustomerVO orderCustomerVO=new OrderCustomerVO();
			
			//如果客户订单是11，则说明是一个旧的订单，还需要查询电工订单，查询出电工描述
			if (orderCustomer.getOrderStatus().equals("11")) {//说明是一个老订单，则需要查询电工订单
				OrderElectrician electrician=orderElectricianService.findByOrderId(orderId,electricianId);
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
				System.out.println(map.toString());
				
				//在这里进行分化，分别保存客户订单和电工订单
				//获取订单的状态
				Map<String,Object> orderCustomerMap=new HashMap<>();
				Map<String,Object> orderElectricianMap=new HashMap<>();
				
				
				//先获取method方法是啥
				String method=(String) map.get("method");
				
				if(method.equals("预约")){
					System.out.println("我现在进行的是预约成功的方法");
					String orderElectricianType=(String) map.get("orderElectricianType");//获取电工订单的订单状态是否是5
					//if(orderElectricianType.equals("5")){//说明是电工的退单，则将旧订单查出来后保存成新 的订单
						//查询出客户订单的详情
						String orderId=(String) map.get("orderId");
						QueryResultObject resultObject=new QueryResultObject();
						resultObject=orderCustomerService.findByOrderId(orderId);
						List<OrderCustomer> orderCustomers=resultObject.getItems();
						//获取一个客户订单
						OrderCustomer orderCustomerNew=orderCustomers.get(0);
						
						//获取电工订单,状态是：5的订单,根据完工时间进行排序
						List<OrderElectrician> list=orderElectricianService.findByOrderIdAndOrderElectricianTypeOrderByFinishTimeDesc(orderId,orderElectricianType);
						
						if(list.size()!=0){
							//获取最新的状态是5的订单，则说明是老订单,则创建一个新的订单
							OrderElectrician orderElectrician=list.get(0);
						
						
						//查询电工的详细信息
						String electricianId=(String) map.get("electricianId");
						ElectricianInfo electricianInfo=electricianInfoService.findInfo(electricianId);
						
						//创建一个新的电工订单
						orderElectricianMap.put("orderElectricianId", UuidUtil.getIntUuid32());
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
						orderCustomerMap.put("orderStatus", "21");
						orderCustomerMap.put("orderId", map.get("orderId"));
						
						orderElectricianMap.put("orderId", map.get("orderId"));
						orderElectricianMap.put("orderElectricianType", "21");
						OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap,file);
						OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
					result.setFormItems(orderCustomer);
					result.setFormItems(orderElectrician);
					
				}
				if (method.equals("现场勘查")) {//此时电工和客户订单的状态都是22，电工到达现场，勘察
					
					//将map中的数据分别送到两个类中，在进行更新
					//客户订单需要跟新的信息
					orderCustomerMap.put("orderStatus", map.get("orderStatus"));
					orderCustomerMap.put("orderId", map.get("orderId"));
					
					//电工订单需要更新的信息
					orderElectricianMap.put("orderId", map.get("orderId"));
					orderElectricianMap.put("orderElectricianType", map.get("orderElectricianType"));
					orderElectricianMap.put("electricianDescrive", map.get("electricianDescrive"));
					orderElectricianMap.put("electricianId", map.get("electricianId"));
					
					
					OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap,file);
					OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
					result.setFormItems(orderCustomer);
					
				}
				
				if(method.equals("现场勘查退回订单")){
					//客户订单将状态改变成：11   电工订单将订单状态改变成：5
					
					//将map中的数据分别送到两个类中，在进行更新
					//客户订单需要跟新的信息
					orderCustomerMap.put("orderStatus", map.get("orderStatus"));
					orderCustomerMap.put("orderId", map.get("orderId"));
					
					//电工订单需要更新的信息
					orderElectricianMap.put("orderId", map.get("orderId"));
					orderElectricianMap.put("orderElectricianType",map.get("orderElectricianType"));
					orderElectricianMap.put("electricianDescrive", map.get("electricianDescrive"));
					orderElectricianMap.put("electricianId", map.get("electricianId"));
					
					OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap,file);
					System.out.println("我执行完了保存操作");
					OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
					result.setFormItems(orderCustomer);
					
					
					
					
				}
				if(method.equals("上传合同")){//状态应该从22---->23电工上传合同（报价）
					
					//将map中的数据分别送到两个类中，在进行更新
					//客户订单需要跟新的信息
					orderCustomerMap.put("orderStatus", map.get("orderStatus"));
					orderCustomerMap.put("orderId", map.get("orderId"));
					
					//电工订单需要更新的信息
					orderElectricianMap.put("orderId", map.get("orderId"));
					orderElectricianMap.put("orderElectricianType",map.get("orderElectricianType"));
					orderElectricianMap.put("electricianDescrive", map.get("electricianDescrive"));
					orderElectricianMap.put("electricianId", map.get("electricianId"));
					orderElectricianMap.put("electricianPrice", map.get("electricianPrice"));
					
					OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap,file);
					System.out.println("我执行完了保存操作");
					OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
					result.setFormItems(orderCustomer);
					
					
				}
				
				if(method.equals("电工人员保存")){// 每点一下就触发一次
					
					//电工订单需要更新的信息
					orderElectricianMap.put("orderId", map.get("orderId"));
					orderElectricianMap.put("electricianId", map.get("electricianId"));
					orderElectricianMap.put("electricianName", map.get("name"));
					//orderElectricianMap.put("telephone", map.get("telephone"));
					
					//根据电工ID查询当下电工的信息
					ElectricianInfo electricianInfoOld=electricianInfoService.findInfo((String)map.get("electricianId"));
					
					String electricianId=(String)map.get("electricianId");
					 String orderId=(String)map.get("orderId");
					//查询当前电工订单，
					OrderElectrician orderElectrician=orderElectricianService.findByElectricianIdAndOrderId(electricianId,orderId);
					
					String telephone=(String)map.get("telephone");
					//根据电话号查询是否有当前电工
					ElectricianInfo electricianInfo=electricianInfoService.findByElectricianPhonenumber(telephone);

					//先对比新查出来的电工姓名和电话是否对的上
					if (orderElectricianMap.get("electricianName").equals(electricianInfo.getElectricianName())) {//查询信息对等
						map.put("otherElectricianId", electricianInfo.getElectricianId());
						orderElectrician.setOtherElectricianId(orderElectrician.getOtherElectricianId()+electricianInfo.getElectricianId()+",");
						orderElectricianMap.put("otherElectricianId", orderElectrician.getOtherElectricianId());
						OrderElectrician orderElectrician2=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
						result.setFormItems(orderElectrician2);
					}else {//信息不对等，则返回错误
						WrappedResult.failedWrappedResult("人员信息不符~");
					}
				}
				
				/**
				 * 删除人员
				 */
					if(method.equals("电工人员删除")){// 每点一下就触发一次
					
					//电工订单需要更新的信息
					orderElectricianMap.put("orderId", map.get("orderId"));
					orderElectricianMap.put("electricianId", map.get("electricianId"));
					orderElectricianMap.put("electricianName", map.get("name"));
					//orderElectricianMap.put("telephone", map.get("telephone"));
					
					//根据电工ID查询当下电工的信息
					ElectricianInfo electricianInfoOld=electricianInfoService.findInfo((String)map.get("electricianId"));
					
					String electricianId=(String)map.get("electricianId");
					 String orderId=(String)map.get("orderId");
					//查询当前电工订单，
					OrderElectrician orderElectrician=orderElectricianService.findByElectricianIdAndOrderId(electricianId,orderId);
					
					String telephone=(String)map.get("telephone");
					//根据电话号查询是否有当前电工
					ElectricianInfo electricianInfo=electricianInfoService.findByElectricianPhonenumber(telephone);

					//先对比新查出来的电工姓名和电话是否对的上
					if (orderElectricianMap.get("electricianName").equals(electricianInfo.getElectricianName())) {//查询信息对等
						map.put("otherElectricianId", electricianInfo.getElectricianId());
						
						//获取要删除id
						
						String deleteElectricianId=electricianInfo.getElectricianId()+",";
						
						String str=orderElectrician.getOtherElectricianId();
						String a=str.replace(deleteElectricianId, "");
						
						orderElectrician.setOtherElectricianId(a);
						System.out.print(a+"*******************************");
						orderElectricianMap.put("otherElectricianId", orderElectrician.getOtherElectricianId());
						orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
						
					}else {//信息不对等，则返回错误
						WrappedResult.failedWrappedResult("人员信息不符~");
					}
				}
					
					/**
					 * 开始施工
					 */
					if(method.equals("开始施工")){//只能改状态就好
						
						
						//将map中的数据分别送到两个类中，在进行更新
						//客户订单需要跟新的信息
						orderCustomerMap.put("orderStatus", map.get("orderStatus"));
						orderCustomerMap.put("orderId", map.get("orderId"));
						
						//电工订单需要更新的信息
						orderElectricianMap.put("orderId", map.get("orderId"));
						orderElectricianMap.put("orderElectricianType",map.get("orderElectricianType"));
						orderElectricianMap.put("electricianId", map.get("electricianId"));
						
						
						OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap,file);
						System.out.println("我执行完了保存操作");
						OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
						result.setFormItems(orderCustomer);
						
						
						
					}
					
					if(method.equals("施工完成")){//状态都改成24
						
						//将map中的数据分别送到两个类中，在进行更新
						//客户订单需要跟新的信息
						orderCustomerMap.put("orderStatus", map.get("orderStatus"));
						orderCustomerMap.put("orderId", map.get("orderId"));
						
						//电工订单需要更新的信息
						orderElectricianMap.put("orderId", map.get("orderId"));
						orderElectricianMap.put("orderElectricianType",map.get("orderElectricianType"));
						orderElectricianMap.put("electricianId", map.get("electricianId"));
						orderElectricianMap.put("constructionContent", map.get("constructionContent"));
						
						/*  由于前段页面可以存储信息，添加的电工就不再传
						String electricianId=(String)map.get("electricianId");
						 String orderId=(String)map.get("orderId");
						//查询当前电工订单，
						OrderElectrician orderElectrician=orderElectricianService.findByElectricianIdAndOrderId(electricianId,orderId);
						//获取其它电工ID
						String OrderElectricianId=orderElectrician.getOrderElectricianId();
						*/
						
						
						
						OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap,file);
						System.out.println("我执行完了保存操作");
						orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
						result.setFormItems(orderCustomer);
						
						
						
						
						
					}
					
					if(method.equals("验收申请")){//验收完成的话状态就变成24，
						
						//将map中的数据分别送到两个类中，在进行更新
						//客户订单需要跟新的信息
						orderCustomerMap.put("orderStatus", map.get("orderStatus"));
						orderCustomerMap.put("orderId", map.get("orderId"));
						
						//电工订单需要更新的信息
						orderElectricianMap.put("orderId", map.get("orderId"));
						orderElectricianMap.put("orderElectricianType",map.get("orderElectricianType"));
						orderElectricianMap.put("electricianId", map.get("electricianId"));
						
						
						OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap,file);
						System.out.println("我执行完了保存操作");
						orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
						result.setFormItems(orderCustomer);
						
					}
					
					if (method.equals("评价")) {//两个订单的状态是9
						//将map中的数据分别送到两个类中，在进行更新
						//客户订单需要跟新的信息
						orderCustomerMap.put("orderStatus", map.get("orderStatus"));
						orderCustomerMap.put("orderId", map.get("orderId"));
						
						//电工订单需要更新的信息
						orderElectricianMap.put("orderId", map.get("orderId"));
						orderElectricianMap.put("orderElectricianType",map.get("orderElectricianType"));
						orderElectricianMap.put("electricianId", map.get("electricianId"));
						orderElectricianMap.put("electricianEvaluate", map.get("electricianEvaluate"));
						//添加订单完结时间
						orderElectricianMap.put("finishTime", DateTimeUtil.formatDateTime(new Date()));
						
						
						//OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap,file);
						System.out.println("我执行完了保存操作");
						OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
						result.setFormItems(orderElectrician);
						
					}
					

				
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