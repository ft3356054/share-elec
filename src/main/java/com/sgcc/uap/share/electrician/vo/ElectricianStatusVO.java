package com.sgcc.uap.share.electrician.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * ElectricianStatus的VO类
 *
 * @author 18511 
 */
public class ElectricianStatusVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ELECTRICIAN_ID
     */  
    @ViewAttribute(name ="electricianId",caption="ELECTRICIAN_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String electricianId;    
    /** 
     * 属性ELECTRICIAN_STATUS
     */  
    @ViewAttribute(name ="electricianStatus",caption="ELECTRICIAN_STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianStatus;    
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
     * 属性ONLINE_TIME
     */  
    @ViewAttribute(name ="onlineTime",caption="ONLINE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp onlineTime;    
    /** 
     * 属性OFFLINE_TIME
     */  
    @ViewAttribute(name ="offlineTime",caption="OFFLINE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp offlineTime;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * ElectricianStatusVO构造函数
     */
    public ElectricianStatusVO() {
        super();
    } 
   
	 /**
     * ElectricianStatusVO完整的构造函数
     */  
    public ElectricianStatusVO(String electricianId){
        this.electricianId = electricianId;
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
        if(electricianId != null && electricianId.trim().length() == 0){
        	this.electricianId = null;
        }else{
        	this.electricianId = electricianId;
        }
	} 
    /**
     * ELECTRICIAN_STATUS的get方法
     * @return electricianStatus
     */
    public String getElectricianStatus(){
        return electricianStatus;
    }
    /**
     * ELECTRICIAN_STATUS的set方法
     * @param electricianStatus
     */
    public void setElectricianStatus(String electricianStatus){
		this.electricianStatus = electricianStatus;
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
     * ONLINE_TIME的get方法
     * @return onlineTime
     */
    public Timestamp getOnlineTime(){
        return onlineTime;
    }
    /**
     * ONLINE_TIME的set方法
     * @param onlineTime
     */
    public void setOnlineTime(Timestamp onlineTime){
		this.onlineTime = onlineTime;
	} 
    /**
     * OFFLINE_TIME的get方法
     * @return offlineTime
     */
    public Timestamp getOfflineTime(){
        return offlineTime;
    }
    /**
     * OFFLINE_TIME的set方法
     * @param offlineTime
     */
    public void setOfflineTime(Timestamp offlineTime){
		this.offlineTime = offlineTime;
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
	  			.append("ELECTRICIAN_ID"+":"+getElectricianId())
				.append("ELECTRICIAN_STATUS"+":"+getElectricianStatus())
				.append("ADDRESS_LONGITUDE"+":"+getAddressLongitude())
				.append("ADDRESS_LATITUDE"+":"+getAddressLatitude())
				.append("ONLINE_TIME"+":"+getOnlineTime())
				.append("OFFLINE_TIME"+":"+getOfflineTime())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
