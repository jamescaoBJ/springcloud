package com.ncme.springboot.model;

import java.util.Date;

public class SystemCardCreateRecord {
    private Integer id;

    private String cardStartInt;

    private String cardEndInt;

    private Integer cardSum;

    private Integer cardUserdSum;

    private Date createDate;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardStartInt() {
        return cardStartInt;
    }

    public void setCardStartInt(String cardStartInt) {
        this.cardStartInt = cardStartInt;
    }

    public String getCardEndInt() {
        return cardEndInt;
    }

    public void setCardEndInt(String cardEndInt) {
        this.cardEndInt = cardEndInt;
    }

    public Integer getCardSum() {
        return cardSum;
    }

    public void setCardSum(Integer cardSum) {
        this.cardSum = cardSum;
    }

    public Integer getCardUserdSum() {
        return cardUserdSum;
    }

    public void setCardUserdSum(Integer cardUserdSum) {
        this.cardUserdSum = cardUserdSum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}