package com.sgcc.uap.share.services.impl;

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

import com.sgcc.uap.exception.NullArgumentException;
import com.sgcc.uap.mdd.runtime.validate.ValidateService;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryFilter;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.utils.CrudUtils;
import com.sgcc.uap.rest.utils.RestUtils;
import com.sgcc.uap.share.customer.services.IGetElectricianInfoService;
import com.sgcc.uap.share.domain.ElecErrorCount;
import com.sgcc.uap.share.domain.ElectricianInfo;
import com.sgcc.uap.share.repositories.ElecErrorCountRepository;
import com.sgcc.uap.share.services.IElecErrorCountService;
import com.sgcc.uap.util.TimeStamp;


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
public class ElecErrorCountService implements IElecErrorCountService{
	/** 
     * 注入elecErrorCountRepository
     */
	@Autowired
	private ElecErrorCountRepository elecErrorCountRepository;
	@Autowired
	private ValidateService validateService;
	@Autowired
	private IGetElectricianInfoService getElectricianInfoService;
	
	@Override
	public QueryResultObject getElecErrorCountByElectricianId(String electricianId) {
		ElecErrorCount elecErrorCount = elecErrorCountRepository.findOne(electricianId);
		return RestUtils.wrappQueryResult(elecErrorCount);
	}
	@Override
	public void remove(IDRequestObject idObject) {
		if(idObject == null){
			throw new NullArgumentException("idObject");
		}
		String[] ids = idObject.getIds();
		for (String id : ids){
			elecErrorCountRepository.delete(id);
		}
	}
	
