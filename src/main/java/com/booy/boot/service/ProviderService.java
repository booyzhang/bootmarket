package com.booy.boot.service;

import com.booy.boot.pojo.Provider;
import com.booy.boot.utils.ResultData;

import java.util.List;

public interface ProviderService {
    //添加供应商
    ResultData addProvider(Provider provider);

    //修改回填数据
    Provider getProviderById(Integer id);

    //修改供应商
    ResultData updateProvider(Provider provider);

    //搜索供应商
    List<Provider> getProviderList(String name);

    //删除供应商
    ResultData deleteProviderById(Integer id);

    //下拉列表
    List<Provider> getProviderName();
}
