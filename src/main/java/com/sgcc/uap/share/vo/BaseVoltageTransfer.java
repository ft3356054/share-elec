package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.BaseVoltage;

/**
 * <b>概述</b>：BaseVoltageTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class BaseVoltageTransfer {
	
	private BaseVoltageTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return BaseVoltage BaseVoltage对象
	 * @date 2020-12-21 17:22:38
	 * @author 18511
	 */
	public static BaseVoltage toPO(BaseVoltageVO vo) {
		BaseVoltage baseVoltage = new BaseVoltage();
		if(vo != null){
			baseVoltage.setVoltageId(vo.getVoltageId());
			baseVoltage.setVoltage(vo.getVoltage());
			baseVoltage.setRemark(vo.getRemark());
        }
		return baseVoltage;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseVoltageVO BaseVoltageVO对象
	 * @date 2020-12-21 17:22:38
	 * @author 18511
	 */
	public static BaseVoltageVO toVO(BaseVoltage po) {
		BaseVoltageVO vo = new BaseVoltageVO();
		vo.setVoltageId(po.getVoltageId());
		vo.setVoltage(po.getVoltage());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
