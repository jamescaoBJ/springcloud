package com.ncme.springboot.model;

import java.util.Date;

public class IcmeProjectUserTemp {
    private Integer id;

    private String realName;

    private String certificateNo;

    private Integer orgId;

    private Integer orgProjectId;

    private Date cardBeginDate;

    private Date cardEndDate;

    private Integer subjectId;

    private Date createDate;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getOrgProjectId() {
        return orgProjectId;
    }

    public void setOrgProjectId(Integer orgProjectId) {
        this.orgProjectId = orgProjectId;
    }

    public Date getCardBeginDate() {
        return cardBeginDate;
    }

    public void setCardBeginDate(Date cardBeginDate) {
        this.cardBeginDate = cardBeginDate;
    }

    public Date getCardEndDate() {
        return cardEndDate;
    }

    public void setCardEndDate(Date cardEndDate) {
        this.cardEndDate = cardEndDate;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}