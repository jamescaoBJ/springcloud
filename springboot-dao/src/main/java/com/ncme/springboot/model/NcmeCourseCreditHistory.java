package com.ncme.springboot.model;

import java.util.Date;

public class NcmeCourseCreditHistory {
    private String creditYear;

    private String courseId;

    private String courseName;

    private String organId;

    private String organName;

    private String creditType;

    private Integer courseType;

    private Float creditNum;

    private Integer evpValue;

    private String courseSerial;

    private String request;

    private Integer reStudyFlag;

    private Date creditDate;

    public String getCreditYear() {
        return creditYear;
    }

    public void setCreditYear(String creditYear) {
        this.creditYear = creditYear;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
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

    public Integer getEvpValue() {
        return evpValue;
    }

    public void setEvpValue(Integer evpValue) {
        this.evpValue = evpValue;
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
}