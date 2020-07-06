create table if not exists url_pool
(
    id            int          not null auto_increment,
    url           varchar(500) not null,
    status        varchar(200) not null,
    create_time   timestamp    not null,
    modified_time timestamp    not null,
    ext_info      varchar(3000),
    primary key (id)
)