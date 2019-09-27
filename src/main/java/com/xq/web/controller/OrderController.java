package com.xq.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xq.bean.Employee;
import com.xq.bean.OrderAll;
import com.xq.bean.OrderCondition;
import com.xq.service.OrderService;
import com.xq.util.ExcelUtil;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/27 8:40
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;


    private Map<String, Object> map = new HashMap<>(3);

    @RequestMapping("getOrders")
    @ResponseBody
    public Map getOrders() {
        PageHelper.startPage(1, 7);
        Page<OrderAll> ordersPage = orderService.getOrders();

        long total = ordersPage.getTotal();
        System.out.println(total);


        OrderCondition condition = new OrderCondition(1, ordersPage.getPageSize(), ordersPage.getTotal(), ordersPage.getPages());
        map.put("ordersPage", ordersPage);
        map.put("orders", ordersPage.getResult());
        map.put("condition", condition);
        return map;
    }

    @RequestMapping("orderExcel")
    public void getExcel(HttpServletRequest request, HttpServletResponse response) {


        FileInputStream fis = null;
        try {
            File file = new File("D:/temp/order.xls");

            Page<OrderAll> orders = orderService.getOrders();

            ExcelUtil.excelExport("orders", orders.getResult(), file);


            fis = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            IOUtils.copy(fis, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @RequestMapping("orderCondition")
    @ResponseBody
    public Map orderCondition(OrderCondition condition) {

        if (condition.getPageNum() == null) {
            condition.setPageNum(1);
        }

        System.out.println(condition);

        PageHelper.startPage(condition.getPageNum(), 7);
        Page<OrderAll> ordersPage = orderService.getOrdersCondition(condition);

        OrderCondition orderCondition = new OrderCondition(condition.getPageNum(), ordersPage.getPageSize(),
                ordersPage.getTotal(), ordersPage.getPages());
        condition.setPageSize(ordersPage.getPageSize());
        condition.setTotal(ordersPage.getTotal());
        condition.setPages(ordersPage.getPages());

        long total = ordersPage.getTotal();
        System.out.println(total);

        map.put("ordersPage", ordersPage);
        map.put("orders", ordersPage.getResult());
        map.put("condition", condition);

        return map;
    }

    @RequestMapping("getEmployee")
    @ResponseBody
    public Employee getEmployee(HttpServletRequest request) {
        Employee name = (Employee) request.getSession().getAttribute("name");
        return name;

    }
}
