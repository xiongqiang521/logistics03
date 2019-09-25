package com.xq.service;

import com.github.pagehelper.Page;
import com.xq.bean.Employee;
import com.xq.bean.EmployeePojo;

import java.util.List;

public interface EmployeeService {

   //管理员添加
   void EmployeeRegist(EmployeePojo employee);

    //查询所有管理人员
    List<Employee> getAll();

    //验证登录
    Employee login(Integer name);

    //分页查询
    Page<Employee> getPageAll(Integer pageNum , Integer pageSize);

    //条件查询
    Page<Employee> getPageByName();

}
