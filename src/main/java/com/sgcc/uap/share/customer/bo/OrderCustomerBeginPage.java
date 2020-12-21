package com.sgcc.uap.share.customer.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * OrderCustomer的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "order_customer")
public class OrderCustomerBeginPage implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * 订单ID
     */
	/*@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")*/
	@Id
    @Column(name = "ORDER_ID", nullable = false, length = 64)
    private String orderId ;
    
    /** 
     * 客户ID
     */
    @Column(name = "CUSTOMER_ID", nullable = true, length = 64)
    private String customerId ;
    
    /** 
     * 客户名称
     */
    @Column(name = "CUSTOMER_NAME", nullable = true, length = 10)
    private String customerName ;
    
    /** 
     * 客户电话
     */
    @Column(name = "CUSTOMER_PHONENUMBER", nullable = true, length = 32)
    private String customerPhonenumber ;
    
    /** 
     * 客户地址
     */
    @Column(name = "CUSTOMER_ADDRESS", nullable = true, length = 256)
    private String customerAddress ;
    
    /** 
     * 地址经度
     */
    @Column(name = "ADDRESS_LONGITUDE", nullable = true, length = 32)
    private String addressLongitude ;
    
    /** 
     * 地址纬度
     */
    @Column(name = "ADDRESS_LATITUDE", nullable = true, length = 32)
    private String addressLatitude ;
    
    /** 
     * 身份ID
     */
    @Column(name = "IDENTITY_ID", nullable = true, length = 2)
    private String identityId ;
    
    /** 
     * 电压
     */
    @Column(name = "VOLTAGE", nullable = true, length = 10)
    private String voltage ;
    
    /** 
     * 订单类型ID
     */
    @Column(name = "ORDER_TYPE_ID", nullable = true, length = 2)
    private String orderTypeId ;
    
    /** 
     * 上门服务费
     */
    @Column(name = "CUSTOMER_PRICE", nullable = true, length = 5)
    private String customerPrice ;
    
    /** 
     * 订单状态
     */
    @Column(name = "ORDER_STATUS", nullable = true, length = 4)
    private String orderStatus ;
    
    /** 
     * 支付状态
     */
    @Column(name = "PAY_STATUS", nullable = true, length = 2)
    private String payStatus ;
    
    /** 
     * 创建时间
     */
    @Column(name = "CREATE_TIME", nullable = true, length = 19)
    private String createTime ;
    
    /** 
     * 预约时间
     */
    @Column(name = "APPOINTMENT_TIME", nullable = true, length = 19)
    private String appointmentTime ;
    
    /** 
     * 更新时间
     */
    @Column(name = "UPDATE_TIME", nullable = true, length = 19)
    private String updateTime ;
    
    /** 
     * 结束时间
     */
    @Column(name = "FINISH_TIME", nullable = true, length = 19)
    private String finishTime ;
    
    /** 
     * 客户描述
     */
    @Column(name = "CUSTOMER_DESCRIVE", nullable = true, length = 512)
    private String customerDescrive ;
    
    /** 
     * 客户拍照
     */
    @Column(name = "CUSTOMER_DESCRIVE_ICON", nullable = true, length = 512)
    private String customerDescriveIcon ;
    
    /** 
     * 客户评分
     */
    @Column(name = "CUSTOMER_GRADE", nullable = true, length = 2)
    private String customerGrade ;
    
    /** 
     * 客户评价标题
     */
    @Column(name = "CUSTOMER_EVALUATE_TITLE", nullable = true, length = 128)
    private String customerEvaluateTitle ;
    
    /** 
     * 客户评价
     */
    @Column(name = "CUSTOMER_EVALUATE", nullable = true, length = 512)
    private String customerEvaluate ;
    
    /** 
     * 客户评价照片
     */
    @Column(name = "CUSTOMER_EVALUATE_PHOTO", nullable = true, length = 512)
    private String customerEvaluatePhoto ;
    
    /** 
     * 订单投诉ID
     */
    @Column(name = "ORDER_COMPLAINT_ID", nullable = true, length = 64)
    private String orderComplaintId ;
    
    /** 
     * 订单来源
     */
    @Column(name = "ORDER_FROM", nullable = true, length = 2)
    private String orderFrom ;
    
    /** 
     * REMARK_STR1
     */
    @Column(name = "REMARK_STR1", nullable = true, length = 128)
    private String remarkStr1 ;
    
    /** 
     * REMARK_STR2
     */
    @Column(name = "REMARK_STR2", nullable = true, length = 128)
    private String remarkStr2 ;
    
    /** 
     * REMARK_STR3
     */
    @Column(name = "REMARK_STR3", nullable = true, length = 128)
    private String remarkStr3 ;
    
    /** 
     * REMARK_NUM1
     */
    @Column(name = "REMARK_NUM1", nullable = true, length = 8)
    private String remarkNum1 ;
    
    /** 
     * REMARK_NUM2
     */
    @Column(name = "REMARK_NUM2", nullable = true, length = 8)
    private String remarkNum2 ;
    
    /** 
     * CREATE_AREA_ID
     */
    @Column(name = "CREATE_AREA_ID", nullable = true, length = 64)
    private String createAreaId ;
    /** 
     * REGISTERED_NUMBER 户号
     */
    @Column(name = "REGISTERED_NUMBER", nullable = true, length = 64)
    private String registeredNumber ;
    
    /** 
     * CUSTOMER_DESCRIVE_TITLE 客户描述标题
     */
    @Column(name = "CUSTOMER_DESCRIVE_TITLE", nullable = true, length = 64)
    private String customerDescriveTitle ;
    
    
    
    /*************************************************** 
     * 新增数据库没有的字段
     */
    @Column(name = "ELECTRICIAN_DESCRIVE", nullable = true, length = 512)
    private String electricianDescrive ;
    @Column(name = "ELECTRICIAN_DESCRIVE_ICON", nullable = true, length = 512)
    private String electricianDescriveIcon ;
    @Column(name = "ELECTRICIAN_PRICE", nullable = true, length = 6)
    private String electricianPrice ;
	public String getElectricianDescrive() {
		return electricianDescrive;
	}
	public void setElectricianDescrive(String electricianDescrive) {
		this.electricianDescrive = electricianDescrive;
	}
	public String getElectricianDescriveIcon() {
		return electricianDescriveIcon;
	}
	public void setElectricianDescriveIcon(String electricianDescriveIcon) {
		this.electricianDescriveIcon = electricianDescriveIcon;
	}
	public String getElectricianPrice() {
		return electricianPrice;
	}
	public void setElectricianPrice(String electricianPrice) {
		this.electricianPrice = electricianPrice;
	}


	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public OrderCustomerBeginPage(){
	
	}
	
	
	public String getRegisteredNumber() {
		return registeredNumber;
	}

	public void setRegisteredNumber(String registeredNumber) {
		this.registeredNumber = registeredNumber;
	}

	public String getCustomerDescriveTitle() {
		return customerDescriveTitle;
	}

	public void setCustomerDescriveTitle(String customerDescriveTitle) {
		this.customerDescriveTitle = customerDescriveTitle;
	}
    /**
     * @getOrderId:订单ID的get方法
     * @params
     * @return orderId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getOrderId(){
        return this.orderId;
    }
    /**
     * @setOrderId:订单ID的set方法
     * @param orderId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setOrderId(String orderId){
        if(orderId != null && orderId.trim().length() == 0){
        	this.orderId = null;
        }else{
        	this.orderId = orderId;
        }
	} 
    /**
     * @getCustomerId:客户ID的get方法
     * @params
     * @return customerId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerId(){
        return this.customerId;
    }
    /**
     * @setCustomerId:客户ID的set方法
     * @param customerId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerId(String customerId){
		this.customerId = customerId;
	} 
    /**
     * @getCustomerName:客户名称的get方法
     * @params
     * @return customerName
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerName(){
        return this.customerName;
    }
    /**
     * @setCustomerName:客户名称的set方法
     * @param customerName
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerName(String customerName){
		this.customerName = customerName;
	} 
    /**
     * @getCustomerPhonenumber:客户电话的get方法
     * @params
     * @return customerPhonenumber
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerPhonenumber(){
        return this.customerPhonenumber;
    }
    /**
     * @setCustomerPhonenumber:客户电话的set方法
     * @param customerPhonenumber
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerPhonenumber(String customerPhonenumber){
		this.customerPhonenumber = customerPhonenumber;
	} 
    /**
     * @getCustomerAddress:客户地址的get方法
     * @params
     * @return customerAddress
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerAddress(){
        return this.customerAddress;
    }
    /**
     * @setCustomerAddress:客户地址的set方法
     * @param customerAddress
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerAddress(String customerAddress){
		this.customerAddress = customerAddress;
	} 
    /**
     * @getAddressLongitude:地址经度的get方法
     * @params
     * @return addressLongitude
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getAddressLongitude(){
        return this.addressLongitude;
    }
    /**
     * @setAddressLongitude:地址经度的set方法
     * @param addressLongitude
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setAddressLongitude(String addressLongitude){
		this.addressLongitude = addressLongitude;
	} 
    /**
     * @getAddressLatitude:地址纬度的get方法
     * @params
     * @return addressLatitude
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getAddressLatitude(){
        return this.addressLatitude;
    }
    /**
     * @setAddressLatitude:地址纬度的set方法
     * @param addressLatitude
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setAddressLatitude(String addressLatitude){
		this.addressLatitude = addressLatitude;
	} 
    /**
     * @getIdentityId:身份ID的get方法
     * @params
     * @return identityId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getIdentityId(){
        return this.identityId;
    }
    /**
     * @setIdentityId:身份ID的set方法
     * @param identityId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setIdentityId(String identityId){
		this.identityId = identityId;
	} 
    /**
     * @getVoltage:电压的get方法
     * @params
     * @return voltage
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getVoltage(){
        return this.voltage;
    }
    /**
     * @setVoltage:电压的set方法
     * @param voltage
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setVoltage(String voltage){
		this.voltage = voltage;
	} 
    /**
     * @getOrderTypeId:订单类型ID的get方法
     * @params
     * @return orderTypeId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getOrderTypeId(){
        return this.orderTypeId;
    }
    /**
     * @setOrderTypeId:订单类型ID的set方法
     * @param orderTypeId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setOrderTypeId(String orderTypeId){
		this.orderTypeId = orderTypeId;
	} 
    /**
     * @getCustomerPrice:上门服务费的get方法
     * @params
     * @return customerPrice
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerPrice(){
        return this.customerPrice;
    }
    /**
     * @setCustomerPrice:上门服务费的set方法
     * @param customerPrice
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerPrice(String customerPrice){
		this.customerPrice = customerPrice;
	} 
    /**
     * @getOrderStatus:订单状态的get方法
     * @params
     * @return orderStatus
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getOrderStatus(){
        return this.orderStatus;
    }
    /**
     * @setOrderStatus:订单状态的set方法
     * @param orderStatus
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setOrderStatus(String orderStatus){
		this.orderStatus = orderStatus;
	} 
    /**
     * @getPayStatus:支付状态的get方法
     * @params
     * @return payStatus
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getPayStatus(){
        return this.payStatus;
    }
    /**
     * @setPayStatus:支付状态的set方法
     * @param payStatus
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setPayStatus(String payStatus){
		this.payStatus = payStatus;
	} 
    /**
     * @getCreateTime:创建时间的get方法
     * @params
     * @return createTime
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:创建时间的set方法
     * @param createTime
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCreateTime(String createTime){
		this.createTime = createTime;
	} 
    /**
     * @getAppointmentTime:预约时间的get方法
     * @params
     * @return appointmentTime
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getAppointmentTime(){
        return this.appointmentTime;
    }
    /**
     * @setAppointmentTime:预约时间的set方法
     * @param appointmentTime
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setAppointmentTime(String appointmentTime){
		this.appointmentTime = appointmentTime;
	} 
    /**
     * @getUpdateTime:更新时间的get方法
     * @params
     * @return updateTime
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getUpdateTime(){
        return this.updateTime;
    }
    /**
     * @setUpdateTime:更新时间的set方法
     * @param updateTime
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * @getFinishTime:结束时间的get方法
     * @params
     * @return finishTime
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getFinishTime(){
        return this.finishTime;
    }
    /**
     * @setFinishTime:结束时间的set方法
     * @param finishTime
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setFinishTime(String finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * @getCustomerDescrive:客户描述的get方法
     * @params
     * @return customerDescrive
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerDescrive(){
        return this.customerDescrive;
    }
    /**
     * @setCustomerDescrive:客户描述的set方法
     * @param customerDescrive
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerDescrive(String customerDescrive){
		this.customerDescrive = customerDescrive;
	} 
    /**
     * @getCustomerDescriveIcon:客户拍照的get方法
     * @params
     * @return customerDescriveIcon
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerDescriveIcon(){
        return this.customerDescriveIcon;
    }
    /**
     * @setCustomerDescriveIcon:客户拍照的set方法
     * @param customerDescriveIcon
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerDescriveIcon(String customerDescriveIcon){
		this.customerDescriveIcon = customerDescriveIcon;
	} 
    /**
     * @getCustomerGrade:客户评分的get方法
     * @params
     * @return customerGrade
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerGrade(){
        return this.customerGrade;
    }
    /**
     * @setCustomerGrade:客户评分的set方法
     * @param customerGrade
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerGrade(String customerGrade){
		this.customerGrade = customerGrade;
	} 
    /**
     * @getCustomerEvaluateTitle:客户评价标题的get方法
     * @params
     * @return customerEvaluateTitle
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerEvaluateTitle(){
        return this.customerEvaluateTitle;
    }
    /**
     * @setCustomerEvaluateTitle:客户评价标题的set方法
     * @param customerEvaluateTitle
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerEvaluateTitle(String customerEvaluateTitle){
		this.customerEvaluateTitle = customerEvaluateTitle;
	} 
    /**
     * @getCustomerEvaluate:客户评价的get方法
     * @params
     * @return customerEvaluate
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerEvaluate(){
        return this.customerEvaluate;
    }
    /**
     * @setCustomerEvaluate:客户评价的set方法
     * @param customerEvaluate
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerEvaluate(String customerEvaluate){
		this.customerEvaluate = customerEvaluate;
	} 
    /**
     * @getCustomerEvaluatePhoto:客户评价照片的get方法
     * @params
     * @return customerEvaluatePhoto
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getCustomerEvaluatePhoto(){
        return this.customerEvaluatePhoto;
    }
    /**
     * @setCustomerEvaluatePhoto:客户评价照片的set方法
     * @param customerEvaluatePhoto
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setCustomerEvaluatePhoto(String customerEvaluatePhoto){
		this.customerEvaluatePhoto = customerEvaluatePhoto;
	} 
    /**
     * @getOrderComplaintId:订单投诉ID的get方法
     * @params
     * @return orderComplaintId
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getOrderComplaintId(){
        return this.orderComplaintId;
    }
    /**
     * @setOrderComplaintId:订单投诉ID的set方法
     * @param orderComplaintId
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setOrderComplaintId(String orderComplaintId){
		this.orderComplaintId = orderComplaintId;
	} 
    /**
     * @getRemarkStr1:REMARK_STR1的get方法
     * @params
     * @return remarkStr1
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getRemarkStr1(){
        return this.remarkStr1;
    }
    /**
     * @setRemarkStr1:REMARK_STR1的set方法
     * @param remarkStr1
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setRemarkStr1(String remarkStr1){
		this.remarkStr1 = remarkStr1;
	} 
    /**
     * @getRemarkStr2:REMARK_STR2的get方法
     * @params
     * @return remarkStr2
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getRemarkStr2(){
        return this.remarkStr2;
    }
    /**
     * @setRemarkStr2:REMARK_STR2的set方法
     * @param remarkStr2
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setRemarkStr2(String remarkStr2){
		this.remarkStr2 = remarkStr2;
	} 
    /**
     * @getRemarkStr3:REMARK_STR3的get方法
     * @params
     * @return remarkStr3
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getRemarkStr3(){
        return this.remarkStr3;
    }
    /**
     * @setRemarkStr3:REMARK_STR3的set方法
     * @param remarkStr3
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setRemarkStr3(String remarkStr3){
		this.remarkStr3 = remarkStr3;
	} 
    /**
     * @getRemarkNum1:REMARK_NUM1的get方法
     * @params
     * @return remarkNum1
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getRemarkNum1(){
        return this.remarkNum1;
    }
    /**
     * @setRemarkNum1:REMARK_NUM1的set方法
     * @param remarkNum1
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setRemarkNum1(String remarkNum1){
		this.remarkNum1 = remarkNum1;
	} 
    /**
     * @getRemarkNum2:REMARK_NUM2的get方法
     * @params
     * @return remarkNum2
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public String getRemarkNum2(){
        return this.remarkNum2;
    }
    /**
     * @setRemarkNum2:REMARK_NUM2的set方法
     * @param remarkNum2
     * @return
     * @date 2020-11-26 14:32:47
     * @author 18511
     */
    public void setRemarkNum2(String remarkNum2){
		this.remarkNum2 = remarkNum2;
	} 
	public String getMxVirtualId() {
        return this.mxVirtualId;
    }
    
    public void setMxVirtualId(String mxVirtualId) {
        this.mxVirtualId = mxVirtualId;
    } 
    
    public String getOrderFrom() {
		return orderFrom;
	}
	public void setOrderFrom(String orderFrom) {
		this.orderFrom = orderFrom;
	}
	
	public String getCreateAreaId() {
		return createAreaId;
	}
	public void setCreateAreaId(String createAreaId) {
		this.createAreaId = createAreaId;
	}
	/**
     * Hibernate通过该方法判断对象是否相等
     * @return boolean
     */  
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
		
        if (obj == null || !(obj instanceof OrderCustomerBeginPage))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		OrderCustomerBeginPage other = (OrderCustomerBeginPage) obj;
		
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (customerName == null) {
			if (other.customerName != null) {
				return false;
			}
		} else if (!customerName.equals(other.customerName)) {
			return false;
		}
		if (customerPhonenumber == null) {
			if (other.customerPhonenumber != null) {
				return false;
			}
		} else if (!customerPhonenumber.equals(other.customerPhonenumber)) {
			return false;
		}
		if (customerAddress == null) {
			if (other.customerAddress != null) {
				return false;
			}
		} else if (!customerAddress.equals(other.customerAddress)) {
			return false;
		}
		if (addressLongitude == null) {
			if (other.addressLongitude != null) {
				return false;
			}
		} else if (!addressLongitude.equals(other.addressLongitude)) {
			return false;
		}
		if (addressLatitude == null) {
			if (other.addressLatitude != null) {
				return false;
			}
		} else if (!addressLatitude.equals(other.addressLatitude)) {
			return false;
		}
		if (identityId == null) {
			if (other.identityId != null) {
				return false;
			}
		} else if (!identityId.equals(other.identityId)) {
			return false;
		}
		if (voltage == null) {
			if (other.voltage != null) {
				return false;
			}
		} else if (!voltage.equals(other.voltage)) {
			return false;
		}
		if (orderTypeId == null) {
			if (other.orderTypeId != null) {
				return false;
			}
		} else if (!orderTypeId.equals(other.orderTypeId)) {
			return false;
		}
		if (customerPrice == null) {
			if (other.customerPrice != null) {
				return false;
			}
		} else if (!customerPrice.equals(other.customerPrice)) {
			return false;
		}
		if (orderStatus == null) {
			if (other.orderStatus != null) {
				return false;
			}
		} else if (!orderStatus.equals(other.orderStatus)) {
			return false;
		}
		if (payStatus == null) {
			if (other.payStatus != null) {
				return false;
			}
		} else if (!payStatus.equals(other.payStatus)) {
			return false;
		}
		if (createTime == null) {
			if (other.createTime != null) {
				return false;
			}
		} else if (!createTime.equals(other.createTime)) {
			return false;
		}
		if (appointmentTime == null) {
			if (other.appointmentTime != null) {
				return false;
			}
		} else if (!appointmentTime.equals(other.appointmentTime)) {
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
		if (customerDescrive == null) {
			if (other.customerDescrive != null) {
				return false;
			}
		} else if (!customerDescrive.equals(other.customerDescrive)) {
			return false;
		}
		if (customerDescriveIcon == null) {
			if (other.customerDescriveIcon != null) {
				return false;
			}
		} else if (!customerDescriveIcon.equals(other.customerDescriveIcon)) {
			return false;
		}
		if (customerGrade == null) {
			if (other.customerGrade != null) {
				return false;
			}
		} else if (!customerGrade.equals(other.customerGrade)) {
			return false;
		}
		if (customerEvaluateTitle == null) {
			if (other.customerEvaluateTitle != null) {
				return false;
			}
		} else if (!customerEvaluateTitle.equals(other.customerEvaluateTitle)) {
			return false;
		}
		if (customerEvaluate == null) {
			if (other.customerEvaluate != null) {
				return false;
			}
		} else if (!customerEvaluate.equals(other.customerEvaluate)) {
			return false;
		}
		if (customerEvaluatePhoto == null) {
			if (other.customerEvaluatePhoto != null) {
				return false;
			}
		} else if (!customerEvaluatePhoto.equals(other.customerEvaluatePhoto)) {
			return false;
		}
		if (orderComplaintId == null) {
			if (other.orderComplaintId != null) {
				return false;
			}
		} else if (!orderComplaintId.equals(other.orderComplaintId)) {
			return false;
		}
		if (remarkStr1 == null) {
			if (other.remarkStr1 != null) {
				return false;
			}
		} else if (!remarkStr1.equals(other.remarkStr1)) {
			return false;
		}
		if (remarkStr2 == null) {
			if (other.remarkStr2 != null) {
				return false;
			}
		} else if (!remarkStr2.equals(other.remarkStr2)) {
			return false;
		}
		if (remarkStr3 == null) {
			if (other.remarkStr3 != null) {
				return false;
			}
		} else if (!remarkStr3.equals(other.remarkStr3)) {
			return false;
		}
		if (remarkNum1 == null) {
			if (other.remarkNum1 != null) {
				return false;
			}
		} else if (!remarkNum1.equals(other.remarkNum1)) {
			return false;
		}
		if (remarkNum2 == null) {
			if (other.remarkNum2 != null) {
				return false;
			}
		} else if (!remarkNum2.equals(other.remarkNum2)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "OrderCustomer ["
			+ ", orderId=" + orderId
			+ ", customerId=" + customerId
			+ ", customerName=" + customerName
			+ ", customerPhonenumber=" + customerPhonenumber
			+ ", customerAddress=" + customerAddress
			+ ", addressLongitude=" + addressLongitude
			+ ", addressLatitude=" + addressLatitude
			+ ", identityId=" + identityId
			+ ", voltage=" + voltage
			+ ", orderTypeId=" + orderTypeId
			+ ", customerPrice=" + customerPrice
			+ ", orderStatus=" + orderStatus
			+ ", payStatus=" + payStatus
			+ ", createTime=" + createTime
			+ ", appointmentTime=" + appointmentTime
			+ ", updateTime=" + updateTime
			+ ", finishTime=" + finishTime
			+ ", customerDescrive=" + customerDescrive
			+ ", customerDescriveIcon=" + customerDescriveIcon
			+ ", customerGrade=" + customerGrade
			+ ", customerEvaluateTitle=" + customerEvaluateTitle
			+ ", customerEvaluate=" + customerEvaluate
			+ ", customerEvaluatePhoto=" + customerEvaluatePhoto
			+ ", orderComplaintId=" + orderComplaintId
			+ ", remarkStr1=" + remarkStr1
			+ ", remarkStr2=" + remarkStr2
			+ ", remarkStr3=" + remarkStr3
			+ ", remarkNum1=" + remarkNum1
			+ ", remarkNum2=" + remarkNum2;
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