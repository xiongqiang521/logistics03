package com.xq.service;

import com.xq.bean.EmployeePojo;
import com.xq.bean.EmployeeState;
import org.apache.ibatis.annotations.Insert;

import java.io.Serializable;

public interface EmployeeStateService {

    /**
     *添加员工级别，及工作区域id
     */
    void EmployeeStateRegister(EmployeePojo employeePojo);


}
