package com.sgcc.uap.sys.enums;


/*
@Author: llb
@Date : 2020/12/04 
格式为： OrderFlow-remark&Notify-title&Notify-connect&Notify-remark
*/
public enum  CustomerEnum {

    CREATE(0, "新增orderCustomer订单&待付勘察费&您已下单，请支付勘察费&新增客户待付款通知"),

    PAY_SERVICE_FEE(1, "等待接单（用户已支付上门费）&下单成功&已下单，等待电工接单&客户已付勘察费"),
    ;

    private Integer code;

    private String message;

    CustomerEnum(Integer code, String message) {
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
