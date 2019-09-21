package com.xq.service;

import com.xq.bean.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/21 15:48
 */
public interface NoseService {
    // 通过订单号查找订单
    Order selectNum(Integer num);

    // 通过收件人手机号查找订单信息
    List<Order> selectByTelephone(String tel);
}
