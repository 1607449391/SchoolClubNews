package com.ssm.schoolclubnews.dao;

import com.ssm.schoolclubnews.vo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *@author：徐家庆
 *@time：2022-01-29 17:31
 *@description：
 *
 */
@Mapper
public interface INewsDao {
    int insertNews(@Param("news") News news);

    int updateNews(@Param("news") News news);

    News getNewsById(@Param("id") String id);

    List<News> getNewsByCondiations();
}
