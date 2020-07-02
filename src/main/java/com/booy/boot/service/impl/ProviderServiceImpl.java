package com.booy.boot.service.impl;

import com.booy.boot.dao.ProviderDAO;
import com.booy.boot.pojo.Provider;
import com.booy.boot.service.ProviderService;
import com.booy.boot.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderDAO providerDAO;

    @Override
    public ResultData addProvider(Provider provider) {
        try {
            provider.setCreateDate(new Date());
            providerDAO.addProvider(provider);
            return new ResultData(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultData(false,"添加失败！");
        }
    }

    @Override
    public Provider getProviderById(Integer id) {
        return providerDAO.getProviderById(id);
    }

    @Override
    public ResultData updateProvider(Provider provider) {
        try {
            providerDAO.updateProvider(provider);
            return new ResultData(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultData(false,"修改失败！");
        }
    }

    @Override
    public List<Provider> getProviderList(String name) {
        return providerDAO.getProviderList(name);
    }

    @Override
    public ResultData deleteProviderById(Integer id) {
        try {
            providerDAO.deleteProviderById(id);
            return new ResultData(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultData(false,"删除失败！");
        }
    }

    @Override
    public List<Provider> getProviderName() {
        return providerDAO.getProviderName();
    }
}
