package com.sgcc.uap.share.vo;

import java.io.Serializable;


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
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
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
	  			.append("COMPANY_ID"+":"+getCompanyId())
				.append("COMPANY_NAME"+":"+getCompanyName())
				.append("COMPANY_PHONENUMBER"+":"+getCompanyPhonenumber())
				.append("COMPANY_ADDRESS"+":"+getCompanyAddress())
				.append("ADDRESS_LONGITUDE"+":"+getAddressLongitude())
				.append("ADDRESS_LATITUDE"+":"+getAddressLatitude())
				.append("COMPANY_LEVEL"+":"+getCompanyLevel())
				.append("RATING_CERTIFICATE"+":"+getRatingCertificate())
				.append("COMPANY_CONTRACT"+":"+getCompanyContract())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
