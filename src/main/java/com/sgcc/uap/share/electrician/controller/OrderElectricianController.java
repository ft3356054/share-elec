package com.sgcc.uap.share.electrician.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.sgcc.uap.exception.NullArgumentException;
import com.sgcc.uap.rest.annotation.ColumnRequestParam;
import com.sgcc.uap.rest.annotation.QueryRequestParam;
import com.sgcc.uap.rest.annotation.attribute.ViewAttributeData;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.ViewMetaData;
import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.rest.utils.ViewAttributeUtils;
import com.sgcc.uap.share.controller.WebSocket;
import com.sgcc.uap.share.controller.WebSocketServer;
import com.sgcc.uap.share.customer.services.impl.CustPositionService;
import com.sgcc.uap.share.customer.services.impl.OrderCustomerHisService;
import com.sgcc.uap.share.customer.services.impl.OrderCustomerService;
import com.sgcc.uap.share.customer.services.impl.OrderFlowService;
import com.sgcc.uap.share.customer.vo.OrderCustomerVO;
import com.sgcc.uap.share.domain.BaseOrderType;
import com.sgcc.uap.share.domain.CustPosition;
import com.sgcc.uap.share.domain.ElecPosition;
import com.sgcc.uap.share.domain.ElectricianCompanyInfo;
import com.sgcc.uap.share.domain.ElectricianInfo;

