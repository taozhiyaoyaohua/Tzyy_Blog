package com.tzyy.runner;

import com.tzyy.constants.RedisConstants;
import com.tzyy.pojo.Article;
import com.tzyy.services.ArticleService;
import com.tzyy.tools.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ViewCountRunner implements CommandLineRunner {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private RedisCache redisCache;
    @Override
    public void run(String... args) throws Exception {
        //查询博客信息
        List<Article> list = articleService.list();
        Map<String, Integer> viewCountMap = list.stream().collect(Collectors.toMap(article1 -> article1.getId().toString(),
                article -> article.getViewCount().intValue()));
        //储存到redis中
        redisCache.setCacheMap(RedisConstants.VIEW_COUNT_FIX,viewCountMap);
    }
}
