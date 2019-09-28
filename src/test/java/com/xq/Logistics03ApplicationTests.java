package com.xq;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.xq.bean.Employee;
import com.xq.bean.NoseOrder;
import com.xq.bean.OrderTransferInfoName;
import com.xq.dao.PageDao;
import com.xq.util.ExcelUtil;
import com.xq.util.IntegerIDUtils;
import com.xq.web.controller.NoseController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Logistics03ApplicationTests {
    @Autowired
    private NoseController controller;

    @Resource
    private PageDao pageDao;

    @Test
    public void sss(){
        Jedis jedis=new Jedis();
        Page<Employee> employees = pageDao.getPageAll();
        String s = JSON.toJSONString(employees);
        System.out.println(employees);
        System.out.println(s);

        jedis.set("ee", s);


        String ee = jedis.get("ee");
        Page parse = JSON.parseObject(ee, Page.class);
        System.out.println(parse);

        jedis.close();
    }


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

    @Test
    public void test() throws Exception {
        File file = new File("D:\\temp\\a.xls");

        Map<String, List<NoseOrder>> map = controller.selectTel("15171567184");
        List<OrderTransferInfoName> orderSend = map.get("orderSend").get(0).getInfos();

        System.out.println(orderSend);
        ExcelUtil.excelExport("123123",orderSend,file);



    }



}
