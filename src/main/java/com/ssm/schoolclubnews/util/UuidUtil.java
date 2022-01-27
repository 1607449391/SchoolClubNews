package com.ssm.schoolclubnews.util;

import java.util.UUID;

/*
 *@author：
 *@time：2022-01-16 18:44
 *@description：
 *      UUID 工具类
 */
public class UuidUtil {

    /**
     * 获取uuid
     *
     * @return uuid
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
