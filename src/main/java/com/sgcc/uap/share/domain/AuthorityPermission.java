package com.sgcc.uap.share.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


/**
 * AuthorityPermission的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "authority_permission")
public class AuthorityPermission implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "ID", nullable = false, length = 64)
    private String id ;
    
    /** 
     * PID
     */
    @Column(name = "PID", nullable = true, length = 64)
    private String pid ;
    
    /** 
     * PERMIS_NAME
     */
    @Column(name = "PERMIS_NAME", nullable = true, length = 64)
    private String permisName ;
    
    /** 
     * PERMIS_TYPE
     */
    @Column(name = "PERMIS_TYPE", nullable = true, length = 2)
    private String permisType ;
    
    /** 
     * URL
     */
    @Column(name = "URL", nullable = true, length = 256)
    private String url ;
    
    /** 
     * STATE
     */
    @Column(name = "STATE", nullable = true, length = 2)
    private String state ;
    
    /** 
     * DESCRIPTION
     */
    @Column(name = "DESCRIPTION", nullable = true, length = 256)
    private String description ;
    
    /** 
     * ICON
     */
    @Column(name = "ICON", nullable = true, length = 256)
    private String icon ;
    
    /** 
     * SORT
     */
    @Column(name = "SORT", nullable = true, length = 2)
    private String sort ;
    
    /** 
     * REMARK
     */
    @Column(name = "REMARK", nullable = true, length = 256)
    private String remark ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public AuthorityPermission(){
	
	}
    /**
     * @getId:ID的get方法
     * @params
     * @return id
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getId(){
        return this.id;
    }
    /**
     * @setId:ID的set方法
     * @param id
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setId(String id){
        if(id != null && id.trim().length() == 0){
        	this.id = null;
        }else{
        	this.id = id;
        }
	} 
    /**
     * @getPid:PID的get方法
     * @params
     * @return pid
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getPid(){
        return this.pid;
    }
    /**
     * @setPid:PID的set方法
     * @param pid
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setPid(String pid){
		this.pid = pid;
	} 
    /**
     * @getPermisName:PERMIS_NAME的get方法
     * @params
     * @return permisName
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getPermisName(){
        return this.permisName;
    }
    /**
     * @setPermisName:PERMIS_NAME的set方法
     * @param permisName
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setPermisName(String permisName){
		this.permisName = permisName;
	} 
    /**
     * @getPermisType:PERMIS_TYPE的get方法
     * @params
     * @return permisType
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getPermisType(){
        return this.permisType;
    }
    /**
     * @setPermisType:PERMIS_TYPE的set方法
     * @param permisType
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setPermisType(String permisType){
		this.permisType = permisType;
	} 
    /**
     * @getUrl:URL的get方法
     * @params
     * @return url
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getUrl(){
        return this.url;
    }
    /**
     * @setUrl:URL的set方法
     * @param url
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setUrl(String url){
		this.url = url;
	} 
    /**
     * @getState:STATE的get方法
     * @params
     * @return state
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getState(){
        return this.state;
    }
    /**
     * @setState:STATE的set方法
     * @param state
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setState(String state){
		this.state = state;
	} 
    /**
     * @getDescription:DESCRIPTION的get方法
     * @params
     * @return description
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getDescription(){
        return this.description;
    }
    /**
     * @setDescription:DESCRIPTION的set方法
     * @param description
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setDescription(String description){
		this.description = description;
	} 
    /**
     * @getIcon:ICON的get方法
     * @params
     * @return icon
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getIcon(){
        return this.icon;
    }
    /**
     * @setIcon:ICON的set方法
     * @param icon
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setIcon(String icon){
		this.icon = icon;
	} 
    /**
     * @getSort:SORT的get方法
     * @params
     * @return sort
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getSort(){
        return this.sort;
    }
    /**
     * @setSort:SORT的set方法
     * @param sort
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setSort(String sort){
		this.sort = sort;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-12-10 09:35:40
     * @author 18511
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 
	public String getMxVirtualId() {
        return this.mxVirtualId;
    }
    
    public void setMxVirtualId(String mxVirtualId) {
        this.mxVirtualId = mxVirtualId;
    } 
    /**
     * Hibernate通过该方法判断对象是否相等
     * @return boolean
     */  
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
		
        if (obj == null || !(obj instanceof AuthorityPermission))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		AuthorityPermission other = (AuthorityPermission) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (pid == null) {
			if (other.pid != null) {
				return false;
			}
		} else if (!pid.equals(other.pid)) {
			return false;
		}
		if (permisName == null) {
			if (other.permisName != null) {
				return false;
			}
		} else if (!permisName.equals(other.permisName)) {
			return false;
		}
		if (permisType == null) {
			if (other.permisType != null) {
				return false;
			}
		} else if (!permisType.equals(other.permisType)) {
			return false;
		}
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (icon == null) {
			if (other.icon != null) {
				return false;
			}
		} else if (!icon.equals(other.icon)) {
			return false;
		}
		if (sort == null) {
			if (other.sort != null) {
				return false;
			}
		} else if (!sort.equals(other.sort)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "AuthorityPermission ["
			+ ", id=" + id
			+ ", pid=" + pid
			+ ", permisName=" + permisName
			+ ", permisType=" + permisType
			+ ", url=" + url
			+ ", state=" + state
			+ ", description=" + description
			+ ", icon=" + icon
			+ ", sort=" + sort
			+ ", remark=" + remark;
	}
   
    
    /**
     * hashcode方法
     * @return int
     * 
     */
    @Override
    public int hashCode(){
		return super.hashCode();
	}
}