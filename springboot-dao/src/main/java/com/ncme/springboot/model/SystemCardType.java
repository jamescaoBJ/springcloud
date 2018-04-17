package com.ncme.springboot.model;

import java.util.Date;

public class SystemCardType {
    private Integer id;

    private String cardTypeName;

    private Date startDate;

    private Date endDate;

    private String creditScope;

    private Integer creditSum;

    private Double price;

    private Integer evpValue;

    private Integer isNetpay;

    private Integer isSdsync;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCreditScope() {
        return creditScope;
    }

    public void setCreditScope(String creditScope) {
        this.creditScope = creditScope;
    }

    public Integer getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(Integer creditSum) {
        this.creditSum = creditSum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getEvpValue() {
        return evpValue;
    }

    public void setEvpValue(Integer evpValue) {
        this.evpValue = evpValue;
    }

    public Integer getIsNetpay() {
        return isNetpay;
    }

    public void setIsNetpay(Integer isNetpay) {
        this.isNetpay = isNetpay;
    }

    public Integer getIsSdsync() {
        return isSdsync;
    }

    public void setIsSdsync(Integer isSdsync) {
        this.isSdsync = isSdsync;
    }
}