package com.xq.service;

import com.xq.bean.OrderAll;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/27 8:42
 */
@Service
public interface OrderService {

    List<OrderAll> getOrders();

}
