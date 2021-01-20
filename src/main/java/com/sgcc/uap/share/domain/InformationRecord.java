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
 * InformationRecord的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "information_record")
public class InformationRecord implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * INFORMATION_RECORD_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "INFORMATION_RECORD_ID", nullable = false, length = 64)
    private String informationRecordId ;
    
    /** 
     * INFORMATION_ID
     */
    @Column(name = "INFORMATION_ID", nullable = true, length = 64)
    private String informationId ;
    
    /** 
     * INFORMATION_TYPE
     */
    @Column(name = "INFORMATION_TYPE", nullable = true, length = 2)
    private String informationType ;
    
    /** 
     * INFORMATION_STATUS
     */
    @Column(name = "INFORMATION_STATUS", nullable = true, length = 2)
    private String informationStatus ;
    
    /** 
     * CREATE_TIME
     */
    @Column(name = "CREATE_TIME", nullable = true, length = 19)
    private Timestamp createTime ;
    
    /** 
     * CREATE_SERVICE_ID
     */
    @Column(name = "CREATE_SERVICE_ID", nullable = true, length = 64)
    private String createServiceId ;
    
    /** 
     * SERVICE_ID
     */
    @Column(name = "SERVICE_ID", nullable = true, length = 64)
    private String serviceId ;
    
    /** 
     * SERVICE_DESC
     */
    @Column(name = "SERVICE_DESC", nullable = true, length = 512)
    private String serviceDesc ;
    
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
	
	public InformationRecord(){
	
	}
    /**
     * @getInformationRecordId:INFORMATION_RECORD_ID的get方法
     * @params
     * @return informationRecordId
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getInformationRecordId(){
        return this.informationRecordId;
    }
    /**
     * @setInformationRecordId:INFORMATION_RECORD_ID的set方法
     * @param informationRecordId
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setInformationRecordId(String informationRecordId){
        if(informationRecordId != null && informationRecordId.trim().length() == 0){
        	this.informationRecordId = null;
        }else{
        	this.informationRecordId = informationRecordId;
        }
	} 
    /**
     * @getInformationId:INFORMATION_ID的get方法
     * @params
     * @return informationId
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getInformationId(){
        return this.informationId;
    }
    /**
     * @setInformationId:INFORMATION_ID的set方法
     * @param informationId
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setInformationId(String informationId){
		this.informationId = informationId;
	} 
    /**
     * @getInformationType:INFORMATION_TYPE的get方法
     * @params
     * @return informationType
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getInformationType(){
        return this.informationType;
    }
    /**
     * @setInformationType:INFORMATION_TYPE的set方法
     * @param informationType
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setInformationType(String informationType){
		this.informationType = informationType;
	} 
    /**
     * @getInformationStatus:INFORMATION_STATUS的get方法
     * @params
     * @return informationStatus
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getInformationStatus(){
        return this.informationStatus;
    }
    /**
     * @setInformationStatus:INFORMATION_STATUS的set方法
     * @param informationStatus
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setInformationStatus(String informationStatus){
		this.informationStatus = informationStatus;
	} 
    /**
     * @getCreateTime:CREATE_TIME的get方法
     * @params
     * @return createTime
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public Timestamp getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:CREATE_TIME的set方法
     * @param createTime
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	} 
    /**
     * @getCreateServiceId:CREATE_SERVICE_ID的get方法
     * @params
     * @return createServiceId
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getCreateServiceId(){
        return this.createServiceId;
    }
    /**
     * @setCreateServiceId:CREATE_SERVICE_ID的set方法
     * @param createServiceId
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setCreateServiceId(String createServiceId){
		this.createServiceId = createServiceId;
	} 
    /**
     * @getServiceId:SERVICE_ID的get方法
     * @params
     * @return serviceId
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getServiceId(){
        return this.serviceId;
    }
    /**
     * @setServiceId:SERVICE_ID的set方法
     * @param serviceId
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setServiceId(String serviceId){
		this.serviceId = serviceId;
	} 
    /**
     * @getServiceDesc:SERVICE_DESC的get方法
     * @params
     * @return serviceDesc
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getServiceDesc(){
        return this.serviceDesc;
    }
    /**
     * @setServiceDesc:SERVICE_DESC的set方法
     * @param serviceDesc
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setServiceDesc(String serviceDesc){
		this.serviceDesc = serviceDesc;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2021-01-20 12:31:14
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
		
        if (obj == null || !(obj instanceof InformationRecord))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		InformationRecord other = (InformationRecord) obj;
		
		if (informationRecordId == null) {
			if (other.informationRecordId != null) {
				return false;
			}
		} else if (!informationRecordId.equals(other.informationRecordId)) {
			return false;
		}
		if (informationId == null) {
			if (other.informationId != null) {
				return false;
			}
		} else if (!informationId.equals(other.informationId)) {
			return false;
		}
		if (informationType == null) {
			if (other.informationType != null) {
				return false;
			}
		} else if (!informationType.equals(other.informationType)) {
			return false;
		}
		if (informationStatus == null) {
			if (other.informationStatus != null) {
				return false;
			}
		} else if (!informationStatus.equals(other.informationStatus)) {
			return false;
		}
		if (createTime == null) {
			if (other.createTime != null) {
				return false;
			}
		} else if (!createTime.equals(other.createTime)) {
			return false;
		}
		if (createServiceId == null) {
			if (other.createServiceId != null) {
				return false;
			}
		} else if (!createServiceId.equals(other.createServiceId)) {
			return false;
		}
		if (serviceId == null) {
			if (other.serviceId != null) {
				return false;
			}
		} else if (!serviceId.equals(other.serviceId)) {
			return false;
		}
		if (serviceDesc == null) {
			if (other.serviceDesc != null) {
				return false;
			}
		} else if (!serviceDesc.equals(other.serviceDesc)) {
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
		return "InformationRecord ["
			+ ", informationRecordId=" + informationRecordId
			+ ", informationId=" + informationId
			+ ", informationType=" + informationType
			+ ", informationStatus=" + informationStatus
			+ ", createTime=" + createTime
			+ ", createServiceId=" + createServiceId
			+ ", serviceId=" + serviceId
			+ ", serviceDesc=" + serviceDesc
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