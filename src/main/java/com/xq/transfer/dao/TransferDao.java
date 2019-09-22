package com.xq.transfer.dao;

import com.xq.bean.OrderState;
import com.xq.bean.TransferInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.HashMap;
import java.util.List;

/**
 * 中转信息dao层接口
 * order_transfer_info  :  中转信息表
 */
@Mapper
public interface TransferDao {

    //查询订单有几种状态
    @Select("select * from order_state")
    List<OrderState> findAllOrderState();

    //查询所有中转信息
    /*@Select("select * from order_transfer_info")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "mode",column = "mode"),
            @Result(property = "time",column = "time"),
            @Result(property = "order",column ="order_id",javaType = Order.class,one =@One(select = "com.xq.transfer.dao.TransferDao.findOrderByOrderId",fetchType = FetchType.DEFAULT))
    })
    List<TransferInfo> findAll();*/

    //根据订单id查询订单
    /*@Select("select * from `order` where order_id = #{order_id}")
    Order findOrderByOrderId(Integer id);*/


    //查询中转记录总数
    @Select("select count(1) from order_transfer_info")
    int selectCount();

    //通过起始记录，和记录size放到一个hashMap再封装到List里
    @SelectProvider(type = TransferDaoProvider.class, method = "findByPage")
    List<TransferInfo> findByPage(HashMap<String,Object> map);

    /*@SelectProvider(type = TransferDaoProvider.class, method = "selectCountByCondition")
    Integer selectCountByCondition(TransferCondition condition);

    @SelectProvider(type = TransferDaoProvider.class, method = "findTransferByConditionAndPage")
    List<TransferInfo> findTransferByConditionAndPage(HashMap<String, Object> map);*/

    class TransferDaoProvider {
        public String findByPage(HashMap<String,Object> map) {

            String sql=" select order_transfer_info.`id`,`order`.`order_id`,`mode`,`station`.`name` stationName,`employee`.`name` employeeName,`order_transfer_info`.`time` from order_transfer_info left join `order` on order_transfer_info.`order_id`=`order`.`order_id` left join `employee` on order_transfer_info.`employee_id`=`employee`.`employee_num` left join `station` on `order_transfer_info`.`station_id`=`station`.`station_num`";

            if(map.get("start")!=null && map.get("size")!=null ){
                sql += " limit #{start},#{size}";
            }
            return sql;
        }

        /*public String selectCountByCondition(TransferCondition condition) {
            String sql = "select * from order_transfer_info,order where 1=1";
            if(condition.getStartTime()!=null ){
                sql += " time >= #{time} ";
            }
            if(condition.getLastTime()!=null ){
                sql += " time <= #{time} ";
            }

            return sql;
        }*/
    }
}
