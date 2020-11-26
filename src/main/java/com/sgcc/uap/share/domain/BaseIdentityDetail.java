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
 * BaseIdentityDetail的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "base_identity_detail")
public class BaseIdentityDetail implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * 身份ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "identity")
    @Column(name = "IDENTITY_ID", nullable = false, length = 2)
    private String identityId ;
    
    /** 
     * 身份名称
     */
    @Column(name = "IDENTITY_NAME", nullable = true, length = 10)
    private String identityName ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public BaseIdentityDetail(){
	
	}
    /**
     * @getIdentityId:身份ID的get方法
     * @params
     * @return identityId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getIdentityId(){
        return this.identityId;
    }
    /**
     * @setIdentityId:身份ID的set方法
     * @param identityId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setIdentityId(String identityId){
        if(identityId != null && identityId.trim().length() == 0){
        	this.identityId = null;
        }else{
        	this.identityId = identityId;
        }
	} 
    /**
     * @getIdentityName:身份名称的get方法
     * @params
     * @return identityName
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getIdentityName(){
        return this.identityName;
    }
    /**
     * @setIdentityName:身份名称的set方法
     * @param identityName
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setIdentityName(String identityName){
		this.identityName = identityName;
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
		
        if (obj == null || !(obj instanceof BaseIdentityDetail))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		BaseIdentityDetail other = (BaseIdentityDetail) obj;
		
		if (identityId == null) {
			if (other.identityId != null) {
				return false;
			}
		} else if (!identityId.equals(other.identityId)) {
			return false;
		}
		if (identityName == null) {
			if (other.identityName != null) {
				return false;
			}
		} else if (!identityName.equals(other.identityName)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "BaseIdentityDetail ["
			+ ", identityId=" + identityId
			+ ", identityName=" + identityName;
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