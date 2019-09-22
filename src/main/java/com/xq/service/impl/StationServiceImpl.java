package com.xq.service.impl;

import com.xq.bean.EmployeePojo;
import com.xq.bean.EmployeeState;
import com.xq.bean.Station;
import com.xq.dao.StationDao;
import com.xq.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StationServiceImpl implements StationService {

    @Resource
    private StationDao stationDao;



    @Override
    public List<Station> getStationname() {
        return stationDao.getStationname();
    }



}
