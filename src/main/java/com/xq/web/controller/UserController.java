package com.xq.web.controller;

import com.xq.bean.Users;
import com.xq.service.UserService;
import com.xq.util.TimeUtils;
import com.xq.util.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Resource
    private UserService service;

    //管理员注册
    @RequestMapping("/UserRegister")
    @ResponseBody
    public Users UserRegist(Users users) throws ParseException {
        users.setUser_id(UUIDUtils.getUUID());
        users.setCreate_time(TimeUtils.getDateTimeToString());
        System.out.println(users);
        service.UserRegist(users);
        return users;
    }

    //查询所有管理人员
    @RequestMapping("/getAll")
    public ModelAndView getAll(ModelAndView mv){
        List<Users> users = service.getAll();
        for (Users user : users) {
            System.out.println(user);
        }
        mv.addObject("users",users);
        return null;

    }

}
