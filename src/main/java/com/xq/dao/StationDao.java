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
public interface StationDao {

    /**
     * 查询员工工作区域，用作下拉列表
     */
    @Select("select station_num,name from station")
    List<Station> getStationname();

    /**
     * 查询员工所有信息，用作显示数据
     * @param station_num
     * @return
     */
    @Select("select station_num,name from station where station_num=#{station_num}")
    List<Station> getStationAll(Serializable station_num);




    @Select("select * from station where station_num=#{id}")
    Station getStationByStationId(Serializable id);
}
