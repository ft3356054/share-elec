package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.BaseSystemConfig;

/**
 * <b>概述</b>：BaseSystemConfigTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class BaseSystemConfigTransfer {
	
	private BaseSystemConfigTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return BaseSystemConfig BaseSystemConfig对象
	 * @date 2020-12-24 17:04:33
	 * @author 18511
	 */
	public static BaseSystemConfig toPO(BaseSystemConfigVO vo) {
		BaseSystemConfig baseSystemConfig = new BaseSystemConfig();
		if(vo != null){
			baseSystemConfig.setConfigId(vo.getConfigId());
			baseSystemConfig.setConfigName(vo.getConfigName());
			baseSystemConfig.setConfigValue(vo.getConfigValue());
			baseSystemConfig.setConfigType(vo.getConfigType());
			baseSystemConfig.setConfigStatus(vo.getConfigStatus());
        }
		return baseSystemConfig;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return BaseSystemConfigVO BaseSystemConfigVO对象
	 * @date 2020-12-24 17:04:33
	 * @author 18511
	 */
	public static BaseSystemConfigVO toVO(BaseSystemConfig po) {
		BaseSystemConfigVO vo = new BaseSystemConfigVO();
		vo.setConfigId(po.getConfigId());
		vo.setConfigName(po.getConfigName());
		vo.setConfigValue(po.getConfigValue());
		vo.setConfigType(po.getConfigType());
		vo.setConfigStatus(po.getConfigStatus());
		return vo;
	}
}
