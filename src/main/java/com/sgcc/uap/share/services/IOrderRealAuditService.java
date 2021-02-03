package com.sgcc.uap.share.services;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.share.domain.OrderRealAudit;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *
 * @author 18511
 */
public interface IOrderRealAuditService {

	/**
	 * @getOrderRealAuditByOrderId:根据主键 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2021-02-02 11:49:33
	 * @author 18511
	 */
	public QueryResultObject getOrderRealAuditByOrderId(String orderId);
	/**
	 * @remove:根据idObject删除
	 * @param idObject 主键id
	 * @return void
	 * @date 2021-02-02 11:49:33
	 * @author 18511
	 */
	public void remove(IDRequestObject idObject);
	/**
	 * @save:保存或更新
	 * @param map 保存或更新的数据
	 * @return OrderRealAudit OrderRealAudit对象
	 * @date 2021-02-02 11:49:33
	 * @author 18511
	 */
	public OrderRealAudit saveOrderRealAudit(Map<String,Object> map,MultipartFile idCardFirst,MultipartFile idCardSecond) throws Exception;
	/**
	 * @query:根据查询条件 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2021-02-02 11:49:33
	 * @author 18511
	 */
	public QueryResultObject query(RequestCondition queryCondition);



}
