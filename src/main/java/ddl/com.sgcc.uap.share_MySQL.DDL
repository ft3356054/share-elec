
    drop table if exists ORDER_COMPLAINT;

    create table ORDER_COMPLAINT (
        ORDER_COMPLAINT_ID varchar(64) not null comment 'ORDER_COMPLAINT_ID',
        ORDER_ID varchar(64) not null comment 'ORDER_ID',
        CUSTOMER_ID varchar(64) comment 'CUSTOMER_ID',
        CUSTOMER_NAME varchar(64) comment 'CUSTOMER_NAME',
        CUSTOMER_PHONENUMBER varchar(64) comment 'CUSTOMER_PHONENUMBER',
        COMPANY_ID varchar(64) comment 'COMPANY_ID',
        COMPANY_NAME varchar(64) comment 'COMPANY_NAME',
        COMPLAINT_TYPE varchar(2) comment 'COMPLAINT_TYPE',
        CREATE_TIME datetime comment 'CREATE_TIME',
        UPDATE_TIME datetime comment 'UPDATE_TIME',
        FINISH_TIME datetime comment 'FINISH_TIME',
        COMPLAINT_STATUS varchar(2) comment 'COMPLAINT_STATUS',
        COMPLAINT_DETAIL text comment 'COMPLAINT_DETAIL',
        COMPLAINT_PICTURE text comment 'COMPLAINT_PICTURE',
        SERVICE_ID varchar(64) comment 'SERVICE_ID',
        RESULTS_DETAIL text comment 'RESULTS_DETAIL',
        REMARK text comment 'REMARK',
        REMARK1 text comment 'REMARK1',
        REMARK2 text comment 'REMARK2',
        primary key (ORDER_COMPLAINT_ID)
    ) comment='OrderComplaint';
