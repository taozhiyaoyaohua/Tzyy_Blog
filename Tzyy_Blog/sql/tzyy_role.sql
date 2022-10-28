create table tzyy_role
(
    id          bigint auto_increment comment '角色ID'
        primary key,
    role_name   varchar(30)      not null comment '角色名称',
    role_key    varchar(100)     not null comment '角色权限字符串',
    role_sort   int              not null comment '显示顺序',
    status      char             not null comment '角色状态（0正常 1停用）',
    del_flag    char default '0' null comment '删除标志（0代表存在 1代表删除）',
    create_by   bigint           null comment '创建者',
    create_time datetime         null comment '创建时间',
    update_by   bigint           null comment '更新者',
    update_time datetime         null comment '更新时间',
    remark      varchar(500)     null comment '备注'
)
    comment '角色信息表' charset = utf8;

INSERT INTO tzyy_blog.tzyy_role (id, role_name, role_key, role_sort, status, del_flag, create_by, create_time, update_by, update_time, remark) VALUES (1, '超级管理员', 'admin', 1, '0', '0', 0, '2021-11-12 10:46:19', 0, null, '超级管理员');
INSERT INTO tzyy_blog.tzyy_role (id, role_name, role_key, role_sort, status, del_flag, create_by, create_time, update_by, update_time, remark) VALUES (2, '普通角色', 'common', 2, '0', '0', 0, '2021-11-12 10:46:19', 0, '2022-01-01 22:32:58', '普通角色');
INSERT INTO tzyy_blog.tzyy_role (id, role_name, role_key, role_sort, status, del_flag, create_by, create_time, update_by, update_time, remark) VALUES (11, '嘎嘎嘎', 'aggag', 5, '0', '0', null, '2022-01-06 14:07:40', null, '2022-01-07 03:48:48', '嘎嘎嘎');
INSERT INTO tzyy_blog.tzyy_role (id, role_name, role_key, role_sort, status, del_flag, create_by, create_time, update_by, update_time, remark) VALUES (12, '友链审核员', 'link', 1, '0', '0', null, '2022-01-16 06:49:30', null, '2022-01-16 08:05:09', null);
