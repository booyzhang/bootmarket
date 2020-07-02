package com.booy.boot.controller;

import com.booy.boot.pojo.AdminUser;
import com.booy.boot.service.AdminUserService;
import com.booy.boot.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("userList.html")
    public String getAdminUserList(String name, Model model){
        List<AdminUser> adminUserList = adminUserService.getAdminUserList(name);
        model.addAttribute("userList",adminUserList);
        return "userList";
    }

    //修改页面回填
    @RequestMapping("goUserEdit.html")
    public String edit(Integer id,Model model){
        if(id!=null){
            AdminUser adminUser = adminUserService.getAdminUserById(id);
            model.addAttribute("adminUser",adminUser);
        }
        return "userEdit";
    }

    //添加修改
    @RequestMapping("doUserEdit.html")
    public String edit(AdminUser adminUser,Model model) {
        if(adminUser.getId()==null){
            ResultData res = adminUserService.addAdminUser(adminUser);
            if(res.getStatus()){
                return "redirect:userList.html";
            }
            model.addAttribute("message",res.getMessage());
        }else{
            ResultData res = adminUserService.updateAdminUser(adminUser);
            model.addAttribute("message",res.getMessage());
        }
        return "userEdit";
    }
    //删除用户
    @RequestMapping("deleteUser.html")
    public String del(Integer id,Model model){
        if(id!=null){
            ResultData res = adminUserService.deleteAdminUserById(id);
            model.addAttribute("message",res.getMessage());
        }
        return "userList";
    }
    //修改密码
    @RequestMapping("updatePWD.html")
    public String updatePWD(String oldPassword, String newPassword, String reNewPassword, HttpSession session,Model model){
        AdminUser user = (AdminUser)session.getAttribute("session_user");
        if(StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword) || StringUtils.isEmpty(reNewPassword)){
            model.addAttribute("message","密码不能为空！");
            return "password";
        }
        if(!newPassword.equals(reNewPassword)){
            model.addAttribute("message","两次密码不一致！");
            return "password";
        }
        if(user.getPassword().equals(oldPassword)){
            user.setPassword(newPassword);
            System.out.println(user.getId());
            try {
                adminUserService.updateAdminUser(user);
                return "redirect:login.html";
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("message","修改失败！");
                return "password";
            }
        }else{
            model.addAttribute("message","原始密码错误！");
            return "password";
        }
    }
}
