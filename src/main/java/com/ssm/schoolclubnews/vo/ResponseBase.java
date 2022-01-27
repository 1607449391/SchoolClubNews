package com.ssm.schoolclubnews.vo;

import lombok.Data;

/*
 *@author：
 *@time：2022-01-16 16:33
 *@description：
 *          API统一返回值
 */
@Data
public class ResponseBase<T> {
    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public ResponseBase(Integer code) {
        this.code = code;
    }

    public ResponseBase(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseBase(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseBase(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
