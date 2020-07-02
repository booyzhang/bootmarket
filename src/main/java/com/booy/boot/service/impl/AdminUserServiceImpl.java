package com.booy.boot.service.impl;

import com.booy.boot.dao.AdminUserDAO;
import com.booy.boot.pojo.AdminUser;
import com.booy.boot.service.AdminUserService;
import com.booy.boot.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDAO adminUserDAO;

    @Override
    public ResultData addAdminUser(AdminUser adminUser) {
        AdminUser user = adminUserDAO.getAdminUserByName(adminUser.getName());
        if(user!=null){
            return new ResultData(false,"用户名已存在");
        }
        adminUserDAO.addAdminUser(adminUser);
        return new ResultData(true);
    }

    @Override
    public List<AdminUser> getAdminUserList(String name) {
        List<AdminUser> adminUserList = adminUserDAO.getAdminUserList(name);
        return adminUserList;
    }

    @Override
    public AdminUser getAdminUserById(Integer id) {
        return adminUserDAO.getAdminUserById(id);
    }

    @Override
    public ResultData updateAdminUser(AdminUser adminUser) {
        try {
            adminUserDAO.updateAdminUser(adminUser);
            return new ResultData(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultData(false,"修改失败！");
        }
    }

    @Override
    public ResultData deleteAdminUserById(Integer id) {
        try {
            adminUserDAO.deleteAdminUserById(id);
            return new ResultData(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultData(false,"删除失败！");
        }
    }

    @Override
    public AdminUser getAdminUserByName(String name) {
        return adminUserDAO.getAdminUserByName(name);
    }
}
