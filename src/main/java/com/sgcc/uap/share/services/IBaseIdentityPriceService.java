package com.sgcc.uap.share.services;

import java.util.Map;


import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.share.domain.BaseIdentityPrice;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *
 * @author 18511
 */
public interface IBaseIdentityPriceService {

	/**
	 * @getBaseIdentityPriceByIdentityId:根据主键 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-30 14:16:50
	 * @author 18511
	 */
	public QueryResultObject getBaseIdentityPriceByIdentityId(String identityId);
	/**
	 * @remove:根据idObject删除
	 * @param idObject 主键id
	 * @return void
	 * @date 2020-11-30 14:16:50
	 * @author 18511
	 */
	public void remove(IDRequestObject idObject);
	/**
	 * @save:保存或更新
	 * @param map 保存或更新的数据
	 * @return BaseIdentityPrice BaseIdentityPrice对象
	 * @date 2020-11-30 14:16:50
	 * @author 18511
	 */
	public BaseIdentityPrice saveBaseIdentityPrice(Map<String,Object> map) throws Exception;
	/**
	 * @query:根据查询条件 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-30 14:16:50
	 * @author 18511
	 */
	public QueryResultObject query(RequestCondition queryCondition);



}
