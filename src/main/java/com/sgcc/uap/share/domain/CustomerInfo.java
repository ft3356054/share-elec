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
 * CustomerInfo的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "customer_info")
public class CustomerInfo implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * CUSTOMER_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "CUSTOMER_ID", nullable = false, length = 64)
    private String customerId ;
    
    /** 
     * CUSTOMER_NAME
     */
    @Column(name = "CUSTOMER_NAME", nullable = true, length = 32)
    private String customerName ;
    
    /** 
     * CUSTOMER_PHONENUMBER
     */
    @Column(name = "CUSTOMER_PHONENUMBER", nullable = true, length = 32)
    private String customerPhonenumber ;
    
    /** 
     * ADDRESS_LONGITUDE
     */
    @Column(name = "ADDRESS_LONGITUDE", nullable = true, length = 32)
    private String addressLongitude ;
    
    /** 
     * ADDRESS_LATITUDE
     */
    @Column(name = "ADDRESS_LATITUDE", nullable = true, length = 32)
    private String addressLatitude ;
    
    /** 
     * IDENTITY_ID
     */
    @Column(name = "IDENTITY_ID", nullable = true, length = 2)
    private String identityId ;
    
    /** 
     * CUSTOMER_SCORE
     */
    @Column(name = "CUSTOMER_SCORE", nullable = true, length = 2)
    private String customerScore ;
    
    /** 
     * REMARK
     */
    @Column(name = "REMARK", nullable = true, length = 256)
    private String remark ;
    
    /** 
     * CUSTOMER_ADDRESS
     */
    @Column(name = "CUSTOMER_ADDRESS", nullable = true, length = 256)
    private String customerAddress ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public CustomerInfo(){
	
	}
    /**
     * @getCustomerId:CUSTOMER_ID的get方法
     * @params
     * @return customerId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerId(){
        return this.customerId;
    }
    /**
     * @setCustomerId:CUSTOMER_ID的set方法
     * @param customerId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerId(String customerId){
        if(customerId != null && customerId.trim().length() == 0){
        	this.customerId = null;
        }else{
        	this.customerId = customerId;
        }
	} 
    /**
     * @getCustomerName:CUSTOMER_NAME的get方法
     * @params
     * @return customerName
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerName(){
        return this.customerName;
    }
    /**
     * @setCustomerName:CUSTOMER_NAME的set方法
     * @param customerName
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerName(String customerName){
		this.customerName = customerName;
	} 
    /**
     * @getCustomerPhonenumber:CUSTOMER_PHONENUMBER的get方法
     * @params
     * @return customerPhonenumber
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerPhonenumber(){
        return this.customerPhonenumber;
    }
    /**
     * @setCustomerPhonenumber:CUSTOMER_PHONENUMBER的set方法
     * @param customerPhonenumber
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerPhonenumber(String customerPhonenumber){
		this.customerPhonenumber = customerPhonenumber;
	} 
    /**
     * @getAddressLongitude:ADDRESS_LONGITUDE的get方法
     * @params
     * @return addressLongitude
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getAddressLongitude(){
        return this.addressLongitude;
    }
    /**
     * @setAddressLongitude:ADDRESS_LONGITUDE的set方法
     * @param addressLongitude
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setAddressLongitude(String addressLongitude){
		this.addressLongitude = addressLongitude;
	} 
    /**
     * @getAddressLatitude:ADDRESS_LATITUDE的get方法
     * @params
     * @return addressLatitude
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getAddressLatitude(){
        return this.addressLatitude;
    }
    /**
     * @setAddressLatitude:ADDRESS_LATITUDE的set方法
     * @param addressLatitude
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setAddressLatitude(String addressLatitude){
		this.addressLatitude = addressLatitude;
	} 
    /**
     * @getIdentityId:IDENTITY_ID的get方法
     * @params
     * @return identityId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getIdentityId(){
        return this.identityId;
    }
    /**
     * @setIdentityId:IDENTITY_ID的set方法
     * @param identityId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setIdentityId(String identityId){
		this.identityId = identityId;
	} 
    /**
     * @getCustomerScore:CUSTOMER_SCORE的get方法
     * @params
     * @return customerScore
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerScore(){
        return this.customerScore;
    }
    /**
     * @setCustomerScore:CUSTOMER_SCORE的set方法
     * @param customerScore
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerScore(String customerScore){
		this.customerScore = customerScore;
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
    /**
     * @getCustomerAddress:CUSTOMER_ADDRESS的get方法
     * @params
     * @return customerAddress
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerAddress(){
        return this.customerAddress;
    }
    /**
     * @setCustomerAddress:CUSTOMER_ADDRESS的set方法
     * @param customerAddress
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerAddress(String customerAddress){
		this.customerAddress = customerAddress;
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
		
        if (obj == null || !(obj instanceof CustomerInfo))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		CustomerInfo other = (CustomerInfo) obj;
		
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (customerName == null) {
			if (other.customerName != null) {
				return false;
			}
		} else if (!customerName.equals(other.customerName)) {
			return false;
		}
		if (customerPhonenumber == null) {
			if (other.customerPhonenumber != null) {
				return false;
			}
		} else if (!customerPhonenumber.equals(other.customerPhonenumber)) {
			return false;
		}
		if (addressLongitude == null) {
			if (other.addressLongitude != null) {
				return false;
			}
		} else if (!addressLongitude.equals(other.addressLongitude)) {
			return false;
		}
		if (addressLatitude == null) {
			if (other.addressLatitude != null) {
				return false;
			}
		} else if (!addressLatitude.equals(other.addressLatitude)) {
			return false;
		}
		if (identityId == null) {
			if (other.identityId != null) {
				return false;
			}
		} else if (!identityId.equals(other.identityId)) {
			return false;
		}
		if (customerScore == null) {
			if (other.customerScore != null) {
				return false;
			}
		} else if (!customerScore.equals(other.customerScore)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		if (customerAddress == null) {
			if (other.customerAddress != null) {
				return false;
			}
		} else if (!customerAddress.equals(other.customerAddress)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "CustomerInfo ["
			+ ", customerId=" + customerId
			+ ", customerName=" + customerName
			+ ", customerPhonenumber=" + customerPhonenumber
			+ ", addressLongitude=" + addressLongitude
			+ ", addressLatitude=" + addressLatitude
			+ ", identityId=" + identityId
			+ ", customerScore=" + customerScore
			+ ", remark=" + remark
			+ ", customerAddress=" + customerAddress;
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