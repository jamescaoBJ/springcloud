package com.ncme.springboot.model;

import java.util.Date;

public class LogStudyCvUnit {
    private Integer id;

    private Integer logStudyCvSetId;

    private Integer systemUserId;

    private Integer cvId;

    private Integer cvUnitId;

    private Integer status;

    private Date lastUpdateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLogStudyCvSetId() {
        return logStudyCvSetId;
    }

    public void setLogStudyCvSetId(Integer logStudyCvSetId) {
        this.logStudyCvSetId = logStudyCvSetId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}