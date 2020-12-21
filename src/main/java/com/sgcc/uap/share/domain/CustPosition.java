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
 * CustPosition的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "cust_position")
public class CustPosition implements Serializable {

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
     * CUSTOMER_ID
     */
    @Column(name = "CUSTOMER_ID", nullable = true, length = 64)
    private String customerId ;
    
    /** 
     * AREA_ID
     */
    @Column(name = "AREA_ID", nullable = true, length = 64)
    private String areaId ;
    
    /** 
     * LON
     */
    @Column(name = "LON", nullable = true, length = 64)
    private String lon ;
    
    /** 
     * LAT
     */
    @Column(name = "LAT", nullable = true, length = 64)
    private String lat ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public CustPosition(){
	
	}
    /**
     * @getOrderId:ORDER_ID的get方法
     * @params
     * @return orderId
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public String getOrderId(){
        return this.orderId;
    }
    /**
     * @setOrderId:ORDER_ID的set方法
     * @param orderId
     * @return
     * @date 2020-12-21 09:31:09
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
     * @getCustomerId:CUSTOMER_ID的get方法
     * @params
     * @return customerId
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public String getCustomerId(){
        return this.customerId;
    }
    /**
     * @setCustomerId:CUSTOMER_ID的set方法
     * @param customerId
     * @return
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public void setCustomerId(String customerId){
		this.customerId = customerId;
	} 
    /**
     * @getAreaId:AREA_ID的get方法
     * @params
     * @return areaId
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public String getAreaId(){
        return this.areaId;
    }
    /**
     * @setAreaId:AREA_ID的set方法
     * @param areaId
     * @return
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public void setAreaId(String areaId){
		this.areaId = areaId;
	} 
    /**
     * @getLon:LON的get方法
     * @params
     * @return lon
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public String getLon(){
        return this.lon;
    }
    /**
     * @setLon:LON的set方法
     * @param lon
     * @return
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public void setLon(String lon){
		this.lon = lon;
	} 
    /**
     * @getLat:LAT的get方法
     * @params
     * @return lat
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public String getLat(){
        return this.lat;
    }
    /**
     * @setLat:LAT的set方法
     * @param lat
     * @return
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public void setLat(String lat){
		this.lat = lat;
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
		
        if (obj == null || !(obj instanceof CustPosition))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		CustPosition other = (CustPosition) obj;
		
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
		if (areaId == null) {
			if (other.areaId != null) {
				return false;
			}
		} else if (!areaId.equals(other.areaId)) {
			return false;
		}
		if (lon == null) {
			if (other.lon != null) {
				return false;
			}
		} else if (!lon.equals(other.lon)) {
			return false;
		}
		if (lat == null) {
			if (other.lat != null) {
				return false;
			}
		} else if (!lat.equals(other.lat)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "CustPosition ["
			+ ", orderId=" + orderId
			+ ", customerId=" + customerId
			+ ", areaId=" + areaId
			+ ", lon=" + lon
			+ ", lat=" + lat;
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