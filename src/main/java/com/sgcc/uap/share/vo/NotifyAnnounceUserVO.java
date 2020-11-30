package com.sgcc.uap.share.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * NotifyAnnounceUser的VO类
 *
 * @author 18511 
 */
public class NotifyAnnounceUserVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ID
     */  
    @ViewAttribute(name ="id",caption="ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性ANNOUNCE_USER_ID
     */  
    @ViewAttribute(name ="announceUserId",caption="ANNOUNCE_USER_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String announceUserId;    
    /** 
     * 属性ANNOUNCE_ID
     */  
    @ViewAttribute(name ="announceId",caption="ANNOUNCE_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String announceId;    
    /** 
     * 属性RECIPIENT_TYPE
     */  
    @ViewAttribute(name ="recipientType",caption="RECIPIENT_TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String recipientType;    
    /** 
     * 属性STATE
     */  
    @ViewAttribute(name ="state",caption="STATE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String state;    
    /** 
     * 属性CREATE_TIME
     */  
    @ViewAttribute(name ="createTime",caption="CREATE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp createTime;    
    /** 
     * 属性READ_TIME
     */  
    @ViewAttribute(name ="readTime",caption="READ_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp readTime;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * NotifyAnnounceUserVO构造函数
     */
    public NotifyAnnounceUserVO() {
        super();
    } 
   
	 /**
     * NotifyAnnounceUserVO完整的构造函数
     */  
    public NotifyAnnounceUserVO(String id){
        this.id = id;
    }
    /**
     * ID的get方法
     * @return id
     */
    public String getId(){
        return id;
    }
    /**
     * ID的set方法
     * @param id
     */
    public void setId(String id){
        if(id != null && id.trim().length() == 0){
        	this.id = null;
        }else{
        	this.id = id;
        }
	} 
    /**
     * ANNOUNCE_USER_ID的get方法
     * @return announceUserId
     */
    public String getAnnounceUserId(){
        return announceUserId;
    }
    /**
     * ANNOUNCE_USER_ID的set方法
     * @param announceUserId
     */
    public void setAnnounceUserId(String announceUserId){
		this.announceUserId = announceUserId;
	} 
    /**
     * ANNOUNCE_ID的get方法
     * @return announceId
     */
    public String getAnnounceId(){
        return announceId;
    }
    /**
     * ANNOUNCE_ID的set方法
     * @param announceId
     */
    public void setAnnounceId(String announceId){
		this.announceId = announceId;
	} 
    /**
     * RECIPIENT_TYPE的get方法
     * @return recipientType
     */
    public String getRecipientType(){
        return recipientType;
    }
    /**
     * RECIPIENT_TYPE的set方法
     * @param recipientType
     */
    public void setRecipientType(String recipientType){
		this.recipientType = recipientType;
	} 
    /**
     * STATE的get方法
     * @return state
     */
    public String getState(){
        return state;
    }
    /**
     * STATE的set方法
     * @param state
     */
    public void setState(String state){
		this.state = state;
	} 
    /**
     * CREATE_TIME的get方法
     * @return createTime
     */
    public Timestamp getCreateTime(){
        return createTime;
    }
    /**
     * CREATE_TIME的set方法
     * @param createTime
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	} 
    /**
     * READ_TIME的get方法
     * @return readTime
     */
    public Timestamp getReadTime(){
        return readTime;
    }
    /**
     * READ_TIME的set方法
     * @param readTime
     */
    public void setReadTime(Timestamp readTime){
		this.readTime = readTime;
	} 
    /**
     * REMARK的get方法
     * @return remark
     */
    public String getRemark(){
        return remark;
    }
    /**
     * REMARK的set方法
     * @param remark
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("ID"+":"+getId())
				.append("ANNOUNCE_USER_ID"+":"+getAnnounceUserId())
				.append("ANNOUNCE_ID"+":"+getAnnounceId())
				.append("RECIPIENT_TYPE"+":"+getRecipientType())
				.append("STATE"+":"+getState())
				.append("CREATE_TIME"+":"+getCreateTime())
				.append("READ_TIME"+":"+getReadTime())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
