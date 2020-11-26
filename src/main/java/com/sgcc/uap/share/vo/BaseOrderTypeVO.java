package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * BaseOrderType的VO类
 *
 * @author 18511 
 */
public class BaseOrderTypeVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性订单类型ID
     */  
    @ViewAttribute(name ="orderTypeId",caption="订单类型ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String orderTypeId;    
    /** 
     * 属性订单类型名称
     */  
    @ViewAttribute(name ="orderTypeName",caption="订单类型名称", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String orderTypeName;    
    /**
     * BaseOrderTypeVO构造函数
     */
    public BaseOrderTypeVO() {
        super();
    } 
   
	 /**
     * BaseOrderTypeVO完整的构造函数
     */  
    public BaseOrderTypeVO(String orderTypeId){
        this.orderTypeId = orderTypeId;
    }
    /**
     * 订单类型ID的get方法
     * @return orderTypeId
     */
    public String getOrderTypeId(){
        return orderTypeId;
    }
    /**
     * 订单类型ID的set方法
     * @param orderTypeId
     */
    public void setOrderTypeId(String orderTypeId){
        if(orderTypeId != null && orderTypeId.trim().length() == 0){
        	this.orderTypeId = null;
        }else{
        	this.orderTypeId = orderTypeId;
        }
	} 
    /**
     * 订单类型名称的get方法
     * @return orderTypeName
     */
    public String getOrderTypeName(){
        return orderTypeName;
    }
    /**
     * 订单类型名称的set方法
     * @param orderTypeName
     */
    public void setOrderTypeName(String orderTypeName){
		this.orderTypeName = orderTypeName;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("ORDER_TYPE_ID"+":"+getOrderTypeId())
				.append("ORDER_TYPE_NAME"+":"+getOrderTypeName())
		        .toString(); 
			
    } 
   


}
