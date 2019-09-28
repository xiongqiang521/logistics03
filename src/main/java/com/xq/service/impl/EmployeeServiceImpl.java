package com.xq.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xq.bean.Employee;
import com.xq.bean.EmployeePojo;
import com.xq.dao.EmployeeDao;
import com.xq.dao.EmployeeStateDao;
import com.xq.dao.PageDao;
import com.xq.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

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

    // 添加redis
    private static Jedis jedis=new Jedis();


    /**
     * 员工注册
     *
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
     *
     * @return
     */
    @Override
    public List<Employee> getAll() {
        return dao.getAll();
    }

    /**
     * 员工登录
     *
     * @param name
     * @return
     */
    @Override
    public Employee login(Integer name) {
        return dao.login(name);
    }


    @Override
    public Page<Employee> getPageAll(Integer pageNum, Integer pageSize) throws Exception {
        // ObjectMapper mapper = new ObjectMapper();
        // String getPageAll = jedis.get("getPageAll" + pageNum + pageSize);
        // Page<Employee> pageAll=null;
        // if (getPageAll != null && !"".equals(getPageAll)) {
        //     pageAll = mapper.readValue(getPageAll, Page.class);
        // }else {
        //     PageHelper.startPage(pageNum, pageSize);
        //     pageAll = pageDao.getPageAll();
        //     String s = mapper.writeValueAsString(pageAll);
        //     System.out.println(s);
        //     jedis.set("getPageAll" + pageNum + pageSize ,s);
        // }

        PageHelper.startPage(pageNum, pageSize);
        Page<Employee> pageAll = pageDao.getPageAll();




        return pageAll;
    }


    /**
     * 条件查询
     *
     * @return
     */
    @Override
    public Page<Employee> getPageByName() {
        Page<Employee> pageAll = pageDao.getPageAll();
        return pageAll;
    }


}
