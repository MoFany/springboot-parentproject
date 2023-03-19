-- 持久登录表，存在时先删除后创建
drop table if exists persistent_logins;
create table persistent_logins
(
    username  varchar(64) not null,
    series    varchar(64) not null,
    token     varchar(64) not null,
    last_used timestamp   not null default current_timestamp on update current_timestamp,
    primary key (series)
);