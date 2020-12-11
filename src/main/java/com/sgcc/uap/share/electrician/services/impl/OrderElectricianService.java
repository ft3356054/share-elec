package com.sgcc.uap.share.electrician.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.sgcc.uap.share.customer.services.impl.OrderFlowService;
import com.sgcc.uap.share.domain.ElectricianCompanyInfo;
import com.sgcc.uap.share.domain.ElectricianInfo;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.electrician.repositories.OrderElectricianRepository;
import com.sgcc.uap.share.electrician.services.IOrderElectricianService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceUserService;
import com.sgcc.uap.util.DateTimeUtil;
import com.sgcc.uap.util.MapUtil;
import com.sgcc.uap.util.SorterUtil;
import com.sgcc.uap.util.TimeStamp;
import com.sgcc.uap.util.UuidUtil;
import com.sgcc.uap.utils.string.StringUtil;

import ch.qos.logback.classic.Logger;



@Service
public class OrderElectricianService implements IOrderElectricianService{
	/** 
     * 注入orderElectricianRepository
     */
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
	private WebSocket webSocket;
	 
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
			String getNewOrderId=UuidUtil.getUuid46();
			//开始新增电工订单
			//先查询电工的信息
			QueryResultObject electricianResult = electricianInfoService.getElectricianInfoByElectricianId(electricianId);
			 List<ElectricianInfo> electricianList=electricianResult.getItems();
			 ElectricianInfo electricianInfo=null;
			 if(electricianList.size()==1){
				  electricianInfo=electricianList.get(0);
			 }
			map.put("electricianId", electricianInfo.getElectricianId());
			map.put("electricianName", electricianInfo.getElectricianName());
			map.put("electricianPhonenumber", electricianInfo.getElectricianPhonenumber());
			map.put("otherElectricianId", null);
			map.put("orderElectricianType", "2");
			map.put("payStatus", 1);//TODO  还没有确认订单的状态
			map.put("createTime", DateTimeUtil.formatDateTime(new Date()));
			map.put("updateTime", null);
			map.put("finishTime", null);
			
			
			CrudUtils.transMap2Bean(map, orderElectrician);
			result = orderElectricianRepository.save(orderElectrician);
			
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
		return null;
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
	public OrderElectrician saveOrderElectrician(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	}

	
	
	
	
	
	
	
	
	
	
	
	

