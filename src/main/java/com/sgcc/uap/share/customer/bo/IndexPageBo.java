package com.sgcc.uap.share.customer.bo;

public class IndexPageBo{

	/** 
     * 用户id CUSTOMER_ID 或  ELECTRICIAN_ID
     */
    private String userId ;
    /** 
     * 国网id 
     */
    private String openId ;
    /** 
     * 跳转页面 0客户 1电工
     */
    private String toPage ;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getToPage() {
		return toPage;
	}
	public void setToPage(String toPage) {
		this.toPage = toPage;
	}
    
    
}
