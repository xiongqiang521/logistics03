package com.xq.service.impl;

import com.xq.bean.Order;
import com.xq.bean.Users;
import com.xq.dao.UserAddOrderDao;
import com.xq.service.UserAddOrderService;
import com.xq.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public void setOrder(Order order) {
     userAddOrderDao.addOrder(order);
    }
}
