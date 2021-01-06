package com.sgcc.uap.share.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * ElecPosition的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "elec_position")
public class ElecPosition implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * ELECTRICIAN_ID
     */
	@Id
	/*@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")*/
    @Column(name = "ELECTRICIAN_ID", nullable = false, length = 64)
    private String electricianId ;
    
    /** 
     * AREA_ID
     */
    @Column(name = "AREA_ID", nullable = true, length = 64)
    private String areaId ;
    
    /** 
     * LON
     */
    @Column(name = "LON", nullable = true, length = 64)
    private String lon ;
    
    /** 
     * LAT
     */
    @Column(name = "LAT", nullable = true, length = 64)
    private String lat ;
    
    /** 
     * STATUS
     */
    @Column(name = "STATUS", nullable = true, length = 2)
    private String status ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public ElecPosition(){
	
	}
    /**
     * @getElectricianId:ELECTRICIAN_ID的get方法
     * @params
     * @return electricianId
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public String getElectricianId(){
        return this.electricianId;
    }
    /**
     * @setElectricianId:ELECTRICIAN_ID的set方法
     * @param electricianId
     * @return
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public void setElectricianId(String electricianId){
        if(electricianId != null && electricianId.trim().length() == 0){
        	this.electricianId = null;
        }else{
        	this.electricianId = electricianId;
        }
	} 
    /**
     * @getAreaId:AREA_ID的get方法
     * @params
     * @return areaId
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public String getAreaId(){
        return this.areaId;
    }
    /**
     * @setAreaId:AREA_ID的set方法
     * @param areaId
     * @return
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public void setAreaId(String areaId){
		this.areaId = areaId;
	} 
    /**
     * @getLon:LON的get方法
     * @params
     * @return lon
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public String getLon(){
        return this.lon;
    }
    /**
     * @setLon:LON的set方法
     * @param lon
     * @return
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public void setLon(String lon){
		this.lon = lon;
	} 
    /**
     * @getLat:LAT的get方法
     * @params
     * @return lat
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public String getLat(){
        return this.lat;
    }
    /**
     * @setLat:LAT的set方法
     * @param lat
     * @return
     * @date 2020-12-21 09:31:09
     * @author 18511
     */
    public void setLat(String lat){
		this.lat = lat;
	} 
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		
        if (obj == null || !(obj instanceof ElecPosition))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		ElecPosition other = (ElecPosition) obj;
		
		if (electricianId == null) {
			if (other.electricianId != null) {
				return false;
			}
		} else if (!electricianId.equals(other.electricianId)) {
			return false;
		}
		if (areaId == null) {
			if (other.areaId != null) {
				return false;
			}
		} else if (!areaId.equals(other.areaId)) {
			return false;
		}
		if (lon == null) {
			if (other.lon != null) {
				return false;
			}
		} else if (!lon.equals(other.lon)) {
			return false;
		}
		if (lat == null) {
			if (other.lat != null) {
				return false;
			}
		} else if (!lat.equals(other.lat)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "ElecPosition ["
			+ ", electricianId=" + electricianId
			+ ", areaId=" + areaId
			+ ", lon=" + lon
			+ ", lat=" + lat;
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