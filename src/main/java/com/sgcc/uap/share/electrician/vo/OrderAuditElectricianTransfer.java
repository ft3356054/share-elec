package com.sgcc.uap.share.electrician.vo;

import com.sgcc.uap.share.domain.OrderAuditElectrician;

/**
 * <b>概述</b>：OrderAuditElectricianTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class OrderAuditElectricianTransfer {
	
	private OrderAuditElectricianTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return OrderAuditElectrician OrderAuditElectrician对象
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	public static OrderAuditElectrician toPO(OrderAuditElectricianVO vo) {
		OrderAuditElectrician orderAuditElectrician = new OrderAuditElectrician();
		if(vo != null){
			orderAuditElectrician.setOrderId(vo.getOrderId());
			orderAuditElectrician.setOrderType(vo.getOrderType());
			orderAuditElectrician.setCreateTime(vo.getCreateTime());
			orderAuditElectrician.setUpdateTime(vo.getUpdateTime());
			orderAuditElectrician.setFinishTime(vo.getFinishTime());
			orderAuditElectrician.setAuditorId(vo.getAuditorId());
			orderAuditElectrician.setAuditorComment(vo.getAuditorComment());
			orderAuditElectrician.setSubCompanyId(vo.getSubCompanyId());
			orderAuditElectrician.setCompanyId(vo.getCompanyId());
			orderAuditElectrician.setCompanyName(vo.getCompanyName());
			orderAuditElectrician.setCompanyPhonenumber(vo.getCompanyPhonenumber());
			orderAuditElectrician.setCompanyAddress(vo.getCompanyAddress());
			orderAuditElectrician.setAddressLongitude(vo.getAddressLongitude());
			orderAuditElectrician.setAddressLatitude(vo.getAddressLatitude());
			orderAuditElectrician.setCompanyLevel(vo.getCompanyLevel());
			orderAuditElectrician.setRatingCertificate(vo.getRatingCertificate());
			orderAuditElectrician.setCompanyContract(vo.getCompanyContract());
			orderAuditElectrician.setRemark(vo.getRemark());
			orderAuditElectrician.setRemark1(vo.getRemark1());
			orderAuditElectrician.setRemark2(vo.getRemark2());
			orderAuditElectrician.setRemark3(vo.getRemark3());
        }
		return orderAuditElectrician;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return OrderAuditElectricianVO OrderAuditElectricianVO对象
	 * @date 2020-12-14 09:55:38
	 * @author 18511
	 */
	public static OrderAuditElectricianVO toVO(OrderAuditElectrician po) {
		OrderAuditElectricianVO vo = new OrderAuditElectricianVO();
		vo.setOrderId(po.getOrderId());
		vo.setOrderType(po.getOrderType());
		vo.setCreateTime(po.getCreateTime());
		vo.setUpdateTime(po.getUpdateTime());
		vo.setFinishTime(po.getFinishTime());
		vo.setAuditorId(po.getAuditorId());
		vo.setAuditorComment(po.getAuditorComment());
		vo.setSubCompanyId(po.getSubCompanyId());
		vo.setCompanyId(po.getCompanyId());
		vo.setCompanyName(po.getCompanyName());
		vo.setCompanyPhonenumber(po.getCompanyPhonenumber());
		vo.setCompanyAddress(po.getCompanyAddress());
		vo.setAddressLongitude(po.getAddressLongitude());
		vo.setAddressLatitude(po.getAddressLatitude());
		vo.setCompanyLevel(po.getCompanyLevel());
		vo.setRatingCertificate(po.getRatingCertificate());
		vo.setCompanyContract(po.getCompanyContract());
		vo.setRemark(po.getRemark());
		vo.setRemark1(po.getRemark1());
		vo.setRemark2(po.getRemark2());
		vo.setRemark3(po.getRemark3());
		return vo;
	}
}
