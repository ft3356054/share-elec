package com.sgcc.uap.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @author llb
 *
 */
public class TimeStamp {
	public static String getTime(Long time){
		//时间戳转化为Sting或Date 
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		  String d = format.format(time); 
		  return d; 
	} 
	/**
	 * 得到传入日期所在周的周一的日期
	 * @param time
	 * @return
	 */
	public static Date getWeek(Date date){
		Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        // 获得当前日期是一个星期的第几天  
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);  
        if (1 == dayWeek) {  
            cal.add(Calendar.DAY_OF_MONTH, -1);  
        }  
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
        cal.setFirstDayOfWeek(Calendar.MONDAY);  
        // 获得当前日期是一个星期的第几天  
        int day = cal.get(Calendar.DAY_OF_WEEK);  
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);  
        return cal.getTime();
	}
	
	/**
	 * 获得传入日期所在周的n周后周一的日期
	 * @param week  所在周后第week周
	 * @return
	 */
	public static Date getNextWeekMonday(Date date,int week) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(getWeek(date));  
        cal.add(Calendar.DATE, 7*week);  
        return cal.getTime();  
    }
	
	/**
	 * String类型转成date类型
	 * @param time
	 * @return
	 */
	public static Date toFormatDate(String time){
		Date date = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date fdate = new Date();
		try {
			fdate = sdf.parse(time);
		} catch (ParseException e) {
			e.getMessage();
		}
		date = new Date(fdate.getTime());
		return date;
	}
	/**
	 * String类型转成date类型  yyyyMMddHHmmss
	 * @param time
	 * @return
	 */
	public static Date formatDate(String time){
		Date date = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		java.util.Date fdate = new Date();
		try {
			fdate = sdf.parse(time);
		} catch (ParseException e) {
			e.getMessage();
		}
		date = new Date(fdate.getTime());
		return date;
	}
	
	
	
	/**
	 * date转标准格式String类型
	 * @param time
	 * @return
	 */
	public static String toString(Date time){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = null;
		date = sdf.format(time);
		return date;
	}
	
	/**
	   * 获取现在时间
	   * 
	   * @return 返回短时间字符串格式yyyy-MM-dd HH:mm:ss
	   */
	public static String getStringDateShort(){
	   Date currentTime = new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String dateString = formatter.format(currentTime);
	   return dateString;
	}
	
	/**
     * 获取现在时间
     * 
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
  public static String getStringDateTime(){
     Date currentTime = new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
     String dateString = formatter.format(currentTime);
     return dateString;
  }
	
	/**
	 * 得到传入日期之后第i天的日期
	 * @param 
	 * @return
	 */
	public static Date getSpecifiedDayAfter(Date date,int i){ 
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day+i); 
		Date dayAfter = new Date(c.getTimeInMillis());
		return dayAfter; 
	}
	
	/**
	 * 求时间差
	 * @param big
	 * @param small
	 * @return
	 */
	public static int mistiming(java.sql.Date big,java.sql.Date small){
		long from = small.getTime();
		long to = big.getTime();  
		int days = (int) ((to - from)/(1000 * 60 * 60 * 24)); 
		return days;
	}
	
	/**
	 * 得到传入日期的当月第一天日期
	 * @param date
	 * @return
	 */
	public static Date getFristDay(Date date){
		Calendar cale = Calendar.getInstance();  
        cale.setTime(date); 
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return cale.getTime();
	}
	
	/**
	 * 得到传入日期的当月最后一天日期
	 * @param date
	 * @return
	 */
	public static Date getLastDay(Date date){
		Calendar cale = Calendar.getInstance();  
        cale.setTime(date); 
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return cale.getTime();
	}
	/**
	 * 时间获取
	 * @author dong
	 */
	public static String getStringDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time =  formatter.format(new Date());
		return time;
	}

	/**
	 * 时间获取
	 * @author dong
	 */
	public static Timestamp getTimestamp(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String time = df.format(date); 
		Timestamp ts = Timestamp.valueOf(time);
		return ts; 
	}
	
	/**
	 * 求时间差 分钟
	 * @param big
	 * @param small
	 * @return
	 */
	public static int minCha(String time1,String time2){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int minute = 0;
		try {
			Date date1 = df.parse(time1);
			Date date2 = df.parse(time2);
			long big = date1.getTime();  
		    long small = date2.getTime();  
		    minute = (int) ((big - small) / (1000 * 60 ));  
		    System.out.println("两个时间之间的分钟差为：" + minute);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return minute;
	}
	
	public static void main(String[] args) {
		minCha("2021-01-25 18:19:47", "2021-01-25 16:19:46");
	}
}

