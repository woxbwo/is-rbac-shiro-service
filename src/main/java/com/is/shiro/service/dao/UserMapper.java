package com.is.shiro.service.dao;

import com.is.shiro.service.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: UserMapper
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.07 1:57
 */
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findByUsername(@Param("username")String username);



    @Select("select * from user where id=#{userId}")
    User findById(@Param("userId") int id);



    @Select("select * from user where username = #{username} and password = #{pwd}")
    User findByUsernameAndPwd(@Param("username")String username, @Param("pwd")String pwd);
}
