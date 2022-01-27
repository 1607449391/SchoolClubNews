package com.ssm.schoolclubnews.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.util.Random;

/*
 *@author：徐家庆
 *@time：2021-07-19 16:57
 *@description：
 *              MD5加密+随机盐+散列
 *
 */
@Slf4j
public class MD5Util {

    private static final String SALT_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm0123456789+-*/@#$%^&*?";
    private static final Integer STR_LENGTH = SALT_STR.length();
    private static Random random = new Random();

    /**
     * 生成随机盐
     *
     * @return
     */
    public static String getSalt() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Dicts.MD5_SALT_LENGTH; i++) {
            str.append(SALT_STR.charAt(random.nextInt(STR_LENGTH)));
        }
        return str.toString();
    }

    /**
     * 根据明文生成密文：
     * 生成方式：明文+salt进行MD5加密，然后根据密文+salt进行MD5加密，重复Iterations次
     *
     * @param msg        明文
     * @param salt       随机盐
     * @param Iterations 散列次数
     * @return 密文
     */
    public static String getEncryption(String msg, String salt, int Iterations) {
        String str = msg + salt;
        str = DigestUtils.md5DigestAsHex(str.getBytes());
        for (int i = 0; i < Iterations; i++) {
            str = str + salt;
            str = DigestUtils.md5DigestAsHex(str.getBytes());
        }
        return str;
    }

}
