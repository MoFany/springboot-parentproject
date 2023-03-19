-- 用户表有数据时先清空数据后插入数据
delete
from users;

insert into users
values (null, 'user1', '123456'),
       (null, 'user2', '123456'),
       (null, 'user3', '123456'),
       (null, 'user4', '123456'),
       (null, 'user5', '123456');