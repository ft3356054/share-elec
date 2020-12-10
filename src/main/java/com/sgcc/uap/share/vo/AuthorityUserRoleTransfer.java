package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.AuthorityUserRole;

/**
 * <b>概述</b>：AuthorityUserRoleTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class AuthorityUserRoleTransfer {
	
	private AuthorityUserRoleTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return AuthorityUserRole AuthorityUserRole对象
	 * @date 2020-12-10 09:35:40
	 * @author 18511
	 */
	public static AuthorityUserRole toPO(AuthorityUserRoleVO vo) {
		AuthorityUserRole authorityUserRole = new AuthorityUserRole();
		if(vo != null){
			authorityUserRole.setId(vo.getId());
			authorityUserRole.setUserId(vo.getUserId());
			authorityUserRole.setRoleId(vo.getRoleId());
			authorityUserRole.set_type(vo.get_type());
			authorityUserRole.setRemark(vo.getRemark());
        }
		return authorityUserRole;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return AuthorityUserRoleVO AuthorityUserRoleVO对象
	 * @date 2020-12-10 09:35:40
	 * @author 18511
	 */
	public static AuthorityUserRoleVO toVO(AuthorityUserRole po) {
		AuthorityUserRoleVO vo = new AuthorityUserRoleVO();
		vo.setId(po.getId());
		vo.setUserId(po.getUserId());
		vo.setRoleId(po.getRoleId());
		vo.set_type(po.get_type());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
