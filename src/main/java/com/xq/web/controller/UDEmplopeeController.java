package com.xq.web.controller;

import com.xq.bean.EmployeePojo;
import com.xq.service.UDEmplopeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UDEmplopeeController {
    //导入
    @Resource
    private UDEmplopeeService UpdateEmplopeeServiceImpl;



    @RequestMapping("/UpdateEmplopee")
    @ResponseBody
    public void updateEmplopee(EmployeePojo employee) throws ParseException {
        UpdateEmplopeeServiceImpl.UpdateEmployee(employee);
        System.out.println(employee);
    }

    @RequestMapping("/DeleteEmplopee")
//    @ResponseBody
    public void deleteEmplopee(String ids){
        String[] d=ids.split(",");
        for (int i = 0; i < d.length; i++) { // 编程式
            String id=d[i];
            System.out.println(id);
            Integer in_num=Integer.valueOf(id);
            UpdateEmplopeeServiceImpl.DeleteEmployee(in_num);
             }
    }









}
