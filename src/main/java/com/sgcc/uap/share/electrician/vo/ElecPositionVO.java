package com.sgcc.uap.share.electrician.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * ElecPosition的VO类
 *
 * @author 18511 
 */
public class ElecPositionVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ELECTRICIAN_ID
     */  
    @ViewAttribute(name ="electricianId",caption="ELECTRICIAN_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String electricianId;    
    /** 
     * 属性AREA_ID
     */  
    @ViewAttribute(name ="areaId",caption="AREA_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String areaId;    
    /** 
     * 属性LON
     */  
    @ViewAttribute(name ="lon",caption="LON", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String lon;    
    /** 
     * 属性LAT
     */  
    @ViewAttribute(name ="lat",caption="LAT", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String lat;    
    /**
     * ElecPositionVO构造函数
     */
    public ElecPositionVO() {
        super();
    } 
   
	 /**
     * ElecPositionVO完整的构造函数
     */  
    public ElecPositionVO(String electricianId){
        this.electricianId = electricianId;
    }
    /**
     * ELECTRICIAN_ID的get方法
     * @return electricianId
     */
    public String getElectricianId(){
        return electricianId;
    }
    /**
     * ELECTRICIAN_ID的set方法
     * @param electricianId
     */
    public void setElectricianId(String electricianId){
        if(electricianId != null && electricianId.trim().length() == 0){
        	this.electricianId = null;
        }else{
        	this.electricianId = electricianId;
        }
	} 
    /**
     * AREA_ID的get方法
     * @return areaId
     */
    public String getAreaId(){
        return areaId;
    }
    /**
     * AREA_ID的set方法
     * @param areaId
     */
    public void setAreaId(String areaId){
		this.areaId = areaId;
	} 
    /**
     * LON的get方法
     * @return lon
     */
    public String getLon(){
        return lon;
    }
    /**
     * LON的set方法
     * @param lon
     */
    public void setLon(String lon){
		this.lon = lon;
	} 
    /**
     * LAT的get方法
     * @return lat
     */
    public String getLat(){
        return lat;
    }
    /**
     * LAT的set方法
     * @param lat
     */
    public void setLat(String lat){
		this.lat = lat;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("ELECTRICIAN_ID"+":"+getElectricianId())
				.append("AREA_ID"+":"+getAreaId())
				.append("LON"+":"+getLon())
				.append("LAT"+":"+getLat())
		        .toString(); 
			
    } 
   


}
