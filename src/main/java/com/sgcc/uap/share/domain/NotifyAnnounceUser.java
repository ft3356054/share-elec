package com.sgcc.uap.share.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


/**
 * NotifyAnnounceUser的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "notify_announce_user")
public class NotifyAnnounceUser implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "ID", nullable = false, length = 64)
    private String id ;
    
    /** 
     * ANNOUNCE_USER_ID
     */
    @Column(name = "ANNOUNCE_USER_ID", nullable = true, length = 64)
    private String announceUserId ;
    
    /** 
     * ANNOUNCE_ID
     */
    @Column(name = "ANNOUNCE_ID", nullable = true, length = 64)
    private String announceId ;
    
    /** 
     * RECIPIENT_TYPE
     */
    @Column(name = "RECIPIENT_TYPE", nullable = true, length = 2)
    private String recipientType ;
    
    /** 
     * STATE
     */
    @Column(name = "STATE", nullable = true, length = 2)
    private String state ;
    
    /** 
     * CREATE_TIME
     */
    @Column(name = "CREATE_TIME", nullable = true, length = 19)
    private String createTime ;
    
    /** 
     * READ_TIME
     */
    @Column(name = "READ_TIME", nullable = true, length = 19)
    private String readTime ;
    
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
	
	public NotifyAnnounceUser(){
	
	}
    /**
     * @getId:ID的get方法
     * @params
     * @return id
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public String getId(){
        return this.id;
    }
    /**
     * @setId:ID的set方法
     * @param id
     * @return
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public void setId(String id){
        if(id != null && id.trim().length() == 0){
        	this.id = null;
        }else{
        	this.id = id;
        }
	} 
    /**
     * @getAnnounceUserId:ANNOUNCE_USER_ID的get方法
     * @params
     * @return announceUserId
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public String getAnnounceUserId(){
        return this.announceUserId;
    }
    /**
     * @setAnnounceUserId:ANNOUNCE_USER_ID的set方法
     * @param announceUserId
     * @return
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public void setAnnounceUserId(String announceUserId){
		this.announceUserId = announceUserId;
	} 
    /**
     * @getAnnounceId:ANNOUNCE_ID的get方法
     * @params
     * @return announceId
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public String getAnnounceId(){
        return this.announceId;
    }
    /**
     * @setAnnounceId:ANNOUNCE_ID的set方法
     * @param announceId
     * @return
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public void setAnnounceId(String announceId){
		this.announceId = announceId;
	} 
    /**
     * @getRecipientType:RECIPIENT_TYPE的get方法
     * @params
     * @return recipientType
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public String getRecipientType(){
        return this.recipientType;
    }
    /**
     * @setRecipientType:RECIPIENT_TYPE的set方法
     * @param recipientType
     * @return
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public void setRecipientType(String recipientType){
		this.recipientType = recipientType;
	} 
    /**
     * @getState:STATE的get方法
     * @params
     * @return state
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public String getState(){
        return this.state;
    }
    /**
     * @setState:STATE的set方法
     * @param state
     * @return
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public void setState(String state){
		this.state = state;
	} 
    /**
     * @getCreateTime:CREATE_TIME的get方法
     * @params
     * @return createTime
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public String getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:CREATE_TIME的set方法
     * @param createTime
     * @return
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public void setCreateTime(String createTime){
		this.createTime = createTime;
	} 
    /**
     * @getReadTime:READ_TIME的get方法
     * @params
     * @return readTime
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public String getReadTime(){
        return this.readTime;
    }
    /**
     * @setReadTime:READ_TIME的set方法
     * @param readTime
     * @return
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public void setReadTime(String readTime){
		this.readTime = readTime;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-11-30 16:13:26
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-11-30 16:13:26
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
		
        if (obj == null || !(obj instanceof NotifyAnnounceUser))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		NotifyAnnounceUser other = (NotifyAnnounceUser) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (announceUserId == null) {
			if (other.announceUserId != null) {
				return false;
			}
		} else if (!announceUserId.equals(other.announceUserId)) {
			return false;
		}
		if (announceId == null) {
			if (other.announceId != null) {
				return false;
			}
		} else if (!announceId.equals(other.announceId)) {
			return false;
		}
		if (recipientType == null) {
			if (other.recipientType != null) {
				return false;
			}
		} else if (!recipientType.equals(other.recipientType)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (createTime == null) {
			if (other.createTime != null) {
				return false;
			}
		} else if (!createTime.equals(other.createTime)) {
			return false;
		}
		if (readTime == null) {
			if (other.readTime != null) {
				return false;
			}
		} else if (!readTime.equals(other.readTime)) {
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
		return "NotifyAnnounceUser ["
			+ ", id=" + id
			+ ", announceUserId=" + announceUserId
			+ ", announceId=" + announceId
			+ ", recipientType=" + recipientType
			+ ", state=" + state
			+ ", createTime=" + createTime
			+ ", readTime=" + readTime
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