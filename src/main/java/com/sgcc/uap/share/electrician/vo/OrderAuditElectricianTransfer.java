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
	 * @date 2020-12-18 15:20:08
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
			orderAuditElectrician.setElectricianId(vo.getElectricianId());
			orderAuditElectrician.setElectricianName(vo.getElectricianName());
			orderAuditElectrician.setElectricianPhonenumber(vo.getElectricianPhonenumber());
			orderAuditElectrician.setElectricianLevel(vo.getElectricianLevel());
			orderAuditElectrician.setSubCompanyId(vo.getSubCompanyId());
			orderAuditElectrician.setCompanyId(vo.getCompanyId());
			orderAuditElectrician.setCompanyName(vo.getCompanyName());
			orderAuditElectrician.setRatingCertificate(vo.getRatingCertificate());
			orderAuditElectrician.setCompanyContract(vo.getCompanyContract());
			orderAuditElectrician.setIdentityInfo(vo.getIdentityInfo());
			orderAuditElectrician.setElectricianCertificate(vo.getElectricianCertificate());
			orderAuditElectrician.setCertificateA(vo.getCertificateA());
			orderAuditElectrician.setCertificateB(vo.getCertificateB());
			orderAuditElectrician.setCertificateC(vo.getCertificateC());
			orderAuditElectrician.setRemark(vo.getRemark());
        }
		return orderAuditElectrician;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return OrderAuditElectricianVO OrderAuditElectricianVO对象
	 * @date 2020-12-18 15:20:08
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
		vo.setElectricianId(po.getElectricianId());
		vo.setElectricianName(po.getElectricianName());
		vo.setElectricianPhonenumber(po.getElectricianPhonenumber());
		vo.setElectricianLevel(po.getElectricianLevel());
		vo.setSubCompanyId(po.getSubCompanyId());
		vo.setCompanyId(po.getCompanyId());
		vo.setCompanyName(po.getCompanyName());
		vo.setRatingCertificate(po.getRatingCertificate());
		vo.setCompanyContract(po.getCompanyContract());
		vo.setIdentityInfo(po.getIdentityInfo());
		vo.setElectricianCertificate(po.getElectricianCertificate());
		vo.setCertificateA(po.getCertificateA());
		vo.setCertificateB(po.getCertificateB());
		vo.setCertificateC(po.getCertificateC());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
