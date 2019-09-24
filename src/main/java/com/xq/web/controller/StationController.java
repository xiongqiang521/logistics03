package com.xq.web.controller;


import com.xq.bean.Station;
import com.xq.service.StationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StationController {

    @Resource
    private StationService service;


    @ModelAttribute
    public ModelAndView getStationname(ModelAndView mv){

        return mv;
    }
}
