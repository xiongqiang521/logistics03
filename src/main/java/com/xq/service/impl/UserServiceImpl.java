package com.xq.service.impl;

import com.xq.bean.Users;
import com.xq.dao.UserDao;
import com.xq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao dao;
    @Override
    public void UserRegist(Users users) {
        dao.UserRegist(users);
    }

    @Override
    public List<Users> getAll() {
        return dao.getAll();
    }
}
