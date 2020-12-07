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
 * ElectricianInfo的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "electrician_info")
public class ElectricianInfo implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * ELECTRICIAN_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "ELECTRICIAN_ID", nullable = false, length = 64)
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
     * ELECTRICIAN_SCORE
     */
    @Column(name = "ELECTRICIAN_SCORE", nullable = true, length = 2)
    private String electricianScore ;
    
    /** 
     * REMARK
     */
    @Column(name = "REMARK", nullable = true, length = 512)
    private String remark ;
    
    /** 
     * ELECTRICIAN_LEVEL
     */
    @Column(name = "ELECTRICIAN_LEVEL", nullable = true, length = 10)
    private String electricianLevel ;
    
    /** 
     * ELECTRICIAN_STATUS
     */
    @Column(name = "ELECTRICIAN_STATUS", nullable = true, length = 2)
    private String electricianStatus ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public ElectricianInfo(){
	
	}
    /**
     * @getElectricianId:ELECTRICIAN_ID的get方法
     * @params
     * @return electricianId
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public String getElectricianId(){
        return this.electricianId;
    }
    /**
     * @setElectricianId:ELECTRICIAN_ID的set方法
     * @param electricianId
     * @return
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public void setElectricianId(String electricianId){
        if(electricianId != null && electricianId.trim().length() == 0){
        	this.electricianId = null;
        }else{
        	this.electricianId = electricianId;
        }
	} 
    /**
     * @getElectricianName:ELECTRICIAN_NAME的get方法
     * @params
     * @return electricianName
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public String getElectricianName(){
        return this.electricianName;
    }
    /**
     * @setElectricianName:ELECTRICIAN_NAME的set方法
     * @param electricianName
     * @return
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public void setElectricianName(String electricianName){
		this.electricianName = electricianName;
	} 
    /**
     * @getElectricianPhonenumber:ELECTRICIAN_PHONENUMBER的get方法
     * @params
     * @return electricianPhonenumber
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public String getElectricianPhonenumber(){
        return this.electricianPhonenumber;
    }
    /**
     * @setElectricianPhonenumber:ELECTRICIAN_PHONENUMBER的set方法
     * @param electricianPhonenumber
     * @return
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public void setElectricianPhonenumber(String electricianPhonenumber){
		this.electricianPhonenumber = electricianPhonenumber;
	} 
    /**
     * @getCompanyId:COMPANY_ID的get方法
     * @params
     * @return companyId
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public String getCompanyId(){
        return this.companyId;
    }
    /**
     * @setCompanyId:COMPANY_ID的set方法
     * @param companyId
     * @return
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public void setCompanyId(String companyId){
		this.companyId = companyId;
	} 
    /**
     * @getCompanyName:COMPANY_NAME的get方法
     * @params
     * @return companyName
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public String getCompanyName(){
        return this.companyName;
    }
    /**
     * @setCompanyName:COMPANY_NAME的set方法
     * @param companyName
     * @return
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public void setCompanyName(String companyName){
		this.companyName = companyName;
	} 
    /**
     * @getRatingCertificate:RATING_CERTIFICATE的get方法
     * @params
     * @return ratingCertificate
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public String getRatingCertificate(){
        return this.ratingCertificate;
    }
    /**
     * @setRatingCertificate:RATING_CERTIFICATE的set方法
     * @param ratingCertificate
     * @return
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public void setRatingCertificate(String ratingCertificate){
		this.ratingCertificate = ratingCertificate;
	} 
    /**
     * @getCompanyContract:COMPANY_CONTRACT的get方法
     * @params
     * @return companyContract
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public String getCompanyContract(){
        return this.companyContract;
    }
    /**
     * @setCompanyContract:COMPANY_CONTRACT的set方法
     * @param companyContract
     * @return
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public void setCompanyContract(String companyContract){
		this.companyContract = companyContract;
	} 
    /**
     * @getElectricianScore:ELECTRICIAN_SCORE的get方法
     * @params
     * @return electricianScore
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public String getElectricianScore(){
        return this.electricianScore;
    }
    /**
     * @setElectricianScore:ELECTRICIAN_SCORE的set方法
     * @param electricianScore
     * @return
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public void setElectricianScore(String electricianScore){
		this.electricianScore = electricianScore;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 
    /**
     * @getElectricianLevel:ELECTRICIAN_LEVEL的get方法
     * @params
     * @return electricianLevel
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public String getElectricianLevel(){
        return this.electricianLevel;
    }
    /**
     * @setElectricianLevel:ELECTRICIAN_LEVEL的set方法
     * @param electricianLevel
     * @return
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public void setElectricianLevel(String electricianLevel){
		this.electricianLevel = electricianLevel;
	} 
    /**
     * @getElectricianStatus:ELECTRICIAN_STATUS的get方法
     * @params
     * @return electricianStatus
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public String getElectricianStatus(){
        return this.electricianStatus;
    }
    /**
     * @setElectricianStatus:ELECTRICIAN_STATUS的set方法
     * @param electricianStatus
     * @return
     * @date 2020-12-07 10:54:21
     * @author 18511
     */
    public void setElectricianStatus(String electricianStatus){
		this.electricianStatus = electricianStatus;
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
		
        if (obj == null || !(obj instanceof ElectricianInfo))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		ElectricianInfo other = (ElectricianInfo) obj;
		
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
		if (electricianScore == null) {
			if (other.electricianScore != null) {
				return false;
			}
		} else if (!electricianScore.equals(other.electricianScore)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		if (electricianLevel == null) {
			if (other.electricianLevel != null) {
				return false;
			}
		} else if (!electricianLevel.equals(other.electricianLevel)) {
			return false;
		}
		if (electricianStatus == null) {
			if (other.electricianStatus != null) {
				return false;
			}
		} else if (!electricianStatus.equals(other.electricianStatus)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "ElectricianInfo ["
			+ ", electricianId=" + electricianId
			+ ", electricianName=" + electricianName
			+ ", electricianPhonenumber=" + electricianPhonenumber
			+ ", companyId=" + companyId
			+ ", companyName=" + companyName
			+ ", ratingCertificate=" + ratingCertificate
			+ ", companyContract=" + companyContract
			+ ", electricianScore=" + electricianScore
			+ ", remark=" + remark
			+ ", electricianLevel=" + electricianLevel
			+ ", electricianStatus=" + electricianStatus;
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