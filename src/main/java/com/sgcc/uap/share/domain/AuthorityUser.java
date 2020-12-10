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
 * AuthorityUser的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "authority_user")
public class AuthorityUser implements Serializable {

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
     * USER_NAME
     */
    @Column(name = "USER_NAME", nullable = true, length = 64)
    private String userName ;
    
    /** 
     * USER_DESC
     */
    @Column(name = "USER_DESC", nullable = true, length = 256)
    private String userDesc ;
    
    /** 
     * STATUS
     */
    @Column(name = "STATUS", nullable = true, length = 2)
    private String _status ;
    
    /** 
     * REMARK
     */
    @Column(name = "REMARK", nullable = true, length = 256)
    private String remark ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public AuthorityUser(){
	
	}
    /**
     * @getId:ID的get方法
     * @params
     * @return id
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getId(){
        return this.id;
    }
    /**
     * @setId:ID的set方法
     * @param id
     * @return
     * @date 2020-12-10 09:35:40
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
     * @getUserName:USER_NAME的get方法
     * @params
     * @return userName
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getUserName(){
        return this.userName;
    }
    /**
     * @setUserName:USER_NAME的set方法
     * @param userName
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setUserName(String userName){
		this.userName = userName;
	} 
    /**
     * @getUserDesc:USER_DESC的get方法
     * @params
     * @return userDesc
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getUserDesc(){
        return this.userDesc;
    }
    /**
     * @setUserDesc:USER_DESC的set方法
     * @param userDesc
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setUserDesc(String userDesc){
		this.userDesc = userDesc;
	} 
    /**
     * @get_status:STATUS的get方法
     * @params
     * @return _status
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String get_status(){
        return this._status;
    }
    /**
     * @set_status:STATUS的set方法
     * @param _status
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void set_status(String _status){
		this._status = _status;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-12-10 09:35:40
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
		
        if (obj == null || !(obj instanceof AuthorityUser))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		AuthorityUser other = (AuthorityUser) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		if (userDesc == null) {
			if (other.userDesc != null) {
				return false;
			}
		} else if (!userDesc.equals(other.userDesc)) {
			return false;
		}
		if (_status == null) {
			if (other._status != null) {
				return false;
			}
		} else if (!_status.equals(other._status)) {
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
		return "AuthorityUser ["
			+ ", id=" + id
			+ ", userName=" + userName
			+ ", userDesc=" + userDesc
			+ ", _status=" + _status
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