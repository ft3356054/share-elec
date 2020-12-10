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
	public static Map<String,Object> notifyAdd(String announceId,String serderId,String title,String content,
			String createTime,String remark){
		Map<String,Object> mapNotify = new HashMap<String,Object>();
		mapNotify.put("announceId",announceId);
		mapNotify.put("serderId", announceId);
		mapNotify.put("title", title);
		mapNotify.put("content", content);
		mapNotify.put("createTime", createTime);
		mapNotify.put("remark", remark);
		return mapNotify;
	}
	
	
	/**
	 * 新增通知USER
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
					map.put(params[0], params[1]);
				}
			}
		} 
		return map;
	}
	
	
}