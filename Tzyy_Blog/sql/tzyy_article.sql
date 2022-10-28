create table tzyy_article
(
    id          bigint auto_increment
        primary key,
    title       varchar(256)       null comment '标题',
    content     longtext           null comment '文章内容',
    summary     varchar(1024)      null comment '文章摘要',
    category_id bigint             null comment '所属分类id',
    thumbnail   varchar(256)       null comment '缩略图',
    is_top      char   default '0' null comment '是否置顶（0否，1是）',
    status      char   default '1' null comment '状态（0已发布，1草稿）',
    view_count  bigint default 0   null comment '访问量',
    is_comment  char   default '1' null comment '是否允许评论 1是，0否',
    create_by   bigint             null,
    create_time datetime           null,
    update_by   bigint             null,
    update_time datetime           null,
    del_flag    int    default 0   null comment '删除标志（0代表未删除，1代表已删除）'
)
    comment '文章表';

INSERT INTO tzyy_blog.tzyy_article (id, title, content, summary, category_id, thumbnail, is_top, status, view_count, is_comment, create_by, create_time, update_by, update_time, del_flag) VALUES (1, 'weq', 'adadaeqe', 'adad', 2, '', '1', '0', 25, '0', null, '2022-01-21 14:58:30', null, null, 0);
INSERT INTO tzyy_blog.tzyy_article (id, title, content, summary, category_id, thumbnail, is_top, status, view_count, is_comment, create_by, create_time, update_by, update_time, del_flag) VALUES (2, '1212', '1212312', '23123', 1, null, '1', '0', 23, '0', null, '2022-10-22 20:39:46', null, null, 0);
INSERT INTO tzyy_blog.tzyy_article (id, title, content, summary, category_id, thumbnail, is_top, status, view_count, is_comment, create_by, create_time, update_by, update_time, del_flag) VALUES (3, 'dad', 'asdasda', 'sadad', 1, '', '1', '0', 36, '0', null, '2022-01-18 14:58:34', null, null, 0);
INSERT INTO tzyy_blog.tzyy_article (id, title, content, summary, category_id, thumbnail, is_top, status, view_count, is_comment, create_by, create_time, update_by, update_time, del_flag) VALUES (6, 'Java高并发编程实战5，异步注解@Async自定义线程池', '一、@Async注解
@Async的作用就是异步处理任务。

在方法上添加@Async，表示此方法是异步方法；
在类上添加@Async，表示类中的所有方法都是异步方法；
使用此注解的类，必须是Spring管理的类；
需要在启动类或配置类中加入@EnableAsync注解，@Async才会生效；
在使用@Async时，如果不指定线程池的名称，也就是不自定义线程池，@Async是有默认线程池的，使用的是Spring默认的线程池SimpleAsyncTaskExecutor。

默认线程池的默认配置如下：

默认核心线程数：8；
最大线程数：Integet.MAX_VALUE；
队列使用LinkedBlockingQueue；
容量是：Integet.MAX_VALUE；
空闲线程保留时间：60s；
线程池拒绝策略：AbortPolicy；', '1', 1, null, '1', '0', 12, '0', null, '2022-10-20 12:44:00', null, null, 0);
