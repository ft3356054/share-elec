package com.sgcc.uap.share.domain;

import java.io.Serializable;


/**
 * 登录后返回
 * @author 18511 
 */
public class LoginBackInfo implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227161159L;

	private String userId ;
	private String realNameAuth ;
	private String userType ;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRealNameAuth() {
		return realNameAuth;
	}
	public void setRealNameAuth(String realNameAuth) {
		this.realNameAuth = realNameAuth;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
    
}