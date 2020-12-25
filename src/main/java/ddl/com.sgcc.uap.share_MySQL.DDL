
    drop table if exists BASE_SYSTEM_CONFIG;

    create table BASE_SYSTEM_CONFIG (
        CONFIG_ID varchar(64) not null comment 'CONFIG_ID',
        CONFIG_NAME varchar(64) comment 'CONFIG_NAME',
        CONFIG_VALUE varchar(64) comment 'CONFIG_VALUE',
        CONFIG_TYPE varchar(4) comment 'CONFIG_TYPE',
        CONFIG_STATUS varchar(2) comment 'CONFIG_STATUS',
        primary key (CONFIG_ID)
    ) comment='BaseSystemConfig';
