package com.sgcc.uap.share.customer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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
	
	@Query(value = "SELECT * FROM order_customer WHERE CUSTOMER_ID =:customerId  "
			+ " UNION SELECT * FROM order_customer_his WHERE CUSTOMER_ID =:customerId "
			+ " limit :pageIndex,:pageSize",
			nativeQuery = true)
	List<OrderCustomer> getAllOrderCustomerByCustomerId(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("customerId")String customerId);
	
	
}
