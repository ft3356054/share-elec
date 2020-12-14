package com.sgcc.uap.share.customer.vo;

import java.io.Serializable;
import java.sql.Timestamp;


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
     * 属性CUSTOMER_ID
     */  
    @ViewAttribute(name ="customerId",caption="CUSTOMER_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerId;    
    /** 
     * 属性CUSTOMER_NAME
     */  
    @ViewAttribute(name ="customerName",caption="CUSTOMER_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerName;    
    /** 
     * 属性CUSTOMER_PHONENUMBER
     */  
    @ViewAttribute(name ="customerPhonenumber",caption="CUSTOMER_PHONENUMBER", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerPhonenumber;    
    /** 
     * 属性COMPANY_ID
     */  
    @ViewAttribute(name ="companyId",caption="COMPANY_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String companyId;    
    /** 
     * 属性COMPANY_NAME
     */  
    @ViewAttribute(name ="companyName",caption="COMPANY_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String companyName;    
    /** 
     * 属性COMPLAINT_TYPE
     */  
    @ViewAttribute(name ="complaintType",caption="COMPLAINT_TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String complaintType;    
    /** 
     * 属性CREATE_TIME
     */  
    @ViewAttribute(name ="createTime",caption="CREATE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp createTime;    
    /** 
     * 属性UPDATE_TIME
     */  
    @ViewAttribute(name ="updateTime",caption="UPDATE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp updateTime;    
    /** 
     * 属性FINISH_TIME
     */  
    @ViewAttribute(name ="finishTime",caption="FINISH_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp finishTime;    
    /** 
     * 属性COMPLAINT_STATUS
     */  
    @ViewAttribute(name ="complaintStatus",caption="COMPLAINT_STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String complaintStatus;    
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
     * 属性REMARK1
     */  
    @ViewAttribute(name ="remark1",caption="REMARK1", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark1;    
    /** 
     * 属性REMARK2
     */  
    @ViewAttribute(name ="remark2",caption="REMARK2", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark2;    
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
     * CUSTOMER_ID的get方法
     * @return customerId
     */
    public String getCustomerId(){
        return customerId;
    }
    /**
     * CUSTOMER_ID的set方法
     * @param customerId
     */
    public void setCustomerId(String customerId){
		this.customerId = customerId;
	} 
    /**
     * CUSTOMER_NAME的get方法
     * @return customerName
     */
    public String getCustomerName(){
        return customerName;
    }
    /**
     * CUSTOMER_NAME的set方法
     * @param customerName
     */
    public void setCustomerName(String customerName){
		this.customerName = customerName;
	} 
    /**
     * CUSTOMER_PHONENUMBER的get方法
     * @return customerPhonenumber
     */
    public String getCustomerPhonenumber(){
        return customerPhonenumber;
    }
    /**
     * CUSTOMER_PHONENUMBER的set方法
     * @param customerPhonenumber
     */
    public void setCustomerPhonenumber(String customerPhonenumber){
		this.customerPhonenumber = customerPhonenumber;
	} 
    /**
     * COMPANY_ID的get方法
     * @return companyId
     */
    public String getCompanyId(){
        return companyId;
    }
    /**
     * COMPANY_ID的set方法
     * @param companyId
     */
    public void setCompanyId(String companyId){
		this.companyId = companyId;
	} 
    /**
     * COMPANY_NAME的get方法
     * @return companyName
     */
    public String getCompanyName(){
        return companyName;
    }
    /**
     * COMPANY_NAME的set方法
     * @param companyName
     */
    public void setCompanyName(String companyName){
		this.companyName = companyName;
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
     * UPDATE_TIME的get方法
     * @return updateTime
     */
    public Timestamp getUpdateTime(){
        return updateTime;
    }
    /**
     * UPDATE_TIME的set方法
     * @param updateTime
     */
    public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * FINISH_TIME的get方法
     * @return finishTime
     */
    public Timestamp getFinishTime(){
        return finishTime;
    }
    /**
     * FINISH_TIME的set方法
     * @param finishTime
     */
    public void setFinishTime(Timestamp finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * COMPLAINT_STATUS的get方法
     * @return complaintStatus
     */
    public String getComplaintStatus(){
        return complaintStatus;
    }
    /**
     * COMPLAINT_STATUS的set方法
     * @param complaintStatus
     */
    public void setComplaintStatus(String complaintStatus){
		this.complaintStatus = complaintStatus;
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
     * REMARK1的get方法
     * @return remark1
     */
    public String getRemark1(){
        return remark1;
    }
    /**
     * REMARK1的set方法
     * @param remark1
     */
    public void setRemark1(String remark1){
		this.remark1 = remark1;
	} 
    /**
     * REMARK2的get方法
     * @return remark2
     */
    public String getRemark2(){
        return remark2;
    }
    /**
     * REMARK2的set方法
     * @param remark2
     */
    public void setRemark2(String remark2){
		this.remark2 = remark2;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("ORDER_COMPLAINT_ID"+":"+getOrderComplaintId())
				.append("ORDER_ID"+":"+getOrderId())
				.append("CUSTOMER_ID"+":"+getCustomerId())
				.append("CUSTOMER_NAME"+":"+getCustomerName())
				.append("CUSTOMER_PHONENUMBER"+":"+getCustomerPhonenumber())
				.append("COMPANY_ID"+":"+getCompanyId())
				.append("COMPANY_NAME"+":"+getCompanyName())
				.append("COMPLAINT_TYPE"+":"+getComplaintType())
				.append("CREATE_TIME"+":"+getCreateTime())
				.append("UPDATE_TIME"+":"+getUpdateTime())
				.append("FINISH_TIME"+":"+getFinishTime())
				.append("COMPLAINT_STATUS"+":"+getComplaintStatus())
				.append("COMPLAINT_DETAIL"+":"+getComplaintDetail())
				.append("COMPLAINT_PICTURE"+":"+getComplaintPicture())
				.append("SERVICE_ID"+":"+getServiceId())
				.append("RESULTS_DETAIL"+":"+getResultsDetail())
				.append("REMARK"+":"+getRemark())
				.append("REMARK1"+":"+getRemark1())
				.append("REMARK2"+":"+getRemark2())
		        .toString(); 
			
    } 
   


}
