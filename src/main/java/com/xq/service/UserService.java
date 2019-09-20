package com.xq.service;

import com.xq.bean.Users;

import java.util.List;

public interface UserService {

   //管理员添加
    void UserRegist(Users users);

    //查询所有管理人员
    List<Users> getAll();

    //验证登录
    Users login(String name);
}
