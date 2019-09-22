package com.xq.service;

import com.xq.bean.NoseOrder;
import com.xq.bean.Order;
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
     * 通过电话号码查找订单列表
     * @param tel
     * @return
     */
    List<Order> selectByTelephone(String tel);
}
