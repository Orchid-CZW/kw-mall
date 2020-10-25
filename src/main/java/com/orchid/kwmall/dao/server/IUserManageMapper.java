package com.orchid.kwmall.dao.server;

import com.orchid.kwmall.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Orchid
 * @data 2020/9/29 --- 20:25
 */
@Mapper
public interface IUserManageMapper {
    @Select("select * from user where uid = #{uid}")
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
    User queryUserById(String id);

    @Select("select * from user")
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
    List<User> queryAllUsers();

    @Delete("delete from user where uid = #{id}")
    void deleteUser(String id);

    @Update("update user set username=#{username},password=#{password},name=#{name},email=#{email},telephone=#{telephone},birthday=#{birthday}, sex=#{sex}, state=#{state}, code=#{code} where uid=#{uid}")
    void updateUser(User user);
}
