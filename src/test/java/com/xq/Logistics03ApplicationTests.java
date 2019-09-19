package com.xq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Logistics03ApplicationTests {

    @RequestMapping("/adda")
    @Test
    public String contextLoads() {

        return "admin-add.html";


    }

}
