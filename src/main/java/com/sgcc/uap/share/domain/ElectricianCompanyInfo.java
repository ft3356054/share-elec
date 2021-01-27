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
     * LEGAL_PERSON
     */
    @Column(name = "LEGAL_PERSON", nullable = true, length = 32)
    private String legalPerson ;
    
    /** 
     * CREDIT_CODE
     */
    @Column(name = "CREDIT_CODE", nullable = true, length = 64)
    private String creditCode ;
    
    /** 
     * STRUCTURE_CODE
     */
    @Column(name = "STRUCTURE_CODE", nullable = true, length = 64)
    private String structureCode ;
    
    /** 
     * ON_BUSINESS_BEGIN
     */
    @Column(name = "ON_BUSINESS_BEGIN", nullable = true, length = 19)
    private String onBusinessBegin ;
    
    /** 
     * ON_BUSINESS_END
     */
    @Column(name = "ON_BUSINESS_END", nullable = true, length = 19)
    private String onBusinessEnd ;
    
    /** 
     * BUSINESS_COPE
     */
    @Column(name = "BUSINESS_COPE", nullable = true, length = 64)
    private String businessCope ;
    
    /** 
     * QUALI_CODE
     */
    @Column(name = "QUALI_CODE", nullable = true, length = 64)
    private String qualiCode ;
    
    /** 
     * QUALI_INDUSTRY
     */
    @Column(name = "QUALI_INDUSTRY", nullable = true, length = 64)
    private String qualiIndustry ;
    
    /** 
     * QUALI_LEVEL
     */
    @Column(name = "QUALI_LEVEL", nullable = true, length = 64)
    private String qualiLevel ;
    
    /** 
     * CERTIFICATE_CODE
     */
    @Column(name = "CERTIFICATE_CODE", nullable = true, length = 64)
    private String certificateCode ;
    
    /** 
     * REGISETER_TIME
     */
    @Column(name = "REGISETER_TIME", nullable = true, length = 19)
    private String regiseterTime ;
    
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
     * REMARK4
     */
    @Column(name = "REMARK4", nullable = true, length = 512)
    private String remark4 ;
    
    /** 
     * REMARK5
     */
    @Column(name = "REMARK5", nullable = true, length = 512)
    private String remark5 ;
    
    /** 
     * COMPANY_AREA_ID
     */
    @Column(name = "COMPANY_AREA_ID", nullable = true, length = 32)
    private String companyAreaId ;
    /** 
     * BUSINESS_STATUS
     */
    @Column(name = "BUSINESS_STATUS", nullable = true, length = 2)
    private String businessStatus ;
    /** 
     * BUSINESS_TYPE
     */
    @Column(name = "BUSINESS_TYPE", nullable = true, length = 2)
    private String businessType ;
    /** 
     * BUSINESS_POINT
     */
    @Column(name = "BUSINESS_POINT", nullable = true, length = 2)
    private String businessPoint ;
    /** 
     * SERVICE_CHARGE
     */
    @Column(name = "SERVICE_CHARGE", nullable = true, length = 2)
    private String businessCharge ;
    
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public ElectricianCompanyInfo(){
	
	}
	
    public String getBusinessPoint() {
		return businessPoint;
	}

	public void setBusinessPoint(String businessPoint) {
		this.businessPoint = businessPoint;
	}

	public String getBusinessCharge() {
		return businessCharge;
	}

	public void setBusinessCharge(String businessCharge) {
		this.businessCharge = businessCharge;
	}

	public String getCompanyAreaId() {
		return companyAreaId;
	}

	public void setCompanyAreaId(String companyAreaId) {
		this.companyAreaId = companyAreaId;
	}

	public String getBusinessStatus() {
		return businessStatus;
	}

	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
     * @getCompanyId:COMPANY_ID的get方法
     * @params
     * @return companyId
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getCompanyId(){
        return this.companyId;
    }
    /**
     * @setCompanyId:COMPANY_ID的set方法
     * @param companyId
     * @return
     * @date 2020-12-18 11:51:00
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
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getCompanyName(){
        return this.companyName;
    }
    /**
     * @setCompanyName:COMPANY_NAME的set方法
     * @param companyName
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setCompanyName(String companyName){
		this.companyName = companyName;
	} 
    /**
     * @getCompanyPhonenumber:COMPANY_PHONENUMBER的get方法
     * @params
     * @return companyPhonenumber
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getCompanyPhonenumber(){
        return this.companyPhonenumber;
    }
    /**
     * @setCompanyPhonenumber:COMPANY_PHONENUMBER的set方法
     * @param companyPhonenumber
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setCompanyPhonenumber(String companyPhonenumber){
		this.companyPhonenumber = companyPhonenumber;
	} 
    /**
     * @getCompanyAddress:COMPANY_ADDRESS的get方法
     * @params
     * @return companyAddress
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getCompanyAddress(){
        return this.companyAddress;
    }
    /**
     * @setCompanyAddress:COMPANY_ADDRESS的set方法
     * @param companyAddress
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setCompanyAddress(String companyAddress){
		this.companyAddress = companyAddress;
	} 
    /**
     * @getAddressLongitude:ADDRESS_LONGITUDE的get方法
     * @params
     * @return addressLongitude
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getAddressLongitude(){
        return this.addressLongitude;
    }
    /**
     * @setAddressLongitude:ADDRESS_LONGITUDE的set方法
     * @param addressLongitude
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setAddressLongitude(String addressLongitude){
		this.addressLongitude = addressLongitude;
	} 
    /**
     * @getAddressLatitude:ADDRESS_LATITUDE的get方法
     * @params
     * @return addressLatitude
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getAddressLatitude(){
        return this.addressLatitude;
    }
    /**
     * @setAddressLatitude:ADDRESS_LATITUDE的set方法
     * @param addressLatitude
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setAddressLatitude(String addressLatitude){
		this.addressLatitude = addressLatitude;
	} 
    /**
     * @getCompanyLevel:COMPANY_LEVEL的get方法
     * @params
     * @return companyLevel
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getCompanyLevel(){
        return this.companyLevel;
    }
    /**
     * @setCompanyLevel:COMPANY_LEVEL的set方法
     * @param companyLevel
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setCompanyLevel(String companyLevel){
		this.companyLevel = companyLevel;
	} 
    /**
     * @getRatingCertificate:RATING_CERTIFICATE的get方法
     * @params
     * @return ratingCertificate
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getRatingCertificate(){
        return this.ratingCertificate;
    }
    /**
     * @setRatingCertificate:RATING_CERTIFICATE的set方法
     * @param ratingCertificate
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setRatingCertificate(String ratingCertificate){
		this.ratingCertificate = ratingCertificate;
	} 
    /**
     * @getCompanyContract:COMPANY_CONTRACT的get方法
     * @params
     * @return companyContract
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getCompanyContract(){
        return this.companyContract;
    }
    /**
     * @setCompanyContract:COMPANY_CONTRACT的set方法
     * @param companyContract
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setCompanyContract(String companyContract){
		this.companyContract = companyContract;
	} 
    /**
     * @getLegalPerson:LEGAL_PERSON的get方法
     * @params
     * @return legalPerson
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getLegalPerson(){
        return this.legalPerson;
    }
    /**
     * @setLegalPerson:LEGAL_PERSON的set方法
     * @param legalPerson
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setLegalPerson(String legalPerson){
		this.legalPerson = legalPerson;
	} 
    /**
     * @getCreditCode:CREDIT_CODE的get方法
     * @params
     * @return creditCode
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getCreditCode(){
        return this.creditCode;
    }
    /**
     * @setCreditCode:CREDIT_CODE的set方法
     * @param creditCode
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setCreditCode(String creditCode){
		this.creditCode = creditCode;
	} 
    /**
     * @getStructureCode:STRUCTURE_CODE的get方法
     * @params
     * @return structureCode
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getStructureCode(){
        return this.structureCode;
    }
    /**
     * @setStructureCode:STRUCTURE_CODE的set方法
     * @param structureCode
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setStructureCode(String structureCode){
		this.structureCode = structureCode;
	} 
    /**
     * @getOnBusinessBegin:ON_BUSINESS_BEGIN的get方法
     * @params
     * @return onBusinessBegin
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getOnBusinessBegin(){
        return this.onBusinessBegin;
    }
    /**
     * @setOnBusinessBegin:ON_BUSINESS_BEGIN的set方法
     * @param onBusinessBegin
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setOnBusinessBegin(String onBusinessBegin){
		this.onBusinessBegin = onBusinessBegin;
	} 
    /**
     * @getOnBusinessEnd:ON_BUSINESS_END的get方法
     * @params
     * @return onBusinessEnd
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getOnBusinessEnd(){
        return this.onBusinessEnd;
    }
    /**
     * @setOnBusinessEnd:ON_BUSINESS_END的set方法
     * @param onBusinessEnd
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setOnBusinessEnd(String onBusinessEnd){
		this.onBusinessEnd = onBusinessEnd;
	} 
    /**
     * @getBusinessCope:BUSINESS_COPE的get方法
     * @params
     * @return businessCope
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getBusinessCope(){
        return this.businessCope;
    }
    /**
     * @setBusinessCope:BUSINESS_COPE的set方法
     * @param businessCope
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setBusinessCope(String businessCope){
		this.businessCope = businessCope;
	} 
    /**
     * @getQualiCode:QUALI_CODE的get方法
     * @params
     * @return qualiCode
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getQualiCode(){
        return this.qualiCode;
    }
    /**
     * @setQualiCode:QUALI_CODE的set方法
     * @param qualiCode
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setQualiCode(String qualiCode){
		this.qualiCode = qualiCode;
	} 
    /**
     * @getQualiIndustry:QUALI_INDUSTRY的get方法
     * @params
     * @return qualiIndustry
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getQualiIndustry(){
        return this.qualiIndustry;
    }
    /**
     * @setQualiIndustry:QUALI_INDUSTRY的set方法
     * @param qualiIndustry
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setQualiIndustry(String qualiIndustry){
		this.qualiIndustry = qualiIndustry;
	} 
    /**
     * @getQualiLevel:QUALI_LEVEL的get方法
     * @params
     * @return qualiLevel
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getQualiLevel(){
        return this.qualiLevel;
    }
    /**
     * @setQualiLevel:QUALI_LEVEL的set方法
     * @param qualiLevel
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setQualiLevel(String qualiLevel){
		this.qualiLevel = qualiLevel;
	} 
    /**
     * @getCertificateCode:CERTIFICATE_CODE的get方法
     * @params
     * @return certificateCode
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getCertificateCode(){
        return this.certificateCode;
    }
    /**
     * @setCertificateCode:CERTIFICATE_CODE的set方法
     * @param certificateCode
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setCertificateCode(String certificateCode){
		this.certificateCode = certificateCode;
	} 
    /**
     * @getRegiseterTime:REGISETER_TIME的get方法
     * @params
     * @return regiseterTime
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getRegiseterTime(){
        return this.regiseterTime;
    }
    /**
     * @setRegiseterTime:REGISETER_TIME的set方法
     * @param regiseterTime
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setRegiseterTime(String regiseterTime){
		this.regiseterTime = regiseterTime;
	} 
    /**
     * @getRemark1:REMARK1的get方法
     * @params
     * @return remark1
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getRemark1(){
        return this.remark1;
    }
    /**
     * @setRemark1:REMARK1的set方法
     * @param remark1
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setRemark1(String remark1){
		this.remark1 = remark1;
	} 
    /**
     * @getRemark2:REMARK2的get方法
     * @params
     * @return remark2
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getRemark2(){
        return this.remark2;
    }
    /**
     * @setRemark2:REMARK2的set方法
     * @param remark2
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setRemark2(String remark2){
		this.remark2 = remark2;
	} 
    /**
     * @getRemark3:REMARK3的get方法
     * @params
     * @return remark3
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getRemark3(){
        return this.remark3;
    }
    /**
     * @setRemark3:REMARK3的set方法
     * @param remark3
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setRemark3(String remark3){
		this.remark3 = remark3;
	} 
    /**
     * @getRemark4:REMARK4的get方法
     * @params
     * @return remark4
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getRemark4(){
        return this.remark4;
    }
    /**
     * @setRemark4:REMARK4的set方法
     * @param remark4
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setRemark4(String remark4){
		this.remark4 = remark4;
	} 
    /**
     * @getRemark5:REMARK5的get方法
     * @params
     * @return remark5
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public String getRemark5(){
        return this.remark5;
    }
    /**
     * @setRemark5:REMARK5的set方法
     * @param remark5
     * @return
     * @date 2020-12-18 11:51:00
     * @author 18511
     */
    public void setRemark5(String remark5){
		this.remark5 = remark5;
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
		if (legalPerson == null) {
			if (other.legalPerson != null) {
				return false;
			}
		} else if (!legalPerson.equals(other.legalPerson)) {
			return false;
		}
		if (creditCode == null) {
			if (other.creditCode != null) {
				return false;
			}
		} else if (!creditCode.equals(other.creditCode)) {
			return false;
		}
		if (structureCode == null) {
			if (other.structureCode != null) {
				return false;
			}
		} else if (!structureCode.equals(other.structureCode)) {
			return false;
		}
		if (onBusinessBegin == null) {
			if (other.onBusinessBegin != null) {
				return false;
			}
		} else if (!onBusinessBegin.equals(other.onBusinessBegin)) {
			return false;
		}
		if (onBusinessEnd == null) {
			if (other.onBusinessEnd != null) {
				return false;
			}
		} else if (!onBusinessEnd.equals(other.onBusinessEnd)) {
			return false;
		}
		if (businessCope == null) {
			if (other.businessCope != null) {
				return false;
			}
		} else if (!businessCope.equals(other.businessCope)) {
			return false;
		}
		if (qualiCode == null) {
			if (other.qualiCode != null) {
				return false;
			}
		} else if (!qualiCode.equals(other.qualiCode)) {
			return false;
		}
		if (qualiIndustry == null) {
			if (other.qualiIndustry != null) {
				return false;
			}
		} else if (!qualiIndustry.equals(other.qualiIndustry)) {
			return false;
		}
		if (qualiLevel == null) {
			if (other.qualiLevel != null) {
				return false;
			}
		} else if (!qualiLevel.equals(other.qualiLevel)) {
			return false;
		}
		if (certificateCode == null) {
			if (other.certificateCode != null) {
				return false;
			}
		} else if (!certificateCode.equals(other.certificateCode)) {
			return false;
		}
		if (regiseterTime == null) {
			if (other.regiseterTime != null) {
				return false;
			}
		} else if (!regiseterTime.equals(other.regiseterTime)) {
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
		if (remark4 == null) {
			if (other.remark4 != null) {
				return false;
			}
		} else if (!remark4.equals(other.remark4)) {
			return false;
		}
		if (remark5 == null) {
			if (other.remark5 != null) {
				return false;
			}
		} else if (!remark5.equals(other.remark5)) {
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
			+ ", legalPerson=" + legalPerson
			+ ", creditCode=" + creditCode
			+ ", structureCode=" + structureCode
			+ ", onBusinessBegin=" + onBusinessBegin
			+ ", onBusinessEnd=" + onBusinessEnd
			+ ", businessCope=" + businessCope
			+ ", qualiCode=" + qualiCode
			+ ", qualiIndustry=" + qualiIndustry
			+ ", qualiLevel=" + qualiLevel
			+ ", certificateCode=" + certificateCode
			+ ", regiseterTime=" + regiseterTime
			+ ", remark1=" + remark1
			+ ", remark2=" + remark2
			+ ", remark3=" + remark3
			+ ", remark4=" + remark4
			+ ", remark5=" + remark5;
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