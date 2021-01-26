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
    @ViewAttribute(name ="evaluateCount",caption="EVALUATE_COUNT", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String evaluateCount;    
    /** 
     * 属性COMPLAINT_COUNT
     */  
    @ViewAttribute(name ="complaintCount",caption="COMPLAINT_COUNT", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String complaintCount;    
    /** 
     * 属性ERROR_FLAG
     */  
    @ViewAttribute(name ="errorFlag",caption="ERROR_FLAG", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String errorFlag;    
    /** 
     * 属性FORBID_DAY
     */  
    @ViewAttribute(name ="forbidDay",caption="FORBID_DAY", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String forbidDay;    
    /** 
     * 属性CREATE_TIME
     */  
    @ViewAttribute(name ="createTime",caption="CREATE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp createTime;    
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
    public String getEvaluateCount(){
        return evaluateCount;
    }
    /**
     * EVALUATE_COUNT的set方法
     * @param evaluateCount
     */
    public void setEvaluateCount(String evaluateCount){
		this.evaluateCount = evaluateCount;
	} 
    /**
     * COMPLAINT_COUNT的get方法
     * @return complaintCount
     */
    public String getComplaintCount(){
        return complaintCount;
    }
    /**
     * COMPLAINT_COUNT的set方法
     * @param complaintCount
     */
    public void setComplaintCount(String complaintCount){
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
    public String getForbidDay(){
        return forbidDay;
    }
    /**
     * FORBID_DAY的set方法
     * @param forbidDay
     */
    public void setForbidDay(String forbidDay){
		this.forbidDay = forbidDay;
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
				.append("CREATE_TIME"+":"+getCreateTime())
		        .toString(); 
			
    } 
   


}
