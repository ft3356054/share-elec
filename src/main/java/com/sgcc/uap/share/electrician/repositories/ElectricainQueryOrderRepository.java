package com.sgcc.uap.share.electrician.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgcc.uap.share.customer.bo.OrderCustomerBeginPage;
import com.sgcc.uap.share.domain.OrderCustomer;

public interface ElectricainQueryOrderRepository extends JpaRepository<OrderCustomerBeginPage,String>,JpaSpecificationExecutor<OrderCustomer> {

	@Query(value="SELECT c.ADDRESS_LATITUDE,c.ADDRESS_LONGITUDE,c.APPOINTMENT_TIME,c.CREATE_TIME,c.CUSTOMER_ADDRESS,c.CUSTOMER_DESCRIVE,c.CUSTOMER_DESCRIVE_ICON, "
			+ " c.CUSTOMER_EVALUATE,c.CUSTOMER_EVALUATE_PHOTO,c.CUSTOMER_EVALUATE_TITLE,c.CUSTOMER_GRADE,c.CUSTOMER_ID,c.CUSTOMER_NAME,c.CUSTOMER_PHONENUMBER,"
			+ " c.CUSTOMER_PRICE,c.FINISH_TIME,c.IDENTITY_ID,c.ORDER_COMPLAINT_ID,c.ORDER_ID,c.ORDER_STATUS,c.ORDER_TYPE_ID,c.PAY_STATUS,c.REMARK_NUM1,"
			+ " c.REMARK_NUM2,c.REMARK_STR1,c.REMARK_STR2,c.REMARK_STR3,c.UPDATE_TIME,c.VOLTAGE,c.ORDER_FROM,c.CREATE_AREA_ID,c.REGISTERED_NUMBER,c.CUSTOMER_DESCRIVE_TITLE, "
			+ " e.ELECTRICIAN_DESCRIVE,e.ELECTRICIAN_DESCRIVE_ICON,e.ELECTRICIAN_PRICE,e.OTHER_ELECTRICIAN_ID,e.ORDER_CONTRACT,e.INSPECTION_REPORT,e.ELECTRICIAN_NAME, "
			+ " e.ELECTRICIAN_PHONENUMBER,e.CREATE_TIME AS ACCEPT_TIME,e.CONSTRUCTION_CONTENT  "
			+"FROM order_customer  c "
			+"LEFT JOIN order_electrician e "
				+"ON c.ORDER_ID = e.ORDER_ID "
					+"WHERE e.ELECTRICIAN_ID = :electricianId and e.ORDER_ELECTRICIAN_TYPE !=1 "
					+ "and e.ORDER_ELECTRICIAN_TYPE !=4 and e.ORDER_ELECTRICIAN_TYPE !=5 "
					+ "and e.ORDER_ELECTRICIAN_TYPE !=9 limit :pageIndex,:pageSize"
			+ "UNION ",nativeQuery=true)
	List<OrderCustomerBeginPage> findqQueryAllHaveDone(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("electricianId")String electricianId);

}
