package com.xq.dao;

import com.xq.bean.EmployeePojo;
import com.xq.bean.EmployeeState;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface EmployeeStateDao {

    /**
     * 根据员工Id查询数据
     * @param id
     * @return
     */
    @Select("select * from employee_state where id=#{id}")
    @Results(id = "getById",value = {
            @Result(column = "group",property = "group"),
            @Result(column = "group",property = "station",one = @One(select ="com.xq.dao.StationDao.getStationByStationId" ))
    })
    EmployeeState getById(Serializable id);


    /**
     *添加员工级别，及工作区域id
     */

    @Insert("INSERT INTO employee_state(id,employee_state.type,employee_state.group) VALUES(#{employee_num},#{type},#{station_num})")
    void EmployeeStateRegister(EmployeePojo employeePojo);


    /**
     * 登录查询
     */
    @Select("select * from employee_state where id=#{id}")
    EmployeeState getBylogin(Serializable id);



}
