package com.sgcc.uap.share.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * NotifyAnnounce的VO类
 *
 * @author 18511 
 */
public class NotifyAnnounceVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ANNOUNCE_ID
     */  
    @ViewAttribute(name ="announceId",caption="ANNOUNCE_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String announceId;    
    /** 
     * 属性SERDER_ID
     */  
    @ViewAttribute(name ="serderId",caption="SERDER_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String serderId;    
    /** 
     * 属性TITLE
     */  
    @ViewAttribute(name ="title",caption="TITLE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String title;    
    /** 
     * 属性CONTENT
     */  
    @ViewAttribute(name ="content",caption="CONTENT", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String content;    
    /** 
     * 属性CREATE_TIME
     */  
    @ViewAttribute(name ="createTime",caption="CREATE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp createTime;    
    /** 
     * 属性NOTIFY_TYPE
     */  
    @ViewAttribute(name ="notifyType",caption="NOTIFY_TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String notifyType;    
    /** 
     * 属性ORDER_ID
     */  
    @ViewAttribute(name ="orderId",caption="ORDER_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String orderId;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * NotifyAnnounceVO构造函数
     */
    public NotifyAnnounceVO() {
        super();
    } 
   
	 /**
     * NotifyAnnounceVO完整的构造函数
     */  
    public NotifyAnnounceVO(String announceId){
        this.announceId = announceId;
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
        if(announceId != null && announceId.trim().length() == 0){
        	this.announceId = null;
        }else{
        	this.announceId = announceId;
        }
	} 
    /**
     * SERDER_ID的get方法
     * @return serderId
     */
    public String getSerderId(){
        return serderId;
    }
    /**
     * SERDER_ID的set方法
     * @param serderId
     */
    public void setSerderId(String serderId){
		this.serderId = serderId;
	} 
    /**
     * TITLE的get方法
     * @return title
     */
    public String getTitle(){
        return title;
    }
    /**
     * TITLE的set方法
     * @param title
     */
    public void setTitle(String title){
		this.title = title;
	} 
    /**
     * CONTENT的get方法
     * @return content
     */
    public String getContent(){
        return content;
    }
    /**
     * CONTENT的set方法
     * @param content
     */
    public void setContent(String content){
		this.content = content;
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
     * NOTIFY_TYPE的get方法
     * @return notifyType
     */
    public String getNotifyType(){
        return notifyType;
    }
    /**
     * NOTIFY_TYPE的set方法
     * @param notifyType
     */
    public void setNotifyType(String notifyType){
		this.notifyType = notifyType;
	} 
    /**
     * ORDER_ID的get方法
     * @return orderId
     */
    public String getOrderId(){
        return orderId;
    }
    /**
     * ORDER_ID的set方法
     * @param orderId
     */
    public void setOrderId(String orderId){
		this.orderId = orderId;
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
	  			.append("ANNOUNCE_ID"+":"+getAnnounceId())
				.append("SERDER_ID"+":"+getSerderId())
				.append("TITLE"+":"+getTitle())
				.append("CONTENT"+":"+getContent())
				.append("CREATE_TIME"+":"+getCreateTime())
				.append("NOTIFY_TYPE"+":"+getNotifyType())
				.append("ORDER_ID"+":"+getOrderId())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
