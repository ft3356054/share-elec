package com.sgcc.uap.share.customer.services;

import java.util.List;
import java.util.Map;

import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.share.domain.CustPosition;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *
 * @author 18511
 */
public interface ICustPositionService {

	/**
	 * @getCustPositionByOrderId:根据主键 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-12-21 09:31:09
	 * @author 18511
	 */
	public CustPosition getCustPositionByOrderId(String orderId);
	public List<CustPosition> getByAreaId(String areaId);
	/**
	 * @remove:根据idObject删除
	 * @param idObject 主键id
	 * @return void
	 * @date 2020-12-21 09:31:09
	 * @author 18511
	 */
	public void remove(IDRequestObject idObject);
	public void delete(String orderId);
	/**
	 * @save:保存或更新
	 * @param map 保存或更新的数据
	 * @return CustPosition CustPosition对象
	 * @date 2020-12-21 09:31:09
	 * @author 18511
	 */
	public CustPosition saveCustPosition(Map<String,Object> map) throws Exception;
	/**
	 * @query:根据查询条件 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-12-21 09:31:09
	 * @author 18511
	 */
	public QueryResultObject query(RequestCondition queryCondition);



}
