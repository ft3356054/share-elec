package com.sgcc.uap.share.electrician.services.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.rest.utils.CrudUtils;
import com.sgcc.uap.rest.utils.RestUtils;
import com.sgcc.uap.share.controller.WebSocket;
import com.sgcc.uap.share.controller.WebSocketServer;
import com.sgcc.uap.share.customer.bo.OrderCustomerMoreVO;
import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;
import com.sgcc.uap.share.customer.services.impl.CustPositionService;
import com.sgcc.uap.share.customer.services.impl.OrderCustomerService;
import com.sgcc.uap.share.customer.services.impl.OrderFlowService;
import com.sgcc.uap.share.customer.vo.OrderCustomerVO;
import com.sgcc.uap.share.domain.BaseAreaPrice;
import com.sgcc.uap.share.domain.BaseEnums;
import com.sgcc.uap.share.domain.BaseIdentityPrice;
import com.sgcc.uap.share.domain.CustPosition;
import com.sgcc.uap.share.domain.ElecPosition;
import com.sgcc.uap.share.domain.ElectricianCompanyInfo;
import com.sgcc.uap.share.domain.ElectricianInfo;
import com.sgcc.uap.share.domain.ElectricianSubCompanyInfo;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.domain.OrderElectricianHis;
import com.sgcc.uap.share.electrician.bo.OrderElectricianBeginPageVO;
import com.sgcc.uap.share.electrician.controller.OrderElectricianController;
import com.sgcc.uap.share.electrician.repositories.OrderElectricianRepository;
import com.sgcc.uap.share.electrician.services.IOrderElectricianService;
import com.sgcc.uap.share.electrician.vo.OrderElectricianVO;
import com.sgcc.uap.share.repositories.OrderCustomerMoreVORepository;
import com.sgcc.uap.share.services.impl.BaseAreaPriceService;
import com.sgcc.uap.share.services.impl.BaseEnumsService;
import com.sgcc.uap.share.services.impl.BaseIdentityPriceService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceUserService;
import com.sgcc.uap.util.DateTimeUtil;
import com.sgcc.uap.util.DecimalUtil;
import com.sgcc.uap.util.FileUtil;
import com.sgcc.uap.util.JsonUtils;
import com.sgcc.uap.util.MapGetValueUtil;
import com.sgcc.uap.util.MapUtil;
import com.sgcc.uap.util.PointUtil;
import com.sgcc.uap.util.SorterUtil;
import com.sgcc.uap.util.TimeStamp;
import com.sgcc.uap.util.UuidUtil;
import com.sgcc.uap.utils.string.StringUtil;

import groovy.util.logging.Log4j;


@Service
public class OrderElectricianService implements IOrderElectricianService{
	/** 
     * 注入orderElectricianRepository
     */
	
	//private final static Logger logger = (Logger) LoggerFactory.getLogger(OrderCustomerService.class);
	
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(OrderElectricianService.class);

	
	
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
	
	@Autowired
	private CustPositionService custPositionService;
	
	@Autowired
	private OrderCustomerService orderCustomerService;
	
	@Autowired
	private ElectricianSubCompanyInfoService electricianSubCompanyInfoService;
	
	@Autowired
	private ElecPositionService elecPositionService;
	
	@Autowired
	private OrderCustomerMoreVORepository orderCustomerMoreVORepository;
	 
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
			map.put("orderElectricianStatus", "2");
			map.put("payStatus", 1);//TODO  还没有确认订单的状态
			map.put("createTime", DateTimeUtil.formatDateTime(new Date()));
			map.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
			map.put("finishTime", DateTimeUtil.formatDateTime(new Date()));
			
			
			CrudUtils.transMap2Bean(map, orderElectrician);
			result = orderElectricianRepository.save(orderElectrician);
			System.out.println("我执行完了新增电工订单");
			System.out.println("");
		
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
		
		QueryFilter queryFilter = qList.get(0);
		String fieldName = queryFilter.getFieldName();

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
	 * 待评价按钮
	 */
	@Override
	public List<OrderElectrician> findByElectricianEvaluateIsNullAndOrderElectricianStatusEquals(String orderElectricianStatus){
		List<OrderElectrician> list=orderElectricianRepository.findByElectricianEvaluateIsNullAndOrderElectricianStatusEquals(orderElectricianStatus);
		return list;		
	}

