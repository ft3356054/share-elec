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


/**
 * AssessRecord的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "assess_record")
public class AssessRecord implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * 客户ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "ASSESS_ID", nullable = false, length = 64)
    private String assessId ;
    
    /** 
     * COMPANY_ID
     */
    @Column(name = "COMPANY_ID", nullable = true, length = 64)
    private String companyId ;
    
    /** 
     * 订单ID
     */
    @Column(name = "ORDER_ID", nullable = true, length = 64)
    private String orderId ;
    
    /** 
     * 订单投诉ID
     */
    @Column(name = "ORDER_COMPLAINT_ID", nullable = true, length = 64)
    private String orderComplaintId ;
    
    /** 
     * 客户电话
     */
    @Column(name = "ASSESS_STATUS", nullable = true, length = 2)
    private String assessStatus ;
    
    /** 
     * 客户地址
     */
    @Column(name = "ASSESS_REASON", nullable = true, length = 2)
    private String assessReason ;
    
    /** 
     * 创建时间
     */
    @Column(name = "CREATE_TIME", nullable = true, length = 19)
    private Timestamp createTime ;
    
    /** 
     * 更新时间
     */
    @Column(name = "UPDATE_TIME", nullable = true, length = 19)
    private Timestamp updateTime ;
    
    /** 
     * 结束时间
     */
    @Column(name = "FINISH_TIME", nullable = true, length = 19)
    private Timestamp finishTime ;
    
    /** 
     * 客户描述
     */
    @Column(name = "ASSESS_TYPE", nullable = true, length = 2)
    private String assessType ;
    
    /** 
     * 客户拍照
     */
    @Column(name = "ASSESS_TYPE_VALUE", nullable = true, length = 4)
    private String assessTypeValue ;
    
    /** 
     * 客户评分
     */
    @Column(name = "SERVICE_ID", nullable = true, length = 2)
    private String serviceId ;
    
    /** 
     * 客户评价标题
     */
    @Column(name = "SOLUTION_DESC", nullable = true, length = 512)
    private String solutionDesc ;
    
    /** 
     * 客户评价
     */
    @Column(name = "REMARK", nullable = true, length = 512)
    private String remark ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public AssessRecord(){
	
	}
    /**
     * @getAssessId:客户ID的get方法
     * @params
     * @return assessId
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public String getAssessId(){
        return this.assessId;
    }
    /**
     * @setAssessId:客户ID的set方法
     * @param assessId
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setAssessId(String assessId){
        if(assessId != null && assessId.trim().length() == 0){
        	this.assessId = null;
        }else{
        	this.assessId = assessId;
        }
	} 
    /**
     * @getCompanyId:COMPANY_ID的get方法
     * @params
     * @return companyId
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public String getCompanyId(){
        return this.companyId;
    }
    /**
     * @setCompanyId:COMPANY_ID的set方法
     * @param companyId
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setCompanyId(String companyId){
		this.companyId = companyId;
	} 
    /**
     * @getOrderId:订单ID的get方法
     * @params
     * @return orderId
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public String getOrderId(){
        return this.orderId;
    }
    /**
     * @setOrderId:订单ID的set方法
     * @param orderId
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setOrderId(String orderId){
		this.orderId = orderId;
	} 
    /**
     * @getOrderComplaintId:订单投诉ID的get方法
     * @params
     * @return orderComplaintId
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public String getOrderComplaintId(){
        return this.orderComplaintId;
    }
    /**
     * @setOrderComplaintId:订单投诉ID的set方法
     * @param orderComplaintId
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setOrderComplaintId(String orderComplaintId){
		this.orderComplaintId = orderComplaintId;
	} 
    /**
     * @getAssessStatus:客户电话的get方法
     * @params
     * @return assessStatus
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public String getAssessStatus(){
        return this.assessStatus;
    }
    /**
     * @setAssessStatus:客户电话的set方法
     * @param assessStatus
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setAssessStatus(String assessStatus){
		this.assessStatus = assessStatus;
	} 
    /**
     * @getAssessReason:客户地址的get方法
     * @params
     * @return assessReason
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public String getAssessReason(){
        return this.assessReason;
    }
    /**
     * @setAssessReason:客户地址的set方法
     * @param assessReason
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setAssessReason(String assessReason){
		this.assessReason = assessReason;
	} 
    /**
     * @getCreateTime:创建时间的get方法
     * @params
     * @return createTime
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public Timestamp getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:创建时间的set方法
     * @param createTime
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	} 
    /**
     * @getUpdateTime:更新时间的get方法
     * @params
     * @return updateTime
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public Timestamp getUpdateTime(){
        return this.updateTime;
    }
    /**
     * @setUpdateTime:更新时间的set方法
     * @param updateTime
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * @getFinishTime:结束时间的get方法
     * @params
     * @return finishTime
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public Timestamp getFinishTime(){
        return this.finishTime;
    }
    /**
     * @setFinishTime:结束时间的set方法
     * @param finishTime
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setFinishTime(Timestamp finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * @getAssessType:客户描述的get方法
     * @params
     * @return assessType
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public String getAssessType(){
        return this.assessType;
    }
    /**
     * @setAssessType:客户描述的set方法
     * @param assessType
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setAssessType(String assessType){
		this.assessType = assessType;
	} 
    /**
     * @getAssessTypeValue:客户拍照的get方法
     * @params
     * @return assessTypeValue
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public String getAssessTypeValue(){
        return this.assessTypeValue;
    }
    /**
     * @setAssessTypeValue:客户拍照的set方法
     * @param assessTypeValue
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setAssessTypeValue(String assessTypeValue){
		this.assessTypeValue = assessTypeValue;
	} 
    /**
     * @getServiceId:客户评分的get方法
     * @params
     * @return serviceId
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public String getServiceId(){
        return this.serviceId;
    }
    /**
     * @setServiceId:客户评分的set方法
     * @param serviceId
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setServiceId(String serviceId){
		this.serviceId = serviceId;
	} 
    /**
     * @getSolutionDesc:客户评价标题的get方法
     * @params
     * @return solutionDesc
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public String getSolutionDesc(){
        return this.solutionDesc;
    }
    /**
     * @setSolutionDesc:客户评价标题的set方法
     * @param solutionDesc
     * @return
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public void setSolutionDesc(String solutionDesc){
		this.solutionDesc = solutionDesc;
	} 
    /**
     * @getRemark:客户评价的get方法
     * @params
     * @return remark
     * @date 2021-01-15 11:35:09
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:客户评价的set方法
     * @param remark
     * @return
     * @date 2021-01-15 11:35:09
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
		
        if (obj == null || !(obj instanceof AssessRecord))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		AssessRecord other = (AssessRecord) obj;
		
		if (assessId == null) {
			if (other.assessId != null) {
				return false;
			}
		} else if (!assessId.equals(other.assessId)) {
			return false;
		}
		if (companyId == null) {
			if (other.companyId != null) {
				return false;
			}
		} else if (!companyId.equals(other.companyId)) {
			return false;
		}
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (orderComplaintId == null) {
			if (other.orderComplaintId != null) {
				return false;
			}
		} else if (!orderComplaintId.equals(other.orderComplaintId)) {
			return false;
		}
		if (assessStatus == null) {
			if (other.assessStatus != null) {
				return false;
			}
		} else if (!assessStatus.equals(other.assessStatus)) {
			return false;
		}
		if (assessReason == null) {
			if (other.assessReason != null) {
				return false;
			}
		} else if (!assessReason.equals(other.assessReason)) {
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
		if (assessType == null) {
			if (other.assessType != null) {
				return false;
			}
		} else if (!assessType.equals(other.assessType)) {
			return false;
		}
		if (assessTypeValue == null) {
			if (other.assessTypeValue != null) {
				return false;
			}
		} else if (!assessTypeValue.equals(other.assessTypeValue)) {
			return false;
		}
		if (serviceId == null) {
			if (other.serviceId != null) {
				return false;
			}
		} else if (!serviceId.equals(other.serviceId)) {
			return false;
		}
		if (solutionDesc == null) {
			if (other.solutionDesc != null) {
				return false;
			}
		} else if (!solutionDesc.equals(other.solutionDesc)) {
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
		return "AssessRecord ["
			+ ", assessId=" + assessId
			+ ", companyId=" + companyId
			+ ", orderId=" + orderId
			+ ", orderComplaintId=" + orderComplaintId
			+ ", assessStatus=" + assessStatus
			+ ", assessReason=" + assessReason
			+ ", createTime=" + createTime
			+ ", updateTime=" + updateTime
			+ ", finishTime=" + finishTime
			+ ", assessType=" + assessType
			+ ", assessTypeValue=" + assessTypeValue
			+ ", serviceId=" + serviceId
			+ ", solutionDesc=" + solutionDesc
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