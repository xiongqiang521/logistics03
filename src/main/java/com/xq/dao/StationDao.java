package com.xq.dao;

import com.xq.bean.Station;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 查询员工工作区域
 */
@Mapper
public interface StationDao {

    /**
     * 查询员工工作区域
     */
    @Select("select station_num,name from station")
    List<Station> getStationname();
}
