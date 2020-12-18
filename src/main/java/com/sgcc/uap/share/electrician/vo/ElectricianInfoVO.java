package com.sgcc.uap.share.electrician.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * ElectricianInfo的VO类
 *
 * @author 18511 
 */
public class ElectricianInfoVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ELECTRICIAN_ID
     */  
    @ViewAttribute(name ="electricianId",caption="ELECTRICIAN_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String electricianId;    
    /** 
     * 属性ELECTRICIAN_NAME
     */  
    @ViewAttribute(name ="electricianName",caption="ELECTRICIAN_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianName;    
    /** 
     * 属性ELECTRICIAN_PHONENUMBER
     */  
    @ViewAttribute(name ="electricianPhonenumber",caption="ELECTRICIAN_PHONENUMBER", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianPhonenumber;    
    /** 
     * 属性ELECTRICIAN_STATUS
     */  
    @ViewAttribute(name ="electricianStatus",caption="ELECTRICIAN_STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianStatus;    
    /** 
     * 属性ADDRESS_LONGITUDE
     */  
    @ViewAttribute(name ="addressLongitude",caption="ADDRESS_LONGITUDE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String addressLongitude;    
    /** 
     * 属性ADDRESS_LATITUDE
     */  
    @ViewAttribute(name ="addressLatitude",caption="ADDRESS_LATITUDE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String addressLatitude;    
    /** 
     * 属性ELECTRICIAN_LEVEL
     */  
    @ViewAttribute(name ="electricianLevel",caption="ELECTRICIAN_LEVEL", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianLevel;    
    /** 
     * 属性SUB_COMPANY_ID
     */  
    @ViewAttribute(name ="subCompanyId",caption="SUB_COMPANY_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String subCompanyId;    
    /** 
     * 属性COMPANY_NAME
     */  
    @ViewAttribute(name ="companyName",caption="COMPANY_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String companyName;    
    /** 
     * 属性RATING_CERTIFICATE
     */  
    @ViewAttribute(name ="ratingCertificate",caption="RATING_CERTIFICATE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String ratingCertificate;    
    /** 
     * 属性COMPANY_CONTRACT
     */  
    @ViewAttribute(name ="companyContract",caption="COMPANY_CONTRACT", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String companyContract;    
    /** 
     * 属性ELECTRICIAN_SCORE
     */  
    @ViewAttribute(name ="electricianScore",caption="ELECTRICIAN_SCORE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianScore;    
    /** 
     * 属性IDENTITY_INFO
     */  
    @ViewAttribute(name ="identityInfo",caption="IDENTITY_INFO", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String identityInfo;    
    /** 
     * 属性ELECTRICIAN_CERTIFICATE
     */  
    @ViewAttribute(name ="electricianCertificate",caption="ELECTRICIAN_CERTIFICATE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianCertificate;    
    /** 
     * 属性REAL_NAME_AUTH
     */  
    @ViewAttribute(name ="realNameAuth",caption="REAL_NAME_AUTH", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String realNameAuth;    
    /** 
     * 属性CERTIFICATE_A
     */  
    @ViewAttribute(name ="certificateA",caption="CERTIFICATE_A", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String certificateA;    
    /** 
     * 属性CERTIFICATE_B
     */  
    @ViewAttribute(name ="certificateB",caption="CERTIFICATE_B", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String certificateB;    
    /** 
     * 属性CERTIFICATE_C
     */  
    @ViewAttribute(name ="certificateC",caption="CERTIFICATE_C", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String certificateC;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * ElectricianInfoVO构造函数
     */
    public ElectricianInfoVO() {
        super();
    } 
   
	 /**
     * ElectricianInfoVO完整的构造函数
     */  
    public ElectricianInfoVO(String electricianId){
        this.electricianId = electricianId;
    }
    /**
     * ELECTRICIAN_ID的get方法
     * @return electricianId
     */
    public String getElectricianId(){
        return electricianId;
    }
    /**
     * ELECTRICIAN_ID的set方法
     * @param electricianId
     */
    public void setElectricianId(String electricianId){
        if(electricianId != null && electricianId.trim().length() == 0){
        	this.electricianId = null;
        }else{
        	this.electricianId = electricianId;
        }
	} 
    /**
     * ELECTRICIAN_NAME的get方法
     * @return electricianName
     */
    public String getElectricianName(){
        return electricianName;
    }
    /**
     * ELECTRICIAN_NAME的set方法
     * @param electricianName
     */
    public void setElectricianName(String electricianName){
		this.electricianName = electricianName;
	} 
    /**
     * ELECTRICIAN_PHONENUMBER的get方法
     * @return electricianPhonenumber
     */
    public String getElectricianPhonenumber(){
        return electricianPhonenumber;
    }
    /**
     * ELECTRICIAN_PHONENUMBER的set方法
     * @param electricianPhonenumber
     */
    public void setElectricianPhonenumber(String electricianPhonenumber){
		this.electricianPhonenumber = electricianPhonenumber;
	} 
    /**
     * ELECTRICIAN_STATUS的get方法
     * @return electricianStatus
     */
    public String getElectricianStatus(){
        return electricianStatus;
    }
    /**
     * ELECTRICIAN_STATUS的set方法
     * @param electricianStatus
     */
    public void setElectricianStatus(String electricianStatus){
		this.electricianStatus = electricianStatus;
	} 
    /**
     * ADDRESS_LONGITUDE的get方法
     * @return addressLongitude
     */
    public String getAddressLongitude(){
        return addressLongitude;
    }
    /**
     * ADDRESS_LONGITUDE的set方法
     * @param addressLongitude
     */
    public void setAddressLongitude(String addressLongitude){
		this.addressLongitude = addressLongitude;
	} 
    /**
     * ADDRESS_LATITUDE的get方法
     * @return addressLatitude
     */
    public String getAddressLatitude(){
        return addressLatitude;
    }
    /**
     * ADDRESS_LATITUDE的set方法
     * @param addressLatitude
     */
    public void setAddressLatitude(String addressLatitude){
		this.addressLatitude = addressLatitude;
	} 
    /**
     * ELECTRICIAN_LEVEL的get方法
     * @return electricianLevel
     */
    public String getElectricianLevel(){
        return electricianLevel;
    }
    /**
     * ELECTRICIAN_LEVEL的set方法
     * @param electricianLevel
     */
    public void setElectricianLevel(String electricianLevel){
		this.electricianLevel = electricianLevel;
	} 
    /**
     * SUB_COMPANY_ID的get方法
     * @return subCompanyId
     */
    public String getSubCompanyId(){
        return subCompanyId;
    }
    /**
     * SUB_COMPANY_ID的set方法
     * @param subCompanyId
     */
    public void setSubCompanyId(String subCompanyId){
		this.subCompanyId = subCompanyId;
	} 
    /**
     * COMPANY_NAME的get方法
     * @return companyName
     */
    public String getCompanyName(){
        return companyName;
    }
    /**
     * COMPANY_NAME的set方法
     * @param companyName
     */
    public void setCompanyName(String companyName){
		this.companyName = companyName;
	} 
    /**
     * RATING_CERTIFICATE的get方法
     * @return ratingCertificate
     */
    public String getRatingCertificate(){
        return ratingCertificate;
    }
    /**
     * RATING_CERTIFICATE的set方法
     * @param ratingCertificate
     */
    public void setRatingCertificate(String ratingCertificate){
		this.ratingCertificate = ratingCertificate;
	} 
    /**
     * COMPANY_CONTRACT的get方法
     * @return companyContract
     */
    public String getCompanyContract(){
        return companyContract;
    }
    /**
     * COMPANY_CONTRACT的set方法
     * @param companyContract
     */
    public void setCompanyContract(String companyContract){
		this.companyContract = companyContract;
	} 
    /**
     * ELECTRICIAN_SCORE的get方法
     * @return electricianScore
     */
    public String getElectricianScore(){
        return electricianScore;
    }
    /**
     * ELECTRICIAN_SCORE的set方法
     * @param electricianScore
     */
    public void setElectricianScore(String electricianScore){
		this.electricianScore = electricianScore;
	} 
    /**
     * IDENTITY_INFO的get方法
     * @return identityInfo
     */
    public String getIdentityInfo(){
        return identityInfo;
    }
    /**
     * IDENTITY_INFO的set方法
     * @param identityInfo
     */
    public void setIdentityInfo(String identityInfo){
		this.identityInfo = identityInfo;
	} 
    /**
     * ELECTRICIAN_CERTIFICATE的get方法
     * @return electricianCertificate
     */
    public String getElectricianCertificate(){
        return electricianCertificate;
    }
    /**
     * ELECTRICIAN_CERTIFICATE的set方法
     * @param electricianCertificate
     */
    public void setElectricianCertificate(String electricianCertificate){
		this.electricianCertificate = electricianCertificate;
	} 
    /**
     * REAL_NAME_AUTH的get方法
     * @return realNameAuth
     */
    public String getRealNameAuth(){
        return realNameAuth;
    }
    /**
     * REAL_NAME_AUTH的set方法
     * @param realNameAuth
     */
    public void setRealNameAuth(String realNameAuth){
		this.realNameAuth = realNameAuth;
	} 
    /**
     * CERTIFICATE_A的get方法
     * @return certificateA
     */
    public String getCertificateA(){
        return certificateA;
    }
    /**
     * CERTIFICATE_A的set方法
     * @param certificateA
     */
    public void setCertificateA(String certificateA){
		this.certificateA = certificateA;
	} 
    /**
     * CERTIFICATE_B的get方法
     * @return certificateB
     */
    public String getCertificateB(){
        return certificateB;
    }
    /**
     * CERTIFICATE_B的set方法
     * @param certificateB
     */
    public void setCertificateB(String certificateB){
		this.certificateB = certificateB;
	} 
    /**
     * CERTIFICATE_C的get方法
     * @return certificateC
     */
    public String getCertificateC(){
        return certificateC;
    }
    /**
     * CERTIFICATE_C的set方法
     * @param certificateC
     */
    public void setCertificateC(String certificateC){
		this.certificateC = certificateC;
	} 
    /**
     * REMARK的get方法
     * @return remark
     */
    public String getRemark(){
        return remark;
    }
    /**
     * REMARK的set方法
     * @param remark
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("ELECTRICIAN_ID"+":"+getElectricianId())
				.append("ELECTRICIAN_NAME"+":"+getElectricianName())
				.append("ELECTRICIAN_PHONENUMBER"+":"+getElectricianPhonenumber())
				.append("ELECTRICIAN_STATUS"+":"+getElectricianStatus())
				.append("ADDRESS_LONGITUDE"+":"+getAddressLongitude())
				.append("ADDRESS_LATITUDE"+":"+getAddressLatitude())
				.append("ELECTRICIAN_LEVEL"+":"+getElectricianLevel())
				.append("SUB_COMPANY_ID"+":"+getSubCompanyId())
				.append("COMPANY_NAME"+":"+getCompanyName())
				.append("RATING_CERTIFICATE"+":"+getRatingCertificate())
				.append("COMPANY_CONTRACT"+":"+getCompanyContract())
				.append("ELECTRICIAN_SCORE"+":"+getElectricianScore())
				.append("IDENTITY_INFO"+":"+getIdentityInfo())
				.append("ELECTRICIAN_CERTIFICATE"+":"+getElectricianCertificate())
				.append("REAL_NAME_AUTH"+":"+getRealNameAuth())
				.append("CERTIFICATE_A"+":"+getCertificateA())
				.append("CERTIFICATE_B"+":"+getCertificateB())
				.append("CERTIFICATE_C"+":"+getCertificateC())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
