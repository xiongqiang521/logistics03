package com.xq.transfer.dao;

import com.xq.bean.TransferInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
