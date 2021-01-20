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
 * InformationNotify的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "information_notify")
public class InformationNotify implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * INFORMATION_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "INFORMATION_ID", nullable = false, length = 64)
    private String informationId ;
    
    /** 
     * INFORMATION_TYPE
     */
    @Column(name = "INFORMATION_TYPE", nullable = true, length = 64)
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
     * SERVICE_ID
     */
    @Column(name = "SERVICE_ID", nullable = true, length = 64)
    private String serviceId ;
    
    /** 
     * SERVICE_NAME
     */
    @Column(name = "SERVICE_NAME", nullable = true, length = 64)
    private String serviceName ;
    
    /** 
     * INFORMATION_TITLE
     */
    @Column(name = "INFORMATION_TITLE", nullable = true, length = 128)
    private String informationTitle ;
    
    /** 
     * INFORMATION_FROM
     */
    @Column(name = "INFORMATION_FROM", nullable = true, length = 256)
    private String informationFrom ;
    
    /** 
     * KEYWORD
     */
    @Column(name = "KEYWORD", nullable = true, length = 128)
    private String keyword ;
    
    /** 
     * INFORMATION_ICON
     */
    @Column(name = "INFORMATION_ICON", nullable = true, length = 512)
    private String informationIcon ;
    
    /** 
     * INFORMATION_CONTENT
     */
    @Column(name = "INFORMATION_CONTENT", nullable = true, length = 512)
    private String informationContent ;
    
    /** 
     * PRIORITY
     */
    @Column(name = "PRIORITY", nullable = true, length = 10)
    private Integer priority ;
    
    /** 
     * READ_COUNT
     */
    @Column(name = "READ_COUNT", nullable = true, length = 10)
    private Integer readCount ;
    
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
	
	public InformationNotify(){
	
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
        if(informationId != null && informationId.trim().length() == 0){
        	this.informationId = null;
        }else{
        	this.informationId = informationId;
        }
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
     * @getUpdateTime:UPDATE_TIME的get方法
     * @params
     * @return updateTime
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public Timestamp getUpdateTime(){
        return this.updateTime;
    }
    /**
     * @setUpdateTime:UPDATE_TIME的set方法
     * @param updateTime
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * @getFinishTime:FINISH_TIME的get方法
     * @params
     * @return finishTime
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public Timestamp getFinishTime(){
        return this.finishTime;
    }
    /**
     * @setFinishTime:FINISH_TIME的set方法
     * @param finishTime
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setFinishTime(Timestamp finishTime){
		this.finishTime = finishTime;
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
     * @getServiceName:SERVICE_NAME的get方法
     * @params
     * @return serviceName
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getServiceName(){
        return this.serviceName;
    }
    /**
     * @setServiceName:SERVICE_NAME的set方法
     * @param serviceName
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	} 
    /**
     * @getInformationTitle:INFORMATION_TITLE的get方法
     * @params
     * @return informationTitle
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getInformationTitle(){
        return this.informationTitle;
    }
    /**
     * @setInformationTitle:INFORMATION_TITLE的set方法
     * @param informationTitle
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setInformationTitle(String informationTitle){
		this.informationTitle = informationTitle;
	} 
    /**
     * @getInformationFrom:INFORMATION_FROM的get方法
     * @params
     * @return informationFrom
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getInformationFrom(){
        return this.informationFrom;
    }
    /**
     * @setInformationFrom:INFORMATION_FROM的set方法
     * @param informationFrom
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setInformationFrom(String informationFrom){
		this.informationFrom = informationFrom;
	} 
    /**
     * @getKeyword:KEYWORD的get方法
     * @params
     * @return keyword
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getKeyword(){
        return this.keyword;
    }
    /**
     * @setKeyword:KEYWORD的set方法
     * @param keyword
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setKeyword(String keyword){
		this.keyword = keyword;
	} 
    /**
     * @getInformationIcon:INFORMATION_ICON的get方法
     * @params
     * @return informationIcon
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getInformationIcon(){
        return this.informationIcon;
    }
    /**
     * @setInformationIcon:INFORMATION_ICON的set方法
     * @param informationIcon
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setInformationIcon(String informationIcon){
		this.informationIcon = informationIcon;
	} 
    /**
     * @getInformationContent:INFORMATION_CONTENT的get方法
     * @params
     * @return informationContent
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public String getInformationContent(){
        return this.informationContent;
    }
    /**
     * @setInformationContent:INFORMATION_CONTENT的set方法
     * @param informationContent
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setInformationContent(String informationContent){
		this.informationContent = informationContent;
	} 
    /**
     * @getPriority:PRIORITY的get方法
     * @params
     * @return priority
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public Integer getPriority(){
        return this.priority;
    }
    /**
     * @setPriority:PRIORITY的set方法
     * @param priority
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setPriority(Integer priority){
		this.priority = priority;
	} 
    /**
     * @getReadCount:READ_COUNT的get方法
     * @params
     * @return readCount
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public Integer getReadCount(){
        return this.readCount;
    }
    /**
     * @setReadCount:READ_COUNT的set方法
     * @param readCount
     * @return
     * @date 2021-01-20 12:31:14
     * @author 18511
     */
    public void setReadCount(Integer readCount){
		this.readCount = readCount;
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
		
        if (obj == null || !(obj instanceof InformationNotify))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		InformationNotify other = (InformationNotify) obj;
		
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
		if (serviceId == null) {
			if (other.serviceId != null) {
				return false;
			}
		} else if (!serviceId.equals(other.serviceId)) {
			return false;
		}
		if (serviceName == null) {
			if (other.serviceName != null) {
				return false;
			}
		} else if (!serviceName.equals(other.serviceName)) {
			return false;
		}
		if (informationTitle == null) {
			if (other.informationTitle != null) {
				return false;
			}
		} else if (!informationTitle.equals(other.informationTitle)) {
			return false;
		}
		if (informationFrom == null) {
			if (other.informationFrom != null) {
				return false;
			}
		} else if (!informationFrom.equals(other.informationFrom)) {
			return false;
		}
		if (keyword == null) {
			if (other.keyword != null) {
				return false;
			}
		} else if (!keyword.equals(other.keyword)) {
			return false;
		}
		if (informationIcon == null) {
			if (other.informationIcon != null) {
				return false;
			}
		} else if (!informationIcon.equals(other.informationIcon)) {
			return false;
		}
		if (informationContent == null) {
			if (other.informationContent != null) {
				return false;
			}
		} else if (!informationContent.equals(other.informationContent)) {
			return false;
		}
		if (priority == null) {
			if (other.priority != null) {
				return false;
			}
		} else if (!priority.equals(other.priority)) {
			return false;
		}
		if (readCount == null) {
			if (other.readCount != null) {
				return false;
			}
		} else if (!readCount.equals(other.readCount)) {
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
		return "InformationNotify ["
			+ ", informationId=" + informationId
			+ ", informationType=" + informationType
			+ ", informationStatus=" + informationStatus
			+ ", createTime=" + createTime
			+ ", updateTime=" + updateTime
			+ ", finishTime=" + finishTime
			+ ", serviceId=" + serviceId
			+ ", serviceName=" + serviceName
			+ ", informationTitle=" + informationTitle
			+ ", informationFrom=" + informationFrom
			+ ", keyword=" + keyword
			+ ", informationIcon=" + informationIcon
			+ ", informationContent=" + informationContent
			+ ", priority=" + priority
			+ ", readCount=" + readCount
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