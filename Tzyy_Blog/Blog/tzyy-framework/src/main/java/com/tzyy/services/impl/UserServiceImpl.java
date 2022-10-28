package com.tzyy.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzyy.enums.AppHttpCodeEnum;
import com.tzyy.exception.SystemException;
import com.tzyy.mappers.UserMapper;
import com.tzyy.pojo.LoginUser;
import com.tzyy.pojo.User;
import com.tzyy.services.UserService;
import com.tzyy.tools.BeanCopyUtils;
import com.tzyy.tools.ResponseResultUtils;
import com.tzyy.tools.SecurityUtils;
import com.tzyy.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 用户表(User)表服务实现类
 *
 * @author tzyy
 * @since 2022-10-20 16:16:38
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseResultUtils userInfo() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
//        User user = loginUser.getUser();
        //获取当前用户id
        Long userId = SecurityUtils.getUserId();
        //根据用户id查询用户信息
        User user = getById(userId);
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
        return ResponseResultUtils.okResult(userInfoVo);
    }

    @Override
    public ResponseResultUtils updateUserInfo(User user) {
        updateById(user);
        return ResponseResultUtils.okResult();
    }

    @Override
    public ResponseResultUtils register(User user) {
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getEmail())){
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getPassword())){
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        if(userNameExist(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if(nickNameExist(user.getNickName())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        String encodePassWord = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassWord);
        save(user);
        return ResponseResultUtils.okResult();
    }

    private boolean nickNameExist(String nickName) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getNickName,nickName);
        return count(lambdaQueryWrapper)>0;
    }

    private boolean userNameExist(String userName) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserName,userName);
        return count(lambdaQueryWrapper)>0;
    }
}

