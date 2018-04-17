package com.ncme.springboot.model;

import java.util.Date;

public class StudyCourse {
    private Integer id;

    private String studyCourseName;

    private String teacher;

    private String keyWord;

    private Integer studyCourseType;

    private Double times;

    private String summary;

    private String description;

    private String review;

    private Integer status;

    private Date lastUpdateDate;

    private Double classHours;

    private Date createDate;

    private String courseInt;

    private Date pubDate;

    private Integer difficulty;

    private String remark;

    private Integer clickTimes;

    private Integer totalClickTimes;

    private String teacherUnit;

    private String courseImgPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudyCourseName() {
        return studyCourseName;
    }

    public void setStudyCourseName(String studyCourseName) {
        this.studyCourseName = studyCourseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getStudyCourseType() {
        return studyCourseType;
    }

    public void setStudyCourseType(Integer studyCourseType) {
        this.studyCourseType = studyCourseType;
    }

    public Double getTimes() {
        return times;
    }

    public void setTimes(Double times) {
        this.times = times;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Double getClassHours() {
        return classHours;
    }

    public void setClassHours(Double classHours) {
        this.classHours = classHours;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCourseInt() {
        return courseInt;
    }

    public void setCourseInt(String courseInt) {
        this.courseInt = courseInt;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getClickTimes() {
        return clickTimes;
    }

    public void setClickTimes(Integer clickTimes) {
        this.clickTimes = clickTimes;
    }

    public Integer getTotalClickTimes() {
        return totalClickTimes;
    }

    public void setTotalClickTimes(Integer totalClickTimes) {
        this.totalClickTimes = totalClickTimes;
    }

    public String getTeacherUnit() {
        return teacherUnit;
    }

    public void setTeacherUnit(String teacherUnit) {
        this.teacherUnit = teacherUnit;
    }

    public String getCourseImgPath() {
        return courseImgPath;
    }

    public void setCourseImgPath(String courseImgPath) {
        this.courseImgPath = courseImgPath;
    }
}