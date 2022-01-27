package com.ssm.schoolclubnews.services;

import com.ssm.schoolclubnews.exception.GlobalException;

/*
 *@author：
 *@time：2022-01-27 17:16
 *@description：
 *
 */
public interface ILoginService {

    public String login(String userName, String password) throws GlobalException;
}
