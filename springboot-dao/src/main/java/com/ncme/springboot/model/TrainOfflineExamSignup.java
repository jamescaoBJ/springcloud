package com.ncme.springboot.model;

import java.util.Date;

public class TrainOfflineExamSignup {
    private Integer id;

    private Integer projectClassId;

    private Integer studentId;

    private Integer status;

    private Date createDate;

    private Date lastUpdateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectClassId() {
        return projectClassId;
    }

    public void setProjectClassId(Integer projectClassId) {
        this.projectClassId = projectClassId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}