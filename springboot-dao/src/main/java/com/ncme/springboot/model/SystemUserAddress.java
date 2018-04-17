package com.ncme.springboot.model;

import java.util.Date;

public class SystemUserAddress {
    private Integer id;

    private Integer userId;

    private String userName;

    private Integer userProvinceId;

    private Integer userCityId;

    private Integer userCountiesId;

    private String address;

    private String mobilePhone;

    private Integer postCode;

    private String description;

    private Date createDate;

    private Integer status;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserProvinceId() {
        return userProvinceId;
    }

    public void setUserProvinceId(Integer userProvinceId) {
        this.userProvinceId = userProvinceId;
    }

    public Integer getUserCityId() {
        return userCityId;
    }

    public void setUserCityId(Integer userCityId) {
        this.userCityId = userCityId;
    }

    public Integer getUserCountiesId() {
        return userCountiesId;
    }

    public void setUserCountiesId(Integer userCountiesId) {
        this.userCountiesId = userCountiesId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}