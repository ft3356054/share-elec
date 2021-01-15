package com.sgcc.uap.share.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * AssessRecord的VO类
 *
 * @author 18511 
 */
public class AssessRecordVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性订单ID
     */  
    @ViewAttribute(name ="orderId",caption="订单ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String orderId;    
    /** 
     * 属性客户ID
     */  
    @ViewAttribute(name ="assessId",caption="客户ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String assessId;    
    /** 
     * 属性订单投诉ID
     */  
    @ViewAttribute(name ="orderComplaintId",caption="订单投诉ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String orderComplaintId;    
    /** 
     * 属性客户电话
     */  
    @ViewAttribute(name ="assessStatus",caption="客户电话", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String assessStatus;    
    /** 
     * 属性客户地址
     */  
    @ViewAttribute(name ="assessReason",caption="客户地址", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String assessReason;    
    /** 
     * 属性创建时间
     */  
    @ViewAttribute(name ="createTime",caption="创建时间", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp createTime;    
    /** 
     * 属性更新时间
     */  
    @ViewAttribute(name ="updateTime",caption="更新时间", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp updateTime;    
    /** 
     * 属性结束时间
     */  
    @ViewAttribute(name ="finishTime",caption="结束时间", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp finishTime;    
    /** 
     * 属性客户描述
     */  
    @ViewAttribute(name ="assessType",caption="客户描述", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String assessType;    
    /** 
     * 属性客户拍照
     */  
    @ViewAttribute(name ="assessTypeValue",caption="客户拍照", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String assessTypeValue;    
    /** 
     * 属性客户评分
     */  
    @ViewAttribute(name ="serviceId",caption="客户评分", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String serviceId;    
    /** 
     * 属性客户评价标题
     */  
    @ViewAttribute(name ="solutionDesc",caption="客户评价标题", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String solutionDesc;    
    /** 
     * 属性客户评价
     */  
    @ViewAttribute(name ="remark",caption="客户评价", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * AssessRecordVO构造函数
     */
    public AssessRecordVO() {
        super();
    } 
   
	 /**
     * AssessRecordVO完整的构造函数
     */  
    public AssessRecordVO(String orderId){
        this.orderId = orderId;
    }
    /**
     * 订单ID的get方法
     * @return orderId
     */
    public String getOrderId(){
        return orderId;
    }
    /**
     * 订单ID的set方法
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
     * 客户ID的get方法
     * @return assessId
     */
    public String getAssessId(){
        return assessId;
    }
    /**
     * 客户ID的set方法
     * @param assessId
     */
    public void setAssessId(String assessId){
		this.assessId = assessId;
	} 
    /**
     * 订单投诉ID的get方法
     * @return orderComplaintId
     */
    public String getOrderComplaintId(){
        return orderComplaintId;
    }
    /**
     * 订单投诉ID的set方法
     * @param orderComplaintId
     */
    public void setOrderComplaintId(String orderComplaintId){
		this.orderComplaintId = orderComplaintId;
	} 
    /**
     * 客户电话的get方法
     * @return assessStatus
     */
    public String getAssessStatus(){
        return assessStatus;
    }
    /**
     * 客户电话的set方法
     * @param assessStatus
     */
    public void setAssessStatus(String assessStatus){
		this.assessStatus = assessStatus;
	} 
    /**
     * 客户地址的get方法
     * @return assessReason
     */
    public String getAssessReason(){
        return assessReason;
    }
    /**
     * 客户地址的set方法
     * @param assessReason
     */
    public void setAssessReason(String assessReason){
		this.assessReason = assessReason;
	} 
    /**
     * 创建时间的get方法
     * @return createTime
     */
    public Timestamp getCreateTime(){
        return createTime;
    }
    /**
     * 创建时间的set方法
     * @param createTime
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	} 
    /**
     * 更新时间的get方法
     * @return updateTime
     */
    public Timestamp getUpdateTime(){
        return updateTime;
    }
    /**
     * 更新时间的set方法
     * @param updateTime
     */
    public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * 结束时间的get方法
     * @return finishTime
     */
    public Timestamp getFinishTime(){
        return finishTime;
    }
    /**
     * 结束时间的set方法
     * @param finishTime
     */
    public void setFinishTime(Timestamp finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * 客户描述的get方法
     * @return assessType
     */
    public String getAssessType(){
        return assessType;
    }
    /**
     * 客户描述的set方法
     * @param assessType
     */
    public void setAssessType(String assessType){
		this.assessType = assessType;
	} 
    /**
     * 客户拍照的get方法
     * @return assessTypeValue
     */
    public String getAssessTypeValue(){
        return assessTypeValue;
    }
    /**
     * 客户拍照的set方法
     * @param assessTypeValue
     */
    public void setAssessTypeValue(String assessTypeValue){
		this.assessTypeValue = assessTypeValue;
	} 
    /**
     * 客户评分的get方法
     * @return serviceId
     */
    public String getServiceId(){
        return serviceId;
    }
    /**
     * 客户评分的set方法
     * @param serviceId
     */
    public void setServiceId(String serviceId){
		this.serviceId = serviceId;
	} 
    /**
     * 客户评价标题的get方法
     * @return solutionDesc
     */
    public String getSolutionDesc(){
        return solutionDesc;
    }
    /**
     * 客户评价标题的set方法
     * @param solutionDesc
     */
    public void setSolutionDesc(String solutionDesc){
		this.solutionDesc = solutionDesc;
	} 
    /**
     * 客户评价的get方法
     * @return remark
     */
    public String getRemark(){
        return remark;
    }
    /**
     * 客户评价的set方法
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
				.append("ASSESS_ID"+":"+getAssessId())
				.append("ORDER_COMPLAINT_ID"+":"+getOrderComplaintId())
				.append("ASSESS_STATUS"+":"+getAssessStatus())
				.append("ASSESS_REASON"+":"+getAssessReason())
				.append("CREATE_TIME"+":"+getCreateTime())
				.append("UPDATE_TIME"+":"+getUpdateTime())
				.append("FINISH_TIME"+":"+getFinishTime())
				.append("ASSESS_TYPE"+":"+getAssessType())
				.append("ASSESS_TYPE_VALUE"+":"+getAssessTypeValue())
				.append("SERVICE_ID"+":"+getServiceId())
				.append("SOLUTION_DESC"+":"+getSolutionDesc())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
