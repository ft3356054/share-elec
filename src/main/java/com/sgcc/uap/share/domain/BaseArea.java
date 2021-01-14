package com.sgcc.uap.share.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


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
     * AREA_ID
     */
	@Id
    @Column(name = "AREA_ID", nullable = true, length = 4)
    private String areaId ;
    
    /** 
     * CITY_ID
     */
    @Column(name = "CITY_ID", nullable = true, length = 4)
    private String cityId ;
    
    /** 
     * AREA_NAME
     */
    @Column(name = "AREA_NAME", nullable = true, length = 64)
    private String areaName ;
    
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
    
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
		
		if (areaId == null) {
			if (other.areaId != null) {
				return false;
			}
		} else if (!areaId.equals(other.areaId)) {
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
     * hashcode方法
     * @return int
     * 
     */
    @Override
    public int hashCode(){
		return super.hashCode();
	}
}