package com.sgcc.uap.share.customer.services;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.share.domain.CustomerInfo;
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
public interface ICustomerInfoService {

	/**
	 * @getCustomerInfoByCustomerId:根据主键 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public CustomerInfo getCustomerInfoByCustomerId(String customerId);
	public CustomerInfo getCustomerInfoByOpenId(String openId);
	public boolean getNumberByCustomerId(String electricianId);
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
	 * @return CustomerInfo CustomerInfo对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public CustomerInfo saveCustomerInfo(Map<String,Object> map) throws Exception;
	
	/**
	 * 电工认证新增
	 * @param map
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	public OrderAuditElectrician changeToElecInfo(Map<String,Object> map,MultipartFile identityInfoFile,MultipartFile electricianCertificateFile) throws Exception;
	/**
	 * @query:根据查询条件 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public QueryResultObject query(RequestCondition queryCondition);



}
