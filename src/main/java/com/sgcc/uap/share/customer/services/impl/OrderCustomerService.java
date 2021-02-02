package com.sgcc.uap.share.customer.services.impl;

import java.sql.Timestamp;
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
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
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
import com.sgcc.uap.share.customer.bo.EvaluateTaskBo;
import com.sgcc.uap.share.customer.bo.OrderCustomerBeginPage;
import com.sgcc.uap.share.customer.repositories.EvaluateTaskRepository;
import com.sgcc.uap.share.customer.repositories.GetOrderElectricianRepository;
import com.sgcc.uap.share.customer.repositories.OrderCustomerBeginPageRepository;
import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;
import com.sgcc.uap.share.customer.services.IOrderCustomerService;
import com.sgcc.uap.share.domain.BaseEnums;
import com.sgcc.uap.share.domain.BaseIdentityPrice;
import com.sgcc.uap.share.domain.BaseSystemConfig;
import com.sgcc.uap.share.domain.ElecPosition;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.electrician.services.impl.ElecPositionService;
import com.sgcc.uap.share.services.IBaseEnumsService;
import com.sgcc.uap.share.services.IElecErrorCountService;
import com.sgcc.uap.share.services.impl.AssessRecordService;
import com.sgcc.uap.share.services.impl.BaseAreaPriceService;
import com.sgcc.uap.share.services.impl.BaseIdentityPriceService;
import com.sgcc.uap.share.services.impl.BaseSystemConfigService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceUserService;
import com.sgcc.uap.util.DateTimeUtil;
import com.sgcc.uap.util.FileUtil;
import com.sgcc.uap.util.MapUtil;
import com.sgcc.uap.util.SorterUtil;
import com.sgcc.uap.util.TimeStamp;
import com.sgcc.uap.util.UuidUtil;
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
@Service
public class OrderCustomerService implements IOrderCustomerService{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(OrderCustomerService.class);
	
	/** 
     * 注入orderCustomerRepository
     */
	@Autowired
	private OrderCustomerRepository orderCustomerRepository;
	@Autowired
	private ValidateService validateService;
	@Autowired
	private OrderFlowService orderFlowService;
	@Autowired
	private BaseIdentityPriceService baseIdentityPriceService;
	@Autowired
	private BaseAreaPriceService baseAreaPriceService;
	@Autowired
    private IBaseEnumsService baseEnumsService;
	@Autowired
    private OrderCustomerBeginPageRepository orderCustomerBeginPageRepository;
	@Autowired
    private GetOrderElectricianRepository getOrderElectricianRepository;
	@Autowired
	private CustPositionService custPositionService;
	@Autowired
	private NotifyAnnounceService notifyAnnounceService;
	@Autowired
	private NotifyAnnounceUserService notifyAnnounceUserService;
	@Autowired
	private ElecPositionService elecPositionService;
	@Autowired
	private BaseSystemConfigService baseSystemConfigService;
	@Autowired
	private EvaluateTaskRepository evaluateTaskRepository;
	@Autowired
	private AssessRecordService assessRecordService;
	@Autowired
	private IElecErrorCountService elecErrorCountService;
	
	
	
	@SuppressWarnings("rawtypes")
	@Autowired
    private RedisTemplate redisTemplate;
	
	@Override
	public QueryResultObject getOrderCustomerByOrderId(String orderId) {
		OrderCustomer orderCustomer = orderCustomerRepository.findOne(orderId);
		return RestUtils.wrappQueryResult(orderCustomer);
	}
	
	@Override
	public QueryResultObject getOrderDetailByOrderId(String orderId) {
		List<String> elecStatus = new ArrayList<>();
		elecStatus.add("1");
		elecStatus.add("4");
		elecStatus.add("5");
		OrderCustomerBeginPage orderCustomerBeginPage = orderCustomerBeginPageRepository.findOrderDetail(orderId,elecStatus);
		/*String OtherElectricianId = orderCustomerBeginPage.getOtherElectricianId();
		String electricianName = orderCustomerBeginPage.getElectricianName();
		orderCustomerBeginPage.setOtherElectricianName(electricianName+","+OtherElectricianId);*/
		return RestUtils.wrappQueryResult(orderCustomerBeginPage);
	}
	
	@Override
	public List<OrderCustomer> getOrderCustomerByOrderIds(List<String> orderIds) {
		List<OrderCustomer> orderCustomers = orderCustomerRepository.findOrderCustomerByOrderId(orderIds);
		return orderCustomers;
	}
	
