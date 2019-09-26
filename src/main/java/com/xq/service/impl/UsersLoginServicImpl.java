package com.xq.service.impl;

import com.xq.bean.Users;
import com.xq.dao.UserLoginDao;
import com.xq.service.UsersLoginServics;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersLoginServicImpl implements UsersLoginServics {

    @Resource
    private UserLoginDao dao;

    @Override
    public Users getUsersByNameAndPassword(String username, String password) {
        return dao.getUsersByNameAndPassword(username,password);
    }
}
