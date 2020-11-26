package com.sgcc.uap.util;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author llb
 *
 */
public class DateTimeUtil {
	private static Logger logger = Logger.getLogger(DateTimeUtil.class);
	
	private static final ThreadLocal<SimpleDateFormat> NOR_FORMAT_T_LOCAL = new ThreadLocal<>();
	
	/**
	 * 获取当天时间 00:00:00
	 * @return
	 */
	public static Date getCurrentDateBegin() {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(calendar.get(Calendar.YEAR), 
				calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
        return calendar.getTime(); 
	}
	
	/**
	 * 获取当天时间 23:59:59
	 * @return
	 */
	public static Date getCurrentDateEnd() {
		Calendar calendar = Calendar.getInstance();  
		calendar.set(calendar.get(Calendar.YEAR), 
				calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		return calendar.getTime();
	}
	
	/**
	 * 日期转换成格式化字符串
	 * @param datetime
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String formatDateTime(Date datetime) {
		if(datetime == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(datetime);
	}
	
	/**
	 * 字符串转日期
	 * @param dateTimeStr	yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date parseNormal(String dateTimeStr) {
		return parse(getNormalSafeFormater(), dateTimeStr);
	}
	
	/**
	 * 日期格式化 (yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static SimpleDateFormat getNormalSafeFormater() {
		return getFormater(NOR_FORMAT_T_LOCAL, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 
	 * @param format
	 * @param str
	 * @return
	 */
	private static Date parse(SimpleDateFormat format, String str) {
		try {
			if(StringUtils.isBlank(str)) {
				return null;
			}
			return format.parse(str);
		} catch(Exception e) {
			logger.error("日期转换异常 ["+str+"]: ", e);
		}
		return null;
	}
	
	/**
	 * @param threadLocal
	 * @param formater
	 * @return
	 */
	private static SimpleDateFormat getFormater(ThreadLocal<SimpleDateFormat> threadLocal, String formater) {
		SimpleDateFormat format = threadLocal.get();
		if(format == null) {
			threadLocal.set(new SimpleDateFormat(formater));
		}
		return threadLocal.get();
	}

	/**
	 * 获取当天整点时间
	 * @param hour
	 * @param second
	 * @param mimute
	 * @param milliSecond
	 * @return
	 */
	public static String getWholeTime(Integer hour, Integer second, Integer mimute, Integer milliSecond){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MINUTE, mimute);
		cal.set(Calendar.MILLISECOND, milliSecond);
		Date date = new Date(cal.getTimeInMillis());
		String time = DateTimeUtil.formatDateTime(date);
		return time;
	}
}