	/*
	按用户对电工维修服务评价情况进行以下配置：
	获2星及以下评价三次暂停抢单：7天（自用户提交评价之日起）
	获2星及以下评价五次暂停抢单：15天（自用户提交评价之日起）
	获2星及以下评价五次以上取消资格
	获用户投诉且情况属实的暂停抢单：15天（自情况核实之日起）
	 * */
	@Override
	@Transactional
	public ElecErrorCount saveElecErrorCount(Map<String,Object> map) throws Exception{
		validateService.validateWithException(ElecErrorCount.class,map);
		ElecErrorCount elecErrorCount = new ElecErrorCount();
		if (map.containsKey("electricianId")) {
			String electricianId = (String) map.get("electricianId");
			elecErrorCount = elecErrorCountRepository.findOne(electricianId);
			
			if(!map.containsKey("evaluateCount")){
				map.put("evaluateCount", "0");
			}
			if(!map.containsKey("complaintCount")){
				map.put("complaintCount", "0");
			}
			
			if(null==elecErrorCount||"".equals(elecErrorCount)){
				//新增
				map.put("errorFlag", "0");
				
				String complaintCount = (String) map.get("complaintCount");
				if("0".equals(complaintCount)){
					map.remove("forbidDay");
					CrudUtils.transMap2Bean(map, elecErrorCount);
				}else{
					map.put("errorFlag", "1");
					Map<String,Object> updateMap = updateElecErrorAndInfo(map, elecErrorCount,true);
					elecErrorCount = new ElecErrorCount();
					CrudUtils.transMap2Bean(updateMap, elecErrorCount);
				}
				
			}else{
				//修改
				String evaluateCount = (String) map.get("evaluateCount");
				boolean flag = false; //默认是记录投诉
				if(!"0".equals(evaluateCount)){
					flag = true; //记录差评
				}
				
				if(flag){
					if(!"0".equals(elecErrorCount.getEvaluateCount())){
						int newEvaluateCount =  elecErrorCount.getEvaluateCount()+1;
						map.put("evaluateCount", newEvaluateCount);
						map.put("complaintCount", elecErrorCount.getComplaintCount());
						Map<String,Object> updateMap = updateElecErrorAndInfo(map, elecErrorCount,false);
						CrudUtils.mapToObject(updateMap, elecErrorCount,  "electricianId");
					}
				}else{
					if(!"0".equals(elecErrorCount.getComplaintCount())){
						int complaintCount =  elecErrorCount.getComplaintCount()+1;
						map.put("complaintCount", complaintCount);
						map.put("evaluateCount", elecErrorCount.getEvaluateCount());
						map.put("errorFlag", "1");
						Map<String,Object> updateMap = updateElecErrorAndInfo(map, elecErrorCount,true);
						CrudUtils.mapToObject(updateMap, elecErrorCount,  "electricianId");
					}
				}
			}
		}else{
			throw new Exception("类型electricianId不能为空值");
		}
		
		
		
		return elecErrorCountRepository.save(elecErrorCount);
	}
	
	
	/*
	公司被惩罚，修改所有旗下电工的状态
	 * */
	@Override
	@Transactional
	public void saveElecErrorCountByCompany(List<String> electricianIdList) throws Exception{
		//按id查询现有表
		List<ElecErrorCount> elecErrorCountList = elecErrorCountRepository.findElecErrorCountByElectricianIdIn(electricianIdList);
		String nowTime = TimeStamp.toString(new Date());
		if(elecErrorCountList.size()>0){
			//记录被停止接单的电工id
			List<String> electricianIdListInDb1 = new ArrayList<>();
			//记录未被停止接单的电工id
			List<String> electricianIdListInDb2 = new ArrayList<>();
			for(ElecErrorCount elecErrorCount:elecErrorCountList){
				if("1".equals(elecErrorCount.getErrorFlag())){
					electricianIdListInDb1.add(elecErrorCount.getElectricianId());
				}else if("0".equals(elecErrorCount.getErrorFlag())){
					electricianIdListInDb2.add(elecErrorCount.getElectricianId());
				}
				if(electricianIdList.contains(elecErrorCount.getElectricianId())){
					electricianIdList.remove(elecErrorCount.getElectricianId());
				}
			}
			//批量修改
			if(electricianIdListInDb1.size()>0){
				elecErrorCountRepository.updateElecErrorCounts1(electricianIdListInDb1,7);
			}
			if(electricianIdListInDb2.size()>0){
				elecErrorCountRepository.updateElecErrorCounts2(electricianIdListInDb2,7,nowTime);
			}
			
			
			//批量新增
			for(String electricianId:electricianIdList){
				ElecErrorCount elecErrorCount = new ElecErrorCount();
				elecErrorCount.setElectricianId(electricianId);
				elecErrorCount.setBeginTime(nowTime);
				elecErrorCount.setComplaintCount(0);
				elecErrorCount.setEvaluateCount(0);
				elecErrorCount.setErrorFlag("1");
				elecErrorCount.setForbidDay(7);
				elecErrorCountRepository.save(elecErrorCount);
			}
			
		}else{
			for(String electricianId:electricianIdList){
				ElecErrorCount elecErrorCount = new ElecErrorCount();
				elecErrorCount.setElectricianId(electricianId);
				elecErrorCount.setBeginTime(nowTime);
				elecErrorCount.setComplaintCount(0);
				elecErrorCount.setEvaluateCount(0);
				elecErrorCount.setErrorFlag("1");
				elecErrorCount.setForbidDay(7);
				elecErrorCountRepository.save(elecErrorCount);
			}
		}
		
		getElectricianInfoService.updateElectricianInfo(electricianIdList);
		
	}
	
	
	//被投诉，修改电工状态 true-complaintCount false-evaluateCount
	private Map<String,Object> updateElecErrorAndInfo(Map<String,Object> map,ElecErrorCount elecErrorCount,boolean typeFlag) throws Exception{
		String electricianId = (String) map.get("electricianId");
		ElectricianInfo electricianInfo = getElectricianInfoService.getElectricianInfoByElectricianId(electricianId);
		
		if(typeFlag){
			//电工自己更改的状态 0休息中 1工作中 4系统惩罚停止接单 5注销
			if("5".equals(electricianInfo.getElectricianStatus())){
				System.out.println("电工已注销");
			}else if("4".equals(electricianInfo.getElectricianStatus())){
				String forbidDay =  (String) map.get("forbidDay");
				if(null==elecErrorCount||"".equals(elecErrorCount)){
					map.put("forbidDay", forbidDay);
				}else
					map.put("forbidDay", elecErrorCount.getForbidDay()+ Integer.parseInt(forbidDay));
			}else{
				Map<String,Object> electricianInfoMap = new HashMap<String, Object>();
				electricianInfoMap.put("electricianId", electricianId);
				electricianInfoMap.put("electricianStatus", "4");
				getElectricianInfoService.saveElectricianInfo(electricianInfoMap);
				
				String forbidDay =  (String) map.get("forbidDay");
				map.put("forbidDay", forbidDay);
				map.put("beginTime", TimeStamp.toString(new Date()));
			}
		}else{
			//判断当前被差评的次数
			Integer evaluateCount =  (Integer) map.get("evaluateCount");
			Map<String,Object> electricianInfoMap = new HashMap<String, Object>();
			electricianInfoMap.put("electricianId", electricianId);
			
			if(evaluateCount>5){
				//取消资格
				if("5".equals(electricianInfo.getElectricianStatus())){
					System.out.println("电工已注销");
				}else{
					electricianInfoMap.put("electricianStatus", "5");
					getElectricianInfoService.saveElectricianInfo(electricianInfoMap);
					
					map.put("beginTime", TimeStamp.toString(new Date()));
				}
			}else if(evaluateCount==5){
				//停止接单+15天
				if("5".equals(electricianInfo.getElectricianStatus())){
					System.out.println("电工已注销");
				}else if("4".equals(electricianInfo.getElectricianStatus())){
					map.put("errorFlag", "1");
					String forbidDay =  (String) map.get("forbidDay");
					map.put("forbidDay", elecErrorCount.getForbidDay()+ Integer.parseInt(forbidDay));
				}else{
					electricianInfoMap.put("electricianStatus", "4");
					getElectricianInfoService.saveElectricianInfo(electricianInfoMap);
					
					map.put("errorFlag", "1");
					String forbidDay =  (String) map.get("forbidDay");
					map.put("forbidDay", elecErrorCount.getForbidDay()+ Integer.parseInt(forbidDay));
					map.put("beginTime", TimeStamp.toString(new Date()));
				}
			}else if(evaluateCount==3){
				//停止接单+7天
				if("5".equals(electricianInfo.getElectricianStatus())){
					System.out.println("电工已注销");
				}else if("4".equals(electricianInfo.getElectricianStatus())){
					map.put("errorFlag", "1");
					String forbidDay =  (String) map.get("forbidDay");
					map.put("forbidDay", elecErrorCount.getForbidDay()+ Integer.parseInt(forbidDay));
				}else{
					electricianInfoMap.put("electricianStatus", "4");
					getElectricianInfoService.saveElectricianInfo(electricianInfoMap);
					
					map.put("errorFlag", "1");
					String forbidDay =  (String) map.get("forbidDay");
					map.put("forbidDay", elecErrorCount.getForbidDay()+ Integer.parseInt(forbidDay));
					map.put("beginTime", TimeStamp.toString(new Date()));
				}
			}
		}
		String errorFlag = (String) map.get("errorFlag");
		if("0".equals(errorFlag)||null==errorFlag){
			//删除 暂停天数
			map.remove("forbidDay");
		}
		return map;
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
	 * @date 2021-01-29 10:17:13
	 * @author 18511
	 */
	private QueryResultObject querySingle(RequestCondition queryCondition) {
		List<QueryFilter> qList = getFilterList(queryCondition);
		Specification<ElecErrorCount> specification = new Specification<ElecErrorCount>() {
			@Override
			public Predicate toPredicate(Root<ElecErrorCount> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<ElecErrorCount> elecErrorCount = elecErrorCountRepository.findAll(specification,request);
		List<ElecErrorCount> result = new ArrayList<ElecErrorCount>();
		long count = 0;
		if(null != qList && !qList.isEmpty()){
			result = elecErrorCount.getContent();
			count = elecErrorCount.getTotalElements();
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
	 * @date 2021-01-29 10:17:13
	 * @author 18511
	 */
	private QueryResultObject queryCommon(RequestCondition queryCondition) {
		List<QueryFilter> qList = queryCondition.getQueryFilter(); 
		Specification<ElecErrorCount> specification = new Specification<ElecErrorCount>() {
			@Override
			public Predicate toPredicate(Root<ElecErrorCount> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
		Page<ElecErrorCount> elecErrorCount = elecErrorCountRepository.findAll(specification,request);
		List<ElecErrorCount> result = new ArrayList<ElecErrorCount>();
		long count = 0;
		result = elecErrorCount.getContent();
		count = elecErrorCount.getTotalElements();
		return RestUtils.wrappQueryResult(result, count);
	}
	
	/**
	 * @getFilterList:获取条件列表
	 * @param queryCondition 查询条件
	 * @return List<QueryFilter> 查询条件列表
	 * @date 2021-01-29 10:17:13
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
	 * @date 2021-01-29 10:17:13
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
