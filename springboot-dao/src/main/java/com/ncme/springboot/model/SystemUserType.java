package com.ncme.springboot.model;

public class SystemUserType {
    private Integer id;

    private String userTypeName;

    private String userTypeRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getUserTypeRemark() {
        return userTypeRemark;
    }

    public void setUserTypeRemark(String userTypeRemark) {
        this.userTypeRemark = userTypeRemark;
    }
}