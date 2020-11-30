package com.sgcc.uap.share.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


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
    private Timestamp createTime ;
    
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
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getAnnounceId(){
        return this.announceId;
    }
    /**
     * @setAnnounceId:ANNOUNCE_ID的set方法
     * @param announceId
     * @return
     * @date 2020-11-26 14:32:47
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
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getSerderId(){
        return this.serderId;
    }
    /**
     * @setSerderId:SERDER_ID的set方法
     * @param serderId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setSerderId(String serderId){
		this.serderId = serderId;
	} 
    /**
     * @getTitle:TITLE的get方法
     * @params
     * @return title
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getTitle(){
        return this.title;
    }
    /**
     * @setTitle:TITLE的set方法
     * @param title
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setTitle(String title){
		this.title = title;
	} 
    /**
     * @getContent:CONTENT的get方法
     * @params
     * @return content
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getContent(){
        return this.content;
    }
    /**
     * @setContent:CONTENT的set方法
     * @param content
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setContent(String content){
		this.content = content;
	} 
    /**
     * @getCreateTime:CREATE_TIME的get方法
     * @params
     * @return createTime
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public Timestamp getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:CREATE_TIME的set方法
     * @param createTime
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-11-26 14:32:47
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