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
 * BaseProvince的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "base_province")
public class BaseProvince implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * PROVINCE_ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "identity")
    @Column(name = "PROVINCE_ID", nullable = false, length = 4)
    private String provinceId ;
    
    /** 
     * PROVINCE_NAME
     */
    @Column(name = "PROVINCE_NAME", nullable = true, length = 64)
    private String provinceName ;
    
    /** 
     * REGION
     */
    @Column(name = "REGION", nullable = true, length = 64)
    private String region ;
    
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
	
	public BaseProvince(){
	
	}
    /**
     * @getProvinceId:PROVINCE_ID的get方法
     * @params
     * @return provinceId
     * @date 2020-11-30 13:16:23
     * @author 18511
     */
    public String getProvinceId(){
        return this.provinceId;
    }
    /**
     * @setProvinceId:PROVINCE_ID的set方法
     * @param provinceId
     * @return
     * @date 2020-11-30 13:16:23
     * @author 18511
     */
    public void setProvinceId(String provinceId){
        if(provinceId != null && provinceId.trim().length() == 0){
        	this.provinceId = null;
        }else{
        	this.provinceId = provinceId;
        }
	} 
    /**
     * @getProvinceName:PROVINCE_NAME的get方法
     * @params
     * @return provinceName
     * @date 2020-11-30 13:16:23
     * @author 18511
     */
    public String getProvinceName(){
        return this.provinceName;
    }
    /**
     * @setProvinceName:PROVINCE_NAME的set方法
     * @param provinceName
     * @return
     * @date 2020-11-30 13:16:23
     * @author 18511
     */
    public void setProvinceName(String provinceName){
		this.provinceName = provinceName;
	} 
    /**
     * @getRegion:REGION的get方法
     * @params
     * @return region
     * @date 2020-11-30 13:16:23
     * @author 18511
     */
    public String getRegion(){
        return this.region;
    }
    /**
     * @setRegion:REGION的set方法
     * @param region
     * @return
     * @date 2020-11-30 13:16:23
     * @author 18511
     */
    public void setRegion(String region){
		this.region = region;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-11-30 13:16:23
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-11-30 13:16:23
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
		
        if (obj == null || !(obj instanceof BaseProvince))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		BaseProvince other = (BaseProvince) obj;
		
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
		if (region == null) {
			if (other.region != null) {
				return false;
			}
		} else if (!region.equals(other.region)) {
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
		return "BaseProvince ["
			+ ", provinceId=" + provinceId
			+ ", provinceName=" + provinceName
			+ ", region=" + region
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