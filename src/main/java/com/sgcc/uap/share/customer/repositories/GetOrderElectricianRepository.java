package com.sgcc.uap.share.customer.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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

	@Query(value="select * from order_electrician o where ORDER_ELECTRICIAN_TYPE =?1 "
			+ " and DATE_SUB(CURDATE(), INTERVAL ?2 MINUTE) >= CREATE_TIME "
			,nativeQuery=true)
	List<OrderElectrician> findByOrderElectricianType(String orderElectricianType, String pastTime);
	
	
	//通过orderId 和状态查询
	@Query(value= " select * from order_electrician where ORDER_ID=:orderId and ORDER_ELECTRICIAN_TYPE in :orderElectricianType",nativeQuery = true)
	public OrderElectrician findByOrderIdAndOrderElectricianTypeIn(String orDERId,Collection<String> orderElectricianType);
	
	@Query(value= " select * from order_electrician where ORDER_ID=:orderId and ORDER_ELECTRICIAN_TYPE not in :orderElectricianType",nativeQuery = true)
	public OrderElectrician findByOrderIdAndOrderElectricianTypeNotIn(@Param("orderId")String orderId,@Param("orderElectricianType")Collection<String> orderElectricianType);
	
}
