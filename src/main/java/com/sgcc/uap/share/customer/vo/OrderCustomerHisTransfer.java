package com.sgcc.uap.share.customer.vo;

import com.sgcc.uap.share.domain.OrderCustomerHis;

/**
 * <b>概述</b>：OrderCustomerHisTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class OrderCustomerHisTransfer {
	
	private OrderCustomerHisTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return OrderCustomerHis OrderCustomerHis对象
	 * @date 2020-12-04 14:22:15
	 * @author 18511
	 */
	public static OrderCustomerHis toPO(OrderCustomerHisVO vo) {
		OrderCustomerHis orderCustomerHis = new OrderCustomerHis();
		if(vo != null){
			orderCustomerHis.setOrderId(vo.getOrderId());
			orderCustomerHis.setCustomerId(vo.getCustomerId());
			orderCustomerHis.setCustomerName(vo.getCustomerName());
			orderCustomerHis.setCustomerPhonenumber(vo.getCustomerPhonenumber());
			orderCustomerHis.setCustomerAddress(vo.getCustomerAddress());
			orderCustomerHis.setAddressLongitude(vo.getAddressLongitude());
			orderCustomerHis.setAddressLatitude(vo.getAddressLatitude());
			orderCustomerHis.setIdentityId(vo.getIdentityId());
			orderCustomerHis.setVoltage(vo.getVoltage());
			orderCustomerHis.setOrderTypeId(vo.getOrderTypeId());
			orderCustomerHis.setCustomerPrice(vo.getCustomerPrice());
			orderCustomerHis.setOrderStatus(vo.getOrderStatus());
			orderCustomerHis.setPayStatus(vo.getPayStatus());
			orderCustomerHis.setCreateTime(vo.getCreateTime());
			orderCustomerHis.setAppointmentTime(vo.getAppointmentTime());
			orderCustomerHis.setUpdateTime(vo.getUpdateTime());
			orderCustomerHis.setFinishTime(vo.getFinishTime());
			orderCustomerHis.setCustomerDescrive(vo.getCustomerDescrive());
			orderCustomerHis.setCustomerDescriveIcon(vo.getCustomerDescriveIcon());
			orderCustomerHis.setCustomerGrade(vo.getCustomerGrade());
			orderCustomerHis.setCustomerEvaluateTitle(vo.getCustomerEvaluateTitle());
			orderCustomerHis.setCustomerEvaluate(vo.getCustomerEvaluate());
			orderCustomerHis.setCustomerEvaluatePhoto(vo.getCustomerEvaluatePhoto());
			orderCustomerHis.setOrderComplaintId(vo.getOrderComplaintId());
			orderCustomerHis.setRemarkStr1(vo.getRemarkStr1());
			orderCustomerHis.setRemarkStr2(vo.getRemarkStr2());
			orderCustomerHis.setRemarkStr3(vo.getRemarkStr3());
			orderCustomerHis.setRemarkNum1(vo.getRemarkNum1());
			orderCustomerHis.setRemarkNum2(vo.getRemarkNum2());
        }
		return orderCustomerHis;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return OrderCustomerHisVO OrderCustomerHisVO对象
	 * @date 2020-12-04 14:22:15
	 * @author 18511
	 */
	public static OrderCustomerHisVO toVO(OrderCustomerHis po) {
		OrderCustomerHisVO vo = new OrderCustomerHisVO();
		vo.setOrderId(po.getOrderId());
		vo.setCustomerId(po.getCustomerId());
		vo.setCustomerName(po.getCustomerName());
		vo.setCustomerPhonenumber(po.getCustomerPhonenumber());
		vo.setCustomerAddress(po.getCustomerAddress());
		vo.setAddressLongitude(po.getAddressLongitude());
		vo.setAddressLatitude(po.getAddressLatitude());
		vo.setIdentityId(po.getIdentityId());
		vo.setVoltage(po.getVoltage());
		vo.setOrderTypeId(po.getOrderTypeId());
		vo.setCustomerPrice(po.getCustomerPrice());
		vo.setOrderStatus(po.getOrderStatus());
		vo.setPayStatus(po.getPayStatus());
		vo.setCreateTime(po.getCreateTime());
		vo.setAppointmentTime(po.getAppointmentTime());
		vo.setUpdateTime(po.getUpdateTime());
		vo.setFinishTime(po.getFinishTime());
		vo.setCustomerDescrive(po.getCustomerDescrive());
		vo.setCustomerDescriveIcon(po.getCustomerDescriveIcon());
		vo.setCustomerGrade(po.getCustomerGrade());
		vo.setCustomerEvaluateTitle(po.getCustomerEvaluateTitle());
		vo.setCustomerEvaluate(po.getCustomerEvaluate());
		vo.setCustomerEvaluatePhoto(po.getCustomerEvaluatePhoto());
		vo.setOrderComplaintId(po.getOrderComplaintId());
		vo.setRemarkStr1(po.getRemarkStr1());
		vo.setRemarkStr2(po.getRemarkStr2());
		vo.setRemarkStr3(po.getRemarkStr3());
		vo.setRemarkNum1(po.getRemarkNum1());
		vo.setRemarkNum2(po.getRemarkNum2());
		return vo;
	}
}
