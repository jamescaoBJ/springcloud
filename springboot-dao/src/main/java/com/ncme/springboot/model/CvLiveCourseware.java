package com.ncme.springboot.model;

public class CvLiveCourseware {
    private Integer id;

    private String coursewareNo;

    private String coursewareNum;

    private String coursewareUrl;

    private String coursewareToken;

    private String subject;

    private String classNo;

    private Long coursewareCreateTime;

    private Long duration;

    private String screenshot;

    private Long recordid;

    private String description;

    private Integer cvId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursewareNo() {
        return coursewareNo;
    }

    public void setCoursewareNo(String coursewareNo) {
        this.coursewareNo = coursewareNo;
    }

    public String getCoursewareNum() {
        return coursewareNum;
    }

    public void setCoursewareNum(String coursewareNum) {
        this.coursewareNum = coursewareNum;
    }

    public String getCoursewareUrl() {
        return coursewareUrl;
    }

    public void setCoursewareUrl(String coursewareUrl) {
        this.coursewareUrl = coursewareUrl;
    }

    public String getCoursewareToken() {
        return coursewareToken;
    }

    public void setCoursewareToken(String coursewareToken) {
        this.coursewareToken = coursewareToken;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public Long getCoursewareCreateTime() {
        return coursewareCreateTime;
    }

    public void setCoursewareCreateTime(Long coursewareCreateTime) {
        this.coursewareCreateTime = coursewareCreateTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public Long getRecordid() {
        return recordid;
    }

    public void setRecordid(Long recordid) {
        this.recordid = recordid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCvId() {
        return cvId;
    }

    public void setCvId(Integer cvId) {
        this.cvId = cvId;
    }
}