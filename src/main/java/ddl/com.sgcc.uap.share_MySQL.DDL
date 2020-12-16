
    alter table ORDER_ELECTRICIAN 
        drop 
        foreign key FKDE881C68C0DCFA34;

    drop table if exists ORDER_CUSTOMER;

    drop table if exists ORDER_ELECTRICIAN;

    drop table if exists ORDER_ELECTRICIAN_HIS;

    create table ORDER_CUSTOMER (
        ORDER_ID varchar(64) not null comment '订单ID',
        CUSTOMER_ID varchar(64) comment '客户ID',
        CUSTOMER_NAME varchar(10) comment '客户名称',
        CUSTOMER_PHONENUMBER varchar(32) comment '客户电话',
        CUSTOMER_ADDRESS text comment '客户地址',
        ADDRESS_LONGITUDE varchar(32) comment '地址经度',
        ADDRESS_LATITUDE varchar(32) comment '地址纬度',
        IDENTITY_ID varchar(2) comment '身份ID',
        VOLTAGE varchar(10) comment '电压',
        ORDER_TYPE_ID varchar(2) comment '订单类型ID',
        CUSTOMER_PRICE varchar(5) comment '上门服务费',
        ORDER_STATUS varchar(4) comment '订单状态',
        PAY_STATUS varchar(2) comment '支付状态',
        CREATE_TIME datetime comment '创建时间',
        APPOINTMENT_TIME datetime comment '预约时间',
        UPDATE_TIME datetime comment '更新时间',
        FINISH_TIME datetime comment '结束时间',
        CUSTOMER_DESCRIVE text comment '客户描述',
        CUSTOMER_DESCRIVE_ICON text comment '客户拍照',
        CUSTOMER_GRADE varchar(2) comment '客户评分',
        CUSTOMER_EVALUATE_TITLE varchar(128) comment '客户评价标题',
        CUSTOMER_EVALUATE text comment '客户评价',
        CUSTOMER_EVALUATE_PHOTO text comment '客户评价照片',
        ORDER_COMPLAINT_ID varchar(64) comment '订单投诉ID',
        REMARK_STR1 varchar(128) comment 'REMARK_STR1',
        REMARK_STR2 varchar(128) comment 'REMARK_STR2',
        REMARK_STR3 varchar(128) comment 'REMARK_STR3',
        REMARK_NUM1 varchar(8) comment 'REMARK_NUM1',
        REMARK_NUM2 varchar(8) comment 'REMARK_NUM2',
        primary key (ORDER_ID)
    ) comment='OrderCustomer';

    create table ORDER_ELECTRICIAN (
        ORDER_ELECTRICIAN_ID varchar(64) not null comment '电工订单ID',
        ORDER_ID varchar(64),
        ELECTRICIAN_ID varchar(64) comment '电工ID',
        ELECTRICIAN_NAME varchar(32) comment '电工名称',
        ELECTRICIAN_PHONENUMBER varchar(32) comment '电工电话',
        ELECTRICIAN_ADDRESS text comment '电工地址',
        OTHER_ELECTRICIAN_ID text comment '其他电工ID',
        ORDER_TYPE_ID varchar(2) comment '订单类型ID',
        ELECTRICIAN_PRICE varchar(6) comment '维修费',
        ORDER_ELECTRICIAN_TYPE varchar(2) comment '订单状态',
        PAY_STATUS varchar(2) comment '支付状态',
        CREATE_TIME datetime comment '创建时间',
        BEGIN_TIME datetime comment '开始施工时间',
        UPDATE_TIME datetime comment '更新时间',
        FINISH_TIME datetime comment '完工时间',
        ELECTRICIAN_DESCRIVE text comment '电工描述',
        ELECTRICIAN_DESCRIVE_ICON text comment '电工拍照',
        ELECTRICIAN_GRADE varchar(2) comment '电工评分',
        ELECTRICIAN_EVALUATE text comment '电工评价',
        CHARGEBACK_REASON text comment '退单原因',
        ORDER_CONTRACT text comment '订单合同',
        INSPECTION_REPORT text comment '验收报告',
        REMARK_STR1 varchar(128) comment 'REMARK_STR1',
        REMARK_STR2 varchar(128) comment 'REMARK_STR2',
        REMARK_STR3 varchar(128) comment 'REMARK_STR3',
        REMARK_NUM1 varchar(8) comment 'REMARK_NUM1',
        REMARK_NUM2 varchar(8) comment 'REMARK_NUM2',
        CONSTRUCTION_CONTENT text comment 'CONSTRUCTION_CONTENT',
        primary key (ORDER_ELECTRICIAN_ID)
    ) comment='OrderElectrician';

    create table ORDER_ELECTRICIAN_HIS (
        ORDER_ELECTRICIAN_ID varchar(64) not null comment '电工订单ID',
        ORDER_ID varchar(64) comment '订单ID',
        ELECTRICIAN_ID varchar(64) comment '电工ID',
        ELECTRICIAN_NAME varchar(32) comment '电工名称',
        ELECTRICIAN_PHONENUMBER varchar(32) comment '电工电话',
        ELECTRICIAN_ADDRESS text comment '电工地址',
        OTHER_ELECTRICIAN_ID text comment '其他电工ID',
        ORDER_TYPE_ID varchar(2) comment '订单类型ID',
        ELECTRICIAN_PRICE varchar(6) comment '维修费',
        ORDER_ELECTRICIAN_TYPE varchar(2) comment '订单状态',
        PAY_STATUS varchar(2) comment '支付状态',
        CREATE_TIME datetime comment '创建时间',
        BEGIN_TIME datetime comment '开始施工时间',
        UPDATE_TIME datetime comment '更新时间',
        FINISH_TIME datetime comment '完工时间',
        ELECTRICIAN_DESCRIVE text comment '电工描述',
        ELECTRICIAN_DESCRIVE_ICON text comment '电工拍照',
        ELECTRICIAN_GRADE varchar(2) comment '电工评分',
        ELECTRICIAN_EVALUATE text comment '电工评价',
        CHARGEBACK_REASON text comment '退单原因',
        ORDER_CONTRACT text comment '订单合同',
        INSPECTION_REPORT text comment '验收报告',
        REMARK_STR1 varchar(128) comment 'REMARK_STR1',
        REMARK_STR2 varchar(128) comment 'REMARK_STR2',
        REMARK_STR3 varchar(128) comment 'REMARK_STR3',
        REMARK_NUM1 varchar(8) comment 'REMARK_NUM1',
        REMARK_NUM2 varchar(8) comment 'REMARK_NUM2',
        CONSTRUCTION_CONTENT text comment 'CONSTRUCTION_CONTENT',
        primary key (ORDER_ELECTRICIAN_ID)
    ) comment='OrderElectricianHis';

    alter table ORDER_ELECTRICIAN 
        add index FKDE881C68C0DCFA34 (ORDER_ID), 
        add constraint FKDE881C68C0DCFA34 
        foreign key (ORDER_ID) 
        references ORDER_CUSTOMER (ORDER_ID);
