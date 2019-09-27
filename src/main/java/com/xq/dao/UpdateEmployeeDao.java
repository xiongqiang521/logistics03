package com.xq.dao;


import com.xq.bean.Employee;
import com.xq.bean.EmployeePojo;
import com.xq.bean.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UpdateEmployeeDao {

    @Update("UPDATE `employee` SET employee_num=#{employee_num},name=#{name},password=#{password},sex=#{sex},telephone=#{telephone},state=#{state} where employee_num=#{employee_num}")
    void UpdateEmployee(EmployeePojo emploee);


    @Delete("DELETE FROM employee where employee_num=#{employee_num}")
    void DeleteEmployee(Integer employee_num);
}

