package com.sgcc.uap.share.domain;

import java.io.Serializable;
import java.sql.Timestamp;

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
     * CUSTOMER_ID
     */
    @Column(name = "CUSTOMER_ID", nullable = true, length = 64)
    private String customerId ;
    
    /** 
     * CUSTOMER_NAME
     */
    @Column(name = "CUSTOMER_NAME", nullable = true, length = 64)
    private String customerName ;
    
    /** 
     * CUSTOMER_PHONENUMBER
     */
    @Column(name = "CUSTOMER_PHONENUMBER", nullable = true, length = 64)
    private String customerPhonenumber ;
    
    /** 
     * COMPANY_ID
     */
    @Column(name = "COMPANY_ID", nullable = true, length = 64)
    private String companyId ;
    
    /** 
     * COMPANY_NAME
     */
    @Column(name = "COMPANY_NAME", nullable = true, length = 64)
    private String companyName ;
    
    /** 
     * COMPLAINT_TYPE
     */
    @Column(name = "COMPLAINT_TYPE", nullable = true, length = 2)
    private String complaintType ;
    
    /** 
     * CREATE_TIME
     */
    @Column(name = "CREATE_TIME", nullable = true, length = 19)
    private Timestamp createTime ;
    
    /** 
     * UPDATE_TIME
     */
    @Column(name = "UPDATE_TIME", nullable = true, length = 19)
    private Timestamp updateTime ;
    
    /** 
     * FINISH_TIME
     */
    @Column(name = "FINISH_TIME", nullable = true, length = 19)
    private Timestamp finishTime ;
    
    /** 
     * COMPLAINT_STATUS
     */
    @Column(name = "COMPLAINT_STATUS", nullable = true, length = 2)
    private String complaintStatus ;
    
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
     * REMARK1
     */
    @Column(name = "REMARK1", nullable = true, length = 512)
    private String remark1 ;
    
    /** 
     * REMARK2
     */
    @Column(name = "REMARK2", nullable = true, length = 512)
    private String remark2 ;
    
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
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getOrderComplaintId(){
        return this.orderComplaintId;
    }
    /**
     * @setOrderComplaintId:ORDER_COMPLAINT_ID的set方法
     * @param orderComplaintId
     * @return
     * @date 2020-12-14 12:00:46
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
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getOrderId(){
        return this.orderId;
    }
    /**
     * @setOrderId:ORDER_ID的set方法
     * @param orderId
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setOrderId(String orderId){
		this.orderId = orderId;
	} 
    /**
     * @getCustomerId:CUSTOMER_ID的get方法
     * @params
     * @return customerId
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getCustomerId(){
        return this.customerId;
    }
    /**
     * @setCustomerId:CUSTOMER_ID的set方法
     * @param customerId
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setCustomerId(String customerId){
		this.customerId = customerId;
	} 
    /**
     * @getCustomerName:CUSTOMER_NAME的get方法
     * @params
     * @return customerName
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getCustomerName(){
        return this.customerName;
    }
    /**
     * @setCustomerName:CUSTOMER_NAME的set方法
     * @param customerName
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setCustomerName(String customerName){
		this.customerName = customerName;
	} 
    /**
     * @getCustomerPhonenumber:CUSTOMER_PHONENUMBER的get方法
     * @params
     * @return customerPhonenumber
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getCustomerPhonenumber(){
        return this.customerPhonenumber;
    }
    /**
     * @setCustomerPhonenumber:CUSTOMER_PHONENUMBER的set方法
     * @param customerPhonenumber
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setCustomerPhonenumber(String customerPhonenumber){
		this.customerPhonenumber = customerPhonenumber;
	} 
    /**
     * @getCompanyId:COMPANY_ID的get方法
     * @params
     * @return companyId
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getCompanyId(){
        return this.companyId;
    }
    /**
     * @setCompanyId:COMPANY_ID的set方法
     * @param companyId
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setCompanyId(String companyId){
		this.companyId = companyId;
	} 
    /**
     * @getCompanyName:COMPANY_NAME的get方法
     * @params
     * @return companyName
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getCompanyName(){
        return this.companyName;
    }
    /**
     * @setCompanyName:COMPANY_NAME的set方法
     * @param companyName
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setCompanyName(String companyName){
		this.companyName = companyName;
	} 
    /**
     * @getComplaintType:COMPLAINT_TYPE的get方法
     * @params
     * @return complaintType
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getComplaintType(){
        return this.complaintType;
    }
    /**
     * @setComplaintType:COMPLAINT_TYPE的set方法
     * @param complaintType
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setComplaintType(String complaintType){
		this.complaintType = complaintType;
	} 
    /**
     * @getCreateTime:CREATE_TIME的get方法
     * @params
     * @return createTime
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public Timestamp getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:CREATE_TIME的set方法
     * @param createTime
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	} 
    /**
     * @getUpdateTime:UPDATE_TIME的get方法
     * @params
     * @return updateTime
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public Timestamp getUpdateTime(){
        return this.updateTime;
    }
    /**
     * @setUpdateTime:UPDATE_TIME的set方法
     * @param updateTime
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * @getFinishTime:FINISH_TIME的get方法
     * @params
     * @return finishTime
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public Timestamp getFinishTime(){
        return this.finishTime;
    }
    /**
     * @setFinishTime:FINISH_TIME的set方法
     * @param finishTime
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setFinishTime(Timestamp finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * @getComplaintStatus:COMPLAINT_STATUS的get方法
     * @params
     * @return complaintStatus
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getComplaintStatus(){
        return this.complaintStatus;
    }
    /**
     * @setComplaintStatus:COMPLAINT_STATUS的set方法
     * @param complaintStatus
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setComplaintStatus(String complaintStatus){
		this.complaintStatus = complaintStatus;
	} 
    /**
     * @getComplaintDetail:COMPLAINT_DETAIL的get方法
     * @params
     * @return complaintDetail
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getComplaintDetail(){
        return this.complaintDetail;
    }
    /**
     * @setComplaintDetail:COMPLAINT_DETAIL的set方法
     * @param complaintDetail
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setComplaintDetail(String complaintDetail){
		this.complaintDetail = complaintDetail;
	} 
    /**
     * @getComplaintPicture:COMPLAINT_PICTURE的get方法
     * @params
     * @return complaintPicture
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getComplaintPicture(){
        return this.complaintPicture;
    }
    /**
     * @setComplaintPicture:COMPLAINT_PICTURE的set方法
     * @param complaintPicture
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setComplaintPicture(String complaintPicture){
		this.complaintPicture = complaintPicture;
	} 
    /**
     * @getServiceId:SERVICE_ID的get方法
     * @params
     * @return serviceId
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getServiceId(){
        return this.serviceId;
    }
    /**
     * @setServiceId:SERVICE_ID的set方法
     * @param serviceId
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setServiceId(String serviceId){
		this.serviceId = serviceId;
	} 
    /**
     * @getResultsDetail:RESULTS_DETAIL的get方法
     * @params
     * @return resultsDetail
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getResultsDetail(){
        return this.resultsDetail;
    }
    /**
     * @setResultsDetail:RESULTS_DETAIL的set方法
     * @param resultsDetail
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setResultsDetail(String resultsDetail){
		this.resultsDetail = resultsDetail;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 
    /**
     * @getRemark1:REMARK1的get方法
     * @params
     * @return remark1
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getRemark1(){
        return this.remark1;
    }
    /**
     * @setRemark1:REMARK1的set方法
     * @param remark1
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setRemark1(String remark1){
		this.remark1 = remark1;
	} 
    /**
     * @getRemark2:REMARK2的get方法
     * @params
     * @return remark2
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public String getRemark2(){
        return this.remark2;
    }
    /**
     * @setRemark2:REMARK2的set方法
     * @param remark2
     * @return
     * @date 2020-12-14 12:00:46
     * @author 18511
     */
    public void setRemark2(String remark2){
		this.remark2 = remark2;
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
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (customerName == null) {
			if (other.customerName != null) {
				return false;
			}
		} else if (!customerName.equals(other.customerName)) {
			return false;
		}
		if (customerPhonenumber == null) {
			if (other.customerPhonenumber != null) {
				return false;
			}
		} else if (!customerPhonenumber.equals(other.customerPhonenumber)) {
			return false;
		}
		if (companyId == null) {
			if (other.companyId != null) {
				return false;
			}
		} else if (!companyId.equals(other.companyId)) {
			return false;
		}
		if (companyName == null) {
			if (other.companyName != null) {
				return false;
			}
		} else if (!companyName.equals(other.companyName)) {
			return false;
		}
		if (complaintType == null) {
			if (other.complaintType != null) {
				return false;
			}
		} else if (!complaintType.equals(other.complaintType)) {
			return false;
		}
		if (createTime == null) {
			if (other.createTime != null) {
				return false;
			}
		} else if (!createTime.equals(other.createTime)) {
			return false;
		}
		if (updateTime == null) {
			if (other.updateTime != null) {
				return false;
			}
		} else if (!updateTime.equals(other.updateTime)) {
			return false;
		}
		if (finishTime == null) {
			if (other.finishTime != null) {
				return false;
			}
		} else if (!finishTime.equals(other.finishTime)) {
			return false;
		}
		if (complaintStatus == null) {
			if (other.complaintStatus != null) {
				return false;
			}
		} else if (!complaintStatus.equals(other.complaintStatus)) {
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
		if (remark1 == null) {
			if (other.remark1 != null) {
				return false;
			}
		} else if (!remark1.equals(other.remark1)) {
			return false;
		}
		if (remark2 == null) {
			if (other.remark2 != null) {
				return false;
			}
		} else if (!remark2.equals(other.remark2)) {
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
			+ ", customerId=" + customerId
			+ ", customerName=" + customerName
			+ ", customerPhonenumber=" + customerPhonenumber
			+ ", companyId=" + companyId
			+ ", companyName=" + companyName
			+ ", complaintType=" + complaintType
			+ ", createTime=" + createTime
			+ ", updateTime=" + updateTime
			+ ", finishTime=" + finishTime
			+ ", complaintStatus=" + complaintStatus
			+ ", complaintDetail=" + complaintDetail
			+ ", complaintPicture=" + complaintPicture
			+ ", serviceId=" + serviceId
			+ ", resultsDetail=" + resultsDetail
			+ ", remark=" + remark
			+ ", remark1=" + remark1
			+ ", remark2=" + remark2;
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