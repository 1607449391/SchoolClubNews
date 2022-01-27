package com.ssm.schoolclubnews.vo;

import lombok.Data;

import java.util.Date;

/*
 *@author：
 *@time：2022-01-16 18:34
 *@description：
 *         用户实体
 */
@Data
public class User extends Base {
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生日期
     */
    private Date birth;

    /**
     * 密码
     */
    private String password;

    /**
     * 学号
     */
    private String number;

    /**
     * 手机号码
     */
    private String tplPhone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 随机盐
     */
    private String salt;
}
