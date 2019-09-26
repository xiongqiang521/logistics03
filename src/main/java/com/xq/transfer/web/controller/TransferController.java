package com.xq.transfer.web.controller;

import com.xq.bean.OrderTransferInfo;
import com.xq.bean.TransferCondition;
import com.xq.bean.TransferInfo;
import com.xq.transfer.service.TransferService;
import com.xq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 中转管理的controller
 */
@Controller
public class TransferController {
    @Autowired
    private TransferService transferService;

    //获取订单有哪些状态
    /*@RequestMapping("findAllOrderState")
    public List<OrderState> findAllOrderState(){
        List<OrderState> orderStateList = transferService.findAllOrderState();
        System.out.println(orderStateList);
        return orderStateList;
    }*/

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
  /* @RequestMapping("findAllByPage")
    public PageBean getPage(@RequestParam(defaultValue="1") int currentPage,@RequestParam(defaultValue="10")  int pageSize, HttpServletRequest request){
        PageBean pageBean= transferService.findByPage(currentPage,pageSize) ;
        return pageBean;
    }*/
    @RequestMapping("findByPage")
    public ModelAndView findByPage(@RequestParam(defaultValue="1") int currentPage, @RequestParam(defaultValue="6")  int pageSize, ModelAndView mv) {
        System.out.println("findByPage");
       PageBean pageBean = transferService.findByPage(currentPage, pageSize);

        mv.addObject("pageBean",pageBean);
        mv.addObject("condition",new TransferCondition());
        mv.setViewName("transitinfo-list");
        return mv;
    }
    //多条件分页查询
    @RequestMapping("findTransferByConditionAndPage")
    public ModelAndView findTransferByConditionAndPage(@RequestParam(defaultValue="1") int currentPage, @RequestParam(defaultValue="6")  int pageSize, TransferCondition condition, HttpServletRequest request,ModelAndView mv){
        PageBean pageBean;
        System.out.println("前台传来的condition:"+condition);
        System.out.println("session中的condition:"+request.getSession().getAttribute("condition"));
        if ("".equals(condition.getStartTime()) &&"".equals(condition.getLastTime()) &&"".equals(condition.getStationName()) &&"".equals(condition.getOrderId()) && request.getSession().getAttribute("condition")==null){
            pageBean = transferService.findByPage(currentPage, pageSize);
            mv.addObject("pageBean",pageBean);
            mv.setViewName("transitinfo-list");
            System.out.println(333);
            System.out.println(pageBean);
            return mv;
        }
        // if (condition==null && request.getSession().getAttribute("condition")!=null){
        //     System.out.println(444);
        //     condition = (TransferCondition)request.getSession().getAttribute("condition");
        // }else {
        //     System.out.println(555);
        //     request.getSession().setAttribute("condition",condition);
        // }
        pageBean=transferService.findTransferByConditionAndPage(currentPage,pageSize,condition) ;
        System.out.println("66666:"+condition);
        mv.addObject("pageBean",pageBean);
        mv.addObject("condition",condition);

        mv.setViewName("transitinfo-list");
        return mv;
    }
    @RequestMapping("addTransferInfo")
    public ModelAndView addTransferInfo(TransferInfo transferInfo){
        System.out.println(transferInfo);
        //获取参数
        String employeeName = transferInfo.getEmployeeName();
        String stationName = transferInfo.getStationName();
        //通过名称查询对象id
        Integer employee_id = transferService.findEmployeeIdByName(employeeName);
        Integer station_id = transferService.findStationIdByName(stationName);

        OrderTransferInfo orderTransferInfo = new OrderTransferInfo();

        //封装orderTransferInfo对象数据
        orderTransferInfo.setOrder_id(transferInfo.getOrder_id());
        orderTransferInfo.setMode(transferInfo.getMode());
        orderTransferInfo.setEmployee_id(employee_id);
        orderTransferInfo.setStation_id(station_id);
        orderTransferInfo.setTime(transferInfo.getTime());
        //添加出入库信息
        transferService.addTransferInfo(orderTransferInfo);
        System.out.println(101);
        ModelAndView mv=new ModelAndView();
        mv = findByPage(1, 6, mv);

        return mv;

    }
}
