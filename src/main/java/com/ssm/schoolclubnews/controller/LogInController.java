package com.ssm.schoolclubnews.controller;

import com.alibaba.druid.util.StringUtils;
import com.ssm.schoolclubnews.exception.CatchExceptions;
import com.ssm.schoolclubnews.exception.GlobalException;
import com.ssm.schoolclubnews.util.StatusCode;
import com.ssm.schoolclubnews.vo.ResponseBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@author：
 *@time：2022-01-16 18:23
 *@description：
 *          用户登录，登出
 */
@RestController
@RequestMapping("/")
public class LogInController {

    @GetMapping("/login")
    @CatchExceptions
    public ResponseBase login(String userName, String password) throws GlobalException {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            throw new GlobalException(StatusCode.USERNAME_OR_PASSWORD_IS_NULL);
        }
        return null;
    }
}
