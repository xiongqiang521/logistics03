package com.xq.service.impl;

import com.github.pagehelper.Page;
import com.xq.bean.OrderAll;
import com.xq.bean.OrderCondition;
import com.xq.dao.OrderDao;
import com.xq.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/27 8:43
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Override
    public Page<OrderAll> getOrders() {
        Page<OrderAll> orders = orderDao.getOrders();
        return orders;
    }

    @Override
    public Page<OrderAll> getOrdersCondition(OrderCondition condition) {
        Page<OrderAll> ordersCondition = orderDao.getOrdersCondition(condition);

        return ordersCondition;
    }
}
