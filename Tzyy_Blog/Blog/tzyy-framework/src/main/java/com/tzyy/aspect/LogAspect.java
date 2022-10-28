package com.tzyy.aspect;

import com.alibaba.fastjson.JSON;
import com.tzyy.annotation.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class LogAspect {
    @Pointcut("@annotation(com.tzyy.annotation.SystemLog)")
    public void pc(){

    }
    @Around("pc()")
    public Object printLog(ProceedingJoinPoint point) throws Throwable {
        Object proceed;
        try {
            handleBefore(point);
            proceed = point.proceed();
            handleAfter(proceed);
        }finally {
            log.info("=======End=======" + System.lineSeparator());
        }
        return proceed;
    }

    private void handleAfter(Object proceed) {
        // 打印出参
        log.info("Response       : {}", JSON.toJSONString(proceed));
    }

    private void handleBefore(ProceedingJoinPoint point) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        SystemLog systemLog = getSystemLog(point);
        log.info("=======Start=======");
        // 打印请求 URL
        log.info("URL            : {}",request.getRequestURL());
        // 打印描述信息
        log.info("BusinessName   : {}", systemLog.businessName());
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", point.getSignature().getDeclaringTypeName(),((MethodSignature) point.getSignature()).getName());
        // 打印请求的 IP
        log.info("IP             : {}",request.getRemoteUser());
        // 打印请求入参
        log.info("Request Args   : {}", JSON.toJSONString(point.getArgs()));
    }

    private SystemLog getSystemLog(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        return signature.getMethod().getAnnotation(SystemLog.class);
    }
}
