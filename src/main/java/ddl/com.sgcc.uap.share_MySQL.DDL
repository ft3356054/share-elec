
    drop table if exists CUST_POSITION;

    drop table if exists ELEC_POSITION;

    create table CUST_POSITION (
        ORDER_ID varchar(64) not null comment 'ORDER_ID',
        CUSTOMER_ID varchar(64) comment 'CUSTOMER_ID',
        AREA_ID varchar(64) comment 'AREA_ID',
        LON varchar(64) comment 'LON',
        LAT varchar(64) comment 'LAT',
        primary key (ORDER_ID)
    ) comment='CustPosition';

    create table ELEC_POSITION (
        ELECTRICIAN_ID varchar(64) not null comment 'ELECTRICIAN_ID',
        AREA_ID varchar(64) comment 'AREA_ID',
        LON varchar(64) comment 'LON',
        LAT varchar(64) comment 'LAT',
        primary key (ELECTRICIAN_ID)
    ) comment='ElecPosition';
