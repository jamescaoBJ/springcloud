package com.ncme.springboot.model;

public class LogStudyCvUnitExam {
    private Integer id;

    private Integer logStudyCvUnitId;

    private Integer systemUserId;

    private Integer cvId;

    private Integer cvUnitId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLogStudyCvUnitId() {
        return logStudyCvUnitId;
    }

    public void setLogStudyCvUnitId(Integer logStudyCvUnitId) {
        this.logStudyCvUnitId = logStudyCvUnitId;
    }

    public Integer getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    public Integer getCvId() {
        return cvId;
    }

    public void setCvId(Integer cvId) {
        this.cvId = cvId;
    }

    public Integer getCvUnitId() {
        return cvUnitId;
    }

    public void setCvUnitId(Integer cvUnitId) {
        this.cvUnitId = cvUnitId;
    }
}