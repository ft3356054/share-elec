package com.sgcc.uap.share.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


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
	/*@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")*/
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
     * PROVINCE_ID
     */
    @Column(name = "PROVINCE_ID", nullable = true, length = 8)
    private int provinceId ;
    
    /** 
     * CITY_ID
     */
    @Column(name = "CITY_ID", nullable = true, length = 8)
    private int cityId ;
    
    /** 
     * AREA_ID
     */
    @Column(name = "AREA_ID", nullable = true, length = 8)
    private int areaId ;
    
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
     * HEAD_ICON
     */
    @Column(name = "HEAD_ICON", nullable = true, length = 256)
    private String headIcon ;
    
    /** 
     * REAL_NAME_AUTH
     */
    @Column(name = "REAL_NAME_AUTH", nullable = true, length = 2)
    private String realNameAuth ;
    
    /** 
     * REGISTERED_NUMBER
     */
    @Column(name = "REGISTERED_NUMBER", nullable = true, length = 32)
    private String registeredNumber ;
    
    /** 
     * AuditStatus电工认证状态 0未认证 1待审核
     */
    @Transient
    private String AuditStatus ;
    
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
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public String getCustomerId(){
        return this.customerId;
    }
    /**
     * @setCustomerId:CUSTOMER_ID的set方法
     * @param customerId
     * @return
     * @date 2020-12-17 17:42:20
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
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public String getCustomerName(){
        return this.customerName;
    }
    /**
     * @setCustomerName:CUSTOMER_NAME的set方法
     * @param customerName
     * @return
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public void setCustomerName(String customerName){
		this.customerName = customerName;
	} 
    /**
     * @getCustomerPhonenumber:CUSTOMER_PHONENUMBER的get方法
     * @params
     * @return customerPhonenumber
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public String getCustomerPhonenumber(){
        return this.customerPhonenumber;
    }
    /**
     * @setCustomerPhonenumber:CUSTOMER_PHONENUMBER的set方法
     * @param customerPhonenumber
     * @return
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public void setCustomerPhonenumber(String customerPhonenumber){
		this.customerPhonenumber = customerPhonenumber;
	} 
    
    public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
    /**
     * @getIdentityId:IDENTITY_ID的get方法
     * @params
     * @return identityId
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public String getIdentityId(){
        return this.identityId;
    }
    /**
     * @setIdentityId:IDENTITY_ID的set方法
     * @param identityId
     * @return
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public void setIdentityId(String identityId){
		this.identityId = identityId;
	} 
    /**
     * @getCustomerScore:CUSTOMER_SCORE的get方法
     * @params
     * @return customerScore
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public String getCustomerScore(){
        return this.customerScore;
    }
    /**
     * @setCustomerScore:CUSTOMER_SCORE的set方法
     * @param customerScore
     * @return
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public void setCustomerScore(String customerScore){
		this.customerScore = customerScore;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 
    /**
     * @getCustomerAddress:CUSTOMER_ADDRESS的get方法
     * @params
     * @return customerAddress
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public String getCustomerAddress(){
        return this.customerAddress;
    }
    /**
     * @setCustomerAddress:CUSTOMER_ADDRESS的set方法
     * @param customerAddress
     * @return
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public void setCustomerAddress(String customerAddress){
		this.customerAddress = customerAddress;
	} 
    /**
     * @getHeadIcon:HEAD_ICON的get方法
     * @params
     * @return headIcon
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public String getHeadIcon(){
        return this.headIcon;
    }
    /**
     * @setHeadIcon:HEAD_ICON的set方法
     * @param headIcon
     * @return
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public void setHeadIcon(String headIcon){
		this.headIcon = headIcon;
	} 
    /**
     * @getRealNameAuth:REAL_NAME_AUTH的get方法
     * @params
     * @return realNameAuth
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public String getRealNameAuth(){
        return this.realNameAuth;
    }
    /**
     * @setRealNameAuth:REAL_NAME_AUTH的set方法
     * @param realNameAuth
     * @return
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public void setRealNameAuth(String realNameAuth){
		this.realNameAuth = realNameAuth;
	} 
    /**
     * @getRegisteredNumber:REGISTERED_NUMBER的get方法
     * @params
     * @return registeredNumber
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public String getRegisteredNumber(){
        return this.registeredNumber;
    }
    /**
     * @setRegisteredNumber:REGISTERED_NUMBER的set方法
     * @param registeredNumber
     * @return
     * @date 2020-12-17 17:42:20
     * @author 18511
     */
    public void setRegisteredNumber(String registeredNumber){
		this.registeredNumber = registeredNumber;
	} 
	public String getMxVirtualId() {
        return this.mxVirtualId;
    }
    
    public void setMxVirtualId(String mxVirtualId) {
        this.mxVirtualId = mxVirtualId;
    } 
    public String getAuditStatus() {
		return AuditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		AuditStatus = auditStatus;
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
		if (headIcon == null) {
			if (other.headIcon != null) {
				return false;
			}
		} else if (!headIcon.equals(other.headIcon)) {
			return false;
		}
		if (realNameAuth == null) {
			if (other.realNameAuth != null) {
				return false;
			}
		} else if (!realNameAuth.equals(other.realNameAuth)) {
			return false;
		}
		if (registeredNumber == null) {
			if (other.registeredNumber != null) {
				return false;
			}
		} else if (!registeredNumber.equals(other.registeredNumber)) {
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
			+ ", identityId=" + identityId
			+ ", customerScore=" + customerScore
			+ ", remark=" + remark
			+ ", customerAddress=" + customerAddress
			+ ", headIcon=" + headIcon
			+ ", realNameAuth=" + realNameAuth
			+ ", registeredNumber=" + registeredNumber;
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