package com.sgcc.uap.share.customer.services;

/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *
 * @author 18511
 */
public interface IGetElectricianInfoService {

	/**
	 * @getElectricianInfoByElectricianId:根据主键 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-12-07 11:01:01
	 * @author 18511
	 */
	public boolean getElectricianInfoNumberByElectricianId(String electricianId);



}
