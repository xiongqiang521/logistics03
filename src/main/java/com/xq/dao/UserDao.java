package com.xq.dao;

import com.xq.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    //管理員注册
   @Insert("INSERT INTO USER(user_id,NAME,PASSWORD,create_time,state,telephone) VALUES(#{user_id},#{name},#{password},${create_time},#{state},#{telephone})")
    void UserRegist(User user);
}
