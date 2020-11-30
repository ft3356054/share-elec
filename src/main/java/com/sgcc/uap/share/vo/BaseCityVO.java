package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * BaseCity的VO类
 *
 * @author 18511 
 */
public class BaseCityVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ID
     */  
    @ViewAttribute(name ="id",caption="ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性CITY_ID
     */  
    @ViewAttribute(name ="cityId",caption="CITY_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String cityId;    
    /** 
     * 属性PROVINCE_ID
     */  
    @ViewAttribute(name ="provinceId",caption="PROVINCE_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String provinceId;    
    /** 
     * 属性CITY_NAME
     */  
    @ViewAttribute(name ="cityName",caption="CITY_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String cityName;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * BaseCityVO构造函数
     */
    public BaseCityVO() {
        super();
    } 
   
	 /**
     * BaseCityVO完整的构造函数
     */  
    public BaseCityVO(String id){
        this.id = id;
    }
    /**
     * ID的get方法
     * @return id
     */
    public String getId(){
        return id;
    }
    /**
     * ID的set方法
     * @param id
     */
    public void setId(String id){
        if(id != null && id.trim().length() == 0){
        	this.id = null;
        }else{
        	this.id = id;
        }
	} 
    /**
     * CITY_ID的get方法
     * @return cityId
     */
    public String getCityId(){
        return cityId;
    }
    /**
     * CITY_ID的set方法
     * @param cityId
     */
    public void setCityId(String cityId){
		this.cityId = cityId;
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
     * CITY_NAME的get方法
     * @return cityName
     */
    public String getCityName(){
        return cityName;
    }
    /**
     * CITY_NAME的set方法
     * @param cityName
     */
    public void setCityName(String cityName){
		this.cityName = cityName;
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
	  			.append("ID"+":"+getId())
				.append("CITY_ID"+":"+getCityId())
				.append("PROVINCE_ID"+":"+getProvinceId())
				.append("CITY_NAME"+":"+getCityName())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
