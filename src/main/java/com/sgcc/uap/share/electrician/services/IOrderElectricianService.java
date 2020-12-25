package com.sgcc.uap.share.electrician.services;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.share.domain.OrderCustomer;
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
public interface IOrderElectricianService {

	/**
	 * @getOrderElectricianByOrderElectricianId:根据主键 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public QueryResultObject getOrderElectricianByOrderElectricianId(String orderElectricianId);
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
	 * @return OrderElectrician OrderElectrician对象
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public OrderElectrician saveOrderElectrician(Map<String,Object> map,MultipartFile file) throws Exception;
	/**
	 * @query:根据查询条件 查询
	 * @param queryCondition 查询条件
	 * @return QueryResultObject 查询结果
	 * @date 2020-11-26 14:32:47
	 * @author 18511
	 */
	public QueryResultObject query(RequestCondition queryCondition);
	
	
	
	/**
	 * 以下是测试代码
	 */
	//public QueryResultObject findByElectricianId(String electricianId)
public List<OrderElectrician> findByElectricianEvaluateIsNullAndOrderElectricianTypeEquals(String orderElectricianType);

public List<OrderCustomer> findByOrderStatusOrderByCreateTime(int id1,int id2);
public List<OrderElectrician> findByElectricianIdAndOrderElectricianTypeEqualsOrderByCreateTime(String electricianId,String orderElectricianType);
public List<OrderElectrician> findByElectricianIdAndOrderByCreateTimeAsc(String electricianId);
public List<OrderElectrician> findByElectricianId(String electricianId);
public QueryResultObject queryMore(RequestCondition requestCondition);
QueryResultObject queryMore(RequestCondition queryCondition, String electricianId);
public QueryResultObject queryWaitToDo(RequestCondition requestCondition, String electricianId);
public OrderElectrician saveOrderElectrician2(Map<String, Object> map,String electricianId) throws Exception ;
public OrderElectrician findByOrDERIdAndOrderElectricianType(String orderId);

public QueryResultObject queryAllDoing(String electricianId);
public Object saveElectricianEvaluate(Map<String, Object> map, MultipartFile file) ;
/**
 * 通过客户订单ID和电工ID查询订单
 * @param orderId
 * @param electricianId
 * @return
 */
OrderElectrician findByOrderId(String orderId, String electricianId);



OrderCustomer saveOrderCustomerByOrderElectricianService(Map<String, Object> map, MultipartFile file) throws Exception;
public List<OrderElectrician> findByOrderIdAndOrderElectricianTypeOrderByFinishTimeDesc(String orderId,
		String orderElectricianType);
public OrderElectrician findByElectricianIdAndOrderId(String electricianId, String orderId);
public QueryResultObject queryAllHaveEsc(String electricianId);
OrderElectrician saveOrderElectrician(Map<String, Object> map) throws Exception;


/**
 * 给刘哥准备的接口
 * 根据传送过来的客户订单ID去查询
 * 
 * 结果放到websocket
 * @throws Exception 
 */

public void paidanchaxun(String orderId) throws Exception;

public OrderElectrician saveNewOrderElectrician(String orderId, String electricianId) throws Exception;
void qiangdantanchuang(String orderId);

OrderElectrician saveNewNullOrderElectrician(String orderId) throws Exception;
public void esc(String orderId, String electricianId);



}
