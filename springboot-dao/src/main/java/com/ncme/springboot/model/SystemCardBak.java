package com.ncme.springboot.model;

import java.util.Date;

public class SystemCardBak {
    private Integer id;

    private String cardNumber;

    private String cardPassword;

    private Integer cardType;

    private Date importDate;

    private Date usefulDate;

    private Integer isnotBind;

    private Integer faceValue;

    private Integer createUserId;

    private Date createDate;

    private Integer status;

    private Integer lastUpdateUserId;

    private Date lastUpdateDate;

    private Double balance;

    private Integer orderId;

    private Integer isselled;

    private Integer sellStyle;

    private Integer cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Date getUsefulDate() {
        return usefulDate;
    }

    public void setUsefulDate(Date usefulDate) {
        this.usefulDate = usefulDate;
    }

    public Integer getIsnotBind() {
        return isnotBind;
    }

    public void setIsnotBind(Integer isnotBind) {
        this.isnotBind = isnotBind;
    }

    public Integer getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Integer faceValue) {
        this.faceValue = faceValue;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getIsselled() {
        return isselled;
    }

    public void setIsselled(Integer isselled) {
        this.isselled = isselled;
    }

    public Integer getSellStyle() {
        return sellStyle;
    }

    public void setSellStyle(Integer sellStyle) {
        this.sellStyle = sellStyle;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}