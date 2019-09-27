package com.xq.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.xq.bean.Users;
import com.xq.service.UsersLoginServics;
import com.xq.util.Messages;
import com.xq.util.TimeUtils;
import com.xq.util.UUIDUtils;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class UsersLoginController {
    private Map<String,String> map=new HashMap<>();

     @Resource
    private UsersLoginServics loginServics;

     //用户账户登录
     @RequestMapping("/UsersByNameAndPassword")
     @ResponseBody
     public ModelAndView UsersByNameAndPassword(String username, String password,ModelAndView mv){
         //判断前端获取的数据是否是有效数据
         if(username!=null && username!="" && password !=null && password !=""){
             Users usersByNameAndPassword = loginServics.getUsersByNameAndPassword(username, password);
             //查询到该用户信息
             if(usersByNameAndPassword!=null){
                 System.out.println("查到该用户");
                 mv.setViewName("redirect:/index.html");
                 return mv;
             }
             System.out.println("用户名不存在");
             mv.addObject("userError","用户名不存在");
             mv.setViewName("login-nose.html");
             return mv;
         }else {
             System.out.println("请输入用户名密码");
             mv.addObject("login","请输入用户名密码");
             mv.setViewName("login-nose.html");
             return mv;
         }
     }

     //手机登录

    @RequestMapping("/Message")
    @ResponseBody
    public Map<String,String > Message(String tel){
        ModelAndView mv=new ModelAndView();

        System.out.println("---------"+tel);
        String telNum = loginServics.getTel(tel);
        if(telNum==null){
          mv.addObject("msg","用户不存在");
            System.out.println("不存在");
            return null;
        }else{
            Messages messages=new Messages();
            String code = messages.Messages(tel);
            map.put(tel,code);
            System.out.println("存在========="+code);

        return map;
        }
    }

    /**
     * 验证手机号和验证码是否匹配
     * @param tel
     * @param code
     * @return
     */
    @RequestMapping("/MessageLogin")
    @ResponseBody
    public String MessageLogin(String tel,String code){
        boolean equals = Objects.equals(map.get(tel), code);
        System.out.println("tel========="+tel+code);
        ModelAndView mv=new ModelAndView();
        if(equals){
            System.out.println(11111);
            return "index.html";
        }else {
            mv.addObject("codeError","验证码错误");
            System.out.println(123123);
            return "login-nose.html";
        }
    }

    /**
     * 用户注册
     */
    @RequestMapping("/MessageRegister")
    @ResponseBody
    public ModelAndView MessageRegister(Users users,ModelAndView mv){
        users.setCreate_time(TimeUtils.getDateTimeToString());
        users.setUser_id(UUIDUtils.getUUID());
        String name = loginServics.getName(users.getName());
        String tel = loginServics.getTel(users.getTelephone());
        System.out.println("============"+name+tel);
        if(name==null && tel==null){
            loginServics.MessageRegister(users);
            System.out.println("============="+users);
            System.out.println("注册完成");
            mv.setViewName("redirect:/login-nose.html");
            return mv;
        }else{
            mv.addObject("RegisterError","用户名已存在");
            System.out.println("该用户名不存在");
            mv.setViewName("user-register.html");
            return mv;
        }


    }
}
