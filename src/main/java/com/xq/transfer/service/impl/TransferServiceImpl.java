package com.xq.transfer.service.impl;

import com.xq.bean.OrderState;
import com.xq.bean.OrderTransferInfo;
import com.xq.bean.TransferCondition;
import com.xq.bean.TransferInfo;
import com.xq.transfer.dao.TransferDao;
import com.xq.transfer.service.TransferService;
import com.xq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * 中转业务service实现层
 */
@Service
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
public class TransferServiceImpl implements TransferService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TransferDao transferDao;



    @Override
    public List<OrderState> findAllOrderState() {
        return transferDao.findAllOrderState();
    }

   /* @Override
    public List<TransferInfo> findAll() {
        return transferDao.findAll();
    }*/

    @Override
    public PageBean findByPage(int currentPage,int pageSize) {
        HashMap<String,Object> map=new HashMap();
        PageBean<TransferInfo> pageBean=new PageBean<TransferInfo>();
        //封装当前页数
        pageBean.setCurrentPage(currentPage);
        //每页显示的数据
        pageBean.setPageSize(pageSize);
        //封装总记录数
        Integer totalCount = transferDao.selectCount();
        pageBean.setTotalCount(totalCount.longValue());
        //封装总页数
        double count=totalCount;
        Double num=Math.ceil(count/pageSize);
        pageBean.setTotalPage(num.intValue());          //转换为整数
        map.put("start", (currentPage-1)*pageSize);     //起始的记录值b
        map.put("size", pageBean.getPageSize());        //获取每个页面的pageSize
        List<TransferInfo> list=transferDao.findByPage(map);
        pageBean.setList(list);
        System.out.println(list);
        return pageBean;
    }

    @Override
    public PageBean findTransferByConditionAndPage(int currentPage, int pageSize, TransferCondition condition) {

        System.out.println("service:"+condition);
        HashMap<String,Object> map=new HashMap();
        PageBean pageBean=new PageBean();
        //封装当前页数
        pageBean.setCurrentPage(currentPage);
        //每页显示的数据
        pageBean.setPageSize(pageSize);
        //封装总记录数
        Integer totalCount = transferDao.selectCountByCondition(condition);
        pageBean.setTotalCount(totalCount.longValue());
        //封装总页数
        double count=totalCount;
        Double num=Math.ceil(count/pageSize);
        pageBean.setTotalPage(num.intValue());          //转换为整数
        map.put("start", (currentPage-1)*pageSize);     //起始的记录值b
        map.put("size", pageBean.getPageSize());        //获取每个页面的pageSize
        map.put("condition",condition);
        List<TransferInfo> list=transferDao.findTransferByConditionAndPage(map);
        System.out.println("查询出来的数据条数: " + list.size());
        pageBean.setList(list);
        return pageBean;

    }

    //根据员工姓名查询员工id
    @Override
    public Integer findEmployeeIdByName(String employeeName) {

        return transferDao.findEmployeeIdByName(employeeName);
    }

    @Override
    public Integer findStationIdByName(String stationName) {
        return transferDao.findStationIdByName(stationName);
    }

    @Override
    public void addTransferInfo(OrderTransferInfo orderTransferInfo) {
        transferDao.addTransferInfo(orderTransferInfo);
    }

    @Override
    public List<TransferInfo> findTransferByCondition(TransferCondition condition) {
        HashMap<String,Object> map=new HashMap();
        map.put("condition",condition);
        return transferDao.findTransferByConditionAndPage(map);
    }

    @Override
    public TransferInfo findTransferById(Integer id) {
        return transferDao.findTransferById(id);
    }

    @Override
    public void updateTransfer(OrderTransferInfo orderTransferInfo) {
        transferDao.updateTransfer(orderTransferInfo);
    }

    @Override
    public void deleteTransfer(Integer id) {
        transferDao.deleteTransfer(id);
    }
}
