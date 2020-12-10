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
 * AuthorityRole的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "authority_role")
public class AuthorityRole implements Serializable {

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
     * ROLE_NAME
     */
    @Column(name = "ROLE_NAME", nullable = true, length = 64)
    private String roleName ;
    
    /** 
     * ROLE_DESC
     */
    @Column(name = "ROLE_DESC", nullable = true, length = 256)
    private String roleDesc ;
    
    /** 
     * CREATE_TIME
     */
    @Column(name = "CREATE_TIME", nullable = true, length = 19)
    private Timestamp createTime ;
    
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
	
	public AuthorityRole(){
	
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
     * @getRoleName:ROLE_NAME的get方法
     * @params
     * @return roleName
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getRoleName(){
        return this.roleName;
    }
    /**
     * @setRoleName:ROLE_NAME的set方法
     * @param roleName
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setRoleName(String roleName){
		this.roleName = roleName;
	} 
    /**
     * @getRoleDesc:ROLE_DESC的get方法
     * @params
     * @return roleDesc
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getRoleDesc(){
        return this.roleDesc;
    }
    /**
     * @setRoleDesc:ROLE_DESC的set方法
     * @param roleDesc
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setRoleDesc(String roleDesc){
		this.roleDesc = roleDesc;
	} 
    /**
     * @getCreateTime:CREATE_TIME的get方法
     * @params
     * @return createTime
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public Timestamp getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:CREATE_TIME的set方法
     * @param createTime
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
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
		
        if (obj == null || !(obj instanceof AuthorityRole))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		AuthorityRole other = (AuthorityRole) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (roleName == null) {
			if (other.roleName != null) {
				return false;
			}
		} else if (!roleName.equals(other.roleName)) {
			return false;
		}
		if (roleDesc == null) {
			if (other.roleDesc != null) {
				return false;
			}
		} else if (!roleDesc.equals(other.roleDesc)) {
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
		return "AuthorityRole ["
			+ ", id=" + id
			+ ", roleName=" + roleName
			+ ", roleDesc=" + roleDesc
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