package com.xq.service;

import com.xq.bean.Order;
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
public interface UserAddOrderService {

    //添加寄件人信息到数据库
    void setSend(Users user);
    //添加收件人信息到数据库
    void setRecevie(Users user);
    //添加订单信息到数据库
    void setOrder(Order order);


}
