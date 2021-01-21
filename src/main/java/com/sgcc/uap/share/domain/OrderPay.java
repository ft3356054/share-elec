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
 * OrderPay的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "order_pay")
public class OrderPay implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * PAY_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "PAY_ID", nullable = false, length = 64)
    private String payId ;
    
    /** 
     * ORDER_ID
     */
    @Column(name = "ORDER_ID", nullable = true, length = 64)
    private String orderId ;
    
    /** 
     * PAY_TYPE
     */
    @Column(name = "PAY_TYPE", nullable = true, length = 2)
    private String payType ;
    
    /** 
     * PAY_USER
     */
    @Column(name = "PAY_USER", nullable = true, length = 64)
    private String payUser ;
    
    /** 
     * PAY_USRE_NAME
     */
    @Column(name = "PAY_USRE_NAME", nullable = true, length = 64)
    private String payUsreName ;
    
    /** 
     * ELECTRICIAN_ID
     */
    @Column(name = "ELECTRICIAN_ID", nullable = true, length = 64)
    private String electricianId ;
    
    /** 
     * ELECTRICIAN_NAME
     */
    @Column(name = "ELECTRICIAN_NAME", nullable = true, length = 64)
    private String electricianName ;
    
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
     * INSURANCE_COMPANY_ID
     */
    @Column(name = "INSURANCE_COMPANY_ID", nullable = true, length = 64)
    private String insuranceCompanyId ;
    
    /** 
     * INSURANCE_COMPANY_NAME
     */
    @Column(name = "INSURANCE_COMPANY_NAME", nullable = true, length = 64)
    private String insuranceCompanyName ;
    
    /** 
     * PRICE
     */
    @Column(name = "PRICE", nullable = true, length = 6)
    private String price ;
    
    /** 
     * PAY_TIME
     */
    @Column(name = "PAY_TIME", nullable = true, length = 19)
    private String payTime ;
    
    /** 
     * PAY_STATUS
     */
    @Column(name = "PAY_STATUS", nullable = true, length = 2)
    private String payStatus ;
    
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
	
	public OrderPay(){
	
	}
    /**
     * @getPayId:PAY_ID的get方法
     * @params
     * @return payId
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getPayId(){
        return this.payId;
    }
    /**
     * @setPayId:PAY_ID的set方法
     * @param payId
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setPayId(String payId){
        if(payId != null && payId.trim().length() == 0){
        	this.payId = null;
        }else{
        	this.payId = payId;
        }
	} 
    /**
     * @getOrderId:ORDER_ID的get方法
     * @params
     * @return orderId
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getOrderId(){
        return this.orderId;
    }
    /**
     * @setOrderId:ORDER_ID的set方法
     * @param orderId
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setOrderId(String orderId){
		this.orderId = orderId;
	} 
    /**
     * @getPayType:PAY_TYPE的get方法
     * @params
     * @return payType
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getPayType(){
        return this.payType;
    }
    /**
     * @setPayType:PAY_TYPE的set方法
     * @param payType
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setPayType(String payType){
		this.payType = payType;
	} 
    /**
     * @getPayUser:PAY_USER的get方法
     * @params
     * @return payUser
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getPayUser(){
        return this.payUser;
    }
    /**
     * @setPayUser:PAY_USER的set方法
     * @param payUser
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setPayUser(String payUser){
		this.payUser = payUser;
	} 
    /**
     * @getPayUsreName:PAY_USRE_NAME的get方法
     * @params
     * @return payUsreName
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getPayUsreName(){
        return this.payUsreName;
    }
    /**
     * @setPayUsreName:PAY_USRE_NAME的set方法
     * @param payUsreName
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setPayUsreName(String payUsreName){
		this.payUsreName = payUsreName;
	} 
    /**
     * @getElectricianId:ELECTRICIAN_ID的get方法
     * @params
     * @return electricianId
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getElectricianId(){
        return this.electricianId;
    }
    /**
     * @setElectricianId:ELECTRICIAN_ID的set方法
     * @param electricianId
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setElectricianId(String electricianId){
		this.electricianId = electricianId;
	} 
    /**
     * @getElectricianName:ELECTRICIAN_NAME的get方法
     * @params
     * @return electricianName
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getElectricianName(){
        return this.electricianName;
    }
    /**
     * @setElectricianName:ELECTRICIAN_NAME的set方法
     * @param electricianName
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setElectricianName(String electricianName){
		this.electricianName = electricianName;
	} 
    /**
     * @getCompanyId:COMPANY_ID的get方法
     * @params
     * @return companyId
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getCompanyId(){
        return this.companyId;
    }
    /**
     * @setCompanyId:COMPANY_ID的set方法
     * @param companyId
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setCompanyId(String companyId){
		this.companyId = companyId;
	} 
    /**
     * @getCompanyName:COMPANY_NAME的get方法
     * @params
     * @return companyName
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getCompanyName(){
        return this.companyName;
    }
    /**
     * @setCompanyName:COMPANY_NAME的set方法
     * @param companyName
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setCompanyName(String companyName){
		this.companyName = companyName;
	} 
    /**
     * @getInsuranceCompanyId:INSURANCE_COMPANY_ID的get方法
     * @params
     * @return insuranceCompanyId
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getInsuranceCompanyId(){
        return this.insuranceCompanyId;
    }
    /**
     * @setInsuranceCompanyId:INSURANCE_COMPANY_ID的set方法
     * @param insuranceCompanyId
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setInsuranceCompanyId(String insuranceCompanyId){
		this.insuranceCompanyId = insuranceCompanyId;
	} 
    /**
     * @getInsuranceCompanyName:INSURANCE_COMPANY_NAME的get方法
     * @params
     * @return insuranceCompanyName
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getInsuranceCompanyName(){
        return this.insuranceCompanyName;
    }
    /**
     * @setInsuranceCompanyName:INSURANCE_COMPANY_NAME的set方法
     * @param insuranceCompanyName
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setInsuranceCompanyName(String insuranceCompanyName){
		this.insuranceCompanyName = insuranceCompanyName;
	} 
    /**
     * @getPrice:PRICE的get方法
     * @params
     * @return price
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getPrice(){
        return this.price;
    }
    /**
     * @setPrice:PRICE的set方法
     * @param price
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setPrice(String price){
		this.price = price;
	} 
    /**
     * @getPayTime:PAY_TIME的get方法
     * @params
     * @return payTime
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getPayTime(){
        return this.payTime;
    }
    /**
     * @setPayTime:PAY_TIME的set方法
     * @param payTime
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setPayTime(String payTime){
		this.payTime = payTime;
	} 
    /**
     * @getPayStatus:PAY_STATUS的get方法
     * @params
     * @return payStatus
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getPayStatus(){
        return this.payStatus;
    }
    /**
     * @setPayStatus:PAY_STATUS的set方法
     * @param payStatus
     * @return
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public void setPayStatus(String payStatus){
		this.payStatus = payStatus;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2021-01-21 15:04:55
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2021-01-21 15:04:55
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
		
        if (obj == null || !(obj instanceof OrderPay))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		OrderPay other = (OrderPay) obj;
		
		if (payId == null) {
			if (other.payId != null) {
				return false;
			}
		} else if (!payId.equals(other.payId)) {
			return false;
		}
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (payType == null) {
			if (other.payType != null) {
				return false;
			}
		} else if (!payType.equals(other.payType)) {
			return false;
		}
		if (payUser == null) {
			if (other.payUser != null) {
				return false;
			}
		} else if (!payUser.equals(other.payUser)) {
			return false;
		}
		if (payUsreName == null) {
			if (other.payUsreName != null) {
				return false;
			}
		} else if (!payUsreName.equals(other.payUsreName)) {
			return false;
		}
		if (electricianId == null) {
			if (other.electricianId != null) {
				return false;
			}
		} else if (!electricianId.equals(other.electricianId)) {
			return false;
		}
		if (electricianName == null) {
			if (other.electricianName != null) {
				return false;
			}
		} else if (!electricianName.equals(other.electricianName)) {
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
		if (insuranceCompanyId == null) {
			if (other.insuranceCompanyId != null) {
				return false;
			}
		} else if (!insuranceCompanyId.equals(other.insuranceCompanyId)) {
			return false;
		}
		if (insuranceCompanyName == null) {
			if (other.insuranceCompanyName != null) {
				return false;
			}
		} else if (!insuranceCompanyName.equals(other.insuranceCompanyName)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (payTime == null) {
			if (other.payTime != null) {
				return false;
			}
		} else if (!payTime.equals(other.payTime)) {
			return false;
		}
		if (payStatus == null) {
			if (other.payStatus != null) {
				return false;
			}
		} else if (!payStatus.equals(other.payStatus)) {
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
		return "OrderPay ["
			+ ", payId=" + payId
			+ ", orderId=" + orderId
			+ ", payType=" + payType
			+ ", payUser=" + payUser
			+ ", payUsreName=" + payUsreName
			+ ", electricianId=" + electricianId
			+ ", electricianName=" + electricianName
			+ ", companyId=" + companyId
			+ ", companyName=" + companyName
			+ ", insuranceCompanyId=" + insuranceCompanyId
			+ ", insuranceCompanyName=" + insuranceCompanyName
			+ ", price=" + price
			+ ", payTime=" + payTime
			+ ", payStatus=" + payStatus
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