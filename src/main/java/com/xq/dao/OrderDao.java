package com.xq.dao;

import com.xq.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/21 15:51
 */
@Mapper
public interface OrderDao {
    // 通过订单号查找订单信息
    @Select("select * from `order` where order_id=#{num}")
    Order selectByOrderId(Integer num);


    // 通过收件人id查找订单信息
    // @Select("select * from `order` where receive_user_id=#{userId}")
    // List<Order> selectByReceiveUserId(String userId);
    // 通过收件人id查找订单信息
    @Select("select * from `order` where receive_user_id=#{userId}")
    List<Order> selectByReceiveUserId(Long userId);

    // 通过寄件人id查找订单信息
    @Select("select * from `order` where send_user_id=#{userId}")
    List<Order> selectBySendUserId(Long userId);


}
