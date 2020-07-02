package com.booy.boot.service;

import com.booy.boot.pojo.Bill;
import com.booy.boot.utils.ResultData;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BillService {
    //添加供应商
    ResultData addBill(Bill bill);

    //修改数据回填
    Bill getBillById(Integer id);

    //修改供应商
    ResultData updateBill(Bill bill);

    //删除供应商
    ResultData deleteBillById(Integer id);

    //条件检索
    PageInfo<Bill> getBillList(Bill bill,Integer pageNum,Integer pageSize);
}
