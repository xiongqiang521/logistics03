package com.xq.web.controller;

import com.xq.bean.Order;
import com.xq.bean.OrderUser;
import com.xq.bean.Users;
import com.xq.service.impl.UserAddOrderlmpl;
import com.xq.service.impl.UserServiceImpl;
import com.xq.util.MoneyUtil;
import com.xq.util.TimeUtils;
import com.xq.util.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
private UserAddOrderlmpl userAddOrderlmpl;


    @RequestMapping(value = "addorder" ,method = {RequestMethod.POST, RequestMethod.GET})
    public String addOrder(OrderUser ou){

        //封装寄件人消息

        //创建对象
        Users user=new Users();
        //用户id
        user.setUser_id(UUIDUtils.getUUID());
        //用户姓名
        user.setName(ou.getName());
        //密码，可以为空
        user.setPassword(ou.getPassword());
        //寄件时间
        user.setCreate_time(TimeUtils.getDateTimeToString());
        //用户是否登录，我先默认为未登录
        user.setState("1");
        //用户的联系方式
        user.setTelephone(ou.getTelephone());
        //寄件人信息封装完成

//       调用userAddOrderlmpl保存寄件人信息
        userAddOrderlmpl.setSend(user);

        //封装收件人信息
       Users suser=new Users();
       suser.setUser_id(UUIDUtils.getUUID());
       //用户姓名
        suser.setName(ou.getSname());
        //密码，可以为空
        suser.setPassword(ou.getSpassword());
        //收件时间，收获的时间
        suser.setCreate_time(TimeUtils.getFutureTime());
        //用户是否登录，我先默认为未登录
        suser.setState("1");
        //用户的联系方式
        suser.setTelephone(ou.getStelephone());
        //寄件人信息封装完成

//       在这里可以调用mapper进行保存
        userAddOrderlmpl.setRecevie(suser);

        //封装订单，地址为收件人的地址
        Order order =new Order();
        //生成订单id
        order.setOrder_id(555555);
        //生成寄件时间
        order.setSend_time(TimeUtils.getDateTimeToString());
        //寄件人id,改变属性
        order.setSend_user_id(333333);
        //取件时间
       // order.setReceive_time(TimeUtils.getFutureTime());
        //收件人id，改变属性
        order.setReceive_user_id(5555);
        //收获人地址
         order.setSend_address(ou.getSendaddress());
         //寄件人地址
        order.setReceive_address(ou.getReceiveaddress());
        //重量
        order.setWeight(ou.getWeiht());
        //计算价格
        double money = MoneyUtil.getMoney(ou.getWeiht());
        order.setMoney(money+"");
        userAddOrderlmpl.setOrder(order);
        System.out.println("添加成功");

        //输入要跳转的地址，之后可以删除succes.html
        return "succes";

    }



}
