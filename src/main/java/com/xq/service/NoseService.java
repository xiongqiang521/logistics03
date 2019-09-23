package com.xq.service;

import com.xq.bean.NoseOrder;
import com.xq.bean.Order;
import com.xq.bean.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/21 15:48
 */
public interface NoseService {
    /**
     * 通过订单编号查询订单
     * @param num
     * @return
     */
    NoseOrder selectNum(Integer num);

    /**
     * 通过电话号码查找订单列表 收件人
     * @param user
     * @return
     */
    List<Order> selectBySendUser(Users user);

    /**
     * 通过电话号码查找订单列表     寄件人
     * @param user
     * @return
     */
    List<Order> selectByReceiveUser(Users user);

    /**
     * 通过号码查找用户
     * @param tel
     * @return
     */
    List<Users> selectTelephone(String tel);
}
