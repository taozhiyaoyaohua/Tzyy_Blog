package com.tzyy.job;

import com.tzyy.constants.RedisConstants;
import com.tzyy.pojo.Article;
import com.tzyy.services.ArticleService;
import com.tzyy.tools.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class UpdateViewCount {
    @Autowired
    RedisCache redisCache;
    @Autowired
    ArticleService articleService;
    @Scheduled(cron = "0/30 * * * * ?")
    public void updateViewCount(){
        Map<String,Integer> map = redisCache.getCacheMap(RedisConstants.VIEW_COUNT_FIX);
        List<Article> collect = map.entrySet().stream().map(entry -> new Article(Long.valueOf(entry.getKey()), entry.getValue().longValue())).collect(Collectors.toList());
        articleService.updateBatchById(collect);
    }
}