import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderCustomerHis;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.domain.OrderElectricianHis;
import com.sgcc.uap.share.electrician.bo.OrderElectricianBeginPage;
import com.sgcc.uap.share.electrician.bo.OrderElectricianBeginPageVO;
import com.sgcc.uap.share.electrician.services.IOrderElectricianService;
import com.sgcc.uap.share.electrician.services.impl.ElecPositionService;
import com.sgcc.uap.share.electrician.services.impl.ElectricianCompanyInfoService;
import com.sgcc.uap.share.electrician.services.impl.ElectricianInfoService;
import com.sgcc.uap.share.electrician.services.impl.ElectricianSubCompanyInfoService;
import com.sgcc.uap.share.electrician.services.impl.OrderElectricianHisService;
import com.sgcc.uap.share.electrician.vo.OrderElectricianVO;
import com.sgcc.uap.share.services.impl.BaseOrderTypeService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceUserService;
import com.sgcc.uap.util.DateTimeUtil;
import com.sgcc.uap.util.JsonUtils;
import com.sgcc.uap.util.MapUtil;
import com.sgcc.uap.util.PointUtil;
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
	
	@Autowired
	private BaseOrderTypeService baseOrderTypeService;
	
	@Autowired
	private ElectricianCompanyInfoService electricianCompanyInfoService;
	
	@Autowired
	private OrderCustomerHisService orderCustomerHisService;
	
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
	 * @query:查询
	 * @param requestCondition
	 * @return WrappedResult 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	@RequestMapping("/")
	public WrappedResult query(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {			
			
			QueryResultObject queryResult = orderElectricianHisService.queryAll(requestCondition);
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
	
	
	//********************************************************************************************************************************
	/**
	 * 抢单页面 点击抢单按钮，
	 * 		1.需要接收前段页面传送过来的订单表，
	 * 		2.判断客户订单表的订单状态是1，新的订单，则进行创建一张电工订单表，更新客户订单表的状态，订单流水表，支付订单表
	 * @throws Exception 
	 * 
	 */
	
	@RequestMapping(value="/qiangdanrecept",name="电工接受了用户的订单，抢单")
	public WrappedResult qiangdanrecept(@RequestParam(value="orderId" )String orderId,
			@RequestParam(value="electricianId") String electricianId
			) throws Exception{
		
		//QueryResultObject resultObject=new QueryResultObject();
		try {

			//1.查询出来客户表
			OrderCustomer orderCustomer=orderCustomerService.findByOrderId(orderId);
			
			//2根据电工的状态查询是否在线，身上是否有单
			//2.1查询电工的信息是否在线
			ElectricianInfo electricianInfo=electricianInfoService.findByElectricianId(electricianId);
			//2.2.1查询电工公司是否在线
			String CompanyId=electricianInfo.getCompanyId();
			ElectricianCompanyInfo electricianCompanyInfo=electricianCompanyInfoService.findByCompanyId(CompanyId);
			if (electricianCompanyInfo.getBusinessStatus().equals("1")) {//1 代表的是停业状态
				String msg="您所属公司已停业";
				return WrappedResult.failedWrappedResult(msg);
			}
			if (electricianInfo.getElectricianStatus().equals("0")) {//0表明电工不在线
				String msg="请先更改接单状态";
				return WrappedResult.failedWrappedResult(msg);
			}
			//2.2查询
			 ElecPosition elecPosition=elecPositionService.getElecPositionByElectricianId(electricianId);
			if ( elecPosition.getStatus().equals("1")) {  //电工已经有单子了，是系统更改的
				String msg="请先完成名下的订单";
				return WrappedResult.failedWrappedResult(msg);
			}
			
			//插入一个条件，如果查询出来的客户表订单为20，表明是已经有人接了单子
			if(orderCustomer.getOrderStatus().equals("20") ){ //主订单20表明已经有人接了单子
				String msg="已经有人接了客户订单";
				return WrappedResult.failedWrappedResult(msg);	 
			}else {
				orderCustomer.setOrderStatus("20");
				Map<String, Object> map=new HashMap<>();
				map=orderElectricianService.pojo2Map(orderCustomer);
				orderElectricianService.saveOrderCustomerByOrderElectricianService(map);
			}
			
				//保存电工订单
				OrderElectrician orderElectrician=orderElectricianService.saveNewOrderElectrician(orderId,electricianId,"0");
				//查询电工订单的主订单
				OrderCustomer orderCustomerNew=orderCustomerService.findByOrderId(orderId);
				
				String orderElectricianId=orderElectrician.getOrderElectricianId();
				OrderElectricianBeginPageVO orderElectricianBeginPageVO=orderElectricianService.convert(orderCustomer, orderElectrician);
				
				
				//电工抢单成功后给客户发送
				orderElectricianService.sendNotify(orderCustomerNew,orderElectrician , 0, "0");
				return WrappedResult.successWrapedResult(orderElectricianBeginPageVO);
				
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			return WrappedResult.failedWrappedResult(errorMessage);
		}
		
	}
	
	/**
	 * 接单接口  
	 */
	@RequestMapping(value="/accept",name="电工接单")
	public WrappedResult accept(@RequestParam("electricianId") String electricianId,
			@RequestParam("orderId") String orderId
			){
		
		try {
			//2021.1.19
//			String orderElectricianEtatus="2";
//			OrderElectrician orderElectrician=orderElectricianService.findByOrDERIdAndOrderElectricianStatus(orderId, orderElectricianEtatus);
//			orderElectrician.setOrderElectricianStatus("0");
			//2021.1.19以下是当天做的更改，由于派单只是给传送的弹窗消息，所以需要再重新创建一个子订单
			OrderElectrician saveNewOrderElectrician = orderElectricianService.saveNewOrderElectrician(orderId, electricianId,"0");
			
		//***************************************截止
			orderElectricianService.save(saveNewOrderElectrician);
			//查询主订单，变换状态为20
			OrderCustomer orderCustomer=orderCustomerService.findByOrderId(orderId);
			orderCustomer.setOrderStatus("20");
			orderElectricianService.saveorderCustomerPOJO(orderCustomer);
			
			return WrappedResult.successWrapedResult(true);
		} catch (Exception e) {
			return WrappedResult.successWrapedResult("查询失败");
		}
		
		
	}
	
	
	/**
	 * 待办按钮点下后需要显示的东西
	 * 		查询条件：电工订单表的订单状态是未完结的那种,+电工ID
	 * 
	 */
	
	@RequestMapping(value="/waitToDo",name="待办事项")
	public List<OrderCustomerVO> waitToDo(@RequestParam(value="electricianId") String electricianId){
		
		//根据电工ID，查询出所有有关他未完结的电工订单
		QueryResultObject resultObject=new QueryResultObject();
		List<OrderCustomer> orderCustomers=new ArrayList<>();
		List<OrderCustomerVO> orderCustomerVOs=new ArrayList<>();
		List<OrderElectrician> list=orderElectricianService.findByElectricianIdAndOrderElectricianStatusEqualsOrderByCreateTime(electricianId,"9");
		for (OrderElectrician orderElectrician : list) {
			OrderCustomerVO orderCustomerVO=new OrderCustomerVO();
			 
			String orderIdString=orderElectrician.getOrDERId();
			OrderCustomer orderCustomer=orderCustomerService.findByOrderId(orderIdString);
			//查询电工的经纬度
			String distance=orderElectricianService.jisuanjuli(orderCustomer,orderElectrician);
			BeanUtils.copyProperties(orderCustomer, orderCustomerVO);
			orderCustomerVO.setDistance(distance);
			orderCustomerVO.setDistance(distance+"KM");
			orderCustomerVOs.add(orderCustomerVO);
		}
		
		return orderCustomerVOs;
	}
	
	
	
	
	@RequestMapping(value="/queryMore",name="待办")
	public WrappedResult queryMore(@QueryRequestParam("params") RequestCondition requestCondition,@RequestParam("electricianId")String electricianId) {
		Random r=new Random();
		
		try {
			//1.先查询当前电工的电工订单，查询条件是根据当前电工的Id,查询订单状态不是9的订单
			//1.1查询电工所有待办订单
			QueryResultObject queryResult = orderElectricianService.queryMore(requestCondition,electricianId);
			
			//1.2查询出来的电工订单，如果订单状态是2(系统派单)，则随机生成公里数
			
			
			List<OrderElectricianBeginPageVO> orderElectricianBeginPageVOList=new ArrayList<>();
			
			
			List<OrderElectrician> list=queryResult.getItems();
			List<OrderCustomer> orderCustomers=new ArrayList<>();
			for (OrderElectrician orderElectrician : list) {
				OrderElectricianBeginPageVO orderElectricianBeginPageVO=new OrderElectricianBeginPageVO();
				String orderId=orderElectrician.getOrDERId();
				OrderCustomer orderCustomer=orderCustomerService.findOrderId(orderId);
				orderCustomers.add(orderCustomer);
			}
			
			 
			ElecPosition elecPosition=elecPositionService.getElecPositionByElectricianId(electricianId);
			List<OrderElectricianBeginPageVO> returBeginPageVOs=new ArrayList<>();
			Double distanceDouble=null;
			int i=0;
			for (OrderCustomer orderCustomer : orderCustomers) {
				OrderElectricianBeginPageVO orderElectricianBeginPageVO=new OrderElectricianBeginPageVO();
				
					distanceDouble=PointUtil.getDistanceString(String.valueOf(orderCustomer.getAddressLongitude()), String.valueOf(orderCustomer.getAddressLatitude()), elecPosition.getLon(), elecPosition.getLat());
					orderElectricianBeginPageVO.setDistance(String.valueOf(distanceDouble)+"KM");
					orderElectricianBeginPageVO=orderElectricianService.convert(orderCustomer, list.get(i));
					returBeginPageVOs.add(orderElectricianBeginPageVO);
				
			}						
			queryResult.setItems(returBeginPageVOs);
						
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
			List<OrderElectrician>orderElectricians=queryResult.getItems();
			
			String orderTypeId=null;
			List<OrderCustomerVO> orderCustomerVOs=new ArrayList<>();
			for (OrderElectrician orderElectrician : orderElectricians) {
				OrderCustomerVO orderCustomerVO=new OrderCustomerVO();
				String orderId=orderElectrician.getOrDERId();
				OrderCustomer orderCustomer=orderCustomerService.findByOrderId(orderId);
				orderTypeId=orderCustomer.getOrderTypeId();
				 BaseOrderType baseOrderType=baseOrderTypeService.findByOrderTypeId(orderTypeId);
				 BeanUtils.copyProperties(orderCustomer, orderCustomerVO);
				 String distance=orderElectricianService.jisuanjuli(orderCustomer,orderElectrician);
				 
				 orderCustomerVO.setOrderTypeId(baseOrderType.getOrderTypeName());
				 orderCustomerVO.setDistance(distance);
				 orderCustomerVOs.add(orderCustomerVO);
			}
			queryResult.setItems(orderCustomerVOs);
			
			
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
	 * 进行抢单页面，进行展示
	 * 		查询条件：查询所有客户订单，订单状态是1和11的订单，然后根据经纬度计算距离
	 * select * from order_customer where ORDER_STATUS like 1%;
	 * acceptAround电工的接单范围
	 */
	@RequestMapping("/queryAllOrder/{electricianId}")
	public WrappedResult queryAllOrder(@PathVariable String electricianId
			
			){
		
		//1.先根据电工的ID获取区域ID
		//2.根据电工的区域ID获取此区域下的客户区域ID集合
		//3.根据客户区域ID集合查询客户名下的订单ID
		//4.根据查询出来的订单ID,进行距离计算，然后进行排序，筛选出一定距离内的客户
				
		//1.先根据电工的ID获取区域ID
		ElecPosition elecPosition=elecPositionService.getElecPositionByElectricianId(electricianId);
		String eleArea=elecPosition.getAreaId();
		
		//2获取此电工的经纬度范围
	
		double[] around=PointUtil.getAround(Double.valueOf(elecPosition.getLon()), Double.valueOf(elecPosition.getLat()), 15*10000);
		
		//地理经纬度在范围内的客户集合
		List<CustPosition> list=new ArrayList<>();
		
		//3.根据电工的区域ID获取此区域下的客户区域ID集合
		List<CustPosition> custPositionList=custPositionService.getByAreaId(eleArea);
		if (custPositionList.size()==0) {
			//没有客户订单，则返回该区域没有客户订单
			return WrappedResult.failedWrappedResult("此区域没有订单");
		}if (custPositionList.size()==1) {
			list.add(custPositionList.get(0));
		} else {
			for (CustPosition custPosition : custPositionList) {
				// { minLng, minLat, maxLng, maxLat };
				Double lon=Double.valueOf(custPosition.getLon());
				Double lat=Double.valueOf(custPosition.getLat());
				if (lon >around[0] && lon <around[2]){
					if (lat >around[1] && lat <around[3]) {
						list.add(custPosition);
					}
				}				
				}
		}
	
		
	
		List<OrderCustomer> orderCustomerList= new ArrayList<>();
		
		//4.根据  地理经纬度在范围内的客户集合  中的ID去查询客户订单中存在的订单
		for (CustPosition custPosition : list) {
			//获取客户的ID，
			String orderId=custPosition.getOrderId();
			OrderCustomer orderCustomer=orderCustomerService.findByOrderIdAndOrderStatus(orderId);
			OrderElectrician orderElectrician=orderElectricianService.findByElectricianIdAndOrderId(orderId,electricianId);
			
			if (orderCustomer !=null && orderElectrician==null && (orderCustomer.getOrderStatus().equals("1") || orderCustomer.getOrderStatus().equals("11"))) {
				orderCustomerList.add(orderCustomer);
			}
		}	
		//5.创建的是前端展示的VO对象集合
		
		List<OrderElectricianBeginPageVO> ovcList=new ArrayList<>();
		
		 Double distanceDouble=null;
		//6.将查询到的客户订单进行距离排序
		
			for (OrderCustomer orderCustomer : orderCustomerList) {
				OrderElectricianBeginPageVO orderElectricianBeginPageVO=new OrderElectricianBeginPageVO();
				
				//获取订单 的位置,即经纬度，进行对比
				String orderCustomerLon=orderCustomer.getAddressLongitude();
				String orderCustomerLat=orderCustomer.getAddressLatitude();
				
				
				distanceDouble=PointUtil.getDistanceString(String.valueOf(elecPosition.getLon()), String.valueOf(elecPosition.getLat()), orderCustomerLon, orderCustomerLat);
				System.out.println("计算的距离是："+distanceDouble);
				
				if (distanceDouble<=150 && distanceDouble>0) {
					orderElectricianBeginPageVO.setDistance(String.valueOf(distanceDouble));
					if (orderCustomer.getOrderStatus().equals("11")) {
						String orderId=orderCustomer.getOrderId();
						List<OrderElectrician> orderElectricianList=orderElectricianService.queryByOrderIdOrderByCreatetime(orderId);
						OrderElectrician orderElectrician=orderElectricianList.get(0);
						orderElectricianBeginPageVO=orderElectricianService.convert(orderCustomer, orderElectrician);
					}else {
						
						orderElectricianBeginPageVO=orderElectricianService.convertOrderCustomer2OrderElectricianBeginPageVO(orderCustomer, orderElectricianBeginPageVO);
					}
					orderElectricianBeginPageVO.setDistance(String.valueOf(distanceDouble));
					ovcList.add(orderElectricianBeginPageVO);
					
				}
				
			}
		
			Collections.sort(ovcList, new Comparator<OrderElectricianBeginPageVO>() {

	            @Override

	            public int compare(OrderElectricianBeginPageVO o1, OrderElectricianBeginPageVO o2) {

	                //return o1.para - o2.para;  //升序

	               //return Double.parseDouble(o1.getDistance()) - Double.parseDouble(o2.getDistance()); //降序
	                return Double.compare(Double.parseDouble(o1.getDistance()), Double.parseDouble(o2.getDistance()));
	                

	            }

	        });
			if (ovcList.size()==0) {
				return WrappedResult.successWrapedResult("此区域没有订单");
			}
			List<OrderElectricianBeginPageVO> returnPageVOs=new ArrayList<>();
			for (OrderElectricianBeginPageVO orderElectricianBeginPageVO : ovcList) {
				orderElectricianBeginPageVO=orderElectricianService.convertDistance(orderElectricianBeginPageVO);
				returnPageVOs.add(orderElectricianBeginPageVO);
			}
			
			logger.info("查询数据成功"); 
			return WrappedResult.successWrapedResult(returnPageVOs);		
		} 
	
	/**
	 * 我的订单模块
	 * 全部已完成的订单  ，，，根据电工ID查询所有订单
	 */
	@RequestMapping(value="/queryAllHaveDone/{electricianId}",name="查询所有已经完结的订单")
	public WrappedResult queryAllHaveDone(@PathVariable String electricianId ,
			@RequestParam(value="pageIndex",required=false) int pageIndex,@RequestParam(value="pageSize",required=false) int pageSize
			){
		
		
		try {
			pageIndex=pageIndex-1;
		QueryResultObject queryResult=orderElectricianHisService.findqQueryAllHaveDone(pageIndex,pageSize,electricianId);
		
		
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
		
		//查询电工订单
		QueryResultObject queryResult=orderElectricianService.queryAllHaveEsc(electricianId);
		OrderElectrician orderElectrician=new OrderElectrician();
		List<OrderElectrician> list=queryResult.getItems();
		List<OrderElectricianBeginPageVO> orderElectricianBeginPageVOs=new ArrayList<>();
		for (OrderElectrician orderElectrician2 : list) {
			OrderElectricianBeginPageVO orderElectricianBeginPageVO=new OrderElectricianBeginPageVO();
			OrderCustomer orderCustomer=orderCustomerService.findByOrderId(orderElectrician2.getOrDERId());
			if (orderCustomer!=null) {
				orderElectricianBeginPageVO=orderElectricianService.convert(orderCustomer, orderElectrician2);
			}else {
				OrderCustomerHis orderCustomerHis=orderCustomerHisService.findByOrderId(orderElectrician2.getOrDERId());
				OrderCustomer orderCustomer2=new OrderCustomer();
				BeanUtils.copyProperties(orderCustomerHis, orderCustomer2);
				orderElectricianBeginPageVO=orderElectricianService.convert(orderCustomer2, orderElectrician2);
			}
			
			
			orderElectricianBeginPageVOs.add(orderElectricianBeginPageVO);
		}
		
		queryResult.setItems(orderElectricianBeginPageVOs);
		
		queryResult.setItemCount(orderElectricianBeginPageVOs.size());
		
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
			List<OrderElectricianBeginPageVO> OrderElectricianBeginPageVOList=new ArrayList<>();
			//获取一个客户订单
			OrderCustomer orderCustomer=orderCustomersList.get(0);
			OrderElectricianBeginPageVO orderElectricianBeginPageVO=new OrderElectricianBeginPageVO();
			//如果主订单的状态是11,则说明是电工退单，已经给了电工上门费，则现在是0
			if (orderCustomer.getOrderStatus().equals("1")) {
				orderElectricianBeginPageVO=orderElectricianService.convertOrderCustomer2OrderElectricianBeginPageVO(orderCustomer, orderElectricianBeginPageVO);
				
			}else if (orderCustomer.getOrderStatus().equals("11")) {
				
				String customerPrice = orderCustomer.getCustomerPrice();
				customerPrice="";
				OrderElectrician orderElectrician=orderElectricianService.findByOrderId(orderId,electricianId);
				orderElectricianBeginPageVO=orderElectricianService.convert(orderCustomer, orderElectrician);
				
			}else{
				OrderElectrician orderElectrician=orderElectricianService.findByOrderId(orderId,electricianId);
				orderElectricianBeginPageVO=orderElectricianService.convert(orderCustomer, orderElectrician);
				
			}
			
			OrderElectricianBeginPageVOList.add(orderElectricianBeginPageVO);
			queryResult.setItems(OrderElectricianBeginPageVOList);
			queryResult.setItemCount(orderCustomersList.size());
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
	public WrappedResult booking(@RequestParam(value = "items", required = false) String items,HttpServletRequest request){
	
		try {
			
			MultipartFile file=null;
			Boolean isMultpart=ServletFileUpload.isMultipartContent(request);
			if (isMultpart) {
				MultipartHttpServletRequest multipartHttpServletRequest=WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
				file=multipartHttpServletRequest.getFile("myFile");
			}
			
			
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
					String orderId=(String) map.get("orderId");
					String electricianId=(String) map.get("electricianId");
					//2021.1.20
					//先查询订单的状态，如果状态是0，则继续预约功能
					OrderElectrician orderElectricianOld = orderElectricianService.findByElectricianIdAndOrderId(orderId, electricianId);
					if (orderElectricianOld.getOrderElectricianStatus().equals("0")) {
						
					
					String orderElectricianStatus=(String) map.get("orderElectricianStatus");
					
						//获取预约子订单的主订单
						OrderCustomer orderCustomerNew=orderCustomerService.findByOrderId(orderId);
						
						//查询电工的详细信息
						
						ElectricianInfo electricianInfo=electricianInfoService.findInfo(electricianId);
						
						//创建一个新的电工订单
						
						orderElectricianMap.put("orderId", orderId);
						orderElectricianMap.put("electricianId",electricianId);
					
						orderCustomerMap.put("appointmentTime", map.get("appointmentTime"));//给客户订单设置更新时
						orderCustomerMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
						orderCustomerMap.put("orderStatus",map.get("orderStatus"));
						orderCustomerMap.put("orderId", map.get("orderId"));
						
						
						orderElectricianMap.put("orderId", map.get("orderId"));
						orderElectricianMap.put("orderElectricianStatus", map.get("orderElectricianStatus"));
						
						orderElectricianMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
						OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap);
						OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
						OrderElectricianBeginPageVO orderCustomerVO=orderElectricianService.convert(orderCustomer,orderElectrician);
						result.setFormItems(orderCustomerVO);
						orderElectricianService.sendNotify(orderElectrician, 2, "1");
					}else {
						return WrappedResult.failedWrappedResult("订单的状态不正确");
					}
						
				
				}
				if (method.equals("现场勘查")) {//电工到达现场，勘察,状态是22--->26
				
					String orderId=(String) map.get("orderId");
					String electricianId=(String) map.get("electricianId");
					//2021.1.20
					//先查询订单的状态，如果状态是0，则继续预约功能
					OrderElectrician orderElectricianOld = orderElectricianService.findByElectricianIdAndOrderId(orderId, electricianId);
					if (orderElectricianOld.getOrderElectricianStatus().equals("22")) {
					
					//将map中的数据分别送到两个类中，在进行更新
					//客户订单需要跟新的信息
					orderCustomerMap.put("orderStatus", map.get("orderStatus"));
					orderCustomerMap.put("orderId", map.get("orderId"));
					orderCustomerMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
					
					//电工订单需要更新的信息
					orderElectricianMap.put("orderId", map.get("orderId"));
					orderElectricianMap.put("orderElectricianStatus", map.get("orderElectricianStatus"));
					orderElectricianMap.put("electricianDescrive", map.get("electricianDescrive"));
					orderElectricianMap.put("electricianId", map.get("electricianId"));
					orderElectricianMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
					
					
				
					OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap);
					OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
					OrderElectricianBeginPageVO orderCustomerVO=orderElectricianService.convert(orderCustomer,orderElectrician);
					orderElectricianService.sendNotify(orderElectrician, 2, "1");
					result.setFormItems(orderCustomerVO);
					
				}else {
					return WrappedResult.failedWrappedResult("订单的状态不正确");
				}}
					
				
				if (method.equals("22")) { //方法ID：22 表明电工到达现场   状态是21--->22
					
					
					orderCustomerMap.put("orderStatus",map.get("orderStatus"));
					orderCustomerMap.put("orderId", map.get("orderId"));
					orderCustomerMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
					
					orderElectricianMap.put("orderId", map.get("orderId"));
					orderElectricianMap.put("orderElectricianStatus", map.get("orderElectricianStatus"));
					orderElectricianMap.put("electricianId", map.get("electricianId"));
					orderElectricianMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
					OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap);
					OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
					OrderElectricianBeginPageVO orderCustomerVO=orderElectricianService.convert(orderCustomer,orderElectrician);
					orderElectricianService.sendNotify(orderElectrician, 2, "1");
					result.setFormItems(orderCustomerVO);
					
				}
				
				if(method.equals("abc")){   //电工退单
					//客户订单将状态改变成：11   电工订单将订单状态改变成：5
					
					//将map中的数据分别送到两个类中，在进行更新
					//客户订单需要跟新的信息
					orderCustomerMap.put("orderStatus", map.get("orderStatus"));
					orderCustomerMap.put("orderId", map.get("orderId"));
					orderCustomerMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
					
					//将电工的状态变成空闲
					String electricianId=(String) map.get("electricianId");
					ElecPosition elecPosition = elecPositionService.getElecPositionByElectricianId(electricianId);
					elecPosition.setStatus("0");
					Map<String, Object> eleMap=orderElectricianService.pojo2Map(elecPosition);
					elecPositionService.saveElecPosition(eleMap);
					
					//电工订单需要更新的信息
					orderElectricianMap.put("orderId", map.get("orderId"));
					orderElectricianMap.put("orderElectricianStatus",map.get("orderElectricianStatus"));
					orderElectricianMap.put("electricianDescrive", map.get("electricianDescrive"));
					orderElectricianMap.put("electricianId", map.get("electricianId"));
					orderElectricianMap.put("finishTime", DateTimeUtil.formatDateTime(new Date()));
					
					OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap);
					System.out.println("我执行完了保存操作");
					OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
					OrderElectricianBeginPageVO orderCustomerVO=orderElectricianService.convert(orderCustomer,orderElectrician);
					
					orderElectricianService.sendNotify(orderCustomer, orderElectrician, 2, "1");
					result.setFormItems(orderCustomerVO);
					
			
				}
				if(method.equals("上传合同")){//状态应该从26---->23电工上传合同（报价）
					
					
					
					try {
						String orderId=(String) map.get("orderId");
						String electricianId=(String) map.get("electricianId");
						//2021.1.20
						//先查询订单的状态，如果状态是0，则继续预约功能
						OrderElectrician orderElectricianOld = orderElectricianService.findByElectricianIdAndOrderId(orderId, electricianId);
						if (orderElectricianOld.getOrderElectricianStatus().equals("26")) {
							
						
						//根据orderId查询主订单，查看订单来源
						
						OrderCustomer orderCustomer=orderCustomerService.findByOrderId(orderId);
						//如果状态是0，则说明是app来源，只需要给客户发送通知就好
						if (orderCustomer.getOrderFrom().equals("0")) {
							//将map中的数据分别送到两个类中，在进行更新
							//客户订单需要跟新的信息
							orderCustomerMap.put("orderStatus", map.get("orderStatus"));
							orderCustomerMap.put("orderId", map.get("orderId"));
							orderCustomerMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
							//OrderCustomer orderCustomer=orderCustomerService.findByOrderId(String.valueOf(map.get("orderId")));
							//电工订单需要更新的信息
							orderElectricianMap.put("orderId", map.get("orderId"));
							orderElectricianMap.put("orderElectricianStatus",map.get("orderElectricianStatus"));
							//orderElectricianMap.put("electricianDescrive", map.get("electricianDescrive"));
							orderElectricianMap.put("electricianId", map.get("electricianId"));
							orderElectricianMap.put("electricianPrice", map.get("electricianPrice"));
							orderElectricianMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
							
							OrderCustomer orderCustomer1=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap);
							System.out.println("我执行完了保存操作");
							OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
							OrderElectricianBeginPageVO orderCustomerVO=orderElectricianService.convert(orderCustomer,orderElectrician);
							result.setFormItems(orderCustomerVO);
							
							//给客户发送消息，让其支付维修费
							//TODO
							orderElectricianService.sendNotify(orderCustomer1,orderElectrician,2,"1");
							
							//订单来源是客服，则直接出示二维码
						}}else {
							// TODO: handle exception
						}
					
					
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
					/**
					 * 开始施工
					 */
					if(method.equals("开始施工")){//状态是从3--->31
						
						String orderId=(String) map.get("orderId");
						String electricianId=(String) map.get("electricianId");
						//2021.1.20
						//先查询订单的状态，如果状态是0，则继续预约功能
						OrderElectrician orderElectricianOld = orderElectricianService.findByElectricianIdAndOrderId(orderId, electricianId);
						if (!orderElectricianOld.getOrderElectricianStatus().equals("3")) {
							return WrappedResult.failedWrappedResult("订单的状态不对");
						}
						String str=(String) map.get("otherElectricianId");
					
						String otherElectricianId="";
						String remark_str1sString="";
						//如果传送过来的有数据
						//先将其它电工截取
						
						if (!str.isEmpty() && str.length()!=0) {
							
							//查询主电工的名字和电话
							ElectricianInfo electricianInfo=electricianInfoService.findByElectricianId(electricianId);
							String electricianName=electricianInfo.getElectricianName();
							String telephone=electricianInfo.getElectricianPhonenumber();
							remark_str1sString=electricianName+":"+telephone;
							
							
							//给其它电工发送通知
							String replace = str.replace("{", "");
							String replace2 = replace.replace("}", "");
							String[] split = replace2.split(",");
							
							//如果有多个
							if (split.length>1) {
								for (int i = 0; i < split.length; i++) {
									
									if (i== split.length-1) {
										otherElectricianId=otherElectricianId+split[i];
										
										String electricianId1=split[i];
										ElectricianInfo electricianInfo1 = electricianInfoService.findByElectricianId(electricianId1);
										String electricianName1=electricianInfo1.getElectricianName();
										String electricianPhonenumber1=electricianInfo1.getElectricianPhonenumber();
										remark_str1sString=remark_str1sString+","+electricianName1+":"+electricianPhonenumber1;
										//更改电工的状态，先查询电工位置状态表
										ElecPosition elecPosition = elecPositionService.getElecPositionByElectricianId(electricianId1);
										elecPosition.setStatus("1");
										Map<String, Object> map2= orderElectricianService.pojo2Map(elecPosition);
										elecPositionService.saveElecPosition(map2);
										orderElectricianService.sendNotice("31",orderId,split[i],0,"1");
										
									}else {

										otherElectricianId=split[i]+",";
										
										String electricianId1=split[i];
										ElectricianInfo electricianInfo1 = electricianInfoService.findByElectricianId(electricianId1);
										String electricianName1=electricianInfo1.getElectricianName();
										String electricianPhonenumber1=electricianInfo1.getElectricianPhonenumber();
										remark_str1sString=remark_str1sString+","+electricianName1+":"+electricianPhonenumber1;
										//更改电工的状态，先查询电工位置状态表
										ElecPosition elecPosition = elecPositionService.getElecPositionByElectricianId(electricianId1);
										elecPosition.setStatus("1");
										Map<String, Object> map2= orderElectricianService.pojo2Map(elecPosition);
										elecPositionService.saveElecPosition(map2);
										orderElectricianService.sendNotice("31",orderId,split[i],0,"1");
										//通过电工的ID给电工发送消息
										//WebSocketServer.sendInfo("您已有未完成的订单",split[i]);
										
									}
									}
								otherElectricianId=electricianId+","+otherElectricianId;
								
							}
							else {
									otherElectricianId=split[0];
									//传送过来的单个电工ID，获取名字和电话号
									
									String electricianId1=split[0];
									ElectricianInfo electricianInfo1 = electricianInfoService.findByElectricianId(electricianId1);
									String electricianName1=electricianInfo1.getElectricianName();
									String electricianPhonenumber1=electricianInfo1.getElectricianPhonenumber();
									remark_str1sString=remark_str1sString+","+electricianName1+":"+electricianPhonenumber1;
									
									//更改电工的状态，先查询电工位置状态表
									ElecPosition elecPosition = elecPositionService.getElecPositionByElectricianId(electricianId1);
									elecPosition.setStatus("1");
									Map<String, Object> map2= orderElectricianService.pojo2Map(elecPosition);
									elecPositionService.saveElecPosition(map2);
									orderElectricianService.sendNotice("31",orderId,split[0],0,"1");
									//通过电工的ID给电工发送消息
									WebSocketServer.sendInfo("您已有未完成的订单",split[0]);
									
								}
								
							
							System.out.println(otherElectricianId);
								
							
					
						}else {
							//放入当前电工ID
							//String electricianId = (String) map.get("electricianId");
							otherElectricianId=electricianId;
							
							ElectricianInfo electricianInfo = electricianInfoService.findByElectricianId(electricianId);
							String electricianName=electricianInfo.getElectricianName();
							String telephone=electricianInfo.getElectricianPhonenumber();
							 remark_str1sString=electricianName+":"+telephone;
						}
						
						
						//将map中的数据分别送到两个类中，在进行更新
						//客户订单需要跟新的信息
						orderCustomerMap.put("orderStatus", map.get("orderStatus"));
						orderCustomerMap.put("orderId", map.get("orderId"));
						orderCustomerMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
						
						//电工订单需要更新的信息
						orderElectricianMap.put("orderId", map.get("orderId"));
						orderElectricianMap.put("orderElectricianStatus",map.get("orderElectricianStatus"));
						orderElectricianMap.put("electricianId", map.get("electricianId"));
						orderElectricianMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
						orderElectricianMap.put("remarkStr1", remark_str1sString);
						orderElectricianMap.put("otherElectricianId", otherElectricianId);
						
						OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap);
						System.out.println("我执行完了保存操作");
						OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
						OrderElectricianBeginPageVO orderCustomerVO=orderElectricianService.convert(orderCustomer,orderElectrician);
						result.setFormItems(orderCustomerVO);
						orderElectricianService.sendNotify(orderElectrician, 2, "1");
					
					}
					
					if(method.equals("施工完成")){//状态是从31--->24
						
						String orderId=(String) map.get("orderId");
						String electricianId=(String) map.get("electricianId");
						//2021.1.20
						//先查询订单的状态，如果状态是3，则继续预约功能
						OrderElectrician orderElectricianOld = orderElectricianService.findByElectricianIdAndOrderId(orderId, electricianId);
						if (!orderElectricianOld.getOrderElectricianStatus().equals("31")) {
							return WrappedResult.failedWrappedResult("订单的状态不对");
						}
						
						//将map中的数据分别送到两个类中，在进行更新
						//客户订单需要跟新的信息
						orderCustomerMap.put("orderStatus", map.get("orderStatus"));
						orderCustomerMap.put("orderId", map.get("orderId"));
						orderCustomerMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
						
						//电工订单需要更新的信息
						orderElectricianMap.put("orderId", map.get("orderId"));
						orderElectricianMap.put("orderElectricianStatus",map.get("orderElectricianStatus"));
						orderElectricianMap.put("electricianId", map.get("electricianId"));
						orderElectricianMap.put("constructionContent", map.get("constructionContent"));
						orderElectricianMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
						
						OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap);
						System.out.println("我执行完了保存操作");
						OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
						OrderElectricianBeginPageVO orderCustomerVO=orderElectricianService.convert(orderCustomer,orderElectrician);
						result.setFormItems(orderCustomerVO);
						orderElectricianService.sendNotify(orderElectrician, 2, "1");
						
					}
					
					if(method.equals("验收申请")){//状态从24--->25
						
						String orderId=(String) map.get("orderId");
						String electricianId=(String) map.get("electricianId");
						//2021.1.20
						//先查询订单的状态，如果状态是0，则继续预约功能
						OrderElectrician orderElectricianOld = orderElectricianService.findByElectricianIdAndOrderId(orderId, electricianId);
						if (!orderElectricianOld.getOrderElectricianStatus().equals("24")) {
							return WrappedResult.failedWrappedResult("订单的状态有问题");
						}
						//将map中的数据分别送到两个类中，在进行更新
						//客户订单需要跟新的信息
						orderCustomerMap.put("orderStatus", map.get("orderStatus"));
						orderCustomerMap.put("orderId", map.get("orderId"));
						orderCustomerMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
						
						//电工订单需要更新的信息
						orderElectricianMap.put("orderId", map.get("orderId"));
						orderElectricianMap.put("orderElectricianStatus",map.get("orderElectricianStatus"));
						orderElectricianMap.put("electricianId", map.get("electricianId"));
						orderElectricianMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
						orderElectricianMap.put("finishTime", DateTimeUtil.formatDateTime(new Date()));
						//2021.1.13电工发起验收后，电工就可以接单了
							//1.需要电工的位置表状态是0   2.
						ElecPosition elecPosition=elecPositionService.getElecPositionByElectricianId(String.valueOf(map.get("electricianId")));
						elecPosition.setStatus("0");
						
						Map<String, Object> map2= orderElectricianService.pojo2Map(elecPosition);
						elecPositionService.saveElecPosition(map2);
					
						OrderCustomer orderCustomer=orderElectricianService.saveOrderCustomerByOrderElectricianService(orderCustomerMap);
						
						OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
						//其它的电工也需要将状态置作1
						String otherElectricianId=orderElectrician.getOtherElectricianId();
						//包含逗号，则说明有多个
						if (otherElectricianId.contains(",")) {
							String[] split = otherElectricianId.split(",");
							for (int i = 1; i < split.length; i++) {
								ElecPosition elecPosition1=elecPositionService.getElecPositionByElectricianId(split[i]);
								elecPosition1.setStatus("0");
								Map<String, Object> map3= orderElectricianService.pojo2Map(elecPosition1);
								elecPositionService.saveElecPosition(map3);
							}
							
						}else {
							//将单个的电工状态置成1
							ElecPosition elecPosition1=elecPositionService.getElecPositionByElectricianId(otherElectricianId);
							elecPosition1.setStatus("0");
							Map<String, Object> map3= orderElectricianService.pojo2Map(elecPosition1);
							elecPositionService.saveElecPosition(map3);
						}
						
						OrderElectricianBeginPageVO orderCustomerVO=orderElectricianService.convert(orderCustomer,orderElectrician);
						result.setFormItems(orderCustomerVO);
						
						//给客户发一个通知消息
						orderElectricianService.sendNotify(orderCustomer, orderElectrician, 2, "1");
						
					}
					
					if (method.equals("评价")) {//两个订单的状态是9
						
					
						String orderId=(String) map.get("orderId");
						String electricianId=(String) map.get("electricianId");
						//2021.1.20
						//先查询订单的状态，如果状态是9，
						OrderElectrician orderElectricianOld = orderElectricianService.findByElectricianIdAndOrderId(orderId, electricianId);
						if (!orderElectricianOld.getOrderElectricianStatus().equals("8")) {
							
						}
						
						//电工订单需要更新的信息
						orderElectricianMap.put("orderId", map.get("orderId"));
						orderElectricianMap.put("orderElectricianStatus",map.get("orderElectricianStatus"));
						orderElectricianMap.put("electricianId", map.get("electricianId"));
						orderElectricianMap.put("electricianEvaluate", map.get("electricianEvaluate"));
						orderElectricianMap.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
						
						
						System.out.println("我执行完了保存操作");
						OrderElectrician orderElectrician=orderElectricianService.saveOrderElectrician(orderElectricianMap,file);
						
						result.setFormItems(orderElectrician);
						
						//插入一条流水
						orderElectricianService.sendNotify( orderElectrician, 2, "1");
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

	@RequestMapping(value="/esc",name="取消订单")
	public WrappedResult esc(@RequestParam(value="orderElectricianId") String orderElectricianId,
			@RequestParam(value="orderElectricianStatus") String orderElectricianStatus
			){
		try {
			
			orderElectricianService.esc(orderElectricianId,orderElectricianStatus);
		
			return WrappedResult.successWrapedResult("true");
			
		} catch (Exception e) {
			
			return WrappedResult.successWrapedResult("false");
		}				
	}	
	/**
	 * tagType=1  表示在全部订单  
	 * tagType=3  表示在已完成订单
	 * tagType=2  表示在进行中订单
	 * @param requestCondition
	 * @return
	 */
	@RequestMapping(value="/searchBox",name="搜索")
	public WrappedResult searchBox(@QueryRequestParam("params") RequestCondition requestCondition) {
		try {
			
			QueryResultObject queryResult = orderElectricianService.searchBox(requestCondition);
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
	
	@RequestMapping(value="/queryElectrician",name="查询电工是否存在")
	public WrappedResult queryElectrician(@RequestParam( value="electricianName",required = false) String electricianName,
			@RequestParam(value="electricianPhonenumber",required = false) String electricianPhonenumber,@RequestParam("electricianId") String electricianId){
		try {
			
			//查询当前电工的信息
			ElecPosition elecPosition=elecPositionService.getElecPositionByElectricianId(electricianId);
			//用于存放返回的数据
			List<ElectricianInfo> list=new ArrayList<>();
			//如果姓名不为空
			if (!electricianName.isEmpty()) {
				//根据电工的姓名去模糊查询
				List<ElectricianInfo> electricianInfoList=electricianInfoService.LikeElectricianName(electricianName);
				for (ElectricianInfo electricianInfo : electricianInfoList) {
					ElecPosition elecPosition2=elecPositionService.getElecPositionByElectricianId(electricianInfo.getElectricianId());
					//电工都是空闲状态
					if (electricianInfo.getElectricianStatus().equals("1") && elecPosition2.getStatus().equals("0") && elecPosition.getAreaId().equals(elecPosition2.getAreaId())) {
						list.add(electricianInfo);
					}					
				}
				return WrappedResult.successWrapedResult(list);
			}else if (!electricianPhonenumber.isEmpty()) {
				
				//根据电工的姓名去模糊查询
				List<ElectricianInfo> electricianInfoList=electricianInfoService.findByElectricianPhonenumberLike(electricianPhonenumber);
				for (ElectricianInfo electricianInfo : electricianInfoList) {
					ElecPosition elecPosition2=elecPositionService.getElecPositionByElectricianId(electricianInfo.getElectricianId());
					//电工都是空闲状态
					if (!electricianInfo.getElectricianStatus().equals("1") && elecPosition2.getStatus().equals("0") && elecPosition.getAreaId().equals(elecPosition2.getAreaId())) {
						list.add(electricianInfo);
					}					
				}
				return WrappedResult.successWrapedResult(list);
				
			}else {
				return WrappedResult.failedWrappedResult("未找到电工");
			}		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult("查找电工出错");
		}	
	}
	
	@RequestMapping(value="queryAllElectrician/{electricianId}",name="查询所有的电工")
	public WrappedResult queryAllElectrician(@PathVariable(value="electricianId") String electricianId ){
		try {
			
			QueryResultObject queryResult=orderElectricianService.queryAllElectrician(electricianId);
			
			return WrappedResult.successWrapedResult(queryResult);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			if(isDev){
				errorMessage = e.getMessage();
			}
			return WrappedResult.failedWrappedResult("当前电工公司没有其它电工");
		}
	}
	
	//***************************************************************************************
	//
	//测试抢单弹窗功能
	@RequestMapping(value="/test",name="")
	public void test(@RequestParam(value="items") String items){
		Map<String,Object> map = JsonUtils.parseJSONstr2Map(items);
		//获取主订单ID，
		String orderId=(String) map.get("orderId");
		OrderCustomer orderCustomer = orderCustomerService.findByOrderId(orderId);
		//orderElectricianService.qiangdantanchuang(orderCustomer, 200);
		orderElectricianService.paidanchaxun(orderCustomer);
		
	}

}