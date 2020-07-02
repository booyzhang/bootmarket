package com.booy.boot.pojo;

import java.util.Date;

public class Bill {
    private Integer id;
    private String goodsName;
    private String unit;
    private Integer amount;
    private Integer price;
    private Integer providerId;
    private String providerName;
    private Integer status;
    private Date createDate;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", unit='" + unit + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", providerId=" + providerId +
                ", providerName=" + providerName +
                ", status=" + status +
                ", createDate=" + createDate +
                '}';
    }
}
