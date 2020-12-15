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
 * OrderElectricianHis的POJO类
 * @author 18511 
 */
@Entity
@Table(name = "order_electrician_his")
public class OrderElectricianHis implements Serializable {

    /** 
     * serialVersionUID
     */
	private static final long serialVersionUID = -7768637914227571159L;

    /** 
     * 电工订单ID
     */
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(name = "ORDER_ELECTRICIAN_ID", nullable = false, length = 64)
    private String orderElectricianId ;
    
    /** 
     * 订单ID
     */
    @Column(name = "ORDER_ID", nullable = true, length = 64)
    private String orderId ;
    
    /** 
     * 电工ID
     */
    @Column(name = "ELECTRICIAN_ID", nullable = true, length = 64)
    private String electricianId ;
    
    /** 
     * 电工名称
     */
    @Column(name = "ELECTRICIAN_NAME", nullable = true, length = 32)
    private String electricianName ;
    
    /** 
     * 电工电话
     */
    @Column(name = "ELECTRICIAN_PHONENUMBER", nullable = true, length = 32)
    private String electricianPhonenumber ;
    
    /** 
     * 电工地址
     */
    @Column(name = "ELECTRICIAN_ADDRESS", nullable = true, length = 256)
    private String electricianAddress ;
    
    /** 
     * 其他电工ID
     */
    @Column(name = "OTHER_ELECTRICIAN_ID", nullable = true, length = 256)
    private String otherElectricianId ;
    
    /** 
     * 订单类型ID
     */
    @Column(name = "ORDER_TYPE_ID", nullable = true, length = 2)
    private String orderTypeId ;
    
    /** 
     * 维修费
     */
    @Column(name = "ELECTRICIAN_PRICE", nullable = true, length = 6)
    private String electricianPrice ;
    
    /** 
     * 订单状态
     */
    @Column(name = "ORDER_ELECTRICIAN_TYPE", nullable = true, length = 2)
    private String orderElectricianType ;
    
    /** 
     * 支付状态
     */
    @Column(name = "PAY_STATUS", nullable = true, length = 2)
    private String payStatus ;
    
    /** 
     * 创建时间
     */
    @Column(name = "CREATE_TIME", nullable = true, length = 19)
    private Timestamp createTime ;
    
    /** 
     * 开始施工时间
     */
    @Column(name = "BEGIN_TIME", nullable = true, length = 19)
    private Timestamp beginTime ;
    
    /** 
     * 更新时间
     */
    @Column(name = "UPDATE_TIME", nullable = true, length = 19)
    private Timestamp updateTime ;
    
    /** 
     * 完工时间
     */
    @Column(name = "FINISH_TIME", nullable = true, length = 19)
    private Timestamp finishTime ;
    
    /** 
     * 电工描述
     */
    @Column(name = "ELECTRICIAN_DESCRIVE", nullable = true, length = 512)
    private String electricianDescrive ;
    
    /** 
     * 电工拍照
     */
    @Column(name = "ELECTRICIAN_DESCRIVE_ICON", nullable = true, length = 512)
    private String electricianDescriveIcon ;
    
    /** 
     * 电工评分
     */
    @Column(name = "ELECTRICIAN_GRADE", nullable = true, length = 2)
    private String electricianGrade ;
    
    /** 
     * 电工评价
     */
    @Column(name = "ELECTRICIAN_EVALUATE", nullable = true, length = 512)
    private String electricianEvaluate ;
    
    /** 
     * 退单原因
     */
    @Column(name = "CHARGEBACK_REASON", nullable = true, length = 512)
    private String chargebackReason ;
    
    /** 
     * 订单合同
     */
    @Column(name = "ORDER_CONTRACT", nullable = true, length = 512)
    private String orderContract ;
    
    /** 
     * 验收报告
     */
    @Column(name = "INSPECTION_REPORT", nullable = true, length = 512)
    private String inspectionReport ;
    
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
     * CONSTRUCTION_CONTENT
     */
    @Column(name = "CONSTRUCTION_CONTENT", nullable = true, length = 512)
    private String constructionContent ;
    
