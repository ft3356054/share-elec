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
 * ElectricianSubCompanyInfo的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "electrician_sub_company_info")
public class ElectricianSubCompanyInfo implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * SUB_COMPANY_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "SUB_COMPANY_ID", nullable = false, length = 64)
    private String subCompanyId ;
    
    /** 
     * COMPANY_ID
     */
    @Column(name = "COMPANY_ID", nullable = true, length = 64)
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
     * COMPANY_AREA_ID
     */
    @Column(name = "COMPANY_AREA_ID", nullable = true, length = 32)
    private String companyAreaId ;
    
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
     * REMARK1
     */
    @Column(name = "REMARK1", nullable = true, length = 512)
    private String remark1 ;
    
    /** 
     * REMARK2
     */
    @Column(name = "REMARK2", nullable = true, length = 512)
    private String remark2 ;
    
    /** 
     * REMARK3
     */
    @Column(name = "REMARK3", nullable = true, length = 512)
    private String remark3 ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public ElectricianSubCompanyInfo(){
	
	}
    /**
     * @getSubCompanyId:SUB_COMPANY_ID的get方法
     * @params
     * @return subCompanyId
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getSubCompanyId(){
        return this.subCompanyId;
    }
    /**
     * @setSubCompanyId:SUB_COMPANY_ID的set方法
     * @param subCompanyId
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setSubCompanyId(String subCompanyId){
        if(subCompanyId != null && subCompanyId.trim().length() == 0){
        	this.subCompanyId = null;
        }else{
        	this.subCompanyId = subCompanyId;
        }
	} 
    /**
     * @getCompanyId:COMPANY_ID的get方法
     * @params
     * @return companyId
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getCompanyId(){
        return this.companyId;
    }
    /**
     * @setCompanyId:COMPANY_ID的set方法
     * @param companyId
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setCompanyId(String companyId){
		this.companyId = companyId;
	} 
    /**
     * @getCompanyName:COMPANY_NAME的get方法
     * @params
     * @return companyName
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getCompanyName(){
        return this.companyName;
    }
    /**
     * @setCompanyName:COMPANY_NAME的set方法
     * @param companyName
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setCompanyName(String companyName){
		this.companyName = companyName;
	} 
    /**
     * @getCompanyPhonenumber:COMPANY_PHONENUMBER的get方法
     * @params
     * @return companyPhonenumber
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getCompanyPhonenumber(){
        return this.companyPhonenumber;
    }
    /**
     * @setCompanyPhonenumber:COMPANY_PHONENUMBER的set方法
     * @param companyPhonenumber
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setCompanyPhonenumber(String companyPhonenumber){
		this.companyPhonenumber = companyPhonenumber;
	} 
    /**
     * @getCompanyAddress:COMPANY_ADDRESS的get方法
     * @params
     * @return companyAddress
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getCompanyAddress(){
        return this.companyAddress;
    }
    /**
     * @setCompanyAddress:COMPANY_ADDRESS的set方法
     * @param companyAddress
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setCompanyAddress(String companyAddress){
		this.companyAddress = companyAddress;
	} 
    /**
     * @getAddressLongitude:ADDRESS_LONGITUDE的get方法
     * @params
     * @return addressLongitude
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getAddressLongitude(){
        return this.addressLongitude;
    }
    /**
     * @setAddressLongitude:ADDRESS_LONGITUDE的set方法
     * @param addressLongitude
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setAddressLongitude(String addressLongitude){
		this.addressLongitude = addressLongitude;
	} 
    /**
     * @getAddressLatitude:ADDRESS_LATITUDE的get方法
     * @params
     * @return addressLatitude
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getAddressLatitude(){
        return this.addressLatitude;
    }
    /**
     * @setAddressLatitude:ADDRESS_LATITUDE的set方法
     * @param addressLatitude
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setAddressLatitude(String addressLatitude){
		this.addressLatitude = addressLatitude;
	} 
    /**
     * @getCompanyAreaId:COMPANY_AREA_ID的get方法
     * @params
     * @return companyAreaId
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getCompanyAreaId(){
        return this.companyAreaId;
    }
    /**
     * @setCompanyAreaId:COMPANY_AREA_ID的set方法
     * @param companyAreaId
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setCompanyAreaId(String companyAreaId){
		this.companyAreaId = companyAreaId;
	} 
    /**
     * @getCompanyLevel:COMPANY_LEVEL的get方法
     * @params
     * @return companyLevel
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getCompanyLevel(){
        return this.companyLevel;
    }
    /**
     * @setCompanyLevel:COMPANY_LEVEL的set方法
     * @param companyLevel
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setCompanyLevel(String companyLevel){
		this.companyLevel = companyLevel;
	} 
    /**
     * @getRatingCertificate:RATING_CERTIFICATE的get方法
     * @params
     * @return ratingCertificate
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getRatingCertificate(){
        return this.ratingCertificate;
    }
    /**
     * @setRatingCertificate:RATING_CERTIFICATE的set方法
     * @param ratingCertificate
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setRatingCertificate(String ratingCertificate){
		this.ratingCertificate = ratingCertificate;
	} 
    /**
     * @getCompanyContract:COMPANY_CONTRACT的get方法
     * @params
     * @return companyContract
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getCompanyContract(){
        return this.companyContract;
    }
    /**
     * @setCompanyContract:COMPANY_CONTRACT的set方法
     * @param companyContract
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setCompanyContract(String companyContract){
		this.companyContract = companyContract;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 
    /**
     * @getRemark1:REMARK1的get方法
     * @params
     * @return remark1
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getRemark1(){
        return this.remark1;
    }
    /**
     * @setRemark1:REMARK1的set方法
     * @param remark1
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setRemark1(String remark1){
		this.remark1 = remark1;
	} 
    /**
     * @getRemark2:REMARK2的get方法
     * @params
     * @return remark2
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getRemark2(){
        return this.remark2;
    }
    /**
     * @setRemark2:REMARK2的set方法
     * @param remark2
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setRemark2(String remark2){
		this.remark2 = remark2;
	} 
    /**
     * @getRemark3:REMARK3的get方法
     * @params
     * @return remark3
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public String getRemark3(){
        return this.remark3;
    }
    /**
     * @setRemark3:REMARK3的set方法
     * @param remark3
     * @return
     * @date 2020-12-18 11:51:05
     * @author 18511
     */
    public void setRemark3(String remark3){
		this.remark3 = remark3;
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
		
        if (obj == null || !(obj instanceof ElectricianSubCompanyInfo))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		ElectricianSubCompanyInfo other = (ElectricianSubCompanyInfo) obj;
		
		if (subCompanyId == null) {
			if (other.subCompanyId != null) {
				return false;
			}
		} else if (!subCompanyId.equals(other.subCompanyId)) {
			return false;
		}
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
		if (companyAreaId == null) {
			if (other.companyAreaId != null) {
				return false;
			}
		} else if (!companyAreaId.equals(other.companyAreaId)) {
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
		if (remark1 == null) {
			if (other.remark1 != null) {
				return false;
			}
		} else if (!remark1.equals(other.remark1)) {
			return false;
		}
		if (remark2 == null) {
			if (other.remark2 != null) {
				return false;
			}
		} else if (!remark2.equals(other.remark2)) {
			return false;
		}
		if (remark3 == null) {
			if (other.remark3 != null) {
				return false;
			}
		} else if (!remark3.equals(other.remark3)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "ElectricianSubCompanyInfo ["
			+ ", subCompanyId=" + subCompanyId
			+ ", companyId=" + companyId
			+ ", companyName=" + companyName
			+ ", companyPhonenumber=" + companyPhonenumber
			+ ", companyAddress=" + companyAddress
			+ ", addressLongitude=" + addressLongitude
			+ ", addressLatitude=" + addressLatitude
			+ ", companyAreaId=" + companyAreaId
			+ ", companyLevel=" + companyLevel
			+ ", ratingCertificate=" + ratingCertificate
			+ ", companyContract=" + companyContract
			+ ", remark=" + remark
			+ ", remark1=" + remark1
			+ ", remark2=" + remark2
			+ ", remark3=" + remark3;
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