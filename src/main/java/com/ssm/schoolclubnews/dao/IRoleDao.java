package com.ssm.schoolclubnews.dao;

import com.ssm.schoolclubnews.vo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *@author：徐家庆
 *@time：2022-01-29 17:46
 *@description：
 *
 */
@Mapper
public interface IRoleDao {
    int insertRole(@Param("role") Role role);

    int updateRole(@Param("role") Role role);

    List<Role> getRolesByUserId(@Param("userId") String userId);

}
