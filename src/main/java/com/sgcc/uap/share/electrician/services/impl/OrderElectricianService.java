package com.sgcc.uap.share.electrician.services.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

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
import com.sgcc.uap.share.controller.WebSocketServer;
import com.sgcc.uap.share.customer.bo.OrderCustomerMoreVO;
import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;
import com.sgcc.uap.share.customer.services.impl.CustPositionService;
import com.sgcc.uap.share.customer.services.impl.OrderCustomerHisService;
import com.sgcc.uap.share.customer.services.impl.OrderCustomerService;
import com.sgcc.uap.share.customer.services.impl.OrderFlowService;
import com.sgcc.uap.share.domain.BaseEnums;
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
import com.sgcc.uap.share.electrician.repositories.ElectricainQueryOrderRepository;
import com.sgcc.uap.share.electrician.repositories.OrderElectricianHisRepository;
import com.sgcc.uap.share.electrician.repositories.OrderElectricianRepository;
import com.sgcc.uap.share.electrician.services.IOrderElectricianService;
import com.sgcc.uap.share.repositories.OrderCustomerMoreVORepository;
import com.sgcc.uap.share.services.impl.BaseAreaPriceService;
import com.sgcc.uap.share.services.impl.BaseEnumsService;
import com.sgcc.uap.share.services.impl.BaseIdentityPriceService;
import com.sgcc.uap.share.services.impl.BaseOrderTypeService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceUserService;
import com.sgcc.uap.util.DateTimeUtil;
import com.sgcc.uap.util.FileUtil;
import com.sgcc.uap.util.MapGetValueUtil;
import com.sgcc.uap.util.MapUtil;
import com.sgcc.uap.util.PointUtil;
import com.sgcc.uap.util.SorterUtil;
import com.sgcc.uap.util.TimeStamp;
import com.sgcc.uap.util.UuidUtil;
import com.sgcc.uap.utils.json.JsonUtils;

@Transactional
@Service
public class OrderElectricianService implements IOrderElectricianService{
	/** 
     * 注入orderElectricianRepository
     */
	
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
	private OrderCustomerHisService orderCustomerHisService;
	@Autowired
	private OrderFlowService orderFlowService;
	
	@Autowired
	private BaseOrderTypeService baseOrderTypeService;
	
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
	private ElectricianCompanyInfoService electricianCompanyInfoService;
	
	@Autowired
	private ElecPositionService elecPositionService;
	
	@Autowired
	private OrderElectricianHisRepository orderElectricianHisRepository;
	
	@Autowired
	private OrderCustomerMoreVORepository orderCustomerMoreVORepository;
	
	@Autowired
	private ElectricainQueryOrderRepository electricainQueryOrderRepository;
	 
