package com.sgcc.uap.share.customer.vo;

import com.sgcc.uap.share.domain.OrderComplaint;

/**
 * <b>概述</b>：OrderComplaintTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class OrderComplaintTransfer {
	
	private OrderComplaintTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return OrderComplaint OrderComplaint对象
	 * @date 2020-12-14 12:00:46
	 * @author 18511
	 */
	public static OrderComplaint toPO(OrderComplaintVO vo) {
		OrderComplaint orderComplaint = new OrderComplaint();
		if(vo != null){
			orderComplaint.setOrderComplaintId(vo.getOrderComplaintId());
			orderComplaint.setOrderId(vo.getOrderId());
			orderComplaint.setCustomerId(vo.getCustomerId());
			orderComplaint.setCustomerName(vo.getCustomerName());
			orderComplaint.setCustomerPhonenumber(vo.getCustomerPhonenumber());
			orderComplaint.setCompanyId(vo.getCompanyId());
			orderComplaint.setCompanyName(vo.getCompanyName());
			orderComplaint.setComplaintType(vo.getComplaintType());
			orderComplaint.setCreateTime(vo.getCreateTime());
			orderComplaint.setUpdateTime(vo.getUpdateTime());
			orderComplaint.setFinishTime(vo.getFinishTime());
			orderComplaint.setComplaintStatus(vo.getComplaintStatus());
			orderComplaint.setComplaintDetail(vo.getComplaintDetail());
			orderComplaint.setComplaintPicture(vo.getComplaintPicture());
			orderComplaint.setServiceId(vo.getServiceId());
			orderComplaint.setResultsDetail(vo.getResultsDetail());
			orderComplaint.setRemark(vo.getRemark());
			orderComplaint.setRemark1(vo.getRemark1());
			orderComplaint.setRemark2(vo.getRemark2());
        }
		return orderComplaint;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return OrderComplaintVO OrderComplaintVO对象
	 * @date 2020-12-14 12:00:46
	 * @author 18511
	 */
	public static OrderComplaintVO toVO(OrderComplaint po) {
		OrderComplaintVO vo = new OrderComplaintVO();
		vo.setOrderComplaintId(po.getOrderComplaintId());
		vo.setOrderId(po.getOrderId());
		vo.setCustomerId(po.getCustomerId());
		vo.setCustomerName(po.getCustomerName());
		vo.setCustomerPhonenumber(po.getCustomerPhonenumber());
		vo.setCompanyId(po.getCompanyId());
		vo.setCompanyName(po.getCompanyName());
		vo.setComplaintType(po.getComplaintType());
		vo.setCreateTime(po.getCreateTime());
		vo.setUpdateTime(po.getUpdateTime());
		vo.setFinishTime(po.getFinishTime());
		vo.setComplaintStatus(po.getComplaintStatus());
		vo.setComplaintDetail(po.getComplaintDetail());
		vo.setComplaintPicture(po.getComplaintPicture());
		vo.setServiceId(po.getServiceId());
		vo.setResultsDetail(po.getResultsDetail());
		vo.setRemark(po.getRemark());
		vo.setRemark1(po.getRemark1());
		vo.setRemark2(po.getRemark2());
		return vo;
	}
}
