package com.ssm.schoolclubnews.util;

/*
 *@author：
 *@time：2022-01-16 16:54
 *@description：
 *          常量类
 *
 */
public interface Dicts {
    //MD5加密随机盐的长度，最大可设置64
    public static final Integer MD5_SALT_LENGTH = 16;
    //MD5加密散列次数
    public static final Integer MD5_ITERATIONS = 1024;
    //Token密钥
    public static final String TOKEN_SECRET_KEY = "Rn&^Fbf4Ran^W4oY";
    // Token失效时间
    public static final long TOKEN_EXPIRE_TIME = 5 * 60;
}
