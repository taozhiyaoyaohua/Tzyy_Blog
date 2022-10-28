package com.tzyy.controllers;

import com.tzyy.annotation.SystemLog;
import com.tzyy.services.ArticleService;
import com.tzyy.tools.ResponseResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "文章",description = "文章相关接口")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/articleList")
    @SystemLog(businessName = "获取文章列表")
    public ResponseResultUtils articleList(Integer pageNum,Integer pageSize,Long categoryId){return articleService.articleList(pageNum, pageSize, categoryId);}
    @GetMapping("/hotArticleList")
    @SystemLog(businessName = "获取热门文章列表")
    public ResponseResultUtils hotArticleList(){
        return articleService.hotArticlesList();
    }
    @GetMapping("/{id}")
    @SystemLog(businessName = "查看文章详情")
    public ResponseResultUtils getArticleDetail(@PathVariable("id") Long id){
        return articleService.getArticleDetail(id);
    }
    @PutMapping("/updateViewCount/{id}")
    @SystemLog(businessName = "更新浏览次数")
    public ResponseResultUtils updateViewCount(@PathVariable("id") Long id){
        return articleService.updateViewCount(id);
    }
}