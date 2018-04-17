package com.ncme.springboot.model;

import java.util.Date;

public class CvsetQualifyHistory {
    private Integer cvSetId;

    private Integer expertId;

    private Integer qualifyStatus;

    private String opinion;

    private String opinionType;

    private Integer status;

    private Date createDate;

    public Integer getCvSetId() {
        return cvSetId;
    }

    public void setCvSetId(Integer cvSetId) {
        this.cvSetId = cvSetId;
    }

    public Integer getExpertId() {
        return expertId;
    }

    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

    public Integer getQualifyStatus() {
        return qualifyStatus;
    }

    public void setQualifyStatus(Integer qualifyStatus) {
        this.qualifyStatus = qualifyStatus;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getOpinionType() {
        return opinionType;
    }

    public void setOpinionType(String opinionType) {
        this.opinionType = opinionType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}