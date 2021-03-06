package com.xq.service.impl;

import com.xq.bean.*;
import com.xq.dao.EmployeeDao;
import com.xq.dao.OrderTransferInfoDao;
import com.xq.dao.UserAddOrderDao;
import com.xq.service.UserAddOrderService;
import com.xq.util.IntegerIDUtils;
import com.xq.util.MoneyUtil;
import com.xq.util.TimeUtils;
import com.xq.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.KeyStore;
import java.util.List;
import java.util.Objects;

/**
 * @ProjectName: logistics03
 * @Package: com.xq.service.impl
 * @ClassName: UserAddOrderlmpl
 * @Author: yaoxiaolei
 * @Description: ${description}
 * @Date: 2019/9/21 17:19
 * @Version: 1.0
 */

@Service
public class UserAddOrderlmpl implements UserAddOrderService {
    //调用DAO层，UserAddOrderDao

    @Resource
    private UserAddOrderDao userAddOrderDao;

    @Resource
    private OrderTransferInfoDao orderTransferInfoDao;
    @Resource
    private EmployeeDao employeeDao;

    //查询
    @Override
    public Users selUserTel(OrderUser orderUser) {
        System.out.println("答应了");
        Users users = userAddOrderDao.sleUsersTel(orderUser.getTelephone());
        //判断数据库是否有该电话
        if (users == null) {
            //如果没有，则添加用户，创建对象
            Users user =new Users();
            //添加姓名
            user.setName(orderUser.getName());
            //添加号码
            user.setTelephone(orderUser.getTelephone());
            //添加下单时间
            user.setCreate_time(TimeUtils.getDateTimeToString());
              //用户id
            user.setUser_id(UUIDUtils.getUUID());

            //密码，可以为空
            user.setPassword(orderUser.getPassword());

            //用户是否登录，我先默认为未登录
            user.setState("1");

            userAddOrderDao.addSend(user);
        }else {
            //判断用户名是否更改
             if(!orderUser.getName().equals(users.getName())){
                     //修改
                 users.setName(orderUser.getName());
                     userAddOrderDao.upUsers(users);
                 System.out.println("修改成功");
             }
        }
        return null;
    }

    //查询寄件人
    @Override
    public Users rselUserTel(OrderUser orderUser) {
        Users users = userAddOrderDao.sleUsersTel(orderUser.getStelephone());
        //判断数据库是否有该电话
        if (users == null) {
            //如果没有，则添加用户，创建对象
            Users user =new Users();
            //添加姓名
            user.setName(orderUser.getSname());
            //添加号码
            user.setTelephone(orderUser.getStelephone());
            //添加下单时间
           // user.setCreate_time(orderUser.getCreate_time());
            //用户id
            user.setUser_id(UUIDUtils.getUUID());
            //用户姓名
            user.setName(orderUser.getSname());
            //密码，可以为空
            user.setPassword(orderUser.getPassword());
            //寄件时间
           // user.setCreate_time(TimeUtils.getDateTimeToString());
            //用户是否登录，我先默认为未登录
            user.setState("1");
            userAddOrderDao.addSend(user);
        }else {
            //判断用户名是否更改
            if(!Objects.equals(users.getName(),orderUser.getSname())){
                //修改
                userAddOrderDao.upUsers(users);
            }
        }
        return null;
    }


    /**
 * @Method
 * @Author yaoxiaolei
 * @Version  1.0
 * @Description
    添加寄件人
 */
    @Override
    public void setSend(Users user) {
        userAddOrderDao.addSend(user);
    }
/**
 * @Method
 * @Author yaoxiaolei
 * @Version  1.0
 * @Description
  添加收件人
 */
    @Override
    public void setRecevie(Users user) {
      userAddOrderDao.addReceive(user);
    }
/**
 * @Method
 * @Author yaoxiaolei
 * @Version  1.0
 * @Description
    添加订单
 */
    @Override
    public void setOrder(OrderUser orderl,Employee employee) {
        //创建订单对象
        System.out.println("正在创建订单");
       Order order = new Order();
        //生成订单id
        Integer oid = IntegerIDUtils.creatID();
        order.setOrder_id(oid);
        //生成寄件时间
        order.setSend_time(TimeUtils.getDateTimeToString());
       // System.out.println(TimeUtils.getDateTimeToString());
        //寄件人id,改变属性,需要查询，根据手机号查询,            根据要求设置Users表的id字段为用户id
        String telephone = orderl.getTelephone();
        Users users = userAddOrderDao.sleUsersTel(telephone);
        Integer id = users.getId();
        order.setSend_user_id(id);

        //取件时间
        // order.setReceive_time(TimeUtils.getFutureTime());
        //收件人id，，根据手机号查询生成的用户id
        String stelephone = orderl.getStelephone();
        Users users1 = userAddOrderDao.sleUsersTel(stelephone);
        Integer id1 = users1.getId();
        order.setReceive_user_id(id1);

        //收获人地址
        order.setSend_address(orderl.getSendaddress());
        //寄件人地址
        order.setReceive_address(orderl.getReceiveaddress());
        //重量
        order.setWeight(orderl.getWeiht());
        //计算价格
        double money = MoneyUtil.getMoney(orderl.getWeiht());
        order.setMoney(money);
        userAddOrderDao.addOrder(order);


        // 获取数据
        OrderTransferInfo orderTransferInfo = new OrderTransferInfo();
        orderTransferInfo.setOrder_id(oid);
        orderTransferInfo.setMode("入库");
        orderTransferInfo.setTime(TimeUtils.getDateTimeToString());

        // 获取登录员工信息
        if (employee == null) {

            throw new RuntimeException("获取员工信息异常");
        }
        orderTransferInfo.setEmployee_id(employee.getEmployee_num());
        orderTransferInfo.setStation_id(employee.getEmployeeState().getGroup());
        // Employee employeeByNum = employeeDao.getEmployeeByNum(employee.getEmployee_num());


        // 添加order_transfer_info表数据
        orderTransferInfoDao.addOrderTransferInfo(orderTransferInfo);


    }
}
