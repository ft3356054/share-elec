package com.sgcc.uap.share.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


/**
 * OrderComplaint的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "order_complaint")
public class OrderComplaint implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * ORDER_COMPLAINT_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "ORDER_COMPLAINT_ID", nullable = false, length = 64)
    private String orderComplaintId ;
    
    /** 
     * ORDER_ID
     */
    @Column(name = "ORDER_ID", nullable = false, length = 64)
	@NotBlank(message="不能为空")
    private String orderId ;
    
    /** 
     * COMPLAINT_TYPE
     */
    @Column(name = "COMPLAINT_TYPE", nullable = true, length = 2)
    private String complaintType ;
    
    /** 
     * COMPLAINT_DETAIL
     */
    @Column(name = "COMPLAINT_DETAIL", nullable = true, length = 512)
    private String complaintDetail ;
    
    /** 
     * COMPLAINT_PICTURE
     */
    @Column(name = "COMPLAINT_PICTURE", nullable = true, length = 512)
    private String complaintPicture ;
    
    /** 
     * SERVICE_ID
     */
    @Column(name = "SERVICE_ID", nullable = true, length = 64)
    private String serviceId ;
    
    /** 
     * RESULTS_DETAIL
     */
    @Column(name = "RESULTS_DETAIL", nullable = true, length = 512)
    private String resultsDetail ;
    
    /** 
     * REMARK
     */
    @Column(name = "REMARK", nullable = true, length = 512)
    private String remark ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public OrderComplaint(){
	
	}
    /**
     * @getOrderComplaintId:ORDER_COMPLAINT_ID的get方法
     * @params
     * @return orderComplaintId
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public String getOrderComplaintId(){
        return this.orderComplaintId;
    }
    /**
     * @setOrderComplaintId:ORDER_COMPLAINT_ID的set方法
     * @param orderComplaintId
     * @return
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public void setOrderComplaintId(String orderComplaintId){
        if(orderComplaintId != null && orderComplaintId.trim().length() == 0){
        	this.orderComplaintId = null;
        }else{
        	this.orderComplaintId = orderComplaintId;
        }
	} 
    /**
     * @getOrderId:ORDER_ID的get方法
     * @params
     * @return orderId
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public String getOrderId(){
        return this.orderId;
    }
    /**
     * @setOrderId:ORDER_ID的set方法
     * @param orderId
     * @return
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public void setOrderId(String orderId){
		this.orderId = orderId;
	} 
    /**
     * @getComplaintType:COMPLAINT_TYPE的get方法
     * @params
     * @return complaintType
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public String getComplaintType(){
        return this.complaintType;
    }
    /**
     * @setComplaintType:COMPLAINT_TYPE的set方法
     * @param complaintType
     * @return
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public void setComplaintType(String complaintType){
		this.complaintType = complaintType;
	} 
    /**
     * @getComplaintDetail:COMPLAINT_DETAIL的get方法
     * @params
     * @return complaintDetail
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public String getComplaintDetail(){
        return this.complaintDetail;
    }
    /**
     * @setComplaintDetail:COMPLAINT_DETAIL的set方法
     * @param complaintDetail
     * @return
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public void setComplaintDetail(String complaintDetail){
		this.complaintDetail = complaintDetail;
	} 
    /**
     * @getComplaintPicture:COMPLAINT_PICTURE的get方法
     * @params
     * @return complaintPicture
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public String getComplaintPicture(){
        return this.complaintPicture;
    }
    /**
     * @setComplaintPicture:COMPLAINT_PICTURE的set方法
     * @param complaintPicture
     * @return
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public void setComplaintPicture(String complaintPicture){
		this.complaintPicture = complaintPicture;
	} 
    /**
     * @getServiceId:SERVICE_ID的get方法
     * @params
     * @return serviceId
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public String getServiceId(){
        return this.serviceId;
    }
    /**
     * @setServiceId:SERVICE_ID的set方法
     * @param serviceId
     * @return
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public void setServiceId(String serviceId){
		this.serviceId = serviceId;
	} 
    /**
     * @getResultsDetail:RESULTS_DETAIL的get方法
     * @params
     * @return resultsDetail
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public String getResultsDetail(){
        return this.resultsDetail;
    }
    /**
     * @setResultsDetail:RESULTS_DETAIL的set方法
     * @param resultsDetail
     * @return
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public void setResultsDetail(String resultsDetail){
		this.resultsDetail = resultsDetail;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-12-14 11:25:11
     * @author 18511
     */
    public void setRemark(String remark){
		this.remark = remark;
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
		
        if (obj == null || !(obj instanceof OrderComplaint))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		OrderComplaint other = (OrderComplaint) obj;
		
		if (orderComplaintId == null) {
			if (other.orderComplaintId != null) {
				return false;
			}
		} else if (!orderComplaintId.equals(other.orderComplaintId)) {
			return false;
		}
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (complaintType == null) {
			if (other.complaintType != null) {
				return false;
			}
		} else if (!complaintType.equals(other.complaintType)) {
			return false;
		}
		if (complaintDetail == null) {
			if (other.complaintDetail != null) {
				return false;
			}
		} else if (!complaintDetail.equals(other.complaintDetail)) {
			return false;
		}
		if (complaintPicture == null) {
			if (other.complaintPicture != null) {
				return false;
			}
		} else if (!complaintPicture.equals(other.complaintPicture)) {
			return false;
		}
		if (serviceId == null) {
			if (other.serviceId != null) {
				return false;
			}
		} else if (!serviceId.equals(other.serviceId)) {
			return false;
		}
		if (resultsDetail == null) {
			if (other.resultsDetail != null) {
				return false;
			}
		} else if (!resultsDetail.equals(other.resultsDetail)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "OrderComplaint ["
			+ ", orderComplaintId=" + orderComplaintId
			+ ", orderId=" + orderId
			+ ", complaintType=" + complaintType
			+ ", complaintDetail=" + complaintDetail
			+ ", complaintPicture=" + complaintPicture
			+ ", serviceId=" + serviceId
			+ ", resultsDetail=" + resultsDetail
			+ ", remark=" + remark;
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