	@Autowired
	private OrderElectricianService orderElectricianService;
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
				electricianId);
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
			orderElectrician=orderElectricianRepository.findByElectricianIdAndOrderId(orderId,electricianId);
			
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
			else if ("9".equals(map.get("orderElectricianStatus"))) {

				//上传图片
				if (null!=file&&!"".equals(file))  {
					String electricianEvaluateIcon = FileUtil.uploadFile(file, orderElectrician.getOrDERId(),"ORDER_ELECTRICIAN", "electricianEvaluateIcon");
					map.put("electricianEvaluateIcon", electricianEvaluateIcon);
				}
				
				
			}
			
			String orderElectricianId=orderElectrician.getOrderElectricianId();
			CrudUtils.mapToObject(map, orderElectrician,  "orderElectricianId");
			result = orderElectricianRepository.save(orderElectrician);
			
			
	       
		return result;
	}
	
	@Override
	public OrderElectrician saveOrderElectrician(Map<String, Object> map) throws Exception {
		validateService.validateWithException(OrderElectrician.class,map);
		OrderElectrician orderElectrician = new OrderElectrician();
		OrderElectrician result = new OrderElectrician();
		
			String orderId = (String) map.get("orderId");
			String orderElectricianId=orderElectrician.getOrderElectricianId();
			CrudUtils.transMap2Bean(map, orderElectrician);
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
	List<OrderElectricianBeginPageVO> list=new ArrayList<>();
	for (OrderElectrician orderElectrician : result) {
		OrderElectricianBeginPageVO orderElectricianBeginPageVO= new OrderElectricianBeginPageVO();
		String orderId=orderElectrician.getOrDERId();
		OrderCustomer orderCustomer=orderCustomerService.findByOrderId(orderId);
		orderElectricianBeginPageVO =convert(orderCustomer, orderElectrician);
		list.add(orderElectricianBeginPageVO);
	}
	long count=0;
	count=list.size();
	return RestUtils.wrappQueryResult(list,count);
	
	
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
			BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("1", "9");	
			
			//新增流水
			Map<String,Object> mapOrderFlow = 
					MapUtil.flowAdd(getNewOrderId, 1, 9, (String)map.get("electricianId"), TimeStamp.toString(new Date()), 2,  baseEnums.getEnumsB());
			orderFlowService.saveOrderFlow(mapOrderFlow);
		
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
	
	public void sendNotify(OrderElectrician orderElectrician,int oper,String getPeople){
	
		String orderElectricianStatus =orderElectrician.getOrderElectricianStatus();
		//1维修 2支付 3验收 4评价
		String notifyType ="1";
		if("23".equals(orderElectricianStatus)){
			notifyType ="2";
		}else if("8".equals(orderElectricianStatus)){
			notifyType ="3";
		}else if("9".equals(orderElectricianStatus)){
			notifyType ="4";
		}
		
		//获取Enum通知类
		BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus(getPeople,  orderElectricianStatus);	
		
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
		String EnumsB=baseEnums.getEnumsB();		
		
		//电工已接单，并确认预约时间,不需要插入消息，只需要流水就行
		List<String> flowstatusList=new ArrayList<>();
		flowstatusList.add("2");
		
		
		if (flowstatusList.contains(orderElectrician.getOrderElectricianStatus())) {
			Map<String,Object> mapNotify =
					MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", EnumsB, baseEnums.getEnumsC(), TimeStamp.toString(new Date()), 
							notifyType,orderElectrician.getOrDERId(),"");
			notifyAnnounceService.saveNotifyAnnounce(mapNotify);
			
			Map<String,Object> mapNotifyUser = 
					MapUtil.notifyUserAdd(orderElectrician.getElectricianId(), announceId, Integer.parseInt(getPeople), 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
			notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);
			
		}
		
		
		List<String> statusList = new ArrayList<String>();
		statusList.add("0"); //0 接单成功【待预约】
		statusList.add("5"); //23 等待支付维修费【待支付】--> 3
		statusList.add("23"); //5 电工退回（无法完成）【已完成】
		statusList.add("2");//系统派单
		if (statusList.contains(orderElectricianStatus)) {

		//发送websocket消息
				Map<String,String> mapString = new HashMap<String,String>();
				if (orderElectricianStatus.equals("0")) {
					mapString.put("orderId", orderElectrician.getOrDERId());
				}
				
				mapString.put("content", baseEnums.getEnumsA());
				String jsonString = JsonUtils.toJson(mapString);
				WebSocketServer.sendInfo(jsonString,orderElectrician.getElectricianId());
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}
	
	
	
	
	/**
	 * @param map
	 * @param orderCustomer
	 * @param oper 0增 1删 2改
	 * @param getPeople 1客户 2电工 
	 */
	
	public void sendNotify(OrderCustomer orderCustomer,OrderElectrician orderElectrician,int oper,String getPeople){
		
		
		String orderStatus =orderCustomer.getOrderStatus();
		if (orderElectrician.getOrderElectricianStatus().equals("5")) {
			orderStatus="5";
		}
		//1维修 2支付 3验收 4评价
		String notifyType ="1";
		if("23".equals(orderStatus)){
			notifyType ="2";
		}else if("8".equals(orderStatus)){
			notifyType ="3";
		}else if("9".equals(orderStatus)){
			notifyType ="4";
		}
		
		//获取Enum通知类
		BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus(getPeople,  orderStatus);	
		
		
		String orderId=orderCustomer.getOrderId();
		String electricianId=orderElectrician.getElectricianId();
		String EnumsA=baseEnums.getEnumsA();
		
		try {
			
		
		//如果状态是1,3,4,22则让客户那边自己插入流水
		if (!orderStatus.equals("1") ||(!orderStatus.equals("3") ||(!orderStatus.equals("4") ||(!orderStatus.equals("22")))) ) {
			
			//新增流水
			Map<String,Object> mapOrderFlow = 
					MapUtil.flowAdd(orderId, 1,  Integer.parseInt(orderStatus), electricianId, TimeStamp.toString(new Date()), oper,EnumsA);
			orderFlowService.saveOrderFlow(mapOrderFlow);
		}
		
		
		
		
		List<String> statusList = new ArrayList<String>();
		statusList.add("0"); //0 接单成功【待预约】
		statusList.add("5"); // 5 电工退回（无法完成）【已完成】
		statusList.add("23"); //23 等待支付维修费【待支付】--> 3
		statusList.add("25"); //维修完成【待验收】
		if (statusList.contains(orderElectrician.getOrderElectricianStatus())) {
			
			//新增通知
			String announceId = UuidUtil.getUuid32();
			
			Map<String,Object> mapNotify =
					MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", baseEnums.getEnumsB(), baseEnums.getEnumsC(), TimeStamp.toString(new Date()), 
							notifyType,orderCustomer.getOrderId(),"");
			notifyAnnounceService.saveNotifyAnnounce(mapNotify);
			
			Map<String,Object> mapNotifyUser = 
					MapUtil.notifyUserAdd(orderCustomer.getCustomerId(), announceId, Integer.parseInt(getPeople), 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
			notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);

			
			//25状态是验收申请
			if (orderElectrician.getOrderElectricianStatus().equals("25")) {
				baseEnums.setEnumsA(baseEnums.getEnumsC());
			}
			//发送websocket消息
				Map<String,String> mapString = new HashMap<String,String>();
			
				mapString.put("orderId", "");
				
				mapString.put("content", baseEnums.getEnumsA());
				String jsonString = JsonUtils.toJson(mapString);
				WebSocketServer.sendInfo(jsonString,orderCustomer.getCustomerId());
		}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<OrderElectrician> findByOrderIdAndOrderElectricianStatusOrderByFinishTimeDesc(String orderId,
			String orderElectricianStatus) {
		
		List<OrderElectrician> list=orderElectricianRepository.findByOrderIdAndOrderElectricianStatusOrderByFinishTimeDesc(orderId,orderElectricianStatus);
		return list;
	}
	
	/**
	 * 根据电工ID和订单ID查询出一个电工订单
	 */
	public OrderElectrician findByElectricianIdAndOrderId(String orderId,String electricianId ){
		OrderElectrician orderElectrician=orderElectricianRepository.findByElectricianIdAndOrderId(orderId,electricianId);
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
		
		//有没有找到电工
		boolean flag = false;		
		try {	
		String orderId=orderCustomer.getOrderId();		
		//1.获取客户的位置信息
		CustPosition custPosition=custPositionService.getCustPositionByOrderId(orderId);
		String areaId=custPosition.getAreaId();		
		//2.根据客户区域ID查询此区域的子公司的集合
		List<ElectricianCompanyInfo>  electricianCompanyInfoList=electricianCompanyInfoService.findByCompanyAreaId(areaId);		
		ElectricianCompanyInfo ElectricianCompanyInfo=null;
		if (electricianCompanyInfoList.size()>1) {//说明有多个电力子公司			
			//判断哪个电力子公司距离最近			
			Map<Double, ElectricianCompanyInfo> map = new TreeMap<Double, ElectricianCompanyInfo>(
	                new Comparator<Double>() {
	                    public int compare(Double obj1, Double obj2) {
	                        // 降序排序
	                        return obj1.compareTo(obj2);
	                    }
	                });	
			Double distanceDouble=null;				
			for (ElectricianCompanyInfo ElectricianCompanyInfo1 : electricianCompanyInfoList) {
				//如果电工子公司的状态是0，则代表营业中
				if (ElectricianCompanyInfo1.getBusinessStatus().equals("0")) {
					//获取订单 的位置,即经纬度，进行对比
					String ElectricianCompanyInfoLon=ElectricianCompanyInfo1.getAddressLongitude();
					String ElectricianCompanyInfoLat=ElectricianCompanyInfo1.getAddressLatitude();										
					distanceDouble=PointUtil.getDistanceString(String.valueOf(custPosition.getLon()), String.valueOf(custPosition.getLat()), ElectricianCompanyInfoLon, ElectricianCompanyInfoLat);
					System.out.println("计算的距离是："+distanceDouble);
					map.put(distanceDouble, ElectricianCompanyInfo1);
				}					
			}
			ElectricianCompanyInfo=MapGetValueUtil.getFirstOrNull(map);			
		}else {//说明有一个电力子公司
			ElectricianCompanyInfo=electricianCompanyInfoList.get(0);
		}		
		ElectricianInfo electricianInfo=null;
		//根据查询出来的电力子公司名字查询旗下所属的电工
		String companyName=ElectricianCompanyInfo.getCompanyName();		
		List<ElectricianInfo> electricianInfoList=electricianInfoService.findBycompanyName(companyName);		
		Map<Double, ElectricianInfo> map = new TreeMap<Double, ElectricianInfo>(
	            new Comparator<Double>() {
	                public int compare(Double obj1, Double obj2) {
	                    // 降序排序
	                    return obj1.compareTo(obj2);
	                }
	            });		
		Double distanceDouble=null;
		List<Double> distanceList=new ArrayList<>();
		OrderElectricianBeginPageVO orderElectricianBeginPageVO=new OrderElectricianBeginPageVO();
		List<OrderElectricianBeginPageVO> orderElectricianBeginPageVOs=new ArrayList<>();		
		if (electricianInfoList.size()>1) {
			for (ElectricianInfo electricianInfo2 : electricianInfoList) {
				//1.电工信息中的状态是1，  2.电工的位置状态是0   3.电工的名下没有这个订单
				//查询电工的位置中的状态
				ElecPosition elecPosition=elecPositionService.getElecPositionByElectricianId(electricianInfo2.getElectricianId());
				//2021.1.25如果查询出来电工的位置信息为空，则跳过本次循环
				if (elecPosition==null) {
					continue;
				}
				List<OrderElectrician> electricians=findByElectricianId(electricianInfo2.getElectricianId());
				String temp="";
				for (OrderElectrician orderElectrician : electricians) {
					if (orderElectrician.getOrDERId().equals(orderId)) {
						temp=orderElectrician.getOrDERId();
					}				
				}
				if (electricianInfo2.getElectricianStatus().equals("1") && elecPosition.getStatus().equals("0") && temp.isEmpty()) {
					//获取订单 的位置,即经纬度，进行对比
					String electricianInfoLon=elecPosition.getLon();
					String electricianInfoLat=elecPosition.getLat();

					distanceDouble=PointUtil.getDistanceString(String.valueOf(custPosition.getLon()), String.valueOf(custPosition.getLat()), electricianInfoLon, electricianInfoLat);
					System.out.println("计算的距离是："+distanceDouble);
					map.put(distanceDouble, electricianInfo2);					
				}			
			}
			int num=0;
			electricianInfo=getFirstElectricianInfo(map);
			flag=true;			
		}else {
			electricianInfo=electricianInfoList.get(0);
			ElecPosition elecPosition2 = elecPositionService.getElecPositionByElectricianId(electricianInfo.getElectricianId());
			//1.电工信息中的状态是1，  2.电工的位置状态是0   3.电工的名下没有这个订单
			ElecPosition elecPosition=elecPositionService.getElecPositionByElectricianId(electricianInfo.getElectricianId());
			List<OrderElectrician> electricians=findByElectricianId(electricianInfo.getElectricianId());
			String temp="";
			for (OrderElectrician orderElectrician : electricians) {
				if (orderElectrician.getOrDERId().equals(orderId)) {
					temp=orderElectrician.getOrDERId();
				}				
			}
			if (electricianInfo.getElectricianStatus().equals("1") && elecPosition.getStatus().equals("0") && temp.isEmpty()) {
				//获取订单 的位置,即经纬度，进行对比
				String electricianInfoLon=elecPosition2.getLon();
				String electricianInfoLat=elecPosition2.getLat();
				distanceDouble=PointUtil.getDistanceString(String.valueOf(custPosition.getLon()), String.valueOf(custPosition.getLat()), electricianInfoLon, electricianInfoLat);
				System.out.println("计算的距离是："+distanceDouble);
				orderElectricianBeginPageVO.setDistance(String.valueOf(distanceDouble));
				flag=true;
			}						
		}		
		if(flag && electricianInfo!=null){
			String electricianId=electricianInfo.getElectricianId();
			OrderElectrician orderElectrician=saveNewOrderElectrician(orderId,electricianId,"2");			
			//改变主订单客户订单的状态是20
			orderCustomer.setOrderStatus("20");
			Map<String, Object> nesMap=new HashMap<>();
			nesMap=CrudUtils.objectToMap(orderCustomer);
			saveOrderCustomerByOrderElectricianService(nesMap);			
			sendNotify(orderElectrician,0,"1");
		}else{
			//待提供方法
			
		}
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		String errorMessage = "查询异常";		
	}	
	}
	
	/**
	 * orderElectricianStatus  要变更的状态
	 */
	@Override
	public OrderElectrician saveNewOrderElectrician(String orderId,String electricianId,String orderElectricianStatus){
		
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
		
		
		map.put("electricianPrice",null);
		//0 表示电工已经接单，
		map.put("orderElectricianStatus",orderElectricianStatus);
		map.put("payStatus",orderCustomer.getPayStatus());
		map.put("createTime",DateTimeUtil.formatDateTime(new Date()));
		map.put("orderTypeId", orderCustomer2.getOrderTypeId());
		
		map.put("orDERId",orderId);
		map.put("orderId", orderId);
		saveOrderElectrician = saveOrderElectrician(map);
		
		//将电工 的状态置1
		ElecPosition elecPosition=elecPositionService.getElecPositionByElectricianId(electricianId);
		elecPosition.setStatus("1");
		Map<String, Object> map2=new HashMap<>();
		map=pojo2Map(elecPosition);
		elecPositionService.saveElecPosition(map);

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
	 *  acceptAround   电工的接单范围，单位：KM
	 * @return
	 */
	//当有新订单后，向符合条件的电工发送
	@Override
	public void qiangdantanchuang(OrderCustomer orderCustomer,Integer acceptAround){
		
		//1.通过orderID查询客户的区域ID
		//2.根据查询出来的区域ID查询此区域内的全部电工
		//3.创建子订单，向集合的电工发布消息
		String orderId=orderCustomer.getOrderId();		
		try {
		//1.通过orderID查询客户的区域ID
		CustPosition custPosition=custPositionService.getCustPositionByOrderId(orderId);
		String areaId=custPosition.getAreaId();		
		//2.根据查询出来的区域ID查询此区域内的全部电工
		List<ElecPosition> elecPositionList=elecPositionService.getByAreaId(areaId);		
		//此集合用于存放在线状态的电工
		List<ElecPosition> elecPositions=new ArrayList<ElecPosition>();	
		//根据客户的区域ID得到电工的区域范围		
		double[] around=PointUtil.getAround(Double.valueOf(custPosition.getLon()), Double.valueOf(custPosition.getLat()), acceptAround*1000);		
		//3.循环查询电工状态，留下 【 范围内】  【 在线状态】    的电工
		for (ElecPosition elecPosition : elecPositionList) {
			//3.1 根据电工的ID查询电工信息
			String electricianId=elecPosition.getElectricianId();			
			//查询电工的信息
			ElectricianInfo electricianInfo=electricianInfoService.findInfo(electricianId);
			//查询电工有没接过此订单
			OrderElectrician orderElectrician = findByElectricianIdAndOrderId(orderId, electricianId);
			//查询电工所属电力公司的
			ElectricianCompanyInfo electricianCompanyInfo=electricianCompanyInfoService.findByCompanyId(electricianInfo.getCompanyId());
			//如果电工的状态是1,位置状态是0，电力公司的状态是0营业中，则代表电工在线,当前电工没有接过此订单
			if (electricianInfo.getElectricianStatus().equals("1") && elecPosition.getStatus().equals("0") && electricianCompanyInfo.getBusinessStatus().equals("0") && orderElectrician==null) {  
				if (Double.valueOf(elecPosition.getLon())>around[0] && Double.valueOf(elecPosition.getLon())<around[2] && Double.valueOf(elecPosition.getLat())>around[1] && Double.valueOf(elecPosition.getLat())<around[3]){					
					//3.2获取到了范围内的可以接单的电工
						elecPositions.add(elecPosition);   					
			}
		}
		}		
		//4.创建一个电工子订单，然后将子订单po转化成VO							
			OrderElectricianBeginPageVO orderElectricianBeginPageVO=new OrderElectricianBeginPageVO();	
			Double distanceDouble=null;			
		if (elecPositions.size()==0) {			
		}else if (elecPositions.size()==1) {
			//获取电工与客户之间的距离
			distanceDouble=PointUtil.getDistanceString(String.valueOf(elecPositions.get(0).getLon()), String.valueOf(elecPositions.get(0).getLat()), custPosition.getLon(), custPosition.getLat());			
			orderElectricianBeginPageVO=convertOrderCustomer2OrderElectricianBeginPageVO(orderCustomer, orderElectricianBeginPageVO);
			orderElectricianBeginPageVO.setDistance(String.valueOf(distanceDouble));			
			//发送websocket消息
			Map<String,String> mapString = new HashMap<String,String>();				
			mapString.put("orderId", orderCustomer.getOrderId());			
			mapString.put("content", "您有新的订单，请查看");
			String jsonString = JsonUtils.toJson(mapString);
			WebSocketServer.sendInfo(jsonString,elecPositions.get(0).getElectricianId());			
		}else {//表明有多个电工
			for (ElecPosition elecPosition1 : elecPositions) {
				//计算出客户和电工之间的距离
				distanceDouble=PointUtil.getDistanceString(String.valueOf(elecPosition1.getLon()), String.valueOf(elecPosition1.getLat()), custPosition.getLon(), custPosition.getLat());
				orderElectricianBeginPageVO=convertOrderCustomer2OrderElectricianBeginPageVO(orderCustomer, orderElectricianBeginPageVO);
				orderElectricianBeginPageVO.setDistance(String.valueOf(distanceDouble));				
				//发送websocket消息
				Map<String,String> mapString = new HashMap<String,String>();				
				mapString.put("orderId", orderCustomer.getOrderId());			
				mapString.put("content", "您有新的订单，请查看");
				String jsonString = JsonUtils.toJson(mapString);
				WebSocketServer.sendInfo(jsonString,elecPosition1.getElectricianId());				
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
			//	根据电工订单中orderID查询主订单
			String orderId=orderElectrician.getOrDERId();
			OrderCustomer orderCustomer=orderCustomerService.findByOrderId(orderId);
			orderCustomer.setOrderStatus("11");
			orderElectrician.setUpdateTime(nowDate);
			orderElectrician.setFinishTime(nowDate);
		
		orderElectrician.setOrderElectricianStatus(orderElectricianStatus);
		//保存后的子订单
		OrderElectrician orderElectrician2=orderElectricianRepository.save(orderElectrician);
		Map<String, Object> map=new HashMap<>();
		map=pojo2Map(orderCustomer);
		//保存后的主订单
		OrderCustomer orderCustomer2=saveOrderCustomerByOrderElectricianService(map);
		
		Map<String, Object> map2=new HashMap<>();
		
			map.put("orderElectricianStatus", orderElectricianStatus);
						
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	private OrderElectrician findByOrderElectricianId(String orderElectricianId) {
		OrderElectrician orderElectrician=(OrderElectrician) orderElectricianRepository.findByOrderElectricianId(orderElectricianId);
		return orderElectrician;
	}
	@Override
	public QueryResultObject searchBox(RequestCondition requestCondition) {
		
		Map<String, String> map = MapUtil.getParam(requestCondition);
		String electricianId = map.get("electricianId");
		String searchContent = map.get("searchContent");
		String tagType = map.get("tagType");
		Integer pageIndex=requestCondition.getPageIndex()-1;
		
		Integer pageSize=requestCondition.getPageSize();
		
		List<OrderElectrician> orderCustomers = null;
		List<String> tagTypes = new ArrayList<String>();
		
		List<OrderElectricianBeginPageVO> list=new ArrayList<>();
		if("1".equals(tagType)){//1表示进行中
			
			List<OrderElectrician> result=orderElectricianRepository.queryAllDoing(electricianId);
			
			for (OrderElectrician orderElectrician : result) {
				OrderElectricianBeginPageVO orderElectricianBeginPageVO= new OrderElectricianBeginPageVO();
				String orderId=orderElectrician.getOrDERId();
				OrderCustomer orderCustomer=orderCustomerService.findByOrderId(orderId);
				if (searchContent==null) {//搜索字段是空，则返回全部
					orderElectricianBeginPageVO =convert(orderCustomer, orderElectrician);
					list.add(orderElectricianBeginPageVO);
				}else {//搜索字段不是空，则返回包含搜索字段的结果
					if (orderCustomer.getCustomerDescriveTitle().contains(searchContent)) {//主订单中包含搜索字段
						orderElectricianBeginPageVO =convert(orderCustomer, orderElectrician);
						list.add(orderElectricianBeginPageVO);
					}else {
						continue;
					}
				}							
			}			
		}else if("2".equals(tagType)){//1表示已完成
			List<OrderElectricianHis> result= orderElectricianHisRepository.findqQueryAllHaveDone(electricianId,pageIndex,pageSize);			
			for (OrderElectricianHis orderElectricianHis : result) {
				//通过ID查询所有的主订单
				OrderCustomer orderCustomer = orderCustomerService.findByOrderId(orderElectricianHis.getOrderId());
				if (orderCustomer==null) {
					OrderCustomerHis customerHis = orderCustomerHisService.findByOrderId(orderElectricianHis.getOrderId());
					BeanUtils.copyProperties(orderElectricianHis, orderCustomer);
				}
				if (searchContent==null) {
					OrderElectrician orderElectrician=new OrderElectrician();
					BeanUtils.copyProperties(orderElectricianHis, orderElectrician);
					OrderElectricianBeginPageVO orderElectricianBeginPageVO=new OrderElectricianBeginPageVO();
					orderElectricianBeginPageVO=orderElectricianService.convert(orderCustomer, orderElectrician);
					list.add(orderElectricianBeginPageVO);
				}else {
					if (orderCustomer.getCustomerDescriveTitle().contains(searchContent)) {
						OrderElectrician orderElectrician=new OrderElectrician();
						BeanUtils.copyProperties(orderElectricianHis, orderElectrician);
						OrderElectricianBeginPageVO orderElectricianBeginPageVO=new OrderElectricianBeginPageVO();
						orderElectricianBeginPageVO=orderElectricianService.convert(orderCustomer, orderElectrician);
						list.add(orderElectricianBeginPageVO);
					}else {
						continue;
					}	
				}								
			}			
					}else{
						
						List<OrderElectricianHis> result= orderElectricianHisRepository.queryAll(electricianId,pageIndex,pageSize);
						for (OrderElectricianHis orderElectricianHis : result) {
							//通过ID查询所有的主订单
							OrderCustomer orderCustomer = orderCustomerService.findByOrderId(orderElectricianHis.getOrderId());
							if (orderCustomer==null) {
								OrderCustomerHis customerHis = orderCustomerHisService.findByOrderId(orderElectricianHis.getOrderId());
								BeanUtils.copyProperties(customerHis, orderCustomer);
							}
							if (searchContent==null) {
								OrderElectrician orderElectrician=new OrderElectrician();
								BeanUtils.copyProperties(orderElectricianHis, orderElectrician);
								OrderElectricianBeginPageVO orderElectricianBeginPageVO=new OrderElectricianBeginPageVO();
								orderElectricianBeginPageVO=orderElectricianService.convert(orderCustomer, orderElectrician);
								list.add(orderElectricianBeginPageVO);
							}else {
								if (orderCustomer.getCustomerDescriveTitle().contains(searchContent)) {
									OrderElectrician orderElectrician=new OrderElectrician();
									BeanUtils.copyProperties(orderElectricianHis, orderElectrician);
									OrderElectricianBeginPageVO orderElectricianBeginPageVO=new OrderElectricianBeginPageVO();
									orderElectricianBeginPageVO=orderElectricianService.convert(orderCustomer, orderElectrician);
									list.add(orderElectricianBeginPageVO);
								}	
							}							
						}					
		}		
	long count=0;
	count=list.size();
	return RestUtils.wrappQueryResult(list,count);

	}
	
	
	/**
	 * 计算客户和电工之间的距离
	 * @param orderCustomer
	 * @param orderElectrician
	 * @return
	 */
	public String jisuanjuli(OrderCustomer orderCustomer,OrderElectrician orderElectrician){
		List<String> strings=new ArrayList<>();
		strings.add("1");
		strings.add("11");
		strings.add("20");
		String orderId=orderCustomer.getOrderId();
		CustPosition custPosition = custPositionService.getCustPositionByOrderId(orderId);
		String custLoString=custPosition.getLon();
		String custLat=custPosition.getLat();
		ElecPosition elecPosition=elecPositionService.getElecPositionByElectricianId(orderElectrician.getElectricianId());
		String lon=elecPosition.getLon();
		String electricianInfoLat=elecPosition.getLat();
		String distanceString=null;
		if (strings.contains(orderCustomer.getOrderId())) {
			double distanceDouble = PointUtil.getDistanceString(String.valueOf(lon), String.valueOf(electricianInfoLat), custLoString, custLat);
			System.out.println("计算的距离是："+distanceDouble);
			 distanceString=String.valueOf(distanceDouble)+"KM";
		}
		
		
		return distanceString;
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
	orderCustomerVO.setChargebackReason(orderElectrician.getChargebackReason());
	//orderCustomerVO.setOrderElectricianId(orderElectrician.getElectricianId());
	orderCustomerVO.setElectricianPrice(orderElectrician.getElectricianPrice());
	orderCustomerVO.setOrderContract(orderElectrician.getOrderContract());
	orderCustomerVO.setOrderElectricianStatus(orderElectrician.getOrderElectricianStatus());
	orderCustomerVO.setConstructionContent(orderElectrician.getConstructionContent());
	orderCustomerVO.setOtherElectricianId(orderElectrician.getOtherElectricianId());
	orderCustomerVO.setRemarkStr1(orderElectrician.getRemarkStr1());
	orderCustomerVO.setElectricianEvaluateIcon(orderElectrician.getElectricianEvaluateIcon());
	orderCustomerVO.setOrderContract(orderElectrician.getOrderContract());
	orderCustomerVO.setInspectionReport(orderElectrician.getInspectionReport());
	//子订单ID
	orderCustomerVO.setOrderElectricianId(orderElectrician.getOrderElectricianId());
	//如果订单类型不为null.则返回描述性信息
	if (orderCustomerVO.getOrderTypeId()!=null) {
		String orderTypeId=orderCustomerVO.getOrderTypeId();
		
		BaseOrderType baseOrderType=baseOrderTypeService.findByOrderTypeId(orderTypeId);
		orderCustomerVO.setOrderTypeId(baseOrderType.getOrderTypeName());
		
	}if (orderCustomer.getOrderFrom()!=null) {
		String orderFromString=orderCustomer.getOrderFrom();
		if (orderFromString.equals("0")) {
			orderCustomerVO.setOrderFrom("来源APP端");
		}else if (orderFromString.equals("1")) {
			orderCustomerVO.setOrderFrom("来源客服端");
		}
		
	}
	if (orderCustomerVO.getDistance()!=null) {
		Double distance=Double.valueOf(orderCustomerVO.getDistance());
		if (distance<1 && distance>0) {
			distance=distance*1000;
			orderCustomerVO.setDistance(String.valueOf(distance)+"m");
			
		}else {
			int i=(int) Math.rint(distance/1000);
			orderCustomerVO.setDistance(String.valueOf(distance)+"km");
		}
	}
	
	
	return orderCustomerVO;
}
public List<OrderElectrician> findqQueryAllHaveDone(String electricianId) {
	List<OrderElectrician> list=orderElectricianRepository.findqQueryAllHaveDone(electricianId);
	return list;
}

public  OrderElectricianBeginPageVO orderElectricianBeginPage2VO(OrderElectricianBeginPage orderElectricianBeginPage){
	//根据子订单ID查询子订单
	OrderElectrician orderElectrician = findByOrderElectricianId(orderElectricianBeginPage.getOrderElectricianId());
	
	OrderElectricianBeginPageVO orderElectricianBeginPageVO=new OrderElectricianBeginPageVO();
	BeanUtils.copyProperties(orderElectricianBeginPage, orderElectricianBeginPageVO);
	//将子订单的状态放入
	orderElectricianBeginPageVO.setOrderElectricianStatus(orderElectrician.getOrderElectricianStatus());
	
	if (!orderElectricianBeginPageVO.getOrderTypeId().isEmpty()) {
		String orderTypeId=orderElectricianBeginPageVO.getOrderTypeId();
		
		BaseOrderType baseOrderType=baseOrderTypeService.findByOrderTypeId(orderTypeId);
		orderElectricianBeginPageVO.setOrderTypeId(baseOrderType.getOrderTypeName());
		
	}
	
	
	return orderElectricianBeginPageVO;
}
@Override
public List<OrderElectrician> queryByOrderIdOrderByCreatetime(String orderId) {
	List<OrderElectrician> list=orderElectricianRepository.queryByOrderIdOrderByCreatetime(orderId);
	return list;
}

public OrderElectricianBeginPageVO convertDistance(OrderElectricianBeginPageVO orderElectricianBeginPageVO){
	OrderElectricianBeginPageVO orderElectricianBeginPageVO2=new OrderElectricianBeginPageVO();
	if (orderElectricianBeginPageVO.getDistance()!=null) {
		Double distance=Double.valueOf(orderElectricianBeginPageVO.getDistance());
		if (distance<1 && distance>0) {
			distance=distance*1000;
			orderElectricianBeginPageVO.setDistance(String.valueOf(distance)+"m");
			
		}else {
			int i=(int) Math.rint(distance/1000);
			orderElectricianBeginPageVO.setDistance(String.valueOf(distance)+"km");
		}
	}
	
	return orderElectricianBeginPageVO;
}
@Override
public OrderElectricianBeginPageVO convertOrderCustomer2OrderElectricianBeginPageVO(OrderCustomer orderCustomer,
		OrderElectricianBeginPageVO orderElectricianBeginPageVO) {
	BeanUtils.copyProperties(orderCustomer, orderElectricianBeginPageVO);
	if (!orderCustomer.getOrderFrom().isEmpty()) {
		String orderFromString=orderCustomer.getOrderFrom();
		if (orderFromString.equals("0")) {
			orderElectricianBeginPageVO.setOrderFrom("来源APP端");
		}else if (orderFromString.equals("1")) {
			orderElectricianBeginPageVO.setOrderFrom("95588");
		}
		
	}
	if (!orderElectricianBeginPageVO.getOrderTypeId().isEmpty()) {
		String orderTypeId=orderElectricianBeginPageVO.getOrderTypeId();
		
		BaseOrderType baseOrderType=baseOrderTypeService.findByOrderTypeId(orderTypeId);
		orderElectricianBeginPageVO.setOrderTypeId(baseOrderType.getOrderTypeName());
		
	}
	return orderElectricianBeginPageVO;
}

/**
 * 保存的是电工子订单的对象
 */
@Override
public void save(OrderElectrician orderElectrician) {
	orderElectricianRepository.save(orderElectrician);
	
}
@Override
public void saveorderCustomerPOJO(OrderCustomer orderCustomer) {
	orderCustomerRepository.save(orderCustomer);
	
}
@Override
public QueryResultObject queryAllElectrician(String electricianId) {
	//根据电工ID查询出公司ID
	ElectricianInfo electricianInfo = electricianInfoService.findByElectricianId(electricianId);
	String companyId=electricianInfo.getCompanyId();
	
	//根据公司ID去查询其旗下的所有电工，状态是身上没有订单(电工位置表的状态是0)
	List<ElectricianInfo> electricianInfos=electricianInfoService.findByCompanyId(companyId);
	//用于放最终可展示的电工信息集合
	List<ElectricianInfo> electricianInfolList=new ArrayList<>();
	for (ElectricianInfo electricianInfo2 : electricianInfos) {
		ElecPosition elecPosition=elecPositionService.getElecPositionByElectricianId(electricianInfo2.getElectricianId());
		if (elecPosition.getStatus().equals("0")) {//0表明电工身上没有订单
			electricianInfolList.add(electricianInfo2);
		}
	}
	long count = 0;
	count = electricianInfolList.size();
	
	return RestUtils.wrappQueryResult(electricianInfolList, count);
}


/**
 * 
 * @param orderElectrician
 *@param oper 0增 1删 2改
	 * @param getPeople 1客户 2电工 
	 * electricianId要发送给谁
 */
		public void sendNotice(String orderElectricianStatus,String orderId,String electricianId,int oper,String getPeople){
			
			String orderStatus =orderElectricianStatus;
			//1维修 2支付 3验收 4评价
			String notifyType ="1";
			if("23".equals(orderStatus)){
				notifyType ="2";
			}else if("8".equals(orderStatus)){
				notifyType ="3";
			}else if("9".equals(orderStatus)){
				notifyType ="4";
			}
			
			//获取Enum通知类
			BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus(getPeople,  orderStatus);	
			
			
			//String orderId=orderElectrician.getOrDERId();
			//String electricianId=orderElectrician.getElectricianId();
			//String EnumsA=baseEnums.getEnumsA();
				
			try {
				
			
				//新增通知
				String announceId = UuidUtil.getUuid32();
				
				Map<String,Object> mapNotify =
						MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", baseEnums.getEnumsB(), "您已有未完成的订单", TimeStamp.toString(new Date()), 
								notifyType,orderId,"");
				notifyAnnounceService.saveNotifyAnnounce(mapNotify);
				
				Map<String,Object> mapNotifyUser = 
						MapUtil.notifyUserAdd(electricianId, announceId, Integer.parseInt(getPeople), 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
				notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);

				//通过电工的ID给电工发送消息
				if (orderElectricianStatus.equals("31")) {
					WebSocketServer.sendInfo(baseEnums.getEnumsC(),electricianId);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
}


}
	
	
	
	
	
	

