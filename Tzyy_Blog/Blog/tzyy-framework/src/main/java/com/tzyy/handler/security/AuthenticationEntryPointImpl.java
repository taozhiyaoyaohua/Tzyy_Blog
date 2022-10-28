package com.tzyy.handler.security;

import com.alibaba.fastjson.JSON;
import com.tzyy.enums.AppHttpCodeEnum;
import com.tzyy.tools.ResponseResultUtils;
import com.tzyy.tools.WebUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        e.printStackTrace();
        ResponseResultUtils responseResultUtils = null;
        if(e instanceof BadCredentialsException){
            responseResultUtils = ResponseResultUtils.errorResult(AppHttpCodeEnum.LOGIN_ERROR.getCode(), e.getMessage());
        } else if(e instanceof InsufficientAuthenticationException){
            responseResultUtils = ResponseResultUtils.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        } else {
            responseResultUtils = ResponseResultUtils.errorResult(AppHttpCodeEnum.SYSTEM_ERROR,"认证或授权失败");
        }
        WebUtils.renderString(httpServletResponse, JSON.toJSONString(responseResultUtils));
    }
}
