package com.tzyy.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzyy.constants.RedisConstants;
import com.tzyy.mappers.UserMapper;
import com.tzyy.pojo.LoginUser;
import com.tzyy.pojo.User;
import com.tzyy.services.LoginService;
import com.tzyy.tools.BeanCopyUtils;
import com.tzyy.tools.JwtUtil;
import com.tzyy.tools.RedisCache;
import com.tzyy.tools.ResponseResultUtils;
import com.tzyy.vo.BlogUserLoginVo;
import com.tzyy.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@Service("LoginService")
public class SystemLoginServiceImpl  extends ServiceImpl<UserMapper, User> implements LoginService {
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
        redisCache.setCacheObject(RedisConstants.ADMIN_USER_FIX+userId,login);
        Map<String,String> map = new HashMap<String,String>();
        map.put("token",jwt);
        return ResponseResultUtils.okResult(map);
    }

//    @Override
//    public ResponseResultUtils logout() {
//        //获取token 解析获取userid
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
//        //获取userid
//        Long userId = loginUser.getUser().getId();
//        //删除redis中的用户信息
//        redisCache.deleteObject(RedisConstants.USER_FIX +userId);
//        return ResponseResultUtils.okResult();
//    }
}
