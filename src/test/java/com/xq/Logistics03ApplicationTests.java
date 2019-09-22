package com.xq;

import com.xq.util.IntegerIDUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// @RunWith(SpringRunner.class)
@SpringBootTest
public class Logistics03ApplicationTests {



    @Test
    public void contextLoads() {

    }

    /**
     * 测试并发下订单生成类
     */
    @Test
    public void contextLoads11() {
        new Thread(() -> {
            int[] is =new int[50000];
            for (int i = 0; i < 50000; i++) {
                int integer = (int)IntegerIDUtils.creatID();
                is[i]=integer;
                // System.out.println(integer);
                for (int i1 = 0; i1 < i - 1; i1++) {
                    if (integer==i1) {
                        System.out.println("----------------------------");
                    }
                }
            }
        });
    }



}
