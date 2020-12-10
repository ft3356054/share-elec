package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * AuthorityUser的VO类
 *
 * @author 18511 
 */
public class AuthorityUserVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ID
     */  
    @ViewAttribute(name ="id",caption="ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性USER_NAME
     */  
    @ViewAttribute(name ="userName",caption="USER_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String userName;    
    /** 
     * 属性USER_DESC
     */  
    @ViewAttribute(name ="userDesc",caption="USER_DESC", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String userDesc;    
    /** 
     * 属性STATUS
     */  
    @ViewAttribute(name ="_status",caption="STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String _status;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * AuthorityUserVO构造函数
     */
    public AuthorityUserVO() {
        super();
    } 
   
	 /**
     * AuthorityUserVO完整的构造函数
     */  
    public AuthorityUserVO(String id){
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
     * USER_NAME的get方法
     * @return userName
     */
    public String getUserName(){
        return userName;
    }
    /**
     * USER_NAME的set方法
     * @param userName
     */
    public void setUserName(String userName){
		this.userName = userName;
	} 
    /**
     * USER_DESC的get方法
     * @return userDesc
     */
    public String getUserDesc(){
        return userDesc;
    }
    /**
     * USER_DESC的set方法
     * @param userDesc
     */
    public void setUserDesc(String userDesc){
		this.userDesc = userDesc;
	} 
    /**
     * STATUS的get方法
     * @return _status
     */
    public String get_status(){
        return _status;
    }
    /**
     * STATUS的set方法
     * @param _status
     */
    public void set_status(String _status){
		this._status = _status;
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
				.append("USER_NAME"+":"+getUserName())
				.append("USER_DESC"+":"+getUserDesc())
				.append("STATUS"+":"+get_status())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
