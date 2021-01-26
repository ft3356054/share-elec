package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.ElecErrorCount;

/**
 * <b>概述</b>：ElecErrorCountTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class ElecErrorCountTransfer {
	
	private ElecErrorCountTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return ElecErrorCount ElecErrorCount对象
	 * @date 2021-01-26 17:55:54
	 * @author 18511
	 */
	public static ElecErrorCount toPO(ElecErrorCountVO vo) {
		ElecErrorCount elecErrorCount = new ElecErrorCount();
		if(vo != null){
			elecErrorCount.setElectricianId(vo.getElectricianId());
			elecErrorCount.setEvaluateCount(vo.getEvaluateCount());
			elecErrorCount.setComplaintCount(vo.getComplaintCount());
			elecErrorCount.setErrorFlag(vo.getErrorFlag());
			elecErrorCount.setForbidDay(vo.getForbidDay());
			elecErrorCount.setCreateTime(vo.getCreateTime());
        }
		return elecErrorCount;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return ElecErrorCountVO ElecErrorCountVO对象
	 * @date 2021-01-26 17:55:54
	 * @author 18511
	 */
	public static ElecErrorCountVO toVO(ElecErrorCount po) {
		ElecErrorCountVO vo = new ElecErrorCountVO();
		vo.setElectricianId(po.getElectricianId());
		vo.setEvaluateCount(po.getEvaluateCount());
		vo.setComplaintCount(po.getComplaintCount());
		vo.setErrorFlag(po.getErrorFlag());
		vo.setForbidDay(po.getForbidDay());
		vo.setCreateTime(po.getCreateTime());
		return vo;
	}
}
