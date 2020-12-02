package com.sgcc.uap.share.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.share.domain.OrderCustomer;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface OrderCustomerRepository extends JpaRepository<OrderCustomer,String>,JpaSpecificationExecutor<OrderCustomer> {

	//Page<OrderCustomer> findAllByCreateTimeAtDesc(Specification<OrderCustomer> specification, PageRequest request);

	
}
