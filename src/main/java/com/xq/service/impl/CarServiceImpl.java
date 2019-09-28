package com.xq.service.impl;/*
 *
 *
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.bean.Car;
import com.xq.dao.CarDao;
import com.xq.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Resource
    private CarDao dao;

    @Override
    public Car getOneCar(String car_num) {
        Car oneCar = dao.getOneCar(car_num);
        if (oneCar == null) {
            return null;
        }
        if (oneCar.getState().equals("0")) {
//            oneCar.getState().replace("0", "未使用");
              oneCar.setState("未使用");
        } else if (oneCar.getState().equals("1")) {
//            oneCar.getState().replace("1", "使用中");
              oneCar.setState("使用中");
        }
        System.out.println(oneCar.getCar_num().length());
        return oneCar;
    }

//    public static void main(String[] args) {
//        String car = "鄂A12345";
//        System.out.println(car.length());
//
//    }

    @Override
    public List<Car> getAllCar() {
        return dao.getAllCar();
    }

    @Override
    public void addCar(Car car) {
//        Car car1 = dao.addCar(car);
        if (car.getCar_num().length()==7 && car.getCar_num()!=null) {

        }else{
            throw new RuntimeException("车牌号输入有误");
        }
        if (car.getLoad()==null && car.getLoad()==0) {
             new RuntimeException("载重未填写");
        }
        if (car.getLoad() > 0 && car.getLoad() <= 200) {
//            car.getType().replace("", "Buggy");
            car.setType("Buggy");
        } else if (car.getLoad() > 200 && car.getLoad() <= 1000) {
//            car.getType().replace("","Truck");
            car.setType("Truck");
        }
//        car.getState().replace("","0");
//            car.setType("0");
        dao.addCar(car);
    }

    @Override
    public void updateCar(Car car) {
        dao.updateCar(car);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public PageInfo<Car> findAll(int page, int pagesize) {
        //1.启动分页
        PageHelper.startPage(page,pagesize);
        //2.调用查询所有
        List<Car> list = dao.findAll();
        //3.获取分页数据
        PageInfo<Car> info = new PageInfo<>(list);
        return info;
    }


}



