package com.xq.web.controller;

import com.xq.bean.Users;
import com.xq.service.UserService;
import com.xq.util.TimeUtils;
import com.xq.util.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/index.html")
    public String indexhtml(){
        return "index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/member-list.html")
    public String member_list(){
        return "member-list";
    }

    @RequestMapping("/member-del.html")
    public String member_del(){
        return "member-del";
    }
    @RequestMapping("/xx.html")
    public String xx(){
        return "member-del";
    }

    //订单列表
    @RequestMapping("/order-list.html")
    public String order_list(){
        return "order-list";
    }

    //管理员列表
    @RequestMapping("/admin-list.html")
    public String admin_list(){
        return "admin-list";
    }

    //角色管理
    @RequestMapping("/admin-role.html")
    public String admin_role(){
        return "admin-role";
    }

    //权限分类
    @RequestMapping("/admin-cate.html")
    public String admin_cate(){
        return "admin-cate";
    }

    //权限管理
    @RequestMapping("/admin-rule.html")
    public String admin_rule(){
        return "admin-rule";
    }

    //拆线图
    @RequestMapping("/echarts1.html")
    public String echarts1(){
        return "echarts1";
    }

    //柱状图
    @RequestMapping("/echarts2.html")
    public String echarts2(){
        return "echarts2";
    }
    //地图
    @RequestMapping("/echarts3.html")
    public String echarts3(){
        return "echarts3";
    }

    //饼图
    @RequestMapping("/echarts4.html")
    public String echarts4(){
        return "echarts4";
    }

    //雷达图
    @RequestMapping("/echarts5.html")
    public String echarts5(){
        return "echarts5";
    }

    //K线图
    @RequestMapping("/echarts6.html")
    public String echarts6(){
        return "echarts6";
    }

    //热力图
    @RequestMapping("/echarts7.html")
    public String echarts7(){
        return "echarts7";
    }

    //仪表图
    @RequestMapping("/echarts8.html")
    public String echarts8(){
        return "echarts8";
    }

    //管理员添加页面
    @RequestMapping("/admin-add.html")
    public String admin_add(){
        return "admin-add";
    }


    @Resource
    private UserService service;

    //管理员注册
    @RequestMapping("/UserRegister")
    @ResponseBody
    public Users UserRegist(Users users) throws ParseException {
        users.setUser_id(UUIDUtils.getUUID()+UUIDUtils.getUUID());
        users.setCreate_time(TimeUtils.getDateTimeToString());
        System.out.println(users);
        service.UserRegist(users);
        return users;
    }
}
