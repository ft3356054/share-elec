package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * BaseEnums的VO类
 *
 * @author 18511 
 */
public class BaseEnumsVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性身份ID
     */  
    @ViewAttribute(name ="enumsId",caption="身份ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String enumsId;    
    /** 
     * 属性身份名称
     */  
    @ViewAttribute(name ="enumsType",caption="身份名称", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String enumsType;    
    /** 
     * 属性ENUMS_STATUS
     */  
    @ViewAttribute(name ="enumsStatus",caption="ENUMS_STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String enumsStatus;    
    /** 
     * 属性ENUMS_A
     */  
    @ViewAttribute(name ="enumsA",caption="ENUMS_A", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String enumsA;    
    /** 
     * 属性ENUMS_B
     */  
    @ViewAttribute(name ="enumsB",caption="ENUMS_B", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String enumsB;    
    /** 
     * 属性ENUMS_C
     */  
    @ViewAttribute(name ="enumsC",caption="ENUMS_C", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String enumsC;    
    /** 
     * 属性ENUMS_D
     */  
    @ViewAttribute(name ="enumsD",caption="ENUMS_D", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String enumsD;    
    /** 
     * 属性ENUMS_E
     */  
    @ViewAttribute(name ="enumsE",caption="ENUMS_E", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String enumsE;    
    /** 
     * 属性ENUMS_F
     */  
    @ViewAttribute(name ="enumsF",caption="ENUMS_F", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String enumsF;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * BaseEnumsVO构造函数
     */
    public BaseEnumsVO() {
        super();
    } 
   
	 /**
     * BaseEnumsVO完整的构造函数
     */  
    public BaseEnumsVO(String enumsId){
        this.enumsId = enumsId;
    }
    /**
     * 身份ID的get方法
     * @return enumsId
     */
    public String getEnumsId(){
        return enumsId;
    }
    /**
     * 身份ID的set方法
     * @param enumsId
     */
    public void setEnumsId(String enumsId){
        if(enumsId != null && enumsId.trim().length() == 0){
        	this.enumsId = null;
        }else{
        	this.enumsId = enumsId;
        }
	} 
    /**
     * 身份名称的get方法
     * @return enumsType
     */
    public String getEnumsType(){
        return enumsType;
    }
    /**
     * 身份名称的set方法
     * @param enumsType
     */
    public void setEnumsType(String enumsType){
		this.enumsType = enumsType;
	} 
    /**
     * ENUMS_STATUS的get方法
     * @return enumsStatus
     */
    public String getEnumsStatus(){
        return enumsStatus;
    }
    /**
     * ENUMS_STATUS的set方法
     * @param enumsStatus
     */
    public void setEnumsStatus(String enumsStatus){
		this.enumsStatus = enumsStatus;
	} 
    /**
     * ENUMS_A的get方法
     * @return enumsA
     */
    public String getEnumsA(){
        return enumsA;
    }
    /**
     * ENUMS_A的set方法
     * @param enumsA
     */
    public void setEnumsA(String enumsA){
		this.enumsA = enumsA;
	} 
    /**
     * ENUMS_B的get方法
     * @return enumsB
     */
    public String getEnumsB(){
        return enumsB;
    }
    /**
     * ENUMS_B的set方法
     * @param enumsB
     */
    public void setEnumsB(String enumsB){
		this.enumsB = enumsB;
	} 
    /**
     * ENUMS_C的get方法
     * @return enumsC
     */
    public String getEnumsC(){
        return enumsC;
    }
    /**
     * ENUMS_C的set方法
     * @param enumsC
     */
    public void setEnumsC(String enumsC){
		this.enumsC = enumsC;
	} 
    /**
     * ENUMS_D的get方法
     * @return enumsD
     */
    public String getEnumsD(){
        return enumsD;
    }
    /**
     * ENUMS_D的set方法
     * @param enumsD
     */
    public void setEnumsD(String enumsD){
		this.enumsD = enumsD;
	} 
    /**
     * ENUMS_E的get方法
     * @return enumsE
     */
    public String getEnumsE(){
        return enumsE;
    }
    /**
     * ENUMS_E的set方法
     * @param enumsE
     */
    public void setEnumsE(String enumsE){
		this.enumsE = enumsE;
	} 
    /**
     * ENUMS_F的get方法
     * @return enumsF
     */
    public String getEnumsF(){
        return enumsF;
    }
    /**
     * ENUMS_F的set方法
     * @param enumsF
     */
    public void setEnumsF(String enumsF){
		this.enumsF = enumsF;
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
	  			.append("ENUMS_ID"+":"+getEnumsId())
				.append("ENUMS_TYPE"+":"+getEnumsType())
				.append("ENUMS_STATUS"+":"+getEnumsStatus())
				.append("ENUMS_A"+":"+getEnumsA())
				.append("ENUMS_B"+":"+getEnumsB())
				.append("ENUMS_C"+":"+getEnumsC())
				.append("ENUMS_D"+":"+getEnumsD())
				.append("ENUMS_E"+":"+getEnumsE())
				.append("ENUMS_F"+":"+getEnumsF())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
