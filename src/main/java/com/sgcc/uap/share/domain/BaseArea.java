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
 * BaseArea的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "base_area")
public class BaseArea implements Serializable {

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
     * AREA_ID
     */
    @Column(name = "AREA_ID", nullable = true, length = 4)
    private String areaId ;
    
    /** 
     * PROVINCE_NAME
     */
    @Column(name = "PROVINCE_NAME", nullable = true, length = 64)
    private String provinceName ;
    
    /** 
     * REMARK
     */
    @Column(name = "REMARK", nullable = true, length = 64)
    private String remark ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public BaseArea(){
	
	}
    /**
     * @getId:ID的get方法
     * @params
     * @return id
     * @date 2020-11-30 13:16:19
     * @author 18511
     */
    public String getId(){
        return this.id;
    }
    /**
     * @setId:ID的set方法
     * @param id
     * @return
     * @date 2020-11-30 13:16:19
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
     * @getAreaId:AREA_ID的get方法
     * @params
     * @return areaId
     * @date 2020-11-30 13:16:19
     * @author 18511
     */
    public String getAreaId(){
        return this.areaId;
    }
    /**
     * @setAreaId:AREA_ID的set方法
     * @param areaId
     * @return
     * @date 2020-11-30 13:16:19
     * @author 18511
     */
    public void setAreaId(String areaId){
		this.areaId = areaId;
	} 
    /**
     * @getProvinceName:PROVINCE_NAME的get方法
     * @params
     * @return provinceName
     * @date 2020-11-30 13:16:19
     * @author 18511
     */
    public String getProvinceName(){
        return this.provinceName;
    }
    /**
     * @setProvinceName:PROVINCE_NAME的set方法
     * @param provinceName
     * @return
     * @date 2020-11-30 13:16:19
     * @author 18511
     */
    public void setProvinceName(String provinceName){
		this.provinceName = provinceName;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-11-30 13:16:19
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-11-30 13:16:19
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
		
        if (obj == null || !(obj instanceof BaseArea))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		BaseArea other = (BaseArea) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (areaId == null) {
			if (other.areaId != null) {
				return false;
			}
		} else if (!areaId.equals(other.areaId)) {
			return false;
		}
		if (provinceName == null) {
			if (other.provinceName != null) {
				return false;
			}
		} else if (!provinceName.equals(other.provinceName)) {
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
		return "BaseArea ["
			+ ", id=" + id
			+ ", areaId=" + areaId
			+ ", provinceName=" + provinceName
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