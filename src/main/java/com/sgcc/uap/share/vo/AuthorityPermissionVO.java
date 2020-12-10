package com.sgcc.uap.share.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * AuthorityPermission的VO类
 *
 * @author 18511 
 */
public class AuthorityPermissionVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ID
     */  
    @ViewAttribute(name ="id",caption="ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性PID
     */  
    @ViewAttribute(name ="pid",caption="PID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String pid;    
    /** 
     * 属性PERMIS_NAME
     */  
    @ViewAttribute(name ="permisName",caption="PERMIS_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String permisName;    
    /** 
     * 属性PERMIS_TYPE
     */  
    @ViewAttribute(name ="permisType",caption="PERMIS_TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String permisType;    
    /** 
     * 属性URL
     */  
    @ViewAttribute(name ="url",caption="URL", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String url;    
    /** 
     * 属性STATE
     */  
    @ViewAttribute(name ="state",caption="STATE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String state;    
    /** 
     * 属性DESCRIPTION
     */  
    @ViewAttribute(name ="description",caption="DESCRIPTION", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String description;    
    /** 
     * 属性ICON
     */  
    @ViewAttribute(name ="icon",caption="ICON", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String icon;    
    /** 
     * 属性SORT
     */  
    @ViewAttribute(name ="sort",caption="SORT", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String sort;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * AuthorityPermissionVO构造函数
     */
    public AuthorityPermissionVO() {
        super();
    } 
   
	 /**
     * AuthorityPermissionVO完整的构造函数
     */  
    public AuthorityPermissionVO(String id){
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
     * PID的get方法
     * @return pid
     */
    public String getPid(){
        return pid;
    }
    /**
     * PID的set方法
     * @param pid
     */
    public void setPid(String pid){
		this.pid = pid;
	} 
    /**
     * PERMIS_NAME的get方法
     * @return permisName
     */
    public String getPermisName(){
        return permisName;
    }
    /**
     * PERMIS_NAME的set方法
     * @param permisName
     */
    public void setPermisName(String permisName){
		this.permisName = permisName;
	} 
    /**
     * PERMIS_TYPE的get方法
     * @return permisType
     */
    public String getPermisType(){
        return permisType;
    }
    /**
     * PERMIS_TYPE的set方法
     * @param permisType
     */
    public void setPermisType(String permisType){
		this.permisType = permisType;
	} 
    /**
     * URL的get方法
     * @return url
     */
    public String getUrl(){
        return url;
    }
    /**
     * URL的set方法
     * @param url
     */
    public void setUrl(String url){
		this.url = url;
	} 
    /**
     * STATE的get方法
     * @return state
     */
    public String getState(){
        return state;
    }
    /**
     * STATE的set方法
     * @param state
     */
    public void setState(String state){
		this.state = state;
	} 
    /**
     * DESCRIPTION的get方法
     * @return description
     */
    public String getDescription(){
        return description;
    }
    /**
     * DESCRIPTION的set方法
     * @param description
     */
    public void setDescription(String description){
		this.description = description;
	} 
    /**
     * ICON的get方法
     * @return icon
     */
    public String getIcon(){
        return icon;
    }
    /**
     * ICON的set方法
     * @param icon
     */
    public void setIcon(String icon){
		this.icon = icon;
	} 
    /**
     * SORT的get方法
     * @return sort
     */
    public String getSort(){
        return sort;
    }
    /**
     * SORT的set方法
     * @param sort
     */
    public void setSort(String sort){
		this.sort = sort;
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
				.append("PID"+":"+getPid())
				.append("PERMIS_NAME"+":"+getPermisName())
				.append("PERMIS_TYPE"+":"+getPermisType())
				.append("URL"+":"+getUrl())
				.append("STATE"+":"+getState())
				.append("DESCRIPTION"+":"+getDescription())
				.append("ICON"+":"+getIcon())
				.append("SORT"+":"+getSort())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
