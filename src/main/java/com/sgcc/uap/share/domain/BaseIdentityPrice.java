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
 * BaseIdentityPrice的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "base_identity_price")
public class BaseIdentityPrice implements Serializable {

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
     * 身份定价
     */
    @Column(name = "IDENTITY_PRICE", nullable = true, length = 5)
    private String identityPrice ;
    
    /** 
     * REMARK
     */
    @Column(name = "REMARK", nullable = true, length = 64)
    private String remark ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public BaseIdentityPrice(){
	
	}
    /**
     * @getIdentityId:身份ID的get方法
     * @params
     * @return identityId
     * @date 2020-11-30 14:16:50
     * @author 18511
     */
    public String getIdentityId(){
        return this.identityId;
    }
    /**
     * @setIdentityId:身份ID的set方法
     * @param identityId
     * @return
     * @date 2020-11-30 14:16:50
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
     * @getIdentityPrice:身份定价的get方法
     * @params
     * @return identityPrice
     * @date 2020-11-30 14:16:50
     * @author 18511
     */
    public String getIdentityPrice(){
        return this.identityPrice;
    }
    /**
     * @setIdentityPrice:身份定价的set方法
     * @param identityPrice
     * @return
     * @date 2020-11-30 14:16:50
     * @author 18511
     */
    public void setIdentityPrice(String identityPrice){
		this.identityPrice = identityPrice;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-11-30 14:16:50
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-11-30 14:16:50
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
		
        if (obj == null || !(obj instanceof BaseIdentityPrice))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		BaseIdentityPrice other = (BaseIdentityPrice) obj;
		
		if (identityId == null) {
			if (other.identityId != null) {
				return false;
			}
		} else if (!identityId.equals(other.identityId)) {
			return false;
		}
		if (identityPrice == null) {
			if (other.identityPrice != null) {
				return false;
			}
		} else if (!identityPrice.equals(other.identityPrice)) {
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
		return "BaseIdentityPrice ["
			+ ", identityId=" + identityId
			+ ", identityPrice=" + identityPrice
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