package com.xq.service;

import com.xq.bean.Employee;
import com.xq.bean.EmployeePojo;
import com.xq.bean.OrderUser;
import com.xq.bean.Users;

/**
 * @ProjectName: logistics03
 * @Package: com.xq.service
 * @ClassName: UserAddOrderService
 * @Author: yaoxiaolei
 * @Description: ${description}
 * @Date: 2019/9/21 17:17
 * @Version: 1.0
 */
public interface UDEmplopeeService {
    //修改管理员
    void UpdateEmployee(EmployeePojo emploee);
    //删除管理员
    void DeleteEmployee(Integer employee_num);

}
