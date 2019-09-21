package com.xq.transfer.service;

import com.xq.bean.TransferInfo;
import com.xq.util.PageBean;

import java.util.List;

public interface TransferService {

    //查询所有中转信息
    List<TransferInfo> findAll();

    public PageBean findByPage(int currentPage,int pageSize);
}
