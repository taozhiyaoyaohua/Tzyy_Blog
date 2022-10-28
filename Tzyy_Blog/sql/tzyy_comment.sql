create table tzyy_comment
(
    id                 bigint auto_increment
        primary key,
    type               char   default '0' null comment '评论类型（0代表文章评论，1代表友链评论）',
    article_id         bigint             null comment '文章id',
    root_id            bigint default -1  null comment '根评论id',
    content            varchar(512)       null comment '评论内容',
    to_comment_user_id bigint default -1  null comment '所回复的目标评论的userid',
    to_comment_id      bigint default -1  null comment '回复目标评论id',
    create_by          bigint             null,
    create_time        datetime           null,
    update_by          bigint             null,
    update_time        datetime           null,
    del_flag           int    default 0   null comment '删除标志（0代表未删除，1代表已删除）'
)
    comment '评论表';

INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (1, '0', 1, -1, 'asS', -1, -1, 1, '2022-01-29 07:59:22', 1, '2022-01-29 07:59:22', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (2, '0', 1, -1, '[哈哈]SDAS', -1, -1, 1, '2022-01-29 08:01:24', 1, '2022-01-29 08:01:24', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (3, '0', 1, -1, '是大多数', -1, -1, 1, '2022-01-29 16:07:24', 1, '2022-01-29 16:07:24', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (4, '0', 1, -1, '撒大声地', -1, -1, 1, '2022-01-29 16:12:09', 1, '2022-01-29 16:12:09', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (5, '0', 1, -1, '你再说什么', -1, -1, 1, '2022-01-29 18:19:56', 1, '2022-01-29 18:19:56', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (6, '0', 1, -1, 'hffd', -1, -1, 1, '2022-01-29 22:13:52', 1, '2022-01-29 22:13:52', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (9, '0', 1, 2, '你说什么', 1, 2, 1, '2022-01-29 22:18:40', 1, '2022-01-29 22:18:40', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (10, '0', 1, 2, '哈哈哈哈[哈哈]', 1, 9, 1, '2022-01-29 22:29:15', 1, '2022-01-29 22:29:15', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (11, '0', 1, 2, 'we全文', 1, 10, 3, '2022-01-29 22:29:55', 1, '2022-01-29 22:29:55', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (12, '0', 1, -1, '王企鹅', -1, -1, 1, '2022-01-29 22:30:20', 1, '2022-01-29 22:30:20', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (13, '0', 1, -1, '什么阿是', -1, -1, 1, '2022-01-29 22:30:56', 1, '2022-01-29 22:30:56', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (14, '0', 1, -1, '新平顶山', -1, -1, 1, '2022-01-29 22:32:51', 1, '2022-01-29 22:32:51', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (15, '0', 1, -1, '2222', -1, -1, 1, '2022-01-29 22:34:38', 1, '2022-01-29 22:34:38', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (16, '0', 1, 2, '3333', 1, 11, 1, '2022-01-29 22:34:47', 1, '2022-01-29 22:34:47', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (17, '0', 1, 2, '回复weqedadsd', 3, 11, 1, '2022-01-29 22:38:00', 1, '2022-01-29 22:38:00', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (18, '0', 1, -1, 'sdasd', -1, -1, 1, '2022-01-29 23:18:19', 1, '2022-01-29 23:18:19', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (19, '0', 1, -1, '111', -1, -1, 1, '2022-01-29 23:22:23', 1, '2022-01-29 23:22:23', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (20, '0', 1, 1, '你说啥？', 1, 1, 1, '2022-01-30 10:06:21', 1, '2022-01-30 10:06:21', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (21, '0', 1, -1, '友链添加个呗', -1, -1, 1, '2022-01-30 10:06:50', 1, '2022-01-30 10:06:50', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (22, 'I', null, -1, '友链评论2', -1, -1, 1, '2022-01-30 10:08:28', 1, '2022-01-30 10:08:28', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (23, 'I', null, 22, '回复友链评论3', 1, 22, 1, '2022-01-30 10:08:50', 1, '2022-01-30 10:08:50', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (24, 'I', null, -1, '友链评论4444', -1, -1, 1, '2022-01-30 10:09:03', 1, '2022-01-30 10:09:03', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (25, 'I', null, 22, '收到的', 1, 22, 1, '2022-01-30 10:13:28', 1, '2022-01-30 10:13:28', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (26, '0', 1, -1, 'sda', -1, -1, 1, '2022-01-30 10:39:05', 1, '2022-01-30 10:39:05', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (27, '0', 1, 1, '说你咋地', 1, 20, 14787164048662, '2022-01-30 17:19:30', 14787164048662, '2022-01-30 17:19:30', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (28, '0', 1, 1, 'sdad', 1, 1, 14787164048662, '2022-01-31 11:11:20', 14787164048662, '2022-01-31 11:11:20', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (29, '0', 1, -1, '你说是的ad', -1, -1, 14787164048662, '2022-01-31 14:10:11', 14787164048662, '2022-01-31 14:10:11', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (30, '0', 1, 1, '撒大声地', 1, 1, 14787164048662, '2022-01-31 20:19:18', 14787164048662, '2022-01-31 20:19:18', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (36, '0', 1, -1, '1231', -1, -1, 1, '2022-10-22 21:39:52', 1, '2022-10-22 21:39:52', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (37, '0', 1, -1, '312312', -1, -1, 1, '2022-10-22 21:39:53', 1, '2022-10-22 21:39:53', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (38, '0', 1, -1, '12123', -1, -1, 1, '2022-10-22 21:39:54', 1, '2022-10-22 21:39:54', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (39, '0', 1, -1, '3123', -1, -1, 1, '2022-10-22 21:39:55', 1, '2022-10-22 21:39:55', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (40, '0', 1, -1, '213123', -1, -1, 1, '2022-10-22 21:43:59', 1, '2022-10-22 21:43:59', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (41, '0', 1, -1, '1', -1, -1, 1, '2022-10-22 21:47:14', 1, '2022-10-22 21:47:14', 0);
INSERT INTO tzyy_blog.tzyy_comment (id, type, article_id, root_id, content, to_comment_user_id, to_comment_id, create_by, create_time, update_by, update_time, del_flag) VALUES (45, '0', 2, -1, '1', -1, -1, 1, '2022-10-22 22:06:23', 1, '2022-10-22 22:06:23', 0);
