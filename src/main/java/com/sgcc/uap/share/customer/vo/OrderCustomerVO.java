package com.sgcc.uap.share.customer.vo;

import java.io.Serializable;

import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * OrderCustomer的VO类
 *
 * @author 18511 
 */
public class OrderCustomerVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性订单ID
     */  
    @ViewAttribute(name ="orderId",caption="订单ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String orderId;    
    /** 
     * 属性客户ID
     */  
    @ViewAttribute(name ="customerId",caption="客户ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerId;    
    /** 
     * 属性客户名称
     */  
    @ViewAttribute(name ="customerName",caption="客户名称", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerName;    
    /** 
     * 属性客户电话
     */  
    @ViewAttribute(name ="customerPhonenumber",caption="客户电话", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerPhonenumber;    
    /** 
     * 属性客户地址
     */  
    @ViewAttribute(name ="customerAddress",caption="客户地址", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerAddress;    
    /** 
     * 属性地址经度
     */  
    @ViewAttribute(name ="addressLongitude",caption="地址经度", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String addressLongitude;    
    /** 
     * 属性地址纬度
     */  
    @ViewAttribute(name ="addressLatitude",caption="地址纬度", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String addressLatitude;    
    /** 
     * 属性身份ID
     */  
    @ViewAttribute(name ="identityId",caption="身份ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String identityId;    
    /** 
     * 属性电压
     */  
    @ViewAttribute(name ="voltage",caption="电压", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String voltage;    
    /** 
     * 属性订单类型ID
     */  
    @ViewAttribute(name ="orderTypeId",caption="订单类型ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String orderTypeId;    
    /** 
     * 属性上门服务费
     */  
    @ViewAttribute(name ="customerPrice",caption="上门服务费", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerPrice;    
    /** 
     * 属性订单状态
     */  
    @ViewAttribute(name ="orderStatus",caption="订单状态", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String orderStatus;    
    /** 
     * 属性支付状态
     */  
    @ViewAttribute(name ="payStatus",caption="支付状态", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String payStatus;    
    /** 
     * 属性创建时间
     */  
    @ViewAttribute(name ="createTime",caption="创建时间", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private String createTime;    
    /** 
     * 属性预约时间
     */  
    @ViewAttribute(name ="appointmentTime",caption="预约时间", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private String appointmentTime;    
    /** 
     * 属性更新时间
     */  
    @ViewAttribute(name ="updateTime",caption="更新时间", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private String updateTime;    
    /** 
     * 属性结束时间
     */  
    @ViewAttribute(name ="finishTime",caption="结束时间", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private String finishTime;    
    /** 
     * 属性客户描述
     */  
    @ViewAttribute(name ="customerDescrive",caption="客户描述", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerDescrive;    
    /** 
     * 属性客户拍照
     */  
    @ViewAttribute(name ="customerDescriveIcon",caption="客户拍照", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerDescriveIcon;    
    /** 
     * 属性客户评分
     */  
    @ViewAttribute(name ="customerGrade",caption="客户评分", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerGrade;    
    /** 
     * 属性客户评价标题
     */  
    @ViewAttribute(name ="customerEvaluateTitle",caption="客户评价标题", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerEvaluateTitle;    
    /** 
     * 属性客户评价
     */  
    @ViewAttribute(name ="customerEvaluate",caption="客户评价", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerEvaluate;    
    /** 
     * 属性客户评价照片
     */  
    @ViewAttribute(name ="customerEvaluatePhoto",caption="客户评价照片", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String customerEvaluatePhoto;    
    /** 
     * 属性订单投诉ID
     */  
    @ViewAttribute(name ="orderComplaintId",caption="订单投诉ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String orderComplaintId;    
    /** 
     * 属性REMARK_STR1
     */  
    @ViewAttribute(name ="remarkStr1",caption="REMARK_STR1", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remarkStr1;    
    /** 
     * 属性REMARK_STR2
     */  
    @ViewAttribute(name ="remarkStr2",caption="REMARK_STR2", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remarkStr2;    
    /** 
     * 属性REMARK_STR3
     */  
    @ViewAttribute(name ="remarkStr3",caption="REMARK_STR3", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remarkStr3;    
    /** 
     * 属性REMARK_NUM1
     */  
    @ViewAttribute(name ="remarkNum1",caption="REMARK_NUM1", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remarkNum1;    
    /** 
     * 属性REMARK_NUM2
     */  
    @ViewAttribute(name ="remarkNum2",caption="REMARK_NUM2", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String remarkNum2;  
    
    private String distance;
    
    /**
     * 用来存放勘察情况描述的
     */
    private String electrician_descrive;
    
    /**
     * 用来存放退单原因
     */
    private String chargeback_reason;
    
    
    private String constructionContent;
    
    
    
    
    
    
    /**
     * OrderCustomerVO构造函数
     */
    public OrderCustomerVO() {
        super();
    } 
   
	 /**
     * OrderCustomerVO完整的构造函数
     */  
    public OrderCustomerVO(String orderId){
        this.orderId = orderId;
    }
    /**
     * 订单ID的get方法
     * @return orderId
     */
    public String getOrderId(){
        return orderId;
    }
    /**
     * 订单ID的set方法
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
     * 客户ID的get方法
     * @return customerId
     */
    public String getCustomerId(){
        return customerId;
    }
    /**
     * 客户ID的set方法
     * @param customerId
     */
    public void setCustomerId(String customerId){
		this.customerId = customerId;
	} 
    /**
     * 客户名称的get方法
     * @return customerName
     */
    public String getCustomerName(){
        return customerName;
    }
    /**
     * 客户名称的set方法
     * @param customerName
     */
    public void setCustomerName(String customerName){
		this.customerName = customerName;
	} 
    /**
     * 客户电话的get方法
     * @return customerPhonenumber
     */
    public String getCustomerPhonenumber(){
        return customerPhonenumber;
    }
    /**
     * 客户电话的set方法
     * @param customerPhonenumber
     */
    public void setCustomerPhonenumber(String customerPhonenumber){
		this.customerPhonenumber = customerPhonenumber;
	} 
    /**
     * 客户地址的get方法
     * @return customerAddress
     */
    public String getCustomerAddress(){
        return customerAddress;
    }
    /**
     * 客户地址的set方法
     * @param customerAddress
     */
    public void setCustomerAddress(String customerAddress){
		this.customerAddress = customerAddress;
	} 
    /**
     * 地址经度的get方法
     * @return addressLongitude
     */
    public String getAddressLongitude(){
        return addressLongitude;
    }
    /**
     * 地址经度的set方法
     * @param addressLongitude
     */
    public void setAddressLongitude(String addressLongitude){
		this.addressLongitude = addressLongitude;
	} 
    /**
     * 地址纬度的get方法
     * @return addressLatitude
     */
    public String getAddressLatitude(){
        return addressLatitude;
    }
    /**
     * 地址纬度的set方法
     * @param addressLatitude
     */
    public void setAddressLatitude(String addressLatitude){
		this.addressLatitude = addressLatitude;
	} 
    /**
     * 身份ID的get方法
     * @return identityId
     */
    public String getIdentityId(){
        return identityId;
    }
    /**
     * 身份ID的set方法
     * @param identityId
     */
    public void setIdentityId(String identityId){
		this.identityId = identityId;
	} 
    /**
     * 电压的get方法
     * @return voltage
     */
    public String getVoltage(){
        return voltage;
    }
    /**
     * 电压的set方法
     * @param voltage
     */
    public void setVoltage(String voltage){
		this.voltage = voltage;
	} 
    /**
     * 订单类型ID的get方法
     * @return orderTypeId
     */
    public String getOrderTypeId(){
        return orderTypeId;
    }
    /**
     * 订单类型ID的set方法
     * @param orderTypeId
     */
    public void setOrderTypeId(String orderTypeId){
		this.orderTypeId = orderTypeId;
	} 
    /**
     * 上门服务费的get方法
     * @return customerPrice
     */
    public String getCustomerPrice(){
        return customerPrice;
    }
    /**
     * 上门服务费的set方法
     * @param customerPrice
     */
    public void setCustomerPrice(String customerPrice){
		this.customerPrice = customerPrice;
	} 
    /**
     * 订单状态的get方法
     * @return orderStatus
     */
    public String getOrderStatus(){
        return orderStatus;
    }
    /**
     * 订单状态的set方法
     * @param orderStatus
     */
    public void setOrderStatus(String orderStatus){
		this.orderStatus = orderStatus;
	} 
    /**
     * 支付状态的get方法
     * @return payStatus
     */
    public String getPayStatus(){
        return payStatus;
    }
    /**
     * 支付状态的set方法
     * @param payStatus
     */
    public void setPayStatus(String payStatus){
		this.payStatus = payStatus;
	} 
    /**
     * 创建时间的get方法
     * @return createTime
     */
    public String getCreateTime(){
        return createTime;
    }
    /**
     * 创建时间的set方法
     * @param createTime
     */
    public void setCreateTime(String createTime){
		this.createTime = createTime;
	} 
    /**
     * 预约时间的get方法
     * @return appointmentTime
     */
    public String getAppointmentTime(){
        return appointmentTime;
    }
    /**
     * 预约时间的set方法
     * @param appointmentTime
     */
    public void setAppointmentTime(String appointmentTime){
		this.appointmentTime = appointmentTime;
	} 
    /**
     * 更新时间的get方法
     * @return updateTime
     */
    public String getUpdateTime(){
        return updateTime;
    }
    /**
     * 更新时间的set方法
     * @param updateTime
     */
    public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * 结束时间的get方法
     * @return finishTime
     */
    public String getFinishTime(){
        return finishTime;
    }
    /**
     * 结束时间的set方法
     * @param finishTime
     */
    public void setFinishTime(String finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * 客户描述的get方法
     * @return customerDescrive
     */
    public String getCustomerDescrive(){
        return customerDescrive;
    }
    /**
     * 客户描述的set方法
     * @param customerDescrive
     */
    public void setCustomerDescrive(String customerDescrive){
		this.customerDescrive = customerDescrive;
	} 
    /**
     * 客户拍照的get方法
     * @return customerDescriveIcon
     */
    public String getCustomerDescriveIcon(){
        return customerDescriveIcon;
    }
    /**
     * 客户拍照的set方法
     * @param customerDescriveIcon
     */
    public void setCustomerDescriveIcon(String customerDescriveIcon){
		this.customerDescriveIcon = customerDescriveIcon;
	} 
    /**
     * 客户评分的get方法
     * @return customerGrade
     */
    public String getCustomerGrade(){
        return customerGrade;
    }
    /**
     * 客户评分的set方法
     * @param customerGrade
     */
    public void setCustomerGrade(String customerGrade){
		this.customerGrade = customerGrade;
	} 
    /**
     * 客户评价标题的get方法
     * @return customerEvaluateTitle
     */
    public String getCustomerEvaluateTitle(){
        return customerEvaluateTitle;
    }
    /**
     * 客户评价标题的set方法
     * @param customerEvaluateTitle
     */
    public void setCustomerEvaluateTitle(String customerEvaluateTitle){
		this.customerEvaluateTitle = customerEvaluateTitle;
	} 
    /**
     * 客户评价的get方法
     * @return customerEvaluate
     */
    public String getCustomerEvaluate(){
        return customerEvaluate;
    }
    /**
     * 客户评价的set方法
     * @param customerEvaluate
     */
    public void setCustomerEvaluate(String customerEvaluate){
		this.customerEvaluate = customerEvaluate;
	} 
    /**
     * 客户评价照片的get方法
     * @return customerEvaluatePhoto
     */
    public String getCustomerEvaluatePhoto(){
        return customerEvaluatePhoto;
    }
    /**
     * 客户评价照片的set方法
     * @param customerEvaluatePhoto
     */
    public void setCustomerEvaluatePhoto(String customerEvaluatePhoto){
		this.customerEvaluatePhoto = customerEvaluatePhoto;
	} 
    /**
     * 订单投诉ID的get方法
     * @return orderComplaintId
     */
    public String getOrderComplaintId(){
        return orderComplaintId;
    }
    /**
     * 订单投诉ID的set方法
     * @param orderComplaintId
     */
    public void setOrderComplaintId(String orderComplaintId){
		this.orderComplaintId = orderComplaintId;
	} 
    /**
     * REMARK_STR1的get方法
     * @return remarkStr1
     */
    public String getRemarkStr1(){
        return remarkStr1;
    }
    /**
     * REMARK_STR1的set方法
     * @param remarkStr1
     */
    public void setRemarkStr1(String remarkStr1){
		this.remarkStr1 = remarkStr1;
	} 
    /**
     * REMARK_STR2的get方法
     * @return remarkStr2
     */
    public String getRemarkStr2(){
        return remarkStr2;
    }
    /**
     * REMARK_STR2的set方法
     * @param remarkStr2
     */
    public void setRemarkStr2(String remarkStr2){
		this.remarkStr2 = remarkStr2;
	} 
    /**
     * REMARK_STR3的get方法
     * @return remarkStr3
     */
    public String getRemarkStr3(){
        return remarkStr3;
    }
    /**
     * REMARK_STR3的set方法
     * @param remarkStr3
     */
    public void setRemarkStr3(String remarkStr3){
		this.remarkStr3 = remarkStr3;
	} 
    /**
     * REMARK_NUM1的get方法
     * @return remarkNum1
     */
    public String getRemarkNum1(){
        return remarkNum1;
    }
    /**
     * REMARK_NUM1的set方法
     * @param remarkNum1
     */
    public void setRemarkNum1(String remarkNum1){
		this.remarkNum1 = remarkNum1;
	} 
    /**
     * REMARK_NUM2的get方法
     * @return remarkNum2
     */
    public String getRemarkNum2(){
        return remarkNum2;
    }
    /**
     * REMARK_NUM2的set方法
     * @param remarkNum2
     */
    public void setRemarkNum2(String remarkNum2){
		this.remarkNum2 = remarkNum2;
	} 
    
    
   
    

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("ORDER_ID"+":"+getOrderId())
				.append("CUSTOMER_ID"+":"+getCustomerId())
				.append("CUSTOMER_NAME"+":"+getCustomerName())
				.append("CUSTOMER_PHONENUMBER"+":"+getCustomerPhonenumber())
				.append("CUSTOMER_ADDRESS"+":"+getCustomerAddress())
				.append("ADDRESS_LONGITUDE"+":"+getAddressLongitude())
				.append("ADDRESS_LATITUDE"+":"+getAddressLatitude())
				.append("IDENTITY_ID"+":"+getIdentityId())
				.append("VOLTAGE"+":"+getVoltage())
				.append("ORDER_TYPE_ID"+":"+getOrderTypeId())
				.append("CUSTOMER_PRICE"+":"+getCustomerPrice())
				.append("ORDER_STATUS"+":"+getOrderStatus())
				.append("PAY_STATUS"+":"+getPayStatus())
				.append("CREATE_TIME"+":"+getCreateTime())
				.append("APPOINTMENT_TIME"+":"+getAppointmentTime())
				.append("UPDATE_TIME"+":"+getUpdateTime())
				.append("FINISH_TIME"+":"+getFinishTime())
				.append("CUSTOMER_DESCRIVE"+":"+getCustomerDescrive())
				.append("CUSTOMER_DESCRIVE_ICON"+":"+getCustomerDescriveIcon())
				.append("CUSTOMER_GRADE"+":"+getCustomerGrade())
				.append("CUSTOMER_EVALUATE_TITLE"+":"+getCustomerEvaluateTitle())
				.append("CUSTOMER_EVALUATE"+":"+getCustomerEvaluate())
				.append("CUSTOMER_EVALUATE_PHOTO"+":"+getCustomerEvaluatePhoto())
				.append("ORDER_COMPLAINT_ID"+":"+getOrderComplaintId())
				.append("REMARK_STR1"+":"+getRemarkStr1())
				.append("REMARK_STR2"+":"+getRemarkStr2())
				.append("REMARK_STR3"+":"+getRemarkStr3())
				.append("REMARK_NUM1"+":"+getRemarkNum1())
				.append("REMARK_NUM2"+":"+getRemarkNum2())
				.append("Distance"+":"+getDistance())
				.append("getElectrician_descrive"+":"+getElectrician_descrive())
				.append("CHARGEBACK_REASON"+":"+getChargeback_reason())
				.append("CONSTRUCTION_CONTENT"+":"+getConstructionContent())
		        .toString(); 
			
    }

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getElectrician_descrive() {
		return electrician_descrive;
	}

	public void setElectrician_descrive(String electrician_descrive) {
		this.electrician_descrive = electrician_descrive;
	}

	public String getChargeback_reason() {
		return chargeback_reason;
	}

	public void setChargeback_reason(String chargeback_reason) {
		this.chargeback_reason = chargeback_reason;
	}

	public String getConstructionContent() {
		return constructionContent;
	}

	public void setConstructionContent(String constructionContent) {
		this.constructionContent = constructionContent;
	} 
   


}
