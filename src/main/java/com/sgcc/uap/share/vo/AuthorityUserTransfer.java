package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.AuthorityUser;

/**
 * <b>概述</b>：AuthorityUserTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class AuthorityUserTransfer {
	
	private AuthorityUserTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return AuthorityUser AuthorityUser对象
	 * @date 2021-02-03 10:53:04
	 * @author 18511
	 */
	public static AuthorityUser toPO(AuthorityUserVO vo) {
		AuthorityUser authorityUser = new AuthorityUser();
		if(vo != null){
			authorityUser.setId(vo.getId());
			authorityUser.setUserAccount(vo.getUserAccount());
			authorityUser.setUserPsw(vo.getUserPsw());
			authorityUser.setOpenId(vo.getOpenId());
			authorityUser.setUserName(vo.getUserName());
			authorityUser.setUserDesc(vo.getUserDesc());
			authorityUser.set_status(vo.get_status());
			authorityUser.setUserType(vo.getUserType());
			authorityUser.setCompanyId(vo.getCompanyId());
			authorityUser.setPhonenumber(vo.getPhonenumber());
			authorityUser.setEmail(vo.getEmail());
			authorityUser.setAddress(vo.getAddress());
			authorityUser.setIdCardNum(vo.getIdCardNum());
			authorityUser.setIdCardFirst(vo.getIdCardFirst());
			authorityUser.setIdCardSecond(vo.getIdCardSecond());
			authorityUser.setCertificate(vo.getCertificate());
			authorityUser.setCreateTime(vo.getCreateTime());
			authorityUser.setUpdateTime(vo.getUpdateTime());
			authorityUser.setFinishTime(vo.getFinishTime());
			authorityUser.setUserIcon(vo.getUserIcon());
			authorityUser.setRemark(vo.getRemark());
        }
		return authorityUser;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return AuthorityUserVO AuthorityUserVO对象
	 * @date 2021-02-03 10:53:04
	 * @author 18511
	 */
	public static AuthorityUserVO toVO(AuthorityUser po) {
		AuthorityUserVO vo = new AuthorityUserVO();
		vo.setId(po.getId());
		vo.setUserAccount(po.getUserAccount());
		vo.setUserPsw(po.getUserPsw());
		vo.setOpenId(po.getOpenId());
		vo.setUserName(po.getUserName());
		vo.setUserDesc(po.getUserDesc());
		vo.set_status(po.get_status());
		vo.setUserType(po.getUserType());
		vo.setCompanyId(po.getCompanyId());
		vo.setPhonenumber(po.getPhonenumber());
		vo.setEmail(po.getEmail());
		vo.setAddress(po.getAddress());
		vo.setIdCardNum(po.getIdCardNum());
		vo.setIdCardFirst(po.getIdCardFirst());
		vo.setIdCardSecond(po.getIdCardSecond());
		vo.setCertificate(po.getCertificate());
		vo.setCreateTime(po.getCreateTime());
		vo.setUpdateTime(po.getUpdateTime());
		vo.setFinishTime(po.getFinishTime());
		vo.setUserIcon(po.getUserIcon());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
