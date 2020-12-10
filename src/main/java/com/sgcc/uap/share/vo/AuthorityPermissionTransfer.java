package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.AuthorityPermission;

/**
 * <b>概述</b>：AuthorityPermissionTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class AuthorityPermissionTransfer {
	
	private AuthorityPermissionTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return AuthorityPermission AuthorityPermission对象
	 * @date 2020-12-10 09:35:40
	 * @author 18511
	 */
	public static AuthorityPermission toPO(AuthorityPermissionVO vo) {
		AuthorityPermission authorityPermission = new AuthorityPermission();
		if(vo != null){
			authorityPermission.setId(vo.getId());
			authorityPermission.setPid(vo.getPid());
			authorityPermission.setPermisName(vo.getPermisName());
			authorityPermission.setPermisType(vo.getPermisType());
			authorityPermission.setUrl(vo.getUrl());
			authorityPermission.setState(vo.getState());
			authorityPermission.setDescription(vo.getDescription());
			authorityPermission.setIcon(vo.getIcon());
			authorityPermission.setSort(vo.getSort());
			authorityPermission.setRemark(vo.getRemark());
        }
		return authorityPermission;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return AuthorityPermissionVO AuthorityPermissionVO对象
	 * @date 2020-12-10 09:35:40
	 * @author 18511
	 */
	public static AuthorityPermissionVO toVO(AuthorityPermission po) {
		AuthorityPermissionVO vo = new AuthorityPermissionVO();
		vo.setId(po.getId());
		vo.setPid(po.getPid());
		vo.setPermisName(po.getPermisName());
		vo.setPermisType(po.getPermisType());
		vo.setUrl(po.getUrl());
		vo.setState(po.getState());
		vo.setDescription(po.getDescription());
		vo.setIcon(po.getIcon());
		vo.setSort(po.getSort());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
