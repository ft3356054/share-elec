package com.sgcc.uap.share.electrician.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.share.domain.OrderAuditElectrician;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *
 * @author 18511
 */
public interface IOrderAuditElectricianService {

	/**
	 * @getOrderAuditElectricianByOrderId:根据主键 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	public QueryResultObject getOrderAuditElectricianByOrderId(String orderId);
	/**
	 * @remove:根据idObject删除
	 * @param idObject 主键id
	 * @return void
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	public void remove(IDRequestObject idObject);
	/**
	 * @save:保存或更新
	 * @param map 保存或更新的数据
	 * @return OrderAuditElectrician OrderAuditElectrician对象
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	public OrderAuditElectrician saveOrderAuditElectrician(Map<String,Object> map) throws Exception;
	/**
	 * @query:根据查询条件 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	public QueryResultObject query(RequestCondition queryCondition);
	
	
	public OrderAuditElectrician save(Map<String, Object> map, MultipartFile file1, MultipartFile file2) throws IOException, Exception;



}
