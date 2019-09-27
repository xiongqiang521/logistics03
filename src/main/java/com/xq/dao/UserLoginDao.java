package com.xq.dao;


import com.xq.bean.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface UserLoginDao {

    //用户登录
    @Select("select * from users where name=#{username} and password=#{password}")
    Users getUsersByNameAndPassword(String username,String password);

    //手机登录
    @Select("select telephone from users where telephone=#{tel}")
    String getTel(String tel);

    //用户注册
    @Insert("insert into users(user_id,name,password,create_time,state,telephone) values(#{user_id},#{name},#{password},#{create_time},#{state},#{telephone})")
    void MessageRegister(Users users);

    @Select("select name from users where name=#{username}")
    String getName(String name);
}
