package com.sgcc.uap.share.customer.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgcc.uap.share.customer.bo.OrderCustomerBeginPage;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface OrderCustomerBeginPageRepository extends JpaRepository<OrderCustomerBeginPage,String>,JpaSpecificationExecutor<OrderCustomerBeginPage> {
	
	
	@Query(value = "SELECT c.ADDRESS_LATITUDE,c.ADDRESS_LONGITUDE,c.APPOINTMENT_TIME,c.CREATE_TIME,c.CUSTOMER_ADDRESS,c.CUSTOMER_DESCRIVE,c.CUSTOMER_DESCRIVE_ICON, "
			+ " c.CUSTOMER_EVALUATE,c.CUSTOMER_EVALUATE_PHOTO,c.CUSTOMER_EVALUATE_TITLE,c.CUSTOMER_GRADE,c.CUSTOMER_ID,c.CUSTOMER_NAME,c.CUSTOMER_PHONENUMBER,"
			+ " c.CUSTOMER_PRICE,c.FINISH_TIME,c.IDENTITY_ID,c.ORDER_COMPLAINT_ID,c.ORDER_ID,c.ORDER_STATUS,c.ORDER_TYPE_ID,c.PAY_STATUS,c.REMARK_NUM1,"
			+ " c.REMARK_NUM2,c.REMARK_STR1,c.REMARK_STR2,c.REMARK_STR3,c.UPDATE_TIME,c.VOLTAGE,c.ORDER_FROM,c.CREATE_AREA_ID,c.REGISTERED_NUMBER,c.CUSTOMER_DESCRIVE_TITLE, "
			+ " e.ELECTRICIAN_DESCRIVE,e.ELECTRICIAN_DESCRIVE_ICON,e.ELECTRICIAN_PRICE,e.OTHER_ELECTRICIAN_ID,e.ORDER_CONTRACT,e.INSPECTION_REPORT,e.ELECTRICIAN_NAME, "
			+ " e.ELECTRICIAN_PHONENUMBER,e.CREATE_TIME AS ACCEPT_TIME,e.CONSTRUCTION_CONTENT,e.REMARK_STR1 as OTHER_ELECTRICIAN_NAME "
			+ " FROM order_customer c  "
			+ " LEFT JOIN order_electrician e ON c.ORDER_ID = e.ORDER_ID "
			+ " AND e.ORDER_ELECTRICIAN_STATUS NOT IN :elecStatus "
			+ " WHERE c.CUSTOMER_ID =:customerId  AND c.order_Status IN :statusList "
			+ " order by c.CREATE_TIME DESC "
			+ " limit :pageIndex,:pageSize",
			nativeQuery = true)
	List<OrderCustomerBeginPage> getOrderCustomerByCustomerIdAndEnot(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize
			,@Param("customerId")String customerId,@Param("statusList")Collection<String> statusList,@Param("elecStatus")Collection<String> elecStatus);
	
	
	@Query(value = "SELECT c.ADDRESS_LATITUDE,c.ADDRESS_LONGITUDE,c.APPOINTMENT_TIME,c.CREATE_TIME,c.CUSTOMER_ADDRESS,c.CUSTOMER_DESCRIVE,c.CUSTOMER_DESCRIVE_ICON, "
			+ " c.CUSTOMER_EVALUATE,c.CUSTOMER_EVALUATE_PHOTO,c.CUSTOMER_EVALUATE_TITLE,c.CUSTOMER_GRADE,c.CUSTOMER_ID,c.CUSTOMER_NAME,c.CUSTOMER_PHONENUMBER,"
			+ " c.CUSTOMER_PRICE,c.FINISH_TIME,c.IDENTITY_ID,c.ORDER_COMPLAINT_ID,c.ORDER_ID,c.ORDER_STATUS,c.ORDER_TYPE_ID,c.PAY_STATUS,c.REMARK_NUM1,"
			+ " c.REMARK_NUM2,c.REMARK_STR1,c.REMARK_STR2,c.REMARK_STR3,c.UPDATE_TIME,c.VOLTAGE,c.ORDER_FROM,c.CREATE_AREA_ID,c.REGISTERED_NUMBER,c.CUSTOMER_DESCRIVE_TITLE, "
			+ " e.ELECTRICIAN_DESCRIVE,e.ELECTRICIAN_DESCRIVE_ICON,e.ELECTRICIAN_PRICE,e.OTHER_ELECTRICIAN_ID,e.ORDER_CONTRACT,e.INSPECTION_REPORT,e.ELECTRICIAN_NAME, "
			+ " e.ELECTRICIAN_PHONENUMBER,e.CREATE_TIME AS ACCEPT_TIME,e.CONSTRUCTION_CONTENT,e.REMARK_STR1 as OTHER_ELECTRICIAN_NAME "
			+ " FROM order_customer c  "
			+ " LEFT JOIN order_electrician e ON c.ORDER_ID = e.ORDER_ID "
			+ " AND e.ORDER_ELECTRICIAN_STATUS NOT IN :elecStatus "
			+ " WHERE c.ORDER_ID =:orderId  ",
			nativeQuery = true)
	OrderCustomerBeginPage findOrderDetail(@Param("orderId")String orderId,@Param("elecStatus")Collection<String> elecStatus);
	
	@Query(value = "SELECT count(*)  "
			+ " FROM order_customer c  "
			+ " LEFT JOIN order_electrician e ON c.ORDER_ID = e.ORDER_ID "
			+ " AND e.ORDER_ELECTRICIAN_STATUS NOT IN :elecStatus "
			+ " WHERE c.CUSTOMER_ID =:customerId  AND c.order_Status IN :statusList "
			,nativeQuery = true)
	Integer countByCustomerIdAndStatus(@Param("customerId")String customerId,@Param("statusList")Collection<String> statusList,@Param("elecStatus")Collection<String> elecStatus);
	
}
