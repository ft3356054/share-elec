package com.sgcc.uap.share.electrician.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgcc.uap.share.domain.OrderCustomer;
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
public interface OrderElectricianRepository extends JpaRepository<OrderElectrician,String>,JpaSpecificationExecutor<OrderElectrician> {

	//List<OrderElectrician> findByElectricianEvaluateIsNull();

	List<OrderElectrician> findByElectricianEvaluateIsNullAndOrderElectricianTypeEquals(String orderElectricianType);

	//@Query(value="select * from order_customer where ORDER_STATUS=?1 or ORDER_STATUS=?2 order by CREATE_TIME asc",nativeQuery=true)
	@Query(value="select * from order_electrician o where ELECTRICIAN_ID=?1 and ORDER_ELECTRICIAN_TYPE !=?2 order by CREATE_TIME asc ",nativeQuery=true)
	List<OrderElectrician> findByElectricianIdAndOrderElectricianTypeEqualsOrderByCreateTime(String electricianId,
			String orderElectricianType);

	/**
	 * 我的订单页面    查询的是当前电工所有的订单+历史订单
	 * @param electricianId
	 * @return
	 */
	
	/*
	@Query(value = "SELECT * FROM order_customer WHERE CUSTOMER_ID =:customerId  "
			+ " UNION SELECT * FROM order_customer_his WHERE CUSTOMER_ID =:customerId "
			+ " limit :pageIndex,:pageSize",
			nativeQuery = true)
	List<OrderElectrician> getAllOrderElectricianByElectricianId(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("electricianId")String electricianId);
	
	
	
	@Query(value =" select * from order_electrician o where ELECTRICIAN_ID = ?1 order by CREATE_TIME asc")
	List<OrderElectrician> findByElectricianIdAndOrderByCreateTimeAsc(String electricianId);

	@Query(value = " select * from order_electrician_his oeh where ELECTRICIAN_ID = ?1 order by CREATE_TIME asc")
	List<OrderElectrician> findByElectricianId(String electricianId);
	*/
	



	
}
