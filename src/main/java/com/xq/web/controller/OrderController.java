package com.xq.web.controller;

import com.xq.bean.OrderAll;
import com.xq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/27 8:40
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("getOrders")
    public void getOrders(){
        List<OrderAll> orders = orderService.getOrders();
    }
}
