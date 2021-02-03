package com.sgcc.uap.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * UUID获取工具类
 * @author llb
 *
 */
public class UuidUtil {
	private static char[] numbers = null;
	private static Random randGen = null;
	private static Object initLock = new Object();
	
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
	 * 获取32位的纯数字UUID
	 * @return
	 */
	public static String getIntUuid32(){
		//return nowToString(new Date())+randomIntegerString(18);
		return nowToString(new Date())+randomIntegerString(6);
	}
	
	/**
     * 产生随机数字串
     * @param length
     * @return
     */
    public static final String randomIntegerString(int length) {
        if (length < 1) {
            return "";
        }
        //Init of pseudo random number generator.
        if (randGen == null) {
            synchronized (initLock) {
                if (randGen == null) {
                    randGen = new Random();
                    numbers = ("0123456789").toCharArray();
                }
            }
        }
        //Create a char buffer to put random letters and numbers in.
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbers[randGen.nextInt(9)];
        }
        return new String(randBuffer);
    }
	
	public static String getUuid46_bak(){
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

	public static void main(String[] args) {
		//System.out.println(UuidUtil.getUuid36());
		//System.out.println(UuidUtil.getUuid32());
		for(int i =0;i<10 ;i++)
		System.out.println(randomIntegerString(6));
		
	}
	
}
