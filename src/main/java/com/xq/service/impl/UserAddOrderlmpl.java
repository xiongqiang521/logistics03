package com.xq.service.impl;

import com.xq.bean.Order;
import com.xq.bean.OrderUser;
import com.xq.bean.Users;
import com.xq.dao.UserAddOrderDao;
import com.xq.service.UserAddOrderService;
import com.xq.service.UserService;
import com.xq.util.MoneyUtil;
import com.xq.util.TimeUtils;
import com.xq.util.UUIDUtils;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
            //用户姓名
            user.setName(orderUser.getName());
            //密码，可以为空
            user.setPassword(orderUser.getPassword());
            //寄件时间
            user.setCreate_time(TimeUtils.getDateTimeToString());
            //用户是否登录，我先默认为未登录
            user.setState("1");

            userAddOrderDao.addSend(user);
        }else if (!Objects.equals(users.getName(),orderUser.getName())){
            //修改
            userAddOrderDao.upUsers(users);
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
        }else if (!Objects.equals(users.getName(),orderUser.getName())){
            //修改
            userAddOrderDao.upUsers(users);
        }
        return null;
    }

    //修改
    @Override
    public void upUser(Users user) {
     userAddOrderDao.upUsers(user);
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
    public void setOrder(OrderUser orderl) {
        //创建订单对象
       Order order = new Order();
        //生成订单id
        order.setOrder_id(333);
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

    }
}
