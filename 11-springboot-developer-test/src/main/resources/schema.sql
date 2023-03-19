# 先删除外键表才能删其它表
drop table if exists relation;
# 然后删除非外键表
drop table if exists event_manager;
drop table if exists work_order_manager;

# 事件管理表
create table event_manager
(
    id            int primary key comment '序号' auto_increment,
    event_name    varchar(50) not null comment '事件名称',
    event_address varchar(80) not null comment '事件地址',
    create_date   DATE    not null comment '创建日期',
    /*执行状态：-1为未执行，0为正在执行，1为执行完成*/
    start_status  int         not null check ( start_status = -1 or start_status = 0 or start_status = 1) comment '执行状态'
) auto_increment = 1;

# 工单表
create table work_order_manager
(
    id                 int primary key comment '序号' auto_increment,
    work_order_number  varchar(30) not null unique comment '工单号',
    work_order_name    varchar(50) not null comment '事件名称',
    work_order_address varchar(80) not null comment '事件地址',
    min                int         not null check ( min > 0 ) comment '耗时',
    /*工单状态：1为已处理，0为处理中*/
    work_order_status  int         not null check ( work_order_status = 1 or work_order_status = 0 ) comment '工单状态'
) auto_increment = 1;

# 关系表 事件与工单属于，一对多关系
create table relation
(
    id            int primary key comment '索引' auto_increment,
    event_id      int not null comment '事件id',
    work_order_id int not null comment '工单id',
    constraint eventId foreign key (event_id) references event_manager (id),
    constraint workOrderId foreign key (work_order_id) references work_order_manager (id)
) auto_increment = 1;


