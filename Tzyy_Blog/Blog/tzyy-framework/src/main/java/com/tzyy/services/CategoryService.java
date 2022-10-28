package com.tzyy.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzyy.pojo.Category;
import com.tzyy.tools.ResponseResultUtils;

/**
 * 分类表(Category)表服务接口
 *
 * @author tzyy
 * @since 2022-10-18 22:33:42
 */
public interface CategoryService extends IService<Category> {

    ResponseResultUtils getCategoryList();

}

