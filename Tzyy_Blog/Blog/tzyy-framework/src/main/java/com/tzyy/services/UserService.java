package com.tzyy.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzyy.pojo.User;
import com.tzyy.tools.ResponseResultUtils;

/**
 * 用户表(User)表服务接口
 *
 * @author tzyy
 * @since 2022-10-20 16:16:38
 */
public interface UserService extends IService<User> {

    ResponseResultUtils userInfo();

    ResponseResultUtils updateUserInfo(User user);

    ResponseResultUtils register(User user);
}

