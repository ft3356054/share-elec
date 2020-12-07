package com.sgcc.uap.share.electrician.vo;

import com.sgcc.uap.share.domain.ElectricianSubCompanyInfo;

/**
 * <b>概述</b>：ElectricianSubCompanyInfoTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class ElectricianSubCompanyInfoTransfer {
	
	private ElectricianSubCompanyInfoTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return ElectricianSubCompanyInfo ElectricianSubCompanyInfo对象
	 * @date 2020-12-07 10:54:19
	 * @author 18511
	 */
	public static ElectricianSubCompanyInfo toPO(ElectricianSubCompanyInfoVO vo) {
		ElectricianSubCompanyInfo electricianSubCompanyInfo = new ElectricianSubCompanyInfo();
		if(vo != null){
			electricianSubCompanyInfo.setSubCompanyId(vo.getSubCompanyId());
			electricianSubCompanyInfo.setCompanyId(vo.getCompanyId());
			electricianSubCompanyInfo.setCompanyName(vo.getCompanyName());
			electricianSubCompanyInfo.setCompanyPhonenumber(vo.getCompanyPhonenumber());
			electricianSubCompanyInfo.setCompanyAddress(vo.getCompanyAddress());
			electricianSubCompanyInfo.setAddressLongitude(vo.getAddressLongitude());
			electricianSubCompanyInfo.setAddressLatitude(vo.getAddressLatitude());
			electricianSubCompanyInfo.setCompanyLevel(vo.getCompanyLevel());
			electricianSubCompanyInfo.setRatingCertificate(vo.getRatingCertificate());
			electricianSubCompanyInfo.setCompanyContract(vo.getCompanyContract());
			electricianSubCompanyInfo.setRemark(vo.getRemark());
			electricianSubCompanyInfo.setRemark1(vo.getRemark1());
			electricianSubCompanyInfo.setRemark2(vo.getRemark2());
			electricianSubCompanyInfo.setRemark3(vo.getRemark3());
        }
		return electricianSubCompanyInfo;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return ElectricianSubCompanyInfoVO ElectricianSubCompanyInfoVO对象
	 * @date 2020-12-07 10:54:19
	 * @author 18511
	 */
	public static ElectricianSubCompanyInfoVO toVO(ElectricianSubCompanyInfo po) {
		ElectricianSubCompanyInfoVO vo = new ElectricianSubCompanyInfoVO();
		vo.setSubCompanyId(po.getSubCompanyId());
		vo.setCompanyId(po.getCompanyId());
		vo.setCompanyName(po.getCompanyName());
		vo.setCompanyPhonenumber(po.getCompanyPhonenumber());
		vo.setCompanyAddress(po.getCompanyAddress());
		vo.setAddressLongitude(po.getAddressLongitude());
		vo.setAddressLatitude(po.getAddressLatitude());
		vo.setCompanyLevel(po.getCompanyLevel());
		vo.setRatingCertificate(po.getRatingCertificate());
		vo.setCompanyContract(po.getCompanyContract());
		vo.setRemark(po.getRemark());
		vo.setRemark1(po.getRemark1());
		vo.setRemark2(po.getRemark2());
		vo.setRemark3(po.getRemark3());
		return vo;
	}
}
