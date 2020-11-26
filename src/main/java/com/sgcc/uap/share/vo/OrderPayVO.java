package com.sgcc.uap.share.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * OrderPay的VO类
 *
 * @author 18511 
 */
public class OrderPayVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性PAY_ID
     */  
    @ViewAttribute(name ="payId",caption="PAY_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String payId;    
    /** 
     * 属性PAY_TYPE
     */  
    @ViewAttribute(name ="payType",caption="PAY_TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String payType;    
    /** 
     * 属性PAY_USER
     */  
    @ViewAttribute(name ="payUser",caption="PAY_USER", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String payUser;    
    /** 
     * 属性PRICE
     */  
    @ViewAttribute(name ="price",caption="PRICE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String price;    
    /** 
     * 属性PAY_TIME
     */  
    @ViewAttribute(name ="payTime",caption="PAY_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp payTime;    
    /** 
     * 属性PAY_STATUS
     */  
    @ViewAttribute(name ="payStatus",caption="PAY_STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String payStatus;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /** 
     * 属性ORDER_ID
     */  
    @ViewAttribute(name ="orDERId",caption="ORDER_ID", editor=EditorType.ComboEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String orDERId;    
    /**
     * OrderPayVO构造函数
     */
    public OrderPayVO() {
        super();
    } 
   
	 /**
     * OrderPayVO完整的构造函数
     */  
    public OrderPayVO(String payId){
        this.payId = payId;
    }
    /**
     * PAY_ID的get方法
     * @return payId
     */
    public String getPayId(){
        return payId;
    }
    /**
     * PAY_ID的set方法
     * @param payId
     */
    public void setPayId(String payId){
        if(payId != null && payId.trim().length() == 0){
        	this.payId = null;
        }else{
        	this.payId = payId;
        }
	} 
    /**
     * PAY_TYPE的get方法
     * @return payType
     */
    public String getPayType(){
        return payType;
    }
    /**
     * PAY_TYPE的set方法
     * @param payType
     */
    public void setPayType(String payType){
		this.payType = payType;
	} 
    /**
     * PAY_USER的get方法
     * @return payUser
     */
    public String getPayUser(){
        return payUser;
    }
    /**
     * PAY_USER的set方法
     * @param payUser
     */
    public void setPayUser(String payUser){
		this.payUser = payUser;
	} 
    /**
     * PRICE的get方法
     * @return price
     */
    public String getPrice(){
        return price;
    }
    /**
     * PRICE的set方法
     * @param price
     */
    public void setPrice(String price){
		this.price = price;
	} 
    /**
     * PAY_TIME的get方法
     * @return payTime
     */
    public Timestamp getPayTime(){
        return payTime;
    }
    /**
     * PAY_TIME的set方法
     * @param payTime
     */
    public void setPayTime(Timestamp payTime){
		this.payTime = payTime;
	} 
    /**
     * PAY_STATUS的get方法
     * @return payStatus
     */
    public String getPayStatus(){
        return payStatus;
    }
    /**
     * PAY_STATUS的set方法
     * @param payStatus
     */
    public void setPayStatus(String payStatus){
		this.payStatus = payStatus;
	} 
    /**
     * REMARK的get方法
     * @return remark
     */
    public String getRemark(){
        return remark;
    }
    /**
     * REMARK的set方法
     * @param remark
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 
    /**
     * ORDER_ID的get方法
     * @return orDERId
     */
    public String getOrDERId(){
        return orDERId;
    }
    /**
     * ORDER_ID的set方法
     * @param orDERId
     */
    public void setOrDERId(String orDERId){
		this.orDERId = orDERId;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("PAY_ID"+":"+getPayId())
				.append("PAY_TYPE"+":"+getPayType())
				.append("PAY_USER"+":"+getPayUser())
				.append("PRICE"+":"+getPrice())
				.append("PAY_TIME"+":"+getPayTime())
				.append("PAY_STATUS"+":"+getPayStatus())
				.append("REMARK"+":"+getRemark())
				.append("ORDER_ID"+":"+getOrDERId())
		        .toString(); 
			
    } 
   


}
