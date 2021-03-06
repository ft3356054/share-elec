package com.sgcc.uap.share.electrician.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.sgcc.uap.share.domain.ElectricianCompanyInfo;
import com.sgcc.uap.share.electrician.repositories.ElectricianCompanyInfoRepository;
import com.sgcc.uap.share.electrician.services.IElectricianCompanyInfoService;
import com.sgcc.uap.util.MapUtil;


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
public class ElectricianCompanyInfoService implements IElectricianCompanyInfoService{
	/** 
     * 注入electricianCompanyInfoRepository
     */
	@Autowired
	private ElectricianCompanyInfoRepository electricianCompanyInfoRepository;
	@Autowired
	private ValidateService validateService;
	
	@Override
	public QueryResultObject getElectricianCompanyInfoByCompanyId(String companyId) {
		ElectricianCompanyInfo electricianCompanyInfo = electricianCompanyInfoRepository.findOne(companyId);
		return RestUtils.wrappQueryResult(electricianCompanyInfo);
	}
	@Override
	public void remove(IDRequestObject idObject) {
		if(idObject == null){
			throw new NullArgumentException("idObject");
		}
		String[] ids = idObject.getIds();
		for (String id : ids){
			electricianCompanyInfoRepository.delete(id);
		}
	}
	
	
	@Override
	public ElectricianCompanyInfo saveElectricianCompanyInfo(Map<String,Object> map) throws Exception{
		validateService.validateWithException(ElectricianCompanyInfo.class,map);
		//ElectricianCompanyInfo electricianCompanyInfo = new ElectricianCompanyInfo();
		ElectricianCompanyInfo electricianCompanyInfo = null;
		
		//String str=electricianCompanyInfo.toString();
		//logger.info("electricianCompanyInfo内容是："+str);		
		//System.out.println("----------------electricianCompanyInfo内容是："+str);
		String companyId2 = (String) map.get("companyId");
		System.out.println("-------***************-----companyId2："+companyId2);
		
		if (map.containsKey("companyId")) {
			String companyId = (String) map.get("companyId");
			electricianCompanyInfo = electricianCompanyInfoRepository.findOne(companyId);
			//CrudUtils.mapToObject(map, electricianCompanyInfo,  "companyId");
			if(electricianCompanyInfo!=null){
				CrudUtils.mapToObject(map, electricianCompanyInfo,  "companyId");
			}else{
				electricianCompanyInfo=new ElectricianCompanyInfo();
				CrudUtils.transMap2Bean(map, electricianCompanyInfo);
			}			
		}else{
			electricianCompanyInfo=new ElectricianCompanyInfo();
			CrudUtils.transMap2Bean(map, electricianCompanyInfo);
		}
		return electricianCompanyInfoRepository.save(electricianCompanyInfo);
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
	 * @date 2020-12-07 10:54:22
	 * @author 18511
	 */
	private QueryResultObject querySingle(RequestCondition queryCondition) {
		List<QueryFilter> qList = getFilterList(queryCondition);
		Specification<ElectricianCompanyInfo> specification = new Specification<ElectricianCompanyInfo>() {
			@Override
			public Predicate toPredicate(Root<ElectricianCompanyInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<ElectricianCompanyInfo> electricianCompanyInfo = electricianCompanyInfoRepository.findAll(specification,request);
		List<ElectricianCompanyInfo> result = new ArrayList<ElectricianCompanyInfo>();
		long count = 0;
		if(null != qList && !qList.isEmpty()){
			result = electricianCompanyInfo.getContent();
			count = electricianCompanyInfo.getTotalElements();
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
	 * @date 2020-12-07 10:54:22
	 * @author 18511
	 */
	private QueryResultObject queryCommon(RequestCondition queryCondition) {
		List<QueryFilter> qList = queryCondition.getQueryFilter(); 
		Specification<ElectricianCompanyInfo> specification = new Specification<ElectricianCompanyInfo>() {
			@Override
			public Predicate toPredicate(Root<ElectricianCompanyInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<ElectricianCompanyInfo> electricianCompanyInfo = electricianCompanyInfoRepository.findAll(specification,request);
		List<ElectricianCompanyInfo> result = new ArrayList<ElectricianCompanyInfo>();
		long count = 0;
		result = electricianCompanyInfo.getContent();
		count = electricianCompanyInfo.getTotalElements();
		return RestUtils.wrappQueryResult(result, count);
	}
	
	/**
	 * @getFilterList:获取条件列表
	 * @param queryCondition 查询条件
	 * @return List<QueryFilter> 查询条件列表
	 * @date 2020-12-07 10:54:22
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
	 * @date 2020-12-07 10:54:22
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
	public QueryResultObject queryMore(RequestCondition queryCondition) {
		if(queryCondition == null){
			throw new NullArgumentException("queryCondition");
		}
		
		Integer pageIndex = queryCondition.getPageIndex()-1;
		Integer pageSize = queryCondition.getPageSize();

		Map<String, String> map = MapUtil.getParam(queryCondition);
		
		List<ElectricianCompanyInfo> result = electricianCompanyInfoRepository.queryMore(pageIndex,pageSize,
				map.get("companyName"),map.get("companyLevel"),map.get("regiseterTimeBegin"),map.get("regiseterTimeEnd"));
		long count = 0;
		count = result.size();
		return RestUtils.wrappQueryResult(result, count);
	}
	public ElectricianCompanyInfo findByCompanyId(String companyId) {
		
ElectricianCompanyInfo electricianCompanyInfo=electricianCompanyInfoRepository.findOne(companyId);
		return electricianCompanyInfo;
	}
	public List<ElectricianCompanyInfo> findByCompanyAreaId(String areaId) {
		List<ElectricianCompanyInfo> list=electricianCompanyInfoRepository.findByCompanyAreaId(areaId);
		return list;
	}
	@Override
	public QueryResultObject queryCompany(String comcompanyName) {
		List<ElectricianCompanyInfo> list = electricianCompanyInfoRepository.queryCompany(comcompanyName);
		QueryResultObject resultObject=new QueryResultObject();
		Long itemCount=(long) 0;
		itemCount=(long) list.size();
		resultObject.setItemCount(itemCount);
		resultObject.setItems(list);
		return resultObject;
	}
	@Override
	public QueryResultObject selectCompany() {
		int page=0;
		int size=15;
		Pageable pageable=new PageRequest(page, size);
		Page<ElectricianCompanyInfo> electricianCompanyInfo = electricianCompanyInfoRepository.findAll(pageable);
		List<ElectricianCompanyInfo> result = new ArrayList<ElectricianCompanyInfo>();
		long count = 0;
		result = electricianCompanyInfo.getContent();
		count = electricianCompanyInfo.getTotalElements();
		return RestUtils.wrappQueryResult(result, count);
		
	
	}
}
