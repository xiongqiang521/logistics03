package com.xq.dao;

import com.xq.bean.EmployeeState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface EmployeeStateDao {

    @Select("select * from employee_state where id=#{id}")
    EmployeeState getById(Serializable id);


}
