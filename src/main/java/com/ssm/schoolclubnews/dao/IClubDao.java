package com.ssm.schoolclubnews.dao;

import com.ssm.schoolclubnews.vo.Club;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *@author：徐家庆
 *@time：2022-01-29 17:54
 *@description：
 *
 */
@Mapper
public interface IClubDao {
    int insertClub(@Param("club")Club club);

    int updateClub(@Param("club") Club club);

    Club getClubById(@Param("id") String id);

    List<Club> getClubs();
}
