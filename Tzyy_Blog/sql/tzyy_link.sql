create table tzyy_link
(
    id          bigint auto_increment
        primary key,
    name        varchar(256)     null,
    logo        varchar(256)     null,
    description varchar(512)     null,
    address     varchar(128)     null comment '网站地址',
    status      char default '2' null comment '审核状态 (0代表审核通过，1代表审核未通过，2代表未审核)',
    create_by   bigint           null,
    create_time datetime         null,
    update_by   bigint           null,
    update_time datetime         null,
    del_flag    int  default 0   null comment '删除标志（0代表未删除，1代表已删除）'
)
    comment '友链';

INSERT INTO tzyy_blog.tzyy_link (id, name, logo, description, address, status, create_by, create_time, update_by, update_time, del_flag) VALUES (1, 'sda', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2016%2F05%2F10%2F146286696706220328.PNG&refer=http%3A%2F%2Fn1.itc.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1646205529&t=f942665181eb9b0685db7a6f59d59975', 'sda', 'https://www.baidu.com', '0', null, '2022-01-13 08:25:47', null, '2022-01-13 08:36:14', 0);
INSERT INTO tzyy_blog.tzyy_link (id, name, logo, description, address, status, create_by, create_time, update_by, update_time, del_flag) VALUES (2, 'sda', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2016%2F05%2F10%2F146286696706220328.PNG&refer=http%3A%2F%2Fn1.itc.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1646205529&t=f942665181eb9b0685db7a6f59d59975', 'dada', 'https://www.qq.com', '0', null, '2022-01-13 09:06:10', null, '2022-01-13 09:07:09', 0);
INSERT INTO tzyy_blog.tzyy_link (id, name, logo, description, address, status, create_by, create_time, update_by, update_time, del_flag) VALUES (3, 'sa', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2016%2F05%2F10%2F146286696706220328.PNG&refer=http%3A%2F%2Fn1.itc.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1646205529&t=f942665181eb9b0685db7a6f59d59975', 'da', 'https://www.taobao.com', '0', null, '2022-01-13 09:23:01', null, '2022-01-13 09:23:01', 0);
