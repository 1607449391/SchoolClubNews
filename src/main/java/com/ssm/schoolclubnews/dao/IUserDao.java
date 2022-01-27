package com.ssm.schoolclubnews.dao;

import com.ssm.schoolclubnews.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
 *@author：
 *@time：2022-01-27 17:22
 *@description：
 *
 */
@Mapper
public interface IUserDao {
    User getUserByUserName(@Param("userName") String userName);
}
