package com.sgcc.uap.share.customer.vo;

import java.io.Serializable;

import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * OrderFlow的VO类
 *
 * @author 18511 
 */
public class OrderFlowVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性FLOW_ID
     */  
    @ViewAttribute(name ="flowId",caption="FLOW_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String flowId;    
    /** 
     * 属性FLOW_TYPE
     */  
    @ViewAttribute(name ="flowType",caption="FLOW_TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String flowType;    
    /** 
     * 属性CURR_STATUS
     */  
    @ViewAttribute(name ="currStatus",caption="CURR_STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String currStatus;    
    /** 
     * 属性OPERATOR_ID
     */  
    @ViewAttribute(name ="operatorId",caption="OPERATOR_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String operatorId;    
    /** 
     * 属性OPERATOR_TIME
     */  
    @ViewAttribute(name ="operatorTime",caption="OPERATOR_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private String operatorTime;    
    /** 
     * 属性OPERATOR_TYPE
     */  
    @ViewAttribute(name ="operatorType",caption="OPERATOR_TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String operatorType;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /** 
     * 属性ORDER_ID
     */  
    @ViewAttribute(name ="orDERId",caption="ORDER_ID", editor=EditorType.ComboEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String orDERId;    
    /**
     * OrderFlowVO构造函数
     */
    public OrderFlowVO() {
        super();
    } 
   
	 /**
     * OrderFlowVO完整的构造函数
     */  
    public OrderFlowVO(String flowId){
        this.flowId = flowId;
    }
    /**
     * FLOW_ID的get方法
     * @return flowId
     */
    public String getFlowId(){
        return flowId;
    }
    /**
     * FLOW_ID的set方法
     * @param flowId
     */
    public void setFlowId(String flowId){
        if(flowId != null && flowId.trim().length() == 0){
        	this.flowId = null;
        }else{
        	this.flowId = flowId;
        }
	} 
    /**
     * FLOW_TYPE的get方法
     * @return flowType
     */
    public String getFlowType(){
        return flowType;
    }
    /**
     * FLOW_TYPE的set方法
     * @param flowType
     */
    public void setFlowType(String flowType){
		this.flowType = flowType;
	} 
    /**
     * CURR_STATUS的get方法
     * @return currStatus
     */
    public String getCurrStatus(){
        return currStatus;
    }
    /**
     * CURR_STATUS的set方法
     * @param currStatus
     */
    public void setCurrStatus(String currStatus){
		this.currStatus = currStatus;
	} 
    /**
     * OPERATOR_ID的get方法
     * @return operatorId
     */
    public String getOperatorId(){
        return operatorId;
    }
    /**
     * OPERATOR_ID的set方法
     * @param operatorId
     */
    public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	} 
    /**
     * OPERATOR_TIME的get方法
     * @return operatorTime
     */
    public String getOperatorTime(){
        return operatorTime;
    }
    /**
     * OPERATOR_TIME的set方法
     * @param operatorTime
     */
    public void setOperatorTime(String operatorTime){
		this.operatorTime = operatorTime;
	} 
    /**
     * OPERATOR_TYPE的get方法
     * @return operatorType
     */
    public String getOperatorType(){
        return operatorType;
    }
    /**
     * OPERATOR_TYPE的set方法
     * @param operatorType
     */
    public void setOperatorType(String operatorType){
		this.operatorType = operatorType;
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
     * ORDER_ID的get方法
     * @return orDERId
     */
    public String getOrDERId(){
        return orDERId;
    }
    /**
     * ORDER_ID的set方法
     * @param orDERId
     */
    public void setOrDERId(String orDERId){
		this.orDERId = orDERId;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("FLOW_ID"+":"+getFlowId())
				.append("FLOW_TYPE"+":"+getFlowType())
				.append("CURR_STATUS"+":"+getCurrStatus())
				.append("OPERATOR_ID"+":"+getOperatorId())
				.append("OPERATOR_TIME"+":"+getOperatorTime())
				.append("OPERATOR_TYPE"+":"+getOperatorType())
				.append("REMARK"+":"+getRemark())
				.append("ORDER_ID"+":"+getOrDERId())
		        .toString(); 
			
    } 
   


}
