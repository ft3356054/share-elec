package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.BaseOrderType;

/**
 * <b>概述</b>：BaseOrderTypeTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class BaseOrderTypeTransfer {
	
	private BaseOrderTypeTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return BaseOrderType BaseOrderType对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static BaseOrderType toPO(BaseOrderTypeVO vo) {
		BaseOrderType baseOrderType = new BaseOrderType();
		if(vo != null){
			baseOrderType.setOrderTypeId(vo.getOrderTypeId());
			baseOrderType.setOrderTypeName(vo.getOrderTypeName());
        }
		return baseOrderType;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseOrderTypeVO BaseOrderTypeVO对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static BaseOrderTypeVO toVO(BaseOrderType po) {
		BaseOrderTypeVO vo = new BaseOrderTypeVO();
		vo.setOrderTypeId(po.getOrderTypeId());
		vo.setOrderTypeName(po.getOrderTypeName());
		return vo;
	}
}
