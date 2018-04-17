package com.ncme.springboot.model;

public class PeixunOrg {
    private Integer id;

    private String name;

    private Integer type;

    private Integer level;

    private Integer hospitalId;

    private Integer region1Id;

    private Integer region2Id;

    private Integer region3Id;

    private String contact;

    private String phoneNumber;

    private Integer state;

    private String description;

    private Integer userId;

    private String filepath;

    private String photopath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getRegion1Id() {
        return region1Id;
    }

    public void setRegion1Id(Integer region1Id) {
        this.region1Id = region1Id;
    }

    public Integer getRegion2Id() {
        return region2Id;
    }

    public void setRegion2Id(Integer region2Id) {
        this.region2Id = region2Id;
    }

    public Integer getRegion3Id() {
        return region3Id;
    }

    public void setRegion3Id(Integer region3Id) {
        this.region3Id = region3Id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }
}