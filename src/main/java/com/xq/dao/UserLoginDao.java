package com.xq.dao;


import com.xq.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserLoginDao {

    //用户登录
    @Select("select * from users where name=#{username} and password=#{password}")
    Users getUsersByNameAndPassword(String username,String password);
}
