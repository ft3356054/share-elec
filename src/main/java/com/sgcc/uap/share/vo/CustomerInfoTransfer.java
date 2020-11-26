package com.sgcc.uap.share.vo;

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
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static CustomerInfo toPO(CustomerInfoVO vo) {
		CustomerInfo customerInfo = new CustomerInfo();
		if(vo != null){
			customerInfo.setCustomerId(vo.getCustomerId());
			customerInfo.setCustomerName(vo.getCustomerName());
			customerInfo.setCustomerPhonenumber(vo.getCustomerPhonenumber());
			customerInfo.setAddressLongitude(vo.getAddressLongitude());
			customerInfo.setAddressLatitude(vo.getAddressLatitude());
			customerInfo.setIdentityId(vo.getIdentityId());
			customerInfo.setCustomerScore(vo.getCustomerScore());
			customerInfo.setRemark(vo.getRemark());
			customerInfo.setCustomerAddress(vo.getCustomerAddress());
        }
		return customerInfo;
	}
	/**
	 * @toVO:po转为vo
	 * @param po po对象
	 * @return CustomerInfoVO CustomerInfoVO对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public static CustomerInfoVO toVO(CustomerInfo po) {
		CustomerInfoVO vo = new CustomerInfoVO();
		vo.setCustomerId(po.getCustomerId());
		vo.setCustomerName(po.getCustomerName());
		vo.setCustomerPhonenumber(po.getCustomerPhonenumber());
		vo.setAddressLongitude(po.getAddressLongitude());
		vo.setAddressLatitude(po.getAddressLatitude());
		vo.setIdentityId(po.getIdentityId());
		vo.setCustomerScore(po.getCustomerScore());
		vo.setRemark(po.getRemark());
		vo.setCustomerAddress(po.getCustomerAddress());
		return vo;
	}
}