	@Override
	public List<OrderElectrician> findByElectricianIdAndOrderElectricianStatusEqualsOrderByCreateTime(String electricianId,String orderElectricianStatus){
		List<OrderElectrician> list=orderElectricianRepository.findByElectricianIdAndorderElectricianStatusEqualsOrderByCreateTime(electricianId,orderElectricianStatus);
		return list;	
	}

	@Override
	public List<OrderElectrician> findByElectricianId(String electricianId) {
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
		
		String orderElectricianStatus=map.get("orderElectricianStatus");
		List<OrderElectrician> result = orderElectricianRepository.queryMore(pageIndex,pageSize,
				electricianId,orderElectricianStatus);
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
				electricianId,map.get("orderElectricianStatus"));
		long count = 0;
		count = result.size();
		return RestUtils.wrappQueryResult(result, count);
		
	}	
	@Override
	public OrderElectrician findByOrDERIdAndOrderElectricianStatus(String orderId,String orderElectricianEtatus){
		OrderElectrician orderElectrician=orderElectricianRepository.findByOrDERIdAndOrderElectricianStatus(orderId,orderElectricianEtatus);
		return orderElectrician;		
	}
	
	@Override
	@Transactional
	public OrderCustomer saveOrderCustomerByOrderElectricianService(Map<String,Object> map) throws Exception{
		
		validateService.validateWithException(OrderCustomer.class,map);
		OrderCustomer orderCustomer = new OrderCustomer();
		OrderCustomer result = new OrderCustomer();
	
			String orderId = (String) map.get("orderId");
			orderCustomer=orderCustomerRepository.findByOrderId(orderId);
	
			CrudUtils.mapToObject(map, orderCustomer,  "orderId");
			result = orderCustomerRepository.save(orderCustomer);
			
		return result;
	}

	@Override
	public OrderElectrician saveOrderElectrician(Map<String, Object> map,MultipartFile file) throws Exception {
		
		validateService.validateWithException(OrderElectrician.class,map);
		OrderElectrician orderElectrician = new OrderElectrician();
		OrderElectrician result = new OrderElectrician();
		
			String orderId = (String) map.get("orderId");
			String electricianId =(String) map.get("electricianId");
			orderElectrician=orderElectricianRepository.findByElectricianIdAndOrderId(electricianId,orderId);
			
			if("23".equals(map.get("orderElectricianStatus"))){
				//上传图片
				if  (null!=file&&!"".equals(file))  {
					String orderContract = FileUtil.uploadFile(file, orderElectrician.getOrDERId(),"ORDER_ELECTRICIAN", "orderContract");
					map.put("orderContract", orderContract);
				}
				
			}else if ("25".equals(map.get("orderElectricianStatus"))) {//8状态说明是验收状态页面要进行验收，需要保存图片
				
				//上传图片
				if (null!=file&&!"".equals(file))  {
					String inspectionReport = FileUtil.uploadFile(file, orderElectrician.getOrDERId(),"ORDER_ELECTRICIAN", "inspectionReport");
					map.put("inspectionReport", inspectionReport);
				}
				
			}
			CrudUtils.mapToObject(map, orderElectrician,  "orderId");
			result = orderElectricianRepository.save(orderElectrician);
			
			if ((String)map.get("orderElectricianStatus")!=null) {
				sendNotify(map, orderElectrician,2,1);
			}

	        WebSocketServer.sendInfo("下单成功",(String)map.get("electricianId"));
	       
		return result;
	}
	
	@Override
	public OrderElectrician saveOrderElectrician(Map<String, Object> map) throws Exception {
		validateService.validateWithException(OrderElectrician.class,map);
		OrderElectrician orderElectrician = new OrderElectrician();
		OrderElectrician result = new OrderElectrician();
		
			String orderId = (String) map.get("orderId");			
			CrudUtils.mapToObject(map, orderElectrician,  "orderId");
			result = orderElectricianRepository.save(orderElectrician);
			
			return result;		
	}

	@Override
	public OrderElectrician findByOrderId(String orderId,String electricianId) {
		
		OrderElectrician orderIdString=orderElectricianRepository.findByElectricianIdAndOrderId(orderId,electricianId);
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
			map.put("orderElectricianStatus", 9);			
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
	 */
	
	public void sendNotify(Map map,OrderElectrician orderElectrician,int oper,int getPeople){
		String orderElectricianStatus =(String)map.get("orderElectricianStatus");
		//1维修 2支付 3验收 4评价
		String notifyType ="1";
		if("23".equals(orderElectricianStatus)){
			notifyType ="2";
		}else if("24".equals(orderElectricianStatus)){
			notifyType ="3";
		}else if("8".equals(orderElectricianStatus)){
			notifyType ="4";
		}
		
		//获取Enum通知类
		BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("1",  orderElectricianStatus);	
		
		
		String orderId=orderElectrician.getOrDERId();
		String electricianId=orderElectrician.getElectricianId();
		String EnumsA=baseEnums.getEnumsA();
		
		try {
			
		
		//如果状态是1,3,4,22则让客户那边自己插入流水
		if (!orderElectricianStatus.equals("1") ||(!orderElectricianStatus.equals("3") ||(!orderElectricianStatus.equals("4") ||(!orderElectricianStatus.equals("22")))) ) {
			
			//新增流水
			Map<String,Object> mapOrderFlow = 
					MapUtil.flowAdd(orderId, 1,  Integer.parseInt(orderElectricianStatus), electricianId, TimeStamp.toString(new Date()), oper,EnumsA);
			orderFlowService.saveOrderFlow(mapOrderFlow);
		}
		
		
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
		String messageString=new String();
		if (map.get("orderElectricianStatus").equals("9")) {
			messageString="订单已经完成";
		}else if (map.get("orderElectricianStatus").equals("8")) {
			messageString="要进行验收申请";
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//WebSocketServer.sendInfo(messageString,(String)map.get("electricianId"));
	}

	
	@Override
	public List<OrderElectrician> findByOrderIdAndOrderElectricianStatusOrderByFinishTimeDesc(String orderId,
			String orderElectricianStatus) {
		// TODO Auto-generated method stub
		List<OrderElectrician> list=orderElectricianRepository.findByOrderIdAndOrderElectricianStatusOrderByFinishTimeDesc(orderId,orderElectricianStatus);
		return list;
	}
	
	/**
	 * 根据电工ID和订单ID查询出一个电工订单
	 */
	public OrderElectrician findByElectricianIdAndOrderId(String electricianId, String orderId){
		OrderElectrician orderElectrician=orderElectricianRepository.findByElectricianIdAndOrderId(electricianId,orderId);
		return orderElectrician;
		
	}
	@Override
	public QueryResultObject queryAllHaveEsc(String electricianId) {
		// TODO Auto-generated method stub
		List<OrderElectrician> result=orderElectricianRepository.queryAllHaveEsc(electricianId);
		long count=0;
		count=result.size();
		return RestUtils.wrappQueryResult(result,count);
		
	}
	
	
	/**
	 * 派单查询，是给一个人进行展示
	 * @throws Exception 
	 */
	@Override
	public void paidanchaxun(OrderCustomer orderCustomer){
		
		//根据客户orderId获取其地区ID
		//根据地区ID查询所属地区的电力子公司
		//然后再查询电力子公司下距离最近的电工
		//将 查询查询出来的信息放入到websocket
		
		try {
			
		
		String orderId=orderCustomer.getOrderId();
		
		//1.获取客户的位置信息
		CustPosition custPosition=custPositionService.findByOrderId(orderId);
		String areaId=custPosition.getAreaId();
		
		//2.根据客户区域ID查询此区域的子公司的集合
		List<ElectricianSubCompanyInfo>  electricianSubCompanyInfoList=electricianSubCompanyInfoService.findByCompanyAreaId(areaId);
		
		ElectricianSubCompanyInfo electricianSubCompanyInfo=null;
		if (electricianSubCompanyInfoList.size()>1) {//说明有多个电力子公司
			
			//判断哪个电力子公司距离最近			
			Map<Double, ElectricianSubCompanyInfo> map = new TreeMap<Double, ElectricianSubCompanyInfo>(
	                new Comparator<Double>() {
	                    public int compare(Double obj1, Double obj2) {
	                        // 降序排序
	                        return obj1.compareTo(obj2);
	                    }
	                });
	
			Double distanceDouble=null;	
			
			for (ElectricianSubCompanyInfo electricianSubCompanyInfo1 : electricianSubCompanyInfoList) {
				
				//获取订单 的位置,即经纬度，进行对比
				String electricianSubCompanyInfoLon=electricianSubCompanyInfo1.getAddressLongitude();
				String electricianSubCompanyInfoLat=electricianSubCompanyInfo1.getAddressLatitude();
				
				
				distanceDouble=PointUtil.getDistanceString(String.valueOf(custPosition.getLon()), String.valueOf(custPosition.getLat()), electricianSubCompanyInfoLon, electricianSubCompanyInfoLat);
				System.out.println("计算的距离是："+distanceDouble);
				map.put(distanceDouble, electricianSubCompanyInfo1);	
			}
			electricianSubCompanyInfo=MapGetValueUtil.getFirstOrNull(map);			
		}else {//说明有一个电力子公司
			electricianSubCompanyInfo=electricianSubCompanyInfoList.get(0);
		}		
		ElectricianInfo electricianInfo=null;
		//根据查询出来的电力子公司名字查询旗下所属的电工
		String companyName=electricianSubCompanyInfo.getCompanyName();
		
		List<ElectricianInfo> electricianInfoList=electricianInfoService.findBycompanyName(companyName);
		
		Map<Double, ElectricianInfo> map = new TreeMap<Double, ElectricianInfo>(
	            new Comparator<Double>() {
	                public int compare(Double obj1, Double obj2) {
	                    // 降序排序
	                    return obj1.compareTo(obj2);
	                }
	            });
		
		Double distanceDouble=null;
		
		if (electricianInfoList.size()>1) {
			for (ElectricianInfo electricianInfo2 : electricianInfoList) {
				
				//获取订单 的位置,即经纬度，进行对比
				String electricianInfoLon=electricianInfo2.getAddressLongitude();
				String electricianInfoLat=electricianInfo2.getAddressLatitude();

				distanceDouble=PointUtil.getDistanceString(String.valueOf(custPosition.getLon()), String.valueOf(custPosition.getLat()), electricianInfoLon, electricianInfoLat);
				System.out.println("计算的距离是："+distanceDouble);
				map.put(distanceDouble, electricianInfo2);
				
			}
			electricianInfo=getFirstElectricianInfo(map);
			
		}else {
			electricianInfo=electricianInfoList.get(0);
						
		}
				
		String electricianId=electricianInfo.getElectricianId();
		OrderElectrician orderElectrician=saveNewOrderElectrician(orderId,electricianId);
		
		//改变主订单客户订单的状态是20
		orderCustomer.setOrderStatus("20");
		Map<String, Object> nesMap=new HashMap<>();
		nesMap=CrudUtils.objectToMap(orderCustomer);
		saveOrderCustomerByOrderElectricianService(nesMap);
		
		WebSocketServer.sendInfo(JsonUtils.objToJson(orderElectrician),(String)electricianInfo.getElectricianId());

	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		String errorMessage = "查询异常";
		
	}	
	}
	
	@Override
	public OrderElectrician saveNewOrderElectrician(String orderId,String electricianId){
		
		try {
	
		OrderElectrician saveOrderElectrician=null;
		
		
		//新的客户订单
		OrderCustomer orderCustomer=new OrderCustomer();
		//新的电工订单
		OrderElectrician orderElectrician=new OrderElectrician();
		//查询出的当前电工信息
		ElectricianInfo electricianInfo=electricianInfoService.findInfo(electricianId);
		
		Map<String,Object> map=new HashMap<String, Object>();
	
		//1.查询出来客户表		
		OrderCustomer orderCustomer2=orderCustomerService.findByOrderId(orderId);
		
		
		//2.判断客户表是否是新表
		if(orderCustomer2.getOrderStatus().equals("11")){
			//2.1电工接单的单子是11，说明是老单子设置客户订单表单状态为2，只需要将电工的填写的信息挪到新的电工订单就好
			List<OrderElectrician> orderElectricianOlds=findByOrderIdAndOrderElectricianStatusOrderByFinishTimeDesc(orderId,"5");
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
		//0 表示电工已经接单，
		map.put("orderElectricianStatus","0");
		map.put("payStatus",orderCustomer.getPayStatus());
		map.put("createTime",DateTimeUtil.formatDateTime(new Date()));
		map.put("orderTypeId", orderCustomer2.getOrderTypeId());
		
		map.put("orDERId",orderId);
		map.put("orderId", orderId);
		saveOrderElectrician = saveOrderElectrician(map);
		
		//电工接单成功，就发送给客户消息
		sendNotify(map, orderElectrician, 0, 1);
		WebSocketServer.sendInfo("电工已接单",(String)orderCustomer2.getCustomerId());
		return saveOrderElectrician;
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";
			return null;
		}
		
	}
	
	
	
	
	/**
	 * 进行抢单弹窗功能接口
	 * @param map
	 * @return
	 */
	
	@Override
	public void qiangdantanchuang(OrderCustomer orderCustomer){
		
		//1.通过orderID查询客户的区域ID
		//2.根据查询出来的区域ID查询此区域内的全部电工
		//3.创建子订单，向集合的电工发布消息
		String orderId=orderCustomer.getOrderId();
		
		try {
			
		
		//1.通过orderID查询客户的区域ID
		CustPosition custPosition=custPositionService.findByOrderId(orderId);
		String areaId=custPosition.getAreaId();
		
		//2.根据查询出来的区域ID查询此区域内的全部电工
		List<ElecPosition> elecPositionList=elecPositionService.findByAreaId(areaId);
		
		//此集合用于存放在线状态的电工
		List<ElecPosition> elecPositions=new ArrayList<ElecPosition>();
		
		
		//根据客户的区域ID得到电工的区域范围
		double[] around=PointUtil.getAround(Double.valueOf(custPosition.getLon()), Double.valueOf(custPosition.getLat()), 100000);
		
		//3.循环查询电工状态，留下 【 范围内】  【 在线状态】    的电工
		for (ElecPosition elecPosition : elecPositionList) {
			//3.1 根据电工的ID查询电工信息
			String electricianId=elecPosition.getElectricianId();
			
			ElectricianInfo electricianInfo=electricianInfoService.findInfo(electricianId);
		
			if (electricianInfo.getElectricianStatus().equals("1")) {  //如果电工的状态是1,则代表电工在线
				if (Double.valueOf(elecPosition.getLon())>around[0] && Double.valueOf(elecPosition.getLon())<around[2] && Double.valueOf(elecPosition.getLat())>around[1] && Double.valueOf(elecPosition.getLat())<around[3]){
					
					//3.2获取到了范围内的可以接单的电工
						elecPositions.add(elecPosition);   
					
			}
		}
		}
		
		//4.创建一个电工子订单，然后将子订单po转化成VO	
			OrderElectrician orderElectrician=saveNewNullOrderElectrician(orderId);
			OrderElectricianVO orderElectricianVO=new OrderElectricianVO();
			BeanUtils.copyProperties(orderElectrician, orderElectricianVO);
		
			Double distanceDouble=null;
			
		if (elecPositions.size()==0) {
			
		}else if (elecPositions.size()==1) {
			//获取电工与客户之间的距离
			distanceDouble=PointUtil.getDistanceString(String.valueOf(elecPositions.get(0).getLon()), String.valueOf(elecPositions.get(0).getLat()), custPosition.getLon(), custPosition.getLat());
			orderElectricianVO.setDistance(String.valueOf(distanceDouble));
			
			WebSocketServer.sendInfo(JsonUtils.objToJson(orderElectricianVO),(String)elecPositions.get(0).getElectricianId());
			
		}else {//表明有多个电工
			for (ElecPosition elecPosition1 : elecPositions) {
				distanceDouble=PointUtil.getDistanceString(String.valueOf(elecPosition1.getLon()), String.valueOf(elecPosition1.getLat()), custPosition.getLon(), custPosition.getLat());
				orderElectricianVO.setDistance(String.valueOf(distanceDouble));
				
				WebSocketServer.sendInfo(JsonUtils.objToJson(orderElectricianVO),(String)elecPosition1.getElectricianId());
				
			}
			
				
			}
		System.out.println("我执行完了");
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			String errorMessage = "查询异常";			
		}
	}
	

	public static ElectricianInfo getFirstElectricianInfo(Map<Double, ElectricianInfo> map) {
		ElectricianInfo obj = null;
	    for (Entry<Double, ElectricianInfo> entry : map.entrySet()) {
	        obj = entry.getValue();
	        if (obj != null) {
	            break;
	        }
	    }
	    return  obj;
	}
	
	
	
	/**
	 * 创建一个没有电工信息的电工子订单
	 */
	
	@Override
	public OrderElectrician saveNewNullOrderElectrician(String orderId) throws Exception{
		
		OrderElectrician saveOrderElectrician=null;
				
		//新的客户订单
		OrderCustomer orderCustomer=new OrderCustomer();
		//新的电工订单
		OrderElectrician orderElectrician=new OrderElectrician();
				
		Map<String,Object> map=new HashMap<String, Object>();
	
		//1.查询出来客户表
		OrderCustomer orderCustomer2=orderCustomerService.findByOrderId(orderId);
				
		//2.判断客户表是否是新表
		if(orderCustomer2.getOrderStatus().equals("11")){
			//2.1电工接单的单子是11，说明是老单子设置客户订单表单状态为2，只需要将电工的填写的信息挪到新的电工订单就好
			List<OrderElectrician> orderElectricianOlds=findByOrderIdAndOrderElectricianStatusOrderByFinishTimeDesc(orderId,"5");
			OrderElectrician orderElectricianOld=orderElectricianOlds.get(0);
			//电工描述
			map.put("electricianDescrive", orderElectricianOld.getElectricianDescrive());
			//电工拍照
			map.put("electricianDescriveIcon", orderElectricianOld.getElectricianDescriveIcon());
						
		}
		map.put("orderElectricianId",UuidUtil.getUuid32());
		
		map.put("electricianAddress",null);
		map.put("otherElectricianId",null);
		map.put("orderTypeId",null);
		map.put("electricianPrice",null);
		map.put("orderElectricianStatus","20");
		map.put("payStatus",orderCustomer.getPayStatus());
		map.put("createTime",DateTimeUtil.formatDateTime(new Date()));
		
		map.put("orDERId",orderId);
		map.put("orderId", orderId);
		saveOrderElectrician = saveOrderElectrician(map);
				
		return saveOrderElectrician;
		
	}
	@Override
	public void esc(String orderElectricianId, String orderElectricianStatus) {
				//能进来说明状态应该是5
		try {
			
			Timestamp nowDate =new Timestamp(System.currentTimeMillis());
			String nowString = TimeStamp.toString(new Date());
		
		OrderElectrician orderElectrician=findByOrderElectricianId(orderElectricianId);
	
		
			orderElectrician.setUpdateTime(nowDate);
			orderElectrician.setFinishTime(nowDate);
		
		orderElectrician.setOrderElectricianStatus(orderElectricianStatus);
		orderElectricianRepository.save(orderElectrician);				
		
		Map<String, Object> map=new HashMap<>();
	
								
		
			map.put("orderElectricianStatus", orderElectricianStatus);
			sendNotify(map, orderElectrician, 1, 2);
			WebSocketServer.sendInfo("用户取消付款",(String)orderElectrician.getElectricianId());
		
						
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	private OrderElectrician findByOrderElectricianId(String orderElectricianId) {
		OrderElectrician orderElectrician=orderElectricianRepository.findByOrderElectricianId(orderElectricianId);
		return orderElectrician;
	}
	@Override
	public QueryResultObject searchBox(String electricianId, String searchContent) {
		//如果搜索字段包含10kv或220v
		List<OrderCustomerMoreVO> OrderCustomerMoreVOs=new ArrayList<>();
		if (searchContent.contains("10kv") || searchContent.contains("220v")) {
			OrderCustomerMoreVOs=orderCustomerMoreVORepository.searchVOLTAGE(electricianId, searchContent);
			}else {
				OrderCustomerMoreVOs=orderCustomerMoreVORepository.searchDescrive(electricianId,searchContent);
		}
		
		return RestUtils.wrappQueryResult(OrderCustomerMoreVOs);
	}
	
	
	/**
	 * 计算客户和电工之间的距离
	 * @param orderCustomer
	 * @param orderElectrician
	 * @return
	 */
	public String jisuanjuli(OrderCustomer orderCustomer,OrderElectrician orderElectrician){
		ElecPosition elecPosition=elecPositionService.getElecPositionByElectricianId(orderElectrician.getElectricianId());
		String lon=elecPosition.getLon();
		String electricianInfoLat=elecPosition.getLat();
		
		
		
		double distanceDouble = PointUtil.getDistanceString(String.valueOf(lon), String.valueOf(electricianInfoLat), orderCustomer.getAddressLongitude(), orderCustomer.getAddressLatitude());
		System.out.println("计算的距离是："+distanceDouble);
		String distanceString=String.valueOf(distanceDouble)+"KM";
		
		return distanceString;
	}
	

	/**
	 * 发送流水
	 * @param map
	 * @param orderCustomer
	 * @param oper 0增 1删 2改
	 * @param getPeople 1客户 2电工 
	 * @throws Exception
	 */
	public void sendOederFlow(OrderElectrician orderElectrician,int oper){
		
		try {
			
		
		String status =(String)orderElectrician.getOrderElectricianStatus();
		//1维修 2支付 3验收 4评价
		
		
		
		//获取Enum通知类
				BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("1",  status);	
				
				//新增流水
				Map<String,Object> mapOrderFlow = 
						MapUtil.flowAdd(orderElectrician.getOrDERId(), 0,  Integer.parseInt(status), orderElectrician.getElectricianId(), TimeStamp.toString(new Date()), oper,  baseEnums.getEnumsA());
				orderFlowService.saveOrderFlow(mapOrderFlow);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	/**
	 * 用于将javabean转换成Map
	 */

public Map<String, Object> pojo2Map(Object obj)  { 
	try{
	if (obj == null) {
		 return null;
		 }
		 Map<String, Object> map = new HashMap<String, Object>();
		 BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		 PropertyDescriptor[] propertyDescriptors = beanInfo
		  .getPropertyDescriptors();
		 for (PropertyDescriptor property : propertyDescriptors) {
		 String key = property.getName();
		 if (key.compareToIgnoreCase("class") == 0) {
		  continue;
		 }
		 Method getter = property.getReadMethod();
		 Object value = getter != null ? getter.invoke(obj) : null;
		 map.put(key, value);
		 }
		 return map;
 
	}catch (Exception e) {
		// TODO: handle exception
		return null;
	}

	
}	

public OrderElectricianBeginPageVO convert(OrderCustomer orderCustomer,OrderElectrician orderElectrician){
	OrderElectricianBeginPageVO orderCustomerVO=new OrderElectricianBeginPageVO();
	BeanUtils.copyProperties(orderCustomer, orderCustomerVO);
	orderCustomerVO.setElectricianDescrive(orderElectrician.getElectricianDescrive());
	orderCustomerVO.setChargeback_reason(orderElectrician.getChargebackReason());
	orderCustomerVO.setConstructionContent(orderElectrician.getChargebackReason());
	orderCustomerVO.setOrderElectricianId(orderElectrician.getElectricianId());
	return orderCustomerVO;
}
public List<OrderElectrician> findqQueryAllHaveDone(String electricianId) {
	List<OrderElectrician> list=orderElectricianRepository.findqQueryAllHaveDone(electricianId);
	return list;
}
}
	
	
	
	
	
	

