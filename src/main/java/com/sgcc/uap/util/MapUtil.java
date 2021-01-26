package com.sgcc.uap.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sgcc.uap.rest.support.RequestCondition;

/**
 * 对 map 的工具类
 * @author llb
 *
 */
public class MapUtil {
	/**
	 * 新增流水
	 * @param orDERId 
	 * @param flowType 0 客户操作 1 电工操作 2系统操作
	 * @param currStatus 当前状态
	 * @param operatorId 操作人id
	 * @param operatorTime 操作时间
	 * @param operatorType 0增 1删 2改
	 * @param remark
	 * @return
	 */
	public static Map<String,Object> flowAdd(String orDERId,int flowType,int currStatus,String operatorId,
			String operatorTime,int operatorType,String remark) {
		Map<String,Object> mapOrderFlow = new HashMap<String,Object>();
		mapOrderFlow.put("orDERId", orDERId);
		mapOrderFlow.put("flowType", flowType);
		mapOrderFlow.put("currStatus", currStatus);
		mapOrderFlow.put("operatorId", operatorId);
		mapOrderFlow.put("operatorTime", operatorTime);
		mapOrderFlow.put("operatorType", operatorType);
		mapOrderFlow.put("remark", remark);
		return mapOrderFlow;
	}
	
	/**
	 * 新增通知
	 */
	/**
	 * @param announceId
	 * @param serderId 发送者编号
	 * @param title
	 * @param content
	 * @param createTime
	 * @param notifyType 1维修 2支付 3验收 4评价 5系统
	 * @param orderId 
	 * @param remark
	 * @return
	 */
	public static Map<String,Object> notifyAdd(String announceId,String serderId,String title,String content,
			String createTime,String notifyType,String orderId,String remark){
		Map<String,Object> mapNotify = new HashMap<String,Object>();
		mapNotify.put("announceId",announceId);
		mapNotify.put("serderId", serderId);
		mapNotify.put("title", title);
		mapNotify.put("content", content);
		mapNotify.put("createTime", createTime);
		mapNotify.put("notifyType", notifyType);
		mapNotify.put("orderId", orderId);
		mapNotify.put("remark", remark);
		return mapNotify;
	}
	
	/**
	 * 新增通知USER
	 * @param announceUserId 通知接收人id
	 * @param announceId 通知id
	 * @param recipientType 接收用户类型 0全部  1客户  2电工  3电工厂商 似乎没有用
	 * @param state 阅读状态  0未阅读 1已阅读 
	 * @param createTime 创建时间
	 * @param remark
	 * @return
	 */
	public static Map<String,Object> notifyUserAdd(String announceUserId,String announceId,int recipientType,
			int state,String createTime,String remark){
		Map<String,Object> mapNotifyUser = new HashMap<String,Object>();
		mapNotifyUser.put("announceUserId", announceUserId);
		mapNotifyUser.put("announceId", announceId);
		mapNotifyUser.put("recipientType", recipientType);
		mapNotifyUser.put("state", state);
		mapNotifyUser.put("createTime", createTime);
		//mapNotifyUser.put("readTime", "");
		mapNotifyUser.put("remark", remark);
		return mapNotifyUser;
	}
	
	/**
	 * 获取前端传入参数
	 */
	public static Map<String,String> getParam(RequestCondition queryCondition){
		Map<String,String> map = new HashMap<String,String>();
		Object o = queryCondition.getFilter();
		if(o != null && o instanceof List){
			List<String> filter = (List<String>)o;
			if(!filter.isEmpty()){
				int size = filter.size();
				for (String param : filter) {
					String[] params =  param.split("=");
					if(1==params.length){
						map.put(params[0], null);
					}else{
						map.put(params[0], params[1]);
					}
				}
			}
		} 
		return map;
	}
	
	
}
