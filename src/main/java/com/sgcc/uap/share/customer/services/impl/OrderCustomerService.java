package com.sgcc.uap.share.customer.services.impl;

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
import com.sgcc.uap.share.customer.bo.OrderCustomerBeginPage;
import com.sgcc.uap.share.customer.repositories.GetOrderElectricianRepository;
import com.sgcc.uap.share.customer.repositories.OrderCustomerBeginPageRepository;
import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;
import com.sgcc.uap.share.customer.services.IOrderCustomerService;
import com.sgcc.uap.share.domain.BaseAreaPrice;
import com.sgcc.uap.share.domain.BaseEnums;
import com.sgcc.uap.share.domain.BaseIdentityPrice;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.electrician.services.impl.OrderElectricianService;
import com.sgcc.uap.share.services.IBaseEnumsService;
import com.sgcc.uap.share.services.impl.BaseAreaPriceService;
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
	private OrderElectricianService orderElectricianService;
	@Autowired
	private BaseIdentityPriceService baseIdentityPriceService;
	@Autowired
	private BaseAreaPriceService baseAreaPriceService;
	@Autowired
	private NotifyAnnounceService notifyAnnounceService;
	@Autowired
	private NotifyAnnounceUserService notifyAnnounceUserService;
	@Autowired
    private IBaseEnumsService baseEnumsService;
	@Autowired
    private OrderCustomerBeginPageRepository orderCustomerBeginPageRepository;
	@Autowired
    private GetOrderElectricianRepository getOrderElectricianRepository;
	@Autowired
	private CustPositionService custPositionService;
	@Autowired
    private RedisTemplate redisTemplate;
	
	@Override
	public QueryResultObject getOrderCustomerByOrderId(String orderId) {
		OrderCustomer orderCustomer = orderCustomerRepository.findOne(orderId);
		return RestUtils.wrappQueryResult(orderCustomer);
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
		QueryFilter queryFilter = queryCondition.getQueryFilter().get(0); 
		String customerId = (String) queryFilter.getValue();
		
		/*
		 0、23 待支付
			24 待验收
			8 待评价
		 * */
		if("beginPage".equals(pageType)){
			custStatus.add("0");
			custStatus.add("23");
			custStatus.add("25");
			custStatus.add("8");
			
			elecStatus.add("1");
			elecStatus.add("4");
			elecStatus.add("5");
			resultBeginPage = orderCustomerBeginPageRepository.getOrderCustomerByCustomerIdAndEnot(pageIndex,pageSize,customerId,custStatus,elecStatus);
			count = resultBeginPage.size();
			return RestUtils.wrappQueryResult(resultBeginPage, count);
		}else{
			result = orderCustomerRepository.getAllOrderCustomerByCustomerId(pageIndex,pageSize,customerId);
			count = result.size();
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
			
			Map<String, Object> getStatus = getOrderStatus(map, orderCustomer);
			
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
				sendNotify(newMap, orderCustomer,2,1);
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
			String areaId = "";
			if(!"".equals(cityId)&&null!=cityId){
				areaId = cityId;
			}else{
				areaId = provinceId;
			}
					
			map.put("createAreaId", areaId);
			map.put("customerPrice", getPrice(identityId, areaId));
			map.put("orderStatus", "0");
			map.put("payStatus", "0");
			map.put("orderFrom", "0");
			map.put("createTime", DateTimeUtil.formatDateTime(new Date()));
			map.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
			map.put("orderId", getNewOrderId);
			CrudUtils.transMap2Bean(map, orderCustomer);
			result = orderCustomerRepository.save(orderCustomer);
			
			//插入 客户订单位置表
			HashMap<String, Object> positionMap = new HashMap<>();
			positionMap.put("orderId", getNewOrderId);
			positionMap.put("customerId", (String) map.get("customerId"));
			positionMap.put("areaId", areaId);
			positionMap.put("lon",  map.get("addressLongitude"));
			positionMap.put("lat",  map.get("addressLatitude"));
			custPositionService.saveCustPosition(positionMap);
			
			//获取Enum通知类
			BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("0", "0");	
			
			//新增流水
			Map<String,Object> mapOrderFlow = 
					MapUtil.flowAdd(getNewOrderId, 0, 0, (String)map.get("customerId"), TimeStamp.toString(new Date()), 0,  baseEnums.getEnumsA());
			orderFlowService.saveOrderFlow(mapOrderFlow);
			
			//新增通知
			String announceId = UuidUtil.getUuid32();
			
			Map<String,Object> mapNotify =
					MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", baseEnums.getEnumsB(), baseEnums.getEnumsC(), TimeStamp.toString(new Date()), 
							"2",getNewOrderId,"");
			notifyAnnounceService.saveNotifyAnnounce(mapNotify);
			
			Map<String,Object> mapNotifyUser = 
					MapUtil.notifyUserAdd((String)map.get("customerId"), announceId, 1, 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
			notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);	
			
			//发送websocket消息
	        //WebSocketServer.sendInfo("下单成功",(String)map.get("customerId"));  前台自动反馈用户
			
			//放入队列中，电工侧获取队列消息，群发给就近电工
			redisTemplate.opsForList().rightPush("newCustomerOrder", orderCustomer);
			
		}
		return result;
	}
	
	
	
	@Override
	public OrderCustomer updateOrderCustomer(Map<String,Object> map){
		logger.info("OrderCustomerService updateOrderCustomer map = " +map); 
		OrderCustomer orderCustomer = new OrderCustomer();
		OrderCustomer result = new OrderCustomer();
		try {
		//修改
		String orderId = (String) map.get("orderId");
		orderCustomer = orderCustomerRepository.findOne(orderId);
			CrudUtils.mapToObject(map, orderCustomer,  "orderId");
			result = orderCustomerRepository.save(orderCustomer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		List<BaseAreaPrice> list = baseAreaPriceService.getBaseAreaPriceByProvinceId(provinceId);
		String areaPrice = list.get(0).getPrice();
		
		BigDecimal identityPriceBD=new BigDecimal(identityPrice);
		BigDecimal areaPriceBD=new BigDecimal(areaPrice);
		String resultBD = DecimalUtil.add(identityPriceBD,areaPriceBD).toString();
		
		return resultBD;
	}
	
	
	private Map<String,Object> getOrderStatus(Map map,OrderCustomer orderCustomer) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		
		String orderStatus = (String) map.get("orderStatus");
		
		if("4".equals(orderStatus)){
	        ArrayList<String> sites = new ArrayList<>();
	        sites.add("0");
	        sites.add("1");
	        sites.add("11");
	        sites.add("21");
			//用户主动取消订单
			if(sites.contains(orderCustomer.getOrderStatus())){
				List<String> listStatus = new ArrayList<String>();
				listStatus.add("1");
				listStatus.add("4");
				listStatus.add("5");
				//获取当前子订单
				OrderElectrician orderElectrician = getOrderElectricianRepository.findByOrderIdAndOrderElectricianTypeNotIn(orderCustomer.getOrderId(), listStatus);
				if(null!=orderElectrician){
					//通知电工
					//notifyAnnounceService.userDefinedNotify(orderCustomer.getOrderId(), "1", "4");
					//修改电工订单状态 由 0 2 21 改为 4
					List<String> elecStatus = new ArrayList<String>();
					elecStatus.add("0");
					elecStatus.add("2");
					elecStatus.add("21");
					if(sites.contains(orderCustomer.getOrderStatus())){
						orderElectricianService.esc(orderElectrician.getElectricianId(), orderStatus);
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
					result.put("desc", "该订单处于可取消状态");
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
			if(sites.contains(orderCustomer.getOrderStatus())){
				String dateString = TimeStamp.toString(new Date());
				map.put("updateTime", dateString);
				map.put("finishTime", dateString);
				result.put("key", "0");
				result.put("desc", "该订单处于待评价状态");
				result.put("map", map);
			}else{
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
		BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("1",  status);	
		
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
        WebSocketServer.sendInfo(baseEnums.getEnumsB(),(String)map.get("customerId"));
	}
	
	@Override
	public QueryResultObject searchBox(String customerId,String tagType,String searchContent) {
		List<OrderCustomer> orderCustomers = null;
		List<String> tagTypes = new ArrayList<String>();
		tagTypes.add("4");
		tagTypes.add("9");
		
		if("1".equals(tagType)){
			orderCustomers = orderCustomerRepository.searchBoxNotIn(customerId,tagTypes,searchContent);
		}else if("2".equals(tagType)){
			orderCustomers = orderCustomerRepository.searchBoxIn(customerId,tagTypes,searchContent);
		}else{
			orderCustomers = orderCustomerRepository.searchBox(customerId,searchContent);
		}
		
		return RestUtils.wrappQueryResult(orderCustomers);
	}
	
	@Override
	public List<OrderCustomer> findByOrderStatus(List<String> orderStatus, String pastTime){
		List<OrderCustomer> list = orderCustomerRepository.findByOrderStatus(orderStatus,pastTime);
		return list;
	}
	
	
	
	
	
	
	
	/**
	 * 郭庆
	 * @param orderId
	 * @return
	 */
	public QueryResultObject findByOrderId(String orderId) {
		
		
		OrderCustomer orderCustomer = orderCustomerRepository.findByOrderIdAndOrderStatus(orderId);
		List<OrderCustomer> result=new ArrayList<>();
		result.add(orderCustomer);
		long count=0;
		count=result.size();
		return RestUtils.wrappQueryResult(result,count);
		
		
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
	
	
	/*
	public QueryResultObject queryOrderDetails(String orderId) {
		List<OrderCustomer> result=orderCustomerRepository.findByOrderDetails(orderId);
		long count=0;
		count=result.size();
		return RestUtils.wrappQueryResult(result,count);
	}
*/
	
	
}
