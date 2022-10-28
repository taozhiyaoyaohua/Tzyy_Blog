create table tzyy_user
(
    id          bigint auto_increment comment '主键'
        primary key,
    user_name   varchar(64) default 'NULL' not null comment '用户名',
    nick_name   varchar(64) default 'NULL' not null comment '昵称',
    password    varchar(64) default 'NULL' not null comment '密码',
    type        char        default '0'    null comment '用户类型：0代表普通用户，1代表管理员',
    status      char        default '0'    null comment '账号状态（0正常 1停用）',
    email       varchar(64)                null comment '邮箱',
    phonenumber varchar(32)                null comment '手机号',
    sex         char                       null comment '用户性别（0男，1女，2未知）',
    avatar      varchar(128)               null comment '头像',
    create_by   bigint                     null comment '创建人的用户id',
    create_time datetime                   null comment '创建时间',
    update_by   bigint                     null comment '更新人',
    update_time datetime                   null comment '更新时间',
    del_flag    int         default 0      null comment '删除标志（0代表未删除，1代表已删除）'
)
    comment '用户表';

INSERT INTO tzyy_blog.tzyy_user (id, user_name, nick_name, password, type, status, email, phonenumber, sex, avatar, create_by, create_time, update_by, update_time, del_flag) VALUES (1, 'tzyy', 'tzyy333', '$2a$10$Jnq31rRkNV3RNzXe0REsEOSKaYK8UgVZZqlNlNXqn.JeVcj2NdeZy', '1', '0', '23412332@qq.com', '18888888888', '0', 'https://tzyyblog.oss-cn-hangzhou.aliyuncs.com/2022/10/23/50c6adb3b70345aaa94b1e39dcb4d17f.png', null, '2022-01-05 09:01:56', 1, '2022-01-30 15:37:03', 0);
INSERT INTO tzyy_blog.tzyy_user (id, user_name, nick_name, password, type, status, email, phonenumber, sex, avatar, create_by, create_time, update_by, update_time, del_flag) VALUES (3, 'tzyy2', 'weqe', '$2a$10$ydv3rLkteFnRx9xelQ7elOiVhFvXOooA98xCqk/omh7G94R.K/E3O', '1', '0', null, null, '0', null, null, '2022-01-05 13:28:43', null, '2022-01-05 13:28:43', 0);
INSERT INTO tzyy_blog.tzyy_user (id, user_name, nick_name, password, type, status, email, phonenumber, sex, avatar, create_by, create_time, update_by, update_time, del_flag) VALUES (4, 'tzyy3', 'dsadd', '$2a$10$kY4T3SN7i4muBccZppd2OOkhxMN6yt8tND1sF89hXOaFylhY2T3he', '1', '0', '23412332@qq.com', '19098790742', '0', null, null, null, null, null, 0);
INSERT INTO tzyy_blog.tzyy_user (id, user_name, nick_name, password, type, status, email, phonenumber, sex, avatar, create_by, create_time, update_by, update_time, del_flag) VALUES (5, 'tzyy4', 'tteqe', '', '1', '0', null, '18246845873', '1', null, null, '2022-01-06 03:51:13', null, '2022-01-06 07:00:50', 0);
INSERT INTO tzyy_blog.tzyy_user (id, user_name, nick_name, password, type, status, email, phonenumber, sex, avatar, create_by, create_time, update_by, update_time, del_flag) VALUES (14787164048662, 'weixin', 'weixin', '$2a$10$y3k3fnMZsBNihsVLXWfI8uMNueVXBI08k.LzWYaKsW8CW7xXy18wC', '0', '0', 'weixin@qq.com', null, null, null, -1, '2022-01-30 17:18:44', -1, '2022-01-30 17:18:44', 0);
INSERT INTO tzyy_blog.tzyy_user (id, user_name, nick_name, password, type, status, email, phonenumber, sex, avatar, create_by, create_time, update_by, update_time, del_flag) VALUES (14787164048663, '123', '123123', '$2a$10$Or5gNzJn/q8BsPQO/sdHrOBXz/l9pZvu.20ND2g2iP3jpUhQtNvfC', '0', '0', '2434727371@qq.com', null, null, null, null, null, null, null, 0);
