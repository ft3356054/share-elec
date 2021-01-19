package com.sgcc.uap.share.electrician.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sgcc.uap.exception.NullArgumentException;
import com.sgcc.uap.mdd.runtime.validate.ValidateService;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryFilter;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.utils.CrudUtils;
import com.sgcc.uap.rest.utils.RestUtils;
import com.sgcc.uap.share.domain.ElecPosition;
import com.sgcc.uap.share.electrician.repositories.ElecPositionRepository;
import com.sgcc.uap.share.electrician.services.IElecPositionService;
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
@Transactional
public class ElecPositionService implements IElecPositionService{
	/** 
     * 注入elecPositionRepository
     */
	@Autowired
	private ElecPositionRepository elecPositionRepository;
	@Autowired
	private ValidateService validateService;
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public ElecPosition getElecPositionByElectricianId(String electricianId) {
		String json = stringRedisTemplate.opsForValue().get("ep"+electricianId);
		ElecPosition elecPosition = null;
		if("".equals(json)||null==json||"null".equals(json)){
			elecPosition = elecPositionRepository.findOne(electricianId);
			String posiJson = JsonUtils.toJsonString(elecPosition);
			stringRedisTemplate.opsForValue().set("ep"+electricianId, posiJson, 1L, TimeUnit.HOURS);
		}else{
			try {
				elecPosition = (ElecPosition) JsonUtils.json2Object(json, ElecPosition.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return elecPosition;
	}
	
	@Override
	public List<ElecPosition> getByAreaId(String areaId) {
		List<ElecPosition> elecPositions = elecPositionRepository.findByAreaId(areaId);
		return elecPositions;
	}
	
	
	@Override
	public void remove(IDRequestObject idObject) {
		if(idObject == null){
			throw new NullArgumentException("idObject");
		}
		String[] ids = idObject.getIds();
		for (String id : ids){
			elecPositionRepository.delete(id);
		}
	}
	
	@Override
	public ElecPosition saveElecPosition(Map<String,Object> map) throws Exception{
		validateService.validateWithException(ElecPosition.class,map);
		ElecPosition elecPosition = null;
		if (map.containsKey("electricianId")) {
			String electricianId = (String) map.get("electricianId");
			elecPosition = getElecPositionByElectricianId(electricianId);
			if(null!=elecPosition){
				CrudUtils.mapToObject(map, elecPosition,  "electricianId");
			}else{
				elecPosition = new ElecPosition();
				CrudUtils.transMap2Bean(map, elecPosition);
			}
		}else{
			throw new Exception("electricianId 不可为空");
		}
		
		String posiJson = JsonUtils.toJsonString(elecPosition);
		stringRedisTemplate.opsForValue().set("ep"+elecPosition.getElectricianId(), posiJson, 1L, TimeUnit.HOURS);
		return elecPositionRepository.save(elecPosition);
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
	 * @date 2020-12-21 09:31:09
	 * @author 18511
	 */
	private QueryResultObject querySingle(RequestCondition queryCondition) {
		List<QueryFilter> qList = getFilterList(queryCondition);
		Specification<ElecPosition> specification = new Specification<ElecPosition>() {
			@Override
			public Predicate toPredicate(Root<ElecPosition> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<ElecPosition> elecPosition = elecPositionRepository.findAll(specification,request);
		List<ElecPosition> result = new ArrayList<ElecPosition>();
		long count = 0;
		if(null != qList && !qList.isEmpty()){
			result = elecPosition.getContent();
			count = elecPosition.getTotalElements();
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
	 * @date 2020-12-21 09:31:09
	 * @author 18511
	 */
	private QueryResultObject queryCommon(RequestCondition queryCondition) {
		List<QueryFilter> qList = queryCondition.getQueryFilter(); 
		Specification<ElecPosition> specification = new Specification<ElecPosition>() {
			@Override
			public Predicate toPredicate(Root<ElecPosition> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<ElecPosition> elecPosition = elecPositionRepository.findAll(specification,request);
		List<ElecPosition> result = new ArrayList<ElecPosition>();
		long count = 0;
		result = elecPosition.getContent();
		count = elecPosition.getTotalElements();
		return RestUtils.wrappQueryResult(result, count);
	}
	
	/**
	 * @getFilterList:获取条件列表
	 * @param queryCondition 查询条件
	 * @return List<QueryFilter> 查询条件列表
	 * @date 2020-12-21 09:31:09
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
	 * @date 2020-12-21 09:31:09
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
