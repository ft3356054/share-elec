package com.sgcc.uap.share.customer.vo;

import com.sgcc.uap.share.domain.OrderCustomer;

/**
 * <b>概述</b>：OrderCustomerTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class OrderCustomerTransfer {
	
	private OrderCustomerTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return OrderCustomer OrderCustomer对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static OrderCustomer toPO(OrderCustomerVO vo) {
		OrderCustomer orderCustomer = new OrderCustomer();
		if(vo != null){
			orderCustomer.setOrderId(vo.getOrderId());
			orderCustomer.setCustomerId(vo.getCustomerId());
			orderCustomer.setCustomerName(vo.getCustomerName());
			orderCustomer.setCustomerPhonenumber(vo.getCustomerPhonenumber());
			orderCustomer.setCustomerAddress(vo.getCustomerAddress());
			orderCustomer.setAddressLongitude(vo.getAddressLongitude());
			orderCustomer.setAddressLatitude(vo.getAddressLatitude());
			orderCustomer.setIdentityId(vo.getIdentityId());
			orderCustomer.setVoltage(vo.getVoltage());
			orderCustomer.setOrderTypeId(vo.getOrderTypeId());
			orderCustomer.setCustomerPrice(vo.getCustomerPrice());
			orderCustomer.setOrderStatus(vo.getOrderStatus());
			orderCustomer.setPayStatus(vo.getPayStatus());
			orderCustomer.setCreateTime(vo.getCreateTime());
			orderCustomer.setAppointmentTime(vo.getAppointmentTime());
			orderCustomer.setUpdateTime(vo.getUpdateTime());
			orderCustomer.setFinishTime(vo.getFinishTime());
			orderCustomer.setCustomerDescrive(vo.getCustomerDescrive());
			orderCustomer.setCustomerDescriveIcon(vo.getCustomerDescriveIcon());
			orderCustomer.setCustomerGrade(vo.getCustomerGrade());
			orderCustomer.setCustomerEvaluateTitle(vo.getCustomerEvaluateTitle());
			orderCustomer.setCustomerEvaluate(vo.getCustomerEvaluate());
			orderCustomer.setCustomerEvaluatePhoto(vo.getCustomerEvaluatePhoto());
			orderCustomer.setOrderComplaintId(vo.getOrderComplaintId());
			orderCustomer.setRemarkStr1(vo.getRemarkStr1());
			orderCustomer.setRemarkStr2(vo.getRemarkStr2());
			orderCustomer.setRemarkStr3(vo.getRemarkStr3());
			orderCustomer.setRemarkNum1(vo.getRemarkNum1());
			orderCustomer.setRemarkNum2(vo.getRemarkNum2());
        }
		return orderCustomer;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return OrderCustomerVO OrderCustomerVO对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static OrderCustomerVO toVO(OrderCustomer po) {
		OrderCustomerVO vo = new OrderCustomerVO();
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
