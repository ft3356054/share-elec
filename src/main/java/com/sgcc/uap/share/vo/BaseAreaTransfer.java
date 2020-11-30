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
	 * @date 2020-11-30 13:16:23
	 * @author 18511
	 */
	public static BaseArea toPO(BaseAreaVO vo) {
		BaseArea baseArea = new BaseArea();
		if(vo != null){
			baseArea.setId(vo.getId());
			baseArea.setAreaId(vo.getAreaId());
			baseArea.setProvinceName(vo.getProvinceName());
			baseArea.setRemark(vo.getRemark());
        }
		return baseArea;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseAreaVO BaseAreaVO对象
	 * @date 2020-11-30 13:16:23
	 * @author 18511
	 */
	public static BaseAreaVO toVO(BaseArea po) {
		BaseAreaVO vo = new BaseAreaVO();
		vo.setId(po.getId());
		vo.setAreaId(po.getAreaId());
		vo.setProvinceName(po.getProvinceName());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
