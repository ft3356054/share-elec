
    drop table if exists NOTIFY_ANNOUNCE_USER;

    create table NOTIFY_ANNOUNCE_USER (
        ID varchar(64) not null comment 'ID',
        ANNOUNCE_USER_ID varchar(64) comment 'ANNOUNCE_USER_ID',
        ANNOUNCE_ID varchar(64) comment 'ANNOUNCE_ID',
        RECIPIENT_TYPE varchar(2) comment 'RECIPIENT_TYPE',
        STATE varchar(2) comment 'STATE',
        CREATE_TIME datetime comment 'CREATE_TIME',
        READ_TIME datetime comment 'READ_TIME',
        REMARK text comment 'REMARK',
        primary key (ID)
    ) comment='NotifyAnnounceUser';
