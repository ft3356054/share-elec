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
     * 属性ID
     */  
    @ViewAttribute(name ="id",caption="ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性AREA_ID
     */  
    @ViewAttribute(name ="areaId",caption="AREA_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String areaId;    
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
     * BaseAreaVO构造函数
     */
    public BaseAreaVO() {
        super();
    } 
   
	 /**
     * BaseAreaVO完整的构造函数
     */  
    public BaseAreaVO(String id){
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
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("ID"+":"+getId())
				.append("AREA_ID"+":"+getAreaId())
				.append("PROVINCE_NAME"+":"+getProvinceName())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
