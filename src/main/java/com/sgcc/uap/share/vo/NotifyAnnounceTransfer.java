package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.NotifyAnnounce;

/**
 * <b>概述</b>：NotifyAnnounceTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class NotifyAnnounceTransfer {
	
	private NotifyAnnounceTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return NotifyAnnounce NotifyAnnounce对象
	 * @date 2020-12-15 09:47:13
	 * @author 18511
	 */
	public static NotifyAnnounce toPO(NotifyAnnounceVO vo) {
		NotifyAnnounce notifyAnnounce = new NotifyAnnounce();
		if(vo != null){
			notifyAnnounce.setAnnounceId(vo.getAnnounceId());
			notifyAnnounce.setSerderId(vo.getSerderId());
			notifyAnnounce.setTitle(vo.getTitle());
			notifyAnnounce.setContent(vo.getContent());
			notifyAnnounce.setCreateTime(vo.getCreateTime());
			notifyAnnounce.setNotifyType(vo.getNotifyType());
			notifyAnnounce.setOrderId(vo.getOrderId());
			notifyAnnounce.setRemark(vo.getRemark());
        }
		return notifyAnnounce;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return NotifyAnnounceVO NotifyAnnounceVO对象
	 * @date 2020-12-15 09:47:13
	 * @author 18511
	 */
	public static NotifyAnnounceVO toVO(NotifyAnnounce po) {
		NotifyAnnounceVO vo = new NotifyAnnounceVO();
		vo.setAnnounceId(po.getAnnounceId());
		vo.setSerderId(po.getSerderId());
		vo.setTitle(po.getTitle());
		vo.setContent(po.getContent());
		vo.setCreateTime(po.getCreateTime());
		vo.setNotifyType(po.getNotifyType());
		vo.setOrderId(po.getOrderId());
		vo.setRemark(po.getRemark());
		return vo;
	}
}
