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
     * 属性COMPANY_ID
     */  
    @ViewAttribute(name ="companyId",caption="COMPANY_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String companyId;    
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
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /** 
     * 属性ELECTRICIAN_LEVEL
     */  
    @ViewAttribute(name ="electricianLevel",caption="ELECTRICIAN_LEVEL", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianLevel;    
    /** 
     * 属性ELECTRICIAN_STATUS
     */  
    @ViewAttribute(name ="electricianStatus",caption="ELECTRICIAN_STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianStatus;    
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
		this.companyId = companyId;
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
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("ELECTRICIAN_ID"+":"+getElectricianId())
				.append("ELECTRICIAN_NAME"+":"+getElectricianName())
				.append("ELECTRICIAN_PHONENUMBER"+":"+getElectricianPhonenumber())
				.append("COMPANY_ID"+":"+getCompanyId())
				.append("COMPANY_NAME"+":"+getCompanyName())
				.append("RATING_CERTIFICATE"+":"+getRatingCertificate())
				.append("COMPANY_CONTRACT"+":"+getCompanyContract())
				.append("ELECTRICIAN_SCORE"+":"+getElectricianScore())
				.append("REMARK"+":"+getRemark())
				.append("ELECTRICIAN_LEVEL"+":"+getElectricianLevel())
				.append("ELECTRICIAN_STATUS"+":"+getElectricianStatus())
		        .toString(); 
			
    } 
   


}
