package com.tzyy.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzyy.constants.SystemConstants;
import com.tzyy.mappers.CategoryMapper;
import com.tzyy.pojo.Article;
import com.tzyy.pojo.Category;
import com.tzyy.services.ArticleService;
import com.tzyy.services.CategoryService;
import com.tzyy.tools.BeanCopyUtils;
import com.tzyy.tools.ResponseResultUtils;
import com.tzyy.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author tzyy
 * @since 2022-10-18 22:36:29
 */
@Service("CategoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private ArticleService articleService;
    @Override
    public ResponseResultUtils getCategoryList() {
        LambdaQueryWrapper<Article> articleQueryWrapper = new LambdaQueryWrapper<>();
        //有效的文章
        articleQueryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articleList = articleService.list(articleQueryWrapper);
        //类别id去重
        Set<Long> categoryId = articleList.stream().map(article -> article.getCategoryId()).collect(Collectors.toSet());
        //根据类别id查找拥有有效文章的种类
        List<Category> categories = listByIds(categoryId);
        List<Category> categoryList = categories.stream().filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus())).collect(Collectors.toList());
        //封装vo
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categoryList, CategoryVo.class);
        return ResponseResultUtils.okResult(categoryVos);
    }
}