	@Override
	public QueryResultObject getAllOrderCustomerByCustomerId(RequestCondition queryCondition) {
		List<OrderCustomer> result = new ArrayList<>();
		List<OrderCustomerBeginPage> resultBeginPage = new ArrayList<>();
		long count = 0;
		
		String pageType = queryCondition.getParentID();
		List<String> custStatus = new ArrayList<>();
		List<String> elecStatus = new ArrayList<>();
		
		Integer pageIndex = queryCondition.getPageIndex()-1;
		Integer pageSize = queryCondition.getPageSize();
		
		Map<String, String> map = MapUtil.getParam(queryCondition);
		String customerId = map.get("customerId");
		//0全部(待支付、待验收、待评价) 1待支付 2待验收 3待评价
		String tagType = map.get("tagType");
		
		/*
		 0、23 待支付
			25 待验收
			8 待评价
		 * */
		if("beginPage".equals(pageType)){
			if("0".equals(tagType)){
				custStatus.add("0");
				custStatus.add("23");
			}else if("1".equals(tagType)){
				custStatus.add("25");
			}else if("2".equals(tagType)){
				custStatus.add("8");
			}
			
			elecStatus.add("1");
			elecStatus.add("4");
			elecStatus.add("5");
			resultBeginPage = orderCustomerBeginPageRepository.getOrderCustomerByCustomerIdAndEnot(pageIndex,pageSize,customerId,custStatus,elecStatus);
			count = orderCustomerBeginPageRepository.countByCustomerIdAndStatus(customerId,custStatus,elecStatus);
			return RestUtils.wrappQueryResult(resultBeginPage, count);
		}else{
			result = orderCustomerRepository.getAllOrderCustomerByCustomerId(pageIndex,pageSize,customerId);
			count = orderCustomerRepository.countByCustomerId(customerId);
			return RestUtils.wrappQueryResult(result, count);
		}
	}
	
	@Override
	public void remove(IDRequestObject idObject) {
		if(idObject == null){
			throw new NullArgumentException("idObject");
		}
		String[] ids = idObject.getIds();
		for (String id : ids){
			orderCustomerRepository.delete(id);
		}
	}
	
	@Override
	@Transactional
	public OrderCustomer saveOrderCustomer(Map<String,Object> map,MultipartFile file) throws Exception{
		logger.info("OrderCustomerService saveOrderCustomer map = " +map); 
		validateService.validateWithException(OrderCustomer.class,map);
		OrderCustomer orderCustomer = new OrderCustomer();
		OrderCustomer result = new OrderCustomer();
		if (map.containsKey("orderId")) {
			//修改
			String orderId = (String) map.get("orderId");
			orderCustomer = orderCustomerRepository.findOne(orderId);
			
			Map<String, Object> getStatus = checkOrderStatus(map, orderCustomer);
			
			if("0".equals(getStatus.get("key"))){
				//上传图片
				if (null!=file&&!"".equals(file)) {
					String fileName = (String) map.get("fileName");
					String iconUrl = FileUtil.uploadFile(file, orderId,"ORDER_CUSTOMER",fileName);
					map.put(fileName, iconUrl);
				}
				Map<String, Object> newMap = (Map) getStatus.get("map");
				CrudUtils.mapToObject(newMap, orderCustomer,  "orderId");
				result = orderCustomerRepository.save(orderCustomer);
				
				sendNotify(newMap, orderCustomer , null,2,"0");
			}else{
				throw new Exception((String) getStatus.get("desc"));
			}
			
			
		}else{
			String getNewOrderId = UuidUtil.getIntUuid32();
			//上传图片
			if (null!=file&&!"".equals(file)) {
				String customerDescriveIcon = FileUtil.uploadFile(file, getNewOrderId,"ORDER_CUSTOMER", "customerDescriveIcon");
				map.put("customerDescriveIcon", customerDescriveIcon);
			}
			
			//新增order
			String identityId = (String) map.get("identityId");
			String provinceId = (String) map.get("provinceId");
			String cityId = (String) map.get("cityId");
			String areaId = (String) map.get("areaId");
			if("".equals(areaId)||null==areaId){
				if(!"".equals(cityId)&&null!=cityId){
					areaId = cityId;
				}else if(!"".equals(provinceId)&&null!=provinceId){
					areaId = provinceId;
				}
			}
					
			map.put("createAreaId", areaId);
			map.put("customerPrice", getPrice(identityId, areaId));
			map.put("orderStatus", "0");
			map.put("payStatus", "0");
			map.put("orderFrom", "0");
			map.put("createTime", DateTimeUtil.formatDateTime(new Date()));
			map.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
			map.put("orderId", getNewOrderId);
			map.put("orderFrom", "0");
			if("".equals((String) map.get("appointmentTime"))){
				map.put("appointmentTime", null);
			}
			
			CrudUtils.transMap2Bean(map, orderCustomer);
			result = orderCustomerRepository.save(orderCustomer);
			
			//获取Enum通知类
			BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("0", "0");	
			
			//新增流水
			Map<String,Object> mapOrderFlow = 
					MapUtil.flowAdd(getNewOrderId, 0, 0, (String)map.get("customerId"), TimeStamp.toString(new Date()), 0,  baseEnums.getEnumsA());
			orderFlowService.saveOrderFlow(mapOrderFlow);
			
			//新增通知
			/*String announceId = UuidUtil.getUuid32();
			
			Map<String,Object> mapNotify =
					MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", baseEnums.getEnumsB(), baseEnums.getEnumsC(), TimeStamp.toString(new Date()), 
							"2",getNewOrderId,"");
			notifyAnnounceService.saveNotifyAnnounce(mapNotify);
			
			Map<String,Object> mapNotifyUser = 
					MapUtil.notifyUserAdd((String)map.get("customerId"), announceId, 1, 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
			notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);*/
			
			//发送websocket消息
	        //WebSocketServer.sendInfo("下单成功",(String)map.get("customerId"));  前台自动反馈用户
		}
		return result;
	}
	
	
	
