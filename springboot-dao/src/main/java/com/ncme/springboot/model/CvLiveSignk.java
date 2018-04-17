package com.ncme.springboot.model;

import java.util.Date;

public class CvLiveSignk {
    private Integer id;

    private Integer userId;

    private String realName;

    private String signkCode;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSignkCode() {
        return signkCode;
    }

    public void setSignkCode(String signkCode) {
        this.signkCode = signkCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}