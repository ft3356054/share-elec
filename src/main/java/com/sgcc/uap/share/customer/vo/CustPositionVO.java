package com.sgcc.uap.share.customer.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * CustPosition的VO类
 *
 * @author 18511 
 */
public class CustPositionVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ORDER_ID
     */  
    @ViewAttribute(name ="orderId",caption="ORDER_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String orderId;    
    /** 
     * 属性CUSTOMER_ID
     */  
    @ViewAttribute(name ="customerId",caption="CUSTOMER_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerId;    
    /** 
     * 属性AREA_ID
     */  
    @ViewAttribute(name ="areaId",caption="AREA_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String areaId;    
    /** 
     * 属性LON
     */  
    @ViewAttribute(name ="lon",caption="LON", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String lon;    
    /** 
     * 属性LAT
     */  
    @ViewAttribute(name ="lat",caption="LAT", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String lat;    
    /**
     * CustPositionVO构造函数
     */
    public CustPositionVO() {
        super();
    } 
   
	 /**
     * CustPositionVO完整的构造函数
     */  
    public CustPositionVO(String orderId){
        this.orderId = orderId;
    }
    /**
     * ORDER_ID的get方法
     * @return orderId
     */
    public String getOrderId(){
        return orderId;
    }
    /**
     * ORDER_ID的set方法
     * @param orderId
     */
    public void setOrderId(String orderId){
        if(orderId != null && orderId.trim().length() == 0){
        	this.orderId = null;
        }else{
        	this.orderId = orderId;
        }
	} 
    /**
     * CUSTOMER_ID的get方法
     * @return customerId
     */
    public String getCustomerId(){
        return customerId;
    }
    /**
     * CUSTOMER_ID的set方法
     * @param customerId
     */
    public void setCustomerId(String customerId){
		this.customerId = customerId;
	} 
    /**
     * AREA_ID的get方法
     * @return areaId
     */
    public String getAreaId(){
        return areaId;
    }
    /**
     * AREA_ID的set方法
     * @param areaId
     */
    public void setAreaId(String areaId){
		this.areaId = areaId;
	} 
    /**
     * LON的get方法
     * @return lon
     */
    public String getLon(){
        return lon;
    }
    /**
     * LON的set方法
     * @param lon
     */
    public void setLon(String lon){
		this.lon = lon;
	} 
    /**
     * LAT的get方法
     * @return lat
     */
    public String getLat(){
        return lat;
    }
    /**
     * LAT的set方法
     * @param lat
     */
    public void setLat(String lat){
		this.lat = lat;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("ORDER_ID"+":"+getOrderId())
				.append("CUSTOMER_ID"+":"+getCustomerId())
				.append("AREA_ID"+":"+getAreaId())
				.append("LON"+":"+getLon())
				.append("LAT"+":"+getLat())
		        .toString(); 
			
    } 
   


}
