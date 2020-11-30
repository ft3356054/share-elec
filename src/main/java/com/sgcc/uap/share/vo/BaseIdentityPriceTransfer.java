package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.BaseIdentityPrice;

/**
 * <b>概述</b>：BaseIdentityPriceTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class BaseIdentityPriceTransfer {
	
	private BaseIdentityPriceTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return BaseIdentityPrice BaseIdentityPrice对象
	 * @date 2020-11-30 14:16:50
	 * @author 18511
	 */
	public static BaseIdentityPrice toPO(BaseIdentityPriceVO vo) {
		BaseIdentityPrice baseIdentityPrice = new BaseIdentityPrice();
		if(vo != null){
			baseIdentityPrice.setIdentityId(vo.getIdentityId());
			baseIdentityPrice.setIdentityPrice(vo.getIdentityPrice());
			baseIdentityPrice.setRemark(vo.getRemark());
        }
		return baseIdentityPrice;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseIdentityPriceVO BaseIdentityPriceVO对象
	 * @date 2020-11-30 14:16:50
	 * @author 18511
	 */
	public static BaseIdentityPriceVO toVO(BaseIdentityPrice po) {
		BaseIdentityPriceVO vo = new BaseIdentityPriceVO();
		vo.setIdentityId(po.getIdentityId());
		vo.setIdentityPrice(po.getIdentityPrice());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
