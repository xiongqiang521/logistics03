package com.xq.web.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.xq.bean.Order;
import com.xq.service.NoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/21 15:45
 */
@Controller
public class NoseController {
    @Autowired
    private NoseService noseService;

    @RequestMapping("selectOrderNum")
    @ResponseBody
    public Order selectNum(Integer num){
        Order order = noseService.selectNum(num);
        return order;
    }

    @RequestMapping("selectOrdersTel")
    @ResponseBody
    public List<Order> selectTel(String  tel){
        List<Order> orders = noseService.selectByTelephone(tel);
        return orders;
    }
}
