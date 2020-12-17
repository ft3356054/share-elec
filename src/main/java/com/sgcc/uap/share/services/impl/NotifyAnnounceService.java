package com.sgcc.uap.share.services.impl;

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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sgcc.uap.exception.NullArgumentException;
import com.sgcc.uap.mdd.runtime.validate.ValidateService;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryFilter;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.utils.CrudUtils;
import com.sgcc.uap.rest.utils.RestUtils;
import com.sgcc.uap.share.domain.BaseEnums;
import com.sgcc.uap.share.domain.NotifyAnnounce;
import com.sgcc.uap.share.domain.NotifyAnnounceUser;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.electrician.repositories.OrderElectricianRepository;
import com.sgcc.uap.share.repositories.NotifyAnnounceRepository;
import com.sgcc.uap.share.repositories.NotifyAnnounceUserRepository;
import com.sgcc.uap.share.services.INotifyAnnounceService;
import com.sgcc.uap.util.DateTimeUtil;
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
public class NotifyAnnounceService implements INotifyAnnounceService{
	/** 
     * 注入notifyAnnounceRepository
     */
	@Autowired
	private NotifyAnnounceRepository notifyAnnounceRepository;
	@Autowired
	private ValidateService validateService;
	@Autowired
	private NotifyAnnounceUserRepository notifyAnnounceUserRepository;
	@Autowired
	private OrderElectricianRepository orderElectricianRepository;
	@Autowired
	private NotifyAnnounceUserService notifyAnnounceUserService;
	@Autowired
	private BaseEnumsService baseEnumsService;
	
	
	@Override
	public QueryResultObject getNotifyAnnounceByAnnounceId(String announceId,String announceUserId) {
		NotifyAnnounce notifyAnnounce = notifyAnnounceRepository.findOne(announceId);
		if(null!=notifyAnnounce&&!"".equals(announceUserId)){
			NotifyAnnounceUser notifyAnnounceUser = notifyAnnounceUserRepository.findByAnnounceUserIdAndAnnounceId(announceUserId, announceId);
			if("0".equals(notifyAnnounceUser.getState())){
				notifyAnnounceUser.setState("1");
				notifyAnnounceUser.setReadTime(DateTimeUtil.formatDateTime(new Date()));
				notifyAnnounceUserRepository.save(notifyAnnounceUser);
			}
		}
		return RestUtils.wrappQueryResult(notifyAnnounce);
	}
	@Override
	public QueryResultObject getNotifyAnnounceByAnnounceIds(List<String> list) {
		List<NotifyAnnounce> notifyAnnounce = notifyAnnounceRepository.findByAnnounceIdIn(list);
		return RestUtils.wrappQueryResult(notifyAnnounce);
	}
	@Override
	public void remove(IDRequestObject idObject) {
		if(idObject == null){
			throw new NullArgumentException("idObject");
		}
		String[] ids = idObject.getIds();
		for (String id : ids){
			notifyAnnounceRepository.delete(id);
		}
	}
	
	@Override
	public NotifyAnnounce saveNotifyAnnounce(Map<String,Object> map) throws Exception{
		validateService.validateWithException(NotifyAnnounce.class,map);
		NotifyAnnounce notifyAnnounce = null;
		if (map.containsKey("announceId")) {
			String announceId = (String) map.get("announceId");
			notifyAnnounce = notifyAnnounceRepository.findOne(announceId);
			if(null!=notifyAnnounce){
				CrudUtils.mapToObject(map, notifyAnnounce,  "announceId");
			}else{
				notifyAnnounce = new NotifyAnnounce();
				CrudUtils.transMap2Bean(map, notifyAnnounce);
			}
		}else{
			notifyAnnounce = new NotifyAnnounce();
			CrudUtils.transMap2Bean(map, notifyAnnounce);
		}
		return notifyAnnounceRepository.save(notifyAnnounce);
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
		Specification<NotifyAnnounce> specification = new Specification<NotifyAnnounce>() {
			@Override
			public Predicate toPredicate(Root<NotifyAnnounce> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<NotifyAnnounce> notifyAnnounce = notifyAnnounceRepository.findAll(specification,request);
		List<NotifyAnnounce> result = new ArrayList<NotifyAnnounce>();
		long count = 0;
		if(null != qList && !qList.isEmpty()){
			result = notifyAnnounce.getContent();
			count = notifyAnnounce.getTotalElements();
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
		Specification<NotifyAnnounce> specification = new Specification<NotifyAnnounce>() {
			@Override
			public Predicate toPredicate(Root<NotifyAnnounce> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<NotifyAnnounce> notifyAnnounce = notifyAnnounceRepository.findAll(specification,request);
		List<NotifyAnnounce> result = new ArrayList<NotifyAnnounce>();
		long count = 0;
		result = notifyAnnounce.getContent();
		count = notifyAnnounce.getTotalElements();
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
		return new PageRequest(pageIndex - 1, pageSize, null);
	}

	@Override
	public QueryResultObject hastenByCustomer(String orderId) {
		try {
			ArrayList<String> orderElectricianType = new ArrayList<String>();
			orderElectricianType.add("4");
			orderElectricianType.add("5");
			OrderElectrician orderElectrician = orderElectricianRepository.findByOrderIdAndOrderElectricianTypeNotIn(orderId, orderElectricianType);
			
			if(null!=orderElectrician){
				String electricianId = orderElectrician.getElectricianId();
				
				//新增通知
				String announceId = UuidUtil.getUuid32();
				
				Map<String,Object> mapNotify =
						MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", "用户催单", "用户催单", TimeStamp.toString(new Date()), "1",orderId,"");
				
				saveNotifyAnnounce(mapNotify);
				
				
				Map<String,Object> mapNotifyUser = 
						MapUtil.notifyUserAdd(electricianId, announceId, 2, 0, TimeStamp.toString(new Date()), "用户催单");
				notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RestUtils.wrappQueryResult(null);
	}
	
	@Override
	public QueryResultObject userDefinedNotify(String orderId,String enumType,String enumStatus) {
		try {
			if("0".equals(enumType)){
				//给客户发通知
				
			}else if("1".equals(enumType)){
				//给电工发送通知
				ArrayList<String> orderElectricianType = new ArrayList<String>();
				orderElectricianType.add("4");
				orderElectricianType.add("5");
				OrderElectrician orderElectrician = orderElectricianRepository.findByOrderIdAndOrderElectricianTypeNotIn(orderId, orderElectricianType);
				
				if(null!=orderElectrician){
					String electricianId = orderElectrician.getElectricianId();
					//获取Enum通知类
					BaseEnums baseEnums = baseEnumsService.getBaseEnumsByTypeAndStatus(enumType,enumStatus);	
					//新增通知
					String announceId = UuidUtil.getUuid32();
					
					Map<String,Object> mapNotify =
							MapUtil.notifyAdd(announceId, "SYSTEM_ADMIN", baseEnums.getEnumsB(), baseEnums.getEnumsC(), TimeStamp.toString(new Date()), "1",orderId,baseEnums.getEnumsD());
					
					saveNotifyAnnounce(mapNotify);
					
					
					Map<String,Object> mapNotifyUser = 
							MapUtil.notifyUserAdd(electricianId, announceId, 2, 0, TimeStamp.toString(new Date()), baseEnums.getEnumsD());
					notifyAnnounceUserService.saveNotifyAnnounceUser(mapNotifyUser);
					
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RestUtils.wrappQueryResult(null);
	}
}
