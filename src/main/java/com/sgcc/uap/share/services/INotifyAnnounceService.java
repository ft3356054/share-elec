package com.sgcc.uap.share.services;

import java.util.Map;

import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.share.domain.NotifyAnnounce;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *
 * @author 18511
 */
public interface INotifyAnnounceService {

	/**
	 * @getNotifyAnnounceByAnnounceId:根据主键 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public QueryResultObject getNotifyAnnounceByAnnounceId(String announceId,String announceUserId);
	public QueryResultObject getNotifyAnnounceByAnnounceIds(String announceUserId);
	public Long getNotReadNum(String announceUserId);
	/**
	 * @remove:根据idObject删除
	 * @param idObject 主键id
	 * @return void
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public void remove(IDRequestObject idObject);
	/**
	 * @save:保存或更新
	 * @param map 保存或更新的数据
	 * @return NotifyAnnounce NotifyAnnounce对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public NotifyAnnounce saveNotifyAnnounce(Map<String,Object> map) throws Exception;
	/**
	 * @query:根据查询条件 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public QueryResultObject query(RequestCondition queryCondition);

	/**
	 * @param orderId
	 * @return
	 */
	public QueryResultObject hastenByCustomer(String orderId);
	
	/**
	 * 自定义通知发送
	 * @param orderId
	 * @param enumType
	 * @param enumStatus
	 * @return
	 */
	public QueryResultObject userDefinedNotify(String orderId,String enumType,String enumStatus);

}
