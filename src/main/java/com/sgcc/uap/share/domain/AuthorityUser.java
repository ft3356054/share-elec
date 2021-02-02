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
 * AuthorityUser的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "authority_user")
public class AuthorityUser implements Serializable {

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
     * USER_ACCOUNT
     */
    @Column(name = "USER_ACCOUNT", nullable = true, length = 64)
    private String userAccount ;
    
    /** 
     * PASSWORD
     */
    @Column(name = "PASSWORD", nullable = true, length = 64)
    private String _password ;
    
    /** 
     * OPEN_ID
     */
    @Column(name = "OPEN_ID", nullable = true, length = 64)
    private String openId ;
    
    /** 
     * USER_NAME
     */
    @Column(name = "USER_NAME", nullable = true, length = 64)
    private String userName ;
    
    /** 
     * USER_DESC
     */
    @Column(name = "USER_DESC", nullable = true, length = 256)
    private String userDesc ;
    
    /** 
     * STATUS
     */
    @Column(name = "STATUS", nullable = true, length = 2)
    private String _status ;
    
    /** 
     * USER_TYPE
     */
    @Column(name = "USER_TYPE", nullable = true, length = 2)
    private String userType ;
    
    /** 
     * COMPANY_ID
     */
    @Column(name = "COMPANY_ID", nullable = true, length = 64)
    private String companyId ;
    
    /** 
     * PHONENUMBER
     */
    @Column(name = "PHONENUMBER", nullable = true, length = 64)
    private String phonenumber ;
    
    /** 
     * EMAIL
     */
    @Column(name = "EMAIL", nullable = true, length = 128)
    private String email ;
    
    /** 
     * ADDRESS
     */
    @Column(name = "ADDRESS", nullable = true, length = 256)
    private String address ;
    
    /** 
     * ID_CARD_NUM
     */
    @Column(name = "ID_CARD_NUM", nullable = true, length = 64)
    private String idCardNum ;
    
    /** 
     * ID_CARD_FIRST
     */
    @Column(name = "ID_CARD_FIRST", nullable = true, length = 512)
    private String idCardFirst ;
    
    /** 
     * ID_CARD_SECOND
     */
    @Column(name = "ID_CARD_SECOND", nullable = true, length = 512)
    private String idCardSecond ;
    
    /** 
     * CERTIFICATE
     */
    @Column(name = "CERTIFICATE", nullable = true, length = 512)
    private String certificate ;
    
    /** 
     * CREATE_TIME
     */
    @Column(name = "CREATE_TIME", nullable = true, length = 19)
    private Timestamp createTime ;
    
    /** 
     * UPDATE_TIME
     */
    @Column(name = "UPDATE_TIME", nullable = true, length = 19)
    private Timestamp updateTime ;
    
    /** 
     * FINISH_TIME
     */
    @Column(name = "FINISH_TIME", nullable = true, length = 19)
    private Timestamp finishTime ;
    
    /** 
     * USER_ICON
     */
    @Column(name = "USER_ICON", nullable = true, length = 512)
    private String userIcon ;
    
