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
     * PRICE
     */
    @Column(name = "PRICE", nullable = true, length = 6)
    private String price ;
    
    /** 
     * PAY_TIME
     */
    @Column(name = "PAY_TIME", nullable = true, length = 19)
    private Timestamp payTime ;
    
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
     * ORDER_ID
     */
    @Column(name = "ORDER_ID", nullable = false, length = 64)
    private String orDERId ;
    
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
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getPayId(){
        return this.payId;
    }
    /**
     * @setPayId:PAY_ID的set方法
     * @param payId
     * @return
     * @date 2020-11-26 14:32:47
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
     * @getPayType:PAY_TYPE的get方法
     * @params
     * @return payType
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getPayType(){
        return this.payType;
    }
    /**
     * @setPayType:PAY_TYPE的set方法
     * @param payType
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setPayType(String payType){
		this.payType = payType;
	} 
    /**
     * @getPayUser:PAY_USER的get方法
     * @params
     * @return payUser
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getPayUser(){
        return this.payUser;
    }
    /**
     * @setPayUser:PAY_USER的set方法
     * @param payUser
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setPayUser(String payUser){
		this.payUser = payUser;
	} 
    /**
     * @getPrice:PRICE的get方法
     * @params
     * @return price
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getPrice(){
        return this.price;
    }
    /**
     * @setPrice:PRICE的set方法
     * @param price
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setPrice(String price){
		this.price = price;
	} 
    /**
     * @getPayTime:PAY_TIME的get方法
     * @params
     * @return payTime
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public Timestamp getPayTime(){
        return this.payTime;
    }
    /**
     * @setPayTime:PAY_TIME的set方法
     * @param payTime
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setPayTime(Timestamp payTime){
		this.payTime = payTime;
	} 
    /**
     * @getPayStatus:PAY_STATUS的get方法
     * @params
     * @return payStatus
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getPayStatus(){
        return this.payStatus;
    }
    /**
     * @setPayStatus:PAY_STATUS的set方法
     * @param payStatus
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setPayStatus(String payStatus){
		this.payStatus = payStatus;
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
		return "OrderPay ["
			+ ", payId=" + payId
			+ ", payType=" + payType
			+ ", payUser=" + payUser
			+ ", price=" + price
			+ ", payTime=" + payTime
			+ ", payStatus=" + payStatus
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