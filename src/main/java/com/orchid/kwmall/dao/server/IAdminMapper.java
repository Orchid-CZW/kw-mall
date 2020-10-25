package com.orchid.kwmall.dao.server;

import com.orchid.kwmall.domain.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Orchid
 * @data 2020/9/29 --- 17:40
 */
@Mapper
public interface IAdminMapper {

    @Select("select * from Admin where username=#{username} and password=#{password}")
    @Results({
            @Result(id = true, column="uid",property="uid"),
            @Result(column="username",property="username"),
            @Result(column="password",property="password"),
            @Result(column="email",property="email"),
            @Result(column="telephone",property="telephone"),
    })
    Admin loginAdmin(@Param("username") String username, @Param("password") String password);

    int deleteByPrimaryKey(Integer uid);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer uid);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);
}
