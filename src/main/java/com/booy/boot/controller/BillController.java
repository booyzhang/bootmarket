package com.booy.boot.controller;

import com.booy.boot.pojo.Bill;
import com.booy.boot.service.BillService;
import com.booy.boot.service.ProviderService;
import com.booy.boot.utils.ResultData;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private ProviderService providerService;

    @RequestMapping("billList.html")
    public String list(Bill bill,Integer pageNum, Model model){
        if(pageNum==null || pageNum<1){
            pageNum=1;
        }
        PageInfo<Bill> pageInfo = billService.getBillList(bill, pageNum, 2);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("providers",providerService.getProviderName());
        return "billList";
    }

    //修改页面回填
    @RequestMapping("goBillEdit.html")
    public String edit(Integer id,Model model){
        model.addAttribute("providers",providerService.getProviderName());
        if(id!=null){
            Bill bill = billService.getBillById(id);
            model.addAttribute("bill",bill);
        }
        return "billEdit";
    }

    //添加修改
    @RequestMapping("doBillEdit.html")
    public String edit(Bill bill,Model model) {
        System.out.println(bill);
        if(bill.getId()==null){
            ResultData res = billService.addBill(bill);
            if(res.getStatus()){
                return "redirect:billList.html";
            }
            model.addAttribute("message",res.getMessage());
        }else{
            ResultData res = billService.updateBill(bill);
            if(res.getStatus()){
                return "redirect:billList.html";
            }
            model.addAttribute("message",res.getMessage());
        }
        return "billEdit";
    }

    //删除
    @RequestMapping("deleteBill.html")
    public String del(Integer id,Model model){
        if(id!=null){
            ResultData res = billService.deleteBillById(id);
            model.addAttribute("message",res.getMessage());
        }
        return "redirect:billList.html";
    }
}
