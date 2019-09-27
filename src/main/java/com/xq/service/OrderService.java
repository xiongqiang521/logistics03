package com.xq.service;

import com.github.pagehelper.Page;
import com.xq.bean.OrderAll;
import com.xq.bean.OrderCondition;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/27 8:42
 */
@Service
public interface OrderService {

    Page<OrderAll> getOrders();

    Page<OrderAll> getOrdersCondition(OrderCondition condition);

}
