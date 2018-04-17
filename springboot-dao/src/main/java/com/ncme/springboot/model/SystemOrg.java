package com.ncme.springboot.model;

import java.util.Date;

public class SystemOrg {
    private Integer id;

    private Integer orgTypeId;

    private Integer parentOrgId;

    private Integer adminParentOrgId;

    private String orgCode;

    private String orgName;

    private Integer status;

    private Integer orgTypeFlag;

    private String aliasName;

    private Integer orgSeq;

    private Integer orgSeq2;

    private Date lastUpdateDate;

    private String orgAbbr;

    private Integer layer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgTypeId() {
        return orgTypeId;
    }

    public void setOrgTypeId(Integer orgTypeId) {
        this.orgTypeId = orgTypeId;
    }

    public Integer getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(Integer parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public Integer getAdminParentOrgId() {
        return adminParentOrgId;
    }

    public void setAdminParentOrgId(Integer adminParentOrgId) {
        this.adminParentOrgId = adminParentOrgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrgTypeFlag() {
        return orgTypeFlag;
    }

    public void setOrgTypeFlag(Integer orgTypeFlag) {
        this.orgTypeFlag = orgTypeFlag;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Integer getOrgSeq() {
        return orgSeq;
    }

    public void setOrgSeq(Integer orgSeq) {
        this.orgSeq = orgSeq;
    }

    public Integer getOrgSeq2() {
        return orgSeq2;
    }

    public void setOrgSeq2(Integer orgSeq2) {
        this.orgSeq2 = orgSeq2;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getOrgAbbr() {
        return orgAbbr;
    }

    public void setOrgAbbr(String orgAbbr) {
        this.orgAbbr = orgAbbr;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }
}