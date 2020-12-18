package com.sgcc.uap.share.electrician.services.impl;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import com.sgcc.uap.exception.NullArgumentException;
import com.sgcc.uap.mdd.runtime.validate.ValidateService;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryFilter;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.utils.CrudUtils;
import com.sgcc.uap.rest.utils.RestUtils;
import com.sgcc.uap.share.domain.OrderAuditElectrician;
import com.sgcc.uap.share.electrician.repositories.OrderAuditElectricianRepository;
import com.sgcc.uap.share.electrician.services.IOrderAuditElectricianService;
import com.sgcc.uap.util.FileUtil;



@Service
public class OrderAuditElectricianService implements IOrderAuditElectricianService{
	/** 
     * 注入orderAuditElectricianRepository
     */
	@Autowired
	private OrderAuditElectricianRepository orderAuditElectricianRepository;
	@Autowired
	private ValidateService validateService;
	
	@Override
	public QueryResultObject getOrderAuditElectricianByOrderId(String orderId) {
		OrderAuditElectrician orderAuditElectrician = orderAuditElectricianRepository.findOne(orderId);
		return RestUtils.wrappQueryResult(orderAuditElectrician);
	}
	@Override
	public void remove(IDRequestObject idObject) {
		if(idObject == null){
			throw new NullArgumentException("idObject");
		}
		String[] ids = idObject.getIds();
		for (String id : ids){
			orderAuditElectricianRepository.delete(id);
		}
	}
	@Override
	public OrderAuditElectrician saveOrderAuditElectrician(Map<String,Object> map) throws Exception{
		validateService.validateWithException(OrderAuditElectrician.class,map);
		OrderAuditElectrician orderAuditElectrician = new OrderAuditElectrician();
		if (map.containsKey("orderId")) {
			String orderId = (String) map.get("orderId");
			orderAuditElectrician = orderAuditElectricianRepository.findOne(orderId);
			CrudUtils.mapToObject(map, orderAuditElectrician,  "orderId");
		}else{
			CrudUtils.transMap2Bean(map, orderAuditElectrician);
		}
		return orderAuditElectricianRepository.save(orderAuditElectrician);
	}
	
	
	/**
	 * 保存新的订单
	 * file1     certificate_a        证件A           存放上传材料
	 * file2     rating_certificate   等级证书                           存放上传证书 
	 * @throws IOException 
	 */
	
	public OrderAuditElectrician save(Map<String, Object> map, MultipartFile file1, MultipartFile file2) throws Exception{
		
		
		String orderId=(String) map.get("orderId");
		OrderAuditElectrician orderAuditElectrician = orderAuditElectricianRepository.findOne(orderId);
		CrudUtils.mapToObject(map, orderAuditElectrician,  "orderId");
		
		
		if(file1.equals(map.get("orderElectricianType"))){
			
			//上传图片
			if (!file1.isEmpty()) {
				String certificate_a = FileUtil.uploadFile(file1, "Electrician","ORDER_ELECTRICIAN", "certificate_a");
				map.put("certificate_a", certificate_a);
			}
		}
		
		if(file1.equals(map.get("orderElectricianType"))){
			//上传图片
			if (!file2.isEmpty()) {
				String rating_certificate = FileUtil.uploadFile(file2, "Electrician","ORDER_ELECTRICIAN", "orderContract");
				map.put("rating_certificate", rating_certificate);
			}
		}
			
			
		
		
		return orderAuditElectricianRepository.save(orderAuditElectrician);
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
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	private QueryResultObject querySingle(RequestCondition queryCondition) {
		List<QueryFilter> qList = getFilterList(queryCondition);
		Specification<OrderAuditElectrician> specification = new Specification<OrderAuditElectrician>() {
			@Override
			public Predicate toPredicate(Root<OrderAuditElectrician> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<OrderAuditElectrician> orderAuditElectrician = orderAuditElectricianRepository.findAll(specification,request);
		List<OrderAuditElectrician> result = new ArrayList<OrderAuditElectrician>();
		long count = 0;
		if(null != qList && !qList.isEmpty()){
			result = orderAuditElectrician.getContent();
			count = orderAuditElectrician.getTotalElements();
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
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	private QueryResultObject queryCommon(RequestCondition queryCondition) {
		List<QueryFilter> qList = queryCondition.getQueryFilter(); 
		Specification<OrderAuditElectrician> specification = new Specification<OrderAuditElectrician>() {
			@Override
			public Predicate toPredicate(Root<OrderAuditElectrician> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<OrderAuditElectrician> orderAuditElectrician = orderAuditElectricianRepository.findAll(specification,request);
		List<OrderAuditElectrician> result = new ArrayList<OrderAuditElectrician>();
		long count = 0;
		result = orderAuditElectrician.getContent();
		count = orderAuditElectrician.getTotalElements();
		return RestUtils.wrappQueryResult(result, count);
	}
	
	/**
	 * @getFilterList:获取条件列表
	 * @param queryCondition 查询条件
	 * @return List<QueryFilter> 查询条件列表
	 * @date 2020-12-14 09:55:38
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
	 * @date 2020-12-14 09:55:38
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
