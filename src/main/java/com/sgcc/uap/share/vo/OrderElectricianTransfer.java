package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.OrderElectrician;

/**
 * <b>概述</b>：OrderElectricianTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class OrderElectricianTransfer {
	
	private OrderElectricianTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return OrderElectrician OrderElectrician对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static OrderElectrician toPO(OrderElectricianVO vo) {
		OrderElectrician orderElectrician = new OrderElectrician();
		if(vo != null){
			orderElectrician.setOrderElectricianId(vo.getOrderElectricianId());
			orderElectrician.setElectricianId(vo.getElectricianId());
			orderElectrician.setElectricianName(vo.getElectricianName());
			orderElectrician.setElectricianPhonenumber(vo.getElectricianPhonenumber());
			orderElectrician.setElectricianAddress(vo.getElectricianAddress());
			orderElectrician.setOtherElectricianId(vo.getOtherElectricianId());
			orderElectrician.setOrderTypeId(vo.getOrderTypeId());
			orderElectrician.setElectricianPrice(vo.getElectricianPrice());
			orderElectrician.setOrderElectricianType(vo.getOrderElectricianType());
			orderElectrician.setPayStatus(vo.getPayStatus());
			orderElectrician.setCreateTime(vo.getCreateTime());
			orderElectrician.setBeginTime(vo.getBeginTime());
			orderElectrician.setUpdateTime(vo.getUpdateTime());
			orderElectrician.setFinishTime(vo.getFinishTime());
			orderElectrician.setElectricianDescrive(vo.getElectricianDescrive());
			orderElectrician.setElectricianDescriveIcon(vo.getElectricianDescriveIcon());
			orderElectrician.setElectricianGrade(vo.getElectricianGrade());
			orderElectrician.setElectricianEvaluate(vo.getElectricianEvaluate());
			orderElectrician.setChargebackReason(vo.getChargebackReason());
			orderElectrician.setOrderContract(vo.getOrderContract());
			orderElectrician.setInspectionReport(vo.getInspectionReport());
			orderElectrician.setRemarkStr1(vo.getRemarkStr1());
			orderElectrician.setRemarkStr2(vo.getRemarkStr2());
			orderElectrician.setRemarkStr3(vo.getRemarkStr3());
			orderElectrician.setRemarkNum1(vo.getRemarkNum1());
			orderElectrician.setRemarkNum2(vo.getRemarkNum2());
			orderElectrician.setOrDERId(vo.getOrDERId());
        }
		return orderElectrician;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return OrderElectricianVO OrderElectricianVO对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static OrderElectricianVO toVO(OrderElectrician po) {
		OrderElectricianVO vo = new OrderElectricianVO();
		vo.setOrderElectricianId(po.getOrderElectricianId());
		vo.setElectricianId(po.getElectricianId());
		vo.setElectricianName(po.getElectricianName());
		vo.setElectricianPhonenumber(po.getElectricianPhonenumber());
		vo.setElectricianAddress(po.getElectricianAddress());
		vo.setOtherElectricianId(po.getOtherElectricianId());
		vo.setOrderTypeId(po.getOrderTypeId());
		vo.setElectricianPrice(po.getElectricianPrice());
		vo.setOrderElectricianType(po.getOrderElectricianType());
		vo.setPayStatus(po.getPayStatus());
		vo.setCreateTime(po.getCreateTime());
		vo.setBeginTime(po.getBeginTime());
		vo.setUpdateTime(po.getUpdateTime());
		vo.setFinishTime(po.getFinishTime());
		vo.setElectricianDescrive(po.getElectricianDescrive());
		vo.setElectricianDescriveIcon(po.getElectricianDescriveIcon());
		vo.setElectricianGrade(po.getElectricianGrade());
		vo.setElectricianEvaluate(po.getElectricianEvaluate());
		vo.setChargebackReason(po.getChargebackReason());
		vo.setOrderContract(po.getOrderContract());
		vo.setInspectionReport(po.getInspectionReport());
		vo.setRemarkStr1(po.getRemarkStr1());
		vo.setRemarkStr2(po.getRemarkStr2());
		vo.setRemarkStr3(po.getRemarkStr3());
		vo.setRemarkNum1(po.getRemarkNum1());
		vo.setRemarkNum2(po.getRemarkNum2());
		vo.setOrDERId(po.getOrDERId());
		return vo;
	}
}
