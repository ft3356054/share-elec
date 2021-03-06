package com.sgcc.uap.share.repositories;
//2020年12月29日

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgcc.uap.share.customer.bo.OrderCustomerMoreVO;
import com.sgcc.uap.share.domain.OrderCustomer;
import com.sgcc.uap.share.domain.OrderElectrician;


public interface OrderCustomerMoreVORepository extends JpaRepository<OrderCustomerMoreVO,String>,JpaSpecificationExecutor<OrderCustomerMoreVO> {

	

	
	
	@Query(value="SELECT oc.* ,oe.INSPECTION_REPORT,oe.ORDER_CONTRACT, oe.CONSTRUCTION_CONTENT,oe.ELECTRICIAN_DESCRIVE,oe.ELECTRICIAN_PRICE "
			+"FROM order_customer oc "
			+"LEFT JOIN order_electrician oe "
			+"ON oc.ORDER_ID = oe.ORDER_ID "
			+"WHERE oe.ELECTRICIAN_ID = :electricianId AND (oc.VOLTAGE like %:searchContent%) "
			+"UNION SELECT oc.* ,oeh.INSPECTION_REPORT,oeh.ORDER_CONTRACT, oeh.CONSTRUCTION_CONTENT,oeh.ELECTRICIAN_DESCRIVE,oeh.ELECTRICIAN_PRICE "
			+"FROM order_customer oc "
			+"LEFT JOIN order_electrician_his oeh "
			+"ON oc.ORDER_ID = oeh.ORDER_ID "
			+"WHERE oeh.ELECTRICIAN_ID = :electricianId AND (oc.VOLTAGE like %:searchContent%)",nativeQuery=true)
	List<OrderCustomerMoreVO> searchVOLTAGE(@Param("electricianId")String electricianId, @Param("searchContent")String searchContent);

	@Query(value="SELECT oc.* ,oe.INSPECTION_REPORT,oe.ORDER_CONTRACT, oe.CONSTRUCTION_CONTENT,oe.ELECTRICIAN_DESCRIVE,oe.ELECTRICIAN_PRICE "
			+"FROM order_customer oc "
			+"LEFT JOIN order_electrician oe "
			+"ON oc.ORDER_ID = oe.ORDER_ID "
			+"WHERE oe.ELECTRICIAN_ID = :electricianId AND (oe.ELECTRICIAN_DESCRIVE like %:searchContent%) "
			+"UNION SELECT oc.* ,oeh.INSPECTION_REPORT,oeh.ORDER_CONTRACT, oeh.CONSTRUCTION_CONTENT,oeh.ELECTRICIAN_DESCRIVE,oeh.ELECTRICIAN_PRICE "
			+"FROM order_customer oc "
			+"LEFT JOIN order_electrician_his oeh "
			+"ON oc.ORDER_ID = oeh.ORDER_ID "
			+"WHERE oeh.ELECTRICIAN_ID = :electricianId AND (oeh.ELECTRICIAN_DESCRIVE like %:searchContent%)",nativeQuery=true)
	List<OrderCustomerMoreVO> searchDescrive(@Param("electricianId")String electricianId, @Param("searchContent")String searchContent);

	
	
}
