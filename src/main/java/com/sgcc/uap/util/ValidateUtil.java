package com.sgcc.uap.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 验证表单数据工具类
 * @author llb
 *
 */
public class ValidateUtil {
	
	private static final Logger log = LoggerFactory.getLogger(ValidateUtil.class);

	/**
	 * 手机号码正则表达式
	 */
	private static final String PATTERN_MOBILE = "^(1)\\d{10}$";
	
	/**
	 * 电话号正则表达式
	 */
	private static final String PATTERN_PHONE = "^0\\d{2,3}-?\\d{7,8}$";
	
	/**
	 * 邮箱正则表达式
	 */
	private static final String PATTERN_EMAIL = "^([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+\\.(?:com|cn)$";
	
	/**
	 * 只允许填写字母与下划线的正则表达式
	 */
	private static final String PATTERN_ENG_LINE = "^[A-Za-z_\\d]+$";
	
	/**
	 * 只允许填写英文字母的正则表达式
	 */
	private static final String PATTERN_ENG = "[a-zA-Z]+";
	
	/**
	 * 只允许填写英文与数字的正则表达式
	 */
	private static final String PATTERN_ENG_NUM = "[a-zA-Z0-9]+";
	
	 /**
     *  非NULL校验
     * @param o 需校验的对象
     * @param errMsg 错误提示信息
     */
    public static void paramNotNull(Object o,String errMsg){
        if(o == null){
            BaseLog.error(log,errMsg);
        }
    }

    /**
     * 字符串非空校验
     * @param param 需校验的字符串
     * @param errMsg 错误提示信息
     */
    public static void paramNotEmpty(String param,String errMsg){
        if(StringUtils.isEmpty(param)){
            BaseLog.error(log,errMsg);
        }
    }

    /**
     * 字符串Null校验
     * @param param 需校验的字符串
     * @param errMsg 错误提示信息
     */
    public static void paramNull(String param,String errMsg){
        if(param == null ){
            BaseLog.error(log,errMsg);
        }
    }

    /**
     * 字符串最大长度校验
     * @param param 需校验的字符串
     * @param length 字符串允许的最大长度
     * @param errMsg 错误提示信息
     */
    public static void paramGreaterLength(String param,Integer length,String errMsg){
        if(StringUtils.isNotEmpty(param)){
            if(param.length() > length){
                BaseLog.error(log,errMsg);
            }
        }
    }

    /**
     * 字符串最小长度校验
     * @param param 需校验的字符串
     * @param length 字符串允许的最小长度
     * @param errMsg 错误提示信息
     */
    public static void paramLessLength(String param,Integer length,String errMsg){
        if(StringUtils.isNotEmpty(param)){
            if(param.length() < length){
                BaseLog.error(log,errMsg);
            }
        }
    }

    /**
     * 校验手机号码
     * @param mobile 手机号码
     * @param errMsg 错误提示信息
     */
    public static void paramIsMobile(String mobile,String errMsg){
        if(StringUtils.isNotEmpty(mobile)){
            Pattern pattern = Pattern.compile(PATTERN_MOBILE);
            Matcher matcher = pattern.matcher(mobile);
            boolean flag = matcher.matches();
            if (!flag){
                BaseLog.error(log,errMsg);
            }
        }
    }
    
    /**
     * 校验部门电话或手机号
     * @author mashiguo
     * @param mobile 手机号码
     * @param errMsg 错误提示信息
     */
    public static void paramIsMobileOrPhone(String mobile,String errMsg){
        if(StringUtils.isNotEmpty(mobile)){
            Pattern pattern = Pattern.compile(PATTERN_MOBILE);
            Pattern pattern2 = Pattern.compile(PATTERN_PHONE);
            Matcher matcher = pattern.matcher(mobile);
            Matcher matcher2 = pattern2.matcher(mobile);
            boolean flag = matcher.matches();
            boolean flag2 = matcher2.matches();
            if (!flag && !flag2){
                BaseLog.error(log,errMsg);
            }
        }
    }

    /**
     * 校验邮箱
     * @param email 邮箱
     * @param errMsg 错误提示信息
     */
    public static void paramIsEmail(String email,String errMsg){
        if(StringUtils.isNotEmpty(email)){
            if(StringUtils.isNotEmpty(email)){
                Pattern pattern = Pattern.compile(PATTERN_EMAIL);
                Matcher matcher = pattern.matcher(email);
                boolean flag = matcher.matches();
                if (!flag){
                    BaseLog.error(log,errMsg);
                }
            }
        }
    }
    
    /**
     * 校验字符串是否为英文
     * @param english 需要校验的字符串
     * @param errMsg 错误提示信息
     */
    public static void paramIsEnglish(String english,String errMsg){
        if(StringUtils.isNotEmpty(english)){
            Pattern pattern = Pattern.compile(PATTERN_ENG);
            Matcher matcher = pattern.matcher(english);
            boolean flag = matcher.matches();
            if (!flag){
                BaseLog.error(log,errMsg);
            }
        }
    }
    
    /**
     * 校验字符串是否只为英文或数字
     * @param string 需要校验的字符串
     * @param errMsg 错误提示信息
     */
    public static void paramIsEnglishOrNumber(String string, String errMsg){
    	if(StringUtils.isNotEmpty(string)){
    		Pattern pattern = Pattern.compile(PATTERN_ENG_NUM);
    		Matcher matcher = pattern.matcher(string);
    		boolean flag = matcher.matches();
    		if (!flag){
    			BaseLog.error(log,errMsg);
    		}
    	}
    }
    
    
    /**
     * 校验字符串是否只为英文或下划线
     * @param string 需要校验的字符串
     * @param errMsg 错误提示信息
     */
    public static void paramIsEnglishOrLine(String string, String errMsg){
    	if(StringUtils.isNotEmpty(string)){
    		Pattern pattern = Pattern.compile(PATTERN_ENG_LINE);
    		Matcher matcher = pattern.matcher(string);
    		boolean flag = matcher.matches();
    		if (!flag){
    			BaseLog.error(log,errMsg);
    		}
    	}
    }
    
}
