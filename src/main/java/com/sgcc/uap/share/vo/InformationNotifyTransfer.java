package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.InformationNotify;

/**
 * <b>概述</b>：InformationNotifyTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class InformationNotifyTransfer {
	
	private InformationNotifyTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return InformationNotify InformationNotify对象
	 * @date 2021-01-20 12:31:14
	 * @author 18511
	 */
	public static InformationNotify toPO(InformationNotifyVO vo) {
		InformationNotify informationNotify = new InformationNotify();
		if(vo != null){
			informationNotify.setInformationId(vo.getInformationId());
			informationNotify.setInformationType(vo.getInformationType());
			informationNotify.setInformationStatus(vo.getInformationStatus());
			informationNotify.setCreateTime(vo.getCreateTime());
			informationNotify.setUpdateTime(vo.getUpdateTime());
			informationNotify.setFinishTime(vo.getFinishTime());
			informationNotify.setServiceId(vo.getServiceId());
			informationNotify.setServiceName(vo.getServiceName());
			informationNotify.setInformationTitle(vo.getInformationTitle());
			informationNotify.setInformationFrom(vo.getInformationFrom());
			informationNotify.setKeyword(vo.getKeyword());
			informationNotify.setInformationIcon(vo.getInformationIcon());
			informationNotify.setInformationContent(vo.getInformationContent());
			informationNotify.setPriority(vo.getPriority());
			informationNotify.setReadCount(vo.getReadCount());
			informationNotify.setRemark(vo.getRemark());
        }
		return informationNotify;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return InformationNotifyVO InformationNotifyVO对象
	 * @date 2021-01-20 12:31:14
	 * @author 18511
	 */
	public static InformationNotifyVO toVO(InformationNotify po) {
		InformationNotifyVO vo = new InformationNotifyVO();
		vo.setInformationId(po.getInformationId());
		vo.setInformationType(po.getInformationType());
		vo.setInformationStatus(po.getInformationStatus());
		vo.setCreateTime(po.getCreateTime());
		vo.setUpdateTime(po.getUpdateTime());
		vo.setFinishTime(po.getFinishTime());
		vo.setServiceId(po.getServiceId());
		vo.setServiceName(po.getServiceName());
		vo.setInformationTitle(po.getInformationTitle());
		vo.setInformationFrom(po.getInformationFrom());
		vo.setKeyword(po.getKeyword());
		vo.setInformationIcon(po.getInformationIcon());
		vo.setInformationContent(po.getInformationContent());
		vo.setPriority(po.getPriority());
		vo.setReadCount(po.getReadCount());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
