package com.sgcc.uap.share.electrician.vo;

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
	 * @date 2020-12-18 11:51:02
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
			electricianCompanyInfo.setLegalPerson(vo.getLegalPerson());
			electricianCompanyInfo.setCreditCode(vo.getCreditCode());
			electricianCompanyInfo.setStructureCode(vo.getStructureCode());
			electricianCompanyInfo.setOnBusinessBegin(vo.getOnBusinessBegin());
			electricianCompanyInfo.setOnBusinessEnd(vo.getOnBusinessEnd());
			electricianCompanyInfo.setBusinessCope(vo.getBusinessCope());
			electricianCompanyInfo.setQualiCode(vo.getQualiCode());
			electricianCompanyInfo.setQualiIndustry(vo.getQualiIndustry());
			electricianCompanyInfo.setQualiLevel(vo.getQualiLevel());
			electricianCompanyInfo.setCertificateCode(vo.getCertificateCode());
			electricianCompanyInfo.setRegiseterTime(vo.getRegiseterTime());
			electricianCompanyInfo.setRemark1(vo.getRemark1());
			electricianCompanyInfo.setRemark2(vo.getRemark2());
			electricianCompanyInfo.setRemark3(vo.getRemark3());
			electricianCompanyInfo.setRemark4(vo.getRemark4());
			electricianCompanyInfo.setRemark5(vo.getRemark5());
        }
		return electricianCompanyInfo;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return ElectricianCompanyInfoVO ElectricianCompanyInfoVO对象
	 * @date 2020-12-18 11:51:02
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
		vo.setLegalPerson(po.getLegalPerson());
		vo.setCreditCode(po.getCreditCode());
		vo.setStructureCode(po.getStructureCode());
		vo.setOnBusinessBegin(po.getOnBusinessBegin());
		vo.setOnBusinessEnd(po.getOnBusinessEnd());
		vo.setBusinessCope(po.getBusinessCope());
		vo.setQualiCode(po.getQualiCode());
		vo.setQualiIndustry(po.getQualiIndustry());
		vo.setQualiLevel(po.getQualiLevel());
		vo.setCertificateCode(po.getCertificateCode());
		vo.setRegiseterTime(po.getRegiseterTime());
		vo.setRemark1(po.getRemark1());
		vo.setRemark2(po.getRemark2());
		vo.setRemark3(po.getRemark3());
		vo.setRemark4(po.getRemark4());
		vo.setRemark5(po.getRemark5());
		return vo;
	}
}
