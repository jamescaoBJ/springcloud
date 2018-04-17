package com.ncme.springboot.model;

public class SystemAbilityCourse {
    private Integer abilityId;

    private Integer courseId;

    private String creditType;

    private Double creditNum;

    private Integer isObligatory;

    public Integer getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(Integer abilityId) {
        this.abilityId = abilityId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public Double getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(Double creditNum) {
        this.creditNum = creditNum;
    }

    public Integer getIsObligatory() {
        return isObligatory;
    }

    public void setIsObligatory(Integer isObligatory) {
        this.isObligatory = isObligatory;
    }
}