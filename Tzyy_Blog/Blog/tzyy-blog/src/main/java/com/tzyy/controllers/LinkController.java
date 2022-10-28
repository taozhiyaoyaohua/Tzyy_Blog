package com.tzyy.controllers;

import com.tzyy.annotation.SystemLog;
import com.tzyy.services.LinkService;
import com.tzyy.tools.ResponseResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "友链",description = "友链相关接口")
@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;
    @GetMapping("getAllLink")
    @SystemLog(businessName = "获取友链列表")
    public ResponseResultUtils getAllLink(){
        return linkService.getAllLink();
    }
}
