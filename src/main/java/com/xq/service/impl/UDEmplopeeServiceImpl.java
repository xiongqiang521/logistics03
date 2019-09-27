package com.xq.service.impl;

import com.xq.bean.EmployeePojo;
import com.xq.dao.UpdateEmployeeDao;
import com.xq.service.UDEmplopeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UDEmplopeeServiceImpl implements UDEmplopeeService {
    //调用DAO层，UpdateEmployeeDao

    @Resource
    private UpdateEmployeeDao updateEmplopeeDao;
    //修改管理员
    @Override
    public void UpdateEmployee(EmployeePojo emploee) {
        updateEmplopeeDao.UpdateEmployee(emploee);
    }
    //删除管理员
    @Override
    public void DeleteEmployee(Integer employee_num) {
        updateEmplopeeDao.DeleteEmployee(employee_num);
    }
}

    

    
    