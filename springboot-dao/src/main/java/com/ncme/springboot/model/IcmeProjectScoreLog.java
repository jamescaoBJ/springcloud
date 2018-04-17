package com.ncme.springboot.model;

import java.util.Date;

public class IcmeProjectScoreLog {
    private Integer id;

    private Integer projectScore;

    private Integer fromOrgId;

    private Integer toOrgId;

    private Integer checkFlag;

    private String remark;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectScore() {
        return projectScore;
    }

    public void setProjectScore(Integer projectScore) {
        this.projectScore = projectScore;
    }

    public Integer getFromOrgId() {
        return fromOrgId;
    }

    public void setFromOrgId(Integer fromOrgId) {
        this.fromOrgId = fromOrgId;
    }

    public Integer getToOrgId() {
        return toOrgId;
    }

    public void setToOrgId(Integer toOrgId) {
        this.toOrgId = toOrgId;
    }

    public Integer getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}