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
 * ElecErrorCount的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "elec_error_count")
public class ElecErrorCount implements Serializable {

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
     * EVALUATE_COUNT
     */
    @Column(name = "EVALUATE_COUNT", nullable = true, length = 4)
    private String evaluateCount ;
    
    /** 
     * COMPLAINT_COUNT
     */
    @Column(name = "COMPLAINT_COUNT", nullable = true, length = 4)
    private String complaintCount ;
    
    /** 
     * ERROR_FLAG
     */
    @Column(name = "ERROR_FLAG", nullable = true, length = 4)
    private String errorFlag ;
    
    /** 
     * FORBID_DAY
     */
    @Column(name = "FORBID_DAY", nullable = true, length = 4)
    private String forbidDay ;
    
    /** 
     * CREATE_TIME
     */
    @Column(name = "CREATE_TIME", nullable = true, length = 19)
    private Timestamp createTime ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public ElecErrorCount(){
	
	}
    /**
     * @getElectricianId:ELECTRICIAN_ID的get方法
     * @params
     * @return electricianId
     * @date 2021-01-26 17:55:54
     * @author 18511
     */
    public String getElectricianId(){
        return this.electricianId;
    }
    /**
     * @setElectricianId:ELECTRICIAN_ID的set方法
     * @param electricianId
     * @return
     * @date 2021-01-26 17:55:54
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
     * @getEvaluateCount:EVALUATE_COUNT的get方法
     * @params
     * @return evaluateCount
     * @date 2021-01-26 17:55:54
     * @author 18511
     */
    public String getEvaluateCount(){
        return this.evaluateCount;
    }
    /**
     * @setEvaluateCount:EVALUATE_COUNT的set方法
     * @param evaluateCount
     * @return
     * @date 2021-01-26 17:55:54
     * @author 18511
     */
    public void setEvaluateCount(String evaluateCount){
		this.evaluateCount = evaluateCount;
	} 
    /**
     * @getComplaintCount:COMPLAINT_COUNT的get方法
     * @params
     * @return complaintCount
     * @date 2021-01-26 17:55:54
     * @author 18511
     */
    public String getComplaintCount(){
        return this.complaintCount;
    }
    /**
     * @setComplaintCount:COMPLAINT_COUNT的set方法
     * @param complaintCount
     * @return
     * @date 2021-01-26 17:55:54
     * @author 18511
     */
    public void setComplaintCount(String complaintCount){
		this.complaintCount = complaintCount;
	} 
    /**
     * @getErrorFlag:ERROR_FLAG的get方法
     * @params
     * @return errorFlag
     * @date 2021-01-26 17:55:54
     * @author 18511
     */
    public String getErrorFlag(){
        return this.errorFlag;
    }
    /**
     * @setErrorFlag:ERROR_FLAG的set方法
     * @param errorFlag
     * @return
     * @date 2021-01-26 17:55:54
     * @author 18511
     */
    public void setErrorFlag(String errorFlag){
		this.errorFlag = errorFlag;
	} 
    /**
     * @getForbidDay:FORBID_DAY的get方法
     * @params
     * @return forbidDay
     * @date 2021-01-26 17:55:54
     * @author 18511
     */
    public String getForbidDay(){
        return this.forbidDay;
    }
    /**
     * @setForbidDay:FORBID_DAY的set方法
     * @param forbidDay
     * @return
     * @date 2021-01-26 17:55:54
     * @author 18511
     */
    public void setForbidDay(String forbidDay){
		this.forbidDay = forbidDay;
	} 
    /**
     * @getCreateTime:CREATE_TIME的get方法
     * @params
     * @return createTime
     * @date 2021-01-26 17:55:54
     * @author 18511
     */
    public Timestamp getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:CREATE_TIME的set方法
     * @param createTime
     * @return
     * @date 2021-01-26 17:55:54
     * @author 18511
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
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
		
        if (obj == null || !(obj instanceof ElecErrorCount))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		ElecErrorCount other = (ElecErrorCount) obj;
		
		if (electricianId == null) {
			if (other.electricianId != null) {
				return false;
			}
		} else if (!electricianId.equals(other.electricianId)) {
			return false;
		}
		if (evaluateCount == null) {
			if (other.evaluateCount != null) {
				return false;
			}
		} else if (!evaluateCount.equals(other.evaluateCount)) {
			return false;
		}
		if (complaintCount == null) {
			if (other.complaintCount != null) {
				return false;
			}
		} else if (!complaintCount.equals(other.complaintCount)) {
			return false;
		}
		if (errorFlag == null) {
			if (other.errorFlag != null) {
				return false;
			}
		} else if (!errorFlag.equals(other.errorFlag)) {
			return false;
		}
		if (forbidDay == null) {
			if (other.forbidDay != null) {
				return false;
			}
		} else if (!forbidDay.equals(other.forbidDay)) {
			return false;
		}
		if (createTime == null) {
			if (other.createTime != null) {
				return false;
			}
		} else if (!createTime.equals(other.createTime)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "ElecErrorCount ["
			+ ", electricianId=" + electricianId
			+ ", evaluateCount=" + evaluateCount
			+ ", complaintCount=" + complaintCount
			+ ", errorFlag=" + errorFlag
			+ ", forbidDay=" + forbidDay
			+ ", createTime=" + createTime;
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