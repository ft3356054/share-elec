package com.sgcc.uap.share.electrician.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sgcc.uap.exception.NullArgumentException;
import com.sgcc.uap.mdd.runtime.validate.ValidateService;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryFilter;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.utils.CrudUtils;
import com.sgcc.uap.rest.utils.RestUtils;
import com.sgcc.uap.share.controller.WebSocket;
import com.sgcc.uap.share.controller.WebSocketServer;
import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;
import com.sgcc.uap.share.customer.services.impl.OrderCustomerService;
import com.sgcc.uap.share.customer.services.impl.OrderFlowService;
import com.sgcc.uap.share.domain.BaseAreaPrice;
import com.sgcc.uap.share.domain.BaseEnums;
import com.sgcc.uap.share.domain.BaseIdentityPrice;
import com.sgcc.uap.share.domain.ElectricianCompanyInfo;
import com.sgcc.uap.share.domain.ElectricianInfo;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.domain.OrderElectricianHis;
import com.sgcc.uap.share.electrician.controller.OrderElectricianController;
import com.sgcc.uap.share.electrician.repositories.OrderElectricianRepository;
import com.sgcc.uap.share.electrician.services.IOrderElectricianService;
import com.sgcc.uap.share.services.impl.BaseAreaPriceService;
import com.sgcc.uap.share.services.impl.BaseEnumsService;
import com.sgcc.uap.share.services.impl.BaseIdentityPriceService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceUserService;
import com.sgcc.uap.util.DateTimeUtil;
import com.sgcc.uap.util.DecimalUtil;
import com.sgcc.uap.util.FileUtil;
import com.sgcc.uap.util.MapUtil;
import com.sgcc.uap.util.SorterUtil;
import com.sgcc.uap.util.TimeStamp;
import com.sgcc.uap.util.UuidUtil;
import com.sgcc.uap.utils.string.StringUtil;





@Service
public class OrderElectricianService implements IOrderElectricianService{
	/** 
     * 注入orderElectricianRepository
     */
	
	//private final static Logger logger = (Logger) LoggerFactory.getLogger(OrderCustomerService.class);
	
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(OrderElectricianController.class);
	
	@Autowired
	private OrderElectricianRepository orderElectricianRepository;
	@Autowired
	private ValidateService validateService;
	
	@Autowired
	private OrderCustomerRepository orderCustomerRepository;
	
	@Autowired
	private ElectricianInfoService electricianInfoService;
	
	@Autowired
	private OrderFlowService orderFlowService;
	
	@Autowired
	private NotifyAnnounceService notifyAnnounceService;
	
	@Autowired
	private NotifyAnnounceUserService notifyAnnounceUserService;
	
	@Autowired
	private BaseAreaPriceService baseAreaPriceService;
	
	@Autowired
	private BaseIdentityPriceService baseIdentityPriceService;
	
	@Autowired
	private BaseEnumsService baseEnumsService;
	 
	@Override
	public QueryResultObject getOrderElectricianByOrderElectricianId(String orderElectricianId) {
		OrderElectrician orderElectrician = orderElectricianRepository.findOne(orderElectricianId);
		return RestUtils.wrappQueryResult(orderElectrician);
	}
	@Override
	public void remove(IDRequestObject idObject) {
		if(idObject == null){
			throw new NullArgumentException("idObject");
		}
		String[] ids = idObject.getIds();
		for (String id : ids){
			orderElectricianRepository.delete(id);
		}
	}
	
	
	
	
	
