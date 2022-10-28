package com.tzyy.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzyy.constants.RedisConstants;
import com.tzyy.constants.SystemConstants;
import com.tzyy.mappers.ArticleMapper;
import com.tzyy.pojo.Category;
import com.tzyy.services.ArticleService;
import com.tzyy.pojo.Article;
import com.tzyy.services.CategoryService;
import com.tzyy.tools.BeanCopyUtils;
import com.tzyy.tools.RedisCache;
import com.tzyy.tools.ResponseResultUtils;
import com.tzyy.vo.ArticleDetailVo;
import com.tzyy.vo.ArticleListVo;
import com.tzyy.vo.HotArticleVo;
import com.tzyy.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("ArticleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResultUtils hotArticlesList() {
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //正式文章
        lambdaQueryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        //降序排列
        lambdaQueryWrapper.orderByDesc(Article::getViewCount);
        //十条数据，分页
        Page<Article> page = new Page<>(1,10);
        Page<Article> articlePage = page(page, lambdaQueryWrapper);
        List<Article> articles = articlePage.getRecords();
        List<HotArticleVo> hotArticleVoList = BeanCopyUtils.copyBeanList(articles,HotArticleVo.class);
        hotArticleVoList.stream().map(new Function<HotArticleVo, HotArticleVo>() {
            @Override
            public HotArticleVo apply(HotArticleVo hotArticleVo) {
                hotArticleVo.setViewCount(Long.valueOf(searchViewCountFormRedis(hotArticleVo.getId())));
                return hotArticleVo;
            }
        }).collect(Collectors.toList());
        return ResponseResultUtils.okResult(hotArticleVoList);
    }


    @Override
    public ResponseResultUtils articleList(Integer pageNum, Integer pageSize, Long categoryId) {

        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //如果有categoryId就要查询和categoryId相同的文章
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);
        //正式发布的
        lambdaQueryWrapper.eq(Article::getStatus,SystemConstants.ARTICLE_STATUS_NORMAL);
        //对isTop进行降序
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,lambdaQueryWrapper);
        List<Article> articles = page.getRecords();
        List<Article> collect = articles.stream().map(new Function<Article, Article>() {

            @Override
            public Article apply(Article article) {
                article.setCategoryName(categoryService.getById(article.getCategoryId()).getName());
                return article;
            }
        }).collect(Collectors.toList());

        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(collect, ArticleListVo.class);
        articleListVos.stream().map(new Function<ArticleListVo, ArticleListVo>() {
            @Override
            public ArticleListVo apply(ArticleListVo articleListVo) {
                articleListVo.setViewCount(Long.valueOf(searchViewCountFormRedis(articleListVo.getId())));
                return articleListVo;
            }
        }).collect(Collectors.toList());
        PageVo vo = new PageVo(articleListVos,page.getTotal());
        return ResponseResultUtils.okResult(vo);
    }

    @Override
    public ResponseResultUtils getArticleDetail(Long id) {
        Article article = getById(id);
        if(article!=null) {
            article.setCategoryName(categoryService.getById(article.getCategoryId()).getName());
        }
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);
        articleDetailVo.setViewCount(Long.valueOf(searchViewCountFormRedis(articleDetailVo.getId())));
        return ResponseResultUtils.okResult(articleDetailVo);
    }

    @Override
    public ResponseResultUtils updateViewCount(Long id) {
        redisCache.incrementCacheMapvalue(RedisConstants.VIEW_COUNT_FIX,id.toString(),1);
        return ResponseResultUtils.okResult();
    }
    private Integer searchViewCountFormRedis(Long id) {
         return redisCache.getCacheMapValue(RedisConstants.VIEW_COUNT_FIX, id.toString());
    }

}