package com.tzyy.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzyy.pojo.Article;
import com.tzyy.tools.ResponseResultUtils;

public interface ArticleService extends IService<Article> {
    ResponseResultUtils hotArticlesList();

    ResponseResultUtils articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResultUtils getArticleDetail(Long id);

    ResponseResultUtils updateViewCount(Long id);
}
