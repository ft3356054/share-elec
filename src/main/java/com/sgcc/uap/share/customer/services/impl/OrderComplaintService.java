package com.sgcc.uap.share.customer.services.impl;

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
import com.sgcc.uap.share.customer.repositories.OrderComplaintRepository;
import com.sgcc.uap.share.customer.repositories.OrderCustomerRepository;
import com.sgcc.uap.share.customer.services.IOrderComplaintService;
import com.sgcc.uap.share.customer.services.IOrderCustomerService;
import com.sgcc.uap.share.domain.BaseEnums;
import com.sgcc.uap.share.domain.ElectricianInfo;
import com.sgcc.uap.share.domain.OrderComplaint;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.electrician.repositories.ElectricianInfoRepository;
import com.sgcc.uap.share.electrician.repositories.OrderElectricianRepository;
import com.sgcc.uap.share.services.IBaseEnumsService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceService;
import com.sgcc.uap.share.services.impl.NotifyAnnounceUserService;
import com.sgcc.uap.util.DateTimeUtil;
import com.sgcc.uap.util.FileUtil;
import com.sgcc.uap.util.MapUtil;
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
public class OrderComplaintService implements IOrderComplaintService{
	/** 
     * 注入orderComplaintRepository
     */
	@Autowired
	private OrderComplaintRepository orderComplaintRepository;
	@Autowired
	private OrderCustomerRepository orderCustomerRepository;
	@Autowired
	private IOrderCustomerService orderCustomerService;
	@Autowired
	private OrderElectricianRepository orderElectricianRepository;
	@Autowired
	private ElectricianInfoRepository electricianInfoRepository;
	@Autowired
    private IBaseEnumsService baseEnumsService;
	@Autowired
	private NotifyAnnounceService notifyAnnounceService;
	@Autowired
	private NotifyAnnounceUserService notifyAnnounceUserService;
	@Autowired
	private OrderFlowService orderFlowService;
	@Autowired
	private ValidateService validateService;
	
