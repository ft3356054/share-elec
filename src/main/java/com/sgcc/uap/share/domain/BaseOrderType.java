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
 * BaseOrderType的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "base_order_type")
public class BaseOrderType implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * 订单类型ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "identity")
    @Column(name = "ORDER_TYPE_ID", nullable = false, length = 2)
    private String orderTypeId ;
    
    /** 
     * 订单类型名称
     */
    @Column(name = "ORDER_TYPE_NAME", nullable = true, length = 10)
    private String orderTypeName ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public BaseOrderType(){
	
	}
    /**
     * @getOrderTypeId:订单类型ID的get方法
     * @params
     * @return orderTypeId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getOrderTypeId(){
        return this.orderTypeId;
    }
    /**
     * @setOrderTypeId:订单类型ID的set方法
     * @param orderTypeId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setOrderTypeId(String orderTypeId){
        if(orderTypeId != null && orderTypeId.trim().length() == 0){
        	this.orderTypeId = null;
        }else{
        	this.orderTypeId = orderTypeId;
        }
	} 
    /**
     * @getOrderTypeName:订单类型名称的get方法
     * @params
     * @return orderTypeName
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getOrderTypeName(){
        return this.orderTypeName;
    }
    /**
     * @setOrderTypeName:订单类型名称的set方法
     * @param orderTypeName
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setOrderTypeName(String orderTypeName){
		this.orderTypeName = orderTypeName;
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
		
        if (obj == null || !(obj instanceof BaseOrderType))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		BaseOrderType other = (BaseOrderType) obj;
		
		if (orderTypeId == null) {
			if (other.orderTypeId != null) {
				return false;
			}
		} else if (!orderTypeId.equals(other.orderTypeId)) {
			return false;
		}
		if (orderTypeName == null) {
			if (other.orderTypeName != null) {
				return false;
			}
		} else if (!orderTypeName.equals(other.orderTypeName)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "BaseOrderType ["
			+ ", orderTypeId=" + orderTypeId
			+ ", orderTypeName=" + orderTypeName;
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