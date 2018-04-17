package com.ncme.springboot.model;

public class ExamExamUser {
    private Integer examId;

    private Integer systemUserId;

    private Integer systemUserType;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    public Integer getSystemUserType() {
        return systemUserType;
    }

    public void setSystemUserType(Integer systemUserType) {
        this.systemUserType = systemUserType;
    }
}