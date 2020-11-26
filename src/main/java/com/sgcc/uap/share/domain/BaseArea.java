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
     * AREA_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "identity")
    @Column(name = "AREA_ID", nullable = false, length = 4)
    private String areaId ;
    
    /** 
     * PROVINCE_ID
     */
    @Column(name = "PROVINCE_ID", nullable = true, length = 64)
    private String provinceId ;
    
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
     * BAS_PROVINCE_ID
     */
    @Column(name = "BAS_PROVINCE_ID", nullable = false, length = 4)
    private String baSProvinceId ;
    
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
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getAreaId(){
        return this.areaId;
    }
    /**
     * @setAreaId:AREA_ID的set方法
     * @param areaId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setAreaId(String areaId){
        if(areaId != null && areaId.trim().length() == 0){
        	this.areaId = null;
        }else{
        	this.areaId = areaId;
        }
	} 
    /**
     * @getProvinceId:PROVINCE_ID的get方法
     * @params
     * @return provinceId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getProvinceId(){
        return this.provinceId;
    }
    /**
     * @setProvinceId:PROVINCE_ID的set方法
     * @param provinceId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setProvinceId(String provinceId){
		this.provinceId = provinceId;
	} 
    /**
     * @getProvinceName:PROVINCE_NAME的get方法
     * @params
     * @return provinceName
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getProvinceName(){
        return this.provinceName;
    }
    /**
     * @setProvinceName:PROVINCE_NAME的set方法
     * @param provinceName
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setProvinceName(String provinceName){
		this.provinceName = provinceName;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 
    /**
     * @getBaSProvinceId:BAS_PROVINCE_ID的get方法
     * @params
     * @return baSProvinceId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getBaSProvinceId(){
        return this.baSProvinceId;
    }
    /**
     * @setBaSProvinceId:BAS_PROVINCE_ID的set方法
     * @param baSProvinceId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setBaSProvinceId(String baSProvinceId){
		this.baSProvinceId = baSProvinceId;
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
		if (provinceId == null) {
			if (other.provinceId != null) {
				return false;
			}
		} else if (!provinceId.equals(other.provinceId)) {
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
		if (baSProvinceId == null) {
			if (other.baSProvinceId != null) {
				return false;
			}
		} else if (!baSProvinceId.equals(other.baSProvinceId)) {
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
			+ ", areaId=" + areaId
			+ ", provinceId=" + provinceId
			+ ", provinceName=" + provinceName
			+ ", remark=" + remark
			+ ", baSProvinceId=" + baSProvinceId;
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