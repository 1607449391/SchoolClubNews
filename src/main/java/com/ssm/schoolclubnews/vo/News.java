package com.ssm.schoolclubnews.vo;

import lombok.Data;

/*
 *@author：
 *@time：2022-01-16 18:34
 *@description：
 *      新闻实体
 */
@Data
public class News extends Base {
    private String id;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 新闻内容
     */
    private String content;

    /**
     * 新闻标签
     */
    private String tags;
}
