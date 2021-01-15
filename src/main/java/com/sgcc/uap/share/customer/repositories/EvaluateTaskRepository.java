package com.sgcc.uap.share.customer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgcc.uap.share.customer.bo.EvaluateTaskBo;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface EvaluateTaskRepository extends JpaRepository<EvaluateTaskBo,String>,JpaSpecificationExecutor<EvaluateTaskBo> {
	
	@Query(value = " SELECT t2.ORDER_ID,(CASE WHEN (oc.COMPLAINT_STATUS IS NULL OR oc.COMPLAINT_STATUS =1) THEN 1 ELSE 0 END ) AS COMPLAINT_STATUS "
			+ " FROM order_customer t2 "
			+ " LEFT JOIN order_complaint oc ON t2.ORDER_ID = oc.ORDER_ID  "
			+ " WHERE t2.ORDER_STATUS=:orderStatus  "
			+ " AND DATE_SUB(t2.UPDATE_TIME, INTERVAL :day DAY) >= CURDATE() "
			+ " GROUP BY t2.ORDER_ID,oc.COMPLAINT_STATUS "
	,nativeQuery = true)
	public List<EvaluateTaskBo> getNotPay(@Param("orderStatus")int orderStatus,@Param("day")int day);


	
}
