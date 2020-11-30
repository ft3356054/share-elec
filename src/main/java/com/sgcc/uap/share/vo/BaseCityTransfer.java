package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.BaseCity;

/**
 * <b>概述</b>：BaseCityTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class BaseCityTransfer {
	
	private BaseCityTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return BaseCity BaseCity对象
	 * @date 2020-11-30 13:16:25
	 * @author 18511
	 */
	public static BaseCity toPO(BaseCityVO vo) {
		BaseCity baseCity = new BaseCity();
		if(vo != null){
			baseCity.setId(vo.getId());
			baseCity.setCityId(vo.getCityId());
			baseCity.setProvinceId(vo.getProvinceId());
			baseCity.setCityName(vo.getCityName());
			baseCity.setRemark(vo.getRemark());
        }
		return baseCity;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseCityVO BaseCityVO对象
	 * @date 2020-11-30 13:16:25
	 * @author 18511
	 */
	public static BaseCityVO toVO(BaseCity po) {
		BaseCityVO vo = new BaseCityVO();
		vo.setId(po.getId());
		vo.setCityId(po.getCityId());
		vo.setProvinceId(po.getProvinceId());
		vo.setCityName(po.getCityName());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
