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
 * BaseVoltage的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "base_voltage")
public class BaseVoltage implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * 身份ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "VOLTAGE_ID", nullable = false, length = 32)
    private String voltageId ;
    
    /** 
     * 身份名称
     */
    @Column(name = "VOLTAGE", nullable = true, length = 32)
    private String voltage ;
    
    /** 
     * REMARK
     */
    @Column(name = "REMARK", nullable = true, length = 32)
    private String remark ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public BaseVoltage(){
	
	}
    /**
     * @getVoltageId:身份ID的get方法
     * @params
     * @return voltageId
     * @date 2020-12-21 17:22:38
     * @author 18511
     */
    public String getVoltageId(){
        return this.voltageId;
    }
    /**
     * @setVoltageId:身份ID的set方法
     * @param voltageId
     * @return
     * @date 2020-12-21 17:22:38
     * @author 18511
     */
    public void setVoltageId(String voltageId){
        if(voltageId != null && voltageId.trim().length() == 0){
        	this.voltageId = null;
        }else{
        	this.voltageId = voltageId;
        }
	} 
    /**
     * @getVoltage:身份名称的get方法
     * @params
     * @return voltage
     * @date 2020-12-21 17:22:38
     * @author 18511
     */
    public String getVoltage(){
        return this.voltage;
    }
    /**
     * @setVoltage:身份名称的set方法
     * @param voltage
     * @return
     * @date 2020-12-21 17:22:38
     * @author 18511
     */
    public void setVoltage(String voltage){
		this.voltage = voltage;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-12-21 17:22:38
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-12-21 17:22:38
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
		
        if (obj == null || !(obj instanceof BaseVoltage))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		BaseVoltage other = (BaseVoltage) obj;
		
		if (voltageId == null) {
			if (other.voltageId != null) {
				return false;
			}
		} else if (!voltageId.equals(other.voltageId)) {
			return false;
		}
		if (voltage == null) {
			if (other.voltage != null) {
				return false;
			}
		} else if (!voltage.equals(other.voltage)) {
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
		return "BaseVoltage ["
			+ ", voltageId=" + voltageId
			+ ", voltage=" + voltage
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