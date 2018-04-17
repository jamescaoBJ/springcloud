package com.ncme.springboot.model;

import java.util.Date;

public class LogStudyCvSet {
    private Integer id;

    private Integer systemUserId;

    private Integer siteId;

    private Integer cvSetId;

    private Integer state;

    private Integer isApplyCredit;

    private Date lastUpdateDate;

    private Date applyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getCvSetId() {
        return cvSetId;
    }

    public void setCvSetId(Integer cvSetId) {
        this.cvSetId = cvSetId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsApplyCredit() {
        return isApplyCredit;
    }

    public void setIsApplyCredit(Integer isApplyCredit) {
        this.isApplyCredit = isApplyCredit;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}