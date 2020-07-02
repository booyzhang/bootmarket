package com.booy.boot.dao;

import com.booy.boot.pojo.AdminUser;

import java.util.List;

public interface AdminUserDAO {
    void addAdminUser(AdminUser adminUser);
    AdminUser getAdminUserByName(String name);

    AdminUser getAdminUserById(Integer id);

    void updateAdminUser(AdminUser adminUser);

    List<AdminUser> getAdminUserList(String name);

    void deleteAdminUserById(Integer id);
}
