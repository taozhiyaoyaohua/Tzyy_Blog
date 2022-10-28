create table tzyy_user_role
(
    user_id bigint not null comment '用户ID',
    role_id bigint not null comment '角色ID',
    primary key (user_id, role_id)
)
    comment '用户和角色关联表' charset = utf8;

INSERT INTO tzyy_blog.tzyy_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tzyy_blog.tzyy_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tzyy_blog.tzyy_user_role (user_id, role_id) VALUES (5, 2);
INSERT INTO tzyy_blog.tzyy_user_role (user_id, role_id) VALUES (6, 12);
