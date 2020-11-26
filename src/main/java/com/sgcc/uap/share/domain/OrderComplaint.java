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
     * ORDER_ID
     */
    @Column(name = "ORDER_ID", nullable = false, length = 64)
    private String orDERId ;
    
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
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getOrderComplaintId(){
        return this.orderComplaintId;
    }
    /**
     * @setOrderComplaintId:ORDER_COMPLAINT_ID的set方法
     * @param orderComplaintId
     * @return
     * @date 2020-11-26 14:32:47
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
     * @getComplaintType:COMPLAINT_TYPE的get方法
     * @params
     * @return complaintType
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getComplaintType(){
        return this.complaintType;
    }
    /**
     * @setComplaintType:COMPLAINT_TYPE的set方法
     * @param complaintType
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setComplaintType(String complaintType){
		this.complaintType = complaintType;
	} 
    /**
     * @getComplaintDetail:COMPLAINT_DETAIL的get方法
     * @params
     * @return complaintDetail
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getComplaintDetail(){
        return this.complaintDetail;
    }
    /**
     * @setComplaintDetail:COMPLAINT_DETAIL的set方法
     * @param complaintDetail
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setComplaintDetail(String complaintDetail){
		this.complaintDetail = complaintDetail;
	} 
    /**
     * @getServiceId:SERVICE_ID的get方法
     * @params
     * @return serviceId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getServiceId(){
        return this.serviceId;
    }
    /**
     * @setServiceId:SERVICE_ID的set方法
     * @param serviceId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setServiceId(String serviceId){
		this.serviceId = serviceId;
	} 
    /**
     * @getResultsDetail:RESULTS_DETAIL的get方法
     * @params
     * @return resultsDetail
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getResultsDetail(){
        return this.resultsDetail;
    }
    /**
     * @setResultsDetail:RESULTS_DETAIL的set方法
     * @param resultsDetail
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setResultsDetail(String resultsDetail){
		this.resultsDetail = resultsDetail;
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
		return "OrderComplaint ["
			+ ", orderComplaintId=" + orderComplaintId
			+ ", complaintType=" + complaintType
			+ ", complaintDetail=" + complaintDetail
			+ ", serviceId=" + serviceId
			+ ", resultsDetail=" + resultsDetail
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