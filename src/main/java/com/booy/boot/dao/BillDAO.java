package com.booy.boot.dao;

import com.booy.boot.pojo.Bill;
import com.booy.boot.pojo.Provider;

import java.util.List;

public interface BillDAO {
    void addBill(Bill bill);

    Bill getBillById(Integer id);

    void updateBill(Bill bill);

    void deleteBillById(Integer id);

    List<Bill> getBillList(Bill bill);
}
