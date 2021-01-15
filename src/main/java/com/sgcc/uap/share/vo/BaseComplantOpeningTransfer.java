package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.BaseComplantOpening;

/**
 * <b>概述</b>：BaseComplantOpeningTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class BaseComplantOpeningTransfer {
	
	private BaseComplantOpeningTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return BaseComplantOpening BaseComplantOpening对象
	 * @date 2021-01-15 10:09:45
	 * @author 18511
	 */
	public static BaseComplantOpening toPO(BaseComplantOpeningVO vo) {
		BaseComplantOpening baseComplantOpening = new BaseComplantOpening();
		if(vo != null){
			baseComplantOpening.setOpeningId(vo.getOpeningId());
			baseComplantOpening.setOnBusinessBegin(vo.getOnBusinessBegin());
			baseComplantOpening.setOnBusinessEnd(vo.getOnBusinessEnd());
        }
		return baseComplantOpening;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseComplantOpeningVO BaseComplantOpeningVO对象
	 * @date 2021-01-15 10:09:45
	 * @author 18511
	 */
	public static BaseComplantOpeningVO toVO(BaseComplantOpening po) {
		BaseComplantOpeningVO vo = new BaseComplantOpeningVO();
		vo.setOpeningId(po.getOpeningId());
		vo.setOnBusinessBegin(po.getOnBusinessBegin());
		vo.setOnBusinessEnd(po.getOnBusinessEnd());
		return vo;
	}
}
