package com.sgcc.uap.share.electrician.vo;

import com.sgcc.uap.share.domain.ElectricianInfo;

/**
 * <b>概述</b>：ElectricianInfoTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class ElectricianInfoTransfer {
	
	private ElectricianInfoTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return ElectricianInfo ElectricianInfo对象
	 * @date 2020-12-07 10:54:21
	 * @author 18511
	 */
	public static ElectricianInfo toPO(ElectricianInfoVO vo) {
		ElectricianInfo electricianInfo = new ElectricianInfo();
		if(vo != null){
			electricianInfo.setElectricianId(vo.getElectricianId());
			electricianInfo.setElectricianName(vo.getElectricianName());
			electricianInfo.setElectricianPhonenumber(vo.getElectricianPhonenumber());
			electricianInfo.setCompanyId(vo.getCompanyId());
			electricianInfo.setCompanyName(vo.getCompanyName());
			electricianInfo.setRatingCertificate(vo.getRatingCertificate());
			electricianInfo.setCompanyContract(vo.getCompanyContract());
			electricianInfo.setElectricianScore(vo.getElectricianScore());
			electricianInfo.setRemark(vo.getRemark());
			electricianInfo.setElectricianLevel(vo.getElectricianLevel());
			electricianInfo.setElectricianStatus(vo.getElectricianStatus());
        }
		return electricianInfo;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return ElectricianInfoVO ElectricianInfoVO对象
	 * @date 2020-12-07 10:54:21
	 * @author 18511
	 */
	public static ElectricianInfoVO toVO(ElectricianInfo po) {
		ElectricianInfoVO vo = new ElectricianInfoVO();
		vo.setElectricianId(po.getElectricianId());
		vo.setElectricianName(po.getElectricianName());
		vo.setElectricianPhonenumber(po.getElectricianPhonenumber());
		vo.setCompanyId(po.getCompanyId());
		vo.setCompanyName(po.getCompanyName());
		vo.setRatingCertificate(po.getRatingCertificate());
		vo.setCompanyContract(po.getCompanyContract());
		vo.setElectricianScore(po.getElectricianScore());
		vo.setRemark(po.getRemark());
		vo.setElectricianLevel(po.getElectricianLevel());
		vo.setElectricianStatus(po.getElectricianStatus());
		return vo;
	}
}
