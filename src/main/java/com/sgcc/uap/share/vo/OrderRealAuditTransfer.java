package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.OrderRealAudit;

/**
 * <b>概述</b>：OrderRealAuditTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class OrderRealAuditTransfer {
	
	private OrderRealAuditTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return OrderRealAudit OrderRealAudit对象
	 * @date 2021-02-02 11:49:33
	 * @author 18511
	 */
	public static OrderRealAudit toPO(OrderRealAuditVO vo) {
		OrderRealAudit orderRealAudit = new OrderRealAudit();
		if(vo != null){
			orderRealAudit.setOrderId(vo.getOrderId());
			orderRealAudit.setOrderStatus(vo.getOrderStatus());
			orderRealAudit.setCreateTime(vo.getCreateTime());
			orderRealAudit.setUpdateTime(vo.getUpdateTime());
			orderRealAudit.setFinishTime(vo.getFinishTime());
			orderRealAudit.setAuditorId(vo.getAuditorId());
			orderRealAudit.setAuditorComment(vo.getAuditorComment());
			orderRealAudit.setUserId(vo.getUserId());
			orderRealAudit.setUserName(vo.getUserName());
			orderRealAudit.setUserType(vo.getUserType());
			orderRealAudit.setCompanyId(vo.getCompanyId());
			orderRealAudit.setPhonenumber(vo.getPhonenumber());
			orderRealAudit.setEmail(vo.getEmail());
			orderRealAudit.setAddress(vo.getAddress());
			orderRealAudit.setIdCardNum(vo.getIdCardNum());
			orderRealAudit.setIdCardFirst(vo.getIdCardFirst());
			orderRealAudit.setIdCardSecond(vo.getIdCardSecond());
			orderRealAudit.setUserIcon(vo.getUserIcon());
			orderRealAudit.setRemark(vo.getRemark());
        }
		return orderRealAudit;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return OrderRealAuditVO OrderRealAuditVO对象
	 * @date 2021-02-02 11:49:33
	 * @author 18511
	 */
	public static OrderRealAuditVO toVO(OrderRealAudit po) {
		OrderRealAuditVO vo = new OrderRealAuditVO();
		vo.setOrderId(po.getOrderId());
		vo.setOrderStatus(po.getOrderStatus());
		vo.setCreateTime(po.getCreateTime());
		vo.setUpdateTime(po.getUpdateTime());
		vo.setFinishTime(po.getFinishTime());
		vo.setAuditorId(po.getAuditorId());
		vo.setAuditorComment(po.getAuditorComment());
		vo.setUserId(po.getUserId());
		vo.setUserName(po.getUserName());
		vo.setUserType(po.getUserType());
		vo.setCompanyId(po.getCompanyId());
		vo.setPhonenumber(po.getPhonenumber());
		vo.setEmail(po.getEmail());
		vo.setAddress(po.getAddress());
		vo.setIdCardNum(po.getIdCardNum());
		vo.setIdCardFirst(po.getIdCardFirst());
		vo.setIdCardSecond(po.getIdCardSecond());
		vo.setUserIcon(po.getUserIcon());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
