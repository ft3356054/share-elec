package com.sgcc.uap.util;

import org.slf4j.Logger;

/**
 * 日志统一输出工具类
 * @author llb
 *
 */
public class BaseLog {
	
	public BaseLog(){
		super();
	}
	
	public static void debug(Logger log, String message) {
        if(log.isDebugEnabled()){
            log.debug(message);
        }
    }

    public static void warn(Logger log,String message) {
        if(log.isWarnEnabled()){
            log.warn(message);
        }
    }

    public static void info(Logger log,String message) {
        if(log.isInfoEnabled()){
            log.info(message);
        }
    }

    public static void error(Logger log,String message) {
        if(log.isErrorEnabled()){
            log.error(message);
        }
    }

    public static void error(Logger log,String message,Exception e) {
        if(log.isErrorEnabled()){
            log.error(message + e.getMessage(),e);
        }
    }
}
