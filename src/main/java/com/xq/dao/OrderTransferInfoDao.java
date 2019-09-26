package com.xq.dao;

import com.xq.bean.OrderTransferInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/26 14:27
 */
@Mapper
public interface OrderTransferInfoDao{

    @Select("insert into `order_transfer_info`(order_id,mode,station_id,employee_id,time) VALUES(#{order_id},#{mode},#{station_id},#{employee_id},#{time})")
    void addOrderTransferInfo(OrderTransferInfo orderTransferInfo);
}
