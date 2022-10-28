package com.tzyy.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzyy.pojo.User;
import com.tzyy.tools.ResponseResultUtils;

public interface BlogLoginService extends IService<User> {
    ResponseResultUtils login(User user);

    ResponseResultUtils logout();
}
