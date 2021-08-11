package com.high.concurrency.currency02.mapper;

import com.high.concurrency.currency02.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer getCount();

    List<User> selectPage(@Param("begin") int begin, @Param("pageSize") int pageSize);

}