	@Override
	public QueryResultObject getOrderComplaintByOrderComplaintId(String orderComplaintId) {
		OrderComplaint orderComplaint = orderComplaintRepository.findOne(orderComplaintId);
		return RestUtils.wrappQueryResult(orderComplaint);
	}
	@Override
	public void remove(IDRequestObject idObject) {
		if(idObject == null){
			throw new NullArgumentException("idObject");
		}
		String[] ids = idObject.getIds();
		for (String id : ids){
			orderComplaintRepository.delete(id);
		}
	}
	/*@Override
	public OrderComplaint saveOrderComplaint(Map<String,Object> map) throws Exception{
		validateService.validateWithException(OrderComplaint.class,map);
		OrderComplaint orderComplaint = new OrderComplaint();
		if (map.containsKey("orderComplaintId")) {
			String orderComplaintId = (String) map.get("orderComplaintId");
			orderComplaint = orderComplaintRepository.findOne(orderComplaintId);
			CrudUtils.mapToObject(map, orderComplaint,  "orderComplaintId");
		}else{
			CrudUtils.transMap2Bean(map, orderComplaint);
		}
		return orderComplaintRepository.save(orderComplaint);
	}*/
	@Override
	@Transactional
	public OrderComplaint saveOrderComplaint(Map<String,Object> map,MultipartFile file) throws Exception{
		validateService.validateWithException(OrderComplaint.class,map);
		OrderComplaint orderComplaint = new OrderComplaint();
		OrderComplaint result = new OrderComplaint();
		if (map.containsKey("orderComplaintId")) {
			//修改
			String orderComplaintId = (String) map.get("orderComplaintId");
			orderComplaint = orderComplaintRepository.findOne(orderComplaintId);
			CrudUtils.mapToObject(map, orderComplaint,  "orderComplaintId");
			result = orderComplaintRepository.save(orderComplaint);
			
			//上传图片
			if (null!=file&&!"".equals(file)) {
				String customerDescriveIcon = FileUtil.uploadFile(file, orderComplaintId,"ORDER_COMPLAINT", "COMPLAINT_PICTURE");
				map.put("customerDescriveIcon", customerDescriveIcon);
			}
			
		}else{
			String orderId = (String) map.get("orderId");
			String complaintDetail = (String) map.get("complaintDetail");
			String getNewOrderId = UuidUtil.getIntUuid32();
			
			//查询order表
			OrderCustomer orderCustomer = orderCustomerRepository.findOne(orderId);
			if(null!=orderCustomer){
				ArrayList<String> sites = new ArrayList<>();
		        sites.add("2");
		        sites.add("25");
				if(sites.contains(orderCustomer.getOrderStatus())){
					map.put("customerId", orderCustomer.getCustomerId());
					map.put("customerName", orderCustomer.getCustomerName());
					map.put("customerPhonenumber", orderCustomer.getCustomerPhonenumber());
					
					List<String> listStatus = new ArrayList<String>();
					listStatus.add("1");
					listStatus.add("4");
					listStatus.add("5");
					OrderElectrician orderElectrician = orderElectricianRepository.findByOrderIdAndOrderElectricianTypeNotIn(orderId, listStatus);
					if(null!=orderElectrician){
						ElectricianInfo electricianInfo = electricianInfoRepository.findOne(orderElectrician.getElectricianId());
						
						//上传图片
						if (null!=file&&!"".equals(file)) {
							String iconUrl = FileUtil.uploadFile(file, getNewOrderId,"ORDER_COMPLAINT", "COMPLAINT_PICTURE");
							map.put("complaintPicture", iconUrl);
						}
						
						map.put("companyId", electricianInfo.getSubCompanyId());
						map.put("companyName", electricianInfo.getCompanyName());
						map.put("complaintType", "0");
						map.put("createTime", DateTimeUtil.formatDateTime(new Date()));
						map.put("complaintStatus", "0");
						map.put("orderComplaintId", getNewOrderId);
						map.put("orderId", orderId);
						map.put("complaintDetail", complaintDetail);
						CrudUtils.transMap2Bean(map, orderComplaint);
						result = orderComplaintRepository.save(orderComplaint);
						
						//修改orderCustomer 添加投诉id
						Map<String, Object> newMap = new HashMap<String, Object>();
						newMap.put("orderId", orderId);
						newMap.put("orderComplaintId", getNewOrderId);
						orderCustomerService.updateOrderCustomer(newMap);
						
						
						//获取Enum通知类
						BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus("2", "0");	
						
						//新增流水
						Map<String,Object> mapOrderFlow = 
								MapUtil.flowAdd(orderCustomer.getOrderId(), 0, Integer.parseInt(orderCustomer.getOrderStatus()), (String)map.get("customerId"), TimeStamp.toString(new Date()), 0,  baseEnums.getEnumsA());
						orderFlowService.saveOrderFlow(mapOrderFlow);
						
						//新增通知
						/*String announceId = UuidUtil.getUuid32();
						
						Map<String,Object> mapNotify =
								MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", baseEnums.getEnumsB(), baseEnums.getEnumsC(), TimeStamp.toString(new Date()), 
										"1",orderCustomer.getOrderId(),"");
						notifyAnnounceService.saveNotifyAnnounce(mapNotify);
						
						Map<String,Object> mapNotifyUser = 
								MapUtil.notifyUserAdd((String)map.get("customerId"), announceId, 0, 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
						notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);*/	
						
						//发送websocket消息
				        //WebSocketServer.sendInfo("投诉成功",(String)map.get("customerId"));
						
					}else{
						throw new Exception("未查询到电工订单");
					}
					
				}else{
					//订单完结15日后，搬迁到历史表
					throw new Exception("当前订单不可被投诉");
				}
				
			}else{
				//订单完结15日后，搬迁到历史表
				throw new Exception("投诉期已过");
			}
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
	 * @date 2020-12-14 12:00:46
	 * @author 18511
	 */
	private QueryResultObject querySingle(RequestCondition queryCondition) {
		List<QueryFilter> qList = getFilterList(queryCondition);
		Specification<OrderComplaint> specification = new Specification<OrderComplaint>() {
			@Override
			public Predicate toPredicate(Root<OrderComplaint> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<OrderComplaint> orderComplaint = orderComplaintRepository.findAll(specification,request);
		List<OrderComplaint> result = new ArrayList<OrderComplaint>();
		long count = 0;
		if(null != qList && !qList.isEmpty()){
			result = orderComplaint.getContent();
			count = orderComplaint.getTotalElements();
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
	 * @date 2020-12-14 12:00:46
	 * @author 18511
	 */
	private QueryResultObject queryCommon(RequestCondition queryCondition) {
		List<QueryFilter> qList = queryCondition.getQueryFilter(); 
		Specification<OrderComplaint> specification = new Specification<OrderComplaint>() {
			@Override
			public Predicate toPredicate(Root<OrderComplaint> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<OrderComplaint> orderComplaint = orderComplaintRepository.findAll(specification,request);
		List<OrderComplaint> result = new ArrayList<OrderComplaint>();
		long count = 0;
		result = orderComplaint.getContent();
		count = orderComplaint.getTotalElements();
		return RestUtils.wrappQueryResult(result, count);
	}
	
	/**
	 * @getFilterList:获取条件列表
	 * @param queryCondition 查询条件
	 * @return List<QueryFilter> 查询条件列表
	 * @date 2020-12-14 12:00:46
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
	 * @date 2020-12-14 12:00:46
	 * @author 18511
	 */
	private PageRequest buildPageRequest(RequestCondition queryCondition) {
		int pageIndex = 1, pageSize = 1;
		if (queryCondition.getPageIndex() != null && queryCondition.getPageSize() != null) {
			pageIndex = queryCondition.getPageIndex();
			pageSize = queryCondition.getPageSize();
		}
		return new PageRequest(pageIndex - 1, pageSize, null);
	}


}
