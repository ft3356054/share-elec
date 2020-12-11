package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.BaseEnums;

/**
 * <b>概述</b>：BaseEnumsTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class BaseEnumsTransfer {
	
	private BaseEnumsTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return BaseEnums BaseEnums对象
	 * @date 2020-12-11 10:02:24
	 * @author 18511
	 */
	public static BaseEnums toPO(BaseEnumsVO vo) {
		BaseEnums baseEnums = new BaseEnums();
		if(vo != null){
			baseEnums.setEnumsId(vo.getEnumsId());
			baseEnums.setEnumsType(vo.getEnumsType());
			baseEnums.setEnumsStatus(vo.getEnumsStatus());
			baseEnums.setEnumsA(vo.getEnumsA());
			baseEnums.setEnumsB(vo.getEnumsB());
			baseEnums.setEnumsC(vo.getEnumsC());
			baseEnums.setEnumsD(vo.getEnumsD());
			baseEnums.setEnumsE(vo.getEnumsE());
			baseEnums.setEnumsF(vo.getEnumsF());
			baseEnums.setRemark(vo.getRemark());
        }
		return baseEnums;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseEnumsVO BaseEnumsVO对象
	 * @date 2020-12-11 10:02:24
	 * @author 18511
	 */
	public static BaseEnumsVO toVO(BaseEnums po) {
		BaseEnumsVO vo = new BaseEnumsVO();
		vo.setEnumsId(po.getEnumsId());
		vo.setEnumsType(po.getEnumsType());
		vo.setEnumsStatus(po.getEnumsStatus());
		vo.setEnumsA(po.getEnumsA());
		vo.setEnumsB(po.getEnumsB());
		vo.setEnumsC(po.getEnumsC());
		vo.setEnumsD(po.getEnumsD());
		vo.setEnumsE(po.getEnumsE());
		vo.setEnumsF(po.getEnumsF());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
