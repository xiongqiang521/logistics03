package com.xq.dao;

import com.xq.bean.Order;
import com.xq.bean.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ProjectName: logistics03
 * @Package: com.xq.dao
 * @ClassName: UserAddOrderDao
 * @Author: yaoxiaolei
 * @Description: ${description}
 * @Date: 2019/9/21 17:46
 * @Version: 1.0
 */
@Mapper
public interface UserAddOrderDao {
    /**
     * @Method
     * @Author yaoxiaolei
     * @Version  1.0
     * @Description


     */
    //添加寄件人信息
    @Insert("INSERT INTO users(user_id,name,password,create_time,state,telephone) VALUES (#{user_id},#{name},#{password},#{create_time},#{state},#{telephone})")
    void addSend(Users user);

    //添加收件人信息
    @Insert("INSERT INTO users(user_id,name,password,create_time,state,telephone) VALUES (#{user_id},#{name},#{password},#{create_time},#{state},#{telephone})")
    void addReceive(Users user);

/*
,order_id,send_time,send_user_id,send_address,receive_time,receive_user_id,receive_address,weight,money,order_state_id,
 */
    //添加订单信息
    @Insert("INSERT INTO `order` (order_id,send_time,send_user_id,send_address,receive_time,receive_user_id,receive_address,weight,money,order_state_id)" +
            " VALUES (#{order_id},#{send_time},#{send_user_id},#{send_address},#{receive_time},#{receive_user_id},#{receive_address},#{weight},#{money},#{order_state_id})")
    void addOrder(Order order);


}
