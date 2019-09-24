package com.xq.service;

import com.xq.bean.Order;
import com.xq.bean.OrderUser;
import com.xq.bean.Users;
import org.apache.catalina.User;

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

    //根据电话号码，查询数据库是否存在，如果有，则查询其他数据，用户名。变更则修改
    //没有则添加。先查询寄件人，再修改
    Users selUserTel(OrderUser orderUser);

    //查询 收件人
    Users rselUserTel(OrderUser orederUser);



    //修改
    void upUser(Users user);


    //添加寄件人信息到数据库
    void setSend(Users user);

    //添加收件人信息到数据库
    void setRecevie(Users user);

    //添加订单信息到数据库
    void setOrder(OrderUser order);


}
