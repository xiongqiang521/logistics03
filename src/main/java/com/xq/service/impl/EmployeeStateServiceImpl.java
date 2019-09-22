package com.xq.service.impl;

import com.xq.bean.EmployeePojo;
import com.xq.bean.EmployeeState;
import com.xq.dao.EmployeeStateDao;
import com.xq.service.EmployeeStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

@Service
public class EmployeeStateServiceImpl implements EmployeeStateService {

    @Resource
    private EmployeeStateDao dao;

    @Override
    public void EmployeeStateRegister(EmployeePojo employeePojo) {
        dao.EmployeeStateRegister(employeePojo);

    }


}
