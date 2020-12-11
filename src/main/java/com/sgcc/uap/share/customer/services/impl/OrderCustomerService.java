package com.sgcc.uap.share.customer.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import com.sgcc.uap.share.controller.WebSocket;
import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;
import com.sgcc.uap.share.customer.services.IOrderCustomerService;
import com.sgcc.uap.share.domain.BaseAreaPrice;
import com.sgcc.uap.share.domain.BaseIdentityPrice;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.electrician.services.impl.OrderElectricianService;
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
    private WebSocket webSocket;
	
	@Override
	public QueryResultObject getOrderCustomerByOrderId(String orderId) {
		OrderCustomer orderCustomer = orderCustomerRepository.findOne(orderId);
		return RestUtils.wrappQueryResult(orderCustomer);
	}
	@Override
	public QueryResultObject getAllOrderCustomerByCustomerId(RequestCondition queryCondition) {
		if(queryCondition == null){
			throw new NullArgumentException("queryCondition");
		}
		
		Integer pageIndex = queryCondition.getPageIndex()-1;
		Integer pageSize = queryCondition.getPageSize();
		QueryFilter queryFilter = queryCondition.getQueryFilter().get(0); 
		String customerId = (String) queryFilter.getValue();
		
		List<OrderCustomer> result = orderCustomerRepository.getAllOrderCustomerByCustomerId(pageIndex,pageSize,customerId);
		long count = 0;
		count = result.size();
		return RestUtils.wrappQueryResult(result, count);
		
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
			CrudUtils.mapToObject(map, orderCustomer,  "orderId");
			result = orderCustomerRepository.save(orderCustomer);
		}else{
			String getNewOrderId = UuidUtil.getUuid46();
			//上传图片
			if (!file.isEmpty()) {
				String customerDescriveIcon = FileUtil.uploadFile(file, getNewOrderId,"ORDER_CUSTOMER", "CUSTOMER_DESCRIVE_ICON");
				map.put("customerDescriveIcon", customerDescriveIcon);
			}
			
			//新增order
			String identityId = (String) map.get("identityId");
			String provinceId = (String) map.get("provinceId");
			map.put("customerPrice", getPrice(identityId, provinceId));
			map.put("orderStatus", "0");
			map.put("payStatus", "0");
			map.put("createTime", DateTimeUtil.formatDateTime(new Date()));
			map.put("updateTime", DateTimeUtil.formatDateTime(new Date()));
			map.put("orderId", getNewOrderId);
			CrudUtils.transMap2Bean(map, orderCustomer);
			result = orderCustomerRepository.save(orderCustomer);
			
			//新增流水
			
			Map<String,Object> mapOrderFlow = 
					MapUtil.flowAdd(getNewOrderId, 0, 0, (String)map.get("customerId"), TimeStamp.toString(new Date()), 0,  "新增orderCustomer订单");
			orderFlowService.saveOrderFlow(mapOrderFlow);
			
			//新增通知
			String announceId = UuidUtil.getUuid32();
			
			Map<String,Object> mapNotify =
					MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", "待付勘察费", "待付勘察费，内容", TimeStamp.toString(new Date()), "新增客户待付款通知");
			notifyAnnounceService.saveNotifyAnnounce(mapNotify);
			
			Map<String,Object> mapNotifyUser = 
					MapUtil.notifyUserAdd((String)map.get("customerId"), announceId, 0, 0, TimeStamp.toString(new Date()), "新增客户待付款通知");
			notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);	
			
			//发送websocket消息
	        webSocket.sendMessage("有新的订单");
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
	
	/**
	 * 郭庆
	 * @param orderId
	 * @return
	 */
	public OrderCustomer findByOrderId(String orderId) {
		
		// TODO Auto-generated method stub
		OrderCustomer orderCustomer=orderCustomerRepository.findByOrderId(orderId);
		
		return orderCustomer;
	}
	
	public QueryResultObject findByOrderStatusLike() {
		// TODO Auto-generated method stub
		List<OrderCustomer> result =orderCustomerRepository.findByOrderStatusLike();
		long count=0;
		count=result.size();
		return RestUtils.wrappQueryResult(result,count);
	}


}
