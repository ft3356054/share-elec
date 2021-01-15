package com.sgcc.uap.share.customer.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(VideoLocationKey.class)
public class EvaluateTaskBo{

	/** 
     * ORDER_ID
     */
	@Id
    @Column(name = "ORDER_ID", nullable = true, length = 64)
    private String orderId ;
    
    /** 
     * COMPLAINT_STATUS
     */
	@Id
    @Column(name = "COMPLAINT_STATUS", nullable = true, length = 2)
    private String complaintStatus ;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}
    
}
