package com.sgcc.uap.util;

import java.util.UUID;

/**
 * UUID获取工具类
 * @author llb
 *
 */
public class UuidUtil {
	
	/**
	 * 获取36位的UUID
	 * @return
	 */
	public static String getUuid36(){
		
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 获取32位的UUID 中间去掉字符“-”
	 * @return
	 */
	public static String getUuid32(){
		String uuid = UuidUtil.getUuid36();
		return uuid.replaceAll("-", "");
	}

	public static void main(String[] args) {
		System.out.println(UuidUtil.getUuid36());
	}
}
