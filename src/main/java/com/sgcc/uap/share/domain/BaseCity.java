package com.sgcc.uap.share.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * BaseCity的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "base_city")
public class BaseCity implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * CITY_ID
     */
	@Id
    @Column(name = "CITY_ID", nullable = true, length = 4)
    private String cityId ;
    
    /** 
     * PROVINCE_ID
     */
    @Column(name = "PROVINCE_ID", nullable = true, length = 4)
    private String provinceId ;
    
    /** 
     * CITY_NAME
     */
    @Column(name = "CITY_NAME", nullable = true, length = 64)
    private String cityName ;
    
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
	
	public BaseCity(){
	
	}
    /**
     * @getCityId:CITY_ID的get方法
     * @params
     * @return cityId
     * @date 2020-11-30 13:16:25
     * @author 18511
     */
    public String getCityId(){
        return this.cityId;
    }
    /**
     * @setCityId:CITY_ID的set方法
     * @param cityId
     * @return
     * @date 2020-11-30 13:16:25
     * @author 18511
     */
    public void setCityId(String cityId){
		this.cityId = cityId;
	} 
    /**
     * @getProvinceId:PROVINCE_ID的get方法
     * @params
     * @return provinceId
     * @date 2020-11-30 13:16:25
     * @author 18511
     */
    public String getProvinceId(){
        return this.provinceId;
    }
    /**
     * @setProvinceId:PROVINCE_ID的set方法
     * @param provinceId
     * @return
     * @date 2020-11-30 13:16:25
     * @author 18511
     */
    public void setProvinceId(String provinceId){
		this.provinceId = provinceId;
	} 
    /**
     * @getCityName:CITY_NAME的get方法
     * @params
     * @return cityName
     * @date 2020-11-30 13:16:25
     * @author 18511
     */
    public String getCityName(){
        return this.cityName;
    }
    /**
     * @setCityName:CITY_NAME的set方法
     * @param cityName
     * @return
     * @date 2020-11-30 13:16:25
     * @author 18511
     */
    public void setCityName(String cityName){
		this.cityName = cityName;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-11-30 13:16:25
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-11-30 13:16:25
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
		
        if (obj == null || !(obj instanceof BaseCity))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		BaseCity other = (BaseCity) obj;
		
		if (cityId == null) {
			if (other.cityId != null) {
				return false;
			}
		} else if (!cityId.equals(other.cityId)) {
			return false;
		}
		if (provinceId == null) {
			if (other.provinceId != null) {
				return false;
			}
		} else if (!provinceId.equals(other.provinceId)) {
			return false;
		}
		if (cityName == null) {
			if (other.cityName != null) {
				return false;
			}
		} else if (!cityName.equals(other.cityName)) {
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
		return "BaseCity ["
			+ ",cityId=" + cityId
			+ ", provinceId=" + provinceId
			+ ", cityName=" + cityName
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