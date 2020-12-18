
    drop table if exists ELECTRICIAN_COMPANY_INFO;

    drop table if exists ELECTRICIAN_SUB_COMPANY_INFO;

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
        LEGAL_PERSON varchar(32) comment 'LEGAL_PERSON',
        CREDIT_CODE varchar(64) comment 'CREDIT_CODE',
        STRUCTURE_CODE varchar(64) comment 'STRUCTURE_CODE',
        ON_BUSINESS_BEGIN datetime comment 'ON_BUSINESS_BEGIN',
        ON_BUSINESS_END datetime comment 'ON_BUSINESS_END',
        BUSINESS_COPE varchar(64) comment 'BUSINESS_COPE',
        QUALI_CODE varchar(64) comment 'QUALI_CODE',
        QUALI_INDUSTRY varchar(64) comment 'QUALI_INDUSTRY',
        QUALI_LEVEL varchar(64) comment 'QUALI_LEVEL',
        CERTIFICATE_CODE varchar(64) comment 'CERTIFICATE_CODE',
        REGISETER_TIME datetime comment 'REGISETER_TIME',
        P_COMPANY_ID varchar(64) comment 'P_COMPANY_ID',
        REMARK1 text comment 'REMARK1',
        REMARK2 text comment 'REMARK2',
        REMARK3 text comment 'REMARK3',
        REMARK4 text comment 'REMARK4',
        REMARK5 text comment 'REMARK5',
        primary key (COMPANY_ID)
    ) comment='ElectricianCompanyInfo';

    create table ELECTRICIAN_SUB_COMPANY_INFO (
        SUB_COMPANY_ID varchar(64) not null comment 'SUB_COMPANY_ID',
        COMPANY_ID varchar(64) comment 'COMPANY_ID',
        COMPANY_NAME text comment 'COMPANY_NAME',
        COMPANY_PHONENUMBER varchar(32) comment 'COMPANY_PHONENUMBER',
        COMPANY_ADDRESS text comment 'COMPANY_ADDRESS',
        ADDRESS_LONGITUDE varchar(32) comment 'ADDRESS_LONGITUDE',
        ADDRESS_LATITUDE varchar(32) comment 'ADDRESS_LATITUDE',
        COMPANY_AREA_ID varchar(32) comment 'COMPANY_AREA_ID',
        COMPANY_LEVEL varchar(10) comment 'COMPANY_LEVEL',
        RATING_CERTIFICATE text comment 'RATING_CERTIFICATE',
        COMPANY_CONTRACT text comment 'COMPANY_CONTRACT',
        REMARK text comment 'REMARK',
        REMARK1 text comment 'REMARK1',
        REMARK2 text comment 'REMARK2',
        REMARK3 text comment 'REMARK3',
        primary key (SUB_COMPANY_ID)
    ) comment='ElectricianSubCompanyInfo';
