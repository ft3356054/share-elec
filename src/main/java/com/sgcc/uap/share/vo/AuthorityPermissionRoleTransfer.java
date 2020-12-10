package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.AuthorityPermissionRole;

/**
 * <b>概述</b>：AuthorityPermissionRoleTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class AuthorityPermissionRoleTransfer {
	
	private AuthorityPermissionRoleTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return AuthorityPermissionRole AuthorityPermissionRole对象
	 * @date 2020-12-10 09:35:40
	 * @author 18511
	 */
	public static AuthorityPermissionRole toPO(AuthorityPermissionRoleVO vo) {
		AuthorityPermissionRole authorityPermissionRole = new AuthorityPermissionRole();
		if(vo != null){
			authorityPermissionRole.setId(vo.getId());
			authorityPermissionRole.setRoleId(vo.getRoleId());
			authorityPermissionRole.setPermisId(vo.getPermisId());
			authorityPermissionRole.set_type(vo.get_type());
			authorityPermissionRole.setRemark(vo.getRemark());
        }
		return authorityPermissionRole;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return AuthorityPermissionRoleVO AuthorityPermissionRoleVO对象
	 * @date 2020-12-10 09:35:40
	 * @author 18511
	 */
	public static AuthorityPermissionRoleVO toVO(AuthorityPermissionRole po) {
		AuthorityPermissionRoleVO vo = new AuthorityPermissionRoleVO();
		vo.setId(po.getId());
		vo.setRoleId(po.getRoleId());
		vo.setPermisId(po.getPermisId());
		vo.set_type(po.get_type());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
