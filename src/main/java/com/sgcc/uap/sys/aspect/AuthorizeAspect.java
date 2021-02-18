package com.sgcc.uap.sys.aspect;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cloopen.rest.sdk.utils.StringUtils;
import com.sgcc.uap.sys.constant.CookieConstant;
import com.sgcc.uap.sys.constant.RedisConstant;
import com.sgcc.uap.sys.exception.ExceptionEnum;
import com.sgcc.uap.sys.exception.ReturnException;
import com.sgcc.uap.util.CookieUtil;


@Aspect
@Component
public class AuthorizeAspect {
	
	private final static Logger logger = (Logger) LoggerFactory.getLogger(AuthorizeAspect.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    /*@Pointcut("execution(public * com.sgcc.uap.share.controller.*.*(..))" +
    "&& execution(public * com.sgcc.uap.share.customer.controller.*.*(..))" +
    "&& execution(public * com.sgcc.uap.share.electrician.controller.*.*(..))" +
    "&& !execution(public * com.sgcc.uap.share.controller.AuthorityUserController.*(..))" +
    "&& !execution(public * com.sgcc.uap.share.controller.LoginController.*(..))")
    public void verify() {
    	System.out.println("@@@@@@@ 进入 verify @@@@@@@");
    }*/
    
    @Pointcut("execution(public * com.sgcc.uap.share.customer.controller.*.*(..))")
    public void verifyCust() {}
    
    @Before("verifyCust()")
    public void doVerifyCust() {
    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ verifyCust @@@@@@@@@@@@@@@@@@@@@@");
    	checkTimeOut();
    }
    
    @Pointcut("execution(public * com.sgcc.uap.share.common.controller.*.*(..))")
    public void verify() {}
    
    @Before("verify()")
    public void doVerify() {
    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ verify @@@@@@@@@@@@@@@@@@@@@@");
    	checkTimeOut();
    }

    @Pointcut("execution(public * com.sgcc.uap.share.electrician.controller.*.*(..))")
    public void verifyElec() {}
    
    @Before("verifyElec()")
    public void doVerifyElec() {
    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ verifyElec @@@@@@@@@@@@@@@@@@@@@@");
    	checkTimeOut();
    }
    
    private void checkTimeOut(){
    	/*ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
        	logger.warn("【登录校验】Cookie中查不到token");
            throw new ReturnException(ExceptionEnum.COOKIE_TIME_OUT);
        }

        //去redis里查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
        	logger.warn("【登录校验】Redis中查不到token");
        	throw new ReturnException(ExceptionEnum.COOKIE_TIME_OUT);
        }*/
    }
}
