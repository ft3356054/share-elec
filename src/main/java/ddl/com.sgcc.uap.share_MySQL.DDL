
    drop table if exists NOTIFY_ANNOUNCE;

    create table NOTIFY_ANNOUNCE (
        ANNOUNCE_ID varchar(64) not null comment 'ANNOUNCE_ID',
        SERDER_ID varchar(64) comment 'SERDER_ID',
        TITLE varchar(64) comment 'TITLE',
        CONTENT text comment 'CONTENT',
        CREATE_TIME datetime comment 'CREATE_TIME',
        NOTIFY_TYPE varchar(2) comment 'NOTIFY_TYPE',
        ORDER_ID varchar(64) comment 'ORDER_ID',
        REMARK text comment 'REMARK',
        primary key (ANNOUNCE_ID)
    ) comment='NotifyAnnounce';
