
    drop table if exists BASE_LABEL;

    drop table if exists ORDER_COMPLAINT;

    create table BASE_LABEL (
        ID varchar(64) not null comment 'ID',
        LABEL_ID varchar(64) comment 'LABEL_ID',
        LABEL_NAME varchar(64) comment 'LABEL_NAME',
        LABEL_STATUS varchar(2) comment 'LABEL_STATUS',
        REMARK text comment 'REMARK',
        primary key (ID)
    ) comment='BaseLabel';

    create table ORDER_COMPLAINT (
        ORDER_COMPLAINT_ID varchar(64) not null comment 'ORDER_COMPLAINT_ID',
        ORDER_ID varchar(64) not null comment 'ORDER_ID',
        COMPLAINT_TYPE varchar(2) comment 'COMPLAINT_TYPE',
        COMPLAINT_DETAIL text comment 'COMPLAINT_DETAIL',
        COMPLAINT_PICTURE text comment 'COMPLAINT_PICTURE',
        SERVICE_ID varchar(64) comment 'SERVICE_ID',
        RESULTS_DETAIL text comment 'RESULTS_DETAIL',
        REMARK text comment 'REMARK',
        primary key (ORDER_COMPLAINT_ID)
    ) comment='OrderComplaint';
