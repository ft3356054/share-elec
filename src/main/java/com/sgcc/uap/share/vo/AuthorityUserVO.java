package com.sgcc.uap.share.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * AuthorityUser的VO类
 *
 * @author 18511 
 */
public class AuthorityUserVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性ID
     */  
    @ViewAttribute(name ="id",caption="ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性USER_ACCOUNT
     */  
    @ViewAttribute(name ="userAccount",caption="USER_ACCOUNT", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String userAccount;    
    /** 
     * 属性PASSWORD
     */  
    @ViewAttribute(name ="_password",caption="PASSWORD", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String _password;    
    /** 
     * 属性OPEN_ID
     */  
    @ViewAttribute(name ="openId",caption="OPEN_ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String openId;    
    /** 
     * 属性USER_NAME
     */  
    @ViewAttribute(name ="userName",caption="USER_NAME", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String userName;    
    /** 
     * 属性USER_DESC
     */  
    @ViewAttribute(name ="userDesc",caption="USER_DESC", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String userDesc;    
    /** 
     * 属性STATUS
     */  
    @ViewAttribute(name ="_status",caption="STATUS", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String _status;    
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
     * 属性CERTIFICATE
     */  
    @ViewAttribute(name ="certificate",caption="CERTIFICATE", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String certificate;    
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
     * AuthorityUserVO构造函数
     */
    public AuthorityUserVO() {
        super();
    } 
   
	 /**
     * AuthorityUserVO完整的构造函数
     */  
    public AuthorityUserVO(String id){
        this.id = id;
    }
    /**
     * ID的get方法
     * @return id
     */
    public String getId(){
        return id;
    }
    /**
     * ID的set方法
     * @param id
     */
    public void setId(String id){
        if(id != null && id.trim().length() == 0){
        	this.id = null;
        }else{
        	this.id = id;
        }
	} 
    /**
     * USER_ACCOUNT的get方法
     * @return userAccount
     */
    public String getUserAccount(){
        return userAccount;
    }
    /**
     * USER_ACCOUNT的set方法
     * @param userAccount
     */
    public void setUserAccount(String userAccount){
		this.userAccount = userAccount;
	} 
    /**
     * PASSWORD的get方法
     * @return _password
     */
    public String get_password(){
        return _password;
    }
    /**
     * PASSWORD的set方法
     * @param _password
     */
    public void set_password(String _password){
		this._password = _password;
	} 
    /**
     * OPEN_ID的get方法
     * @return openId
     */
    public String getOpenId(){
        return openId;
    }
    /**
     * OPEN_ID的set方法
     * @param openId
     */
    public void setOpenId(String openId){
		this.openId = openId;
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
     * USER_DESC的get方法
     * @return userDesc
     */
    public String getUserDesc(){
        return userDesc;
    }
    /**
     * USER_DESC的set方法
     * @param userDesc
     */
    public void setUserDesc(String userDesc){
		this.userDesc = userDesc;
	} 
    /**
     * STATUS的get方法
     * @return _status
     */
    public String get_status(){
        return _status;
    }
    /**
     * STATUS的set方法
     * @param _status
     */
    public void set_status(String _status){
		this._status = _status;
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
     * CERTIFICATE的get方法
     * @return certificate
     */
    public String getCertificate(){
        return certificate;
    }
    /**
     * CERTIFICATE的set方法
     * @param certificate
     */
    public void setCertificate(String certificate){
		this.certificate = certificate;
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
	  			.append("ID"+":"+getId())
				.append("USER_ACCOUNT"+":"+getUserAccount())
				.append("PASSWORD"+":"+get_password())
				.append("OPEN_ID"+":"+getOpenId())
				.append("USER_NAME"+":"+getUserName())
				.append("USER_DESC"+":"+getUserDesc())
				.append("STATUS"+":"+get_status())
				.append("USER_TYPE"+":"+getUserType())
				.append("COMPANY_ID"+":"+getCompanyId())
				.append("PHONENUMBER"+":"+getPhonenumber())
				.append("EMAIL"+":"+getEmail())
				.append("ADDRESS"+":"+getAddress())
				.append("ID_CARD_NUM"+":"+getIdCardNum())
				.append("ID_CARD_FIRST"+":"+getIdCardFirst())
				.append("ID_CARD_SECOND"+":"+getIdCardSecond())
				.append("CERTIFICATE"+":"+getCertificate())
				.append("CREATE_TIME"+":"+getCreateTime())
				.append("UPDATE_TIME"+":"+getUpdateTime())
				.append("FINISH_TIME"+":"+getFinishTime())
				.append("USER_ICON"+":"+getUserIcon())
				.append("REMARK"+":"+getRemark())
		        .toString(); 
			
    } 
   


}
