package com.xq.service.impl;

import com.xq.bean.User;
import com.xq.dao.UserDao;
import com.xq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;
    @Override
    public void UserRegist(User user) {
        dao.UserRegist(user);
    }
}
