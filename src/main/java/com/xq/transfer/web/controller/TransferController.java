package com.xq.transfer.web.controller;

import com.xq.bean.OrderState;
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

    //获取订单有哪些状态
    @RequestMapping("findAllOrderState")
    public List<OrderState> findAllOrderState(){
        List<OrderState> orderStateList = transferService.findAllOrderState();
        System.out.println(orderStateList);
        return orderStateList;
    }

    //pages/transit/transitinfo.html
    /*@RequestMapping("findAll")
    public List<TransferInfo> findAll(){
        System.out.println(11111);

        List<TransferInfo> list = transferService.findAll();

        System.out.println(list);
        return list;
    }
*/
    //分页
    @RequestMapping("findByPage")
    public PageBean getPage(@RequestParam(defaultValue="1") int currentPage,@RequestParam(defaultValue="10")  int pageSize, HttpServletRequest request){
        PageBean pageBean= transferService.findByPage(currentPage,pageSize) ;
        return pageBean;
    }

    //多条件分页查询
    /*@RequestMapping("findTransferByConditionAndPage")
    public PageBean findTransferByConditionAndPage(@RequestParam(defaultValue="1") int currentPage, @RequestParam(defaultValue="10")  int pageSize, TransferCondition condition){
        PageBean pageBean=transferService.findTransferByConditionAndPage(currentPage,pageSize,condition) ;
        return pageBean;
    }*/
}
