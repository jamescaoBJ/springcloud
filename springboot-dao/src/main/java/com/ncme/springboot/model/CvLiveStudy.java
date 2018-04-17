package com.ncme.springboot.model;

public class CvLiveStudy {
    private Integer id;

    private Long userId;

    private String classNo;

    private String nickname;

    private String mobile;

    private Long jointime;

    private Long leavetime;

    private String ip;

    private Integer device;

    private Integer usefulLength;

    private String company;

    private String area;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getJointime() {
        return jointime;
    }

    public void setJointime(Long jointime) {
        this.jointime = jointime;
    }

    public Long getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Long leavetime) {
        this.leavetime = leavetime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getDevice() {
        return device;
    }

    public void setDevice(Integer device) {
        this.device = device;
    }

    public Integer getUsefulLength() {
        return usefulLength;
    }

    public void setUsefulLength(Integer usefulLength) {
        this.usefulLength = usefulLength;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}