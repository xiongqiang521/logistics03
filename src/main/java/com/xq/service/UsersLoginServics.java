package com.xq.service;

import com.xq.bean.Users;
import org.springframework.stereotype.Service;



public interface UsersLoginServics {

    Users getUsersByNameAndPassword(String username, String password);
}
