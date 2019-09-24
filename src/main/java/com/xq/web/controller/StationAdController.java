package com.xq.web.controller;



import com.xq.bean.Order;
import com.xq.service.StationAdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StationAdController {

    @Resource
    private StationAdService stationAdService;
    /*
        查找所有站点名
     */
    @RequestMapping("Stationaddress")
    @ResponseBody
    public List<String> getStationaddress(){
        List<String> stationaddress=stationAdService.getStationaddress();
        return stationaddress;
    }
}
