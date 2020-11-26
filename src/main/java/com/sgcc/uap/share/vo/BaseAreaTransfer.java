package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.BaseArea;

/**
 * <b>概述</b>：BaseAreaTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class BaseAreaTransfer {
	
	private BaseAreaTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return BaseArea BaseArea对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static BaseArea toPO(BaseAreaVO vo) {
		BaseArea baseArea = new BaseArea();
		if(vo != null){
			baseArea.setAreaId(vo.getAreaId());
			baseArea.setProvinceId(vo.getProvinceId());
			baseArea.setProvinceName(vo.getProvinceName());
			baseArea.setRemark(vo.getRemark());
			baseArea.setBaSProvinceId(vo.getBaSProvinceId());
        }
		return baseArea;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseAreaVO BaseAreaVO对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static BaseAreaVO toVO(BaseArea po) {
		BaseAreaVO vo = new BaseAreaVO();
		vo.setAreaId(po.getAreaId());
		vo.setProvinceId(po.getProvinceId());
		vo.setProvinceName(po.getProvinceName());
		vo.setRemark(po.getRemark());
		vo.setBaSProvinceId(po.getBaSProvinceId());
		return vo;
	}
}
