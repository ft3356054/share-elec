package com.sgcc.uap.share.customer.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * OrderComplaint的VO类
 *
 * @author 18511 
 */
public class OrderComplaintVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ORDER_COMPLAINT_ID
     */  
    @ViewAttribute(name ="orderComplaintId",caption="ORDER_COMPLAINT_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String orderComplaintId;    
    /** 
     * 属性ORDER_ID
     */  
    @ViewAttribute(name ="orderId",caption="ORDER_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String orderId;    
    /** 
     * 属性COMPLAINT_TYPE
     */  
    @ViewAttribute(name ="complaintType",caption="COMPLAINT_TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String complaintType;    
    /** 
     * 属性COMPLAINT_DETAIL
     */  
    @ViewAttribute(name ="complaintDetail",caption="COMPLAINT_DETAIL", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String complaintDetail;    
    /** 
     * 属性COMPLAINT_PICTURE
     */  
    @ViewAttribute(name ="complaintPicture",caption="COMPLAINT_PICTURE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String complaintPicture;    
    /** 
     * 属性SERVICE_ID
     */  
    @ViewAttribute(name ="serviceId",caption="SERVICE_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String serviceId;    
    /** 
     * 属性RESULTS_DETAIL
     */  
    @ViewAttribute(name ="resultsDetail",caption="RESULTS_DETAIL", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String resultsDetail;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * OrderComplaintVO构造函数
     */
    public OrderComplaintVO() {
        super();
    } 
   
	 /**
     * OrderComplaintVO完整的构造函数
     */  
    public OrderComplaintVO(String orderComplaintId){
        this.orderComplaintId = orderComplaintId;
    }
    /**
     * ORDER_COMPLAINT_ID的get方法
     * @return orderComplaintId
     */
    public String getOrderComplaintId(){
        return orderComplaintId;
    }
    /**
     * ORDER_COMPLAINT_ID的set方法
     * @param orderComplaintId
     */
    public void setOrderComplaintId(String orderComplaintId){
        if(orderComplaintId != null && orderComplaintId.trim().length() == 0){
        	this.orderComplaintId = null;
        }else{
        	this.orderComplaintId = orderComplaintId;
        }
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
		this.orderId = orderId;
	} 
    /**
     * COMPLAINT_TYPE的get方法
     * @return complaintType
     */
    public String getComplaintType(){
        return complaintType;
    }
    /**
     * COMPLAINT_TYPE的set方法
     * @param complaintType
     */
    public void setComplaintType(String complaintType){
		this.complaintType = complaintType;
	} 
    /**
     * COMPLAINT_DETAIL的get方法
     * @return complaintDetail
     */
    public String getComplaintDetail(){
        return complaintDetail;
    }
    /**
     * COMPLAINT_DETAIL的set方法
     * @param complaintDetail
     */
    public void setComplaintDetail(String complaintDetail){
		this.complaintDetail = complaintDetail;
	} 
    /**
     * COMPLAINT_PICTURE的get方法
     * @return complaintPicture
     */
    public String getComplaintPicture(){
        return complaintPicture;
    }
    /**
     * COMPLAINT_PICTURE的set方法
     * @param complaintPicture
     */
    public void setComplaintPicture(String complaintPicture){
		this.complaintPicture = complaintPicture;
	} 
    /**
     * SERVICE_ID的get方法
     * @return serviceId
     */
    public String getServiceId(){
        return serviceId;
    }
    /**
     * SERVICE_ID的set方法
     * @param serviceId
     */
    public void setServiceId(String serviceId){
		this.serviceId = serviceId;
	} 
    /**
     * RESULTS_DETAIL的get方法
     * @return resultsDetail
     */
    public String getResultsDetail(){
        return resultsDetail;
    }
    /**
     * RESULTS_DETAIL的set方法
     * @param resultsDetail
     */
    public void setResultsDetail(String resultsDetail){
		this.resultsDetail = resultsDetail;
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
	  			.append("ORDER_COMPLAINT_ID"+":"+getOrderComplaintId())
				.append("ORDER_ID"+":"+getOrderId())
				.append("COMPLAINT_TYPE"+":"+getComplaintType())
				.append("COMPLAINT_DETAIL"+":"+getComplaintDetail())
				.append("COMPLAINT_PICTURE"+":"+getComplaintPicture())
				.append("SERVICE_ID"+":"+getServiceId())
				.append("RESULTS_DETAIL"+":"+getResultsDetail())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
