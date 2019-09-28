package com.xq.service;/*
 *
 *
 */

import com.github.pagehelper.PageInfo;
import com.xq.bean.Car;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarService {

    /*
        查询单个车辆信息
     */
    Car getOneCar(String car_num);


    /*
        查询所有车辆信息
     */
    List<Car> getAllCar();

    /*
        添加车辆
     */
    void addCar(Car car);

    /*
        修改车辆信息
     */
    void updateCar(Car car);

    /*
        分页
     */
    PageInfo<Car> findAll(int page, int pagesize);
}
