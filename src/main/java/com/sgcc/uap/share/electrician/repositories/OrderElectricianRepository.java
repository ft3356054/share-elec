package com.sgcc.uap.share.electrician.repositories;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

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
public interface OrderElectricianRepository extends JpaRepository<OrderElectrician,String>,JpaSpecificationExecutor<OrderElectrician> {

	

	List<OrderElectrician> findByElectricianEvaluateIsNullAndOrderElectricianStatusEquals(String orderElectricianStatus);

	
	@Query(value="select * from order_electrician o where ELECTRICIAN_ID=?1 and ORDER_ELECTRICIAN_STATUS !=?2 order by CREATE_TIME asc ",nativeQuery=true)
	List<OrderElectrician> findByElectricianIdAndorderElectricianStatusEqualsOrderByCreateTime(String electricianId,
			String orderElectricianStatus);

	
	@Query(value = "select * from order_electrician where ELECTRICIAN_ID=:electricianId and ORDER_ELECTRICIAN_STATUS"+
			"!= :orderElectricianStatus and ORDER_ELECTRICIAN_STATUS  not in (1,4,5,8) ORDER by CREATE_TIME asc limit :pageIndex,:pageSize",nativeQuery = true)
	List<OrderElectrician> queryMore(@Param("pageIndex")Integer pageIndex, @Param("pageSize")Integer pageSize, @Param("electricianId")String electricianId, @Param("orderElectricianStatus")String orderElectricianStatus);

	

	/**
	 * 待评价
	 * @param pageIndex
	 * @param pageSize
	 * @param electricianId
	 * @param orderElectricianStatus
	 * @return
	 */
	@Query(value = "select * from order_electrician where ELECTRICIAN_ID=:electricianId and ORDER_ELECTRICIAN_STATUS"+
			"= :orderElectricianStatus order by CREATE_TIME asc limit :pageIndex,:pageSize",nativeQuery = true)
	List<OrderElectrician> queryWaitToDo(@Param("pageIndex")Integer pageIndex, @Param("pageSize")Integer pageSize, @Param("electricianId")String electricianId, @Param("orderElectricianStatus")String orderElectricianStatus);

	
	@Query(value= " select * from order_electrician where ORDER_ID=:orderId and ORDER_ELECTRICIAN_STATUS=:orderElectricianEtatus",nativeQuery = true)
	OrderElectrician findByOrDERIdAndOrderElectricianStatus(@Param("orderId")String orderId,@Param("orderElectricianEtatus")String orderElectricianEtatus);

	
	@Query(value="select * from order_electrician where ELECTRICIAN_ID=? and ORDER_ELECTRICIAN_STATUS != 9 and ORDER_ELECTRICIAN_STATUS != 5 and ORDER_ELECTRICIAN_STATUS != 4 and ORDER_ELECTRICIAN_STATUS != 1",nativeQuery=true)
	List<OrderElectrician> queryAllDoing(String electricianId);

	/**
	 * 根据订单id获取电工订单
	 * @param orderId
	 * @return
	 */
	
	@Query(value="select * from order_electrician where ORDER_ID=?",nativeQuery=true)
	OrderElectrician findByOrderId(String orderId);

	/**
	 * 
	 * @param electricianId
	 * @param orderId
	 * @return
	 */
	@Query(value="select * from order_electrician where ELECTRICIAN_ID=:electricianId and ORDER_ID=:orderId",nativeQuery = true)
	OrderElectrician findByElectricianIdAndOrderId(@Param("orderId")String orderId,@Param("electricianId") String electricianId);
	
	
	
	//通过orderId 和状态查询
	@Query(value= " select * from order_electrician where ORDER_ID=:orderId and ORDER_ELECTRICIAN_STATUS in :orderElectricianStatus",nativeQuery = true)
	public OrderElectrician findByOrderIdAndorderElectricianStatusIn(String orDERId,Collection<String> orderElectricianStatus);
	
	@Query(value= " select * from order_electrician where ORDER_ID=:orderId and ORDER_ELECTRICIAN_STATUS not in :orderElectricianStatus",nativeQuery = true)
	public OrderElectrician findByOrderIdAndorderElectricianStatusNotIn(@Param("orderId")String orderId,@Param("orderElectricianStatus")Collection<String> orderElectricianStatus);
	
	@Query(value= " select * from order_electrician where ORDER_ID=:orderId and ORDER_ELECTRICIAN_STATUS = :orderElectricianStatus order by FINISH_TIME desc",nativeQuery = true)
	List<OrderElectrician> findByOrderIdAndOrderElectricianStatusOrderByFinishTimeDesc(@Param("orderId")String orderId,
			@Param("orderElectricianStatus")String orderElectricianStatus);

	@Query(value="select * from order_electrician where ELECTRICIAN_ID=?",nativeQuery = true)
	List<OrderElectrician> findByElectricianId(String electricianId);

	

	@Query(value="select * from order_electrician where ELECTRICIAN_ID = :electricianId and ORDER_ELECTRICIAN_STATUS in (1,4,5,9)"
			+ "UNION select * from order_electrician_his where ELECTRICIAN_ID = :electricianId and ORDER_ELECTRICIAN_STATUS in (1,4,5,9)",nativeQuery=true)
	List<OrderElectrician> queryAllHaveEsc(@Param("electricianId")String electricianId);

	
	
	/**
	 * 通过orderid 搬表
	 * @param orderIds
	 */
	@Transactional
	@Query(value = "INSERT INTO ORDER_ELECTRICIAN_HIS SELECT * FROM ORDER_ELECTRICIAN WHERE ORDER_ID IN :orderIds  ",
			nativeQuery = true)
	@Modifying
	public void insertToHis(@Param("orderIds")Collection<String> orderIds);
	@Query(value = "DELETE FROM ORDER_ELECTRICIAN WHERE ORDER_ID IN :orderIds  ",
			nativeQuery = true)
	@Modifying
	@Transactional
	public void deleteNowTable(@Param("orderIds")Collection<String> orderIds);

	OrderElectrician findByOrderElectricianId(String orderElectricianId);

	
	@Query(value="select * from order_electrician where ELECTRICIAN_ID=? and ORDER_ELECTRICIAN_TYPE = 4 or ORDER_ELECTRICIAN_TYPE=9 "
			+ "or ORDER_ELECTRICIAN_TYPE=1 or ORDER_ELECTRICIAN_TYPE=5",nativeQuery=true)
	List<OrderElectrician> findqQueryAllHaveDone(String electricianId);


	@Query(value="select * from order_electrician where ORDER_ID = ? Order by FINISH_TIME desc")
	List<OrderElectrician> queryByOrderIdOrderByCreatetime(String orderId);

	
	


	

	

	
	
}
