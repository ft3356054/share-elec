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
 * BaseSystemConfig的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "base_system_config")
public class BaseSystemConfig implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * CONFIG_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "CONFIG_ID", nullable = false, length = 64)
    private String configId ;
    
    /** 
     * CONFIG_NAME
     */
    @Column(name = "CONFIG_NAME", nullable = true, length = 64)
    private String configName ;
    
    /** 
     * CONFIG_VALUE
     */
    @Column(name = "CONFIG_VALUE", nullable = true, length = 64)
    private String configValue ;
    
    /** 
     * CONFIG_TYPE
     */
    @Column(name = "CONFIG_TYPE", nullable = true, length = 4)
    private String configType ;
    
    /** 
     * CONFIG_STATUS
     */
    @Column(name = "CONFIG_STATUS", nullable = true, length = 2)
    private String configStatus ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public BaseSystemConfig(){
	
	}
    /**
     * @getConfigId:CONFIG_ID的get方法
     * @params
     * @return configId
     * @date 2020-12-24 17:04:33
     * @author 18511
     */
    public String getConfigId(){
        return this.configId;
    }
    /**
     * @setConfigId:CONFIG_ID的set方法
     * @param configId
     * @return
     * @date 2020-12-24 17:04:33
     * @author 18511
     */
    public void setConfigId(String configId){
        if(configId != null && configId.trim().length() == 0){
        	this.configId = null;
        }else{
        	this.configId = configId;
        }
	} 
    /**
     * @getConfigName:CONFIG_NAME的get方法
     * @params
     * @return configName
     * @date 2020-12-24 17:04:33
     * @author 18511
     */
    public String getConfigName(){
        return this.configName;
    }
    /**
     * @setConfigName:CONFIG_NAME的set方法
     * @param configName
     * @return
     * @date 2020-12-24 17:04:33
     * @author 18511
     */
    public void setConfigName(String configName){
		this.configName = configName;
	} 
    /**
     * @getConfigValue:CONFIG_VALUE的get方法
     * @params
     * @return configValue
     * @date 2020-12-24 17:04:33
     * @author 18511
     */
    public String getConfigValue(){
        return this.configValue;
    }
    /**
     * @setConfigValue:CONFIG_VALUE的set方法
     * @param configValue
     * @return
     * @date 2020-12-24 17:04:33
     * @author 18511
     */
    public void setConfigValue(String configValue){
		this.configValue = configValue;
	} 
    /**
     * @getConfigType:CONFIG_TYPE的get方法
     * @params
     * @return configType
     * @date 2020-12-24 17:04:33
     * @author 18511
     */
    public String getConfigType(){
        return this.configType;
    }
    /**
     * @setConfigType:CONFIG_TYPE的set方法
     * @param configType
     * @return
     * @date 2020-12-24 17:04:33
     * @author 18511
     */
    public void setConfigType(String configType){
		this.configType = configType;
	} 
    /**
     * @getConfigStatus:CONFIG_STATUS的get方法
     * @params
     * @return configStatus
     * @date 2020-12-24 17:04:33
     * @author 18511
     */
    public String getConfigStatus(){
        return this.configStatus;
    }
    /**
     * @setConfigStatus:CONFIG_STATUS的set方法
     * @param configStatus
     * @return
     * @date 2020-12-24 17:04:33
     * @author 18511
     */
    public void setConfigStatus(String configStatus){
		this.configStatus = configStatus;
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
		
        if (obj == null || !(obj instanceof BaseSystemConfig))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		BaseSystemConfig other = (BaseSystemConfig) obj;
		
		if (configId == null) {
			if (other.configId != null) {
				return false;
			}
		} else if (!configId.equals(other.configId)) {
			return false;
		}
		if (configName == null) {
			if (other.configName != null) {
				return false;
			}
		} else if (!configName.equals(other.configName)) {
			return false;
		}
		if (configValue == null) {
			if (other.configValue != null) {
				return false;
			}
		} else if (!configValue.equals(other.configValue)) {
			return false;
		}
		if (configType == null) {
			if (other.configType != null) {
				return false;
			}
		} else if (!configType.equals(other.configType)) {
			return false;
		}
		if (configStatus == null) {
			if (other.configStatus != null) {
				return false;
			}
		} else if (!configStatus.equals(other.configStatus)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "BaseSystemConfig ["
			+ ", configId=" + configId
			+ ", configName=" + configName
			+ ", configValue=" + configValue
			+ ", configType=" + configType
			+ ", configStatus=" + configStatus;
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