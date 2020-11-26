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
 * ElectricianCompanyInfo的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "electrician_company_info")
public class ElectricianCompanyInfo implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * COMPANY_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "COMPANY_ID", nullable = false, length = 64)
    private String companyId ;
    
    /** 
     * COMPANY_NAME
     */
    @Column(name = "COMPANY_NAME", nullable = true, length = 256)
    private String companyName ;
    
    /** 
     * COMPANY_PHONENUMBER
     */
    @Column(name = "COMPANY_PHONENUMBER", nullable = true, length = 32)
    private String companyPhonenumber ;
    
    /** 
     * COMPANY_ADDRESS
     */
    @Column(name = "COMPANY_ADDRESS", nullable = true, length = 256)
    private String companyAddress ;
    
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
     * COMPANY_LEVEL
     */
    @Column(name = "COMPANY_LEVEL", nullable = true, length = 10)
    private String companyLevel ;
    
    /** 
     * RATING_CERTIFICATE
     */
    @Column(name = "RATING_CERTIFICATE", nullable = true, length = 512)
    private String ratingCertificate ;
    
    /** 
     * COMPANY_CONTRACT
     */
    @Column(name = "COMPANY_CONTRACT", nullable = true, length = 512)
    private String companyContract ;
    
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
	
	public ElectricianCompanyInfo(){
	
	}
    /**
     * @getCompanyId:COMPANY_ID的get方法
     * @params
     * @return companyId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCompanyId(){
        return this.companyId;
    }
    /**
     * @setCompanyId:COMPANY_ID的set方法
     * @param companyId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCompanyId(String companyId){
        if(companyId != null && companyId.trim().length() == 0){
        	this.companyId = null;
        }else{
        	this.companyId = companyId;
        }
	} 
    /**
     * @getCompanyName:COMPANY_NAME的get方法
     * @params
     * @return companyName
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCompanyName(){
        return this.companyName;
    }
    /**
     * @setCompanyName:COMPANY_NAME的set方法
     * @param companyName
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCompanyName(String companyName){
		this.companyName = companyName;
	} 
    /**
     * @getCompanyPhonenumber:COMPANY_PHONENUMBER的get方法
     * @params
     * @return companyPhonenumber
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCompanyPhonenumber(){
        return this.companyPhonenumber;
    }
    /**
     * @setCompanyPhonenumber:COMPANY_PHONENUMBER的set方法
     * @param companyPhonenumber
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCompanyPhonenumber(String companyPhonenumber){
		this.companyPhonenumber = companyPhonenumber;
	} 
    /**
     * @getCompanyAddress:COMPANY_ADDRESS的get方法
     * @params
     * @return companyAddress
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCompanyAddress(){
        return this.companyAddress;
    }
    /**
     * @setCompanyAddress:COMPANY_ADDRESS的set方法
     * @param companyAddress
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCompanyAddress(String companyAddress){
		this.companyAddress = companyAddress;
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
     * @getCompanyLevel:COMPANY_LEVEL的get方法
     * @params
     * @return companyLevel
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCompanyLevel(){
        return this.companyLevel;
    }
    /**
     * @setCompanyLevel:COMPANY_LEVEL的set方法
     * @param companyLevel
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCompanyLevel(String companyLevel){
		this.companyLevel = companyLevel;
	} 
    /**
     * @getRatingCertificate:RATING_CERTIFICATE的get方法
     * @params
     * @return ratingCertificate
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getRatingCertificate(){
        return this.ratingCertificate;
    }
    /**
     * @setRatingCertificate:RATING_CERTIFICATE的set方法
     * @param ratingCertificate
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setRatingCertificate(String ratingCertificate){
		this.ratingCertificate = ratingCertificate;
	} 
    /**
     * @getCompanyContract:COMPANY_CONTRACT的get方法
     * @params
     * @return companyContract
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCompanyContract(){
        return this.companyContract;
    }
    /**
     * @setCompanyContract:COMPANY_CONTRACT的set方法
     * @param companyContract
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCompanyContract(String companyContract){
		this.companyContract = companyContract;
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
		
        if (obj == null || !(obj instanceof ElectricianCompanyInfo))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		ElectricianCompanyInfo other = (ElectricianCompanyInfo) obj;
		
		if (companyId == null) {
			if (other.companyId != null) {
				return false;
			}
		} else if (!companyId.equals(other.companyId)) {
			return false;
		}
		if (companyName == null) {
			if (other.companyName != null) {
				return false;
			}
		} else if (!companyName.equals(other.companyName)) {
			return false;
		}
		if (companyPhonenumber == null) {
			if (other.companyPhonenumber != null) {
				return false;
			}
		} else if (!companyPhonenumber.equals(other.companyPhonenumber)) {
			return false;
		}
		if (companyAddress == null) {
			if (other.companyAddress != null) {
				return false;
			}
		} else if (!companyAddress.equals(other.companyAddress)) {
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
		if (companyLevel == null) {
			if (other.companyLevel != null) {
				return false;
			}
		} else if (!companyLevel.equals(other.companyLevel)) {
			return false;
		}
		if (ratingCertificate == null) {
			if (other.ratingCertificate != null) {
				return false;
			}
		} else if (!ratingCertificate.equals(other.ratingCertificate)) {
			return false;
		}
		if (companyContract == null) {
			if (other.companyContract != null) {
				return false;
			}
		} else if (!companyContract.equals(other.companyContract)) {
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
		return "ElectricianCompanyInfo ["
			+ ", companyId=" + companyId
			+ ", companyName=" + companyName
			+ ", companyPhonenumber=" + companyPhonenumber
			+ ", companyAddress=" + companyAddress
			+ ", addressLongitude=" + addressLongitude
			+ ", addressLatitude=" + addressLatitude
			+ ", companyLevel=" + companyLevel
			+ ", ratingCertificate=" + ratingCertificate
			+ ", companyContract=" + companyContract
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