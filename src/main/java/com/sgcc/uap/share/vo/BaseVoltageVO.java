package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * BaseVoltage的VO类
 *
 * @author 18511 
 */
public class BaseVoltageVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性身份ID
     */  
    @ViewAttribute(name ="voltageId",caption="身份ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String voltageId;    
    /** 
     * 属性身份名称
     */  
    @ViewAttribute(name ="voltage",caption="身份名称", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String voltage;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * BaseVoltageVO构造函数
     */
    public BaseVoltageVO() {
        super();
    } 
   
	 /**
     * BaseVoltageVO完整的构造函数
     */  
    public BaseVoltageVO(String voltageId){
        this.voltageId = voltageId;
    }
    /**
     * 身份ID的get方法
     * @return voltageId
     */
    public String getVoltageId(){
        return voltageId;
    }
    /**
     * 身份ID的set方法
     * @param voltageId
     */
    public void setVoltageId(String voltageId){
        if(voltageId != null && voltageId.trim().length() == 0){
        	this.voltageId = null;
        }else{
        	this.voltageId = voltageId;
        }
	} 
    /**
     * 身份名称的get方法
     * @return voltage
     */
    public String getVoltage(){
        return voltage;
    }
    /**
     * 身份名称的set方法
     * @param voltage
     */
    public void setVoltage(String voltage){
		this.voltage = voltage;
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
	  			.append("VOLTAGE_ID"+":"+getVoltageId())
				.append("VOLTAGE"+":"+getVoltage())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
