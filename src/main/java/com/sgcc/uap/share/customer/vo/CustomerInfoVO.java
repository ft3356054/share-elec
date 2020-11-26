package com.sgcc.uap.share.customer.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * CustomerInfo的VO类
 *
 * @author 18511 
 */
public class CustomerInfoVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性CUSTOMER_ID
     */  
    @ViewAttribute(name ="customerId",caption="CUSTOMER_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String customerId;    
    /** 
     * 属性CUSTOMER_NAME
     */  
    @ViewAttribute(name ="customerName",caption="CUSTOMER_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerName;    
    /** 
     * 属性CUSTOMER_PHONENUMBER
     */  
    @ViewAttribute(name ="customerPhonenumber",caption="CUSTOMER_PHONENUMBER", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerPhonenumber;    
    /** 
     * 属性ADDRESS_LONGITUDE
     */  
    @ViewAttribute(name ="addressLongitude",caption="ADDRESS_LONGITUDE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String addressLongitude;    
    /** 
     * 属性ADDRESS_LATITUDE
     */  
    @ViewAttribute(name ="addressLatitude",caption="ADDRESS_LATITUDE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String addressLatitude;    
    /** 
     * 属性IDENTITY_ID
     */  
    @ViewAttribute(name ="identityId",caption="IDENTITY_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String identityId;    
    /** 
     * 属性CUSTOMER_SCORE
     */  
    @ViewAttribute(name ="customerScore",caption="CUSTOMER_SCORE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerScore;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /** 
     * 属性CUSTOMER_ADDRESS
     */  
    @ViewAttribute(name ="customerAddress",caption="CUSTOMER_ADDRESS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerAddress;    
    /**
     * CustomerInfoVO构造函数
     */
    public CustomerInfoVO() {
        super();
    } 
   
	 /**
     * CustomerInfoVO完整的构造函数
     */  
    public CustomerInfoVO(String customerId){
        this.customerId = customerId;
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
        if(customerId != null && customerId.trim().length() == 0){
        	this.customerId = null;
        }else{
        	this.customerId = customerId;
        }
	} 
    /**
     * CUSTOMER_NAME的get方法
     * @return customerName
     */
    public String getCustomerName(){
        return customerName;
    }
    /**
     * CUSTOMER_NAME的set方法
     * @param customerName
     */
    public void setCustomerName(String customerName){
		this.customerName = customerName;
	} 
    /**
     * CUSTOMER_PHONENUMBER的get方法
     * @return customerPhonenumber
     */
    public String getCustomerPhonenumber(){
        return customerPhonenumber;
    }
    /**
     * CUSTOMER_PHONENUMBER的set方法
     * @param customerPhonenumber
     */
    public void setCustomerPhonenumber(String customerPhonenumber){
		this.customerPhonenumber = customerPhonenumber;
	} 
    /**
     * ADDRESS_LONGITUDE的get方法
     * @return addressLongitude
     */
    public String getAddressLongitude(){
        return addressLongitude;
    }
    /**
     * ADDRESS_LONGITUDE的set方法
     * @param addressLongitude
     */
    public void setAddressLongitude(String addressLongitude){
		this.addressLongitude = addressLongitude;
	} 
    /**
     * ADDRESS_LATITUDE的get方法
     * @return addressLatitude
     */
    public String getAddressLatitude(){
        return addressLatitude;
    }
    /**
     * ADDRESS_LATITUDE的set方法
     * @param addressLatitude
     */
    public void setAddressLatitude(String addressLatitude){
		this.addressLatitude = addressLatitude;
	} 
    /**
     * IDENTITY_ID的get方法
     * @return identityId
     */
    public String getIdentityId(){
        return identityId;
    }
    /**
     * IDENTITY_ID的set方法
     * @param identityId
     */
    public void setIdentityId(String identityId){
		this.identityId = identityId;
	} 
    /**
     * CUSTOMER_SCORE的get方法
     * @return customerScore
     */
    public String getCustomerScore(){
        return customerScore;
    }
    /**
     * CUSTOMER_SCORE的set方法
     * @param customerScore
     */
    public void setCustomerScore(String customerScore){
		this.customerScore = customerScore;
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
     * CUSTOMER_ADDRESS的get方法
     * @return customerAddress
     */
    public String getCustomerAddress(){
        return customerAddress;
    }
    /**
     * CUSTOMER_ADDRESS的set方法
     * @param customerAddress
     */
    public void setCustomerAddress(String customerAddress){
		this.customerAddress = customerAddress;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("CUSTOMER_ID"+":"+getCustomerId())
				.append("CUSTOMER_NAME"+":"+getCustomerName())
				.append("CUSTOMER_PHONENUMBER"+":"+getCustomerPhonenumber())
				.append("ADDRESS_LONGITUDE"+":"+getAddressLongitude())
				.append("ADDRESS_LATITUDE"+":"+getAddressLatitude())
				.append("IDENTITY_ID"+":"+getIdentityId())
				.append("CUSTOMER_SCORE"+":"+getCustomerScore())
				.append("REMARK"+":"+getRemark())
				.append("CUSTOMER_ADDRESS"+":"+getCustomerAddress())
		        .toString(); 
			
    } 
   


}
