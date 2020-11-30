package com.sgcc.uap.share.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


/**
 * BaseAreaPrice的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "base_area_price")
public class BaseAreaPrice implements Serializable {

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
     * PROVINCE_ID
     */
    @Column(name = "PROVINCE_ID", nullable = true, length = 4)
    private String provinceId ;
    
    /** 
     * CITY_ID
     */
    @Column(name = "CITY_ID", nullable = true, length = 4)
    private String cityId ;
    
    /** 
     * AREA_ID
     */
    @Column(name = "AREA_ID", nullable = true, length = 4)
    private String areaId ;
    
    /** 
     * PRICE
     */
    @Column(name = "PRICE", nullable = false, length = 6)
	@NotBlank(message="不能为空")
    private String price ;
    
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
	
	public BaseAreaPrice(){
	
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
     * @getProvinceId:PROVINCE_ID的get方法
     * @params
     * @return provinceId
     * @date 2020-11-30 13:16:19
     * @author 18511
     */
    public String getProvinceId(){
        return this.provinceId;
    }
    /**
     * @setProvinceId:PROVINCE_ID的set方法
     * @param provinceId
     * @return
     * @date 2020-11-30 13:16:19
     * @author 18511
     */
    public void setProvinceId(String provinceId){
		this.provinceId = provinceId;
	} 
    /**
     * @getCityId:CITY_ID的get方法
     * @params
     * @return cityId
     * @date 2020-11-30 13:16:19
     * @author 18511
     */
    public String getCityId(){
        return this.cityId;
    }
    /**
     * @setCityId:CITY_ID的set方法
     * @param cityId
     * @return
     * @date 2020-11-30 13:16:19
     * @author 18511
     */
    public void setCityId(String cityId){
		this.cityId = cityId;
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
     * @getPrice:PRICE的get方法
     * @params
     * @return price
     * @date 2020-11-30 13:16:19
     * @author 18511
     */
    public String getPrice(){
        return this.price;
    }
    /**
     * @setPrice:PRICE的set方法
     * @param price
     * @return
     * @date 2020-11-30 13:16:19
     * @author 18511
     */
    public void setPrice(String price){
		this.price = price;
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
		
        if (obj == null || !(obj instanceof BaseAreaPrice))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		BaseAreaPrice other = (BaseAreaPrice) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (provinceId == null) {
			if (other.provinceId != null) {
				return false;
			}
		} else if (!provinceId.equals(other.provinceId)) {
			return false;
		}
		if (cityId == null) {
			if (other.cityId != null) {
				return false;
			}
		} else if (!cityId.equals(other.cityId)) {
			return false;
		}
		if (areaId == null) {
			if (other.areaId != null) {
				return false;
			}
		} else if (!areaId.equals(other.areaId)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
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
		return "BaseAreaPrice ["
			+ ", id=" + id
			+ ", provinceId=" + provinceId
			+ ", cityId=" + cityId
			+ ", areaId=" + areaId
			+ ", price=" + price
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