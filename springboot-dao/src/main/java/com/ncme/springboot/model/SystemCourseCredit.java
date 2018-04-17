package com.ncme.springboot.model;

import java.util.Date;

public class SystemCourseCredit {
    private String creditYear;

    private Integer courseId;

    private Integer orgId;

    private String creditType;

    private Integer industryId;

    private Integer courseType;

    private Float creditNum;

    private String courseSerial;

    private String request;

    private Integer reStudyFlag;

    private Date creditDate;

    private Float creditHours;

    private Date startDate;

    private Date endDate;

    private Integer siteId;

    public String getCreditYear() {
        return creditYear;
    }

    public void setCreditYear(String creditYear) {
        this.creditYear = creditYear;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Float getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(Float creditNum) {
        this.creditNum = creditNum;
    }

    public String getCourseSerial() {
        return courseSerial;
    }

    public void setCourseSerial(String courseSerial) {
        this.courseSerial = courseSerial;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Integer getReStudyFlag() {
        return reStudyFlag;
    }

    public void setReStudyFlag(Integer reStudyFlag) {
        this.reStudyFlag = reStudyFlag;
    }

    public Date getCreditDate() {
        return creditDate;
    }

    public void setCreditDate(Date creditDate) {
        this.creditDate = creditDate;
    }

    public Float getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(Float creditHours) {
        this.creditHours = creditHours;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}