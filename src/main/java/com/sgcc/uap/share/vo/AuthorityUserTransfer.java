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
	 * @date 2020-12-10 09:35:40
	 * @author 18511
	 */
	public static AuthorityUser toPO(AuthorityUserVO vo) {
		AuthorityUser authorityUser = new AuthorityUser();
		if(vo != null){
			authorityUser.setId(vo.getId());
			authorityUser.setUserName(vo.getUserName());
			authorityUser.setUserDesc(vo.getUserDesc());
			authorityUser.set_status(vo.get_status());
			authorityUser.setRemark(vo.getRemark());
        }
		return authorityUser;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return AuthorityUserVO AuthorityUserVO对象
	 * @date 2020-12-10 09:35:40
	 * @author 18511
	 */
	public static AuthorityUserVO toVO(AuthorityUser po) {
		AuthorityUserVO vo = new AuthorityUserVO();
		vo.setId(po.getId());
		vo.setUserName(po.getUserName());
		vo.setUserDesc(po.getUserDesc());
		vo.set_status(po.get_status());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
