package com.booy.boot.controller;

import com.booy.boot.pojo.Provider;
import com.booy.boot.service.ProviderService;
import com.booy.boot.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @RequestMapping("providerList.html")
    public String list(String name, Model model){
        List<Provider> providerList = providerService.getProviderList(name);
        model.addAttribute("providerList",providerList);
        return "providerList";
    }

    //修改页面回填
    @RequestMapping("goProviderEdit.html")
    public String edit(Integer id,Model model){
        if(id!=null){
            Provider provider = providerService.getProviderById(id);
            model.addAttribute("provider",provider);
        }
        return "ProviderEdit";
    }

    //添加修改
    @RequestMapping("doProviderEdit.html")
    public String edit(Provider provider,Model model) {
        if(provider.getId()==null){
            ResultData res = providerService.addProvider(provider);
            if(res.getStatus()){
                return "redirect:providerList.html";
            }
            model.addAttribute("message",res.getMessage());
        }else{
            ResultData res = providerService.updateProvider(provider);
            if(res.getStatus()){
                return "redirect:providerList.html";
            }
            model.addAttribute("message",res.getMessage());
        }
        return "ProviderEdit";
    }

    //删除供应商
    @RequestMapping("deleteProvider.html")
    public String del(Integer id,Model model){
        if(id!=null){
            ResultData res = providerService.deleteProviderById(id);
            model.addAttribute("message",res.getMessage());
        }
        return "redirect:providerList.html";
    }

}
