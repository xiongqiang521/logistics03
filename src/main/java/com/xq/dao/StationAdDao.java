package com.xq.dao;

import com.xq.bean.Station;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;

/**
 * 查询员工工作区域
 */
@Mapper
public interface StationAdDao {

    /**
     * 查询所有站点地址
     */
    @Select("select address from station")
    List<String> getStationaddress();


}
