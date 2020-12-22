package com.sgcc.uap.share.customer.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgcc.uap.share.domain.OrderFlow;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface OrderFlowRepository extends JpaRepository<OrderFlow,String>,JpaSpecificationExecutor<OrderFlow> {
	@Query(value = "INSERT INTO ORDER_FLOW_HIS SELECT * FROM order_flow WHERE ORDER_ID IN :orderIds  ",
			nativeQuery = true)
	@Modifying
	public void insertToHis(@Param("orderIds")Collection<String> orderIds);
	
	@Query(value = "DELETE FROM order_flow WHERE ORDER_ID IN :orderIds  ",
			nativeQuery = true)
	@Modifying
	public void deleteNowTable(@Param("orderIds")Collection<String> orderIds);
	
}
