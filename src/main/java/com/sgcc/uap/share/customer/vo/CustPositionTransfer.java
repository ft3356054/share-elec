package com.sgcc.uap.share.customer.vo;

import com.sgcc.uap.share.domain.CustPosition;

/**
 * <b>概述</b>：CustPositionTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class CustPositionTransfer {
	
	private CustPositionTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return CustPosition CustPosition对象
	 * @date 2020-12-21 09:31:09
	 * @author 18511
	 */
	public static CustPosition toPO(CustPositionVO vo) {
		CustPosition custPosition = new CustPosition();
		if(vo != null){
			custPosition.setOrderId(vo.getOrderId());
			custPosition.setCustomerId(vo.getCustomerId());
			custPosition.setAreaId(vo.getAreaId());
			custPosition.setLon(vo.getLon());
			custPosition.setLat(vo.getLat());
        }
		return custPosition;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return CustPositionVO CustPositionVO对象
	 * @date 2020-12-21 09:31:09
	 * @author 18511
	 */
	public static CustPositionVO toVO(CustPosition po) {
		CustPositionVO vo = new CustPositionVO();
		vo.setOrderId(po.getOrderId());
		vo.setCustomerId(po.getCustomerId());
		vo.setAreaId(po.getAreaId());
		vo.setLon(po.getLon());
		vo.setLat(po.getLat());
		return vo;
	}
}
