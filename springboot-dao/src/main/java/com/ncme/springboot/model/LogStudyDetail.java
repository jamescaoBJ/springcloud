package com.ncme.springboot.model;

import java.util.Date;

public class LogStudyDetail {
    private Integer id;

    private Integer logStudyId;

    private Integer coursewareId;

    private Date startDate;

    private Date endDate;

    private Integer viewTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLogStudyId() {
        return logStudyId;
    }

    public void setLogStudyId(Integer logStudyId) {
        this.logStudyId = logStudyId;
    }

    public Integer getCoursewareId() {
        return coursewareId;
    }

    public void setCoursewareId(Integer coursewareId) {
        this.coursewareId = coursewareId;
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

    public Integer getViewTime() {
        return viewTime;
    }

    public void setViewTime(Integer viewTime) {
        this.viewTime = viewTime;
    }
}