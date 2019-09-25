package com.xq.service.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.xq.bean.*;
import com.xq.dao.OrderDao;
import com.xq.dao.StationDao;
import com.xq.dao.UserDao;
import com.xq.service.NoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/21 15:48
 */
@Service
public class NoseServiceImpl implements NoseService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private OrderDao orderDao;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDao userDao;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private StationDao stationDao;


    /**
     * 通过电话号码查找订单列表     寄件人
     * @param user
     * @return
     */
    @Override
    public List<Order> selectByReceiveUser(Users user) {

        // 通过用户查找订单列表
        List<Order> orders = orderDao.selectByReceiveUserId(user.getId());


        return orders;
    }
    /**
     * 通过电话号码查找订单列表     收件人
     * @param user
     * @return
     */
    @Override
    public List<Order> selectBySendUser(Users user) {

        // 通过用户查找订单列表
        List<Order> orders = orderDao.selectBySendUserId(user.getId());

        return orders;
    }

    @Override
    public List<Users> selectTelephone(String tel){
        List<Users> users = userDao.selectTelephone(tel);
        return users;
    }

    /**
     * 通过订单编号查询订单
     * @param num
     * @return
     */
    @Override
    @Transactional
    public NoseOrder selectNum(Integer num) {
        Order order = orderDao.selectByOrderId(num);
        // 健壮性判断
        if (order == null) {
            return null;
        }

        NoseOrder noseOrder=new NoseOrder();

        OrderState orderState = orderDao.selectOrderState(order.getOrder_state_id());

        noseOrder.setMoney(order.getMoney());
        noseOrder.setOrder_id(order.getOrder_id());
        noseOrder.setReceive_address(order.getReceive_address());
        noseOrder.setReceive_time(order.getReceive_time());
        noseOrder.setSend_address(order.getSend_address());
        noseOrder.setSend_time(order.getSend_time());
        noseOrder.setWeight(order.getWeight());


        noseOrder.setOrderState(orderState);
        noseOrder.setReceive_user(userDao.selectById(order.getReceive_user_id()));
        noseOrder.setSend_user(userDao.selectById(order.getSend_user_id()));


        List<OrderTransferInfoName> names=new ArrayList<>();
        // 查询订单的转运详情
        List<OrderTransferInfo> infos=orderDao.selectInfoNum(num);
        // 查询订单的地点
        for (OrderTransferInfo info : infos) {
            OrderTransferInfoName orderTransferInfoName=new OrderTransferInfoName();
            Integer station_id = info.getStation_id();
            Station station= stationDao.getStationByStationId(station_id);
            orderTransferInfoName.setMode(info.getMode());
            orderTransferInfoName.setTime(info.getTime());
            orderTransferInfoName.setStationName(station.getName());
            orderTransferInfoName.setAddress(station.getAddress());


            names.add(orderTransferInfoName);

        }
        noseOrder.setInfos(names);

        // 封装至NoseOrder类中
        return noseOrder;
    }



}
