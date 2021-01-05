package com.sgcc.uap.share.customer.services;

import java.util.List;

import com.sgcc.uap.share.domain.OrderElectrician;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *
 * @author 18511
 */
public interface IGetOrderElectricianService {

	/**
	 * 通过 订单状态 批量获取订单
	 * @param orderElectricianType
	 * @param pastTime
	 * @return
	 */
	public List<OrderElectrician> findByOrderElectricianStatus(String orderElectricianStatus, String pastTime);
	
	/**
	 * 修改电工订单状态
	 * @param orderElectricianType
	 * @param pastTime
	 * @return
	 */
	public OrderElectrician updateOrderElectricianStatus(OrderElectrician orderElectrician);
}
