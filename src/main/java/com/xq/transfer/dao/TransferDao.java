package com.xq.transfer.dao;

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

    //查询所有中转信息
    @Select("select * from order_transfer_info")
    List<TransferInfo> findAll();

    //查询中转记录总数
    @Select("select count(1) from order_transfer_info")
    int selectCount();

    //通过起始记录，和记录size放到一个hashMap再封装到List里
    @SelectProvider(type = TransferDaoProvider.class, method = "findByPage")
    List<TransferInfo> findByPage(HashMap<String,Object> map);

    class TransferDaoProvider {
        public String findByPage(HashMap<String,Object> map) {
            String sql = "select * from order_transfer_info";
            if(map.get("start")!=null && map.get("size")!=null ){
                sql += " limit #{start},#{size}";
            }
            return sql;
        }
    }
}
