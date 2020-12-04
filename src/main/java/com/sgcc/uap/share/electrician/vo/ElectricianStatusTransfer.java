package com.sgcc.uap.share.electrician.vo;

import com.sgcc.uap.share.domain.ElectricianStatus;

/**
 * <b>概述</b>：ElectricianStatusTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class ElectricianStatusTransfer {
	
	private ElectricianStatusTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return ElectricianStatus ElectricianStatus对象
	 * @date 2020-12-04 17:27:43
	 * @author 18511
	 */
	public static ElectricianStatus toPO(ElectricianStatusVO vo) {
		ElectricianStatus electricianStatus = new ElectricianStatus();
		if(vo != null){
			electricianStatus.setElectricianId(vo.getElectricianId());
			electricianStatus.setElectricianStatus(vo.getElectricianStatus());
			electricianStatus.setAddressLongitude(vo.getAddressLongitude());
			electricianStatus.setAddressLatitude(vo.getAddressLatitude());
			electricianStatus.setOnlineTime(vo.getOnlineTime());
			electricianStatus.setOfflineTime(vo.getOfflineTime());
			electricianStatus.setRemark(vo.getRemark());
        }
		return electricianStatus;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return ElectricianStatusVO ElectricianStatusVO对象
	 * @date 2020-12-04 17:27:43
	 * @author 18511
	 */
	public static ElectricianStatusVO toVO(ElectricianStatus po) {
		ElectricianStatusVO vo = new ElectricianStatusVO();
		vo.setElectricianId(po.getElectricianId());
		vo.setElectricianStatus(po.getElectricianStatus());
		vo.setAddressLongitude(po.getAddressLongitude());
		vo.setAddressLatitude(po.getAddressLatitude());
		vo.setOnlineTime(po.getOnlineTime());
		vo.setOfflineTime(po.getOfflineTime());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
