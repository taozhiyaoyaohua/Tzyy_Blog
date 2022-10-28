create table tzyy_tag
(
    id          bigint auto_increment
        primary key,
    name        varchar(128)  null comment '标签名',
    create_by   bigint        null,
    create_time datetime      null,
    update_by   bigint        null,
    update_time datetime      null,
    del_flag    int default 0 null comment '删除标志（0代表未删除，1代表已删除）',
    remark      varchar(500)  null comment '备注'
)
    comment '标签';

INSERT INTO tzyy_blog.tzyy_tag (id, name, create_by, create_time, update_by, update_time, del_flag, remark) VALUES (1, 'Mybatis', null, null, null, '2022-01-11 09:20:50', 0, 'weqwe');
INSERT INTO tzyy_blog.tzyy_tag (id, name, create_by, create_time, update_by, update_time, del_flag, remark) VALUES (2, 'asdas', null, '2022-01-11 09:20:55', null, '2022-01-11 09:20:55', 1, 'weqw');
INSERT INTO tzyy_blog.tzyy_tag (id, name, create_by, create_time, update_by, update_time, del_flag, remark) VALUES (3, 'weqw', null, '2022-01-11 09:21:07', null, '2022-01-11 09:21:07', 1, 'qweqwe');
INSERT INTO tzyy_blog.tzyy_tag (id, name, create_by, create_time, update_by, update_time, del_flag, remark) VALUES (4, 'Java', null, '2022-01-13 15:22:43', null, '2022-01-13 15:22:43', 0, 'sdad');
INSERT INTO tzyy_blog.tzyy_tag (id, name, create_by, create_time, update_by, update_time, del_flag, remark) VALUES (5, 'WAD', null, '2022-01-13 15:22:47', null, '2022-01-13 15:22:47', 0, 'ASDAD');
