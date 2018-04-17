package com.ncme.springboot.model;

public class IcmeSiteScoreType {
    private Integer siteId;

    private Integer scoreTypeId;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getScoreTypeId() {
        return scoreTypeId;
    }

    public void setScoreTypeId(Integer scoreTypeId) {
        this.scoreTypeId = scoreTypeId;
    }
}