package com.xq.dao;/*
 *
 *
 */

import com.xq.bean.Car;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface CarDao {

    /*
        查询单个车辆信息
        SELECT car_user.car_num,car_user.exclusive,car_user.out_time,car_user.in_time,car_user.target car.state FROM " +
            "car,car_user WHERE car.car_num=car_user.car_num AND car_num=#{car_num}
     */
    @Select("select * from car where car_num=#{ss}")
    Car getOneCar(String car_num);

    /*
        查询所有车辆信息
     */
    @Select("SELECT * FROM car")
    List<Car> getAllCar();

    /*
        添加车辆
     */
    @Insert("INSERT INTO car(car_num,type,car.load) VALUES(#{car_num},#{type},#{load})")
    void addCar(Car car);

    /*
        修改车辆信息
     */
    @Update("UPDATE car SET car_num=#{car_num},type=#{type},car.load=#{load} WHERE car_num=#{car_num}")
    void updateCar(Car car);

    /*
        分页查询
     */
    List<Car> findAll();


}
