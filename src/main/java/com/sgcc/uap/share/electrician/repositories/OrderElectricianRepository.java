package com.sgcc.uap.share.electrician.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgcc.uap.share.domain.ElectricianCompanyInfo;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.share.domain.OrderElectricianHis;


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

	/*
	@Query(value = "SELECT * FROM Electrician_Company_Info WHERE company_Name like %:companyName%  "
			+ " and company_Level =:companyLevel and regiseter_Time between :regiseterTimeBegin and :regiseterTimeEnd "
			+ " limit :pageIndex,:pageSize",
			nativeQuery = true)
			*/
	@Query(value = "select * from order_electrician where ELECTRICIAN_ID=:electricianId and ORDER_ELECTRICIAN_TYPE"+
			"!= :orderElectricianType order by CREATE_TIME asc limit :pageIndex,:pageSize",nativeQuery = true)
	List<OrderElectrician> queryMore(@Param("pageIndex")Integer pageIndex, @Param("pageSize")Integer pageSize, @Param("electricianId")String electricianId, @Param("orderElectricianType")String orderElectricianType);

	//List<OrderElectrician> queryWaitToDo(Integer pageIndex, Integer pageSize, String electricianId, String string);

	/**
	 * 待评价
	 * @param pageIndex
	 * @param pageSize
	 * @param electricianId
	 * @param orderElectricianType
	 * @return
	 */
	@Query(value = "select * from order_electrician where ELECTRICIAN_ID=:electricianId and ORDER_ELECTRICIAN_TYPE"+
			"= :orderElectricianType order by CREATE_TIME asc limit :pageIndex,:pageSize",nativeQuery = true)
	List<OrderElectrician> queryWaitToDo(@Param("pageIndex")Integer pageIndex, @Param("pageSize")Integer pageSize, @Param("electricianId")String electricianId, @Param("orderElectricianType")String orderElectricianType);

	
	@Query(value= " select * from order_electrician where ORDER_ID=:orderId and ORDER_ELECTRICIAN_TYPE=2",nativeQuery = true)
	OrderElectrician findByOrDERIdAndOrderElectricianType(@Param("orderId")String orderId);

	
	@Query(value="select * from order_electrician where ELECTRICIAN_ID=? and ORDER_ELECTRICIAN_TYPE != 9",nativeQuery=true)
	List<OrderElectrician> queryAllDoing(String electricianId);
	
	
	



	
}
