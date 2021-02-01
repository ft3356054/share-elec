package com.sgcc.uap.share.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


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
	/*@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")*/
    @Column(name = "ELECTRICIAN_ID", nullable = false, length = 64)
    private String electricianId ;
    
    /** 
     * EVALUATE_COUNT
     */
    @Column(name = "EVALUATE_COUNT", nullable = true, length = 10)
    private Integer evaluateCount ;
    
    /** 
     * COMPLAINT_COUNT
     */
    @Column(name = "COMPLAINT_COUNT", nullable = true, length = 10)
    private Integer complaintCount ;
    
    /** 
     * ERROR_FLAG
     */
    @Column(name = "ERROR_FLAG", nullable = true, length = 4)
    private String errorFlag ;
    
    /** 
     * FORBID_DAY
     */
    @Column(name = "FORBID_DAY", nullable = true, length = 10)
    private Integer forbidDay ;
    
    /** 
     * BEGIN_TIME
     */
    @Column(name = "BEGIN_TIME", nullable = true, length = 19)
    private String beginTime ;
    
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
     * @date 2021-01-29 10:17:13
     * @author 18511
     */
    public String getElectricianId(){
        return this.electricianId;
    }
    /**
     * @setElectricianId:ELECTRICIAN_ID的set方法
     * @param electricianId
     * @return
     * @date 2021-01-29 10:17:13
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
     * @date 2021-01-29 10:17:13
     * @author 18511
     */
    public Integer getEvaluateCount(){
        return this.evaluateCount;
    }
    /**
     * @setEvaluateCount:EVALUATE_COUNT的set方法
     * @param evaluateCount
     * @return
     * @date 2021-01-29 10:17:13
     * @author 18511
     */
    public void setEvaluateCount(Integer evaluateCount){
		this.evaluateCount = evaluateCount;
	} 
    /**
     * @getComplaintCount:COMPLAINT_COUNT的get方法
     * @params
     * @return complaintCount
     * @date 2021-01-29 10:17:13
     * @author 18511
     */
    public Integer getComplaintCount(){
        return this.complaintCount;
    }
    /**
     * @setComplaintCount:COMPLAINT_COUNT的set方法
     * @param complaintCount
     * @return
     * @date 2021-01-29 10:17:13
     * @author 18511
     */
    public void setComplaintCount(Integer complaintCount){
		this.complaintCount = complaintCount;
	} 
    /**
     * @getErrorFlag:ERROR_FLAG的get方法
     * @params
     * @return errorFlag
     * @date 2021-01-29 10:17:13
     * @author 18511
     */
    public String getErrorFlag(){
        return this.errorFlag;
    }
    /**
     * @setErrorFlag:ERROR_FLAG的set方法
     * @param errorFlag
     * @return
     * @date 2021-01-29 10:17:13
     * @author 18511
     */
    public void setErrorFlag(String errorFlag){
		this.errorFlag = errorFlag;
	} 
    /**
     * @getForbidDay:FORBID_DAY的get方法
     * @params
     * @return forbidDay
     * @date 2021-01-29 10:17:13
     * @author 18511
     */
    public Integer getForbidDay(){
        return this.forbidDay;
    }
    /**
     * @setForbidDay:FORBID_DAY的set方法
     * @param forbidDay
     * @return
     * @date 2021-01-29 10:17:13
     * @author 18511
     */
    public void setForbidDay(Integer forbidDay){
		this.forbidDay = forbidDay;
	} 
    /**
     * @getBeginTime:BEGIN_TIME的get方法
     * @params
     * @return beginTime
     * @date 2021-01-29 10:17:13
     * @author 18511
     */
    public String getBeginTime(){
        return this.beginTime;
    }
    /**
     * @setBeginTime:BEGIN_TIME的set方法
     * @param beginTime
     * @return
     * @date 2021-01-29 10:17:13
     * @author 18511
     */
    public void setBeginTime(String beginTime){
		this.beginTime = beginTime;
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
		if (beginTime == null) {
			if (other.beginTime != null) {
				return false;
			}
		} else if (!beginTime.equals(other.beginTime)) {
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
			+ ", beginTime=" + beginTime;
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