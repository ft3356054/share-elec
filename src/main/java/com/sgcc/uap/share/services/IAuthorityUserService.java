package com.sgcc.uap.share.services;

import java.util.Map;


import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.share.domain.AuthorityUser;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *
 * @author 18511
 */
public interface IAuthorityUserService {

	/**
	 * @getAuthorityUserById:根据主键 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2021-02-02 11:49:33
	 * @author 18511
	 */
	public QueryResultObject getAuthorityUserById(String id);
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
	 * @return AuthorityUser AuthorityUser对象
	 * @date 2021-02-02 11:49:33
	 * @author 18511
	 */
	public AuthorityUser saveAuthorityUser(Map<String,Object> map) throws Exception;
	/**
	 * @query:根据查询条件 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2021-02-02 11:49:33
	 * @author 18511
	 */
	public QueryResultObject query(RequestCondition queryCondition);



}
