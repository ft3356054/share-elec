package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.InformationRecord;

/**
 * <b>概述</b>：InformationRecordTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class InformationRecordTransfer {
	
	private InformationRecordTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return InformationRecord InformationRecord对象
	 * @date 2021-01-20 12:31:14
	 * @author 18511
	 */
	public static InformationRecord toPO(InformationRecordVO vo) {
		InformationRecord informationRecord = new InformationRecord();
		if(vo != null){
			informationRecord.setInformationRecordId(vo.getInformationRecordId());
			informationRecord.setInformationId(vo.getInformationId());
			informationRecord.setInformationType(vo.getInformationType());
			informationRecord.setInformationStatus(vo.getInformationStatus());
			informationRecord.setCreateTime(vo.getCreateTime());
			informationRecord.setCreateServiceId(vo.getCreateServiceId());
			informationRecord.setServiceId(vo.getServiceId());
			informationRecord.setServiceDesc(vo.getServiceDesc());
			informationRecord.setRemark(vo.getRemark());
        }
		return informationRecord;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return InformationRecordVO InformationRecordVO对象
	 * @date 2021-01-20 12:31:14
	 * @author 18511
	 */
	public static InformationRecordVO toVO(InformationRecord po) {
		InformationRecordVO vo = new InformationRecordVO();
		vo.setInformationRecordId(po.getInformationRecordId());
		vo.setInformationId(po.getInformationId());
		vo.setInformationType(po.getInformationType());
		vo.setInformationStatus(po.getInformationStatus());
		vo.setCreateTime(po.getCreateTime());
		vo.setCreateServiceId(po.getCreateServiceId());
		vo.setServiceId(po.getServiceId());
		vo.setServiceDesc(po.getServiceDesc());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
