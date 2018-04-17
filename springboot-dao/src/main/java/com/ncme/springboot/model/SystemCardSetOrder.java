package com.ncme.springboot.model;

public class SystemCardSetOrder {
    private Integer id;

    private Integer cardTypeId;

    private Integer userId;

    private String usefulDate;

    private Double price;

    private Double amount;

    private String payDate;

    private String paymodeCode;

    private String orderNumber;

    private Integer status;

    private Integer orderType;

    private Integer cvSetId;

    private String itemName;

    private String cardNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(Integer cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsefulDate() {
        return usefulDate;
    }

    public void setUsefulDate(String usefulDate) {
        this.usefulDate = usefulDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPaymodeCode() {
        return paymodeCode;
    }

    public void setPaymodeCode(String paymodeCode) {
        this.paymodeCode = paymodeCode;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getCvSetId() {
        return cvSetId;
    }

    public void setCvSetId(Integer cvSetId) {
        this.cvSetId = cvSetId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}