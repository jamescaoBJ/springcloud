package com.ncme.springboot.model;

public class StudyCourseTypeCourse {
    private Integer studyCourseTypeId;

    private Integer studyCourseId;

    private Integer isObligatory;

    public Integer getStudyCourseTypeId() {
        return studyCourseTypeId;
    }

    public void setStudyCourseTypeId(Integer studyCourseTypeId) {
        this.studyCourseTypeId = studyCourseTypeId;
    }

    public Integer getStudyCourseId() {
        return studyCourseId;
    }

    public void setStudyCourseId(Integer studyCourseId) {
        this.studyCourseId = studyCourseId;
    }

    public Integer getIsObligatory() {
        return isObligatory;
    }

    public void setIsObligatory(Integer isObligatory) {
        this.isObligatory = isObligatory;
    }
}