package com.sgcc.uap.sys.handler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.sgcc.uap.sys.exception.ReturnException;

@ControllerAdvice
public class ExceptionHandler {

    @Autowired
    private final String projectUrl = "http://127.0.0.1:8080/customer";

    //拦截登录异常
    //response.sendRedirect("http://127.0.0.1:8080/customer");
    //@ExceptionHandler(value = AuthorizeException.class)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = ReturnException.class)
    public ModelAndView handlerAuthorizeException() {
    	System.out.println("**********************************拦截登录异常***************************************************");
        //concat只能接字符串。
        //+可以接其它类型。
        return new ModelAndView("redirect:"
        .concat(projectUrl));
    }

}
