package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * BaseIdentityDetail的VO类
 *
 * @author 18511 
 */
public class BaseIdentityDetailVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性身份ID
     */  
    @ViewAttribute(name ="identityId",caption="身份ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String identityId;    
    /** 
     * 属性身份名称
     */  
    @ViewAttribute(name ="identityName",caption="身份名称", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String identityName;    
    /**
     * BaseIdentityDetailVO构造函数
     */
    public BaseIdentityDetailVO() {
        super();
    } 
   
	 /**
     * BaseIdentityDetailVO完整的构造函数
     */  
    public BaseIdentityDetailVO(String identityId){
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
     * 身份名称的get方法
     * @return identityName
     */
    public String getIdentityName(){
        return identityName;
    }
    /**
     * 身份名称的set方法
     * @param identityName
     */
    public void setIdentityName(String identityName){
		this.identityName = identityName;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("IDENTITY_ID"+":"+getIdentityId())
				.append("IDENTITY_NAME"+":"+getIdentityName())
		        .toString(); 
			
    } 
   


}
