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
	 * @date 2020-12-18 15:20:13
	 * @author 18511
	 */
	public static ElectricianInfo toPO(ElectricianInfoVO vo) {
		ElectricianInfo electricianInfo = new ElectricianInfo();
		if(vo != null){
			electricianInfo.setElectricianId(vo.getElectricianId());
			electricianInfo.setElectricianName(vo.getElectricianName());
			electricianInfo.setElectricianPhonenumber(vo.getElectricianPhonenumber());
			electricianInfo.setElectricianStatus(vo.getElectricianStatus());
			electricianInfo.setAddressLongitude(vo.getAddressLongitude());
			electricianInfo.setAddressLatitude(vo.getAddressLatitude());
			electricianInfo.setElectricianLevel(vo.getElectricianLevel());
			electricianInfo.setCompanyId(vo.getCompanyId());
			electricianInfo.setCompanyName(vo.getCompanyName());
			electricianInfo.setRatingCertificate(vo.getRatingCertificate());
			electricianInfo.setCompanyContract(vo.getCompanyContract());
			electricianInfo.setElectricianScore(vo.getElectricianScore());
			electricianInfo.setIdentityInfo(vo.getIdentityInfo());
			electricianInfo.setElectricianCertificate(vo.getElectricianCertificate());
			electricianInfo.setRealNameAuth(vo.getRealNameAuth());
			electricianInfo.setCertificateA(vo.getCertificateA());
			electricianInfo.setCertificateB(vo.getCertificateB());
			electricianInfo.setCertificateC(vo.getCertificateC());
			electricianInfo.setRemark(vo.getRemark());
        }
		return electricianInfo;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return ElectricianInfoVO ElectricianInfoVO对象
	 * @date 2020-12-18 15:20:13
	 * @author 18511
	 */
	public static ElectricianInfoVO toVO(ElectricianInfo po) {
		ElectricianInfoVO vo = new ElectricianInfoVO();
		vo.setElectricianId(po.getElectricianId());
		vo.setElectricianName(po.getElectricianName());
		vo.setElectricianPhonenumber(po.getElectricianPhonenumber());
		vo.setElectricianStatus(po.getElectricianStatus());
		vo.setAddressLongitude(po.getAddressLongitude());
		vo.setAddressLatitude(po.getAddressLatitude());
		vo.setElectricianLevel(po.getElectricianLevel());
		vo.setCompanyId(po.getCompanyId());
		vo.setCompanyName(po.getCompanyName());
		vo.setRatingCertificate(po.getRatingCertificate());
		vo.setCompanyContract(po.getCompanyContract());
		vo.setElectricianScore(po.getElectricianScore());
		vo.setIdentityInfo(po.getIdentityInfo());
		vo.setElectricianCertificate(po.getElectricianCertificate());
		vo.setRealNameAuth(po.getRealNameAuth());
		vo.setCertificateA(po.getCertificateA());
		vo.setCertificateB(po.getCertificateB());
		vo.setCertificateC(po.getCertificateC());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
