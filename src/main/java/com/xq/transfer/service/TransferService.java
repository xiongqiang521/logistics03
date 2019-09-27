package com.xq.transfer.service;

import com.xq.bean.OrderState;
import com.xq.bean.OrderTransferInfo;
import com.xq.bean.TransferCondition;
import com.xq.bean.TransferInfo;
import com.xq.util.PageBean;

import java.util.List;

public interface TransferService {
    //查询所有订单状态
    List<OrderState> findAllOrderState();

   /* //查询所有中转信息
    List<TransferInfo> findAll();*/

    PageBean findByPage(int currentPage,int pageSize);


    PageBean findTransferByConditionAndPage(int currentPage, int pageSize, TransferCondition condition);

    Integer findEmployeeIdByName(String employeeName);


    Integer findStationIdByName(String stationName);

    void addTransferInfo(OrderTransferInfo orderTransferInfo);

    List<TransferInfo> findTransferByCondition(TransferCondition condition);

    TransferInfo findTransferById(Integer id);

    void updateTransfer(OrderTransferInfo orderTransferInfo);

    void deleteTransfer(Integer id);
}
