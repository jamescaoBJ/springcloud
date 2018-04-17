package com.ncme.springboot.model;

public class IcmeOrgMergeLogUser {
    private Integer mergeLogId;

    private Integer userId;

    private Integer orgId;

    public Integer getMergeLogId() {
        return mergeLogId;
    }

    public void setMergeLogId(Integer mergeLogId) {
        this.mergeLogId = mergeLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
}