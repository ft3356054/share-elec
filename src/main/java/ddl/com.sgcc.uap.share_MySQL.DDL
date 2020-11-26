
    alter table BASE_AREA 
        drop 
        foreign key FK3B8E1D3B192F7544;

    alter table ORDER_COMPLAINT 
        drop 
        foreign key FK2C68F4BAC0DCFA34;

    alter table ORDER_ELECTRICIAN 
        drop 
        foreign key FKDE881C68C0DCFA34;

    alter table ORDER_FLOW 
        drop 
        foreign key FK4BBC6F9FC0DCFA34;

    alter table ORDER_PAY 
        drop 
        foreign key FK8ED4ABF7C0DCFA34;

    drop table if exists BASE_AREA;

    drop table if exists BASE_IDENTITY_DETAIL;

    drop table if exists BASE_ORDER_TYPE;

    drop table if exists BASE_PROVINCE;

    drop table if exists CUSTOMER_INFO;

    drop table if exists ELECTRICIAN_COMPANY_INFO;

    drop table if exists NOTIFY_ANNOUNCE;

    drop table if exists NOTIFY_ANNOUNCE_USER;

    drop table if exists ORDER_COMPLAINT;

    drop table if exists ORDER_CUSTOMER;

    drop table if exists ORDER_ELECTRICIAN;

    drop table if exists ORDER_FLOW;

    drop table if exists ORDER_PAY;

    create table BASE_AREA (
        AREA_ID varchar(4) not null comment 'AREA_ID',
        BAS_PROVINCE_ID varchar(4),
        PROVINCE_ID varchar(64) comment 'PROVINCE_ID',
        PROVINCE_NAME varchar(64) comment 'PROVINCE_NAME',
        REMARK varchar(64) comment 'REMARK',
        primary key (AREA_ID)
    ) comment='BaseArea';

    create table BASE_IDENTITY_DETAIL (
        IDENTITY_ID varchar(2) not null comment '身份ID',
        IDENTITY_NAME varchar(10) comment '身份名称',
        primary key (IDENTITY_ID)
    ) comment='BaseIdentityDetail';

    create table BASE_ORDER_TYPE (
        ORDER_TYPE_ID varchar(2) not null comment '订单类型ID',
        ORDER_TYPE_NAME varchar(10) comment '订单类型名称',
        primary key (ORDER_TYPE_ID)
    ) comment='BaseOrderType';

    create table BASE_PROVINCE (
        PROVINCE_ID varchar(4) not null comment 'PROVINCE_ID',
        PROVINCE_NAME varchar(64) comment 'PROVINCE_NAME',
        REGION varchar(64) comment 'REGION',
        REMARK varchar(64) comment 'REMARK',
        primary key (PROVINCE_ID)
    ) comment='BaseProvince';

    create table CUSTOMER_INFO (
        CUSTOMER_ID varchar(64) not null comment 'CUSTOMER_ID',
        CUSTOMER_NAME varchar(32) comment 'CUSTOMER_NAME',
        CUSTOMER_PHONENUMBER varchar(32) comment 'CUSTOMER_PHONENUMBER',
        ADDRESS_LONGITUDE varchar(32) comment 'ADDRESS_LONGITUDE',
        ADDRESS_LATITUDE varchar(32) comment 'ADDRESS_LATITUDE',
        IDENTITY_ID varchar(2) comment 'IDENTITY_ID',
        CUSTOMER_SCORE varchar(2) comment 'CUSTOMER_SCORE',
        REMARK text comment 'REMARK',
        CUSTOMER_ADDRESS text comment 'CUSTOMER_ADDRESS',
        primary key (CUSTOMER_ID)
    ) comment='CustomerInfo';

    create table ELECTRICIAN_COMPANY_INFO (
        COMPANY_ID varchar(64) not null comment 'COMPANY_ID',
        COMPANY_NAME text comment 'COMPANY_NAME',
        COMPANY_PHONENUMBER varchar(32) comment 'COMPANY_PHONENUMBER',
        COMPANY_ADDRESS text comment 'COMPANY_ADDRESS',
        ADDRESS_LONGITUDE varchar(32) comment 'ADDRESS_LONGITUDE',
        ADDRESS_LATITUDE varchar(32) comment 'ADDRESS_LATITUDE',
        COMPANY_LEVEL varchar(10) comment 'COMPANY_LEVEL',
        RATING_CERTIFICATE text comment 'RATING_CERTIFICATE',
        COMPANY_CONTRACT text comment 'COMPANY_CONTRACT',
        REMARK text comment 'REMARK',
        primary key (COMPANY_ID)
    ) comment='ElectricianCompanyInfo';

    create table NOTIFY_ANNOUNCE (
        ANNOUNCE_ID varchar(64) not null comment 'ANNOUNCE_ID',
        SERDER_ID varchar(64) comment 'SERDER_ID',
        TITLE varchar(64) comment 'TITLE',
        CONTENT text comment 'CONTENT',
        CREATE_TIME datetime comment 'CREATE_TIME',
        REMARK text comment 'REMARK',
        primary key (ANNOUNCE_ID)
    ) comment='NotifyAnnounce';

    create table NOTIFY_ANNOUNCE_USER (
        ANNOUNCE_USER_ID varchar(64) not null comment 'ANNOUNCE_USER_ID',
        ANNOUNCE_ID varchar(64) comment 'ANNOUNCE_ID',
        RECIPIENT_TYPE varchar(2) comment 'RECIPIENT_TYPE',
        STATE varchar(2) comment 'STATE',
        CREATE_TIME datetime comment 'CREATE_TIME',
        READ_TIME datetime comment 'READ_TIME',
        REMARK text comment 'REMARK',
        primary key (ANNOUNCE_USER_ID)
    ) comment='NotifyAnnounceUser';

    create table ORDER_COMPLAINT (
        ORDER_COMPLAINT_ID varchar(64) not null comment 'ORDER_COMPLAINT_ID',
        ORDER_ID varchar(64),
        COMPLAINT_TYPE varchar(2) comment 'COMPLAINT_TYPE',
        COMPLAINT_DETAIL text comment 'COMPLAINT_DETAIL',
        SERVICE_ID varchar(64) comment 'SERVICE_ID',
        RESULTS_DETAIL text comment 'RESULTS_DETAIL',
        REMARK text comment 'REMARK',
        primary key (ORDER_COMPLAINT_ID)
    ) comment='OrderComplaint';

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
        primary key (ORDER_ELECTRICIAN_ID)
    ) comment='OrderElectrician';

    create table ORDER_FLOW (
        FLOW_ID varchar(64) not null comment 'FLOW_ID',
        ORDER_ID varchar(64),
        FLOW_TYPE varchar(2) comment 'FLOW_TYPE',
        CURR_STATUS varchar(2) comment 'CURR_STATUS',
        OPERATOR_ID varchar(64) comment 'OPERATOR_ID',
        OPERATOR_TIME datetime comment 'OPERATOR_TIME',
        OPERATOR_TYPE varchar(2) comment 'OPERATOR_TYPE',
        REMARK text comment 'REMARK',
        primary key (FLOW_ID)
    ) comment='OrderFlow';

    create table ORDER_PAY (
        PAY_ID varchar(64) not null comment 'PAY_ID',
        ORDER_ID varchar(64),
        PAY_TYPE varchar(2) comment 'PAY_TYPE',
        PAY_USER varchar(64) comment 'PAY_USER',
        PRICE varchar(6) comment 'PRICE',
        PAY_TIME datetime comment 'PAY_TIME',
        PAY_STATUS varchar(2) comment 'PAY_STATUS',
        REMARK text comment 'REMARK',
        primary key (PAY_ID)
    ) comment='OrderPay';

    alter table BASE_AREA 
        add index FK3B8E1D3B192F7544 (BAS_PROVINCE_ID), 
        add constraint FK3B8E1D3B192F7544 
        foreign key (BAS_PROVINCE_ID) 
        references BASE_PROVINCE (PROVINCE_ID);

    alter table ORDER_COMPLAINT 
        add index FK2C68F4BAC0DCFA34 (ORDER_ID), 
        add constraint FK2C68F4BAC0DCFA34 
        foreign key (ORDER_ID) 
        references ORDER_CUSTOMER (ORDER_ID);

    alter table ORDER_ELECTRICIAN 
        add index FKDE881C68C0DCFA34 (ORDER_ID), 
        add constraint FKDE881C68C0DCFA34 
        foreign key (ORDER_ID) 
        references ORDER_CUSTOMER (ORDER_ID);

    alter table ORDER_FLOW 
        add index FK4BBC6F9FC0DCFA34 (ORDER_ID), 
        add constraint FK4BBC6F9FC0DCFA34 
        foreign key (ORDER_ID) 
        references ORDER_CUSTOMER (ORDER_ID);

    alter table ORDER_PAY 
        add index FK8ED4ABF7C0DCFA34 (ORDER_ID), 
        add constraint FK8ED4ABF7C0DCFA34 
        foreign key (ORDER_ID) 
        references ORDER_CUSTOMER (ORDER_ID);
