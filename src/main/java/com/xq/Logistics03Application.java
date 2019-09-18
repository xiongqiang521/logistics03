package com.xq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xq.dao")
public class Logistics03Application {

    public static void main(String[] args) {
        SpringApplication.run(Logistics03Application.class, args);
    }

}
