package com.tzyy.controllers;

import com.tzyy.annotation.SystemLog;
import com.tzyy.pojo.User;
import com.tzyy.services.UserService;
import com.tzyy.tools.ResponseResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Api(tags = "用户",description = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/userInfo")
    @SystemLog(businessName = "查看个人信息")
    public ResponseResultUtils userInfo(){
        return userService.userInfo();
    }
    @PutMapping("/userInfo")
    @SystemLog(businessName = "更新个人信息")
    public ResponseResultUtils updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }
    @PostMapping("/register")
    @SystemLog(businessName = "注册")
    public ResponseResultUtils register(@RequestBody User user){
        return userService.register(user);
    }
}
