package com.ncme.springboot.model;

import java.util.Date;

public class IcmeSubject {
    private Integer id;

    private Integer orgProjectId;

    private String subjectName;

    private String subjectTeacherName;

    private String subjectTeacherOrg;

    private String subjectTeacherRank;

    private String subjectHolder;

    private Double subjectClassScore;

    private Double subjectClassHour;

    private Date subjectBeginDate;

    private Date subjectEndDate;

    private Date subjectCardBeginDate;

    private Date subjectCardEndDate;

    private String subjectRemark;

    private Integer createUserId;

    private Integer createOrgId;

    private Date createDate;

    private Date lastUpdateDate;

    private Integer lastUpdateUserId;

    private Integer status;

    private Integer subjectSeq;

    private Integer subjectType;

    private Integer courseId;

    private Integer expectInt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgProjectId() {
        return orgProjectId;
    }

    public void setOrgProjectId(Integer orgProjectId) {
        this.orgProjectId = orgProjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectTeacherName() {
        return subjectTeacherName;
    }

    public void setSubjectTeacherName(String subjectTeacherName) {
        this.subjectTeacherName = subjectTeacherName;
    }

    public String getSubjectTeacherOrg() {
        return subjectTeacherOrg;
    }

    public void setSubjectTeacherOrg(String subjectTeacherOrg) {
        this.subjectTeacherOrg = subjectTeacherOrg;
    }

    public String getSubjectTeacherRank() {
        return subjectTeacherRank;
    }

    public void setSubjectTeacherRank(String subjectTeacherRank) {
        this.subjectTeacherRank = subjectTeacherRank;
    }

    public String getSubjectHolder() {
        return subjectHolder;
    }

    public void setSubjectHolder(String subjectHolder) {
        this.subjectHolder = subjectHolder;
    }

    public Double getSubjectClassScore() {
        return subjectClassScore;
    }

    public void setSubjectClassScore(Double subjectClassScore) {
        this.subjectClassScore = subjectClassScore;
    }

    public Double getSubjectClassHour() {
        return subjectClassHour;
    }

    public void setSubjectClassHour(Double subjectClassHour) {
        this.subjectClassHour = subjectClassHour;
    }

    public Date getSubjectBeginDate() {
        return subjectBeginDate;
    }

    public void setSubjectBeginDate(Date subjectBeginDate) {
        this.subjectBeginDate = subjectBeginDate;
    }

    public Date getSubjectEndDate() {
        return subjectEndDate;
    }

    public void setSubjectEndDate(Date subjectEndDate) {
        this.subjectEndDate = subjectEndDate;
    }

    public Date getSubjectCardBeginDate() {
        return subjectCardBeginDate;
    }

    public void setSubjectCardBeginDate(Date subjectCardBeginDate) {
        this.subjectCardBeginDate = subjectCardBeginDate;
    }

    public Date getSubjectCardEndDate() {
        return subjectCardEndDate;
    }

    public void setSubjectCardEndDate(Date subjectCardEndDate) {
        this.subjectCardEndDate = subjectCardEndDate;
    }

    public String getSubjectRemark() {
        return subjectRemark;
    }

    public void setSubjectRemark(String subjectRemark) {
        this.subjectRemark = subjectRemark;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getCreateOrgId() {
        return createOrgId;
    }

    public void setCreateOrgId(Integer createOrgId) {
        this.createOrgId = createOrgId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSubjectSeq() {
        return subjectSeq;
    }

    public void setSubjectSeq(Integer subjectSeq) {
        this.subjectSeq = subjectSeq;
    }

    public Integer getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Integer subjectType) {
        this.subjectType = subjectType;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getExpectInt() {
        return expectInt;
    }

    public void setExpectInt(Integer expectInt) {
        this.expectInt = expectInt;
    }
}