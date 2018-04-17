package com.ncme.springboot.model;

import java.util.Date;

public class LogStudy {
    private Integer id;

    private Integer userId;

    private Integer siteId;

    private Integer studyCourseId;

    private Integer state;

    private Date lastUpdateDate;

    private Integer studyCourseTypeId;

    private String ncmeSubjectId;

    private String year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getStudyCourseId() {
        return studyCourseId;
    }

    public void setStudyCourseId(Integer studyCourseId) {
        this.studyCourseId = studyCourseId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getStudyCourseTypeId() {
        return studyCourseTypeId;
    }

    public void setStudyCourseTypeId(Integer studyCourseTypeId) {
        this.studyCourseTypeId = studyCourseTypeId;
    }

    public String getNcmeSubjectId() {
        return ncmeSubjectId;
    }

    public void setNcmeSubjectId(String ncmeSubjectId) {
        this.ncmeSubjectId = ncmeSubjectId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}