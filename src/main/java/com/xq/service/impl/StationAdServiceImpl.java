package com.xq.service.impl;

import com.xq.bean.Station;

import com.xq.dao.StationAdDao;
import com.xq.service.StationAdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class StationAdServiceImpl implements StationAdService {

    @Resource
    private StationAdDao stationAdDao;
    /*
        查找站点地址
     */
    @Override
    public List<String> getStationaddress() {
        return stationAdDao.getStationaddress();

    }
}
