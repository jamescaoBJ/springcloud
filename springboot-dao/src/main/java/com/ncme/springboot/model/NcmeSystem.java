package com.ncme.springboot.model;

public class NcmeSystem {
    private String sytId;

    private String sysName;

    private Integer courseType;

    private Integer weight;

    public String getSytId() {
        return sytId;
    }

    public void setSytId(String sytId) {
        this.sytId = sytId;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}