package com.xq.dao;


import com.github.pagehelper.Page;
import com.xq.bean.Employee;
import com.xq.bean.EmployeePojo;
import com.xq.bean.Station;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PageDao {


      //分页
    @Select("select * from employee")
    @Results(id = "getAll",value = {
            @Result(column = "employee_num",property = "employee_num"),
            @Result(column = "employee_num",property = "employeeState",one = @One(select ="com.xq.dao.EmployeeStateDao.getById" ))
    })
    Page<Employee> getPageAll();


}
