package com.ncme.springboot.model;

import java.util.Date;

public class IcmeExamOrgproject {
    private Integer examId;

    private Integer siteId;

    private Integer orgprojectId;

    private Double totalScore;

    private Double standardScore;

    private Date createDate;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getOrgprojectId() {
        return orgprojectId;
    }

    public void setOrgprojectId(Integer orgprojectId) {
        this.orgprojectId = orgprojectId;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Double getStandardScore() {
        return standardScore;
    }

    public void setStandardScore(Double standardScore) {
        this.standardScore = standardScore;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}