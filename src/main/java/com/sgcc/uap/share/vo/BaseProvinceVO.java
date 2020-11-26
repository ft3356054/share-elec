package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * BaseProvince的VO类
 *
 * @author 18511 
 */
public class BaseProvinceVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性PROVINCE_ID
     */  
    @ViewAttribute(name ="provinceId",caption="PROVINCE_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String provinceId;    
    /** 
     * 属性PROVINCE_NAME
     */  
    @ViewAttribute(name ="provinceName",caption="PROVINCE_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String provinceName;    
    /** 
     * 属性REGION
     */  
    @ViewAttribute(name ="region",caption="REGION", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String region;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * BaseProvinceVO构造函数
     */
    public BaseProvinceVO() {
        super();
    } 
   
	 /**
     * BaseProvinceVO完整的构造函数
     */  
    public BaseProvinceVO(String provinceId){
        this.provinceId = provinceId;
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
        if(provinceId != null && provinceId.trim().length() == 0){
        	this.provinceId = null;
        }else{
        	this.provinceId = provinceId;
        }
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
     * REGION的get方法
     * @return region
     */
    public String getRegion(){
        return region;
    }
    /**
     * REGION的set方法
     * @param region
     */
    public void setRegion(String region){
		this.region = region;
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
	  			.append("PROVINCE_ID"+":"+getProvinceId())
				.append("PROVINCE_NAME"+":"+getProvinceName())
				.append("REGION"+":"+getRegion())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
