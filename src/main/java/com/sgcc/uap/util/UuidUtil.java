package com.sgcc.uap.util;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	/**
	 * 获取46位的UUID 中间去掉字符“-”
	 * @return
	 */
	public static String getUuid46(){
		String uuid = UuidUtil.getUuid36();
		return nowToString(new Date())+uuid.replaceAll("-", "");
	}
	
	/**
	 * date转标准格式String类型
	 * @param time
	 * @return
	 */
	public static String nowToString(Date time){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String date = null;
		date = sdf.format(time);
		return date;
	}

	/*public static void main(String[] args) {
		System.out.println(UuidUtil.getUuid36());
		System.out.println(UuidUtil.getUuid32());
		System.out.println(UuidUtil.getUuid46());
		
	}*/
	
	
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static Integer getUUIDInOrderId(){
        Integer orderId=UUID.randomUUID().toString().hashCode();
        orderId = orderId < 0 ? -orderId : orderId; //String.hashCode() 值会为空
        return orderId;
    }

    public static void main(String[] args){
        for (int i = 0; i<100; i++)
        System.out.println(UuidUtil.getUUIDInOrderId());
    }
}
