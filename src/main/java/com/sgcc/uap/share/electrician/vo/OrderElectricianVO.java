package com.sgcc.uap.share.electrician.vo;

import java.io.Serializable;
import java.sql.Timestamp;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;


/**
 * OrderElectrician的VO类
 *
 * @author 18511 
 */
public class OrderElectricianVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性电工订单ID
     */  
    @ViewAttribute(name ="orderElectricianId",caption="电工订单ID", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String orderElectricianId;    
    /** 
     * 属性电工ID
     */  
    @ViewAttribute(name ="electricianId",caption="电工ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianId;    
    /** 
     * 属性电工名称
     */  
    @ViewAttribute(name ="electricianName",caption="电工名称", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianName;    
    /** 
     * 属性电工电话
     */  
    @ViewAttribute(name ="electricianPhonenumber",caption="电工电话", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianPhonenumber;    
    /** 
     * 属性电工地址
     */  
    @ViewAttribute(name ="electricianAddress",caption="电工地址", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianAddress;    
    /** 
     * 属性其他电工ID
     */  
    @ViewAttribute(name ="otherElectricianId",caption="其他电工ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String otherElectricianId;    
    /** 
     * 属性订单类型ID
     */  
    @ViewAttribute(name ="orderTypeId",caption="订单类型ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String orderTypeId;    
    /** 
     * 属性维修费
     */  
    @ViewAttribute(name ="electricianPrice",caption="维修费", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianPrice;    
    /** 
     * 属性订单状态
     */  
    @ViewAttribute(name ="orderElectricianType",caption="订单状态", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String orderElectricianType;    
    /** 
     * 属性支付状态
     */  
    @ViewAttribute(name ="payStatus",caption="支付状态", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String payStatus;    
    /** 
     * 属性创建时间
     */  
    @ViewAttribute(name ="createTime",caption="创建时间", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp createTime;    
    /** 
     * 属性开始施工时间
     */  
    @ViewAttribute(name ="beginTime",caption="开始施工时间", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp beginTime;    
    /** 
     * 属性更新时间
     */  
    @ViewAttribute(name ="updateTime",caption="更新时间", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp updateTime;    
    /** 
     * 属性完工时间
     */  
    @ViewAttribute(name ="finishTime",caption="完工时间", editor=EditorType.DateTimeEditor,nullable =true,readOnly=false, type=AttributeType.TIMESTAMP)
    private Timestamp finishTime;    
    /** 
     * 属性电工描述
     */  
    @ViewAttribute(name ="electricianDescrive",caption="电工描述", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianDescrive;    
    /** 
     * 属性电工拍照
     */  
    @ViewAttribute(name ="electricianDescriveIcon",caption="电工拍照", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianDescriveIcon;    
    /** 
     * 属性电工评分
     */  
    @ViewAttribute(name ="electricianGrade",caption="电工评分", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianGrade;    
    /** 
     * 属性电工评价
     */  
    @ViewAttribute(name ="electricianEvaluate",caption="电工评价", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String electricianEvaluate;    
    /** 
     * 属性退单原因
     */  
    @ViewAttribute(name ="chargebackReason",caption="退单原因", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String chargebackReason;    
    /** 
     * 属性订单合同
     */  
    @ViewAttribute(name ="orderContract",caption="订单合同", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String orderContract;    
    /** 
     * 属性验收报告
     */  
    @ViewAttribute(name ="inspectionReport",caption="验收报告", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String inspectionReport;    
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
    /** 
     * 属性ORDER_ID
     */  
    @ViewAttribute(name ="orDERId",caption="ORDER_ID", editor=EditorType.ComboEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String orDERId;    
    /**
     * OrderElectricianVO构造函数
     */
    public OrderElectricianVO() {
        super();
    } 
   
	 /**
     * OrderElectricianVO完整的构造函数
     */  
    public OrderElectricianVO(String orderElectricianId){
        this.orderElectricianId = orderElectricianId;
    }
    /**
     * 电工订单ID的get方法
     * @return orderElectricianId
     */
    public String getOrderElectricianId(){
        return orderElectricianId;
    }
    /**
     * 电工订单ID的set方法
     * @param orderElectricianId
     */
    public void setOrderElectricianId(String orderElectricianId){
        if(orderElectricianId != null && orderElectricianId.trim().length() == 0){
        	this.orderElectricianId = null;
        }else{
        	this.orderElectricianId = orderElectricianId;
        }
	} 
    /**
     * 电工ID的get方法
     * @return electricianId
     */
    public String getElectricianId(){
        return electricianId;
    }
    /**
     * 电工ID的set方法
     * @param electricianId
     */
    public void setElectricianId(String electricianId){
		this.electricianId = electricianId;
	} 
    /**
     * 电工名称的get方法
     * @return electricianName
     */
    public String getElectricianName(){
        return electricianName;
    }
    /**
     * 电工名称的set方法
     * @param electricianName
     */
    public void setElectricianName(String electricianName){
		this.electricianName = electricianName;
	} 
    /**
     * 电工电话的get方法
     * @return electricianPhonenumber
     */
    public String getElectricianPhonenumber(){
        return electricianPhonenumber;
    }
    /**
     * 电工电话的set方法
     * @param electricianPhonenumber
     */
    public void setElectricianPhonenumber(String electricianPhonenumber){
		this.electricianPhonenumber = electricianPhonenumber;
	} 
    /**
     * 电工地址的get方法
     * @return electricianAddress
     */
    public String getElectricianAddress(){
        return electricianAddress;
    }
    /**
     * 电工地址的set方法
     * @param electricianAddress
     */
    public void setElectricianAddress(String electricianAddress){
		this.electricianAddress = electricianAddress;
	} 
    /**
     * 其他电工ID的get方法
     * @return otherElectricianId
     */
    public String getOtherElectricianId(){
        return otherElectricianId;
    }
    /**
     * 其他电工ID的set方法
     * @param otherElectricianId
     */
    public void setOtherElectricianId(String otherElectricianId){
		this.otherElectricianId = otherElectricianId;
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
     * 维修费的get方法
     * @return electricianPrice
     */
    public String getElectricianPrice(){
        return electricianPrice;
    }
    /**
     * 维修费的set方法
     * @param electricianPrice
     */
    public void setElectricianPrice(String electricianPrice){
		this.electricianPrice = electricianPrice;
	} 
    /**
     * 订单状态的get方法
     * @return orderElectricianType
     */
    public String getOrderElectricianType(){
        return orderElectricianType;
    }
    /**
     * 订单状态的set方法
     * @param orderElectricianType
     */
    public void setOrderElectricianType(String orderElectricianType){
		this.orderElectricianType = orderElectricianType;
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
    public Timestamp getCreateTime(){
        return createTime;
    }
    /**
     * 创建时间的set方法
     * @param createTime
     */
    public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	} 
    /**
     * 开始施工时间的get方法
     * @return beginTime
     */
    public Timestamp getBeginTime(){
        return beginTime;
    }
    /**
     * 开始施工时间的set方法
     * @param beginTime
     */
    public void setBeginTime(Timestamp beginTime){
		this.beginTime = beginTime;
	} 
    /**
     * 更新时间的get方法
     * @return updateTime
     */
    public Timestamp getUpdateTime(){
        return updateTime;
    }
    /**
     * 更新时间的set方法
     * @param updateTime
     */
    public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	} 
    /**
     * 完工时间的get方法
     * @return finishTime
     */
    public Timestamp getFinishTime(){
        return finishTime;
    }
    /**
     * 完工时间的set方法
     * @param finishTime
     */
    public void setFinishTime(Timestamp finishTime){
		this.finishTime = finishTime;
	} 
    /**
     * 电工描述的get方法
     * @return electricianDescrive
     */
    public String getElectricianDescrive(){
        return electricianDescrive;
    }
    /**
     * 电工描述的set方法
     * @param electricianDescrive
     */
    public void setElectricianDescrive(String electricianDescrive){
		this.electricianDescrive = electricianDescrive;
	} 
    /**
     * 电工拍照的get方法
     * @return electricianDescriveIcon
     */
    public String getElectricianDescriveIcon(){
        return electricianDescriveIcon;
    }
    /**
     * 电工拍照的set方法
     * @param electricianDescriveIcon
     */
    public void setElectricianDescriveIcon(String electricianDescriveIcon){
		this.electricianDescriveIcon = electricianDescriveIcon;
	} 
    /**
     * 电工评分的get方法
     * @return electricianGrade
     */
    public String getElectricianGrade(){
        return electricianGrade;
    }
    /**
     * 电工评分的set方法
     * @param electricianGrade
     */
    public void setElectricianGrade(String electricianGrade){
		this.electricianGrade = electricianGrade;
	} 
    /**
     * 电工评价的get方法
     * @return electricianEvaluate
     */
    public String getElectricianEvaluate(){
        return electricianEvaluate;
    }
    /**
     * 电工评价的set方法
     * @param electricianEvaluate
     */
    public void setElectricianEvaluate(String electricianEvaluate){
		this.electricianEvaluate = electricianEvaluate;
	} 
    /**
     * 退单原因的get方法
     * @return chargebackReason
     */
    public String getChargebackReason(){
        return chargebackReason;
    }
    /**
     * 退单原因的set方法
     * @param chargebackReason
     */
    public void setChargebackReason(String chargebackReason){
		this.chargebackReason = chargebackReason;
	} 
    /**
     * 订单合同的get方法
     * @return orderContract
     */
    public String getOrderContract(){
        return orderContract;
    }
    /**
     * 订单合同的set方法
     * @param orderContract
     */
    public void setOrderContract(String orderContract){
		this.orderContract = orderContract;
	} 
    /**
     * 验收报告的get方法
     * @return inspectionReport
     */
    public String getInspectionReport(){
        return inspectionReport;
    }
    /**
     * 验收报告的set方法
     * @param inspectionReport
     */
    public void setInspectionReport(String inspectionReport){
		this.inspectionReport = inspectionReport;
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
     * ORDER_ID的get方法
     * @return orDERId
     */
    public String getOrDERId(){
        return orDERId;
    }
    /**
     * ORDER_ID的set方法
     * @param orDERId
     */
    public void setOrDERId(String orDERId){
		this.orDERId = orDERId;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("ORDER_ELECTRICIAN_ID"+":"+getOrderElectricianId())
				.append("ELECTRICIAN_ID"+":"+getElectricianId())
				.append("ELECTRICIAN_NAME"+":"+getElectricianName())
				.append("ELECTRICIAN_PHONENUMBER"+":"+getElectricianPhonenumber())
				.append("ELECTRICIAN_ADDRESS"+":"+getElectricianAddress())
				.append("OTHER_ELECTRICIAN_ID"+":"+getOtherElectricianId())
				.append("ORDER_TYPE_ID"+":"+getOrderTypeId())
				.append("ELECTRICIAN_PRICE"+":"+getElectricianPrice())
				.append("ORDER_ELECTRICIAN_TYPE"+":"+getOrderElectricianType())
				.append("PAY_STATUS"+":"+getPayStatus())
				.append("CREATE_TIME"+":"+getCreateTime())
				.append("BEGIN_TIME"+":"+getBeginTime())
				.append("UPDATE_TIME"+":"+getUpdateTime())
				.append("FINISH_TIME"+":"+getFinishTime())
				.append("ELECTRICIAN_DESCRIVE"+":"+getElectricianDescrive())
				.append("ELECTRICIAN_DESCRIVE_ICON"+":"+getElectricianDescriveIcon())
				.append("ELECTRICIAN_GRADE"+":"+getElectricianGrade())
				.append("ELECTRICIAN_EVALUATE"+":"+getElectricianEvaluate())
				.append("CHARGEBACK_REASON"+":"+getChargebackReason())
				.append("ORDER_CONTRACT"+":"+getOrderContract())
				.append("INSPECTION_REPORT"+":"+getInspectionReport())
				.append("REMARK_STR1"+":"+getRemarkStr1())
				.append("REMARK_STR2"+":"+getRemarkStr2())
				.append("REMARK_STR3"+":"+getRemarkStr3())
				.append("REMARK_NUM1"+":"+getRemarkNum1())
				.append("REMARK_NUM2"+":"+getRemarkNum2())
				.append("ORDER_ID"+":"+getOrDERId())
		        .toString(); 
			
    } 
   


}
