package com.sgcc.uap.share.electrician.vo;

import com.sgcc.uap.share.domain.ElecPosition;

/**
 * <b>概述</b>：ElecPositionTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class ElecPositionTransfer {
	
	private ElecPositionTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return ElecPosition ElecPosition对象
	 * @date 2020-12-21 09:31:09
	 * @author 18511
	 */
	public static ElecPosition toPO(ElecPositionVO vo) {
		ElecPosition elecPosition = new ElecPosition();
		if(vo != null){
			elecPosition.setElectricianId(vo.getElectricianId());
			elecPosition.setAreaId(vo.getAreaId());
			elecPosition.setLon(vo.getLon());
			elecPosition.setLat(vo.getLat());
        }
		return elecPosition;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return ElecPositionVO ElecPositionVO对象
	 * @date 2020-12-21 09:31:09
	 * @author 18511
	 */
	public static ElecPositionVO toVO(ElecPosition po) {
		ElecPositionVO vo = new ElecPositionVO();
		vo.setElectricianId(po.getElectricianId());
		vo.setAreaId(po.getAreaId());
		vo.setLon(po.getLon());
		vo.setLat(po.getLat());
		return vo;
	}
}
