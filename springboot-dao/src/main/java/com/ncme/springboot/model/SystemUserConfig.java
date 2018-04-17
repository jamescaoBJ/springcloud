package com.ncme.springboot.model;

import java.util.Date;

public class SystemUserConfig {
    private Integer id;

    private Integer userId;

    private Integer studyCourseTypeId;

    private Date lastUpdateDate;

    private Integer userType;

    private Integer userProvinceId;

    private Integer userCityId;

    private Integer userCountiesId;

    private Integer isEnable;

    private Integer userIndustryId;

    private Integer userStreetId;

    private String address;

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

    public Integer getStudyCourseTypeId() {
        return studyCourseTypeId;
    }

    public void setStudyCourseTypeId(Integer studyCourseTypeId) {
        this.studyCourseTypeId = studyCourseTypeId;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
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

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getUserIndustryId() {
        return userIndustryId;
    }

    public void setUserIndustryId(Integer userIndustryId) {
        this.userIndustryId = userIndustryId;
    }

    public Integer getUserStreetId() {
        return userStreetId;
    }

    public void setUserStreetId(Integer userStreetId) {
        this.userStreetId = userStreetId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}