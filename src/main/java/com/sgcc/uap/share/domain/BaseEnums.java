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
 * BaseEnums的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "base_enums")
public class BaseEnums implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * 身份ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "identity")
    @Column(name = "ENUMS_ID", nullable = false, length = 8)
    private String enumsId ;
    
    /** 
     * 身份名称
     */
    @Column(name = "ENUMS_TYPE", nullable = true, length = 4)
    private String enumsType ;
    
    /** 
     * ENUMS_STATUS
     */
    @Column(name = "ENUMS_STATUS", nullable = true, length = 4)
    private String enumsStatus ;
    
    /** 
     * ENUMS_A
     */
    @Column(name = "ENUMS_A", nullable = true, length = 64)
    private String enumsA ;
    
    /** 
     * ENUMS_B
     */
    @Column(name = "ENUMS_B", nullable = true, length = 64)
    private String enumsB ;
    
    /** 
     * ENUMS_C
     */
    @Column(name = "ENUMS_C", nullable = true, length = 64)
    private String enumsC ;
    
    /** 
     * ENUMS_D
     */
    @Column(name = "ENUMS_D", nullable = true, length = 64)
    private String enumsD ;
    
    /** 
     * ENUMS_E
     */
    @Column(name = "ENUMS_E", nullable = true, length = 64)
    private String enumsE ;
    
    /** 
     * ENUMS_F
     */
    @Column(name = "ENUMS_F", nullable = true, length = 64)
    private String enumsF ;
    
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
	
	public BaseEnums(){
	
	}
    /**
     * @getEnumsId:身份ID的get方法
     * @params
     * @return enumsId
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public String getEnumsId(){
        return this.enumsId;
    }
    /**
     * @setEnumsId:身份ID的set方法
     * @param enumsId
     * @return
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public void setEnumsId(String enumsId){
        if(enumsId != null && enumsId.trim().length() == 0){
        	this.enumsId = null;
        }else{
        	this.enumsId = enumsId;
        }
	} 
    /**
     * @getEnumsType:身份名称的get方法
     * @params
     * @return enumsType
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public String getEnumsType(){
        return this.enumsType;
    }
    /**
     * @setEnumsType:身份名称的set方法
     * @param enumsType
     * @return
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public void setEnumsType(String enumsType){
		this.enumsType = enumsType;
	} 
    /**
     * @getEnumsStatus:ENUMS_STATUS的get方法
     * @params
     * @return enumsStatus
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public String getEnumsStatus(){
        return this.enumsStatus;
    }
    /**
     * @setEnumsStatus:ENUMS_STATUS的set方法
     * @param enumsStatus
     * @return
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public void setEnumsStatus(String enumsStatus){
		this.enumsStatus = enumsStatus;
	} 
    /**
     * @getEnumsA:ENUMS_A的get方法
     * @params
     * @return enumsA
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public String getEnumsA(){
        return this.enumsA;
    }
    /**
     * @setEnumsA:ENUMS_A的set方法
     * @param enumsA
     * @return
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public void setEnumsA(String enumsA){
		this.enumsA = enumsA;
	} 
    /**
     * @getEnumsB:ENUMS_B的get方法
     * @params
     * @return enumsB
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public String getEnumsB(){
        return this.enumsB;
    }
    /**
     * @setEnumsB:ENUMS_B的set方法
     * @param enumsB
     * @return
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public void setEnumsB(String enumsB){
		this.enumsB = enumsB;
	} 
    /**
     * @getEnumsC:ENUMS_C的get方法
     * @params
     * @return enumsC
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public String getEnumsC(){
        return this.enumsC;
    }
    /**
     * @setEnumsC:ENUMS_C的set方法
     * @param enumsC
     * @return
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public void setEnumsC(String enumsC){
		this.enumsC = enumsC;
	} 
    /**
     * @getEnumsD:ENUMS_D的get方法
     * @params
     * @return enumsD
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public String getEnumsD(){
        return this.enumsD;
    }
    /**
     * @setEnumsD:ENUMS_D的set方法
     * @param enumsD
     * @return
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public void setEnumsD(String enumsD){
		this.enumsD = enumsD;
	} 
    /**
     * @getEnumsE:ENUMS_E的get方法
     * @params
     * @return enumsE
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public String getEnumsE(){
        return this.enumsE;
    }
    /**
     * @setEnumsE:ENUMS_E的set方法
     * @param enumsE
     * @return
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public void setEnumsE(String enumsE){
		this.enumsE = enumsE;
	} 
    /**
     * @getEnumsF:ENUMS_F的get方法
     * @params
     * @return enumsF
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public String getEnumsF(){
        return this.enumsF;
    }
    /**
     * @setEnumsF:ENUMS_F的set方法
     * @param enumsF
     * @return
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public void setEnumsF(String enumsF){
		this.enumsF = enumsF;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2020-12-11 10:02:24
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2020-12-11 10:02:24
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
		
        if (obj == null || !(obj instanceof BaseEnums))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		BaseEnums other = (BaseEnums) obj;
		
		if (enumsId == null) {
			if (other.enumsId != null) {
				return false;
			}
		} else if (!enumsId.equals(other.enumsId)) {
			return false;
		}
		if (enumsType == null) {
			if (other.enumsType != null) {
				return false;
			}
		} else if (!enumsType.equals(other.enumsType)) {
			return false;
		}
		if (enumsStatus == null) {
			if (other.enumsStatus != null) {
				return false;
			}
		} else if (!enumsStatus.equals(other.enumsStatus)) {
			return false;
		}
		if (enumsA == null) {
			if (other.enumsA != null) {
				return false;
			}
		} else if (!enumsA.equals(other.enumsA)) {
			return false;
		}
		if (enumsB == null) {
			if (other.enumsB != null) {
				return false;
			}
		} else if (!enumsB.equals(other.enumsB)) {
			return false;
		}
		if (enumsC == null) {
			if (other.enumsC != null) {
				return false;
			}
		} else if (!enumsC.equals(other.enumsC)) {
			return false;
		}
		if (enumsD == null) {
			if (other.enumsD != null) {
				return false;
			}
		} else if (!enumsD.equals(other.enumsD)) {
			return false;
		}
		if (enumsE == null) {
			if (other.enumsE != null) {
				return false;
			}
		} else if (!enumsE.equals(other.enumsE)) {
			return false;
		}
		if (enumsF == null) {
			if (other.enumsF != null) {
				return false;
			}
		} else if (!enumsF.equals(other.enumsF)) {
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
		return "BaseEnums ["
			+ ", enumsId=" + enumsId
			+ ", enumsType=" + enumsType
			+ ", enumsStatus=" + enumsStatus
			+ ", enumsA=" + enumsA
			+ ", enumsB=" + enumsB
			+ ", enumsC=" + enumsC
			+ ", enumsD=" + enumsD
			+ ", enumsE=" + enumsE
			+ ", enumsF=" + enumsF
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