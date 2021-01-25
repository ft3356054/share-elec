package com.sgcc.uap.share.electrician.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
public interface OrderElectricianHisRepository extends JpaRepository<OrderElectricianHis,String>,JpaSpecificationExecutor<OrderElectricianHis> {

	/**
	 * 查询已完成历史里边状态是9或者4的订单
	 * @param electricianId
	 * @return
	 */
	
	@Query(value="select * from order_electrician_his where ELECTRICIAN_ID=? and ORDER_ELECTRICIAN_TYPE = 4 or ORDER_ELECTRICIAN_TYPE=9 "
			+ "or ORDER_ELECTRICIAN_TYPE=1 or ORDER_ELECTRICIAN_TYPE=5",nativeQuery=true)
	List<OrderElectricianHis> findqQueryAllHaveDone(String electricianId);

	
	
	@Query(value="select * from order_electrician_his where ELECTRICIAN_ID=? and ORDER_ELECTRICIAN_TYPE = 4 or ORDER_ELECTRICIAN_TYPE = 5 ",nativeQuery=true)
	List<OrderElectricianHis> queryAllHaveEsc(String electricianId);



	@Query(value="select * from( "
			+ "select * from order_electrician WHERE ELECTRICIAN_ID=:electricianId"
			+ " union  select * from order_electrician_his WHERE ELECTRICIAN_ID=:electricianId) t "
			+ " order by t.CREATE_TIME desc limit :page,:size "
			,nativeQuery=true)
	List<OrderElectricianHis> queryAll(@Param("electricianId")String electricianId,@Param("page")int page,@Param("size")int size);


	@Query(value="select * from( "
			+ "select * from order_electrician WHERE ELECTRICIAN_ID=:electricianId and ORDER_ELECTRICIAN_STATUS in ('8','9') "
			+ " union  select * from order_electrician_his WHERE ELECTRICIAN_ID=:electricianId and ORDER_ELECTRICIAN_STATUS in ('8','9')) t "
			+ " order by t.CREATE_TIME desc limit :page,:size "
			,nativeQuery=true)
	List<OrderElectricianHis> findqQueryAllHaveDone(@Param("electricianId")String electricianId,@Param("page")int page,@Param("size")int size);


	
}
