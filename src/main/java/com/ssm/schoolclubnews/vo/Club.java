package com.ssm.schoolclubnews.vo;

import lombok.Data;

/*
 *@author：
 *@time：2022-01-16 18:34
 *@description：
 *      社团实体
 */
@Data
public class Club extends Base {
    private String id;

    /**
     * 社团名称
     */
    private String name;

    /**
     * 社团描述
     */
    private String desc;
}
