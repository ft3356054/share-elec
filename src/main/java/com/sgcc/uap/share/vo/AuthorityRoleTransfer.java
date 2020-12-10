package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.AuthorityRole;

/**
 * <b>概述</b>：AuthorityRoleTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class AuthorityRoleTransfer {
	
	private AuthorityRoleTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return AuthorityRole AuthorityRole对象
	 * @date 2020-12-10 09:35:40
	 * @author 18511
	 */
	public static AuthorityRole toPO(AuthorityRoleVO vo) {
		AuthorityRole authorityRole = new AuthorityRole();
		if(vo != null){
			authorityRole.setId(vo.getId());
			authorityRole.setRoleName(vo.getRoleName());
			authorityRole.setRoleDesc(vo.getRoleDesc());
			authorityRole.setCreateTime(vo.getCreateTime());
			authorityRole.setRemark(vo.getRemark());
        }
		return authorityRole;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return AuthorityRoleVO AuthorityRoleVO对象
	 * @date 2020-12-10 09:35:40
	 * @author 18511
	 */
	public static AuthorityRoleVO toVO(AuthorityRole po) {
		AuthorityRoleVO vo = new AuthorityRoleVO();
		vo.setId(po.getId());
		vo.setRoleName(po.getRoleName());
		vo.setRoleDesc(po.getRoleDesc());
		vo.setCreateTime(po.getCreateTime());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
