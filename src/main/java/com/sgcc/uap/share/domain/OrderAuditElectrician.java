package com.sgcc.uap.share.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


/**
 * OrderAuditElectrician的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "order_audit_electrician")
public class OrderAuditElectrician implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * ORDER_ID
     */
	@Id
	/*@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")*/
    @Column(name = "ORDER_ID", nullable = false, length = 64)
    private String orderId ;
    
    /** 
     * ORDER_TYPE
     */
    @Column(name = "ORDER_TYPE", nullable = true, length = 2)
    private String orderType ;
    
    /** 
     * CREATE_TIME
     */
    @Column(name = "CREATE_TIME", nullable = true, length = 19)
    private String createTime ;
    
    /** 
     * UPDATE_TIME
     */
    @Column(name = "UPDATE_TIME", nullable = true, length = 19)
    private String updateTime ;
    
    /** 
     * FINISH_TIME
     */
    @Column(name = "FINISH_TIME", nullable = true, length = 19)
    private String finishTime ;
    
    /** 
     * AUDITOR_ID
     */
    @Column(name = "AUDITOR_ID", nullable = true, length = 64)
    private String auditorId ;
    
    /** 
     * AUDITOR_COMMENT
     */
    @Column(name = "AUDITOR_COMMENT", nullable = true, length = 512)
    private String auditorComment ;
    
    /** 
     * ELECTRICIAN_ID
     */
    @Column(name = "ELECTRICIAN_ID", nullable = true, length = 64)
    private String electricianId ;
    
    /** 
     * ELECTRICIAN_NAME
     */
    @Column(name = "ELECTRICIAN_NAME", nullable = true, length = 32)
    private String electricianName ;
    
    /** 
     * ELECTRICIAN_PHONENUMBER
     */
    @Column(name = "ELECTRICIAN_PHONENUMBER", nullable = true, length = 32)
    private String electricianPhonenumber ;
    
    /** 
     * ELECTRICIAN_LEVEL
     */
    @Column(name = "ELECTRICIAN_LEVEL", nullable = true, length = 32)
    private String electricianLevel ;
    
    /** 
     * SUB_COMPANY_ID
     */
    @Column(name = "SUB_COMPANY_ID", nullable = true, length = 64)
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
     * IDENTITY_INFO
     */
    @Column(name = "IDENTITY_INFO", nullable = true, length = 512)
    private String identityInfo ;
    
    /** 
     * ELECTRICIAN_CERTIFICATE
     */
    @Column(name = "ELECTRICIAN_CERTIFICATE", nullable = true, length = 512)
    private String electricianCertificate ;
    
    /** 
     * CERTIFICATE_A
     */
    @Column(name = "CERTIFICATE_A", nullable = true, length = 512)
    private String certificateA ;
    
    /** 
     * CERTIFICATE_B
     */
    @Column(name = "CERTIFICATE_B", nullable = true, length = 512)
    private String certificateB ;
    
    /** 
     * CERTIFICATE_C
     */
    @Column(name = "CERTIFICATE_C", nullable = true, length = 512)
    private String certificateC ;
    
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
	
	public OrderAuditElectrician(){
	
	}
    /**
     * @getOrderId:ORDER_ID的get方法
     * @params
     * @return orderId
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getOrderId(){
        return this.orderId;
    }
    /**
     * @setOrderId:ORDER_ID的set方法
     * @param orderId
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setOrderId(String orderId){
        if(orderId != null && orderId.trim().length() == 0){
        	this.orderId = null;
        }else{
        	this.orderId = orderId;
        }
	} 
    /**
     * @getOrderType:ORDER_TYPE的get方法
     * @params
     * @return orderType
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getOrderType(){
        return this.orderType;
    }
    /**
     * @setOrderType:ORDER_TYPE的set方法
     * @param orderType
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setOrderType(String orderType){
		this.orderType = orderType;
	} 
    /**
     * @getCreateTime:CREATE_TIME的get方法
     * @params
     * @return createTime
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:CREATE_TIME的set方法
     * @param createTime
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setCreateTime(String createTime){
		this.createTime = createTime;
	} 
    /**
     * @getUpdateTime:UPDATE_TIME的get方法
     * @params
     * @return updateTime
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getUpdateTime(){
        return this.updateTime;
    }
    /**
     * @setUpdateTime:UPDATE_TIME的set方法
     * @param updateTime
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * @getFinishTime:FINISH_TIME的get方法
     * @params
     * @return finishTime
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getFinishTime(){
        return this.finishTime;
    }
    /**
     * @setFinishTime:FINISH_TIME的set方法
     * @param finishTime
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setFinishTime(String finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * @getAuditorId:AUDITOR_ID的get方法
     * @params
     * @return auditorId
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getAuditorId(){
        return this.auditorId;
    }
    /**
     * @setAuditorId:AUDITOR_ID的set方法
     * @param auditorId
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setAuditorId(String auditorId){
		this.auditorId = auditorId;
	} 
    /**
     * @getAuditorComment:AUDITOR_COMMENT的get方法
     * @params
     * @return auditorComment
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getAuditorComment(){
        return this.auditorComment;
    }
    /**
     * @setAuditorComment:AUDITOR_COMMENT的set方法
     * @param auditorComment
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setAuditorComment(String auditorComment){
		this.auditorComment = auditorComment;
	} 
    /**
     * @getElectricianId:ELECTRICIAN_ID的get方法
     * @params
     * @return electricianId
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getElectricianId(){
        return this.electricianId;
    }
    /**
     * @setElectricianId:ELECTRICIAN_ID的set方法
     * @param electricianId
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setElectricianId(String electricianId){
		this.electricianId = electricianId;
	} 
    /**
     * @getElectricianName:ELECTRICIAN_NAME的get方法
     * @params
     * @return electricianName
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getElectricianName(){
        return this.electricianName;
    }
    /**
     * @setElectricianName:ELECTRICIAN_NAME的set方法
     * @param electricianName
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setElectricianName(String electricianName){
		this.electricianName = electricianName;
	} 
    /**
     * @getElectricianPhonenumber:ELECTRICIAN_PHONENUMBER的get方法
     * @params
     * @return electricianPhonenumber
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getElectricianPhonenumber(){
        return this.electricianPhonenumber;
    }
    /**
     * @setElectricianPhonenumber:ELECTRICIAN_PHONENUMBER的set方法
     * @param electricianPhonenumber
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setElectricianPhonenumber(String electricianPhonenumber){
		this.electricianPhonenumber = electricianPhonenumber;
	} 
    /**
     * @getElectricianLevel:ELECTRICIAN_LEVEL的get方法
     * @params
     * @return electricianLevel
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getElectricianLevel(){
        return this.electricianLevel;
    }
    /**
     * @setElectricianLevel:ELECTRICIAN_LEVEL的set方法
     * @param electricianLevel
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setElectricianLevel(String electricianLevel){
		this.electricianLevel = electricianLevel;
	} 
    /**
     * @getSubCompanyId:SUB_COMPANY_ID的get方法
     * @params
     * @return subCompanyId
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getSubCompanyId(){
        return this.subCompanyId;
    }
    /**
     * @setSubCompanyId:SUB_COMPANY_ID的set方法
     * @param subCompanyId
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setSubCompanyId(String subCompanyId){
		this.subCompanyId = subCompanyId;
	} 
    /**
     * @getCompanyId:COMPANY_ID的get方法
     * @params
     * @return companyId
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getCompanyId(){
        return this.companyId;
    }
    /**
     * @setCompanyId:COMPANY_ID的set方法
     * @param companyId
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setCompanyId(String companyId){
		this.companyId = companyId;
	} 
    /**
     * @getCompanyName:COMPANY_NAME的get方法
     * @params
     * @return companyName
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getCompanyName(){
        return this.companyName;
    }
    /**
     * @setCompanyName:COMPANY_NAME的set方法
     * @param companyName
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setCompanyName(String companyName){
		this.companyName = companyName;
	} 
    /**
     * @getRatingCertificate:RATING_CERTIFICATE的get方法
     * @params
     * @return ratingCertificate
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getRatingCertificate(){
        return this.ratingCertificate;
    }
    /**
     * @setRatingCertificate:RATING_CERTIFICATE的set方法
     * @param ratingCertificate
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setRatingCertificate(String ratingCertificate){
		this.ratingCertificate = ratingCertificate;
	} 
    /**
     * @getCompanyContract:COMPANY_CONTRACT的get方法
     * @params
     * @return companyContract
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getCompanyContract(){
        return this.companyContract;
    }
    /**
     * @setCompanyContract:COMPANY_CONTRACT的set方法
     * @param companyContract
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setCompanyContract(String companyContract){
		this.companyContract = companyContract;
	} 
    /**
     * @getIdentityInfo:IDENTITY_INFO的get方法
     * @params
     * @return identityInfo
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getIdentityInfo(){
        return this.identityInfo;
    }
    /**
     * @setIdentityInfo:IDENTITY_INFO的set方法
     * @param identityInfo
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setIdentityInfo(String identityInfo){
		this.identityInfo = identityInfo;
	} 
    /**
     * @getElectricianCertificate:ELECTRICIAN_CERTIFICATE的get方法
     * @params
     * @return electricianCertificate
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getElectricianCertificate(){
        return this.electricianCertificate;
    }
    /**
     * @setElectricianCertificate:ELECTRICIAN_CERTIFICATE的set方法
     * @param electricianCertificate
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setElectricianCertificate(String electricianCertificate){
		this.electricianCertificate = electricianCertificate;
	} 
    /**
     * @getCertificateA:CERTIFICATE_A的get方法
     * @params
     * @return certificateA
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getCertificateA(){
        return this.certificateA;
    }
    /**
     * @setCertificateA:CERTIFICATE_A的set方法
     * @param certificateA
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setCertificateA(String certificateA){
		this.certificateA = certificateA;
	} 
    /**
     * @getCertificateB:CERTIFICATE_B的get方法
     * @params
     * @return certificateB
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getCertificateB(){
        return this.certificateB;
    }
    /**
     * @setCertificateB:CERTIFICATE_B的set方法
     * @param certificateB
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setCertificateB(String certificateB){
		this.certificateB = certificateB;
	} 
    /**
     * @getCertificateC:CERTIFICATE_C的get方法
     * @params
     * @return certificateC
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getCertificateC(){
        return this.certificateC;
    }
    /**
     * @setCertificateC:CERTIFICATE_C的set方法
     * @param certificateC
     * @return
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public void setCertificateC(String certificateC){
		this.certificateC = certificateC;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-12-18 15:20:05
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-12-18 15:20:05
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
		
        if (obj == null || !(obj instanceof OrderAuditElectrician))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		OrderAuditElectrician other = (OrderAuditElectrician) obj;
		
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (orderType == null) {
			if (other.orderType != null) {
				return false;
			}
		} else if (!orderType.equals(other.orderType)) {
			return false;
		}
		if (createTime == null) {
			if (other.createTime != null) {
				return false;
			}
		} else if (!createTime.equals(other.createTime)) {
			return false;
		}
		if (updateTime == null) {
			if (other.updateTime != null) {
				return false;
			}
		} else if (!updateTime.equals(other.updateTime)) {
			return false;
		}
		if (finishTime == null) {
			if (other.finishTime != null) {
				return false;
			}
		} else if (!finishTime.equals(other.finishTime)) {
			return false;
		}
		if (auditorId == null) {
			if (other.auditorId != null) {
				return false;
			}
		} else if (!auditorId.equals(other.auditorId)) {
			return false;
		}
		if (auditorComment == null) {
			if (other.auditorComment != null) {
				return false;
			}
		} else if (!auditorComment.equals(other.auditorComment)) {
			return false;
		}
		if (electricianId == null) {
			if (other.electricianId != null) {
				return false;
			}
		} else if (!electricianId.equals(other.electricianId)) {
			return false;
		}
		if (electricianName == null) {
			if (other.electricianName != null) {
				return false;
			}
		} else if (!electricianName.equals(other.electricianName)) {
			return false;
		}
		if (electricianPhonenumber == null) {
			if (other.electricianPhonenumber != null) {
				return false;
			}
		} else if (!electricianPhonenumber.equals(other.electricianPhonenumber)) {
			return false;
		}
		if (electricianLevel == null) {
			if (other.electricianLevel != null) {
				return false;
			}
		} else if (!electricianLevel.equals(other.electricianLevel)) {
			return false;
		}
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
		if (identityInfo == null) {
			if (other.identityInfo != null) {
				return false;
			}
		} else if (!identityInfo.equals(other.identityInfo)) {
			return false;
		}
		if (electricianCertificate == null) {
			if (other.electricianCertificate != null) {
				return false;
			}
		} else if (!electricianCertificate.equals(other.electricianCertificate)) {
			return false;
		}
		if (certificateA == null) {
			if (other.certificateA != null) {
				return false;
			}
		} else if (!certificateA.equals(other.certificateA)) {
			return false;
		}
		if (certificateB == null) {
			if (other.certificateB != null) {
				return false;
			}
		} else if (!certificateB.equals(other.certificateB)) {
			return false;
		}
		if (certificateC == null) {
			if (other.certificateC != null) {
				return false;
			}
		} else if (!certificateC.equals(other.certificateC)) {
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
		return "OrderAuditElectrician ["
			+ ", orderId=" + orderId
			+ ", orderType=" + orderType
			+ ", createTime=" + createTime
			+ ", updateTime=" + updateTime
			+ ", finishTime=" + finishTime
			+ ", auditorId=" + auditorId
			+ ", auditorComment=" + auditorComment
			+ ", electricianId=" + electricianId
			+ ", electricianName=" + electricianName
			+ ", electricianPhonenumber=" + electricianPhonenumber
			+ ", electricianLevel=" + electricianLevel
			+ ", subCompanyId=" + subCompanyId
			+ ", companyId=" + companyId
			+ ", companyName=" + companyName
			+ ", ratingCertificate=" + ratingCertificate
			+ ", companyContract=" + companyContract
			+ ", identityInfo=" + identityInfo
			+ ", electricianCertificate=" + electricianCertificate
			+ ", certificateA=" + certificateA
			+ ", certificateB=" + certificateB
			+ ", certificateC=" + certificateC
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