package com.xq.service.impl;

import com.xq.bean.Employee;
import com.xq.dao.EmployeeDao;
import com.xq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    @Override
    public void EmployeeRegist(Employee employee) {
        dao.EmployeeRegist(employee);
    }

    @Override
    public List<Employee> getAll() {
        return dao.getAll();
    }

    @Override
    public Employee login(String name) {
        return dao.login(name);
    }
}
