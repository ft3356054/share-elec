
    drop table if exists ELECTRICIAN_INFO;

    drop table if exists ORDER_AUDIT_ELECTRICIAN;

    create table ELECTRICIAN_INFO (
        ELECTRICIAN_ID varchar(64) not null comment 'ELECTRICIAN_ID',
        ELECTRICIAN_NAME varchar(32) comment 'ELECTRICIAN_NAME',
        ELECTRICIAN_PHONENUMBER varchar(32) comment 'ELECTRICIAN_PHONENUMBER',
        ELECTRICIAN_STATUS varchar(2) comment 'ELECTRICIAN_STATUS',
        ADDRESS_LONGITUDE varchar(32) comment 'ADDRESS_LONGITUDE',
        ADDRESS_LATITUDE varchar(32) comment 'ADDRESS_LATITUDE',
        ELECTRICIAN_LEVEL varchar(10) comment 'ELECTRICIAN_LEVEL',
        SUB_COMPANY_ID varchar(64) comment 'SUB_COMPANY_ID',
        COMPANY_NAME text comment 'COMPANY_NAME',
        RATING_CERTIFICATE text comment 'RATING_CERTIFICATE',
        COMPANY_CONTRACT text comment 'COMPANY_CONTRACT',
        ELECTRICIAN_SCORE varchar(2) comment 'ELECTRICIAN_SCORE',
        IDENTITY_INFO text comment 'IDENTITY_INFO',
        ELECTRICIAN_CERTIFICATE text comment 'ELECTRICIAN_CERTIFICATE',
        REAL_NAME_AUTH varchar(2) comment 'REAL_NAME_AUTH',
        CERTIFICATE_A text comment 'CERTIFICATE_A',
        CERTIFICATE_B text comment 'CERTIFICATE_B',
        CERTIFICATE_C text comment 'CERTIFICATE_C',
        REMARK text comment 'REMARK',
        primary key (ELECTRICIAN_ID)
    ) comment='ElectricianInfo';

    create table ORDER_AUDIT_ELECTRICIAN (
        ORDER_ID varchar(64) not null comment 'ORDER_ID',
        ORDER_TYPE varchar(2) comment 'ORDER_TYPE',
        CREATE_TIME datetime comment 'CREATE_TIME',
        UPDATE_TIME datetime comment 'UPDATE_TIME',
        FINISH_TIME datetime comment 'FINISH_TIME',
        AUDITOR_ID varchar(64) comment 'AUDITOR_ID',
        AUDITOR_COMMENT text comment 'AUDITOR_COMMENT',
        ELECTRICIAN_ID varchar(64) comment 'ELECTRICIAN_ID',
        ELECTRICIAN_NAME varchar(32) comment 'ELECTRICIAN_NAME',
        ELECTRICIAN_PHONENUMBER varchar(32) comment 'ELECTRICIAN_PHONENUMBER',
        ELECTRICIAN_LEVEL varchar(32) comment 'ELECTRICIAN_LEVEL',
        SUB_COMPANY_ID varchar(64) comment 'SUB_COMPANY_ID',
        COMPANY_ID varchar(64) comment 'COMPANY_ID',
        COMPANY_NAME text comment 'COMPANY_NAME',
        RATING_CERTIFICATE text comment 'RATING_CERTIFICATE',
        COMPANY_CONTRACT text comment 'COMPANY_CONTRACT',
        IDENTITY_INFO text comment 'IDENTITY_INFO',
        ELECTRICIAN_CERTIFICATE text comment 'ELECTRICIAN_CERTIFICATE',
        CERTIFICATE_A text comment 'CERTIFICATE_A',
        CERTIFICATE_B text comment 'CERTIFICATE_B',
        CERTIFICATE_C text comment 'CERTIFICATE_C',
        REMARK text comment 'REMARK',
        primary key (ORDER_ID)
    ) comment='OrderAuditElectrician';