	@Override
	@Transactional
	public OrderElectrician saveOrderElectrician2(Map<String,Object> map,String electricianId) throws Exception{
		System.out.println("我进入了service中");
		
			validateService.validateWithException(OrderElectrician.class,map);
		
		/*
		 * 开始改动地方
		 * TODO
		 */
		
		OrderElectrician orderElectrician = new OrderElectrician();
		OrderElectrician result = new OrderElectrician();
		
		
		if (map.containsKey("orderElectricianId")) {
			//说明是个旧的订单
			String orderElectricianId = (String) map.get("orderElectricianId");
			orderElectrician = orderElectricianRepository.findOne(orderElectricianId);
			if(null!=orderElectrician){
				CrudUtils.mapToObject(map, orderElectrician,  "orderElectricianId");
			}else{
				orderElectrician = new OrderElectrician();
				CrudUtils.transMap2Bean(map, orderElectrician);
			}
			
			//CrudUtils.mapToObject(map, orderElectrician,  "orderElectricianId");
		}else{//说明是个新的订单
			String getNewOrderId=UuidUtil.getUuid32();
			//开始新增电工订单
			//先查询电工的信息
			QueryResultObject electricianResult = electricianInfoService.getElectricianInfoByElectricianId(electricianId);
			 List<ElectricianInfo> electricianList=electricianResult.getItems();
			 ElectricianInfo electricianInfo=null;
			 if(electricianList.size()==1){
				  electricianInfo=electricianList.get(0);
			 }
			 //map.put("", value)
			 map.put("orderElectricianId", getNewOrderId);
			map.put("electricianId", electricianInfo.getElectricianId());
			map.put("electricianName", electricianInfo.getElectricianName());
			map.put("electricianPhonenumber", electricianInfo.getElectricianPhonenumber());
			map.put("otherElectricianId", null);
			map.put("orderElectricianType", "2");
			map.put("payStatus", 1);//TODO  还没有确认订单的状态
			map.put("createTime", DateTimeUtil.formatDateTime(new Date()));
			map.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
			map.put("finishTime", DateTimeUtil.formatDateTime(new Date()));
			
			
			CrudUtils.transMap2Bean(map, orderElectrician);
			result = orderElectricianRepository.save(orderElectrician);
			System.out.println("我执行完了新增电工订单");
			System.out.println("");
			/*
			//新增流水
			Map<String,Object> mapOrderFlow = 
					MapUtil.flowAdd((String) map.get("orderId"), 0, 0, (String)map.get("customerId"), TimeStamp.toString(new Date()), 0,  "新增orderCustomer订单");
			orderFlowService.saveOrderFlow(mapOrderFlow);
			System.out.println("我执行完了新增流水");
			System.out.println("");
			
			
			
			//新增通知
			String announceId = UuidUtil.getUuid32();
			
			Map<String,Object> mapNotify =
					MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", "待付勘察费", "待付勘察费，内容", TimeStamp.toString(new Date()), "新增客户待付款通知");
			notifyAnnounceService.saveNotifyAnnounce(mapNotify);
			
			Map<String,Object> mapNotifyUser = 
					MapUtil.notifyUserAdd((String)map.get("customerId"), announceId, 0, 0, TimeStamp.toString(new Date()), "新增客户待付款通知");
			notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);
			
			System.out.println("我执行完了新增通知");
			System.out.println("");
			*/
			
			
			//获取Enum通知类
			BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("0", "0");	
			
			//新增流水
			Map<String,Object> mapOrderFlow = 
					MapUtil.flowAdd((String) map.get("orderId"), 0, 0, (String)map.get("customerId"), TimeStamp.toString(new Date()), 0,  baseEnums.getEnumsA());
			orderFlowService.saveOrderFlow(mapOrderFlow);
			
			//新增通知
			String announceId = UuidUtil.getUuid32();
			
			String status=(String) map.get("orderStatus");
			String notifyType="1";
			if ("23".equals(status)) {
				notifyType="2";
				
			}else if ("24".equals(status)) {
				notifyType="3";
			}else if ("8".equals(status)) {
				notifyType="4";
			}
			
			Map<String,Object> mapNotify =
					MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", baseEnums.getEnumsB(), baseEnums.getEnumsC(), TimeStamp.toString(new Date()), 
							notifyType,orderElectrician.getOrDERId(),getNewOrderId);
			notifyAnnounceService.saveNotifyAnnounce(mapNotify);
			
			Map<String,Object> mapNotifyUser = 
					MapUtil.notifyUserAdd((String)map.get("customerId"), announceId, 0, 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
			notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);

			//发送websocket消息
	        
			
			
		}
		return result;
		
	
	}
	
	
	
	@Override
	public QueryResultObject query(RequestCondition queryCondition) {
		System.out.println("我使用的是query方法");
		if(queryCondition == null){
			throw new NullArgumentException("queryCondition");
		}
		Object o = queryCondition.getFilter();
	
		
		if(o != null && o instanceof List){
			List<Map<String, Object>> filter = (List<Map<String, Object>>)o;
			String str = filter.toString();
			System.out.println("*-*-*-*-*-*-*-*-str*************"+str);
			if(!filter.isEmpty()){
				for (Map<String, Object> map : filter) {
					List<Map<String, Object>> filter1 = (List<Map<String, Object>>) map.get("criterions");
					if(filter1 != null && !filter1.isEmpty()){
						return querySingle(queryCondition);
					}
				}
			}
		} 
		return queryCommon(queryCondition);
	}
	/**
	 * 字符串类型模糊查询示例：
	 * Predicate predicate = cb.like(root.get("employeeName"), "%" + 三 + "%");  查询名字中含有“三”的员工
	 * 
	 * 数字类型or时间类型示例:
	 * Predicate predicate = cb.equal(root.get("age"), 26); 查询年龄为26的员工
	 * Predicate predicate = cb.ge(root.get("age"), 26);	 查询年龄大于26的员工  同理大于等于为gt
     * Predicate predicate = cb.le(root.get("age"), 26);	 查询年龄小于26的员工  同理小于等于为lt
     * Predicate predicate = cb.between(root.get("age"), 26, 30);查询年龄在26与30之间的员工
	 * 若查询条件为时间类型，需用DateTimeConverter类的toDate方法将条件转换为对应的日期类型，然后进行查询
	 * 例如：Date date = (Date) DateTimeConverter.toDate(Date.class, queryFilter.getValue()); Predicate predicate = cb.equal(namePath, date);
	 * @querySingle:主从表单页查询方法
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	private QueryResultObject querySingle(RequestCondition queryCondition) {
		
		System.out.println("我使用的是querySingle方法");
		
		List<QueryFilter> qList = getFilterList(queryCondition);
		Specification<OrderElectrician> specification = new Specification<OrderElectrician>() {
			@Override
			public Predicate toPredicate(Root<OrderElectrician> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> preList = new ArrayList<Predicate>();
				if(qList != null && !qList.isEmpty()){
					for(QueryFilter queryFilter : qList){
					Path<String> namePath = root.get(queryFilter.getFieldName());
					Predicate predicate = cb.equal(namePath, queryFilter.getValue());
					preList.add(predicate);
					}
					query.where(preList.toArray(new Predicate[preList.size()]));
				}
				preList.clear();
				return null;
			}
		};
		PageRequest request = this.buildPageRequest(queryCondition);
		Page<OrderElectrician> orderElectrician = orderElectricianRepository.findAll(specification,request);
		List<OrderElectrician> result = new ArrayList<OrderElectrician>();
		long count = 0;
		if(null != qList && !qList.isEmpty()){
			result = orderElectrician.getContent();
			count = orderElectrician.getTotalElements();
		}
		return RestUtils.wrappQueryResult(result, count);
	}
	/**
	 * 字符串类型模糊查询示例：
	 * Predicate predicate = cb.like(root.get("employeeName"), "%" + 三 + "%");  查询名字中含有“三”的员工
	 * 
	 * 数字类型or时间类型示例:
	 * Predicate predicate = cb.equal(root.get("age"), 26); 查询年龄为26的员工
	 * Predicate predicate = cb.ge(root.get("age"), 26);	 查询年龄大于26的员工  同理大于等于为gt
     * Predicate predicate = cb.le(root.get("age"), 26);	 查询年龄小于26的员工  同理小于等于为lt
     * Predicate predicate = cb.between(root.get("age"), 26, 30);查询年龄在26与30之间的员工
	 * 若查询条件为时间类型，需用DateTimeConverter类的toDate方法将条件转换为对应的日期类型，然后进行查询
	 * 例如：Date date = (Date) DateTimeConverter.toDate(Date.class, queryFilter.getValue()); Predicate predicate = cb.equal(namePath, date); 
	 * @queryCommon:查询方法(通用的)
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	private QueryResultObject queryCommon(RequestCondition queryCondition) {
		System.out.println("我使用的是queryCommon方法");
		List<QueryFilter> qList = queryCondition.getQueryFilter();
		System.out.println("**********qList************"+qList);
		System.out.println("");
		
		
		QueryFilter queryFilter = qList.get(0);
		String fieldName = queryFilter.getFieldName();
		System.out.println("**********fieldName************"+fieldName);
		System.out.println("");
		
		Specification<OrderElectrician> specification = new Specification<OrderElectrician>() {
			@Override
			public Predicate toPredicate(Root<OrderElectrician> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> preList = new ArrayList<Predicate>();
				if(qList != null && !qList.isEmpty()){
					for(QueryFilter queryFilter : qList){
						Path<String> namePath = root.get(queryFilter.getFieldName());
						Predicate predicate = cb.equal(namePath, queryFilter.getValue());
						preList.add(predicate);
					}
					query.where(preList.toArray(new Predicate[preList.size()]));
				}
				preList.clear();
				return null;
			}
		};
		PageRequest request = this.buildPageRequest(queryCondition);
		Page<OrderElectrician> orderElectrician = orderElectricianRepository.findAll(specification,request);
		List<OrderElectrician> result = new ArrayList<OrderElectrician>();
		long count = 0;
		result = orderElectrician.getContent();
		count = orderElectrician.getTotalElements();
		return RestUtils.wrappQueryResult(result, count);
	}
	
	/**
	 * @getFilterList:获取条件列表
	 * @param queryCondition 查询条件
	 * @return List<QueryFilter> 查询条件列表
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	private List<QueryFilter> getFilterList(RequestCondition queryCondition) {
		List<QueryFilter> qList = new ArrayList<QueryFilter>();
		List<Map<String, Object>> filter = (List<Map<String, Object>>) queryCondition.getFilter();
		if(filter != null && !filter.isEmpty()){
			for (Map<String, Object> map : filter) {
				QueryFilter queryFilter = new QueryFilter();
				 List<Map<String, Object>> filter1 = (List<Map<String, Object>>) map.get("criterions");
				 Map<String, Object> map2 = filter1.get(0);
				 queryFilter.setFieldName(map2.get("fieldName").toString());
				 queryFilter.setValue(map2.get("value"));
				 qList.add(queryFilter);
			}
		}
		return qList;
	}
	/**
	 * @buildPageRequest:构建PageRequest
	 * @param queryCondition 查询条件
	 * @return PageRequest 页面请求对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	private PageRequest buildPageRequest(RequestCondition queryCondition) {
		int pageIndex = 1, pageSize = 1;
		if (queryCondition.getPageIndex() != null && queryCondition.getPageSize() != null) {
			pageIndex = queryCondition.getPageIndex();
			pageSize = queryCondition.getPageSize();
		}
		return new PageRequest(pageIndex - 1, pageSize, SorterUtil.sortBy(queryCondition));
	}
	
	
	
	/**
	 * electricianEvaluate
	 * 以下是测试代码
	 */
	
	//@Query(value="select * from order_electrician oe where oe.ELECTRICIAN_ID=?1")
	//public List<OrderElectrician> findByPriceRange
	/**
	 * 待评价按钮
	 */
	@Override
	public List<OrderElectrician> findByElectricianEvaluateIsNullAndOrderElectricianTypeEquals(String orderElectricianType){
		List<OrderElectrician> list=orderElectricianRepository.findByElectricianEvaluateIsNullAndOrderElectricianTypeEquals(orderElectricianType);
		return list;
		
	}
	
	
	/**
	 * 首页--我的订单按钮
	 * electricianId
	 */
	
	@Override
	public List<OrderCustomer> findByOrderStatusOrderByCreateTime(int id1, int id2) {
		// TODO Auto-generated method stub
		List<OrderCustomer> list=orderCustomerRepository.findByOrderStatusOrderByCreateTime( id1,id2);
		return list;
	}
	
	
	@Override
	public List<OrderElectrician> findByElectricianIdAndOrderElectricianTypeEqualsOrderByCreateTime(String electricianId,String orderElectricianType){
		List<OrderElectrician> list=orderElectricianRepository.findByElectricianIdAndOrderElectricianTypeEqualsOrderByCreateTime(electricianId,orderElectricianType);
		return list;
		
	}
	
	/**
	 * 我的订单页面    查询的是当前电工所有的订单+历史订单
	 * 查询未完结的订单
	 */
	
	public List<OrderElectrician> findByElectricianIdAndOrderByCreateTimeAsc(String electricianId){
		
		//List<OrderElectrician> list=orderElectricianRepository.getAllOrderElectricianByElectricianId(pageIndex,pageSize,customerId);
		
		return null;
	}
	@Override
	public List<OrderElectrician> findByElectricianId(String electricianId) {
		// TODO Auto-generated method stub
		List<OrderElectrician> list=orderElectricianRepository.findByElectricianId(electricianId);
		return list;
	}
	
	@Override
	public QueryResultObject queryMore(RequestCondition queryCondition,String electricianId){
		
		if(queryCondition == null){
			throw new NullArgumentException("queryCondition");
		}
		
		Integer pageIndex = queryCondition.getPageIndex()-1;
		Integer pageSize = queryCondition.getPageSize();

		Map<String, String> map = MapUtil.getParam(queryCondition);
		
		List<OrderElectrician> result = orderElectricianRepository.queryMore(pageIndex,pageSize,
				electricianId,map.get("orderElectricianType"));
		long count = 0;
		count = result.size();
		return RestUtils.wrappQueryResult(result, count);
		
	}
	
	
	@Override
	public QueryResultObject queryWaitToDo(RequestCondition queryCondition,String electricianId){
		
		if(queryCondition == null){
			throw new NullArgumentException("queryCondition");
		}
		
		Integer pageIndex = queryCondition.getPageIndex()-1;
		Integer pageSize = queryCondition.getPageSize();

		Map<String, String> map = MapUtil.getParam(queryCondition);
		
		List<OrderElectrician> result = orderElectricianRepository.queryWaitToDo(pageIndex,pageSize,
				electricianId,map.get("orderElectricianType"));
		long count = 0;
		count = result.size();
		return RestUtils.wrappQueryResult(result, count);
		
	}
	@Override
	public QueryResultObject queryMore(RequestCondition requestCondition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public OrderElectrician findByOrDERIdAndOrderElectricianType(String orderId){
		OrderElectrician orderElectrician=orderElectricianRepository.findByOrDERIdAndOrderElectricianType(orderId);
		return orderElectrician;
		
	}
	
	
	@Override
	@Transactional
	public OrderCustomer saveOrderCustomerByOrderElectricianService(Map<String,Object> map,MultipartFile file) throws Exception{
		
		validateService.validateWithException(OrderCustomer.class,map);
		OrderCustomer orderCustomer = new OrderCustomer();
		OrderCustomer result = new OrderCustomer();
		
		
			
			String orderId = (String) map.get("orderId");
			orderCustomer=orderCustomerRepository.findByOrderId(orderId);
			
			/*客户这边不用
			
			//23 电工上传合同（报价）
			if("23".equals(map.get("orderStatus"))){
			//if("23".equals(map.get("orderStatus"))){
				//上传图片
				if (!file.isEmpty()) {
					String fileName = (String) map.get("fileName");
					String iconUrl = FileUtil.uploadFile(file, orderId,"ORDER_CUSTOMER",fileName);
					map.put(fileName, iconUrl);
				}
				
				
				
			}
			*/
			
			
			
			CrudUtils.mapToObject(map, orderCustomer,  "orderId");
			result = orderCustomerRepository.save(orderCustomer);
			sendNotify(map, orderCustomer,2,1);
			
			
		
		return result;
	}
	
	
	
	
	
	
	@Override
	public OrderElectrician saveOrderElectrician(Map<String, Object> map,MultipartFile file) throws Exception {
		System.out.println("要执行保存OrderElectrician方法");
		validateService.validateWithException(OrderElectrician.class,map);
		OrderElectrician orderElectrician = new OrderElectrician();
		OrderElectrician result = new OrderElectrician();
		
			String orderId = (String) map.get("orderId");
			orderElectrician=orderElectricianRepository.findByOrderId(orderId, (String)map.get("electricianId"));
			
			
			
			if("23".equals(map.get("orderElectricianType"))){
				//上传图片
				if (!file.isEmpty()) {
					String orderContract = FileUtil.uploadFile(file, orderElectrician.getOrDERId(),"ORDER_ELECTRICIAN", "orderContract");
					map.put("orderContract", orderContract);
				}
				
				
				
			}
			CrudUtils.mapToObject(map, orderElectrician,  "orderId");
			result = orderElectricianRepository.save(orderElectrician);
			//sendNotify(map, orderElectrician,2,1);
			
			
		/*
			
			//获取Enum通知类
			BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("0", "0");	
			
			//新增流水
			Map<String,Object> mapOrderFlow = 
					MapUtil.flowAdd((String)map.get("orderElectricianType"), 0, 0, (String)map.get("electricianId"), TimeStamp.toString(new Date()), 0,  baseEnums.getEnumsA());
			orderFlowService.saveOrderFlow(mapOrderFlow);
			
			//新增通知
			String announceId = UuidUtil.getUuid32();
			
			Map<String,Object> mapNotify =
					MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", baseEnums.getEnumsB(), baseEnums.getEnumsC(), TimeStamp.toString(new Date()), 
							"2",(String)map.get("orderElectricianType"),"");
			notifyAnnounceService.saveNotifyAnnounce(mapNotify);
			
			Map<String,Object> mapNotifyUser = 
					MapUtil.notifyUserAdd((String)map.get("electricianId"), announceId, 1, 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
			notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);
			*/	
			
			//发送websocket消息
	      
	        WebSocketServer.sendInfo("下单成功",(String)map.get("electricianId"));
		return result;
	}

	
	
	@Override
	public OrderElectrician findByOrderId(String orderId,String orderelectriciantype) {
		
		// TODO Auto-generated method stub
		OrderElectrician orderIdString=orderElectricianRepository.findByOrderId(orderId,orderelectriciantype);
		return orderIdString;
	}
	
	@Override
public QueryResultObject queryAllDoing(String electricianId) {
	List<OrderElectrician> result=orderElectricianRepository.queryAllDoing(electricianId);
	long count=0;
	count=result.size();
	return RestUtils.wrappQueryResult(result,count);
	
	
}
	/**
	 * 保存电工提交的评价信息
	 */
	@Override
	public Object saveElectricianEvaluate(Map<String, Object> map, MultipartFile file){
		OrderElectrician result=null;
		try {
			
		
		//logger.info("OrderCustomerService saveOrderCustomer map = " +map); 
		validateService.validateWithException(OrderElectrician.class,map);
		
		
		//修改订单的状态
		OrderElectrician orderElectrician=new OrderElectrician();
		result=new OrderElectrician();
		CrudUtils.transMap2Bean(map, orderElectrician);
	
		String getNewOrderId =orderElectrician.getOrDERId();
			//上传图片
			if (!file.isEmpty()) {
				String electrician_descrive_icon = FileUtil.uploadFile(file, getNewOrderId,"ORDER_ELECTRICIAN", "ELECTRICIAN_DESCRIVE_ICON");
				map.put("ELECTRICIAN_DESCRIVE_ICON", electrician_descrive_icon);
			}
			
			//新增order
		
			//电工评价后将状态置9
			map.put("orderElectricianType", 9);
			
			map.put("finishTime", DateTimeUtil.formatDateTime(new Date()));
			
			result = orderElectricianRepository.save(orderElectrician);
			
			//获取Enum通知类
			BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("20", "1");	
			
			//新增流水
			Map<String,Object> mapOrderFlow = 
					MapUtil.flowAdd(getNewOrderId, 0, 0, (String)map.get("electricianId"), TimeStamp.toString(new Date()), 0,  baseEnums.getEnumsA());
			orderFlowService.saveOrderFlow(mapOrderFlow);
			
			//新增通知
			String announceId = UuidUtil.getUuid32();
			
			String status=(String) map.get("orderStatus");
			String notifyType="1";
			if ("23".equals(status)) {
				notifyType="2";
				
			}else if ("24".equals(status)) {
				notifyType="3";
			}else if ("8".equals(status)) {
				notifyType="4";
			}
			
			Map<String,Object> mapNotify =
					MapUtil.notifyAdd(announceId, (String)map.get("electricianId"), baseEnums.getEnumsB(), baseEnums.getEnumsC(), TimeStamp.toString(new Date()),
							notifyType,orderElectrician.getOrDERId(),getNewOrderId);
			notifyAnnounceService.saveNotifyAnnounce(mapNotify);
			
			Map<String,Object> mapNotifyUser = 
					MapUtil.notifyUserAdd((String)map.get("electricianId"), announceId, 0, 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
			notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);	
			
			//发送websocket消息
			//WebSocketServer.sendInfo("下单成功",(String)map.get("electricianId"));
		

		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
		
	}
	
	/**
	 * @param map
	 * @param orderCustomer
	 * @param oper 0增 1删 2改
	 * @param getPeople 1客户 2电工 
	 * @throws Exception
	 */
	private void sendNotify(Map map,OrderElectrician orderElectrician,int oper,int getPeople) throws Exception{
		String status =(String)map.get("orderStatus");
		//1维修 2支付 3验收 4评价
		String notifyType ="1";
		if("23".equals(status)){
			notifyType ="2";
		}else if("24".equals(status)){
			notifyType ="3";
		}else if("8".equals(status)){
			notifyType ="4";
		}
		
		//获取Enum通知类
		BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("0",  status);	
		
		//新增流水
		Map<String,Object> mapOrderFlow = 
				MapUtil.flowAdd(orderElectrician.getOrDERId(), 0,  Integer.parseInt(status), orderElectrician.getElectricianId(), TimeStamp.toString(new Date()), oper,  baseEnums.getEnumsA());
		orderFlowService.saveOrderFlow(mapOrderFlow);
		
		//新增通知
		String announceId = UuidUtil.getUuid32();
		
		Map<String,Object> mapNotify =
				MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", baseEnums.getEnumsB(), baseEnums.getEnumsC(), TimeStamp.toString(new Date()), 
						notifyType,orderElectrician.getOrDERId(),"");
		notifyAnnounceService.saveNotifyAnnounce(mapNotify);
		
		Map<String,Object> mapNotifyUser = 
				MapUtil.notifyUserAdd(orderElectrician.getElectricianId(), announceId, getPeople, 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
		notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);
		
		//发送websocket消息
		//WebSocketServer.sendInfo("下单成功",(String)map.get("electricianId"));
	}
	@Override
	public OrderElectrician findByOrderId(String orderId) {
		// TODO Auto-generated method stub
		//orderElectricianRepository.findByOrderId(orderId)
		return null;
	}
	
	/**
	 * 通过保存custromer
	 * @param map
	 * @param file
	 * @return
	 * @throws Exception
	 * 
	 */
	
	/**
	 * 1.  要是预约的话就只会给更改客户订单信息中的预约时间
	 */

	
	
	private Map<String,Object> orderStatus(Map map,OrderElectrician orderElectrician) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		
		String orderStatus = (String) map.get("orderStatus");
		
		if("4".equals(orderStatus)){
	        ArrayList<String> sites = new ArrayList<>();
	        sites.add("0");
	        sites.add("1");
	        sites.add("11");
			//用户主动取消订单，只有在状态为0,1,11 时可以取消
			if(sites.contains(orderElectrician.getOrderElectricianType())){
				String dateString = TimeStamp.toString(new Date());
				map.put("updateTime", dateString);
				map.put("finishTime", dateString);
				result.put("key", "0");
				result.put("desc", "该订单处于可取消状态");
				result.put("map", map);
			}else{
				result.put("key", "1");
				result.put("desc", "该订单不处于可取消状态");
			}
		}else if("8".equals(orderStatus)){
			ArrayList<String> sites = new ArrayList<>();
	        sites.add("24"); //待用户验收
			if(sites.contains(orderElectrician.getOrderElectricianType())){
				String dateString = TimeStamp.toString(new Date());
				map.put("updateTime", dateString);
				result.put("key", "0");
				result.put("desc", "该订单处于可验收状态");
				result.put("map", map);
			}else{
				result.put("key", "1");
				result.put("desc", "该订单不处于可验收状态");
			}
		}else if("9".equals(orderStatus)){
			ArrayList<String> sites = new ArrayList<>();
	        sites.add("8"); //待用户评价
			if(sites.contains(orderElectrician.getOrderElectricianType())){
				String dateString = TimeStamp.toString(new Date());
				map.put("updateTime", dateString);
				map.put("finishTime", dateString);
				result.put("key", "0");
				result.put("desc", "该订单处于待评价状态");
				result.put("map", map);
			}else if ("21".equals(orderStatus)) {
				
			}
			
			else{
				result.put("key", "1");
				result.put("desc", "该订单不处于待评价状态");
			}
		}
		
		return result;
	}
	
	/**
	 * @param map
	 * @param orderCustomer
	 * @param oper 0增 1删 2改
	 * @param getPeople 1客户 2电工 
	 * @throws Exception
	 */
	private void sendNotify(Map map,OrderCustomer orderCustomer,int oper,int getPeople) throws Exception{
		String status =(String)map.get("orderStatus");
		//1维修 2支付 3验收 4评价
		String notifyType ="1";
		if("23".equals(status)){
			notifyType ="2";
		}else if("24".equals(status)){
			notifyType ="3";
		}else if("8".equals(status)){
			notifyType ="4";
		}
		
		//获取Enum通知类
		BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("0",  status);	
		
		//新增流水
		Map<String,Object> mapOrderFlow = 
				MapUtil.flowAdd(orderCustomer.getOrderId(), 0,  Integer.parseInt(status), orderCustomer.getCustomerId(), TimeStamp.toString(new Date()), oper,  baseEnums.getEnumsA());
		orderFlowService.saveOrderFlow(mapOrderFlow);
		
		//新增通知
		String announceId = UuidUtil.getUuid32();
		
		Map<String,Object> mapNotify =
				MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", baseEnums.getEnumsB(), baseEnums.getEnumsC(), TimeStamp.toString(new Date()), 
						notifyType,orderCustomer.getOrderId(),"");
		notifyAnnounceService.saveNotifyAnnounce(mapNotify);
		
		Map<String,Object> mapNotifyUser = 
				MapUtil.notifyUserAdd(orderCustomer.getCustomerId(), announceId, getPeople, 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
		notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);
		
		//发送websocket消息
		//WebSocketServer.sendInfo("下单成功",(String)map.get("electricianId"));
	}
	
	private String getPrice(String identityId,String provinceId){
		//获取身份价格
		QueryResultObject getBaseIdentityPrice = baseIdentityPriceService.getBaseIdentityPriceByIdentityId(identityId);
		BaseIdentityPrice baseIdentityPrice = (BaseIdentityPrice) (getBaseIdentityPrice.getItems().get(0));
		String identityPrice = baseIdentityPrice.getIdentityPrice();
		
		//获取省份价格
		List<BaseAreaPrice> list = baseAreaPriceService.getBaseAreaPriceByProvinceId(provinceId);
		String areaPrice = list.get(0).getPrice();
		
		BigDecimal identityPriceBD=new BigDecimal(identityPrice);
		BigDecimal areaPriceBD=new BigDecimal(areaPrice);
		String resultBD = DecimalUtil.add(identityPriceBD,areaPriceBD).toString();
		
		return resultBD;
	}
	@Override
	public List<OrderElectrician> findByOrderIdAndOrderElectricianTypeOrderByFinishTimeDesc(String orderId,
			String orderElectricianType) {
		// TODO Auto-generated method stub
		List<OrderElectrician> list=orderElectricianRepository.findByOrderIdAndOrderElectricianTypeOrderByFinishTimeDesc(orderId,orderElectricianType);
		return list;
	}
	
	/**
	 * 根据电工ID和订单ID查询出一个电工订单
	 */
	public OrderElectrician findByElectricianIdAndOrderId(String electricianId, String orderId){
		OrderElectrician orderElectrician=orderElectricianRepository.findByElectricianIdAndOrderId(electricianId,orderId);
		return orderElectrician;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}

	
	
	
	
	
	
	
	
	
	
	
	

