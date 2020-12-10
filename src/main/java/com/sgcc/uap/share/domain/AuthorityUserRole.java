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
 * AuthorityUserRole的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "authority_user_role")
public class AuthorityUserRole implements Serializable {

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
     * USER_ID
     */
    @Column(name = "USER_ID", nullable = true, length = 64)
    private String userId ;
    
    /** 
     * ROLE_ID
     */
    @Column(name = "ROLE_ID", nullable = true, length = 64)
    private String roleId ;
    
    /** 
     * TYPE
     */
    @Column(name = "TYPE", nullable = true, length = 2)
    private String _type ;
    
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
	
	public AuthorityUserRole(){
	
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
     * @getUserId:USER_ID的get方法
     * @params
     * @return userId
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getUserId(){
        return this.userId;
    }
    /**
     * @setUserId:USER_ID的set方法
     * @param userId
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setUserId(String userId){
		this.userId = userId;
	} 
    /**
     * @getRoleId:ROLE_ID的get方法
     * @params
     * @return roleId
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getRoleId(){
        return this.roleId;
    }
    /**
     * @setRoleId:ROLE_ID的set方法
     * @param roleId
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setRoleId(String roleId){
		this.roleId = roleId;
	} 
    /**
     * @get_type:TYPE的get方法
     * @params
     * @return _type
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String get_type(){
        return this._type;
    }
    /**
     * @set_type:TYPE的set方法
     * @param _type
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void set_type(String _type){
		this._type = _type;
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
		
        if (obj == null || !(obj instanceof AuthorityUserRole))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		AuthorityUserRole other = (AuthorityUserRole) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		if (roleId == null) {
			if (other.roleId != null) {
				return false;
			}
		} else if (!roleId.equals(other.roleId)) {
			return false;
		}
		if (_type == null) {
			if (other._type != null) {
				return false;
			}
		} else if (!_type.equals(other._type)) {
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
		return "AuthorityUserRole ["
			+ ", id=" + id
			+ ", userId=" + userId
			+ ", roleId=" + roleId
			+ ", _type=" + _type
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