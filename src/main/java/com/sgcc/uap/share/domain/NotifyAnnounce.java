package com.sgcc.uap.share.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * NotifyAnnounce的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "notify_announce")
public class NotifyAnnounce implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

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
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public NotifyAnnounce(){
	
	}
    /**
     * @getAnnounceId:ANNOUNCE_ID的get方法
     * @params
     * @return announceId
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public String getAnnounceId(){
        return this.announceId;
    }
    /**
     * @setAnnounceId:ANNOUNCE_ID的set方法
     * @param announceId
     * @return
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public void setAnnounceId(String announceId){
        if(announceId != null && announceId.trim().length() == 0){
        	this.announceId = null;
        }else{
        	this.announceId = announceId;
        }
	} 
    /**
     * @getSerderId:SERDER_ID的get方法
     * @params
     * @return serderId
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public String getSerderId(){
        return this.serderId;
    }
    /**
     * @setSerderId:SERDER_ID的set方法
     * @param serderId
     * @return
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public void setSerderId(String serderId){
		this.serderId = serderId;
	} 
    /**
     * @getTitle:TITLE的get方法
     * @params
     * @return title
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public String getTitle(){
        return this.title;
    }
    /**
     * @setTitle:TITLE的set方法
     * @param title
     * @return
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public void setTitle(String title){
		this.title = title;
	} 
    /**
     * @getContent:CONTENT的get方法
     * @params
     * @return content
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public String getContent(){
        return this.content;
    }
    /**
     * @setContent:CONTENT的set方法
     * @param content
     * @return
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public void setContent(String content){
		this.content = content;
	} 
    /**
     * @getCreateTime:CREATE_TIME的get方法
     * @params
     * @return createTime
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public String getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:CREATE_TIME的set方法
     * @param createTime
     * @return
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public void setCreateTime(String createTime){
		this.createTime = createTime;
	} 
    /**
     * @getNotifyType:NOTIFY_TYPE的get方法
     * @params
     * @return notifyType
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public String getNotifyType(){
        return this.notifyType;
    }
    /**
     * @setNotifyType:NOTIFY_TYPE的set方法
     * @param notifyType
     * @return
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public void setNotifyType(String notifyType){
		this.notifyType = notifyType;
	} 
    /**
     * @getOrderId:ORDER_ID的get方法
     * @params
     * @return orderId
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public String getOrderId(){
        return this.orderId;
    }
    /**
     * @setOrderId:ORDER_ID的set方法
     * @param orderId
     * @return
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public void setOrderId(String orderId){
		this.orderId = orderId;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-12-15 09:47:12
     * @author 18511
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 
	public String getMxVirtualId() {
        return this.mxVirtualId;
    }
    
    public void setMxVirtualId(String mxVirtualId) {
        this.mxVirtualId = mxVirtualId;
    } 
    /**
     * Hibernate通过该方法判断对象是否相等
     * @return boolean
     */  
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
		
        if (obj == null || !(obj instanceof NotifyAnnounce))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		NotifyAnnounce other = (NotifyAnnounce) obj;
		
		if (announceId == null) {
			if (other.announceId != null) {
				return false;
			}
		} else if (!announceId.equals(other.announceId)) {
			return false;
		}
		if (serderId == null) {
			if (other.serderId != null) {
				return false;
			}
		} else if (!serderId.equals(other.serderId)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
			return false;
		}
		if (createTime == null) {
			if (other.createTime != null) {
				return false;
			}
		} else if (!createTime.equals(other.createTime)) {
			return false;
		}
		if (notifyType == null) {
			if (other.notifyType != null) {
				return false;
			}
		} else if (!notifyType.equals(other.notifyType)) {
			return false;
		}
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "NotifyAnnounce ["
			+ ", announceId=" + announceId
			+ ", serderId=" + serderId
			+ ", title=" + title
			+ ", content=" + content
			+ ", createTime=" + createTime
			+ ", notifyType=" + notifyType
			+ ", orderId=" + orderId
			+ ", remark=" + remark;
	}
   
    
    /**
     * hashcode方法
     * @return int
     * 
     */
    @Override
    public int hashCode(){
		return super.hashCode();
	}
}