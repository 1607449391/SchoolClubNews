package com.ssm.schoolclubnews.vo;

import lombok.Data;

/*
 *@author：
 *@time：2022-01-16 18:34
 *@description：
 *      角色实体
 */
@Data
public class Role extends Base {
    private String id;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;
}
