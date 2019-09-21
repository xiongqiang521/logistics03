package com.xq.service.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.xq.bean.Order;
import com.xq.bean.Users;
import com.xq.dao.OrderDao;
import com.xq.dao.UserDao;
import com.xq.service.NoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/21 15:48
 */
@Service
public class NoseServiceImpl implements NoseService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;


    @Override
    public List<Order> selectByTelephone(String tel) {
        // 通过电话号查找用户
        Users users = userDao.selectTelephone(tel);
        // 通过用户查找订单列表
        List<Order> orders = orderDao.selectByReceiveUserId(users.getId());
        return orders;
    }

    @Override
    public Order selectNum(Integer num) {
        Order order = orderDao.selectByOrderId(num);
        return order;
    }
}
