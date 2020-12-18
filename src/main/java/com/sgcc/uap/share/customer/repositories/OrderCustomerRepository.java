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
	
	@Query(value = "SELECT * FROM order_customer WHERE CUSTOMER_ID =:customerId "
			+ " UNION SELECT * FROM order_customer_his WHERE CUSTOMER_ID =:customerId "
			+ " limit :pageIndex,:pageSize",
			nativeQuery = true)
	List<OrderCustomer> getAllOrderCustomerByCustomerId(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize
			,@Param("customerId")String customerId);
	
	
	@Query(value = "SELECT c.ADDRESS_LATITUDE,c.ADDRESS_LONGITUDE,c.APPOINTMENT_TIME,c.CREATE_TIME,c.CUSTOMER_ADDRESS,c.CUSTOMER_DESCRIVE,c.CUSTOMER_DESCRIVE_ICON, "
			+ " c.CUSTOMER_EVALUATE,c.CUSTOMER_EVALUATE_PHOTO,c.CUSTOMER_EVALUATE_TITLE,c.CUSTOMER_GRADE,c.CUSTOMER_ID,c.CUSTOMER_NAME,c.CUSTOMER_PHONENUMBER,"
			+ " c.CUSTOMER_PRICE,c.FINISH_TIME,c.IDENTITY_ID,c.ORDER_COMPLAINT_ID,c.ORDER_ID,c.ORDER_STATUS,c.ORDER_TYPE_ID,c.PAY_STATUS,c.REMARK_NUM1,"
			+ " c.REMARK_NUM2,c.REMARK_STR1,c.REMARK_STR2,c.REMARK_STR3,c.UPDATE_TIME,c.VOLTAGE, "
			+ " e.ELECTRICIAN_DESCRIVE,e.ELECTRICIAN_DESCRIVE_ICON,e.ELECTRICIAN_PRICE FROM order_customer c  "
			+ " LEFT JOIN order_electrician e ON c.ORDER_ID = e.ORDER_ID "
			+ " WHERE c.CUSTOMER_ID =:customerId  AND c.order_Status IN :statusList  "
			+ " AND e.ORDER_ELECTRICIAN_TYPE NOT IN :elecStatus "
			+ " limit :pageIndex,:pageSize",
			nativeQuery = true)
	List<OrderCustomer> getOrderCustomerByCustomerIdAndEnot(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize
			,@Param("customerId")String customerId,@Param("statusList")Collection<String> statusList,@Param("elecStatus")Collection<String> elecStatus);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE order_customer t1 SET t1.CUSTOMER_GRADE =:customerGrade ,"
			+ " t1.CUSTOMER_EVALUATE_TITLE=:customerEvaluateTitle,t1.CUSTOMER_EVALUATE=:customerEvaluate,t1.ORDER_STATUS=9 "
			+ " WHERE t1.ORDER_ID IN  "
			+ " (SELECT T3.ORDER_ID FROM ( "
			+ " SELECT t2.ORDER_ID FROM order_customer t2 WHERE t2.ORDER_STATUS=:orderStatus  "
			+ " AND DATE_SUB(t2.FINISH_TIME, INTERVAL :day DAY) >= CURDATE()  "
			+ " ) AS T3) "
	,nativeQuery = true)
	Integer getNotEvaluate(@Param("customerGrade")int customerGrade,@Param("customerEvaluateTitle")String customerEvaluateTitle,
			@Param("customerEvaluate")String customerEvaluate,@Param("orderStatus")int orderStatus,@Param("day")int day);

	
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
