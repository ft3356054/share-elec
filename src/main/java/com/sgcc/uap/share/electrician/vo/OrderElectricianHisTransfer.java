package com.sgcc.uap.share.electrician.vo;

import com.sgcc.uap.share.domain.OrderElectricianHis;

/**
 * <b>概述</b>：OrderElectricianHisTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class OrderElectricianHisTransfer {
	
	private OrderElectricianHisTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return OrderElectricianHis OrderElectricianHis对象
	 * @date 2020-12-04 14:22:14
	 * @author 18511
	 */
	public static OrderElectricianHis toPO(OrderElectricianHisVO vo) {
		OrderElectricianHis orderElectricianHis = new OrderElectricianHis();
		if(vo != null){
			orderElectricianHis.setOrderElectricianId(vo.getOrderElectricianId());
			orderElectricianHis.setOrderId(vo.getOrderId());
			orderElectricianHis.setElectricianId(vo.getElectricianId());
			orderElectricianHis.setElectricianName(vo.getElectricianName());
			orderElectricianHis.setElectricianPhonenumber(vo.getElectricianPhonenumber());
			orderElectricianHis.setElectricianAddress(vo.getElectricianAddress());
			orderElectricianHis.setOtherElectricianId(vo.getOtherElectricianId());
			orderElectricianHis.setOrderTypeId(vo.getOrderTypeId());
			orderElectricianHis.setElectricianPrice(vo.getElectricianPrice());
			orderElectricianHis.setOrderElectricianType(vo.getOrderElectricianType());
			orderElectricianHis.setPayStatus(vo.getPayStatus());
			orderElectricianHis.setCreateTime(vo.getCreateTime());
			orderElectricianHis.setBeginTime(vo.getBeginTime());
			orderElectricianHis.setUpdateTime(vo.getUpdateTime());
			orderElectricianHis.setFinishTime(vo.getFinishTime());
			orderElectricianHis.setElectricianDescrive(vo.getElectricianDescrive());
			orderElectricianHis.setElectricianDescriveIcon(vo.getElectricianDescriveIcon());
			orderElectricianHis.setElectricianGrade(vo.getElectricianGrade());
			orderElectricianHis.setElectricianEvaluate(vo.getElectricianEvaluate());
			orderElectricianHis.setChargebackReason(vo.getChargebackReason());
			orderElectricianHis.setOrderContract(vo.getOrderContract());
			orderElectricianHis.setInspectionReport(vo.getInspectionReport());
			orderElectricianHis.setRemarkStr1(vo.getRemarkStr1());
			orderElectricianHis.setRemarkStr2(vo.getRemarkStr2());
			orderElectricianHis.setRemarkStr3(vo.getRemarkStr3());
			orderElectricianHis.setRemarkNum1(vo.getRemarkNum1());
			orderElectricianHis.setRemarkNum2(vo.getRemarkNum2());
        }
		return orderElectricianHis;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return OrderElectricianHisVO OrderElectricianHisVO对象
	 * @date 2020-12-04 14:22:14
	 * @author 18511
	 */
	public static OrderElectricianHisVO toVO(OrderElectricianHis po) {
		OrderElectricianHisVO vo = new OrderElectricianHisVO();
		vo.setOrderElectricianId(po.getOrderElectricianId());
		vo.setOrderId(po.getOrderId());
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
		return vo;
	}
}
