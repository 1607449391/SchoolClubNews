package com.ssm.schoolclubnews.util;

/*
 *@author：
 *@time：2022-01-16 16:43
 *@description：
 *      请求状态码
 */
public enum StatusCode {
    /**
     * 请求成功
     */
    SUCCESS("请求成功", 200),

    /**
     * 请求失败
     */
    FAIL("请求失败", 500),

    USERNAME_OR_PASSWORD_IS_NULL("用户名或密码不能为空", 510);


    String msg;

    int code;

    StatusCode(String msg, int i) {
        code = i;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
