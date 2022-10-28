package com.tzyy.handler.execption;

import com.tzyy.enums.AppHttpCodeEnum;
import com.tzyy.exception.SystemException;
import com.tzyy.tools.ResponseResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExecptionHandler {
    @ExceptionHandler(SystemException.class)
    public ResponseResultUtils systemExecptionHandler(SystemException exception){
        log.error("出现了异常！：",exception);
        return ResponseResultUtils.errorResult(exception.getCode(),exception.getMsg());
    }
    @ExceptionHandler(Exception.class)
    public ResponseResultUtils execptionHandler(Exception exception){
        log.error("出现了异常！：",exception);
        return ResponseResultUtils.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(),AppHttpCodeEnum.SYSTEM_ERROR.getMsg());
    }
}
