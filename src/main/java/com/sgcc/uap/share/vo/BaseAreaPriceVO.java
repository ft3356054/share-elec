package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * BaseAreaPrice的VO类
 *
 * @author 18511 
 */
public class BaseAreaPriceVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ID
     */  
    @ViewAttribute(name ="id",caption="ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性PROVINCE_ID
     */  
    @ViewAttribute(name ="provinceId",caption="PROVINCE_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String provinceId;    
    /** 
     * 属性CITY_ID
     */  
    @ViewAttribute(name ="cityId",caption="CITY_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String cityId;    
    /** 
     * 属性AREA_ID
     */  
    @ViewAttribute(name ="areaId",caption="AREA_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String areaId;    
    /** 
     * 属性PRICE
     */  
    @ViewAttribute(name ="price",caption="PRICE", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String price;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * BaseAreaPriceVO构造函数
     */
    public BaseAreaPriceVO() {
        super();
    } 
   
	 /**
     * BaseAreaPriceVO完整的构造函数
     */  
    public BaseAreaPriceVO(String id){
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
		this.areaId = areaId;
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
				.append("PROVINCE_ID"+":"+getProvinceId())
				.append("CITY_ID"+":"+getCityId())
				.append("AREA_ID"+":"+getAreaId())
				.append("PRICE"+":"+getPrice())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
