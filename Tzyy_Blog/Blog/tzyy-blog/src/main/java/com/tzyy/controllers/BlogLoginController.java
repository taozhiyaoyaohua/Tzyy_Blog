package com.tzyy.controllers;

import com.tzyy.annotation.SystemLog;
import com.tzyy.enums.AppHttpCodeEnum;
import com.tzyy.exception.SystemException;
import com.tzyy.pojo.User;
import com.tzyy.services.BlogLoginService;
import com.tzyy.tools.ResponseResultUtils;
import io.swagger.annotations.Api;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "登录",description = "登录相关接口")
public class BlogLoginController {
    @Autowired
    private BlogLoginService blogLoginService;
    @PostMapping("/login")
    @SystemLog(businessName = "登录")
    public ResponseResultUtils login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }
    @PostMapping("/logout")
    @SystemLog(businessName = "退出登录")
    public ResponseResultUtils logout(){
        return blogLoginService.logout();
    }
}
