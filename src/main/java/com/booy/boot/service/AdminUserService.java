package com.booy.boot.service;

import com.booy.boot.pojo.AdminUser;
import com.booy.boot.utils.ResultData;

import java.util.List;

public interface AdminUserService {
    //添加用户
    ResultData addAdminUser(AdminUser adminUser);

    //用户登录
    AdminUser getAdminUserByName(String name);

    //搜索用户
    List<AdminUser> getAdminUserList(String name);

    AdminUser getAdminUserById(Integer id);

    ResultData updateAdminUser(AdminUser adminUser);

    //删除用户
    ResultData deleteAdminUserById(Integer id);
}
