package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.BaseAreaPrice;

/**
 * <b>概述</b>：BaseAreaPriceTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class BaseAreaPriceTransfer {
	
	private BaseAreaPriceTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return BaseAreaPrice BaseAreaPrice对象
	 * @date 2020-11-30 13:16:19
	 * @author 18511
	 */
	public static BaseAreaPrice toPO(BaseAreaPriceVO vo) {
		BaseAreaPrice baseAreaPrice = new BaseAreaPrice();
		if(vo != null){
			baseAreaPrice.setId(vo.getId());
			baseAreaPrice.setProvinceId(vo.getProvinceId());
			baseAreaPrice.setCityId(vo.getCityId());
			baseAreaPrice.setAreaId(vo.getAreaId());
			baseAreaPrice.setPrice(vo.getPrice());
			baseAreaPrice.setRemark(vo.getRemark());
        }
		return baseAreaPrice;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseAreaPriceVO BaseAreaPriceVO对象
	 * @date 2020-11-30 13:16:19
	 * @author 18511
	 */
	public static BaseAreaPriceVO toVO(BaseAreaPrice po) {
		BaseAreaPriceVO vo = new BaseAreaPriceVO();
		vo.setId(po.getId());
		vo.setProvinceId(po.getProvinceId());
		vo.setCityId(po.getCityId());
		vo.setAreaId(po.getAreaId());
		vo.setPrice(po.getPrice());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
