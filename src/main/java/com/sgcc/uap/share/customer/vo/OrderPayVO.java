package com.sgcc.uap.share.customer.vo;

import java.io.Serializable;


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
     * 属性ORDER_ID
     */  
    @ViewAttribute(name ="orderId",caption="ORDER_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String orderId;    
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
     * 属性PAY_USRE_NAME
     */  
    @ViewAttribute(name ="payUsreName",caption="PAY_USRE_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String payUsreName;    
    /** 
     * 属性ELECTRICIAN_ID
     */  
    @ViewAttribute(name ="electricianId",caption="ELECTRICIAN_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianId;    
    /** 
     * 属性ELECTRICIAN_NAME
     */  
    @ViewAttribute(name ="electricianName",caption="ELECTRICIAN_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianName;    
    /** 
     * 属性COMPANY_ID
     */  
    @ViewAttribute(name ="companyId",caption="COMPANY_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String companyId;    
    /** 
     * 属性COMPANY_NAME
     */  
    @ViewAttribute(name ="companyName",caption="COMPANY_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String companyName;    
    /** 
     * 属性INSURANCE_COMPANY_ID
     */  
    @ViewAttribute(name ="insuranceCompanyId",caption="INSURANCE_COMPANY_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String insuranceCompanyId;    
    /** 
     * 属性INSURANCE_COMPANY_NAME
     */  
    @ViewAttribute(name ="insuranceCompanyName",caption="INSURANCE_COMPANY_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String insuranceCompanyName;    
    /** 
     * 属性PRICE
     */  
    @ViewAttribute(name ="price",caption="PRICE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String price;    
    /** 
     * 属性PAY_TIME
     */  
    @ViewAttribute(name ="payTime",caption="PAY_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private String payTime;    
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
		this.orderId = orderId;
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
     * PAY_USRE_NAME的get方法
     * @return payUsreName
     */
    public String getPayUsreName(){
        return payUsreName;
    }
    /**
     * PAY_USRE_NAME的set方法
     * @param payUsreName
     */
    public void setPayUsreName(String payUsreName){
		this.payUsreName = payUsreName;
	} 
    /**
     * ELECTRICIAN_ID的get方法
     * @return electricianId
     */
    public String getElectricianId(){
        return electricianId;
    }
    /**
     * ELECTRICIAN_ID的set方法
     * @param electricianId
     */
    public void setElectricianId(String electricianId){
		this.electricianId = electricianId;
	} 
    /**
     * ELECTRICIAN_NAME的get方法
     * @return electricianName
     */
    public String getElectricianName(){
        return electricianName;
    }
    /**
     * ELECTRICIAN_NAME的set方法
     * @param electricianName
     */
    public void setElectricianName(String electricianName){
		this.electricianName = electricianName;
	} 
    /**
     * COMPANY_ID的get方法
     * @return companyId
     */
    public String getCompanyId(){
        return companyId;
    }
    /**
     * COMPANY_ID的set方法
     * @param companyId
     */
    public void setCompanyId(String companyId){
		this.companyId = companyId;
	} 
    /**
     * COMPANY_NAME的get方法
     * @return companyName
     */
    public String getCompanyName(){
        return companyName;
    }
    /**
     * COMPANY_NAME的set方法
     * @param companyName
     */
    public void setCompanyName(String companyName){
		this.companyName = companyName;
	} 
    /**
     * INSURANCE_COMPANY_ID的get方法
     * @return insuranceCompanyId
     */
    public String getInsuranceCompanyId(){
        return insuranceCompanyId;
    }
    /**
     * INSURANCE_COMPANY_ID的set方法
     * @param insuranceCompanyId
     */
    public void setInsuranceCompanyId(String insuranceCompanyId){
		this.insuranceCompanyId = insuranceCompanyId;
	} 
    /**
     * INSURANCE_COMPANY_NAME的get方法
     * @return insuranceCompanyName
     */
    public String getInsuranceCompanyName(){
        return insuranceCompanyName;
    }
    /**
     * INSURANCE_COMPANY_NAME的set方法
     * @param insuranceCompanyName
     */
    public void setInsuranceCompanyName(String insuranceCompanyName){
		this.insuranceCompanyName = insuranceCompanyName;
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
    public String getPayTime(){
        return payTime;
    }
    /**
     * PAY_TIME的set方法
     * @param payTime
     */
    public void setPayTime(String payTime){
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
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("PAY_ID"+":"+getPayId())
				.append("ORDER_ID"+":"+getOrderId())
				.append("PAY_TYPE"+":"+getPayType())
				.append("PAY_USER"+":"+getPayUser())
				.append("PAY_USRE_NAME"+":"+getPayUsreName())
				.append("ELECTRICIAN_ID"+":"+getElectricianId())
				.append("ELECTRICIAN_NAME"+":"+getElectricianName())
				.append("COMPANY_ID"+":"+getCompanyId())
				.append("COMPANY_NAME"+":"+getCompanyName())
				.append("INSURANCE_COMPANY_ID"+":"+getInsuranceCompanyId())
				.append("INSURANCE_COMPANY_NAME"+":"+getInsuranceCompanyName())
				.append("PRICE"+":"+getPrice())
				.append("PAY_TIME"+":"+getPayTime())
				.append("PAY_STATUS"+":"+getPayStatus())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
