package com.sgcc.uap.share.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * BaseComplantOpening的VO类
 *
 * @author 18511 
 */
public class BaseComplantOpeningVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性身份ID
     */  
    @ViewAttribute(name ="openingId",caption="身份ID", editor=EditorType.NumberEditor,nullable =false,readOnly=false, type=AttributeType.LONG)
    private Long openingId;    
    /** 
     * 属性身份名称
     */  
    @ViewAttribute(name ="onBusinessBegin",caption="身份名称", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp onBusinessBegin;    
    /** 
     * 属性ON_BUSINESS_END
     */  
    @ViewAttribute(name ="onBusinessEnd",caption="ON_BUSINESS_END", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp onBusinessEnd;    
    /**
     * BaseComplantOpeningVO构造函数
     */
    public BaseComplantOpeningVO() {
        super();
    } 
   
	 /**
     * BaseComplantOpeningVO完整的构造函数
     */  
    public BaseComplantOpeningVO(Long openingId){
        this.openingId = openingId;
    }
    /**
     * 身份ID的get方法
     * @return openingId
     */
    public Long getOpeningId(){
        return openingId;
    }
    /**
     * 身份ID的set方法
     * @param openingId
     */
    public void setOpeningId(Long openingId){
		this.openingId = openingId;
	} 
    /**
     * 身份名称的get方法
     * @return onBusinessBegin
     */
    public Timestamp getOnBusinessBegin(){
        return onBusinessBegin;
    }
    /**
     * 身份名称的set方法
     * @param onBusinessBegin
     */
    public void setOnBusinessBegin(Timestamp onBusinessBegin){
		this.onBusinessBegin = onBusinessBegin;
	} 
    /**
     * ON_BUSINESS_END的get方法
     * @return onBusinessEnd
     */
    public Timestamp getOnBusinessEnd(){
        return onBusinessEnd;
    }
    /**
     * ON_BUSINESS_END的set方法
     * @param onBusinessEnd
     */
    public void setOnBusinessEnd(Timestamp onBusinessEnd){
		this.onBusinessEnd = onBusinessEnd;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("OPENING_ID"+":"+getOpeningId())
				.append("ON_BUSINESS_BEGIN"+":"+getOnBusinessBegin())
				.append("ON_BUSINESS_END"+":"+getOnBusinessEnd())
		        .toString(); 
			
    } 
   


}
