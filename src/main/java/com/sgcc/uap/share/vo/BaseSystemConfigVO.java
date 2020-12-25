package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * BaseSystemConfig的VO类
 *
 * @author 18511 
 */
public class BaseSystemConfigVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性CONFIG_ID
     */  
    @ViewAttribute(name ="configId",caption="CONFIG_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String configId;    
    /** 
     * 属性CONFIG_NAME
     */  
    @ViewAttribute(name ="configName",caption="CONFIG_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String configName;    
    /** 
     * 属性CONFIG_VALUE
     */  
    @ViewAttribute(name ="configValue",caption="CONFIG_VALUE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String configValue;    
    /** 
     * 属性CONFIG_TYPE
     */  
    @ViewAttribute(name ="configType",caption="CONFIG_TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String configType;    
    /** 
     * 属性CONFIG_STATUS
     */  
    @ViewAttribute(name ="configStatus",caption="CONFIG_STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String configStatus;    
    /**
     * BaseSystemConfigVO构造函数
     */
    public BaseSystemConfigVO() {
        super();
    } 
   
	 /**
     * BaseSystemConfigVO完整的构造函数
     */  
    public BaseSystemConfigVO(String configId){
        this.configId = configId;
    }
    /**
     * CONFIG_ID的get方法
     * @return configId
     */
    public String getConfigId(){
        return configId;
    }
    /**
     * CONFIG_ID的set方法
     * @param configId
     */
    public void setConfigId(String configId){
        if(configId != null && configId.trim().length() == 0){
        	this.configId = null;
        }else{
        	this.configId = configId;
        }
	} 
    /**
     * CONFIG_NAME的get方法
     * @return configName
     */
    public String getConfigName(){
        return configName;
    }
    /**
     * CONFIG_NAME的set方法
     * @param configName
     */
    public void setConfigName(String configName){
		this.configName = configName;
	} 
    /**
     * CONFIG_VALUE的get方法
     * @return configValue
     */
    public String getConfigValue(){
        return configValue;
    }
    /**
     * CONFIG_VALUE的set方法
     * @param configValue
     */
    public void setConfigValue(String configValue){
		this.configValue = configValue;
	} 
    /**
     * CONFIG_TYPE的get方法
     * @return configType
     */
    public String getConfigType(){
        return configType;
    }
    /**
     * CONFIG_TYPE的set方法
     * @param configType
     */
    public void setConfigType(String configType){
		this.configType = configType;
	} 
    /**
     * CONFIG_STATUS的get方法
     * @return configStatus
     */
    public String getConfigStatus(){
        return configStatus;
    }
    /**
     * CONFIG_STATUS的set方法
     * @param configStatus
     */
    public void setConfigStatus(String configStatus){
		this.configStatus = configStatus;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("CONFIG_ID"+":"+getConfigId())
				.append("CONFIG_NAME"+":"+getConfigName())
				.append("CONFIG_VALUE"+":"+getConfigValue())
				.append("CONFIG_TYPE"+":"+getConfigType())
				.append("CONFIG_STATUS"+":"+getConfigStatus())
		        .toString(); 
			
    } 
   


}
