package com.xq.transfer.web.controller;

import com.xq.bean.TransferInfo;
import com.xq.transfer.service.TransferService;
import com.xq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("findByPage")
    public PageBean getPage(@RequestParam(defaultValue="1") int currentPage,@RequestParam(defaultValue="10")  int pageSize, HttpServletRequest request){
        PageBean pageBean= transferService.findByPage(currentPage,pageSize) ;
        return pageBean;
}
}
