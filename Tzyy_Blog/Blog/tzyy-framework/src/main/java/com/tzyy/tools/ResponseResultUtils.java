package com.tzyy.tools;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tzyy.enums.AppHttpCodeEnum;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResultUtils<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public ResponseResultUtils() {
        this.code = AppHttpCodeEnum.SUCCESS.getCode();
        this.msg = AppHttpCodeEnum.SUCCESS.getMsg();
    }

    public ResponseResultUtils(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResultUtils(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResultUtils(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseResultUtils errorResult(int code, String msg) {
        ResponseResultUtils result = new ResponseResultUtils();
        return result.error(code, msg);
    }
    public static ResponseResultUtils okResult() {
        ResponseResultUtils result = new ResponseResultUtils();
        return result;
    }
    public static ResponseResultUtils okResult(int code, String msg) {
        ResponseResultUtils result = new ResponseResultUtils();
        return result.ok(code, null, msg);
    }

    public static ResponseResultUtils okResult(Object data) {
        ResponseResultUtils result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS, AppHttpCodeEnum.SUCCESS.getMsg());
        if(data!=null) {
            result.setData(data);
        }
        return result;
    }

    public static ResponseResultUtils errorResult(AppHttpCodeEnum enums){
        return setAppHttpCodeEnum(enums,enums.getMsg());
    }

    public static ResponseResultUtils errorResult(AppHttpCodeEnum enums, String msg){
        return setAppHttpCodeEnum(enums,msg);
    }

    public static ResponseResultUtils setAppHttpCodeEnum(AppHttpCodeEnum enums){
        return okResult(enums.getCode(),enums.getMsg());
    }

    private static ResponseResultUtils setAppHttpCodeEnum(AppHttpCodeEnum enums, String msg){
        return okResult(enums.getCode(),msg);
    }

    public ResponseResultUtils<?> error(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public ResponseResultUtils<?> ok(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    public ResponseResultUtils<?> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }

    public ResponseResultUtils<?> ok(T data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



}