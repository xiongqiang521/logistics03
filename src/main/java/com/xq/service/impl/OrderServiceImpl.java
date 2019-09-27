package com.xq.service.impl;

import com.xq.bean.OrderAll;
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
    public List<OrderAll> getOrders() {
        List<OrderAll> orders = orderDao.getOrders();
        return orders;
    }
}
