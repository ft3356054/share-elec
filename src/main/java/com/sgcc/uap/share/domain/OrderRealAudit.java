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
 * OrderRealAudit的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "order_real_audit")
public class OrderRealAudit implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * ORDER_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "ORDER_ID", nullable = false, length = 64)
    private String orderId ;
    
    /** 
     * ORDER_STATUS
     */
    @Column(name = "ORDER_STATUS", nullable = true, length = 2)
    private String orderStatus ;
    
    /** 
     * CREATE_TIME
     */
    @Column(name = "CREATE_TIME", nullable = true, length = 19)
    private String createTime ;
    
    /** 
     * UPDATE_TIME
     */
    @Column(name = "UPDATE_TIME", nullable = true, length = 19)
    private String updateTime ;
    
    /** 
     * FINISH_TIME
     */
    @Column(name = "FINISH_TIME", nullable = true, length = 19)
    private String finishTime ;
    
    /** 
     * AUDITOR_ID
     */
    @Column(name = "AUDITOR_ID", nullable = true, length = 64)
    private String auditorId ;
    
    /** 
     * AUDITOR_COMMENT
     */
    @Column(name = "AUDITOR_COMMENT", nullable = true, length = 256)
    private String auditorComment ;
    
    /** 
     * USER_ID
     */
    @Column(name = "USER_ID", nullable = true, length = 64)
    private String userId ;
    
    /** 
     * USER_NAME
     */
    @Column(name = "USER_NAME", nullable = true, length = 64)
    private String userName ;
    
    /** 
     * USER_TYPE
     */
    @Column(name = "USER_TYPE", nullable = true, length = 2)
    private String userType ;
    
    /** 
     * COMPANY_ID
     */
    @Column(name = "COMPANY_ID", nullable = true, length = 64)
    private String companyId ;
    
    /** 
     * PHONENUMBER
     */
    @Column(name = "PHONENUMBER", nullable = true, length = 64)
    private String phonenumber ;
    
    /** 
     * EMAIL
     */
    @Column(name = "EMAIL", nullable = true, length = 128)
    private String email ;
    
    /** 
     * ADDRESS
     */
    @Column(name = "ADDRESS", nullable = true, length = 256)
    private String address ;
    
    /** 
     * ID_CARD_NUM
     */
    @Column(name = "ID_CARD_NUM", nullable = true, length = 64)
    private String idCardNum ;
    
    /** 
     * ID_CARD_FIRST
     */
    @Column(name = "ID_CARD_FIRST", nullable = true, length = 512)
    private String idCardFirst ;
    
    /** 
     * ID_CARD_SECOND
     */
    @Column(name = "ID_CARD_SECOND", nullable = true, length = 512)
    private String idCardSecond ;
    
    /** 
     * USER_ICON
     */
    @Column(name = "USER_ICON", nullable = true, length = 512)
    private String userIcon ;
    
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
	
	public OrderRealAudit(){
	
	}
    /**
     * @getOrderId:ORDER_ID的get方法
     * @params
     * @return orderId
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getOrderId(){
        return this.orderId;
    }
    /**
     * @setOrderId:ORDER_ID的set方法
     * @param orderId
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setOrderId(String orderId){
        if(orderId != null && orderId.trim().length() == 0){
        	this.orderId = null;
        }else{
        	this.orderId = orderId;
        }
	} 
    /**
     * @getOrderStatus:ORDER_STATUS的get方法
     * @params
     * @return orderStatus
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getOrderStatus(){
        return this.orderStatus;
    }
    /**
     * @setOrderStatus:ORDER_STATUS的set方法
     * @param orderStatus
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setOrderStatus(String orderStatus){
		this.orderStatus = orderStatus;
	} 
    /**
     * @getCreateTime:CREATE_TIME的get方法
     * @params
     * @return createTime
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:CREATE_TIME的set方法
     * @param createTime
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setCreateTime(String createTime){
		this.createTime = createTime;
	} 
    /**
     * @getUpdateTime:UPDATE_TIME的get方法
     * @params
     * @return updateTime
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getUpdateTime(){
        return this.updateTime;
    }
    /**
     * @setUpdateTime:UPDATE_TIME的set方法
     * @param updateTime
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * @getFinishTime:FINISH_TIME的get方法
     * @params
     * @return finishTime
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getFinishTime(){
        return this.finishTime;
    }
    /**
     * @setFinishTime:FINISH_TIME的set方法
     * @param finishTime
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setFinishTime(String finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * @getAuditorId:AUDITOR_ID的get方法
     * @params
     * @return auditorId
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getAuditorId(){
        return this.auditorId;
    }
    /**
     * @setAuditorId:AUDITOR_ID的set方法
     * @param auditorId
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setAuditorId(String auditorId){
		this.auditorId = auditorId;
	} 
    /**
     * @getAuditorComment:AUDITOR_COMMENT的get方法
     * @params
     * @return auditorComment
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getAuditorComment(){
        return this.auditorComment;
    }
    /**
     * @setAuditorComment:AUDITOR_COMMENT的set方法
     * @param auditorComment
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setAuditorComment(String auditorComment){
		this.auditorComment = auditorComment;
	} 
    /**
     * @getUserId:USER_ID的get方法
     * @params
     * @return userId
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getUserId(){
        return this.userId;
    }
    /**
     * @setUserId:USER_ID的set方法
     * @param userId
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setUserId(String userId){
		this.userId = userId;
	} 
    /**
     * @getUserName:USER_NAME的get方法
     * @params
     * @return userName
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getUserName(){
        return this.userName;
    }
    /**
     * @setUserName:USER_NAME的set方法
     * @param userName
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setUserName(String userName){
		this.userName = userName;
	} 
    /**
     * @getUserType:USER_TYPE的get方法
     * @params
     * @return userType
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getUserType(){
        return this.userType;
    }
    /**
     * @setUserType:USER_TYPE的set方法
     * @param userType
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setUserType(String userType){
		this.userType = userType;
	} 
    /**
     * @getCompanyId:COMPANY_ID的get方法
     * @params
     * @return companyId
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getCompanyId(){
        return this.companyId;
    }
    /**
     * @setCompanyId:COMPANY_ID的set方法
     * @param companyId
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setCompanyId(String companyId){
		this.companyId = companyId;
	} 
    /**
     * @getPhonenumber:PHONENUMBER的get方法
     * @params
     * @return phonenumber
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getPhonenumber(){
        return this.phonenumber;
    }
    /**
     * @setPhonenumber:PHONENUMBER的set方法
     * @param phonenumber
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setPhonenumber(String phonenumber){
		this.phonenumber = phonenumber;
	} 
    /**
     * @getEmail:EMAIL的get方法
     * @params
     * @return email
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getEmail(){
        return this.email;
    }
    /**
     * @setEmail:EMAIL的set方法
     * @param email
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setEmail(String email){
		this.email = email;
	} 
    /**
     * @getAddress:ADDRESS的get方法
     * @params
     * @return address
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getAddress(){
        return this.address;
    }
    /**
     * @setAddress:ADDRESS的set方法
     * @param address
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setAddress(String address){
		this.address = address;
	} 
    /**
     * @getIdCardNum:ID_CARD_NUM的get方法
     * @params
     * @return idCardNum
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getIdCardNum(){
        return this.idCardNum;
    }
    /**
     * @setIdCardNum:ID_CARD_NUM的set方法
     * @param idCardNum
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setIdCardNum(String idCardNum){
		this.idCardNum = idCardNum;
	} 
    /**
     * @getIdCardFirst:ID_CARD_FIRST的get方法
     * @params
     * @return idCardFirst
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getIdCardFirst(){
        return this.idCardFirst;
    }
    /**
     * @setIdCardFirst:ID_CARD_FIRST的set方法
     * @param idCardFirst
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setIdCardFirst(String idCardFirst){
		this.idCardFirst = idCardFirst;
	} 
    /**
     * @getIdCardSecond:ID_CARD_SECOND的get方法
     * @params
     * @return idCardSecond
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getIdCardSecond(){
        return this.idCardSecond;
    }
    /**
     * @setIdCardSecond:ID_CARD_SECOND的set方法
     * @param idCardSecond
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setIdCardSecond(String idCardSecond){
		this.idCardSecond = idCardSecond;
	} 
    /**
     * @getUserIcon:USER_ICON的get方法
     * @params
     * @return userIcon
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getUserIcon(){
        return this.userIcon;
    }
    /**
     * @setUserIcon:USER_ICON的set方法
     * @param userIcon
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setUserIcon(String userIcon){
		this.userIcon = userIcon;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2021-02-02 11:49:33
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
		
        if (obj == null || !(obj instanceof OrderRealAudit))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		OrderRealAudit other = (OrderRealAudit) obj;
		
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (orderStatus == null) {
			if (other.orderStatus != null) {
				return false;
			}
		} else if (!orderStatus.equals(other.orderStatus)) {
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
		if (auditorId == null) {
			if (other.auditorId != null) {
				return false;
			}
		} else if (!auditorId.equals(other.auditorId)) {
			return false;
		}
		if (auditorComment == null) {
			if (other.auditorComment != null) {
				return false;
			}
		} else if (!auditorComment.equals(other.auditorComment)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		if (userType == null) {
			if (other.userType != null) {
				return false;
			}
		} else if (!userType.equals(other.userType)) {
			return false;
		}
		if (companyId == null) {
			if (other.companyId != null) {
				return false;
			}
		} else if (!companyId.equals(other.companyId)) {
			return false;
		}
		if (phonenumber == null) {
			if (other.phonenumber != null) {
				return false;
			}
		} else if (!phonenumber.equals(other.phonenumber)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (idCardNum == null) {
			if (other.idCardNum != null) {
				return false;
			}
		} else if (!idCardNum.equals(other.idCardNum)) {
			return false;
		}
		if (idCardFirst == null) {
			if (other.idCardFirst != null) {
				return false;
			}
		} else if (!idCardFirst.equals(other.idCardFirst)) {
			return false;
		}
		if (idCardSecond == null) {
			if (other.idCardSecond != null) {
				return false;
			}
		} else if (!idCardSecond.equals(other.idCardSecond)) {
			return false;
		}
		if (userIcon == null) {
			if (other.userIcon != null) {
				return false;
			}
		} else if (!userIcon.equals(other.userIcon)) {
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
		return "OrderRealAudit ["
			+ ", orderId=" + orderId
			+ ", orderStatus=" + orderStatus
			+ ", createTime=" + createTime
			+ ", updateTime=" + updateTime
			+ ", finishTime=" + finishTime
			+ ", auditorId=" + auditorId
			+ ", auditorComment=" + auditorComment
			+ ", userId=" + userId
			+ ", userName=" + userName
			+ ", userType=" + userType
			+ ", companyId=" + companyId
			+ ", phonenumber=" + phonenumber
			+ ", email=" + email
			+ ", address=" + address
			+ ", idCardNum=" + idCardNum
			+ ", idCardFirst=" + idCardFirst
			+ ", idCardSecond=" + idCardSecond
			+ ", userIcon=" + userIcon
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