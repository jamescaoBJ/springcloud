package com.ncme.springboot.model;

public class CvLiveRefUnit {
    private Integer id;

    private Integer cvId;

    private Integer unitId;

    private String coursewareNo;

    private String classNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCvId() {
        return cvId;
    }

    public void setCvId(Integer cvId) {
        this.cvId = cvId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getCoursewareNo() {
        return coursewareNo;
    }

    public void setCoursewareNo(String coursewareNo) {
        this.coursewareNo = coursewareNo;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }
}