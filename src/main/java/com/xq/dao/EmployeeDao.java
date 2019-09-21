package com.xq.dao;


import com.xq.bean.Employee;
import com.xq.bean.EmployeeState;
import com.xq.bean.Station;
import com.xq.bean.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeDao {

    //管理員注册
   @Insert("INSERT INTO employee(employee_num,name,password,sex,telephone,state) VALUES(#{employee_num},#{name},#{password},#{sex},#{telephone},#{state})")
    void EmployeeRegist(Employee employee);

   //查询所有管理人员
   @Select("SELECT * from employee")
   @Results(id = "getAll",value = {
           @Result(column = "employee_num",property = "employee_num"),
           @Result(column = "employee_num",property = "employeeState",one = @One(select ="com.xq.dao.EmployeeStateDao.getById" ))
   })
   List<Employee> getAll();

    //验证登录
    @Select("SELECT * from employee where employee_num=#{name}")
    @Results(id = "emMap",value = {
            @Result(column = "employee_num",property = "employee_num"),
            @Result(column = "employee_num",property = "employeeState",one = @One(select ="com.xq.dao.EmployeeStateDao.getById" ))
    })
    Employee login(Integer name);





}
