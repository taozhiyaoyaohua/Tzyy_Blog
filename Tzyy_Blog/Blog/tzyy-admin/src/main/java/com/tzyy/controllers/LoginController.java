package com.tzyy.controllers;

import com.tzyy.annotation.SystemLog;
import com.tzyy.enums.AppHttpCodeEnum;
import com.tzyy.exception.SystemException;
import com.tzyy.pojo.User;
import com.tzyy.services.LoginService;
import com.tzyy.tools.ResponseResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/user/login")
    @SystemLog(businessName = "登录")
    public ResponseResultUtils login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }
    @PostMapping("/user/logout")
    @SystemLog(businessName = "退出登录")
    public ResponseResultUtils logout(){
        return null;
    }
    @GetMapping("/getInfo")
    public ResponseResultUtils getInfo(){
        return null;
    }
}
