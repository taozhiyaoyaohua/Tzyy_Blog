create table tzyy_article_tag
(
    article_id bigint auto_increment comment '文章id',
    tag_id     bigint default 0 not null comment '标签id',
    primary key (article_id, tag_id)
)
    comment '文章标签关联表';

INSERT INTO tzyy_blog.tzyy_article_tag (article_id, tag_id) VALUES (1, 4);
INSERT INTO tzyy_blog.tzyy_article_tag (article_id, tag_id) VALUES (2, 1);
INSERT INTO tzyy_blog.tzyy_article_tag (article_id, tag_id) VALUES (2, 4);
INSERT INTO tzyy_blog.tzyy_article_tag (article_id, tag_id) VALUES (3, 4);
INSERT INTO tzyy_blog.tzyy_article_tag (article_id, tag_id) VALUES (3, 5);
