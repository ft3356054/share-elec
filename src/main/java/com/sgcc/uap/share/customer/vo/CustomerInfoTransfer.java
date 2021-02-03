package com.sgcc.uap.share.customer.vo;

import com.sgcc.uap.share.domain.CustomerInfo;

/**
 * <b>概述</b>：CustomerInfoTransfer类<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
public class CustomerInfoTransfer {
	
	private CustomerInfoTransfer(){}

	/**
	 * @toPO:vo转为po
	 * @param vo vo对象
	 * @return CustomerInfo CustomerInfo对象
	 * @date 2020-12-17 17:42:23
	 * @author 18511
	 */
	public static CustomerInfo toPO(CustomerInfoVO vo) {
		CustomerInfo customerInfo = new CustomerInfo();
		if(vo != null){
			customerInfo.setCustomerId(vo.getCustomerId());
			customerInfo.setCustomerName(vo.getCustomerName());
			customerInfo.setCustomerPhonenumber(vo.getCustomerPhonenumber());
			customerInfo.setIdentityId(vo.getIdentityId());
			customerInfo.setCustomerScore(vo.getCustomerScore());
			customerInfo.setRemark(vo.getRemark());
			customerInfo.setCustomerAddress(vo.getCustomerAddress());
			customerInfo.setHeadIcon(vo.getHeadIcon());
			customerInfo.setRealNameAuth(vo.getRealNameAuth());
			customerInfo.setRegisteredNumber(vo.getRegisteredNumber());
        }
		return customerInfo;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return CustomerInfoVO CustomerInfoVO对象
	 * @date 2020-12-17 17:42:23
	 * @author 18511
	 */
	public static CustomerInfoVO toVO(CustomerInfo po) {
		CustomerInfoVO vo = new CustomerInfoVO();
		vo.setCustomerId(po.getCustomerId());
		vo.setCustomerName(po.getCustomerName());
		vo.setCustomerPhonenumber(po.getCustomerPhonenumber());
		vo.setIdentityId(po.getIdentityId());
		vo.setCustomerScore(po.getCustomerScore());
		vo.setRemark(po.getRemark());
		vo.setCustomerAddress(po.getCustomerAddress());
		vo.setHeadIcon(po.getHeadIcon());
		vo.setRealNameAuth(po.getRealNameAuth());
		vo.setRegisteredNumber(po.getRegisteredNumber());
		return vo;
	}
}
