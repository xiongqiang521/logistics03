package com.xq.dao;

import com.xq.bean.Order;
import com.xq.bean.OrderAll;
import com.xq.bean.OrderState;
import com.xq.bean.OrderTransferInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/21 15:51
 */
@Mapper
public interface OrderDao {
    /**
     * 通过订单号查找订单信息
     */
    @Select("select * from `order` where order_id=#{num}")
    Order selectByOrderId(Serializable num);

    /**
     * 通过收件人id查找订单信息
     */
    @Select("select * from `order` where receive_user_id=#{userId}")
    List<Order> selectByReceiveUserId(Serializable userId);

    /**
     * 通过寄件人id查找订单信息
     */
    @Select("select * from `order` where send_user_id=#{userId}")
    List<Order> selectBySendUserId(Serializable userId);

    /**
     * 通过订单号查询订单转运信息
     */
    @Select("select * from order_transfer_info where order_id=#{num}")
    List<OrderTransferInfo> selectInfoNum(Serializable num);

    /**
     * 查询订单状态
     */
    @Select("select * from order_state where id=#{id}")
    OrderState selectOrderState(Serializable id);

    /**
     * 查询所有订单
     */
    @Select("select * from `order`")
    List<Order> selectOrder();

    /**
     * 查询所有订单所有信息
     */
    @Select("select * from `order_all`")
    List<OrderAll> getOrders();
}
