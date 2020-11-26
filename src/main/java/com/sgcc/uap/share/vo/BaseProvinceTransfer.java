package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.BaseProvince;

/**
 * <b>概述</b>：BaseProvinceTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class BaseProvinceTransfer {
	
	private BaseProvinceTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return BaseProvince BaseProvince对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static BaseProvince toPO(BaseProvinceVO vo) {
		BaseProvince baseProvince = new BaseProvince();
		if(vo != null){
			baseProvince.setProvinceId(vo.getProvinceId());
			baseProvince.setProvinceName(vo.getProvinceName());
			baseProvince.setRegion(vo.getRegion());
			baseProvince.setRemark(vo.getRemark());
        }
		return baseProvince;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseProvinceVO BaseProvinceVO对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static BaseProvinceVO toVO(BaseProvince po) {
		BaseProvinceVO vo = new BaseProvinceVO();
		vo.setProvinceId(po.getProvinceId());
		vo.setProvinceName(po.getProvinceName());
		vo.setRegion(po.getRegion());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
