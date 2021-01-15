package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.AssessRecord;

/**
 * <b>概述</b>：AssessRecordTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class AssessRecordTransfer {
	
	private AssessRecordTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return AssessRecord AssessRecord对象
	 * @date 2021-01-15 11:35:09
	 * @author 18511
	 */
	public static AssessRecord toPO(AssessRecordVO vo) {
		AssessRecord assessRecord = new AssessRecord();
		if(vo != null){
			assessRecord.setAssessId(vo.getAssessId());
			assessRecord.setCompanyId(vo.getCompanyId());
			assessRecord.setOrderId(vo.getOrderId());
			assessRecord.setOrderComplaintId(vo.getOrderComplaintId());
			assessRecord.setAssessStatus(vo.getAssessStatus());
			assessRecord.setAssessReason(vo.getAssessReason());
			assessRecord.setCreateTime(vo.getCreateTime());
			assessRecord.setUpdateTime(vo.getUpdateTime());
			assessRecord.setFinishTime(vo.getFinishTime());
			assessRecord.setAssessType(vo.getAssessType());
			assessRecord.setAssessTypeValue(vo.getAssessTypeValue());
			assessRecord.setServiceId(vo.getServiceId());
			assessRecord.setSolutionDesc(vo.getSolutionDesc());
			assessRecord.setRemark(vo.getRemark());
        }
		return assessRecord;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return AssessRecordVO AssessRecordVO对象
	 * @date 2021-01-15 11:35:09
	 * @author 18511
	 */
	public static AssessRecordVO toVO(AssessRecord po) {
		AssessRecordVO vo = new AssessRecordVO();
		vo.setAssessId(po.getAssessId());
		vo.setCompanyId(po.getCompanyId());
		vo.setOrderId(po.getOrderId());
		vo.setOrderComplaintId(po.getOrderComplaintId());
		vo.setAssessStatus(po.getAssessStatus());
		vo.setAssessReason(po.getAssessReason());
		vo.setCreateTime(po.getCreateTime());
		vo.setUpdateTime(po.getUpdateTime());
		vo.setFinishTime(po.getFinishTime());
		vo.setAssessType(po.getAssessType());
		vo.setAssessTypeValue(po.getAssessTypeValue());
		vo.setServiceId(po.getServiceId());
		vo.setSolutionDesc(po.getSolutionDesc());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
