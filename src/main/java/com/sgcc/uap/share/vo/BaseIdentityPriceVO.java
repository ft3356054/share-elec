package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * BaseIdentityPrice的VO类
 *
 * @author 18511 
 */
public class BaseIdentityPriceVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性身份ID
     */  
    @ViewAttribute(name ="identityId",caption="身份ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String identityId;    
    /** 
     * 属性身份定价
     */  
    @ViewAttribute(name ="identityPrice",caption="身份定价", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String identityPrice;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * BaseIdentityPriceVO构造函数
     */
    public BaseIdentityPriceVO() {
        super();
    } 
   
	 /**
     * BaseIdentityPriceVO完整的构造函数
     */  
    public BaseIdentityPriceVO(String identityId){
        this.identityId = identityId;
    }
    /**
     * 身份ID的get方法
     * @return identityId
     */
    public String getIdentityId(){
        return identityId;
    }
    /**
     * 身份ID的set方法
     * @param identityId
     */
    public void setIdentityId(String identityId){
        if(identityId != null && identityId.trim().length() == 0){
        	this.identityId = null;
        }else{
        	this.identityId = identityId;
        }
	} 
    /**
     * 身份定价的get方法
     * @return identityPrice
     */
    public String getIdentityPrice(){
        return identityPrice;
    }
    /**
     * 身份定价的set方法
     * @param identityPrice
     */
    public void setIdentityPrice(String identityPrice){
		this.identityPrice = identityPrice;
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
	  			.append("IDENTITY_ID"+":"+getIdentityId())
				.append("IDENTITY_PRICE"+":"+getIdentityPrice())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
