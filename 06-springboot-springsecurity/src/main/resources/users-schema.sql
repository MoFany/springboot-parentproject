-- 用户表，存在时先删除后创建
drop table if exists users;

create table users
(
    id       int primary key auto_increment comment '主键id',
    username varchar(20) unique not null comment '用户名',
    password char(10)           not null comment '密码'
)auto_increment=1;