package com.xq.service.impl;

import com.xq.bean.Employee;
import com.xq.bean.EmployeePojo;
import com.xq.bean.EmployeeState;
import com.xq.dao.EmployeeDao;
import com.xq.dao.EmployeeStateDao;
import com.xq.dao.PageDao;
import com.xq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao dao;

    @Resource
    private EmployeeStateDao stateDao;

    @Resource
    private PageDao pageDao;


    /**
     * 员工注册
     * @param employee
     */
    @Override
    @Transactional
    public void EmployeeRegist(EmployeePojo employee) {
        dao.EmployeeRegist(employee);
        stateDao.EmployeeStateRegister(employee);
    }

    /**
     * 员工查询
     * @return
     */
    @Override
    public List<Employee> getAll() {
        return dao.getAll();
    }

    /**
     * 员工登录
     * @param name
     * @return
     */
    @Override
    public Employee login(Integer name) {
        return dao.login(name);
    }

    /**
     * 当前员工的总数量
     * @return
     */
    @Override
    public Integer count() {
        return pageDao.count();
    }

    @Override
    public List<Employee> pageAll() {
        return pageDao.pageAll();
    }


}
