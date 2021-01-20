package com.sgcc.uap.share.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * InformationNotify的VO类
 *
 * @author 18511 
 */
public class InformationNotifyVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性INFORMATION_ID
     */  
    @ViewAttribute(name ="informationId",caption="INFORMATION_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
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
     * 属性UPDATE_TIME
     */  
    @ViewAttribute(name ="updateTime",caption="UPDATE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp updateTime;    
    /** 
     * 属性FINISH_TIME
     */  
    @ViewAttribute(name ="finishTime",caption="FINISH_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp finishTime;    
    /** 
     * 属性SERVICE_ID
     */  
    @ViewAttribute(name ="serviceId",caption="SERVICE_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String serviceId;    
    /** 
     * 属性SERVICE_NAME
     */  
    @ViewAttribute(name ="serviceName",caption="SERVICE_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String serviceName;    
    /** 
     * 属性INFORMATION_TITLE
     */  
    @ViewAttribute(name ="informationTitle",caption="INFORMATION_TITLE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String informationTitle;    
    /** 
     * 属性INFORMATION_FROM
     */  
    @ViewAttribute(name ="informationFrom",caption="INFORMATION_FROM", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String informationFrom;    
    /** 
     * 属性KEYWORD
     */  
    @ViewAttribute(name ="keyword",caption="KEYWORD", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String keyword;    
    /** 
     * 属性INFORMATION_ICON
     */  
    @ViewAttribute(name ="informationIcon",caption="INFORMATION_ICON", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String informationIcon;    
    /** 
     * 属性INFORMATION_CONTENT
     */  
    @ViewAttribute(name ="informationContent",caption="INFORMATION_CONTENT", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String informationContent;    
    /** 
     * 属性PRIORITY
     */  
    @ViewAttribute(name ="priority",caption="PRIORITY", editor=EditorType.NumberEditor,nullable =true,readOnly=false, type=AttributeType.INTEGER)
    private Integer priority;    
    /** 
     * 属性READ_COUNT
     */  
    @ViewAttribute(name ="readCount",caption="READ_COUNT", editor=EditorType.NumberEditor,nullable =true,readOnly=false, type=AttributeType.INTEGER)
    private Integer readCount;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * InformationNotifyVO构造函数
     */
    public InformationNotifyVO() {
        super();
    } 
   
	 /**
     * InformationNotifyVO完整的构造函数
     */  
    public InformationNotifyVO(String informationId){
        this.informationId = informationId;
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
        if(informationId != null && informationId.trim().length() == 0){
        	this.informationId = null;
        }else{
        	this.informationId = informationId;
        }
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
     * UPDATE_TIME的get方法
     * @return updateTime
     */
    public Timestamp getUpdateTime(){
        return updateTime;
    }
    /**
     * UPDATE_TIME的set方法
     * @param updateTime
     */
    public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * FINISH_TIME的get方法
     * @return finishTime
     */
    public Timestamp getFinishTime(){
        return finishTime;
    }
    /**
     * FINISH_TIME的set方法
     * @param finishTime
     */
    public void setFinishTime(Timestamp finishTime){
		this.finishTime = finishTime;
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
     * SERVICE_NAME的get方法
     * @return serviceName
     */
    public String getServiceName(){
        return serviceName;
    }
    /**
     * SERVICE_NAME的set方法
     * @param serviceName
     */
    public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	} 
    /**
     * INFORMATION_TITLE的get方法
     * @return informationTitle
     */
    public String getInformationTitle(){
        return informationTitle;
    }
    /**
     * INFORMATION_TITLE的set方法
     * @param informationTitle
     */
    public void setInformationTitle(String informationTitle){
		this.informationTitle = informationTitle;
	} 
    /**
     * INFORMATION_FROM的get方法
     * @return informationFrom
     */
    public String getInformationFrom(){
        return informationFrom;
    }
    /**
     * INFORMATION_FROM的set方法
     * @param informationFrom
     */
    public void setInformationFrom(String informationFrom){
		this.informationFrom = informationFrom;
	} 
    /**
     * KEYWORD的get方法
     * @return keyword
     */
    public String getKeyword(){
        return keyword;
    }
    /**
     * KEYWORD的set方法
     * @param keyword
     */
    public void setKeyword(String keyword){
		this.keyword = keyword;
	} 
    /**
     * INFORMATION_ICON的get方法
     * @return informationIcon
     */
    public String getInformationIcon(){
        return informationIcon;
    }
    /**
     * INFORMATION_ICON的set方法
     * @param informationIcon
     */
    public void setInformationIcon(String informationIcon){
		this.informationIcon = informationIcon;
	} 
    /**
     * INFORMATION_CONTENT的get方法
     * @return informationContent
     */
    public String getInformationContent(){
        return informationContent;
    }
    /**
     * INFORMATION_CONTENT的set方法
     * @param informationContent
     */
    public void setInformationContent(String informationContent){
		this.informationContent = informationContent;
	} 
    /**
     * PRIORITY的get方法
     * @return priority
     */
    public Integer getPriority(){
        return priority;
    }
    /**
     * PRIORITY的set方法
     * @param priority
     */
    public void setPriority(Integer priority){
		this.priority = priority;
	} 
    /**
     * READ_COUNT的get方法
     * @return readCount
     */
    public Integer getReadCount(){
        return readCount;
    }
    /**
     * READ_COUNT的set方法
     * @param readCount
     */
    public void setReadCount(Integer readCount){
		this.readCount = readCount;
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
	  			.append("INFORMATION_ID"+":"+getInformationId())
				.append("INFORMATION_TYPE"+":"+getInformationType())
				.append("INFORMATION_STATUS"+":"+getInformationStatus())
				.append("CREATE_TIME"+":"+getCreateTime())
				.append("UPDATE_TIME"+":"+getUpdateTime())
				.append("FINISH_TIME"+":"+getFinishTime())
				.append("SERVICE_ID"+":"+getServiceId())
				.append("SERVICE_NAME"+":"+getServiceName())
				.append("INFORMATION_TITLE"+":"+getInformationTitle())
				.append("INFORMATION_FROM"+":"+getInformationFrom())
				.append("KEYWORD"+":"+getKeyword())
				.append("INFORMATION_ICON"+":"+getInformationIcon())
				.append("INFORMATION_CONTENT"+":"+getInformationContent())
				.append("PRIORITY"+":"+getPriority())
				.append("READ_COUNT"+":"+getReadCount())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
