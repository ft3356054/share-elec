package com.sgcc.uap.share.customer.vo;

import com.sgcc.uap.share.domain.OrderPay;

/**
 * <b>概述</b>：OrderPayTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class OrderPayTransfer {
	
	private OrderPayTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return OrderPay OrderPay对象
	 * @date 2021-01-21 15:04:55
	 * @author 18511
	 */
	public static OrderPay toPO(OrderPayVO vo) {
		OrderPay orderPay = new OrderPay();
		if(vo != null){
			orderPay.setPayId(vo.getPayId());
			orderPay.setOrderId(vo.getOrderId());
			orderPay.setPayType(vo.getPayType());
			orderPay.setPayUser(vo.getPayUser());
			orderPay.setPayUsreName(vo.getPayUsreName());
			orderPay.setElectricianId(vo.getElectricianId());
			orderPay.setElectricianName(vo.getElectricianName());
			orderPay.setCompanyId(vo.getCompanyId());
			orderPay.setCompanyName(vo.getCompanyName());
			orderPay.setInsuranceCompanyId(vo.getInsuranceCompanyId());
			orderPay.setInsuranceCompanyName(vo.getInsuranceCompanyName());
			orderPay.setPrice(vo.getPrice());
			orderPay.setPayTime(vo.getPayTime());
			orderPay.setPayStatus(vo.getPayStatus());
			orderPay.setRemark(vo.getRemark());
        }
		return orderPay;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return OrderPayVO OrderPayVO对象
	 * @date 2021-01-21 15:04:55
	 * @author 18511
	 */
	public static OrderPayVO toVO(OrderPay po) {
		OrderPayVO vo = new OrderPayVO();
		vo.setPayId(po.getPayId());
		vo.setOrderId(po.getOrderId());
		vo.setPayType(po.getPayType());
		vo.setPayUser(po.getPayUser());
		vo.setPayUsreName(po.getPayUsreName());
		vo.setElectricianId(po.getElectricianId());
		vo.setElectricianName(po.getElectricianName());
		vo.setCompanyId(po.getCompanyId());
		vo.setCompanyName(po.getCompanyName());
		vo.setInsuranceCompanyId(po.getInsuranceCompanyId());
		vo.setInsuranceCompanyName(po.getInsuranceCompanyName());
		vo.setPrice(po.getPrice());
		vo.setPayTime(po.getPayTime());
		vo.setPayStatus(po.getPayStatus());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
