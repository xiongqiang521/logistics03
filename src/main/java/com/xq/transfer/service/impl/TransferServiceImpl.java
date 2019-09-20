package com.xq.transfer.service.impl;

import com.xq.bean.TransferInfo;
import com.xq.transfer.dao.TransferDao;
import com.xq.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    private TransferDao transferDao;
    @Override
    public List<TransferInfo> findAll() {
        return transferDao.findAll();
    }
}
