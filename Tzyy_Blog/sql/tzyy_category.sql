create table tzyy_category
(
    id          bigint auto_increment
        primary key,
    name        varchar(128)       null comment '分类名',
    pid         bigint default -1  null comment '父分类id，如果没有父分类为-1',
    description varchar(512)       null comment '描述',
    status      char   default '0' null comment '状态0:正常,1禁用',
    create_by   bigint             null,
    create_time datetime           null,
    update_by   bigint             null,
    update_time datetime           null,
    del_flag    int    default 0   null comment '删除标志（0代表未删除，1代表已删除）'
)
    comment '分类表';

INSERT INTO tzyy_blog.tzyy_category (id, name, pid, description, status, create_by, create_time, update_by, update_time, del_flag) VALUES (1, 'java', -1, 'wsd', '0', null, null, null, null, 0);
INSERT INTO tzyy_blog.tzyy_category (id, name, pid, description, status, create_by, create_time, update_by, update_time, del_flag) VALUES (2, 'C++', -1, 'wsd', '0', null, null, null, null, 0);
