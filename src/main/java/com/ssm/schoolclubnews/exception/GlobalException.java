package com.ssm.schoolclubnews.exception;

import com.ssm.schoolclubnews.util.StatusCode;

/*
 *@author：
 *@time：2022-01-16 18:58
 *@description：
 *          全局异常
 */
public class GlobalException extends Exception {
    private static final long serialVersionUID = 4501435307076363372L;
    private StatusCode code;

    public GlobalException(StatusCode code) {
        super(code.getMsg());
        this.code = code;
    }

    public StatusCode getCode() {
        return code;
    }
}
