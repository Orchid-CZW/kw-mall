package com.orchid.kwmall.dao.client;

import com.orchid.kwmall.domain.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(String uid);

    @Select("insert into user values (#{uid}, #{username}, #{password},#{name}, #{email}, #{telephone},#{birthday}, #{sex}, #{state}, #{code})")
    @Results({
            @Result(id = true, column="uid",property="uid"),
            @Result(column="username",property="username"),
            @Result(column="password",property="password"),
            @Result(column="name",property="name"),
            @Result(column="email",property="email"),
            @Result(column="telephone",property="telephone"),
            @Result(column="birthday",property="birthday"),
            @Result(column="sex",property="sex"),
            @Result(column="state",property="state"),
            @Result(column="code",property="code")
    })
    User insert(User record);

    User selectByPrimaryKey(String uid);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    @Select("select * from user where username=#{username} and password=#{password}")
    @Results({
            @Result(id = true, column="uid",property="uid"),
            @Result(column="username",property="username"),
            @Result(column="password",property="password"),
            @Result(column="name",property="name"),
            @Result(column="email",property="email"),
            @Result(column="telephone",property="telephone"),
            @Result(column="birthday",property="birthday"),
            @Result(column="sex",property="sex"),
            @Result(column="state",property="state"),
            @Result(column="code",property="code")
    })
    User loginUser(@Param("username") String username, @Param("password") String password);
}