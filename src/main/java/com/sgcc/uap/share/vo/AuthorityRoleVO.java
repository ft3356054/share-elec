package com.sgcc.uap.share.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * AuthorityRole的VO类
 *
 * @author 18511 
 */
public class AuthorityRoleVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ID
     */  
    @ViewAttribute(name ="id",caption="ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性ROLE_NAME
     */  
    @ViewAttribute(name ="roleName",caption="ROLE_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String roleName;    
    /** 
     * 属性ROLE_DESC
     */  
    @ViewAttribute(name ="roleDesc",caption="ROLE_DESC", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String roleDesc;    
    /** 
     * 属性CREATE_TIME
     */  
    @ViewAttribute(name ="createTime",caption="CREATE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp createTime;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * AuthorityRoleVO构造函数
     */
    public AuthorityRoleVO() {
        super();
    } 
   
	 /**
     * AuthorityRoleVO完整的构造函数
     */  
    public AuthorityRoleVO(String id){
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
     * ROLE_NAME的get方法
     * @return roleName
     */
    public String getRoleName(){
        return roleName;
    }
    /**
     * ROLE_NAME的set方法
     * @param roleName
     */
    public void setRoleName(String roleName){
		this.roleName = roleName;
	} 
    /**
     * ROLE_DESC的get方法
     * @return roleDesc
     */
    public String getRoleDesc(){
        return roleDesc;
    }
    /**
     * ROLE_DESC的set方法
     * @param roleDesc
     */
    public void setRoleDesc(String roleDesc){
		this.roleDesc = roleDesc;
	} 
    /**
     * CREATE_TIME的get方法
     * @return createTime
     */
    public Timestamp getCreateTime(){
        return createTime;
    }
    /**
     * CREATE_TIME的set方法
     * @param createTime
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
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
				.append("ROLE_NAME"+":"+getRoleName())
				.append("ROLE_DESC"+":"+getRoleDesc())
				.append("CREATE_TIME"+":"+getCreateTime())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
