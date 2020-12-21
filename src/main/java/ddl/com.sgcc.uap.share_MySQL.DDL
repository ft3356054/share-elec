
    drop table if exists BASE_VOLTAGE;

    create table BASE_VOLTAGE (
        VOLTAGE_ID varchar(32) not null comment '身份ID',
        VOLTAGE varchar(32) comment '身份名称',
        REMARK varchar(32) comment 'REMARK',
        primary key (VOLTAGE_ID)
    ) comment='BaseVoltage';
