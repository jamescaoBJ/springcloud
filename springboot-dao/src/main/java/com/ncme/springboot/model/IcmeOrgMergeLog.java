package com.ncme.springboot.model;

import java.util.Date;

public class IcmeOrgMergeLog {
    private Integer id;

    private Integer mergeOrgId;

    private Integer orgId;

    private Integer userId;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMergeOrgId() {
        return mergeOrgId;
    }

    public void setMergeOrgId(Integer mergeOrgId) {
        this.mergeOrgId = mergeOrgId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}