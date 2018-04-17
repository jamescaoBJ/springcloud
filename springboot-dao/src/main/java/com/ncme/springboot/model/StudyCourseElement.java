package com.ncme.springboot.model;

import java.util.Date;

public class StudyCourseElement {
    private Integer id;

    private Integer courseElementType;

    private Integer courseId;

    private Integer seq;

    private Integer status;

    private Date lastUpdateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseElementType() {
        return courseElementType;
    }

    public void setCourseElementType(Integer courseElementType) {
        this.courseElementType = courseElementType;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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
}