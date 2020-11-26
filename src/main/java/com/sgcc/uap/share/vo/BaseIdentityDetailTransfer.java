package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.BaseIdentityDetail;

/**
 * <b>概述</b>：BaseIdentityDetailTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class BaseIdentityDetailTransfer {
	
	private BaseIdentityDetailTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return BaseIdentityDetail BaseIdentityDetail对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static BaseIdentityDetail toPO(BaseIdentityDetailVO vo) {
		BaseIdentityDetail baseIdentityDetail = new BaseIdentityDetail();
		if(vo != null){
			baseIdentityDetail.setIdentityId(vo.getIdentityId());
			baseIdentityDetail.setIdentityName(vo.getIdentityName());
        }
		return baseIdentityDetail;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseIdentityDetailVO BaseIdentityDetailVO对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static BaseIdentityDetailVO toVO(BaseIdentityDetail po) {
		BaseIdentityDetailVO vo = new BaseIdentityDetailVO();
		vo.setIdentityId(po.getIdentityId());
		vo.setIdentityName(po.getIdentityName());
		return vo;
	}
}
