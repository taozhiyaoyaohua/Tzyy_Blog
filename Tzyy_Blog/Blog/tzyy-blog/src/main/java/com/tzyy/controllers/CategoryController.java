package com.tzyy.controllers;

import com.tzyy.annotation.SystemLog;
import com.tzyy.services.CategoryService;
import com.tzyy.tools.ResponseResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "文章分类",description = "文章分类相关接口")
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/getCategoryList")
    @SystemLog(businessName = "获取文章分类列表")
    public ResponseResultUtils getCategoryList(){
        return categoryService.getCategoryList();
    }
}