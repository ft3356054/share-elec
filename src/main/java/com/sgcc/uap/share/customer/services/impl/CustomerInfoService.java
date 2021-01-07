package com.sgcc.uap.share.customer.services.impl;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
import com.sgcc.uap.share.customer.repositories.CustomerInfoRepository;
import com.sgcc.uap.share.customer.services.ICustomerInfoService;
import com.sgcc.uap.share.domain.BaseEnums;
import com.sgcc.uap.share.domain.CustomerInfo;
import com.sgcc.uap.share.domain.OrderAuditElectrician;
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
@Service("customerInfoService")
public class CustomerInfoService implements ICustomerInfoService{
	/** 
     * 注入customerInfoRepository
     */
	@Autowired
	private CustomerInfoRepository customerInfoRepository;
	@Autowired
	private ValidateService validateService;
	
	@Override
	@Cacheable(cacheNames = "customerInfo" ,  keyGenerator = "wiselyKeyGenerator") //redis缓存
	public QueryResultObject getCustomerInfoByCustomerId(String customerId) {
		CustomerInfo customerInfo = customerInfoRepository.findCustomerInfoAndAuditStatus(customerId);
		if(null!=customerInfo){
			String auditStatus = customerInfo.getRemark();
			if("".equals(auditStatus)||null==auditStatus||"4".equals(auditStatus)){
				customerInfo.setAuditStatus("0");
			}else if("0".equals(auditStatus)){
				customerInfo.setAuditStatus("1");
			}
			/*else if("9".equals(auditStatus)){
				customerInfo.setAuditStatus("2");
			}*/
		}
		return RestUtils.wrappQueryResult(customerInfo);
	}
	
	
	@Override
	@CacheEvict(cacheNames = "customerInfo",keyGenerator = "wiselyKeyGenerator" , allEntries = true) //redis缓存
	public void remove(IDRequestObject idObject) {
		if(idObject == null){
			throw new NullArgumentException("idObject");
		}
		String[] ids = idObject.getIds();
		for (String id : ids){
			customerInfoRepository.delete(id);
		}
	}
	
	@Override
	@CacheEvict(cacheNames = "customerInfo",keyGenerator = "wiselyKeyGenerator" , allEntries = true) //redis缓存
	public CustomerInfo saveCustomerInfo(Map<String,Object> map) throws Exception{
		validateService.validateWithException(CustomerInfo.class,map);
		CustomerInfo customerInfo = null;
		if (map.containsKey("customerId")) {
			String customerId = (String) map.get("customerId");
			customerInfo = customerInfoRepository.findOne(customerId);
			if(null!=customerInfo){
				CrudUtils.mapToObject(map, customerInfo,  "customerId");
			}else{
				customerInfo = new CustomerInfo();
				CrudUtils.transMap2Bean(map, customerInfo);
			}
		}else{
			customerInfo = new CustomerInfo();
			CrudUtils.transMap2Bean(map, customerInfo);
		}
		return customerInfoRepository.save(customerInfo);
	}
	
	@Override
	@Transactional
	public OrderAuditElectrician changeToElecInfo(Map<String,Object> map,MultipartFile identityInfoFile,MultipartFile electricianCertificateFile) throws Exception{
		OrderAuditElectrician result = new OrderAuditElectrician();
		if (map.containsKey("customerId")) {
			//修改SUB_COMPANY_ID
			String customerId = (String) map.get("customerId");
			CustomerInfo customerInfo = customerInfoRepository.findOne(customerId);
			
			//上传图片
			/*if (null!=identityInfoFile&&!"".equals(identityInfoFile)) {
				String iconUrl = FileUtil.uploadFile(identityInfoFile, orderId,"ORDER_AUDIT_ELECTRICIAN","identityInfoFile");
				map.put(fileName, iconUrl);
			}
			Map<String, Object> newMap = (Map) getStatus.get("map");
			CrudUtils.mapToObject(newMap, orderCustomer,  "orderId");
			result = orderCustomerRepository.save(orderCustomer);
			sendNotify(newMap, orderCustomer , null,2,"0");*/
			
		}else{
			throw new Exception("提交文件格式错误");
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
		Specification<CustomerInfo> specification = new Specification<CustomerInfo>() {
			@Override
			public Predicate toPredicate(Root<CustomerInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<CustomerInfo> customerInfo = customerInfoRepository.findAll(specification,request);
		List<CustomerInfo> result = new ArrayList<CustomerInfo>();
		long count = 0;
		if(null != qList && !qList.isEmpty()){
			result = customerInfo.getContent();
			count = customerInfo.getTotalElements();
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
		Specification<CustomerInfo> specification = new Specification<CustomerInfo>() {
			@Override
			public Predicate toPredicate(Root<CustomerInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<CustomerInfo> customerInfo = customerInfoRepository.findAll(specification,request);
		List<CustomerInfo> result = new ArrayList<CustomerInfo>();
		long count = 0;
		result = customerInfo.getContent();
		count = customerInfo.getTotalElements();
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


}
