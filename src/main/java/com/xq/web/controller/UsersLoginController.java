package com.xq.web.controller;

import com.xq.bean.Users;
import com.xq.service.UsersLoginServics;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class UsersLoginController {

     @Resource
    private UsersLoginServics loginServics;

     //用户账户登录
     @RequestMapping("/UsersByNameAndPassword")
     @ResponseBody
    public ModelAndView UsersByNameAndPassword(String username, String password,ModelAndView mv){
         System.out.println(username+password);
         Users usersByNameAndPassword = loginServics.getUsersByNameAndPassword(username, password);
         System.out.println(usersByNameAndPassword);
         mv.setViewName("index.html");
         return mv;
     }

     //手机登录

    @RequestMapping("/Message")
    @ResponseBody
    public void Message(String tel){
        System.out.println("---------"+tel);



    }
}
