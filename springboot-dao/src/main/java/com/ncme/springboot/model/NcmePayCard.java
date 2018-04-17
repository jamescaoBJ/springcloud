package com.ncme.springboot.model;

import java.util.Date;

public class NcmePayCard {
    private String cardType;

    private String cardName;

    private Date startDate;

    private Date endDate;

    private String creditScope;

    private Integer creditSum;

    private Integer price;

    private Integer evpValue;

    private Integer isNetpay;

    private Integer isSdsync;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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