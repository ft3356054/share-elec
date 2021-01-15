package com.sgcc.uap.share.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


/**
 * BaseComplantOpening的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "base_complant_opening")
public class BaseComplantOpening implements Serializable {

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
    @Column(name = "OPENING_ID", nullable = false, length = 10)
    private Long openingId ;
    
    /** 
     * 身份名称
     */
    @Column(name = "ON_BUSINESS_BEGIN", nullable = true, length = 19)
    private Timestamp onBusinessBegin ;
    
    /** 
     * ON_BUSINESS_END
     */
    @Column(name = "ON_BUSINESS_END", nullable = true, length = 19)
    private Timestamp onBusinessEnd ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public BaseComplantOpening(){
	
	}
    /**
     * @getOpeningId:身份ID的get方法
     * @params
     * @return openingId
     * @date 2021-01-15 10:09:45
     * @author 18511
     */
    public Long getOpeningId(){
        return this.openingId;
    }
    /**
     * @setOpeningId:身份ID的set方法
     * @param openingId
     * @return
     * @date 2021-01-15 10:09:45
     * @author 18511
     */
    public void setOpeningId(Long openingId){
		this.openingId = openingId;
	} 
    /**
     * @getOnBusinessBegin:身份名称的get方法
     * @params
     * @return onBusinessBegin
     * @date 2021-01-15 10:09:45
     * @author 18511
     */
    public Timestamp getOnBusinessBegin(){
        return this.onBusinessBegin;
    }
    /**
     * @setOnBusinessBegin:身份名称的set方法
     * @param onBusinessBegin
     * @return
     * @date 2021-01-15 10:09:45
     * @author 18511
     */
    public void setOnBusinessBegin(Timestamp onBusinessBegin){
		this.onBusinessBegin = onBusinessBegin;
	} 
    /**
     * @getOnBusinessEnd:ON_BUSINESS_END的get方法
     * @params
     * @return onBusinessEnd
     * @date 2021-01-15 10:09:45
     * @author 18511
     */
    public Timestamp getOnBusinessEnd(){
        return this.onBusinessEnd;
    }
    /**
     * @setOnBusinessEnd:ON_BUSINESS_END的set方法
     * @param onBusinessEnd
     * @return
     * @date 2021-01-15 10:09:45
     * @author 18511
     */
    public void setOnBusinessEnd(Timestamp onBusinessEnd){
		this.onBusinessEnd = onBusinessEnd;
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
		
        if (obj == null || !(obj instanceof BaseComplantOpening))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		BaseComplantOpening other = (BaseComplantOpening) obj;
		
		if (openingId == null) {
			if (other.openingId != null) {
				return false;
			}
		} else if (!openingId.equals(other.openingId)) {
			return false;
		}
		if (onBusinessBegin == null) {
			if (other.onBusinessBegin != null) {
				return false;
			}
		} else if (!onBusinessBegin.equals(other.onBusinessBegin)) {
			return false;
		}
		if (onBusinessEnd == null) {
			if (other.onBusinessEnd != null) {
				return false;
			}
		} else if (!onBusinessEnd.equals(other.onBusinessEnd)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "BaseComplantOpening ["
			+ ", openingId=" + openingId
			+ ", onBusinessBegin=" + onBusinessBegin
			+ ", onBusinessEnd=" + onBusinessEnd;
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