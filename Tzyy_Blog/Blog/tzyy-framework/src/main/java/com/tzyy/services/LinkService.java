package com.tzyy.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzyy.pojo.Link;
import com.tzyy.tools.ResponseResultUtils;

/**
 * 友链(Link)表服务接口
 *
 * @author tzyy
 * @since 2022-10-20 14:34:57
 */
public interface LinkService extends IService<Link> {

    ResponseResultUtils getAllLink();
}

