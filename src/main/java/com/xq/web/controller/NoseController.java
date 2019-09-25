package com.xq.web.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.xq.bean.NoseOrder;
import com.xq.bean.Order;
import com.xq.bean.Users;
import com.xq.service.NoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public NoseOrder selectNum(Integer num){
        NoseOrder noseOrder = noseService.selectNum(num);
        if (noseOrder==null)
            throw new RuntimeException("订单号错误");

        return noseOrder;
    }

    @RequestMapping("selectOrdersTel")
    @ResponseBody
    public Map<String ,List<NoseOrder>> selectTel(String  tel){

        Map<String ,List<NoseOrder>> map =new HashMap<>();

        List<Users> users = noseService.selectTelephone(tel);
        if (users == null) {
            return null;
        }
        // 寄件人电话
        List<NoseOrder> noseOrderReceives =new ArrayList<>();
        for (Users user : users) {
            List<Order> orders = noseService.selectByReceiveUser(user);
            if (orders == null) {
                continue;
            }
            for (Order order : orders) {
                NoseOrder noseOrder = selectNum(order.getOrder_id());
                noseOrderReceives.add(noseOrder);
            }
        }
        map.put("orderReceive",noseOrderReceives);
        // model.addAttribute("noseOrderReceives",noseOrderReceives);

        // 收件人电话
        List<NoseOrder> noseOrderSends =new ArrayList<>();
        for (Users user : users) {
            List<Order> orders = noseService.selectBySendUser(user);
            if (orders == null) {
                continue;
            }
            for (Order order : orders) {
                NoseOrder noseOrder = selectNum(order.getOrder_id());
                noseOrderSends.add(noseOrder);
            }
        }
        map.put("orderSend",noseOrderSends);
        // model.addAttribute("noseOrderSends",noseOrderSends);

        return map;
    }
}
