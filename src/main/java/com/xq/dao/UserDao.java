package com.xq.dao;


import com.xq.bean.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    //管理員注册
   @Insert("INSERT INTO users(user_id,NAME,PASSWORD,create_time,state,telephone) VALUES(#{user_id},#{name},#{password},#{create_time},#{state},#{telephone})")
    void UserRegist(Users users);

   //查询所有管理人员
    @Select("select * from users")
   List<Users> getAll();

    //验证登录
    @Select("SELECT * FROM users WHERE NAME=#{NAME}")
    Users login(String name);
}
