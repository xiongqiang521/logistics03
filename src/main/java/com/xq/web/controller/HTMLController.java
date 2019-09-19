package com.xq.web.controller;

import com.xq.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 访问templates里的动态页面
 *
 * @author Mechrevo
 * @version v1.0
 * 2019/9/18 9:04
 */
@Controller
public class HTMLController {

    @RequestMapping("*.html")
    public String welcome(HttpServletRequest request) {
        /*
        备用，返回null测试没问题，不明白为什么，如果返回null找不到页面404，使用下面的替代null
        return request.getServletPath().substring(1).replace(".html", "");
        */

        return null;
    }

    @RequestMapping("admin")
     public String test(){

        return "login";
     };




    @RequestMapping("add")
    @ResponseBody
    public User  add(User user){
        System.out.println(1111);
        System.out.println(user);
        return user;
    }
}
