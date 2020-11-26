package com.sgcc.uap.share.vo;

import com.sgcc.uap.share.domain.OrderFlow;

/**
 * <b>概述</b>：OrderFlowTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class OrderFlowTransfer {
	
	private OrderFlowTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return OrderFlow OrderFlow对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static OrderFlow toPO(OrderFlowVO vo) {
		OrderFlow orderFlow = new OrderFlow();
		if(vo != null){
			orderFlow.setFlowId(vo.getFlowId());
			orderFlow.setFlowType(vo.getFlowType());
			orderFlow.setCurrStatus(vo.getCurrStatus());
			orderFlow.setOperatorId(vo.getOperatorId());
			orderFlow.setOperatorTime(vo.getOperatorTime());
			orderFlow.setOperatorType(vo.getOperatorType());
			orderFlow.setRemark(vo.getRemark());
			orderFlow.setOrDERId(vo.getOrDERId());
        }
		return orderFlow;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return OrderFlowVO OrderFlowVO对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static OrderFlowVO toVO(OrderFlow po) {
		OrderFlowVO vo = new OrderFlowVO();
		vo.setFlowId(po.getFlowId());
		vo.setFlowType(po.getFlowType());
		vo.setCurrStatus(po.getCurrStatus());
		vo.setOperatorId(po.getOperatorId());
		vo.setOperatorTime(po.getOperatorTime());
		vo.setOperatorType(po.getOperatorType());
		vo.setRemark(po.getRemark());
		vo.setOrDERId(po.getOrDERId());
		return vo;
	}
}
