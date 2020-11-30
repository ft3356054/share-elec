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
 * OrderFlow的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "order_flow")
public class OrderFlow implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * FLOW_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "FLOW_ID", nullable = false, length = 64)
    private String flowId ;
    
    /** 
     * FLOW_TYPE
     */
    @Column(name = "FLOW_TYPE", nullable = true, length = 2)
    private String flowType ;
    
    /** 
     * CURR_STATUS
     */
    @Column(name = "CURR_STATUS", nullable = true, length = 2)
    private String currStatus ;
    
    /** 
     * OPERATOR_ID
     */
    @Column(name = "OPERATOR_ID", nullable = true, length = 64)
    private String operatorId ;
    
    /** 
     * OPERATOR_TIME
     */
    @Column(name = "OPERATOR_TIME", nullable = true, length = 19)
    private String operatorTime ;
    
    /** 
     * OPERATOR_TYPE
     */
    @Column(name = "OPERATOR_TYPE", nullable = true, length = 2)
    private String operatorType ;
    
    /** 
     * REMARK
     */
    @Column(name = "REMARK", nullable = true, length = 512)
    private String remark ;
    
    /** 
     * ORDER_ID
     */
    @Column(name = "ORDER_ID", nullable = false, length = 64)
    private String orDERId ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public OrderFlow(){
	
	}
    /**
     * @getFlowId:FLOW_ID的get方法
     * @params
     * @return flowId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getFlowId(){
        return this.flowId;
    }
    /**
     * @setFlowId:FLOW_ID的set方法
     * @param flowId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setFlowId(String flowId){
        if(flowId != null && flowId.trim().length() == 0){
        	this.flowId = null;
        }else{
        	this.flowId = flowId;
        }
	} 
    /**
     * @getFlowType:FLOW_TYPE的get方法
     * @params
     * @return flowType
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getFlowType(){
        return this.flowType;
    }
    /**
     * @setFlowType:FLOW_TYPE的set方法
     * @param flowType
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setFlowType(String flowType){
		this.flowType = flowType;
	} 
    /**
     * @getCurrStatus:CURR_STATUS的get方法
     * @params
     * @return currStatus
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCurrStatus(){
        return this.currStatus;
    }
    /**
     * @setCurrStatus:CURR_STATUS的set方法
     * @param currStatus
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCurrStatus(String currStatus){
		this.currStatus = currStatus;
	} 
    /**
     * @getOperatorId:OPERATOR_ID的get方法
     * @params
     * @return operatorId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getOperatorId(){
        return this.operatorId;
    }
    /**
     * @setOperatorId:OPERATOR_ID的set方法
     * @param operatorId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	} 
    /**
     * @getOperatorTime:OPERATOR_TIME的get方法
     * @params
     * @return operatorTime
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getOperatorTime(){
        return this.operatorTime;
    }
    /**
     * @setOperatorTime:OPERATOR_TIME的set方法
     * @param operatorTime
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setOperatorTime(String operatorTime){
		this.operatorTime = operatorTime;
	} 
    /**
     * @getOperatorType:OPERATOR_TYPE的get方法
     * @params
     * @return operatorType
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getOperatorType(){
        return this.operatorType;
    }
    /**
     * @setOperatorType:OPERATOR_TYPE的set方法
     * @param operatorType
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setOperatorType(String operatorType){
		this.operatorType = operatorType;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 
    /**
     * @getOrDERId:ORDER_ID的get方法
     * @params
     * @return orDERId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getOrDERId(){
        return this.orDERId;
    }
    /**
     * @setOrDERId:ORDER_ID的set方法
     * @param orDERId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setOrDERId(String orDERId){
		this.orDERId = orDERId;
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
		
        if (obj == null || !(obj instanceof OrderFlow))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		OrderFlow other = (OrderFlow) obj;
		
		if (flowId == null) {
			if (other.flowId != null) {
				return false;
			}
		} else if (!flowId.equals(other.flowId)) {
			return false;
		}
		if (flowType == null) {
			if (other.flowType != null) {
				return false;
			}
		} else if (!flowType.equals(other.flowType)) {
			return false;
		}
		if (currStatus == null) {
			if (other.currStatus != null) {
				return false;
			}
		} else if (!currStatus.equals(other.currStatus)) {
			return false;
		}
		if (operatorId == null) {
			if (other.operatorId != null) {
				return false;
			}
		} else if (!operatorId.equals(other.operatorId)) {
			return false;
		}
		if (operatorTime == null) {
			if (other.operatorTime != null) {
				return false;
			}
		} else if (!operatorTime.equals(other.operatorTime)) {
			return false;
		}
		if (operatorType == null) {
			if (other.operatorType != null) {
				return false;
			}
		} else if (!operatorType.equals(other.operatorType)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		if (orDERId == null) {
			if (other.orDERId != null) {
				return false;
			}
		} else if (!orDERId.equals(other.orDERId)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "OrderFlow ["
			+ ", flowId=" + flowId
			+ ", flowType=" + flowType
			+ ", currStatus=" + currStatus
			+ ", operatorId=" + operatorId
			+ ", operatorTime=" + operatorTime
			+ ", operatorType=" + operatorType
			+ ", remark=" + remark
			+ ", orDERId=" + orDERId;
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