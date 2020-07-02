package com.booy.boot.controller;

import com.booy.boot.pojo.AdminUser;
import com.booy.boot.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SystemController {

    @Autowired
    AdminUserService adminUserService;

    @RequestMapping("{page}.html")
    public String index(@PathVariable String page){
        return page;
    }
    @RequestMapping("doLogin.html")
    public String doLogin(String name, String password, Model model, HttpSession session){
        AdminUser user = adminUserService.getAdminUserByName(name);
        if(user==null || !user.getPassword().equals(password)){
            model.addAttribute("message","用户名或密码错误！");
            return "login";
        }
        session.setAttribute("session_user",user);
        return "redirect:index.html";
    }
    @RequestMapping("logout.html")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login.html";
    }
}
