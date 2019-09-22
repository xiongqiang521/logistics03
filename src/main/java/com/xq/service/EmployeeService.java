package com.xq.service;

import com.xq.bean.Employee;
import com.xq.bean.EmployeePojo;
import com.xq.bean.EmployeeState;
import com.xq.bean.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeService {

   //管理员添加
   void EmployeeRegist(EmployeePojo employee);

    //查询所有管理人员
    List<Employee> getAll();

    //验证登录
    Employee login(Integer name);

     //分页   当前总记录数
     Integer count();

    //分页当前页面数据
    List<Employee> pageAll();
}
