package com.xq.web.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.xq.bean.OrderUser;
import com.xq.bean.Users;
import com.xq.service.UserAddOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ProjectName: logistics03
 * @Package: com.xq.web.controller
 * @ClassName: UserAddOrder
 * @Author: yaoxiaolei
 * @Description: 这是生成用户订单的类
 * @Date: 2019/9/20 13:59
 * @Version: 1.0
 */
@Controller
public class UserAddOrderController {

/**
 * @Method
 * @Author yaoxiaolei
 * @Version  1.0
 * @Description

 * @Return
 * @Exception
 * @Date 2019/9/20 14:07
 */
//导入
@Resource
private UserAddOrderService userAddOrderlmpl;


    @RequestMapping(value = "/addorder" ,method = {RequestMethod.POST})
    @ResponseBody
    public String addOrder( OrderUser ou){

        System.out.println(ou);
        //添加寄件人
        Users users = userAddOrderlmpl.selUserTel(ou);
        //添加收件人
        Users ruser = userAddOrderlmpl.rselUserTel(ou);
        //添加到订单
        userAddOrderlmpl.setOrder(ou);
        System.out.println("添加成功");

        //输入要跳转的地址，之后可以删除succes.html
        return "succes";

    }



}
