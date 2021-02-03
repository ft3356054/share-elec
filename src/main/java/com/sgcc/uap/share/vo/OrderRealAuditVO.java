package com.sgcc.uap.share.vo;

import java.io.Serializable;

import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * OrderRealAudit的VO类
 *
 * @author 18511 
 */
public class OrderRealAuditVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ORDER_ID
     */  
    @ViewAttribute(name ="orderId",caption="ORDER_ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String orderId;    
    /** 
     * 属性ORDER_STATUS
     */  
    @ViewAttribute(name ="orderStatus",caption="ORDER_STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String orderStatus;    
    /** 
     * 属性CREATE_TIME
     */  
    @ViewAttribute(name ="createTime",caption="CREATE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private String createTime;    
    /** 
     * 属性UPDATE_TIME
     */  
    @ViewAttribute(name ="updateTime",caption="UPDATE_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private String updateTime;    
    /** 
     * 属性FINISH_TIME
     */  
    @ViewAttribute(name ="finishTime",caption="FINISH_TIME", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private String finishTime;    
    /** 
     * 属性AUDITOR_ID
     */  
    @ViewAttribute(name ="auditorId",caption="AUDITOR_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String auditorId;    
    /** 
     * 属性AUDITOR_COMMENT
     */  
    @ViewAttribute(name ="auditorComment",caption="AUDITOR_COMMENT", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String auditorComment;    
    /** 
     * 属性USER_ID
     */  
    @ViewAttribute(name ="userId",caption="USER_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String userId;    
    /** 
     * 属性USER_NAME
     */  
    @ViewAttribute(name ="userName",caption="USER_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String userName;    
    /** 
     * 属性USER_TYPE
     */  
    @ViewAttribute(name ="userType",caption="USER_TYPE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String userType;    
    /** 
     * 属性COMPANY_ID
     */  
    @ViewAttribute(name ="companyId",caption="COMPANY_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String companyId;    
    /** 
     * 属性PHONENUMBER
     */  
    @ViewAttribute(name ="phonenumber",caption="PHONENUMBER", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String phonenumber;    
    /** 
     * 属性EMAIL
     */  
    @ViewAttribute(name ="email",caption="EMAIL", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String email;    
    /** 
     * 属性ADDRESS
     */  
    @ViewAttribute(name ="address",caption="ADDRESS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String address;    
    /** 
     * 属性ID_CARD_NUM
     */  
    @ViewAttribute(name ="idCardNum",caption="ID_CARD_NUM", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String idCardNum;    
    /** 
     * 属性ID_CARD_FIRST
     */  
    @ViewAttribute(name ="idCardFirst",caption="ID_CARD_FIRST", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String idCardFirst;    
    /** 
     * 属性ID_CARD_SECOND
     */  
    @ViewAttribute(name ="idCardSecond",caption="ID_CARD_SECOND", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String idCardSecond;    
    /** 
     * 属性USER_ICON
     */  
    @ViewAttribute(name ="userIcon",caption="USER_ICON", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String userIcon;    
    /** 
     * 属性REMARK
     */  
    @ViewAttribute(name ="remark",caption="REMARK", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remark;    
    /**
     * OrderRealAuditVO构造函数
     */
    public OrderRealAuditVO() {
        super();
    } 
   
	 /**
     * OrderRealAuditVO完整的构造函数
     */  
    public OrderRealAuditVO(String orderId){
        this.orderId = orderId;
    }
    /**
     * ORDER_ID的get方法
     * @return orderId
     */
    public String getOrderId(){
        return orderId;
    }
    /**
     * ORDER_ID的set方法
     * @param orderId
     */
    public void setOrderId(String orderId){
        if(orderId != null && orderId.trim().length() == 0){
        	this.orderId = null;
        }else{
        	this.orderId = orderId;
        }
	} 
    /**
     * ORDER_STATUS的get方法
     * @return orderStatus
     */
    public String getOrderStatus(){
        return orderStatus;
    }
    /**
     * ORDER_STATUS的set方法
     * @param orderStatus
     */
    public void setOrderStatus(String orderStatus){
		this.orderStatus = orderStatus;
	} 
    /**
     * CREATE_TIME的get方法
     * @return createTime
     */
    public String getCreateTime(){
        return createTime;
    }
    /**
     * CREATE_TIME的set方法
     * @param createTime
     */
    public void setCreateTime(String createTime){
		this.createTime = createTime;
	} 
    /**
     * UPDATE_TIME的get方法
     * @return updateTime
     */
    public String getUpdateTime(){
        return updateTime;
    }
    /**
     * UPDATE_TIME的set方法
     * @param updateTime
     */
    public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * FINISH_TIME的get方法
     * @return finishTime
     */
    public String getFinishTime(){
        return finishTime;
    }
    /**
     * FINISH_TIME的set方法
     * @param finishTime
     */
    public void setFinishTime(String finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * AUDITOR_ID的get方法
     * @return auditorId
     */
    public String getAuditorId(){
        return auditorId;
    }
    /**
     * AUDITOR_ID的set方法
     * @param auditorId
     */
    public void setAuditorId(String auditorId){
		this.auditorId = auditorId;
	} 
    /**
     * AUDITOR_COMMENT的get方法
     * @return auditorComment
     */
    public String getAuditorComment(){
        return auditorComment;
    }
    /**
     * AUDITOR_COMMENT的set方法
     * @param auditorComment
     */
    public void setAuditorComment(String auditorComment){
		this.auditorComment = auditorComment;
	} 
    /**
     * USER_ID的get方法
     * @return userId
     */
    public String getUserId(){
        return userId;
    }
    /**
     * USER_ID的set方法
     * @param userId
     */
    public void setUserId(String userId){
		this.userId = userId;
	} 
    /**
     * USER_NAME的get方法
     * @return userName
     */
    public String getUserName(){
        return userName;
    }
    /**
     * USER_NAME的set方法
     * @param userName
     */
    public void setUserName(String userName){
		this.userName = userName;
	} 
    /**
     * USER_TYPE的get方法
     * @return userType
     */
    public String getUserType(){
        return userType;
    }
    /**
     * USER_TYPE的set方法
     * @param userType
     */
    public void setUserType(String userType){
		this.userType = userType;
	} 
    /**
     * COMPANY_ID的get方法
     * @return companyId
     */
    public String getCompanyId(){
        return companyId;
    }
    /**
     * COMPANY_ID的set方法
     * @param companyId
     */
    public void setCompanyId(String companyId){
		this.companyId = companyId;
	} 
    /**
     * PHONENUMBER的get方法
     * @return phonenumber
     */
    public String getPhonenumber(){
        return phonenumber;
    }
    /**
     * PHONENUMBER的set方法
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber){
		this.phonenumber = phonenumber;
	} 
    /**
     * EMAIL的get方法
     * @return email
     */
    public String getEmail(){
        return email;
    }
    /**
     * EMAIL的set方法
     * @param email
     */
    public void setEmail(String email){
		this.email = email;
	} 
    /**
     * ADDRESS的get方法
     * @return address
     */
    public String getAddress(){
        return address;
    }
    /**
     * ADDRESS的set方法
     * @param address
     */
    public void setAddress(String address){
		this.address = address;
	} 
    /**
     * ID_CARD_NUM的get方法
     * @return idCardNum
     */
    public String getIdCardNum(){
        return idCardNum;
    }
    /**
     * ID_CARD_NUM的set方法
     * @param idCardNum
     */
    public void setIdCardNum(String idCardNum){
		this.idCardNum = idCardNum;
	} 
    /**
     * ID_CARD_FIRST的get方法
     * @return idCardFirst
     */
    public String getIdCardFirst(){
        return idCardFirst;
    }
    /**
     * ID_CARD_FIRST的set方法
     * @param idCardFirst
     */
    public void setIdCardFirst(String idCardFirst){
		this.idCardFirst = idCardFirst;
	} 
    /**
     * ID_CARD_SECOND的get方法
     * @return idCardSecond
     */
    public String getIdCardSecond(){
        return idCardSecond;
    }
    /**
     * ID_CARD_SECOND的set方法
     * @param idCardSecond
     */
    public void setIdCardSecond(String idCardSecond){
		this.idCardSecond = idCardSecond;
	} 
    /**
     * USER_ICON的get方法
     * @return userIcon
     */
    public String getUserIcon(){
        return userIcon;
    }
    /**
     * USER_ICON的set方法
     * @param userIcon
     */
    public void setUserIcon(String userIcon){
		this.userIcon = userIcon;
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
	  			.append("ORDER_ID"+":"+getOrderId())
				.append("ORDER_STATUS"+":"+getOrderStatus())
				.append("CREATE_TIME"+":"+getCreateTime())
				.append("UPDATE_TIME"+":"+getUpdateTime())
				.append("FINISH_TIME"+":"+getFinishTime())
				.append("AUDITOR_ID"+":"+getAuditorId())
				.append("AUDITOR_COMMENT"+":"+getAuditorComment())
				.append("USER_ID"+":"+getUserId())
				.append("USER_NAME"+":"+getUserName())
				.append("USER_TYPE"+":"+getUserType())
				.append("COMPANY_ID"+":"+getCompanyId())
				.append("PHONENUMBER"+":"+getPhonenumber())
				.append("EMAIL"+":"+getEmail())
				.append("ADDRESS"+":"+getAddress())
				.append("ID_CARD_NUM"+":"+getIdCardNum())
				.append("ID_CARD_FIRST"+":"+getIdCardFirst())
				.append("ID_CARD_SECOND"+":"+getIdCardSecond())
				.append("USER_ICON"+":"+getUserIcon())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
