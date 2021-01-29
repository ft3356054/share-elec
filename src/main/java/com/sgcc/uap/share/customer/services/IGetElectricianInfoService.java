package com.sgcc.uap.share.customer.services;

import java.util.Map;

import com.sgcc.uap.share.domain.ElectricianInfo;

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

	/**
	 * @getElectricianInfoByElectricianId:根据主键 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-12-07 11:01:01
	 * @author 18511
	 */
	public ElectricianInfo getElectricianInfoByElectricianId(String electricianId);
	/**
	 * @save:保存或更新
	 * @param map 保存或更新的数据
	 * @return ElectricianInfo ElectricianInfo对象
	 * @date 2020-12-07 11:01:01
	 * @author 18511
	 */
	public ElectricianInfo saveElectricianInfo(Map<String,Object> map) throws Exception;

}
