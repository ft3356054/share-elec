package com.sgcc.uap.share.customer.services;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
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
public interface IOrderCustomerService {

	/**
	 * @getOrderCustomerByOrderId:根据主键 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public QueryResultObject getOrderCustomerByOrderId(String orderId);
	
	/**
	 * 根据主键 查询 关联电工订单
	 * @param orderId
	 * @return
	 */
	public QueryResultObject getOrderDetailByOrderId(String orderId);
	/**
	 * @getOrderCustomerByOrderId:根据主键 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public List<OrderCustomer> getOrderCustomerByOrderIds(List<String> orderIds);
	
	/**
	 * 通过 订单状态 批量获取订单
	 * @param OrderElectricianStatus
	 * @param pastTime
	 * @return
	 */
	public List<OrderCustomer> findByOrderStatus(List<String> orderStatus, String pastTime);
	
	/**
	 * 搜索页面模糊查询
	 * @param 
	 * @return
	 */
	public QueryResultObject searchBox(String customerId,String tagType,String searchContent);
	
	/**
	 * @getOrderCustomerByOrderId:根据主键 查询 现表和历史表
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public QueryResultObject getAllOrderCustomerByCustomerId(RequestCondition queryCondition);
	/**
	 * @remove:根据idObject删除
	 * @param idObject 主键id
	 * @return void
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public void remove(IDRequestObject idObject);
	/**
	 * @save:保存或更新
	 * @param map 保存或更新的数据
	 * @return OrderCustomer OrderCustomer对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public OrderCustomer saveOrderCustomer(Map<String,Object> map,MultipartFile file) throws Exception;
	/**
	 * @query:根据查询条件 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public QueryResultObject query(RequestCondition queryCondition);

	public OrderCustomer updateOrderCustomer(Map<String,Object> map) throws Exception;
	
	/**
	 * 支付成功后 修改订单状态
	 * @param orderId
	 * @param orderStatus
	 * @return
	 * @throws Exception
	 */
	public OrderCustomer payPrice(String orderId,String orderStatus) throws Exception;
	
	
	
	
	/*************** TASK ******************/
	//15天后。待评价、待验收的订单，自动完结
	public boolean runElecEvaluateTask();
	
	
	
	
	
	
	
	/*************** TASK ******************/
	

}
