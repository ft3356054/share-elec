package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.NotifyAnnounceUser;

/**
 * <b>概述</b>：NotifyAnnounceUserTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class NotifyAnnounceUserTransfer {
	
	private NotifyAnnounceUserTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return NotifyAnnounceUser NotifyAnnounceUser对象
	 * @date 2020-11-30 16:13:29
	 * @author 18511
	 */
	public static NotifyAnnounceUser toPO(NotifyAnnounceUserVO vo) {
		NotifyAnnounceUser notifyAnnounceUser = new NotifyAnnounceUser();
		if(vo != null){
			notifyAnnounceUser.setId(vo.getId());
			notifyAnnounceUser.setAnnounceUserId(vo.getAnnounceUserId());
			notifyAnnounceUser.setAnnounceId(vo.getAnnounceId());
			notifyAnnounceUser.setRecipientType(vo.getRecipientType());
			notifyAnnounceUser.setState(vo.getState());
			notifyAnnounceUser.setCreateTime(vo.getCreateTime());
			notifyAnnounceUser.setReadTime(vo.getReadTime());
			notifyAnnounceUser.setRemark(vo.getRemark());
        }
		return notifyAnnounceUser;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return NotifyAnnounceUserVO NotifyAnnounceUserVO对象
	 * @date 2020-11-30 16:13:29
	 * @author 18511
	 */
	public static NotifyAnnounceUserVO toVO(NotifyAnnounceUser po) {
		NotifyAnnounceUserVO vo = new NotifyAnnounceUserVO();
		vo.setId(po.getId());
		vo.setAnnounceUserId(po.getAnnounceUserId());
		vo.setAnnounceId(po.getAnnounceId());
		vo.setRecipientType(po.getRecipientType());
		vo.setState(po.getState());
		vo.setCreateTime(po.getCreateTime());
		vo.setReadTime(po.getReadTime());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