	/**
	  *虚拟主键
	  */
	@Transient
	private String mxVirtualId;
	
	public OrderElectricianHis(){
	
	}
    /**
     * @getOrderElectricianId:电工订单ID的get方法
     * @params
     * @return orderElectricianId
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getOrderElectricianId(){
        return this.orderElectricianId;
    }
    /**
     * @setOrderElectricianId:电工订单ID的set方法
     * @param orderElectricianId
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setOrderElectricianId(String orderElectricianId){
        if(orderElectricianId != null && orderElectricianId.trim().length() == 0){
        	this.orderElectricianId = null;
        }else{
        	this.orderElectricianId = orderElectricianId;
        }
	} 
    /**
     * @getOrderId:订单ID的get方法
     * @params
     * @return orderId
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getOrderId(){
        return this.orderId;
    }
    /**
     * @setOrderId:订单ID的set方法
     * @param orderId
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setOrderId(String orderId){
		this.orderId = orderId;
	} 
    /**
     * @getElectricianId:电工ID的get方法
     * @params
     * @return electricianId
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getElectricianId(){
        return this.electricianId;
    }
    /**
     * @setElectricianId:电工ID的set方法
     * @param electricianId
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setElectricianId(String electricianId){
		this.electricianId = electricianId;
	} 
    /**
     * @getElectricianName:电工名称的get方法
     * @params
     * @return electricianName
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getElectricianName(){
        return this.electricianName;
    }
    /**
     * @setElectricianName:电工名称的set方法
     * @param electricianName
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setElectricianName(String electricianName){
		this.electricianName = electricianName;
	} 
    /**
     * @getElectricianPhonenumber:电工电话的get方法
     * @params
     * @return electricianPhonenumber
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getElectricianPhonenumber(){
        return this.electricianPhonenumber;
    }
    /**
     * @setElectricianPhonenumber:电工电话的set方法
     * @param electricianPhonenumber
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setElectricianPhonenumber(String electricianPhonenumber){
		this.electricianPhonenumber = electricianPhonenumber;
	} 
    /**
     * @getElectricianAddress:电工地址的get方法
     * @params
     * @return electricianAddress
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getElectricianAddress(){
        return this.electricianAddress;
    }
    /**
     * @setElectricianAddress:电工地址的set方法
     * @param electricianAddress
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setElectricianAddress(String electricianAddress){
		this.electricianAddress = electricianAddress;
	} 
    /**
     * @getOtherElectricianId:其他电工ID的get方法
     * @params
     * @return otherElectricianId
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getOtherElectricianId(){
        return this.otherElectricianId;
    }
    /**
     * @setOtherElectricianId:其他电工ID的set方法
     * @param otherElectricianId
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setOtherElectricianId(String otherElectricianId){
		this.otherElectricianId = otherElectricianId;
	} 
    /**
     * @getOrderTypeId:订单类型ID的get方法
     * @params
     * @return orderTypeId
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getOrderTypeId(){
        return this.orderTypeId;
    }
    /**
     * @setOrderTypeId:订单类型ID的set方法
     * @param orderTypeId
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setOrderTypeId(String orderTypeId){
		this.orderTypeId = orderTypeId;
	} 
    /**
     * @getElectricianPrice:维修费的get方法
     * @params
     * @return electricianPrice
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getElectricianPrice(){
        return this.electricianPrice;
    }
    /**
     * @setElectricianPrice:维修费的set方法
     * @param electricianPrice
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setElectricianPrice(String electricianPrice){
		this.electricianPrice = electricianPrice;
	} 
    /**
     * @getOrderElectricianType:订单状态的get方法
     * @params
     * @return orderElectricianType
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getOrderElectricianType(){
        return this.orderElectricianType;
    }
    /**
     * @setOrderElectricianType:订单状态的set方法
     * @param orderElectricianType
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setOrderElectricianType(String orderElectricianType){
		this.orderElectricianType = orderElectricianType;
	} 
    /**
     * @getPayStatus:支付状态的get方法
     * @params
     * @return payStatus
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getPayStatus(){
        return this.payStatus;
    }
    /**
     * @setPayStatus:支付状态的set方法
     * @param payStatus
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setPayStatus(String payStatus){
		this.payStatus = payStatus;
	} 
    /**
     * @getCreateTime:创建时间的get方法
     * @params
     * @return createTime
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public Timestamp getCreateTime(){
        return this.createTime;
    }
    /**
     * @setCreateTime:创建时间的set方法
     * @param createTime
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	} 
    /**
     * @getBeginTime:开始施工时间的get方法
     * @params
     * @return beginTime
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public Timestamp getBeginTime(){
        return this.beginTime;
    }
    /**
     * @setBeginTime:开始施工时间的set方法
     * @param beginTime
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setBeginTime(Timestamp beginTime){
		this.beginTime = beginTime;
	} 
    /**
     * @getUpdateTime:更新时间的get方法
     * @params
     * @return updateTime
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public Timestamp getUpdateTime(){
        return this.updateTime;
    }
    /**
     * @setUpdateTime:更新时间的set方法
     * @param updateTime
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * @getFinishTime:完工时间的get方法
     * @params
     * @return finishTime
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public Timestamp getFinishTime(){
        return this.finishTime;
    }
    /**
     * @setFinishTime:完工时间的set方法
     * @param finishTime
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setFinishTime(Timestamp finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * @getElectricianDescrive:电工描述的get方法
     * @params
     * @return electricianDescrive
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getElectricianDescrive(){
        return this.electricianDescrive;
    }
    /**
     * @setElectricianDescrive:电工描述的set方法
     * @param electricianDescrive
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setElectricianDescrive(String electricianDescrive){
		this.electricianDescrive = electricianDescrive;
	} 
    /**
     * @getElectricianDescriveIcon:电工拍照的get方法
     * @params
     * @return electricianDescriveIcon
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getElectricianDescriveIcon(){
        return this.electricianDescriveIcon;
    }
    /**
     * @setElectricianDescriveIcon:电工拍照的set方法
     * @param electricianDescriveIcon
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setElectricianDescriveIcon(String electricianDescriveIcon){
		this.electricianDescriveIcon = electricianDescriveIcon;
	} 
    /**
     * @getElectricianGrade:电工评分的get方法
     * @params
     * @return electricianGrade
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getElectricianGrade(){
        return this.electricianGrade;
    }
    /**
     * @setElectricianGrade:电工评分的set方法
     * @param electricianGrade
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setElectricianGrade(String electricianGrade){
		this.electricianGrade = electricianGrade;
	} 
    /**
     * @getElectricianEvaluate:电工评价的get方法
     * @params
     * @return electricianEvaluate
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getElectricianEvaluate(){
        return this.electricianEvaluate;
    }
    /**
     * @setElectricianEvaluate:电工评价的set方法
     * @param electricianEvaluate
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setElectricianEvaluate(String electricianEvaluate){
		this.electricianEvaluate = electricianEvaluate;
	} 
    /**
     * @getChargebackReason:退单原因的get方法
     * @params
     * @return chargebackReason
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getChargebackReason(){
        return this.chargebackReason;
    }
    /**
     * @setChargebackReason:退单原因的set方法
     * @param chargebackReason
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setChargebackReason(String chargebackReason){
		this.chargebackReason = chargebackReason;
	} 
    /**
     * @getOrderContract:订单合同的get方法
     * @params
     * @return orderContract
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getOrderContract(){
        return this.orderContract;
    }
    /**
     * @setOrderContract:订单合同的set方法
     * @param orderContract
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setOrderContract(String orderContract){
		this.orderContract = orderContract;
	} 
    /**
     * @getInspectionReport:验收报告的get方法
     * @params
     * @return inspectionReport
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getInspectionReport(){
        return this.inspectionReport;
    }
    /**
     * @setInspectionReport:验收报告的set方法
     * @param inspectionReport
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setInspectionReport(String inspectionReport){
		this.inspectionReport = inspectionReport;
	} 
    /**
     * @getRemarkStr1:REMARK_STR1的get方法
     * @params
     * @return remarkStr1
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getRemarkStr1(){
        return this.remarkStr1;
    }
    /**
     * @setRemarkStr1:REMARK_STR1的set方法
     * @param remarkStr1
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setRemarkStr1(String remarkStr1){
		this.remarkStr1 = remarkStr1;
	} 
    /**
     * @getRemarkStr2:REMARK_STR2的get方法
     * @params
     * @return remarkStr2
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getRemarkStr2(){
        return this.remarkStr2;
    }
    /**
     * @setRemarkStr2:REMARK_STR2的set方法
     * @param remarkStr2
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setRemarkStr2(String remarkStr2){
		this.remarkStr2 = remarkStr2;
	} 
    /**
     * @getRemarkStr3:REMARK_STR3的get方法
     * @params
     * @return remarkStr3
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getRemarkStr3(){
        return this.remarkStr3;
    }
    /**
     * @setRemarkStr3:REMARK_STR3的set方法
     * @param remarkStr3
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setRemarkStr3(String remarkStr3){
		this.remarkStr3 = remarkStr3;
	} 
    /**
     * @getRemarkNum1:REMARK_NUM1的get方法
     * @params
     * @return remarkNum1
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getRemarkNum1(){
        return this.remarkNum1;
    }
    /**
     * @setRemarkNum1:REMARK_NUM1的set方法
     * @param remarkNum1
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setRemarkNum1(String remarkNum1){
		this.remarkNum1 = remarkNum1;
	} 
    /**
     * @getRemarkNum2:REMARK_NUM2的get方法
     * @params
     * @return remarkNum2
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getRemarkNum2(){
        return this.remarkNum2;
    }
    /**
     * @setRemarkNum2:REMARK_NUM2的set方法
     * @param remarkNum2
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setRemarkNum2(String remarkNum2){
		this.remarkNum2 = remarkNum2;
	} 
    /**
     * @getConstructionContent:CONSTRUCTION_CONTENT的get方法
     * @params
     * @return constructionContent
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public String getConstructionContent(){
        return this.constructionContent;
    }
    /**
     * @setConstructionContent:CONSTRUCTION_CONTENT的set方法
     * @param constructionContent
     * @return
     * @date 2020-12-15 17:38:21
     * @author 18511
     */
    public void setConstructionContent(String constructionContent){
		this.constructionContent = constructionContent;
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
		
        if (obj == null || !(obj instanceof OrderElectricianHis))
	        return false; 
	        
		if (getClass() != obj.getClass())
			return false;
		
		OrderElectricianHis other = (OrderElectricianHis) obj;
		
		if (orderElectricianId == null) {
			if (other.orderElectricianId != null) {
				return false;
			}
		} else if (!orderElectricianId.equals(other.orderElectricianId)) {
			return false;
		}
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (electricianId == null) {
			if (other.electricianId != null) {
				return false;
			}
		} else if (!electricianId.equals(other.electricianId)) {
			return false;
		}
		if (electricianName == null) {
			if (other.electricianName != null) {
				return false;
			}
		} else if (!electricianName.equals(other.electricianName)) {
			return false;
		}
		if (electricianPhonenumber == null) {
			if (other.electricianPhonenumber != null) {
				return false;
			}
		} else if (!electricianPhonenumber.equals(other.electricianPhonenumber)) {
			return false;
		}
		if (electricianAddress == null) {
			if (other.electricianAddress != null) {
				return false;
			}
		} else if (!electricianAddress.equals(other.electricianAddress)) {
			return false;
		}
		if (otherElectricianId == null) {
			if (other.otherElectricianId != null) {
				return false;
			}
		} else if (!otherElectricianId.equals(other.otherElectricianId)) {
			return false;
		}
		if (orderTypeId == null) {
			if (other.orderTypeId != null) {
				return false;
			}
		} else if (!orderTypeId.equals(other.orderTypeId)) {
			return false;
		}
		if (electricianPrice == null) {
			if (other.electricianPrice != null) {
				return false;
			}
		} else if (!electricianPrice.equals(other.electricianPrice)) {
			return false;
		}
		if (orderElectricianType == null) {
			if (other.orderElectricianType != null) {
				return false;
			}
		} else if (!orderElectricianType.equals(other.orderElectricianType)) {
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
		if (beginTime == null) {
			if (other.beginTime != null) {
				return false;
			}
		} else if (!beginTime.equals(other.beginTime)) {
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
		if (electricianDescrive == null) {
			if (other.electricianDescrive != null) {
				return false;
			}
		} else if (!electricianDescrive.equals(other.electricianDescrive)) {
			return false;
		}
		if (electricianDescriveIcon == null) {
			if (other.electricianDescriveIcon != null) {
				return false;
			}
		} else if (!electricianDescriveIcon.equals(other.electricianDescriveIcon)) {
			return false;
		}
		if (electricianGrade == null) {
			if (other.electricianGrade != null) {
				return false;
			}
		} else if (!electricianGrade.equals(other.electricianGrade)) {
			return false;
		}
		if (electricianEvaluate == null) {
			if (other.electricianEvaluate != null) {
				return false;
			}
		} else if (!electricianEvaluate.equals(other.electricianEvaluate)) {
			return false;
		}
		if (chargebackReason == null) {
			if (other.chargebackReason != null) {
				return false;
			}
		} else if (!chargebackReason.equals(other.chargebackReason)) {
			return false;
		}
		if (orderContract == null) {
			if (other.orderContract != null) {
				return false;
			}
		} else if (!orderContract.equals(other.orderContract)) {
			return false;
		}
		if (inspectionReport == null) {
			if (other.inspectionReport != null) {
				return false;
			}
		} else if (!inspectionReport.equals(other.inspectionReport)) {
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
		if (constructionContent == null) {
			if (other.constructionContent != null) {
				return false;
			}
		} else if (!constructionContent.equals(other.constructionContent)) {
			return false;
		}
		return true;
	}
    
    /**
     * toString方法
     * @return String
     */
	public String toString(){
		return "OrderElectricianHis ["
			+ ", orderElectricianId=" + orderElectricianId
			+ ", orderId=" + orderId
			+ ", electricianId=" + electricianId
			+ ", electricianName=" + electricianName
			+ ", electricianPhonenumber=" + electricianPhonenumber
			+ ", electricianAddress=" + electricianAddress
			+ ", otherElectricianId=" + otherElectricianId
			+ ", orderTypeId=" + orderTypeId
			+ ", electricianPrice=" + electricianPrice
			+ ", orderElectricianType=" + orderElectricianType
			+ ", payStatus=" + payStatus
			+ ", createTime=" + createTime
			+ ", beginTime=" + beginTime
			+ ", updateTime=" + updateTime
			+ ", finishTime=" + finishTime
			+ ", electricianDescrive=" + electricianDescrive
			+ ", electricianDescriveIcon=" + electricianDescriveIcon
			+ ", electricianGrade=" + electricianGrade
			+ ", electricianEvaluate=" + electricianEvaluate
			+ ", chargebackReason=" + chargebackReason
			+ ", orderContract=" + orderContract
			+ ", inspectionReport=" + inspectionReport
			+ ", remarkStr1=" + remarkStr1
			+ ", remarkStr2=" + remarkStr2
			+ ", remarkStr3=" + remarkStr3
			+ ", remarkNum1=" + remarkNum1
			+ ", remarkNum2=" + remarkNum2
			+ ", constructionContent=" + constructionContent;
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