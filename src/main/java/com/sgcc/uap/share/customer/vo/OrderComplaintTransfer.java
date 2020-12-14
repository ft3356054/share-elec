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
	 * @date 2020-12-14 11:25:12
	 * @author 18511
	 */
	public static OrderComplaint toPO(OrderComplaintVO vo) {
		OrderComplaint orderComplaint = new OrderComplaint();
		if(vo != null){
			orderComplaint.setOrderComplaintId(vo.getOrderComplaintId());
			orderComplaint.setOrderId(vo.getOrderId());
			orderComplaint.setComplaintType(vo.getComplaintType());
			orderComplaint.setComplaintDetail(vo.getComplaintDetail());
			orderComplaint.setComplaintPicture(vo.getComplaintPicture());
			orderComplaint.setServiceId(vo.getServiceId());
			orderComplaint.setResultsDetail(vo.getResultsDetail());
			orderComplaint.setRemark(vo.getRemark());
        }
		return orderComplaint;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return OrderComplaintVO OrderComplaintVO对象
	 * @date 2020-12-14 11:25:12
	 * @author 18511
	 */
	public static OrderComplaintVO toVO(OrderComplaint po) {
		OrderComplaintVO vo = new OrderComplaintVO();
		vo.setOrderComplaintId(po.getOrderComplaintId());
		vo.setOrderId(po.getOrderId());
		vo.setComplaintType(po.getComplaintType());
		vo.setComplaintDetail(po.getComplaintDetail());
		vo.setComplaintPicture(po.getComplaintPicture());
		vo.setServiceId(po.getServiceId());
		vo.setResultsDetail(po.getResultsDetail());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
