package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.ElectricianCompanyInfo;

/**
 * <b>概述</b>：ElectricianCompanyInfoTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class ElectricianCompanyInfoTransfer {
	
	private ElectricianCompanyInfoTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return ElectricianCompanyInfo ElectricianCompanyInfo对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static ElectricianCompanyInfo toPO(ElectricianCompanyInfoVO vo) {
		ElectricianCompanyInfo electricianCompanyInfo = new ElectricianCompanyInfo();
		if(vo != null){
			electricianCompanyInfo.setCompanyId(vo.getCompanyId());
			electricianCompanyInfo.setCompanyName(vo.getCompanyName());
			electricianCompanyInfo.setCompanyPhonenumber(vo.getCompanyPhonenumber());
			electricianCompanyInfo.setCompanyAddress(vo.getCompanyAddress());
			electricianCompanyInfo.setAddressLongitude(vo.getAddressLongitude());
			electricianCompanyInfo.setAddressLatitude(vo.getAddressLatitude());
			electricianCompanyInfo.setCompanyLevel(vo.getCompanyLevel());
			electricianCompanyInfo.setRatingCertificate(vo.getRatingCertificate());
			electricianCompanyInfo.setCompanyContract(vo.getCompanyContract());
			electricianCompanyInfo.setRemark(vo.getRemark());
        }
		return electricianCompanyInfo;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return ElectricianCompanyInfoVO ElectricianCompanyInfoVO对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static ElectricianCompanyInfoVO toVO(ElectricianCompanyInfo po) {
		ElectricianCompanyInfoVO vo = new ElectricianCompanyInfoVO();
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
		return vo;
	}
}
