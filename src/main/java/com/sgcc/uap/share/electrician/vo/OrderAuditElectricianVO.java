package com.sgcc.uap.share.electrician.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * OrderAuditElectrician的VO类
 *
 * @author 18511 
 */
public class OrderAuditElectricianVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ORDER_ID
     */  
    @ViewAttribute(name ="orderId",caption="ORDER_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String orderId;    
    /** 
     * 属性ORDER_TYPE
     */  
    @ViewAttribute(name ="orderType",caption="ORDER_TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String orderType;    
    /** 
     * 属性CREATE_TIME
     */  
    @ViewAttribute(name ="createTime",caption="CREATE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp createTime;    
    /** 
     * 属性UPDATE_TIME
     */  
    @ViewAttribute(name ="updateTime",caption="UPDATE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp updateTime;    
    /** 
     * 属性FINISH_TIME
     */  
    @ViewAttribute(name ="finishTime",caption="FINISH_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp finishTime;    
    /** 
     * 属性AUDITOR_ID
     */  
    @ViewAttribute(name ="auditorId",caption="AUDITOR_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String auditorId;    
    /** 
     * 属性AUDITOR_COMMENT
     */  
    @ViewAttribute(name ="auditorComment",caption="AUDITOR_COMMENT", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String auditorComment;    
    /** 
     * 属性ELECTRICIAN_ID
     */  
    @ViewAttribute(name ="electricianId",caption="ELECTRICIAN_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
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
     * OrderAuditElectricianVO构造函数
     */
    public OrderAuditElectricianVO() {
        super();
    } 
   
	 /**
     * OrderAuditElectricianVO完整的构造函数
     */  
    public OrderAuditElectricianVO(String orderId){
        this.orderId = orderId;
    }
    /**
     * ORDER_ID的get方法
     * @return orderId
     */
    public String getOrderId(){
        return orderId;
    }
    /**
     * ORDER_ID的set方法
     * @param orderId
     */
    public void setOrderId(String orderId){
        if(orderId != null && orderId.trim().length() == 0){
        	this.orderId = null;
        }else{
        	this.orderId = orderId;
        }
	} 
    /**
     * ORDER_TYPE的get方法
     * @return orderType
     */
    public String getOrderType(){
        return orderType;
    }
    /**
     * ORDER_TYPE的set方法
     * @param orderType
     */
    public void setOrderType(String orderType){
		this.orderType = orderType;
	} 
    /**
     * CREATE_TIME的get方法
     * @return createTime
     */
    public Timestamp getCreateTime(){
        return createTime;
    }
    /**
     * CREATE_TIME的set方法
     * @param createTime
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	} 
    /**
     * UPDATE_TIME的get方法
     * @return updateTime
     */
    public Timestamp getUpdateTime(){
        return updateTime;
    }
    /**
     * UPDATE_TIME的set方法
     * @param updateTime
     */
    public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * FINISH_TIME的get方法
     * @return finishTime
     */
    public Timestamp getFinishTime(){
        return finishTime;
    }
    /**
     * FINISH_TIME的set方法
     * @param finishTime
     */
    public void setFinishTime(Timestamp finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * AUDITOR_ID的get方法
     * @return auditorId
     */
    public String getAuditorId(){
        return auditorId;
    }
    /**
     * AUDITOR_ID的set方法
     * @param auditorId
     */
    public void setAuditorId(String auditorId){
		this.auditorId = auditorId;
	} 
    /**
     * AUDITOR_COMMENT的get方法
     * @return auditorComment
     */
    public String getAuditorComment(){
        return auditorComment;
    }
    /**
     * AUDITOR_COMMENT的set方法
     * @param auditorComment
     */
    public void setAuditorComment(String auditorComment){
		this.auditorComment = auditorComment;
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
		this.electricianId = electricianId;
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
	  			.append("ORDER_ID"+":"+getOrderId())
				.append("ORDER_TYPE"+":"+getOrderType())
				.append("CREATE_TIME"+":"+getCreateTime())
				.append("UPDATE_TIME"+":"+getUpdateTime())
				.append("FINISH_TIME"+":"+getFinishTime())
				.append("AUDITOR_ID"+":"+getAuditorId())
				.append("AUDITOR_COMMENT"+":"+getAuditorComment())
				.append("ELECTRICIAN_ID"+":"+getElectricianId())
				.append("ELECTRICIAN_NAME"+":"+getElectricianName())
				.append("ELECTRICIAN_PHONENUMBER"+":"+getElectricianPhonenumber())
				.append("ELECTRICIAN_LEVEL"+":"+getElectricianLevel())
				.append("SUB_COMPANY_ID"+":"+getSubCompanyId())
				.append("COMPANY_ID"+":"+getCompanyId())
				.append("COMPANY_NAME"+":"+getCompanyName())
				.append("RATING_CERTIFICATE"+":"+getRatingCertificate())
				.append("COMPANY_CONTRACT"+":"+getCompanyContract())
				.append("IDENTITY_INFO"+":"+getIdentityInfo())
				.append("ELECTRICIAN_CERTIFICATE"+":"+getElectricianCertificate())
				.append("CERTIFICATE_A"+":"+getCertificateA())
				.append("CERTIFICATE_B"+":"+getCertificateB())
				.append("CERTIFICATE_C"+":"+getCertificateC())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
