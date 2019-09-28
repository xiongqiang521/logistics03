package com.xq.web.controller;/*
 *
 *
 */

import com.github.pagehelper.PageInfo;
import com.xq.bean.Car;
import com.xq.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService service;


    /*
        查询单个车辆信息
     */
    @RequestMapping("/getOneCar")
    @ResponseBody
    public List<Car> getOneCar(@RequestParam String car_num){
        System.out.println(car_num);

        Car car = service.getOneCar(car_num);

        System.out.println("查询单个"+car);
        List<Car> list =new ArrayList<>();
        list.add(car);
        return list;
    }

    /*
        查询所有车辆信息
     */
    @RequestMapping("/getAllCar")
    @ResponseBody
    public List<Car> getAllCar(ModelAndView mv){
        List<Car> cars = service.getAllCar();
        mv.addObject("Car",cars);
        System.out.println(cars);
//        mv.setViewName("car-allList.html");
        return cars;
    }

    /*
        添加车辆
     */
    @RequestMapping("/addCar")
    @ResponseBody
    public Car addCar(Car car){
//        System.out.println(car);
        service.addCar(car);
        return car;
    }

    /*
        修改车辆
     */
    @RequestMapping("/updateCar")
    @ResponseBody
    public Car updateCar(Car car){
        service.updateCar(car);
        return car;
    }

    /*
        分页
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public String show(Model model, Integer pageNum) throws Exception{
        PageInfo<Car> info = service.findAll(pageNum==null?1:pageNum, 4);
        model.addAttribute("info",info);
        return "car-allList2.html";
    }
}
