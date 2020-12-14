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
 * BaseLabel的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "base_label")
public class BaseLabel implements Serializable {

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
     * LABEL_ID
     */
    @Column(name = "LABEL_ID", nullable = true, length = 64)
    private String labelId ;
    
    /** 
     * LABEL_NAME
     */
    @Column(name = "LABEL_NAME", nullable = true, length = 64)
    private String labelName ;
    
    /** 
     * LABEL_STATUS
     */
    @Column(name = "LABEL_STATUS", nullable = true, length = 2)
    private String labelStatus ;
    
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
	
	public BaseLabel(){
	
	}
    /**
     * @getId:ID的get方法
     * @params
     * @return id
     * @date 2020-12-14 11:25:15
     * @author 18511
     */
    public String getId(){
        return this.id;
    }
    /**
     * @setId:ID的set方法
     * @param id
     * @return
     * @date 2020-12-14 11:25:15
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
     * @getLabelId:LABEL_ID的get方法
     * @params
     * @return labelId
     * @date 2020-12-14 11:25:15
     * @author 18511
     */
    public String getLabelId(){
        return this.labelId;
    }
    /**
     * @setLabelId:LABEL_ID的set方法
     * @param labelId
     * @return
     * @date 2020-12-14 11:25:15
     * @author 18511
     */
    public void setLabelId(String labelId){
		this.labelId = labelId;
	} 
    /**
     * @getLabelName:LABEL_NAME的get方法
     * @params
     * @return labelName
     * @date 2020-12-14 11:25:15
     * @author 18511
     */
    public String getLabelName(){
        return this.labelName;
    }
    /**
     * @setLabelName:LABEL_NAME的set方法
     * @param labelName
     * @return
     * @date 2020-12-14 11:25:15
     * @author 18511
     */
    public void setLabelName(String labelName){
		this.labelName = labelName;
	} 
    /**
     * @getLabelStatus:LABEL_STATUS的get方法
     * @params
     * @return labelStatus
     * @date 2020-12-14 11:25:15
     * @author 18511
     */
    public String getLabelStatus(){
        return this.labelStatus;
    }
    /**
     * @setLabelStatus:LABEL_STATUS的set方法
     * @param labelStatus
     * @return
     * @date 2020-12-14 11:25:15
     * @author 18511
     */
    public void setLabelStatus(String labelStatus){
		this.labelStatus = labelStatus;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-12-14 11:25:15
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-12-14 11:25:15
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
		
        if (obj == null || !(obj instanceof BaseLabel))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		BaseLabel other = (BaseLabel) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (labelId == null) {
			if (other.labelId != null) {
				return false;
			}
		} else if (!labelId.equals(other.labelId)) {
			return false;
		}
		if (labelName == null) {
			if (other.labelName != null) {
				return false;
			}
		} else if (!labelName.equals(other.labelName)) {
			return false;
		}
		if (labelStatus == null) {
			if (other.labelStatus != null) {
				return false;
			}
		} else if (!labelStatus.equals(other.labelStatus)) {
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
		return "BaseLabel ["
			+ ", id=" + id
			+ ", labelId=" + labelId
			+ ", labelName=" + labelName
			+ ", labelStatus=" + labelStatus
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