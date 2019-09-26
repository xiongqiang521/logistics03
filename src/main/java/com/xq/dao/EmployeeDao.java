package com.xq.dao;


import com.xq.bean.*;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface EmployeeDao {

    //管理員注册
   @Insert("INSERT INTO employee(employee_num,name,password,sex,telephone,state) VALUES(#{employee_num},#{name},#{password},#{sex},#{telephone},#{state})")
    void EmployeeRegist(EmployeePojo employee);

   //查询所有管理人员
   @Select("SELECT * from employee")
   @Results(id = "getAll",value = {
           @Result(column = "employee_num",property = "employee_num"),
           @Result(column = "employee_num",property = "employeeState",one = @One(select ="com.xq.dao.EmployeeStateDao.getById" ))
   })
   List<Employee> getAll();

    //验证登录
    @Select("SELECT * from employee where name=#{name}")
    @Results(id = "emMap",value = {
            @Result(column = "state",property = "state"),
            @Result(column = "state",property = "employeeState",one = @One(select ="com.xq.dao.EmployeeStateDao.getById" ))
    })
    Employee login(String name);

    //根据id查询管理人员
    @Select("SELECT * from employee where employee_num=#{num}")
    @Results(id = "getAll",value = {
            @Result(column = "state",property = "state"),
            @Result(column = "state",property = "employeeState",one = @One(select ="com.xq.dao.EmployeeStateDao.getById" ))
    })
    Employee getEmployeeByNum(Integer num);
}
