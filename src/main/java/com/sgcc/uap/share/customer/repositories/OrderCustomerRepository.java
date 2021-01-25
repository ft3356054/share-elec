package com.sgcc.uap.share.customer.repositories;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	/*Page<OrderCustomer> findAllByCreateTimeAtDesc(Specification<OrderCustomer> specification, PageRequest request);
	
	展示带有条件的分页查询
	@Query(value = "from User u where u.email like %:emailLike%")
	Page<User> findByEmailLike(Pageable pageable, @Param("emailLike")String emailLike);*/
	// + " UNION SELECT * FROM order_customer_his WHERE CUSTOMER_ID :customerId "
	/*
	@Query(value = "SELECT *,null as ELECTRICIAN_DESCRIVE,null as ELECTRICIAN_DESCRIVE_ICON,null as ELECTRICIAN_PRICE FROM order_customer WHERE CUSTOMER_ID =:customerId "
			+ " UNION SELECT *,null as ELECTRICIAN_DESCRIVE,null as ELECTRICIAN_DESCRIVE_ICON,null as ELECTRICIAN_PRICE FROM order_customer_his WHERE CUSTOMER_ID =:customerId "
			+ " limit :pageIndex,:pageSize",
			nativeQuery = true)
	 * */
	@Query(value = " SELECT * FROM ( "
			+ " SELECT * FROM order_customer WHERE CUSTOMER_ID =:customerId "
			+ " UNION SELECT * FROM order_customer_his WHERE CUSTOMER_ID =:customerId "
			+ " ) t ORDER BY t.CREATE_TIME DESC  "
			+ " limit :pageIndex,:pageSize",
			nativeQuery = true)
	List<OrderCustomer> getAllOrderCustomerByCustomerId(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize
			,@Param("customerId")String customerId);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE order_customer t1 SET t1.CUSTOMER_GRADE =:customerGrade ,"
			+ " t1.CUSTOMER_EVALUATE_TITLE=:customerEvaluateTitle,t1.CUSTOMER_EVALUATE=:customerEvaluate,t1.ORDER_STATUS=9,t1.UPDATE_TIME=:updateTime  "
			+ " WHERE t1.ORDER_ID IN  "
			+ " (SELECT T3.ORDER_ID FROM ( "
			+ " SELECT t2.ORDER_ID FROM order_customer t2 WHERE t2.ORDER_STATUS=:orderStatus  "
			+ " AND DATE_SUB(CURDATE(), INTERVAL :day DAY) >=   t2.UPDATE_TIME  "
			+ " ) AS T3) "
	,nativeQuery = true)
	Integer getNotEvaluate(@Param("customerGrade")int customerGrade,@Param("customerEvaluateTitle")String customerEvaluateTitle,
			@Param("customerEvaluate")String customerEvaluate,@Param("orderStatus")int orderStatus,@Param("day")int day,@Param("updateTime")String updateTime);

	@Query(value = " SELECT * FROM order_customer t WHERE t.CUSTOMER_ID =:customerId "
			+ " AND t.ORDER_STATUS NOT IN :tagTypes "
			+ " AND IF(:searchContent !='',(t.CUSTOMER_DESCRIVE_TITLE LIKE CONCAT('%',:searchContent,'%') OR t.CUSTOMER_DESCRIVE LIKE CONCAT('%',:searchContent,'%')),1=1) "
			+ " ORDER BY t.CREATE_TIME DESC "
			+ " limit :pageIndex,:pageSize",
			nativeQuery = true)
	List<OrderCustomer> searchBoxNotIn(@Param("customerId")String customerId,@Param("tagTypes")Collection<String> tagTypes,
			@Param("searchContent")String searchContent,@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
	
	@Query(value = " SELECT * FROM ( "
			+ " SELECT * FROM order_customer t WHERE t.CUSTOMER_ID =:customerId "
			+ " AND t.ORDER_STATUS IN :tagTypes "
			+ " AND IF(:searchContent !='',(t.CUSTOMER_DESCRIVE_TITLE LIKE CONCAT('%',:searchContent,'%') OR t.CUSTOMER_DESCRIVE LIKE CONCAT('%',:searchContent,'%')),1=1) "
			+ " UNION SELECT * FROM order_customer_his th WHERE th.CUSTOMER_ID =:customerId "
			+ " AND IF(:searchContent !='',(th.CUSTOMER_DESCRIVE_TITLE LIKE CONCAT('%',:searchContent,'%') OR th.CUSTOMER_DESCRIVE LIKE CONCAT('%',:searchContent,'%')),1=1) "
			+ " ) TALL ORDER BY TALL.CREATE_TIME DESC "
			+ " limit :pageIndex,:pageSize",
			nativeQuery = true)
	List<OrderCustomer> searchBoxIn(@Param("customerId")String customerId,@Param("tagTypes")Collection<String> tagTypes,
			@Param("searchContent")String searchContent,@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
	
	@Query(value = " SELECT * FROM ( "
			+ " SELECT * FROM order_customer t WHERE t.CUSTOMER_ID =:customerId "
			+ " AND IF(:searchContent !='',(t.CUSTOMER_DESCRIVE_TITLE LIKE CONCAT('%',:searchContent,'%') OR t.CUSTOMER_DESCRIVE LIKE CONCAT('%',:searchContent,'%')),1=1) "
			+ " UNION SELECT * FROM order_customer_his th WHERE th.CUSTOMER_ID =:customerId "
			+ " AND IF(:searchContent !='',(th.CUSTOMER_DESCRIVE_TITLE LIKE CONCAT('%',:searchContent,'%') OR th.CUSTOMER_DESCRIVE LIKE CONCAT('%',:searchContent,'%')),1=1) "
			+ " ) TALL ORDER BY TALL.CREATE_TIME DESC "
			+ " limit :pageIndex,:pageSize",
			nativeQuery = true)
	List<OrderCustomer> searchBox(@Param("customerId")String customerId,@Param("searchContent")String searchContent,
			@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);

	
	@Query(value = " SELECT count(*) FROM order_customer t WHERE t.CUSTOMER_ID =:customerId "
			+ " AND t.ORDER_STATUS NOT IN :tagTypes "
			+ " AND IF(:searchContent !='',(t.CUSTOMER_DESCRIVE_TITLE LIKE CONCAT('%',:searchContent,'%') OR t.CUSTOMER_DESCRIVE LIKE CONCAT('%',:searchContent,'%')),1=1) "
			,nativeQuery = true)
	Integer searchBoxNotInCount(@Param("customerId")String customerId,@Param("tagTypes")Collection<String> tagTypes,
			@Param("searchContent")String searchContent);
	
	@Query(value = " SELECT count(*) FROM ( "
			+ " SELECT * FROM order_customer t WHERE t.CUSTOMER_ID =:customerId "
			+ " AND t.ORDER_STATUS IN :tagTypes "
			+ " AND IF(:searchContent !='',(t.CUSTOMER_DESCRIVE_TITLE LIKE CONCAT('%',:searchContent,'%') OR t.CUSTOMER_DESCRIVE LIKE CONCAT('%',:searchContent,'%')),1=1) "
			+ " UNION SELECT * FROM order_customer_his th WHERE th.CUSTOMER_ID =:customerId "
			+ " AND IF(:searchContent !='',(th.CUSTOMER_DESCRIVE_TITLE LIKE CONCAT('%',:searchContent,'%') OR th.CUSTOMER_DESCRIVE LIKE CONCAT('%',:searchContent,'%')),1=1) "
			+ " ) TALL "
			,nativeQuery = true)
	Integer searchBoxInCount(@Param("customerId")String customerId,@Param("tagTypes")Collection<String> tagTypes,
			@Param("searchContent")String searchContent);
	
	@Query(value = " SELECT count(*) FROM ( "
			+ " SELECT * FROM order_customer t WHERE t.CUSTOMER_ID =:customerId "
			+ " AND IF(:searchContent !='',(t.CUSTOMER_DESCRIVE_TITLE LIKE CONCAT('%',:searchContent,'%') OR t.CUSTOMER_DESCRIVE LIKE CONCAT('%',:searchContent,'%')),1=1) "
			+ " UNION SELECT * FROM order_customer_his th WHERE th.CUSTOMER_ID =:customerId "
			+ " AND IF(:searchContent !='',(th.CUSTOMER_DESCRIVE_TITLE LIKE CONCAT('%',:searchContent,'%') OR th.CUSTOMER_DESCRIVE LIKE CONCAT('%',:searchContent,'%')),1=1) "
			+ " ) TALL "
			,nativeQuery = true)
	Integer searchBoxCount(@Param("customerId")String customerId,@Param("searchContent")String searchContent);
	
	
	/**
	 * 通过orderid 搬表
	 * @param orderIds
	 */
	@Query(value = "SELECT * FROM order_customer T  "
			+ " WHERE T.ORDER_STATUS in ('4','9') AND DATE_SUB(CURDATE(), INTERVAL :day DAY) >= T.FINISH_TIME  ",
			nativeQuery = true)
	public List<OrderCustomer> findFinishOrder(@Param("day")String day);
	@Transactional
	@Query(value = "INSERT INTO order_customer_his SELECT * FROM order_customer WHERE ORDER_ID IN :orderIds  ",
			nativeQuery = true)
	@Modifying
	public void insertToHis(@Param("orderIds")Collection<String> orderIds);
	@Query(value = "DELETE FROM order_customer WHERE ORDER_ID IN :orderIds  ",
			nativeQuery = true)
	@Modifying
	@Transactional
	public void deleteNowTable(@Param("orderIds")Collection<String> orderIds);
	
	/**
	 * 查询没有接单的订单
	 * @param orderIds
	 */
	@Query(value = "SELECT CREATE_TIME FROM order_customer T   "
			+ " WHERE T.ORDER_STATUS IN ('1','11') AND DATE_SUB(NOW(), INTERVAL :day MINUTE) >= T.CREATE_TIME  ",
			nativeQuery = true)
	public List<OrderCustomer> findNotAcceptOrder(@Param("day")String day);
	
	
	@Query(value="select * from order_customer o where ORDER_STATUS in ?1 "
			+ " and DATE_SUB(NOW(), INTERVAL ?2 MINUTE) >= UPDATE_TIME  "
			,nativeQuery=true)
	List<OrderCustomer> findByOrderStatus(Collection<String> orderStatus, String pastTime);
	
	
	public List<OrderCustomer> findOrderCustomerByOrderId(Collection<String> orderId);
	
	public int countByCustomerId(String customerId);
	
	@Modifying
	@Query(value = "UPDATE order_customer t1 SET t1.CUSTOMER_GRADE =:customerGrade ,"
			+ " t1.CUSTOMER_EVALUATE_TITLE=:customerEvaluateTitle,t1.CUSTOMER_EVALUATE=:customerEvaluate, "
			+ " t1.ORDER_STATUS=:orderStatus,t1.UPDATE_TIME=:updateTime  "
			+ " WHERE t1.ORDER_ID IN :orderIds "
	,nativeQuery = true)
	Integer updateNotEvaluate(@Param("customerGrade")int customerGrade,@Param("customerEvaluateTitle")String customerEvaluateTitle,
			@Param("customerEvaluate")String customerEvaluate,@Param("orderStatus")int orderStatus,@Param("orderIds")Collection<String> orderIds,@Param("updateTime")String updateTime);
	
	@Modifying
	@Query(value = "UPDATE order_customer t1 SET t1.CUSTOMER_GRADE =:customerGrade ,"
			+ " t1.CUSTOMER_EVALUATE_TITLE=:customerEvaluateTitle,t1.CUSTOMER_EVALUATE=:customerEvaluate, "
			+ " t1.ORDER_STATUS=:orderStatus,t1.UPDATE_TIME=:updateTime,t1.FINISH_TIME=:updateTime  "
			+ " WHERE t1.ORDER_ID IN :orderIds "
	,nativeQuery = true)
	Integer updateNotEvaluateAndFinishtime(@Param("customerGrade")int customerGrade,@Param("customerEvaluateTitle")String customerEvaluateTitle,
			@Param("customerEvaluate")String customerEvaluate,@Param("orderStatus")int orderStatus,@Param("orderIds")Collection<String> orderIds,@Param("updateTime")String updateTime);
	
	
	
	
	
	
	
	
	/**
	 * 郭庆2020.12.04
	 * 
	 */
	@Query(value="select * from order_customer where ORDER_STATUS=?1 or ORDER_STATUS=?2 order by CREATE_TIME asc",nativeQuery=true)
	List<OrderCustomer> findByOrderStatusOrderByCreateTime(int id1, int id2);

	
	@Query(value="select * from order_customer where ORDER_ID=?",nativeQuery=true)
	OrderCustomer findByOrderId(String orderId);


	/**
	 * 查询客户订单，使用模糊查询，返回订单状态是1或者11
	 * @return
	 */
	@Query(value="select * from order_customer where ORDER_STATUS = 1 or ORDER_STATUS = 11",nativeQuery=true)
	List<OrderCustomer> findByOrderStatusLike();

	@Query(value="select * from order_customer where ORDER_ID=? and ORDER_STATUS in (1,11) ",nativeQuery=true)
	OrderCustomer findByOrderIdAndOrderStatus(String orderId);

	
	/**
	 * 查询详情页
	 * @param orderElectricianId
	 * @return
	 */
	/*
	@Query(value="select * from order_customer where ORDER_ID=?",nativeQuery=true)
	List<OrderCustomer> findByOrderDetails(String orderId);
*/
	


	
}
