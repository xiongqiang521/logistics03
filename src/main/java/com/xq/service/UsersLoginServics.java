package com.xq.service;

import com.xq.bean.Users;
import org.springframework.stereotype.Service;



public interface UsersLoginServics {

    //用户账号密码登录
    Users getUsersByNameAndPassword(String username, String password);

    //手机登录
    String getTel(String tel);

    //用户注册
    void MessageRegister(Users users);
    String getName(String name);

}
