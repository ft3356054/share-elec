package com.sgcc.uap.share.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.share.domain.CustomerInfo;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,String>,JpaSpecificationExecutor<CustomerInfo> {

	/*@Query(value="select ci.CUSTOMER_ID,ci.CUSTOMER_NAME,ci.CUSTOMER_PHONENUMBER,ci.CUSTOMER_ADDRESS,ci.ADDRESS_LONGITUDE,ci.ADDRESS_LATITUDE "
			+ " ,ci.IDENTITY_ID,ci.CUSTOMER_SCORE,ci.HEAD_ICON,ci.REAL_NAME_AUTH,ci.REGISTERED_NUMBER,oae.ORDER_TYPE as REMARK "
			+ " from Customer_Info ci  "
			+ " left join ORDER_AUDIT_ELECTRICIAN oae on oae.ELECTRICIAN_ID = ci.CUSTOMER_ID "
			+ " where ci.CUSTOMER_ID =?1 AND oae.ORDER_TYPE='0' and oae.ORDER_STATUS='0' "
			,nativeQuery=true)
	public CustomerInfo findCustomerInfoAndAuditStatus(String customerId);*/
	
	public Integer countByCustomerId(String customerId);
	
}
