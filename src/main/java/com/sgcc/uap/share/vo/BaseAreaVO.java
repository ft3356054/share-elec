package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * BaseArea的VO类
 *
 * @author 18511 
 */
public class BaseAreaVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性AREA_ID
     */  
    @ViewAttribute(name ="areaId",caption="AREA_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String areaId;    
    /** 
     * 属性PROVINCE_ID
     */  
    @ViewAttribute(name ="provinceId",caption="PROVINCE_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String provinceId;    
    /** 
     * 属性PROVINCE_NAME
     */  
    @ViewAttribute(name ="provinceName",caption="PROVINCE_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String provinceName;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /** 
     * 属性BAS_PROVINCE_ID
     */  
    @ViewAttribute(name ="baSProvinceId",caption="BAS_PROVINCE_ID", editor=EditorType.ComboEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String baSProvinceId;    
    /**
     * BaseAreaVO构造函数
     */
    public BaseAreaVO() {
        super();
    } 
   
	 /**
     * BaseAreaVO完整的构造函数
     */  
    public BaseAreaVO(String areaId){
        this.areaId = areaId;
    }
    /**
     * AREA_ID的get方法
     * @return areaId
     */
    public String getAreaId(){
        return areaId;
    }
    /**
     * AREA_ID的set方法
     * @param areaId
     */
    public void setAreaId(String areaId){
        if(areaId != null && areaId.trim().length() == 0){
        	this.areaId = null;
        }else{
        	this.areaId = areaId;
        }
	} 
    /**
     * PROVINCE_ID的get方法
     * @return provinceId
     */
    public String getProvinceId(){
        return provinceId;
    }
    /**
     * PROVINCE_ID的set方法
     * @param provinceId
     */
    public void setProvinceId(String provinceId){
		this.provinceId = provinceId;
	} 
    /**
     * PROVINCE_NAME的get方法
     * @return provinceName
     */
    public String getProvinceName(){
        return provinceName;
    }
    /**
     * PROVINCE_NAME的set方法
     * @param provinceName
     */
    public void setProvinceName(String provinceName){
		this.provinceName = provinceName;
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
     * BAS_PROVINCE_ID的get方法
     * @return baSProvinceId
     */
    public String getBaSProvinceId(){
        return baSProvinceId;
    }
    /**
     * BAS_PROVINCE_ID的set方法
     * @param baSProvinceId
     */
    public void setBaSProvinceId(String baSProvinceId){
		this.baSProvinceId = baSProvinceId;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("AREA_ID"+":"+getAreaId())
				.append("PROVINCE_ID"+":"+getProvinceId())
				.append("PROVINCE_NAME"+":"+getProvinceName())
				.append("REMARK"+":"+getRemark())
				.append("BAS_PROVINCE_ID"+":"+getBaSProvinceId())
		        .toString(); 
			
    } 
   


}
