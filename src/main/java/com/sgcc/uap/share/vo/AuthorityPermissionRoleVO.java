package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * AuthorityPermissionRole的VO类
 *
 * @author 18511 
 */
public class AuthorityPermissionRoleVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ID
     */  
    @ViewAttribute(name ="id",caption="ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性ROLE_ID
     */  
    @ViewAttribute(name ="roleId",caption="ROLE_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String roleId;    
    /** 
     * 属性PERMIS_ID
     */  
    @ViewAttribute(name ="permisId",caption="PERMIS_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String permisId;    
    /** 
     * 属性TYPE
     */  
    @ViewAttribute(name ="_type",caption="TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String _type;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * AuthorityPermissionRoleVO构造函数
     */
    public AuthorityPermissionRoleVO() {
        super();
    } 
   
	 /**
     * AuthorityPermissionRoleVO完整的构造函数
     */  
    public AuthorityPermissionRoleVO(String id){
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
     * ROLE_ID的get方法
     * @return roleId
     */
    public String getRoleId(){
        return roleId;
    }
    /**
     * ROLE_ID的set方法
     * @param roleId
     */
    public void setRoleId(String roleId){
		this.roleId = roleId;
	} 
    /**
     * PERMIS_ID的get方法
     * @return permisId
     */
    public String getPermisId(){
        return permisId;
    }
    /**
     * PERMIS_ID的set方法
     * @param permisId
     */
    public void setPermisId(String permisId){
		this.permisId = permisId;
	} 
    /**
     * TYPE的get方法
     * @return _type
     */
    public String get_type(){
        return _type;
    }
    /**
     * TYPE的set方法
     * @param _type
     */
    public void set_type(String _type){
		this._type = _type;
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
				.append("ROLE_ID"+":"+getRoleId())
				.append("PERMIS_ID"+":"+getPermisId())
				.append("TYPE"+":"+get_type())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
