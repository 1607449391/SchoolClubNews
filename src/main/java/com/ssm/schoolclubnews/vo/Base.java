package com.ssm.schoolclubnews.vo;

import lombok.Data;

import java.util.Date;

/*
 *@author：
 *@time：2022-01-16 17:44
 *@description：
 *
 */
@Data
public class Base {
    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 最后更新人
     */
    private String lastUpdatedBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdatedDate;

    /**
     * 逻辑删除标记
     */
    private String isDeleted;
}
