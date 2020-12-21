package com.sgcc.uap.share.customer.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sgcc.uap.rest.support.ParentVO;


@Entity
@Table(name = "NOTIFY_ANNOUNCE")
public class NotifyAnnounceAndUser extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 
     * ANNOUNCE_ID
     */
	@Id
	/*@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")*/
    @Column(name = "ANNOUNCE_ID", nullable = false, length = 64)
    private String announceId ;
    
    /** 
     * SERDER_ID
     */
    @Column(name = "SERDER_ID", nullable = true, length = 64)
    private String serderId ;
    
    /** 
     * TITLE
     */
    @Column(name = "TITLE", nullable = true, length = 64)
    private String title ;
    
    /** 
     * CONTENT
     */
    @Column(name = "CONTENT", nullable = true, length = 512)
    private String content ;
    
    /** 
     * CREATE_TIME
     */
    @Column(name = "CREATE_TIME", nullable = true, length = 19)
    private String createTime ;
    
    /** 
     * NOTIFY_TYPE
     */
    @Column(name = "NOTIFY_TYPE", nullable = true, length = 2)
    private String notifyType ;
    
    /** 
     * ORDER_ID
     */
    @Column(name = "ORDER_ID", nullable = true, length = 64)
    private String orderId ;
    
    /** 
     * REMARK
     */
    @Column(name = "REMARK", nullable = true, length = 512)
    private String remark ;
    
    /********************************************************/
    /** 
     * ANNOUNCE_USER_ID
     */
    @Column(name = "ANNOUNCE_USER_ID", nullable = true, length = 64)
    private String announceUserId ;
    
    /** 
     * STATE
     */
    @Column(name = "STATE", nullable = true, length = 2)
    private String state ;
    
    /** 
     * READ_TIME
     */
    @Column(name = "READ_TIME", nullable = true, length = 19)
    private String readTime ;
    /********************************************************/

	public String getAnnounceId() {
		return announceId;
	}

	public void setAnnounceId(String announceId) {
		this.announceId = announceId;
	}

	public String getSerderId() {
		return serderId;
	}

	public void setSerderId(String serderId) {
		this.serderId = serderId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getNotifyType() {
		return notifyType;
	}

	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAnnounceUserId() {
		return announceUserId;
	}

	public void setAnnounceUserId(String announceUserId) {
		this.announceUserId = announceUserId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReadTime() {
		return readTime;
	}

	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
