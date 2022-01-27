package com.ssm.schoolclubnews.util;

import com.ssm.schoolclubnews.vo.ResponseBase;

/*
 *@author：
 *@time：2022-01-16 16:30
 *@description：
 *          API统一返回值工具类
 */
public class ResponseUtil<T> {

    public static ResponseBase fail() {
        return new ResponseBase(StatusCode.FAIL.getCode());
    }

    public static ResponseBase fail(String msg) {
        return new ResponseBase(StatusCode.FAIL.getCode(), msg);
    }

    public static ResponseBase fail(int code, String msg) {
        return new ResponseBase(code, msg);
    }

    public static ResponseBase success() {
        return new ResponseBase(StatusCode.SUCCESS.getCode());
    }

    public static <T> ResponseBase success(T data) {
        return new ResponseBase(StatusCode.SUCCESS.getCode(), data);
    }

    public static ResponseBase success(String msg) {
        return new ResponseBase(StatusCode.SUCCESS.getCode(), msg);
    }
}
