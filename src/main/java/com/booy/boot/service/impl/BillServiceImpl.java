package com.booy.boot.service.impl;

import com.booy.boot.dao.BillDAO;
import com.booy.boot.pojo.Bill;
import com.booy.boot.service.BillService;
import com.booy.boot.utils.ResultData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDAO billDAO;

    @Override
    public ResultData addBill(Bill bill) {
        try {
            bill.setCreateDate(new Date());
            billDAO.addBill(bill);
            return new ResultData(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultData(false,"添加失败！");
        }

    }

    @Override
    public Bill getBillById(Integer id) {
        return billDAO.getBillById(id);
    }

    @Override
    public ResultData updateBill(Bill bill) {
        try {
            billDAO.updateBill(bill);
            return new ResultData(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultData(false,"修改失败！");
        }
    }

    @Override
    public ResultData deleteBillById(Integer id) {
        try {
            billDAO.deleteBillById(id);
            return new ResultData(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultData(false,"删除失败！");
        }
    }

    @Override
    public PageInfo<Bill> getBillList(Bill bill, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Bill> billPageInfo = new PageInfo<>(billDAO.getBillList(bill));
        return billPageInfo;
    }
}
