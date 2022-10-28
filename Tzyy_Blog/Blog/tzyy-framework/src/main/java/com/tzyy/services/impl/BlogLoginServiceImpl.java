package com.tzyy.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzyy.constants.RedisConstants;
import com.tzyy.mappers.UserMapper;
import com.tzyy.pojo.LoginUser;
import com.tzyy.pojo.User;
import com.tzyy.services.BlogLoginService;
import com.tzyy.tools.BeanCopyUtils;
import com.tzyy.tools.JwtUtil;
import com.tzyy.tools.RedisCache;
import com.tzyy.tools.ResponseResultUtils;
import com.tzyy.vo.BlogUserLoginVo;
import com.tzyy.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service("BlogLoginService")
public class BlogLoginServiceImpl extends ServiceImpl<UserMapper, User> implements BlogLoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResultUtils login(User user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        LoginUser login = (LoginUser) authenticate.getPrincipal();
        String userId = login.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        redisCache.setCacheObject(RedisConstants.USER_FIX+userId,login);
        UserInfoVo info = BeanCopyUtils.copyBean(login.getUser(),UserInfoVo.class);
        BlogUserLoginVo blogUser = new BlogUserLoginVo(jwt,info);
        return ResponseResultUtils.okResult(blogUser);
    }

    @Override
    public ResponseResultUtils logout() {
        //获取token 解析获取userid
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        //获取userid
        Long userId = loginUser.getUser().getId();
        //删除redis中的用户信息
        redisCache.deleteObject(RedisConstants.USER_FIX +userId);
        return ResponseResultUtils.okResult();
    }
}