	@Override
	public OrderCustomer updateOrderCustomer(Map<String,Object> map) throws Exception{
		logger.info("OrderCustomerService updateOrderCustomer map = " +map); 
		OrderCustomer orderCustomer = new OrderCustomer();
		OrderCustomer result = new OrderCustomer();
		//修改
		String orderId = (String) map.get("orderId");
		orderCustomer = orderCustomerRepository.findOne(orderId);
			CrudUtils.mapToObject(map, orderCustomer,  "orderId");
			result = orderCustomerRepository.save(orderCustomer);
		return result;
	}
	
	
	@Override
	public QueryResultObject query(RequestCondition queryCondition) {
		if(queryCondition == null){
			throw new NullArgumentException("queryCondition");
		}
		Object o = queryCondition.getFilter();
		if(o != null && o instanceof List){
			List<Map<String, Object>> filter = (List<Map<String, Object>>)o;
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
		List<QueryFilter> qList = getFilterList(queryCondition);
		Specification<OrderCustomer> specification = new Specification<OrderCustomer>() {
			@Override
			public Predicate toPredicate(Root<OrderCustomer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<OrderCustomer> orderCustomer = orderCustomerRepository.findAll(specification,request);
		//Page<OrderCustomer> orderCustomer = orderCustomerRepository.findAllByCreateTimeAtDesc(specification,request);
		List<OrderCustomer> result = new ArrayList<OrderCustomer>();
		long count = 0;
		if(null != qList && !qList.isEmpty()){
			result = orderCustomer.getContent();
			count = orderCustomer.getTotalElements();
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
		List<QueryFilter> qList = queryCondition.getQueryFilter(); 
		Specification<OrderCustomer> specification = new Specification<OrderCustomer>() {
			@Override
			public Predicate toPredicate(Root<OrderCustomer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<OrderCustomer> orderCustomer = orderCustomerRepository.findAll(specification,request);
		//Page<OrderCustomer> orderCustomer = orderCustomerRepository.findAllByCreateTimeAtDesc(specification,request);
		List<OrderCustomer> result = new ArrayList<OrderCustomer>();
		long count = 0;
		result = orderCustomer.getContent();
		count = orderCustomer.getTotalElements();
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
	
	private String getPrice(String identityId,String provinceId){
		//获取身份价格
		QueryResultObject getBaseIdentityPrice = baseIdentityPriceService.getBaseIdentityPriceByIdentityId(identityId);
		BaseIdentityPrice baseIdentityPrice = (BaseIdentityPrice) (getBaseIdentityPrice.getItems().get(0));
		String identityPrice = baseIdentityPrice.getIdentityPrice();
		
		//获取省份价格
		/*List<BaseAreaPrice> list = baseAreaPriceService.getBaseAreaPriceByProvinceId(provinceId);
		String areaPrice = list.get(0).getPrice();
		
		BigDecimal identityPriceBD=new BigDecimal(identityPrice);
		BigDecimal areaPriceBD=new BigDecimal(areaPrice);
		String resultBD = DecimalUtil.add(identityPriceBD,areaPriceBD).toString();*/
		String resultBD = identityPrice;
		return resultBD;
	}
	
	
	private Map<String,Object> checkOrderStatus(Map<String, Object> map,OrderCustomer orderCustomer) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		Timestamp nowDate =new Timestamp(System.currentTimeMillis());
		String orderStatus = (String) map.get("orderStatus");
		
		if("4".equals(orderStatus)){
	        ArrayList<String> sites = new ArrayList<>();
	        sites.add("0");
	        sites.add("1");
	        sites.add("11");
	        sites.add("20");
	        sites.add("21");
			//用户主动取消订单
			if(sites.contains(orderCustomer.getOrderStatus())){
				List<String> listStatus = new ArrayList<String>();
				listStatus.add("1");
				listStatus.add("4");
				listStatus.add("5");
				//获取当前子订单
				OrderElectrician orderElectrician = getOrderElectricianRepository.findByOrderIdAndOrderElectricianStatusNotIn(orderCustomer.getOrderId(), listStatus);
				if(null!=orderElectrician){
					//通知电工
					//notifyAnnounceService.userDefinedNotify(orderCustomer.getOrderId(), "1", "4");
					//修改电工订单状态 由 0 2 21 改为 4
					List<String> elecStatus = new ArrayList<String>();
					elecStatus.add("0");
					elecStatus.add("2");
					elecStatus.add("20");
					elecStatus.add("21");
					if(sites.contains(orderElectrician.getOrderElectricianStatus())){
						orderElectrician.setUpdateTime(nowDate);
						orderElectrician.setFinishTime(nowDate);
						orderElectrician.setOrderElectricianStatus(orderStatus);
						getOrderElectricianRepository.save(orderElectrician);
						//插入电工流水
						sendNotify(map, orderCustomer , orderElectrician,2,"1");
						
						ElecPosition elecPosition = elecPositionService.getElecPositionByElectricianId(orderElectrician.getElectricianId());
						Map<String,Object> elecPositionMap = new HashMap<String, Object>();
						elecPositionMap.put("electricianId", elecPosition.getElectricianId());
						elecPositionMap.put("status", "0");
						elecPositionService.saveElecPosition(elecPositionMap);
						
						//删除cust_position
						custPositionService.delete(orderCustomer.getOrderId());
						
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
				}else{
					String dateString = TimeStamp.toString(new Date());
					map.put("updateTime", dateString);
					map.put("finishTime", dateString);
					result.put("key", "0");
					result.put("desc", "未找到子订单");
					result.put("map", map);
				}
			}else{
				result.put("key", "1");
				result.put("desc", "该订单不处于可取消状态");
			}
		}else if("8".equals(orderStatus)){
			ArrayList<String> sites = new ArrayList<>();
	        sites.add("25"); //待用户验收
			if(sites.contains(orderCustomer.getOrderStatus())){
				List<String> listStatus = new ArrayList<String>();
				listStatus.add("1");
				listStatus.add("4");
				listStatus.add("5");
				//获取当前子订单
				OrderElectrician orderElectrician = getOrderElectricianRepository.findByOrderIdAndOrderElectricianStatusNotIn(orderCustomer.getOrderId(), listStatus);
				if(null!=orderElectrician){
					//修改电工订单状态 
					List<String> elecStatus = new ArrayList<String>();
					elecStatus.add("25");
					if(sites.contains(orderElectrician.getOrderElectricianStatus())){
						orderElectrician.setUpdateTime(nowDate);
						orderElectrician.setFinishTime(nowDate);
						orderElectrician.setOrderElectricianStatus(orderStatus);
						getOrderElectricianRepository.save(orderElectrician);
						//插入电工流水
						//sendNotify(map, orderCustomer , orderElectrician,2,"1");
						
						/*电工状态的修改由电工侧完成（发起验收时修改）
						ElecPosition elecPosition = elecPositionService.getElecPositionByElectricianId(orderElectrician.getElectricianId());
						Map<String,Object> elecPositionMap = new HashMap<String, Object>();
						elecPositionMap.put("electricianId", elecPosition.getElectricianId());
						elecPositionMap.put("status", "0");
						elecPositionService.saveElecPosition(elecPositionMap);*/
						
						//如果是差评，需要插入到考核记录表、电工差评投诉计数表
						String customerGrade = orderCustomer.getCustomerGrade();
						if("1".equals(customerGrade)||"2".equals(customerGrade)){
							Map<String,Object> assessRecordMap = new HashMap<String,Object>();
							assessRecordMap.put("companyId", orderElectrician.getRemarkStr2());
							assessRecordMap.put("orderId", orderElectrician.getOrDERId());
							//assessRecordMap.put("orderComplaintId", orderElectrician.get);
							assessRecordMap.put("assessStatus", "0");
							assessRecordMap.put("assessReason", "1");
							assessRecordMap.put("createTime", nowDate);
							assessRecordService.saveAssessRecord(assessRecordMap);
							
							Map<String,Object> elecErrorCountMap = new HashMap<String,Object>();
							elecErrorCountMap.put("electricianId", orderElectrician.getElectricianId());
							elecErrorCountMap.put("evaluateCount", "1");
							elecErrorCountMap.put("complaintCount", "1");
							elecErrorCountMap.put("forbidDay", "7");
							elecErrorCountService.saveElecErrorCount(elecErrorCountMap);
						}
						
						//费用划转
						
						String dateString = TimeStamp.toString(new Date());
						map.put("updateTime", dateString);
						map.put("finishTime", dateString);
						result.put("key", "0");
						result.put("desc", "该订单处于可验收状态");
						result.put("map", map);
					}else{
						result.put("key", "1");
						result.put("desc", "该订单不处于可验收状态");
					}
				}else{
					String dateString = TimeStamp.toString(new Date());
					map.put("updateTime", dateString);
					map.put("finishTime", dateString);
					result.put("key", "1");
					result.put("desc", "未找到子订单");
					result.put("map", map);
				}
				
			}else{
				result.put("key", "1");
				result.put("desc", "该订单不处于可验收状态");
			}
		}else if("9".equals(orderStatus)){
			ArrayList<String> sites = new ArrayList<>();
	        sites.add("8"); //待用户评价
			if(sites.contains(orderCustomer.getOrderStatus())){
				String dateString = TimeStamp.toString(new Date());
				map.put("updateTime", dateString);
				result.put("key", "0");
				result.put("desc", "该订单处于待评价状态");
				result.put("map", map);
			}else{
				result.put("key", "1");
				result.put("desc", "该订单不处于待评价状态");
			}
		}else if("26".equals(orderStatus)){
			ArrayList<String> sites = new ArrayList<>();
	        sites.add("23"); //待用户支付
			if(sites.contains(orderCustomer.getOrderStatus())){
				List<String> listStatus = new ArrayList<String>();
				listStatus.add("1");
				listStatus.add("4");
				listStatus.add("5");
				//获取当前子订单
				OrderElectrician orderElectrician = getOrderElectricianRepository.findByOrderIdAndOrderElectricianStatusNotIn(orderCustomer.getOrderId(), listStatus);
				if(null!=orderElectrician){
					//修改电工订单状态 由 23 改为26
					List<String> elecStatus = new ArrayList<String>();
					elecStatus.add("23");
					if(sites.contains(orderElectrician.getOrderElectricianStatus())){
						orderElectrician.setUpdateTime(nowDate);
						orderElectrician.setOrderElectricianStatus(orderStatus);
						getOrderElectricianRepository.save(orderElectrician);
						//插入电工流水
						sendNotify(map, orderCustomer , orderElectrician,2,"1");
						
						String dateString = TimeStamp.toString(new Date());
						map.put("updateTime", dateString);
						result.put("key", "0");
						result.put("desc", "该订单处于待支付状态");
						result.put("map", map);
					}else{
						result.put("key", "1");
						result.put("desc", "该订单的子订单不处于待支付状态");
					}
				}else{
					result.put("key", "1");
					result.put("desc", "未查询到子订单");
				}
		}else{
			result.put("key", "1");
			result.put("desc", "该订单不处于待支付状态");
		}
	}
		return result;
	}
	
	/**
	 * @param map
	 * @param orderCustomer
	 * @param oper 0增 1删 2改
	 * @param getPeople 0 客户订单 1 电工订单 2 投诉订单
	 * @throws Exception
	 */
	private void sendNotify(Map map,OrderCustomer orderCustomer,OrderElectrician orderElectrician,int oper,String getPeople) throws Exception{
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
		BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus(getPeople,  status);	
		
		//新增流水
		Map<String,Object> mapOrderFlow = null;
		if(!"1".equals(getPeople)){
			mapOrderFlow = MapUtil.flowAdd(orderCustomer.getOrderId(), 0,  Integer.parseInt(status), orderCustomer.getCustomerId(), TimeStamp.toString(new Date()), oper,  baseEnums.getEnumsA());
			orderFlowService.saveOrderFlow(mapOrderFlow);
		}else{
			//由于流水表关联的是主订单，所以子订单不插入流水表
			//新增通知
			List<String> statusList = new ArrayList<String>();
			statusList.add("3"); //用户支付维修费
			statusList.add("4"); //用户主动退单
			statusList.add("26"); //用户主动退回，电工重新填写价格
			if(statusList.contains(status)){
				String announceId = UuidUtil.getUuid32();
				
				Map<String,Object> mapNotify =
						MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", baseEnums.getEnumsB(), baseEnums.getEnumsC(), TimeStamp.toString(new Date()), 
								notifyType,orderElectrician.getOrDERId(),"");
				notifyAnnounceService.saveNotifyAnnounce(mapNotify);
				
				Map<String,Object> mapNotifyUser = 
						MapUtil.notifyUserAdd(orderElectrician.getElectricianId(), announceId, Integer.parseInt(getPeople), 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
				notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);
				
				//发送websocket消息
				Map<String,String> mapString = new HashMap<String,String>();
				//mapString.put("orderId", orderElectrician.getOrderElectricianId());
				mapString.put("orderId", "");
				mapString.put("content", baseEnums.getEnumsC());
				String jsonString = JsonUtils.toJson(mapString);
				WebSocketServer.sendInfo(jsonString,orderElectrician.getElectricianId());
			}
		}
	}
	
	@Override
	public QueryResultObject searchBox(String customerId,String tagType,String searchContent,Integer pageIndex,Integer pageSize) {
		List<OrderCustomer> orderCustomers = null;
		int count = 0;
		List<String> tagTypes = new ArrayList<String>();
		tagTypes.add("8");
		tagTypes.add("9");
		
		if("1".equals(tagType)){
			//只查现表
			tagTypes.add("4"); 
			orderCustomers = orderCustomerRepository.searchBoxNotIn(customerId,tagTypes,searchContent,pageIndex,pageSize);
		}else if("2".equals(tagType)){
			orderCustomers = orderCustomerRepository.searchBoxIn(customerId,tagTypes,searchContent,pageIndex,pageSize);
		}else{
			orderCustomers = orderCustomerRepository.searchBox(customerId,searchContent,pageIndex,pageSize);
		}
		
		if(orderCustomers!=null&&orderCustomers.size()>0){
			if("1".equals(tagType)){
				tagTypes.add("4"); 
				count = orderCustomerRepository.searchBoxNotInCount(customerId,tagTypes,searchContent);
			}else if("2".equals(tagType)){
				count = orderCustomerRepository.searchBoxInCount(customerId,tagTypes,searchContent);
			}else{
				count = orderCustomerRepository.searchBoxCount(customerId,searchContent);
			}
			
		}
		
		return RestUtils.wrappQueryResult(orderCustomers,count);
	}
	
	@Override
	public List<OrderCustomer> findByOrderStatus(List<String> orderStatus, String pastTime){
		List<OrderCustomer> list = orderCustomerRepository.findByOrderStatus(orderStatus,pastTime);
		return list;
	}
	
	@Override
	public List<OrderCustomer> findByOrderStatus(List<String> orderStatus, Integer pastTimeBegin, Integer pastTimeEnd){
		List<OrderCustomer> list = orderCustomerRepository.findByOrderStatusAndPasttime(orderStatus,pastTimeBegin,pastTimeEnd);
		return list;
	}
	
	@Override
	@Transactional
	public OrderCustomer payPrice(String orderId,String orderStatus) throws Exception{
		logger.info("OrderCustomerService payPrice = " +orderId + "," +orderStatus); 
		Timestamp nowDate =new Timestamp(System.currentTimeMillis());
		OrderCustomer orderCustomer = new OrderCustomer();
		OrderCustomer result = new OrderCustomer();
		
			//修改
			orderCustomer = orderCustomerRepository.findOne(orderId);
			
			String dateString = TimeStamp.toString(new Date());
			Map<String, Object> newMap = new HashMap<String, Object>();
			newMap.put("orderId", orderId);
			newMap.put("updateTime", dateString);
			newMap.put("orderStatus", orderStatus);
			
			if("3".equals(orderStatus)){
				if("23".equals(orderCustomer.getOrderStatus())){
					CrudUtils.mapToObject(newMap, orderCustomer,  "orderId");
					result = orderCustomerRepository.save(orderCustomer);
					//插入流水
					sendNotify(newMap, orderCustomer , null ,2,"0");
					//删除cust_position
					custPositionService.delete(orderId);
					
					//修改电工表状态
					List<String> listStatus = new ArrayList<String>();
					listStatus.add("1");
					listStatus.add("4");
					listStatus.add("5");
					//获取当前子订单
					OrderElectrician orderElectrician = getOrderElectricianRepository.findByOrderIdAndOrderElectricianStatusNotIn(orderCustomer.getOrderId(), listStatus);
					if(null!=orderElectrician){
						//修改电工订单状态 由 23 改为3
						if("23".equals(orderElectrician.getOrderElectricianStatus())){
							orderElectrician.setUpdateTime(nowDate);
							orderElectrician.setOrderElectricianStatus(orderStatus);
							getOrderElectricianRepository.save(orderElectrician);
							//插入电工流水
							sendNotify(newMap, orderCustomer , orderElectrician,2,"1");
						}else{
							throw new Exception("子订单状态异常");
						}
					}else{
						throw new Exception("未查询到子订单");
					}
				}else{
					throw new Exception("该订单未处于待支付状态");
				}
			}else{
				if("0".equals(orderCustomer.getOrderStatus())){
					CrudUtils.mapToObject(newMap, orderCustomer,  "orderId");
					result = orderCustomerRepository.save(orderCustomer);
					//插入 客户订单位置表
					HashMap<String, Object> positionMap = new HashMap<>();
					positionMap.put("orderId", orderId);
					positionMap.put("customerId", orderCustomer.getCustomerId());
					positionMap.put("areaId", orderCustomer.getCreateAreaId());
					positionMap.put("lon",  orderCustomer.getAddressLongitude());
					positionMap.put("lat",  orderCustomer.getAddressLatitude());
					custPositionService.saveCustPosition(positionMap);
					//插入流水
					sendNotify(newMap, orderCustomer , null,2,"0");
					//放入队列中，电工侧获取队列消息，群发给就近电工
					redisTemplate.opsForList().rightPush("newCustomerOrder", orderCustomer);
				}else{
					throw new Exception("该订单未处于待支付状态");
				}
			}
			
			
		return result;
	}
	
	
	
	
	/*************** TASK ******************/
	@Override
	@Transactional
	public boolean runElecEvaluateTask(){

		try{
			
			BaseSystemConfig baseSystemConfig = baseSystemConfigService.getBaseSystemConfigByConfigType("3");
			Integer days = Integer.parseInt(baseSystemConfig.getConfigValue());
			Integer updateCount = 0;
			String dateString = TimeStamp.toString(new Date());
			//修改用户待评价   5星 状态8 15天
			//updateCount = orderCustomerRepository.getNotEvaluate(5, "默认好评",  "默认好评", 8, days,dateString);
			List<EvaluateTaskBo> list1 = evaluateTaskRepository.findNotEvaluateOrderIds(8, days);
			List<String> orderIds8 = new ArrayList<String>();
			if(null!=list1&&!"".equals(list1)&&list1.size()>0){
				for(EvaluateTaskBo evaluateTaskBo : list1){
					orderIds8.add(evaluateTaskBo.getOrderId());
					//插入流水
					Map<String,Object> mapOrderFlow =
						MapUtil.flowAdd(evaluateTaskBo.getOrderId(), 2,  9, "SYSTEM", 
								TimeStamp.toString(new Date()), 2,  "系统修改长时间未评价的订单");
					orderFlowService.saveOrderFlow(mapOrderFlow);
					
					//删除cust_position 改成支付后删除
					//custPositionService.delete(evaluateTaskBo.getOrderId());
				}
				//修改主订单
				if(null!=orderIds8&&!"".equals(orderIds8)&&orderIds8.size()>0){
					updateCount = orderCustomerRepository.updateNotEvaluate(5, "默认好评",  "默认好评", 9, orderIds8,dateString);
					logger.info("EvaluateTask 修改待评价的主订单条数 = "+updateCount);
				}
			}
			
			//修改电工待评价   5星 状态8 15天
			List<EvaluateTaskBo> elist1 = evaluateTaskRepository.findNotEvaluateOrderElectricianIds(8, 15);
			List<String> eOrderIds8 = new ArrayList<String>();
			if(null!=elist1&&!"".equals(elist1)&&elist1.size()>0){
				for(EvaluateTaskBo evaluateTaskBo : elist1){
					eOrderIds8.add(evaluateTaskBo.getOrderId());
				}
				//修改主订单
				if(null!=eOrderIds8&&!"".equals(eOrderIds8)&&eOrderIds8.size()>0){
					updateCount = getOrderElectricianRepository.updateNotEvaluateByElecOrderId(5, "默认好评", 9, eOrderIds8,dateString);
					logger.info("EvaluateTask 修改待评价的子订单条数 = "+updateCount);
				}
			}
			
			
			/*15天未验收，且没有投诉的订单，自动完结，并划转*/
			List<String> orderIds25 = new ArrayList<String>();
			List<String> beComplantOrderIds = new ArrayList<String>();
			
			//查询满足条件的orderid 和 投诉状态 
			List<EvaluateTaskBo> list2 = evaluateTaskRepository.getNotPass(25, days);
			if(null!=list2&&!"".equals(list2)&&list2.size()>0){
				for(EvaluateTaskBo evaluateTaskBo : list2){
					String complaintStatus = evaluateTaskBo.getComplaintStatus();
					if("0".equals(complaintStatus)){
						beComplantOrderIds.add(evaluateTaskBo.getOrderId());
					}else{
						orderIds25.add(evaluateTaskBo.getOrderId());
					}
				}
				//集合去重
				orderIds25.removeAll(beComplantOrderIds);
				
				//修改主订单 子订单 
				if(null!=orderIds25&&!"".equals(orderIds25)&&orderIds25.size()>0){
					updateCount = orderCustomerRepository.updateNotEvaluateAndFinishtime(5, "默认好评",  "默认好评", 9, orderIds25,dateString);
					logger.info("EvaluateTask 修改待验收的主订单条数 = "+updateCount);
					updateCount = getOrderElectricianRepository.updateNotEvaluateByOrderId(5, "默认好评", 9, orderIds25,dateString);
					logger.info("EvaluateTask 修改待验收的子订单条数 = "+updateCount);
					
					for(String orderId : orderIds25){
						//插入流水
						Map<String,Object> mapOrderFlow =
							MapUtil.flowAdd(orderId, 2,  9, "SYSTEM", 
									TimeStamp.toString(new Date()), 2,  "系统修改长时间未验收的订单");
						orderFlowService.saveOrderFlow(mapOrderFlow);
						
						//费用划转
						
					}
				}
				
			}
			
		} catch (Exception e) {
            e.printStackTrace();
            System.out.println("runElecEvaluateTask error->" + e.getMessage());
            return false;
        }
		return true;
	}
	
	
	
	
	
	
	
	
	
	/*************** TASK ******************/
	
	
	
	
	
	
	/**
	 * 郭庆
	 * @param orderId
	 * @return
	 */
	public OrderCustomer findByOrderId(String orderId) {
		
		
		OrderCustomer orderCustomer = orderCustomerRepository.findByOrderId(orderId);
//		List<OrderCustomer> result=new ArrayList<>();
//		result.add(orderCustomer);
//		long count=0;
//		count=result.size();
		return orderCustomer;
		
		
	}
	
	public QueryResultObject findByOrderStatusLike() {
		// TODO Auto-generated method stub
		List<OrderCustomer> result =orderCustomerRepository.findByOrderStatusLike();
		long count=0;
		count=result.size();
		return RestUtils.wrappQueryResult(result,count);
	}
	
	/**
	 * 2020.12.23当时在orderElecricainController中查找了一下，发现没有被使用，就将其修改一下
	 */
	
	public OrderCustomer findOrderId(String orderId) {
		
		
		OrderCustomer orderIdString=orderCustomerRepository.findOne(orderId);
		return orderIdString;
	}
	public OrderCustomer findByOrderIdAndOrderStatus(String orderId) {
		OrderCustomer orderIdString=orderCustomerRepository.findByOrderIdAndOrderStatus(orderId);
		return orderIdString;
	}

	
	
	
	
	
}
