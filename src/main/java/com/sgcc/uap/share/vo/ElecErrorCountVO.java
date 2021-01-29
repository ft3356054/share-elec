package com.sgcc.uap.share.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * ElecErrorCount的VO类
 *
 * @author 18511 
 */
public class ElecErrorCountVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ELECTRICIAN_ID
     */  
    @ViewAttribute(name ="electricianId",caption="ELECTRICIAN_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String electricianId;    
    /** 
     * 属性EVALUATE_COUNT
     */  
    @ViewAttribute(name ="evaluateCount",caption="EVALUATE_COUNT", editor=EditorType.NumberEditor,nullable =true,readOnly=false, type=AttributeType.INTEGER)
    private Integer evaluateCount;    
    /** 
     * 属性COMPLAINT_COUNT
     */  
    @ViewAttribute(name ="complaintCount",caption="COMPLAINT_COUNT", editor=EditorType.NumberEditor,nullable =true,readOnly=false, type=AttributeType.INTEGER)
    private Integer complaintCount;    
    /** 
     * 属性ERROR_FLAG
     */  
    @ViewAttribute(name ="errorFlag",caption="ERROR_FLAG", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String errorFlag;    
    /** 
     * 属性FORBID_DAY
     */  
    @ViewAttribute(name ="forbidDay",caption="FORBID_DAY", editor=EditorType.NumberEditor,nullable =true,readOnly=false, type=AttributeType.INTEGER)
    private Integer forbidDay;    
    /** 
     * 属性BEGIN_TIME
     */  
    @ViewAttribute(name ="beginTime",caption="BEGIN_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp beginTime;    
    /**
     * ElecErrorCountVO构造函数
     */
    public ElecErrorCountVO() {
        super();
    } 
   
	 /**
     * ElecErrorCountVO完整的构造函数
     */  
    public ElecErrorCountVO(String electricianId){
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
     * EVALUATE_COUNT的get方法
     * @return evaluateCount
     */
    public Integer getEvaluateCount(){
        return evaluateCount;
    }
    /**
     * EVALUATE_COUNT的set方法
     * @param evaluateCount
     */
    public void setEvaluateCount(Integer evaluateCount){
		this.evaluateCount = evaluateCount;
	} 
    /**
     * COMPLAINT_COUNT的get方法
     * @return complaintCount
     */
    public Integer getComplaintCount(){
        return complaintCount;
    }
    /**
     * COMPLAINT_COUNT的set方法
     * @param complaintCount
     */
    public void setComplaintCount(Integer complaintCount){
		this.complaintCount = complaintCount;
	} 
    /**
     * ERROR_FLAG的get方法
     * @return errorFlag
     */
    public String getErrorFlag(){
        return errorFlag;
    }
    /**
     * ERROR_FLAG的set方法
     * @param errorFlag
     */
    public void setErrorFlag(String errorFlag){
		this.errorFlag = errorFlag;
	} 
    /**
     * FORBID_DAY的get方法
     * @return forbidDay
     */
    public Integer getForbidDay(){
        return forbidDay;
    }
    /**
     * FORBID_DAY的set方法
     * @param forbidDay
     */
    public void setForbidDay(Integer forbidDay){
		this.forbidDay = forbidDay;
	} 
    /**
     * BEGIN_TIME的get方法
     * @return beginTime
     */
    public Timestamp getBeginTime(){
        return beginTime;
    }
    /**
     * BEGIN_TIME的set方法
     * @param beginTime
     */
    public void setBeginTime(Timestamp beginTime){
		this.beginTime = beginTime;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("ELECTRICIAN_ID"+":"+getElectricianId())
				.append("EVALUATE_COUNT"+":"+getEvaluateCount())
				.append("COMPLAINT_COUNT"+":"+getComplaintCount())
				.append("ERROR_FLAG"+":"+getErrorFlag())
				.append("FORBID_DAY"+":"+getForbidDay())
				.append("BEGIN_TIME"+":"+getBeginTime())
		        .toString(); 
			
    } 
   


}
