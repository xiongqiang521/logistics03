package com.xq.transfer.web.controller;

import com.xq.bean.OrderTransferInfo;
import com.xq.bean.TransferCondition;
import com.xq.bean.TransferInfo;
import com.xq.transfer.service.TransferService;
import com.xq.util.PageBean;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    @ResponseBody
    public String addTransferInfo(TransferInfo transferInfo){
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
//        ModelAndView mv=new ModelAndView();
//        mv = findByPage(1, 6, mv);

        return "success";

    }

    //导出excel报表
    @RequestMapping("exportXls")
    public String exportXls(TransferCondition condition, HttpServletRequest request, HttpServletResponse response) throws Exception{
        //查询要生成表格的数据
        List<TransferInfo> exportXlsList = transferService.findTransferByCondition(condition);
        System.out.println(1112);
        System.out.println(exportXlsList);
        //创建HSSFWorkbook对象
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //创建excel的工作表sheet
        HSSFSheet sheet = hssfWorkbook.createSheet("中转配送信息");
        //设置表头
        HSSFRow headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("运单号");
        headRow.createCell(1).setCellValue("出入库状态");
        headRow.createCell(2).setCellValue("站点名称");
        headRow.createCell(3).setCellValue("操作员姓名");
        headRow.createCell(4).setCellValue("操作时间");
        //插入数据
        for(TransferInfo transferInfo:exportXlsList){
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            //System.out.println("每一条transferInfo:"+transferInfo);
            dataRow.createCell(0).setCellValue(transferInfo.getOrder_id());
            dataRow.createCell(1).setCellValue(transferInfo.getMode());
            dataRow.createCell(2).setCellValue(transferInfo.getStationName());
            dataRow.createCell(3).setCellValue(transferInfo.getEmployeeName());
            dataRow.createCell(4).setCellValue(transferInfo.getTime());
        }
        //设置下载的2个头一个流
        //ContentType和Header
        response.setContentType("application/vnd.ms-excel");
        //设置导出的文件文件名
        String filename="order_transfer_info.xls";
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        //下载导出
        ServletOutputStream outputStream = response.getOutputStream();
        hssfWorkbook.write(outputStream);

        //关闭资源
        hssfWorkbook.close();
        return null;
    }

    //根据id查询对应的中转信息
    @RequestMapping("findTransferById")
    public ModelAndView findTransferById(Integer id){
        System.out.println(id);
        ModelAndView modelAndView=new ModelAndView();
        TransferInfo transferInfo=transferService.findTransferById(id);
        //解决从数据库中取出的时间后面多了毫秒值的文件("去掉.0")
        transferInfo.setTime(transferInfo.getTime().substring(0,transferInfo.getTime().length()-2));
        System.out.println("transferInfo测试:"+transferInfo);
        modelAndView.addObject("transferInfo",transferInfo);
        modelAndView.setViewName("transitinfo-edit.html");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("updateTransfer")
    public String updateTransfer(TransferInfo transferInfo){
        String stationName = transferInfo.getStationName();
        String employeeName = transferInfo.getEmployeeName();

        Integer employee_id = transferService.findEmployeeIdByName(employeeName);
        Integer station_id = transferService.findStationIdByName(stationName);

        //封装transferInfo
        OrderTransferInfo orderTransferInfo = new OrderTransferInfo();
        orderTransferInfo.setId(transferInfo.getId());
        orderTransferInfo.setOrder_id(transferInfo.getOrder_id());
        orderTransferInfo.setMode(transferInfo.getMode());
        orderTransferInfo.setEmployee_id(employee_id);
        orderTransferInfo.setStation_id(station_id);
        orderTransferInfo.setTime(transferInfo.getTime());
        System.out.println("44444:"+transferInfo.getTime());
        System.out.println("orderTransferInfo_________"+orderTransferInfo);
        transferService.updateTransfer(orderTransferInfo);
        return null;
    }

    //删除中转信息(慎用)
    @RequestMapping("deleteTransfer")
    @ResponseBody
    public String deleteTransfer(Integer id){
        System.out.println(933);
        transferService.deleteTransfer(id);
        return "success";
    }
}
