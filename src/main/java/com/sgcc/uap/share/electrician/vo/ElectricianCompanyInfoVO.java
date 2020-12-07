package com.sgcc.uap.share.electrician.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * ElectricianCompanyInfo的VO类
 *
 * @author 18511 
 */
public class ElectricianCompanyInfoVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性COMPANY_ID
     */  
    @ViewAttribute(name ="companyId",caption="COMPANY_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String companyId;    
    /** 
     * 属性COMPANY_NAME
     */  
    @ViewAttribute(name ="companyName",caption="COMPANY_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String companyName;    
    /** 
     * 属性COMPANY_PHONENUMBER
     */  
    @ViewAttribute(name ="companyPhonenumber",caption="COMPANY_PHONENUMBER", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String companyPhonenumber;    
    /** 
     * 属性COMPANY_ADDRESS
     */  
    @ViewAttribute(name ="companyAddress",caption="COMPANY_ADDRESS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String companyAddress;    
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
     * 属性COMPANY_LEVEL
     */  
    @ViewAttribute(name ="companyLevel",caption="COMPANY_LEVEL", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String companyLevel;    
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
     * 属性LEGAL_PERSON
     */  
    @ViewAttribute(name ="legalPerson",caption="LEGAL_PERSON", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String legalPerson;    
    /** 
     * 属性CREDIT_CODE
     */  
    @ViewAttribute(name ="creditCode",caption="CREDIT_CODE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String creditCode;    
    /** 
     * 属性STRUCTURE_CODE
     */  
    @ViewAttribute(name ="structureCode",caption="STRUCTURE_CODE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String structureCode;    
    /** 
     * 属性ON_BUSINESS_BEGIN
     */  
    @ViewAttribute(name ="onBusinessBegin",caption="ON_BUSINESS_BEGIN", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp onBusinessBegin;    
    /** 
     * 属性ON_BUSINESS_END
     */  
    @ViewAttribute(name ="onBusinessEnd",caption="ON_BUSINESS_END", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp onBusinessEnd;    
    /** 
     * 属性BUSINESS_COPE
     */  
    @ViewAttribute(name ="businessCope",caption="BUSINESS_COPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String businessCope;    
    /** 
     * 属性QUALI_CODE
     */  
    @ViewAttribute(name ="qualiCode",caption="QUALI_CODE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String qualiCode;    
    /** 
     * 属性QUALI_INDUSTRY
     */  
    @ViewAttribute(name ="qualiIndustry",caption="QUALI_INDUSTRY", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String qualiIndustry;    
    /** 
     * 属性QUALI_LEVEL
     */  
    @ViewAttribute(name ="qualiLevel",caption="QUALI_LEVEL", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String qualiLevel;    
    /** 
     * 属性CERTIFICATE_CODE
     */  
    @ViewAttribute(name ="certificateCode",caption="CERTIFICATE_CODE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String certificateCode;    
    /** 
     * 属性REGISETER_TIME
     */  
    @ViewAttribute(name ="regiseterTime",caption="REGISETER_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp regiseterTime;    
    /** 
     * 属性REMARK1
     */  
    @ViewAttribute(name ="remark1",caption="REMARK1", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark1;    
    /** 
     * 属性REMARK2
     */  
    @ViewAttribute(name ="remark2",caption="REMARK2", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark2;    
    /** 
     * 属性REMARK3
     */  
    @ViewAttribute(name ="remark3",caption="REMARK3", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark3;    
    /** 
     * 属性REMARK4
     */  
    @ViewAttribute(name ="remark4",caption="REMARK4", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark4;    
    /** 
     * 属性REMARK5
     */  
    @ViewAttribute(name ="remark5",caption="REMARK5", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark5;    
    /**
     * ElectricianCompanyInfoVO构造函数
     */
    public ElectricianCompanyInfoVO() {
        super();
    } 
   
	 /**
     * ElectricianCompanyInfoVO完整的构造函数
     */  
    public ElectricianCompanyInfoVO(String companyId){
        this.companyId = companyId;
    }
    /**
     * COMPANY_ID的get方法
     * @return companyId
     */
    public String getCompanyId(){
        return companyId;
    }
    /**
     * COMPANY_ID的set方法
     * @param companyId
     */
    public void setCompanyId(String companyId){
        if(companyId != null && companyId.trim().length() == 0){
        	this.companyId = null;
        }else{
        	this.companyId = companyId;
        }
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
     * COMPANY_PHONENUMBER的get方法
     * @return companyPhonenumber
     */
    public String getCompanyPhonenumber(){
        return companyPhonenumber;
    }
    /**
     * COMPANY_PHONENUMBER的set方法
     * @param companyPhonenumber
     */
    public void setCompanyPhonenumber(String companyPhonenumber){
		this.companyPhonenumber = companyPhonenumber;
	} 
    /**
     * COMPANY_ADDRESS的get方法
     * @return companyAddress
     */
    public String getCompanyAddress(){
        return companyAddress;
    }
    /**
     * COMPANY_ADDRESS的set方法
     * @param companyAddress
     */
    public void setCompanyAddress(String companyAddress){
		this.companyAddress = companyAddress;
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
     * COMPANY_LEVEL的get方法
     * @return companyLevel
     */
    public String getCompanyLevel(){
        return companyLevel;
    }
    /**
     * COMPANY_LEVEL的set方法
     * @param companyLevel
     */
    public void setCompanyLevel(String companyLevel){
		this.companyLevel = companyLevel;
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
     * LEGAL_PERSON的get方法
     * @return legalPerson
     */
    public String getLegalPerson(){
        return legalPerson;
    }
    /**
     * LEGAL_PERSON的set方法
     * @param legalPerson
     */
    public void setLegalPerson(String legalPerson){
		this.legalPerson = legalPerson;
	} 
    /**
     * CREDIT_CODE的get方法
     * @return creditCode
     */
    public String getCreditCode(){
        return creditCode;
    }
    /**
     * CREDIT_CODE的set方法
     * @param creditCode
     */
    public void setCreditCode(String creditCode){
		this.creditCode = creditCode;
	} 
    /**
     * STRUCTURE_CODE的get方法
     * @return structureCode
     */
    public String getStructureCode(){
        return structureCode;
    }
    /**
     * STRUCTURE_CODE的set方法
     * @param structureCode
     */
    public void setStructureCode(String structureCode){
		this.structureCode = structureCode;
	} 
    /**
     * ON_BUSINESS_BEGIN的get方法
     * @return onBusinessBegin
     */
    public Timestamp getOnBusinessBegin(){
        return onBusinessBegin;
    }
    /**
     * ON_BUSINESS_BEGIN的set方法
     * @param onBusinessBegin
     */
    public void setOnBusinessBegin(Timestamp onBusinessBegin){
		this.onBusinessBegin = onBusinessBegin;
	} 
    /**
     * ON_BUSINESS_END的get方法
     * @return onBusinessEnd
     */
    public Timestamp getOnBusinessEnd(){
        return onBusinessEnd;
    }
    /**
     * ON_BUSINESS_END的set方法
     * @param onBusinessEnd
     */
    public void setOnBusinessEnd(Timestamp onBusinessEnd){
		this.onBusinessEnd = onBusinessEnd;
	} 
    /**
     * BUSINESS_COPE的get方法
     * @return businessCope
     */
    public String getBusinessCope(){
        return businessCope;
    }
    /**
     * BUSINESS_COPE的set方法
     * @param businessCope
     */
    public void setBusinessCope(String businessCope){
		this.businessCope = businessCope;
	} 
    /**
     * QUALI_CODE的get方法
     * @return qualiCode
     */
    public String getQualiCode(){
        return qualiCode;
    }
    /**
     * QUALI_CODE的set方法
     * @param qualiCode
     */
    public void setQualiCode(String qualiCode){
		this.qualiCode = qualiCode;
	} 
    /**
     * QUALI_INDUSTRY的get方法
     * @return qualiIndustry
     */
    public String getQualiIndustry(){
        return qualiIndustry;
    }
    /**
     * QUALI_INDUSTRY的set方法
     * @param qualiIndustry
     */
    public void setQualiIndustry(String qualiIndustry){
		this.qualiIndustry = qualiIndustry;
	} 
    /**
     * QUALI_LEVEL的get方法
     * @return qualiLevel
     */
    public String getQualiLevel(){
        return qualiLevel;
    }
    /**
     * QUALI_LEVEL的set方法
     * @param qualiLevel
     */
    public void setQualiLevel(String qualiLevel){
		this.qualiLevel = qualiLevel;
	} 
    /**
     * CERTIFICATE_CODE的get方法
     * @return certificateCode
     */
    public String getCertificateCode(){
        return certificateCode;
    }
    /**
     * CERTIFICATE_CODE的set方法
     * @param certificateCode
     */
    public void setCertificateCode(String certificateCode){
		this.certificateCode = certificateCode;
	} 
    /**
     * REGISETER_TIME的get方法
     * @return regiseterTime
     */
    public Timestamp getRegiseterTime(){
        return regiseterTime;
    }
    /**
     * REGISETER_TIME的set方法
     * @param regiseterTime
     */
    public void setRegiseterTime(Timestamp regiseterTime){
		this.regiseterTime = regiseterTime;
	} 
    /**
     * REMARK1的get方法
     * @return remark1
     */
    public String getRemark1(){
        return remark1;
    }
    /**
     * REMARK1的set方法
     * @param remark1
     */
    public void setRemark1(String remark1){
		this.remark1 = remark1;
	} 
    /**
     * REMARK2的get方法
     * @return remark2
     */
    public String getRemark2(){
        return remark2;
    }
    /**
     * REMARK2的set方法
     * @param remark2
     */
    public void setRemark2(String remark2){
		this.remark2 = remark2;
	} 
    /**
     * REMARK3的get方法
     * @return remark3
     */
    public String getRemark3(){
        return remark3;
    }
    /**
     * REMARK3的set方法
     * @param remark3
     */
    public void setRemark3(String remark3){
		this.remark3 = remark3;
	} 
    /**
     * REMARK4的get方法
     * @return remark4
     */
    public String getRemark4(){
        return remark4;
    }
    /**
     * REMARK4的set方法
     * @param remark4
     */
    public void setRemark4(String remark4){
		this.remark4 = remark4;
	} 
    /**
     * REMARK5的get方法
     * @return remark5
     */
    public String getRemark5(){
        return remark5;
    }
    /**
     * REMARK5的set方法
     * @param remark5
     */
    public void setRemark5(String remark5){
		this.remark5 = remark5;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("COMPANY_ID"+":"+getCompanyId())
				.append("COMPANY_NAME"+":"+getCompanyName())
				.append("COMPANY_PHONENUMBER"+":"+getCompanyPhonenumber())
				.append("COMPANY_ADDRESS"+":"+getCompanyAddress())
				.append("ADDRESS_LONGITUDE"+":"+getAddressLongitude())
				.append("ADDRESS_LATITUDE"+":"+getAddressLatitude())
				.append("COMPANY_LEVEL"+":"+getCompanyLevel())
				.append("RATING_CERTIFICATE"+":"+getRatingCertificate())
				.append("COMPANY_CONTRACT"+":"+getCompanyContract())
				.append("LEGAL_PERSON"+":"+getLegalPerson())
				.append("CREDIT_CODE"+":"+getCreditCode())
				.append("STRUCTURE_CODE"+":"+getStructureCode())
				.append("ON_BUSINESS_BEGIN"+":"+getOnBusinessBegin())
				.append("ON_BUSINESS_END"+":"+getOnBusinessEnd())
				.append("BUSINESS_COPE"+":"+getBusinessCope())
				.append("QUALI_CODE"+":"+getQualiCode())
				.append("QUALI_INDUSTRY"+":"+getQualiIndustry())
				.append("QUALI_LEVEL"+":"+getQualiLevel())
				.append("CERTIFICATE_CODE"+":"+getCertificateCode())
				.append("REGISETER_TIME"+":"+getRegiseterTime())
				.append("REMARK1"+":"+getRemark1())
				.append("REMARK2"+":"+getRemark2())
				.append("REMARK3"+":"+getRemark3())
				.append("REMARK4"+":"+getRemark4())
				.append("REMARK5"+":"+getRemark5())
		        .toString(); 
			
    } 
   


}
