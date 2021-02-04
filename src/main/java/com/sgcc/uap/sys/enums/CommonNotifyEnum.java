package com.sgcc.uap.sys.enums;


/*
用于获取基础通知消息
@Author: llb
*/
public enum  CommonNotifyEnum {

    CUSTOMER_PAY_SUBSCRIPTION(0,"8dc4014457e04fb484e039d69d8948aa"),

    PAY_SERVICE_FEE(1, "等待接单（用户已支付上门费）&下单成功&已下单，等待电工接单&客户已付勘察费"),
    ;

    private Integer code;

    private String message;

    CommonNotifyEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
