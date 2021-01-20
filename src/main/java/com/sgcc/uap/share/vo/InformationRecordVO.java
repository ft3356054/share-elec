package com.sgcc.uap.share.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * InformationRecord的VO类
 *
 * @author 18511 
 */
public class InformationRecordVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性INFORMATION_RECORD_ID
     */  
    @ViewAttribute(name ="informationRecordId",caption="INFORMATION_RECORD_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String informationRecordId;    
    /** 
     * 属性INFORMATION_ID
     */  
    @ViewAttribute(name ="informationId",caption="INFORMATION_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String informationId;    
    /** 
     * 属性INFORMATION_TYPE
     */  
    @ViewAttribute(name ="informationType",caption="INFORMATION_TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String informationType;    
    /** 
     * 属性INFORMATION_STATUS
     */  
    @ViewAttribute(name ="informationStatus",caption="INFORMATION_STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String informationStatus;    
    /** 
     * 属性CREATE_TIME
     */  
    @ViewAttribute(name ="createTime",caption="CREATE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp createTime;    
    /** 
     * 属性CREATE_SERVICE_ID
     */  
    @ViewAttribute(name ="createServiceId",caption="CREATE_SERVICE_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String createServiceId;    
    /** 
     * 属性SERVICE_ID
     */  
    @ViewAttribute(name ="serviceId",caption="SERVICE_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String serviceId;    
    /** 
     * 属性SERVICE_DESC
     */  
    @ViewAttribute(name ="serviceDesc",caption="SERVICE_DESC", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String serviceDesc;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * InformationRecordVO构造函数
     */
    public InformationRecordVO() {
        super();
    } 
   
	 /**
     * InformationRecordVO完整的构造函数
     */  
    public InformationRecordVO(String informationRecordId){
        this.informationRecordId = informationRecordId;
    }
    /**
     * INFORMATION_RECORD_ID的get方法
     * @return informationRecordId
     */
    public String getInformationRecordId(){
        return informationRecordId;
    }
    /**
     * INFORMATION_RECORD_ID的set方法
     * @param informationRecordId
     */
    public void setInformationRecordId(String informationRecordId){
        if(informationRecordId != null && informationRecordId.trim().length() == 0){
        	this.informationRecordId = null;
        }else{
        	this.informationRecordId = informationRecordId;
        }
	} 
    /**
     * INFORMATION_ID的get方法
     * @return informationId
     */
    public String getInformationId(){
        return informationId;
    }
    /**
     * INFORMATION_ID的set方法
     * @param informationId
     */
    public void setInformationId(String informationId){
		this.informationId = informationId;
	} 
    /**
     * INFORMATION_TYPE的get方法
     * @return informationType
     */
    public String getInformationType(){
        return informationType;
    }
    /**
     * INFORMATION_TYPE的set方法
     * @param informationType
     */
    public void setInformationType(String informationType){
		this.informationType = informationType;
	} 
    /**
     * INFORMATION_STATUS的get方法
     * @return informationStatus
     */
    public String getInformationStatus(){
        return informationStatus;
    }
    /**
     * INFORMATION_STATUS的set方法
     * @param informationStatus
     */
    public void setInformationStatus(String informationStatus){
		this.informationStatus = informationStatus;
	} 
    /**
     * CREATE_TIME的get方法
     * @return createTime
     */
    public Timestamp getCreateTime(){
        return createTime;
    }
    /**
     * CREATE_TIME的set方法
     * @param createTime
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	} 
    /**
     * CREATE_SERVICE_ID的get方法
     * @return createServiceId
     */
    public String getCreateServiceId(){
        return createServiceId;
    }
    /**
     * CREATE_SERVICE_ID的set方法
     * @param createServiceId
     */
    public void setCreateServiceId(String createServiceId){
		this.createServiceId = createServiceId;
	} 
    /**
     * SERVICE_ID的get方法
     * @return serviceId
     */
    public String getServiceId(){
        return serviceId;
    }
    /**
     * SERVICE_ID的set方法
     * @param serviceId
     */
    public void setServiceId(String serviceId){
		this.serviceId = serviceId;
	} 
    /**
     * SERVICE_DESC的get方法
     * @return serviceDesc
     */
    public String getServiceDesc(){
        return serviceDesc;
    }
    /**
     * SERVICE_DESC的set方法
     * @param serviceDesc
     */
    public void setServiceDesc(String serviceDesc){
		this.serviceDesc = serviceDesc;
	} 
    /**
     * REMARK的get方法
     * @return remark
     */
    public String getRemark(){
        return remark;
    }
    /**
     * REMARK的set方法
     * @param remark
     */
    public void setRemark(String remark){
		this.remark = remark;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("INFORMATION_RECORD_ID"+":"+getInformationRecordId())
				.append("INFORMATION_ID"+":"+getInformationId())
				.append("INFORMATION_TYPE"+":"+getInformationType())
				.append("INFORMATION_STATUS"+":"+getInformationStatus())
				.append("CREATE_TIME"+":"+getCreateTime())
				.append("CREATE_SERVICE_ID"+":"+getCreateServiceId())
				.append("SERVICE_ID"+":"+getServiceId())
				.append("SERVICE_DESC"+":"+getServiceDesc())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
