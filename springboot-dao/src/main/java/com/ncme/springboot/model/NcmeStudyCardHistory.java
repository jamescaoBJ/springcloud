package com.ncme.springboot.model;

import java.util.Date;

public class NcmeStudyCardHistory {
    private String cardNo;

    private String cardPasswd;

    private String cardType;

    private Date operatorDate;

    private String userName;

    private Date linkDate;

    private Integer balance;

    private Integer times;

    private String orderNo;

    private Integer saleType;

    private String parentCard;

    private String remark;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardPasswd() {
        return cardPasswd;
    }

    public void setCardPasswd(String cardPasswd) {
        this.cardPasswd = cardPasswd;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Date getOperatorDate() {
        return operatorDate;
    }

    public void setOperatorDate(Date operatorDate) {
        this.operatorDate = operatorDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(Date linkDate) {
        this.linkDate = linkDate;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getSaleType() {
        return saleType;
    }

    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }

    public String getParentCard() {
        return parentCard;
    }

    public void setParentCard(String parentCard) {
        this.parentCard = parentCard;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}