package com.sgcc.uap.share.customer.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgcc.uap.share.domain.OrderElectrician;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface GetOrderElectricianRepository extends JpaRepository<OrderElectrician,String>,JpaSpecificationExecutor<OrderElectrician> {

	@Query(value="select * from order_electrician o where ORDER_ELECTRICIAN_STATUS =?1 "
			+ " and DATE_SUB(NOW(), INTERVAL ?2 MINUTE) >= CREATE_TIME "
			,nativeQuery=true)
	List<OrderElectrician> findByOrderElectricianStatus(String orderElectricianStatus, String pastTime);
	
	
	//通过orderId 和状态查询
	@Query(value= " select * from order_electrician where ORDER_ID=:orderId and ORDER_ELECTRICIAN_STATUS in :orderElectricianStatus",nativeQuery = true)
	public OrderElectrician findByOrderIdAndOrderElectricianStatusIn(String orDERId,Collection<String> orderElectricianStatus);
	
	@Query(value= " select * from order_electrician where ORDER_ID=:orderId and ORDER_ELECTRICIAN_STATUS not in :orderElectricianStatus",nativeQuery = true)
	public OrderElectrician findByOrderIdAndOrderElectricianStatusNotIn(@Param("orderId")String orderId,@Param("orderElectricianStatus")Collection<String> orderElectricianType);
	
	@Modifying
	@Query(value = "UPDATE ORDER_ELECTRICIAN t1 SET t1.ELECTRICIAN_GRADE =:electricianGrade, "
			+ " t1.ELECTRICIAN_EVALUATE=:electricianEvaluate, "
			+ " t1.ORDER_ELECTRICIAN_STATUS=:orderStatus,t1.UPDATE_TIME=:updateTime,t1.FINISH_TIME=:updateTime  "
			+ " WHERE t1.ORDER_ID IN :orderIds "
	,nativeQuery = true)
	Integer updateNotEvaluateByOrderId(@Param("electricianGrade")int customerGrade,@Param("electricianEvaluate")String customerEvaluate,
			@Param("orderStatus")int orderStatus,@Param("orderIds")Collection<String> orderIds,@Param("updateTime")String updateTime);
	
	@Modifying
	@Query(value = "UPDATE ORDER_ELECTRICIAN t1 SET t1.ELECTRICIAN_GRADE =:electricianGrade, "
			+ " t1.ELECTRICIAN_EVALUATE=:electricianEvaluate, "
			+ " t1.ORDER_ELECTRICIAN_STATUS=:orderStatus,t1.UPDATE_TIME=:updateTime  "
			+ " WHERE t1.ORDER_ELECTRICIAN_ID IN :orderIds "
	,nativeQuery = true)
	Integer updateNotEvaluateByElecOrderId(@Param("electricianGrade")int customerGrade,@Param("electricianEvaluate")String customerEvaluate,
			@Param("orderStatus")int orderStatus,@Param("orderIds")Collection<String> orderIds,@Param("updateTime")String updateTime);
	
}
