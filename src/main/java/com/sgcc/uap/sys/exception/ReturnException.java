package com.sgcc.uap.sys.exception;

/*
@Author: llb
@Date : 2018/6/19 11:04
*/
public class ReturnException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  Integer code;

    public ReturnException(ExceptionEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public ReturnException(Integer code,String message){
        super();
        this.code = code;
    }

	public Integer getCode() {
		return code;
	}
    
    
}