    /** 
     * REMARK
     */
    @Column(name = "REMARK", nullable = true, length = 512)
    private String remark ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public AuthorityUser(){
	
	}
    /**
     * @getId:ID的get方法
     * @params
     * @return id
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getId(){
        return this.id;
    }
    /**
     * @setId:ID的set方法
     * @param id
     * @return
     * @date 2021-02-02 11:49:33
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
     * @getUserAccount:USER_ACCOUNT的get方法
     * @params
     * @return userAccount
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getUserAccount(){
        return this.userAccount;
    }
    /**
     * @setUserAccount:USER_ACCOUNT的set方法
     * @param userAccount
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setUserAccount(String userAccount){
		this.userAccount = userAccount;
	} 
    /**
     * @get_password:PASSWORD的get方法
     * @params
     * @return _password
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String get_password(){
        return this._password;
    }
    /**
     * @set_password:PASSWORD的set方法
     * @param _password
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void set_password(String _password){
		this._password = _password;
	} 
    /**
     * @getOpenId:OPEN_ID的get方法
     * @params
     * @return openId
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getOpenId(){
        return this.openId;
    }
    /**
     * @setOpenId:OPEN_ID的set方法
     * @param openId
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setOpenId(String openId){
		this.openId = openId;
	} 
    /**
     * @getUserName:USER_NAME的get方法
     * @params
     * @return userName
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getUserName(){
        return this.userName;
    }
    /**
     * @setUserName:USER_NAME的set方法
     * @param userName
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setUserName(String userName){
		this.userName = userName;
	} 
    /**
     * @getUserDesc:USER_DESC的get方法
     * @params
     * @return userDesc
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getUserDesc(){
        return this.userDesc;
    }
    /**
     * @setUserDesc:USER_DESC的set方法
     * @param userDesc
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setUserDesc(String userDesc){
		this.userDesc = userDesc;
	} 
    /**
     * @get_status:STATUS的get方法
     * @params
     * @return _status
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String get_status(){
        return this._status;
    }
    /**
     * @set_status:STATUS的set方法
     * @param _status
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void set_status(String _status){
		this._status = _status;
	} 
    /**
     * @getUserType:USER_TYPE的get方法
     * @params
     * @return userType
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getUserType(){
        return this.userType;
    }
    /**
     * @setUserType:USER_TYPE的set方法
     * @param userType
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setUserType(String userType){
		this.userType = userType;
	} 
    /**
     * @getCompanyId:COMPANY_ID的get方法
     * @params
     * @return companyId
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getCompanyId(){
        return this.companyId;
    }
    /**
     * @setCompanyId:COMPANY_ID的set方法
     * @param companyId
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setCompanyId(String companyId){
		this.companyId = companyId;
	} 
    /**
     * @getPhonenumber:PHONENUMBER的get方法
     * @params
     * @return phonenumber
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getPhonenumber(){
        return this.phonenumber;
    }
    /**
     * @setPhonenumber:PHONENUMBER的set方法
     * @param phonenumber
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setPhonenumber(String phonenumber){
		this.phonenumber = phonenumber;
	} 
    /**
     * @getEmail:EMAIL的get方法
     * @params
     * @return email
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getEmail(){
        return this.email;
    }
    /**
     * @setEmail:EMAIL的set方法
     * @param email
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setEmail(String email){
		this.email = email;
	} 
    /**
     * @getAddress:ADDRESS的get方法
     * @params
     * @return address
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getAddress(){
        return this.address;
    }
    /**
     * @setAddress:ADDRESS的set方法
     * @param address
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setAddress(String address){
		this.address = address;
	} 
    /**
     * @getIdCardNum:ID_CARD_NUM的get方法
     * @params
     * @return idCardNum
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getIdCardNum(){
        return this.idCardNum;
    }
    /**
     * @setIdCardNum:ID_CARD_NUM的set方法
     * @param idCardNum
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setIdCardNum(String idCardNum){
		this.idCardNum = idCardNum;
	} 
    /**
     * @getIdCardFirst:ID_CARD_FIRST的get方法
     * @params
     * @return idCardFirst
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getIdCardFirst(){
        return this.idCardFirst;
    }
    /**
     * @setIdCardFirst:ID_CARD_FIRST的set方法
     * @param idCardFirst
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setIdCardFirst(String idCardFirst){
		this.idCardFirst = idCardFirst;
	} 
    /**
     * @getIdCardSecond:ID_CARD_SECOND的get方法
     * @params
     * @return idCardSecond
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getIdCardSecond(){
        return this.idCardSecond;
    }
    /**
     * @setIdCardSecond:ID_CARD_SECOND的set方法
     * @param idCardSecond
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setIdCardSecond(String idCardSecond){
		this.idCardSecond = idCardSecond;
	} 
    /**
     * @getCertificate:CERTIFICATE的get方法
     * @params
     * @return certificate
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getCertificate(){
        return this.certificate;
    }
    /**
     * @setCertificate:CERTIFICATE的set方法
     * @param certificate
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setCertificate(String certificate){
		this.certificate = certificate;
	} 
    /**
     * @getCreateTime:CREATE_TIME的get方法
     * @params
     * @return createTime
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public Timestamp getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:CREATE_TIME的set方法
     * @param createTime
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	} 
    /**
     * @getUpdateTime:UPDATE_TIME的get方法
     * @params
     * @return updateTime
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public Timestamp getUpdateTime(){
        return this.updateTime;
    }
    /**
     * @setUpdateTime:UPDATE_TIME的set方法
     * @param updateTime
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * @getFinishTime:FINISH_TIME的get方法
     * @params
     * @return finishTime
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public Timestamp getFinishTime(){
        return this.finishTime;
    }
    /**
     * @setFinishTime:FINISH_TIME的set方法
     * @param finishTime
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setFinishTime(Timestamp finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * @getUserIcon:USER_ICON的get方法
     * @params
     * @return userIcon
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getUserIcon(){
        return this.userIcon;
    }
    /**
     * @setUserIcon:USER_ICON的set方法
     * @param userIcon
     * @return
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public void setUserIcon(String userIcon){
		this.userIcon = userIcon;
	} 
    /**
     * @getRemark:REMARK的get方法
     * @params
     * @return remark
     * @date 2021-02-02 11:49:33
     * @author 18511
     */
    public String getRemark(){
        return this.remark;
    }
    /**
     * @setRemark:REMARK的set方法
     * @param remark
     * @return
     * @date 2021-02-02 11:49:33
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
		
        if (obj == null || !(obj instanceof AuthorityUser))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		AuthorityUser other = (AuthorityUser) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (userAccount == null) {
			if (other.userAccount != null) {
				return false;
			}
		} else if (!userAccount.equals(other.userAccount)) {
			return false;
		}
		if (_password == null) {
			if (other._password != null) {
				return false;
			}
		} else if (!_password.equals(other._password)) {
			return false;
		}
		if (openId == null) {
			if (other.openId != null) {
				return false;
			}
		} else if (!openId.equals(other.openId)) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		if (userDesc == null) {
			if (other.userDesc != null) {
				return false;
			}
		} else if (!userDesc.equals(other.userDesc)) {
			return false;
		}
		if (_status == null) {
			if (other._status != null) {
				return false;
			}
		} else if (!_status.equals(other._status)) {
			return false;
		}
		if (userType == null) {
			if (other.userType != null) {
				return false;
			}
		} else if (!userType.equals(other.userType)) {
			return false;
		}
		if (companyId == null) {
			if (other.companyId != null) {
				return false;
			}
		} else if (!companyId.equals(other.companyId)) {
			return false;
		}
		if (phonenumber == null) {
			if (other.phonenumber != null) {
				return false;
			}
		} else if (!phonenumber.equals(other.phonenumber)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (idCardNum == null) {
			if (other.idCardNum != null) {
				return false;
			}
		} else if (!idCardNum.equals(other.idCardNum)) {
			return false;
		}
		if (idCardFirst == null) {
			if (other.idCardFirst != null) {
				return false;
			}
		} else if (!idCardFirst.equals(other.idCardFirst)) {
			return false;
		}
		if (idCardSecond == null) {
			if (other.idCardSecond != null) {
				return false;
			}
		} else if (!idCardSecond.equals(other.idCardSecond)) {
			return false;
		}
		if (certificate == null) {
			if (other.certificate != null) {
				return false;
			}
		} else if (!certificate.equals(other.certificate)) {
			return false;
		}
		if (createTime == null) {
			if (other.createTime != null) {
				return false;
			}
		} else if (!createTime.equals(other.createTime)) {
			return false;
		}
		if (updateTime == null) {
			if (other.updateTime != null) {
				return false;
			}
		} else if (!updateTime.equals(other.updateTime)) {
			return false;
		}
		if (finishTime == null) {
			if (other.finishTime != null) {
				return false;
			}
		} else if (!finishTime.equals(other.finishTime)) {
			return false;
		}
		if (userIcon == null) {
			if (other.userIcon != null) {
				return false;
			}
		} else if (!userIcon.equals(other.userIcon)) {
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
		return "AuthorityUser ["
			+ ", id=" + id
			+ ", userAccount=" + userAccount
			+ ", _password=" + _password
			+ ", openId=" + openId
			+ ", userName=" + userName
			+ ", userDesc=" + userDesc
			+ ", _status=" + _status
			+ ", userType=" + userType
			+ ", companyId=" + companyId
			+ ", phonenumber=" + phonenumber
			+ ", email=" + email
			+ ", address=" + address
			+ ", idCardNum=" + idCardNum
			+ ", idCardFirst=" + idCardFirst
			+ ", idCardSecond=" + idCardSecond
			+ ", certificate=" + certificate
			+ ", createTime=" + createTime
			+ ", updateTime=" + updateTime
			+ ", finishTime=" + finishTime
			+ ", userIcon=" + userIcon
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