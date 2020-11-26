package com.sgcc.uap.util;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

/**
 * 用于计算浮点数加减乘除以及判断大小的公共方法类
 * @author llb
 */
public class DecimalUtil {
	
	/**
	 * 无参构造函数
	 */
	public DecimalUtil(){
		
	}
	
	public static final BigDecimal ZERO = new BigDecimal("0");
	public static final BigDecimal ONE = BigDecimal.ONE;
    public static final BigDecimal NEGATIVE_ONE = new BigDecimal("-1");
    
    /**
     * 默认运算精度 2 即保留两位小数点
     */
    public static final Integer SCALE = Integer.valueOf(2);
    
    /**
     * 将一个数字字符串转换为精度为2的浮点数
     * @param decimal decimal为null时  返回0.00
     * @return
     */
    public static BigDecimal initDecimal(String decimal){
    	if(StringUtils.isEmpty(decimal)){
    		decimal = DecimalUtil.ZERO.toString();
    	}
    	return new BigDecimal(decimal).setScale(DecimalUtil.SCALE,BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * 两数相加,参数 v1、v2只要存在一个以上的null值，均返回null
     * @param v1 
     * @param v2
     * @return
     */
    public static BigDecimal add(BigDecimal v1,BigDecimal v2){
    	if(v1 == null || v2 == null){
    		return null;
    	}
    	return v1.add(v2).setScale(DecimalUtil.SCALE, BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * 两数相减,参数 v1、v2只要存在一个以上的null值，均返回null
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal sub(BigDecimal v1,BigDecimal v2){
    	if(v1 == null || v2 == null){
    		return null;
    	}
    	return v1.subtract(v2).setScale(DecimalUtil.SCALE, BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * 两数相乘,参数 v1、v2只要存在一个以上的null值，均返回null
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal mul(BigDecimal v1,BigDecimal v2){
    	if(v1 == null || v2 == null){
    		return null;
    	}
    	return v1.multiply(v2).setScale(DecimalUtil.SCALE, BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * 两数相除,参数 v1、v2只要存在一个以上的null值，均返回null
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal div(BigDecimal v1,BigDecimal v2){
    	if(v1 == null || v2 == null){
    		return null;
    	}
    	return v1.divide(v2,DecimalUtil.SCALE, BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * 两数相除,参数 v1、v2只要存在一个以上的null值，均返回null
     * @param v1
     * @param v2
     * @param sacle 自定义精度
     * @return
     */
    public static BigDecimal div(BigDecimal v1,BigDecimal v2,Integer sacle){
    	if(v1 == null || v2 == null){
    		return null;
    	}
    	return v1.divide(v2).setScale(sacle, BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * 比较两值的大小 判断 v1 > v2
     * @param v1
     * @param v2
     * @return
     */
    public static Boolean compareGreater(BigDecimal v1,BigDecimal v2){
    	return Integer.valueOf(1).equals(v1.compareTo(v2));
    }
    
    /**
     * 比较两值的大小 判断 v1 >= v2
     * @param v1
     * @param v2
     * @return
     */
    public static Boolean greaterOrEqual(BigDecimal v1,BigDecimal v2){
    	return Integer.valueOf(1).equals(v1.compareTo(v2)) || Integer.valueOf(0).equals(v1.compareTo(v2));
    }
    
    /**
     * 比较两值的大小 判断 v1 < v2
     * @param v1
     * @param v2
     * @return
     */
    public static Boolean compareLess(BigDecimal v1,BigDecimal v2){
    	return Integer.valueOf(-1).equals(v1.compareTo(v2));
    }
    
    /**
     * 比较两值的大小 判断 v1 <= v2
     * @param v1
     * @param v2
     * @return
     */
    public static Boolean lessOrEqual(BigDecimal v1,BigDecimal v2){
    	return Integer.valueOf(-1).equals(v1.compareTo(v2)) || Integer.valueOf(0).equals(v1.compareTo(v2));
    }
    
    /**
     * 比较两值是否相等
     * @param v1
     * @param v2
     * @return
     */
    public static Boolean compareEquality(BigDecimal v1,BigDecimal v2){
    	return Integer.valueOf(0).equals(v1.compareTo(v2));
    }
    
    /**
     * 判断v1是否等于0
     * @param v1
     * @return
     */
    public static Boolean equalsZero(BigDecimal v1){
    	return Integer.valueOf(0).equals(v1.compareTo(DecimalUtil.ZERO));
    }
    
    /**
     * 判断v1是否大于或等于0；
     * @param v1
     * @return
     */
    public static Boolean greaterOrEqualZero(BigDecimal v1){
    	return Integer.valueOf(0).equals(v1.compareTo(DecimalUtil.ZERO)) ||
    			Integer.valueOf(1).equals(v1.compareTo(DecimalUtil.ZERO));
    }
    
    /**
     * 判断v1是否小于或等于0
     * @param v1
     * @return
     */
    public static Boolean lessOrEqualZero(BigDecimal v1){
    	return Integer.valueOf(0).equals(v1.compareTo(DecimalUtil.ZERO)) ||
    			Integer.valueOf(-1).equals(v1.compareTo(DecimalUtil.ZERO));
    }

}
