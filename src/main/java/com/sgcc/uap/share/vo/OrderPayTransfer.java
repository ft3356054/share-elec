package com.sgcc.uap.share.vo;

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
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static OrderPay toPO(OrderPayVO vo) {
		OrderPay orderPay = new OrderPay();
		if(vo != null){
			orderPay.setPayId(vo.getPayId());
			orderPay.setPayType(vo.getPayType());
			orderPay.setPayUser(vo.getPayUser());
			orderPay.setPrice(vo.getPrice());
			orderPay.setPayTime(vo.getPayTime());
			orderPay.setPayStatus(vo.getPayStatus());
			orderPay.setRemark(vo.getRemark());
			orderPay.setOrDERId(vo.getOrDERId());
        }
		return orderPay;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return OrderPayVO OrderPayVO对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static OrderPayVO toVO(OrderPay po) {
		OrderPayVO vo = new OrderPayVO();
		vo.setPayId(po.getPayId());
		vo.setPayType(po.getPayType());
		vo.setPayUser(po.getPayUser());
		vo.setPrice(po.getPrice());
		vo.setPayTime(po.getPayTime());
		vo.setPayStatus(po.getPayStatus());
		vo.setRemark(po.getRemark());
		vo.setOrDERId(po.getOrDERId());
		return vo;
	}
}
