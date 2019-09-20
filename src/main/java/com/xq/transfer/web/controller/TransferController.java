package com.xq.transfer.web.controller;

import com.xq.bean.TransferInfo;
import com.xq.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 中转管理的controller
 */
@RestController
public class TransferController {
    @Autowired
    private TransferService transferService;
     //pages/transit/transitinfo.html
    @RequestMapping("findAll")
    public List<TransferInfo> findAll(){
        System.out.println(11111);

        List<TransferInfo> list = transferService.findAll();

        System.out.println(list);
        return list;
    }

}
