
    drop table if exists CUSTOMER_INFO;

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
        HEAD_ICON text comment 'HEAD_ICON',
        REAL_NAME_AUTH varchar(2) comment 'REAL_NAME_AUTH',
        REGISTERED_NUMBER varchar(32) comment 'REGISTERED_NUMBER',
        primary key (CUSTOMER_ID)
    ) comment='CustomerInfo';
