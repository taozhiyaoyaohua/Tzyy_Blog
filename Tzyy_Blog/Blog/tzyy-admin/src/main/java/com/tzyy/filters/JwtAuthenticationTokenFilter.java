package com.tzyy.filters;

import com.alibaba.fastjson.JSON;
import com.tzyy.constants.RedisConstants;
import com.tzyy.enums.AppHttpCodeEnum;
import com.tzyy.pojo.LoginUser;
import com.tzyy.tools.JwtUtil;
import com.tzyy.tools.RedisCache;
import com.tzyy.tools.ResponseResultUtils;
import com.tzyy.tools.WebUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    RedisCache redisCache;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("token");
        if(!StringUtils.hasText(token)){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseResultUtils responseResultUtils = ResponseResultUtils.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(httpServletResponse,JSON.toJSONString(responseResultUtils));
            return;
        }
        String userId = claims.getSubject();
        LoginUser loginUser = redisCache.getCacheObject(RedisConstants.ADMIN_USER_FIX + userId);
        if(Objects.isNull(loginUser)){
            ResponseResultUtils responseResultUtils = ResponseResultUtils.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(httpServletResponse,JSON.toJSONString(responseResultUtils));
            return;
        }
        UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(loginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(loginToken);
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
