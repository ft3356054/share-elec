package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * BaseLabel的VO类
 *
 * @author 18511 
 */
public class BaseLabelVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ID
     */  
    @ViewAttribute(name ="id",caption="ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性LABEL_ID
     */  
    @ViewAttribute(name ="labelId",caption="LABEL_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String labelId;    
    /** 
     * 属性LABEL_NAME
     */  
    @ViewAttribute(name ="labelName",caption="LABEL_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String labelName;    
    /** 
     * 属性LABEL_STATUS
     */  
    @ViewAttribute(name ="labelStatus",caption="LABEL_STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String labelStatus;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * BaseLabelVO构造函数
     */
    public BaseLabelVO() {
        super();
    } 
   
	 /**
     * BaseLabelVO完整的构造函数
     */  
    public BaseLabelVO(String id){
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
     * LABEL_ID的get方法
     * @return labelId
     */
    public String getLabelId(){
        return labelId;
    }
    /**
     * LABEL_ID的set方法
     * @param labelId
     */
    public void setLabelId(String labelId){
		this.labelId = labelId;
	} 
    /**
     * LABEL_NAME的get方法
     * @return labelName
     */
    public String getLabelName(){
        return labelName;
    }
    /**
     * LABEL_NAME的set方法
     * @param labelName
     */
    public void setLabelName(String labelName){
		this.labelName = labelName;
	} 
    /**
     * LABEL_STATUS的get方法
     * @return labelStatus
     */
    public String getLabelStatus(){
        return labelStatus;
    }
    /**
     * LABEL_STATUS的set方法
     * @param labelStatus
     */
    public void setLabelStatus(String labelStatus){
		this.labelStatus = labelStatus;
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
				.append("LABEL_ID"+":"+getLabelId())
				.append("LABEL_NAME"+":"+getLabelName())
				.append("LABEL_STATUS"+":"+getLabelStatus())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
