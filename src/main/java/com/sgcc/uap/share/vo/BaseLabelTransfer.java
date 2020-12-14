package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.BaseLabel;

/**
 * <b>概述</b>：BaseLabelTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class BaseLabelTransfer {
	
	private BaseLabelTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return BaseLabel BaseLabel对象
	 * @date 2020-12-14 11:25:15
	 * @author 18511
	 */
	public static BaseLabel toPO(BaseLabelVO vo) {
		BaseLabel baseLabel = new BaseLabel();
		if(vo != null){
			baseLabel.setId(vo.getId());
			baseLabel.setLabelId(vo.getLabelId());
			baseLabel.setLabelName(vo.getLabelName());
			baseLabel.setLabelStatus(vo.getLabelStatus());
			baseLabel.setRemark(vo.getRemark());
        }
		return baseLabel;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseLabelVO BaseLabelVO对象
	 * @date 2020-12-14 11:25:15
	 * @author 18511
	 */
	public static BaseLabelVO toVO(BaseLabel po) {
		BaseLabelVO vo = new BaseLabelVO();
		vo.setId(po.getId());
		vo.setLabelId(po.getLabelId());
		vo.setLabelName(po.getLabelName());
		vo.setLabelStatus(po.getLabelStatus());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
