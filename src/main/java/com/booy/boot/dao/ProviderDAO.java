package com.booy.boot.dao;

import com.booy.boot.pojo.AdminUser;
import com.booy.boot.pojo.Provider;

import java.util.List;

public interface ProviderDAO {
    void addProvider(Provider provider);

    Provider getProviderById(Integer id);

    void updateProvider(Provider provider);

    List<Provider> getProviderList(String name);

    void deleteProviderById(Integer id);

    List<Provider> getProviderName();

}
