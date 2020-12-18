
    drop table if exists ELECTRICIAN_INFO;

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
        CERTIFICATE_A text comment 'CERTIFICATE_A',
        CERTIFICATE_B text comment 'CERTIFICATE_B',
        CERTIFICATE_C text comment 'CERTIFICATE_C',
        REMARK text comment 'REMARK',
        primary key (ELECTRICIAN_ID)
    ) comment='ElectricianInfo';
