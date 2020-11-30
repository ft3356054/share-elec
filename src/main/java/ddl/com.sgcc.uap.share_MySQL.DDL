
    drop table if exists BASE_AREA;

    drop table if exists BASE_AREA_PRICE;

    drop table if exists BASE_CITY;

    drop table if exists BASE_PROVINCE;

    create table BASE_AREA (
        ID varchar(64) not null comment 'ID',
        AREA_ID varchar(4) comment 'AREA_ID',
        PROVINCE_NAME varchar(64) comment 'PROVINCE_NAME',
        REMARK varchar(64) comment 'REMARK',
        primary key (ID)
    ) comment='BaseArea';

    create table BASE_AREA_PRICE (
        ID varchar(64) not null comment 'ID',
        PROVINCE_ID varchar(4) comment 'PROVINCE_ID',
        CITY_ID varchar(4) comment 'CITY_ID',
        AREA_ID varchar(4) comment 'AREA_ID',
        PRICE varchar(6) not null comment 'PRICE',
        REMARK varchar(64) comment 'REMARK',
        primary key (ID)
    ) comment='BaseAreaPrice';

    create table BASE_CITY (
        ID varchar(64) not null comment 'ID',
        CITY_ID varchar(4) comment 'CITY_ID',
        PROVINCE_ID varchar(4) comment 'PROVINCE_ID',
        CITY_NAME varchar(64) comment 'CITY_NAME',
        REMARK varchar(64) comment 'REMARK',
        primary key (ID)
    ) comment='BaseCity';

    create table BASE_PROVINCE (
        PROVINCE_ID varchar(4) not null comment 'PROVINCE_ID',
        PROVINCE_NAME varchar(64) comment 'PROVINCE_NAME',
        REGION varchar(64) comment 'REGION',
        REMARK varchar(64) comment 'REMARK',
        primary key (PROVINCE_ID)
    ) comment='BaseProvince';
