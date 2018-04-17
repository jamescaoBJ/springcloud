package com.ncme.springboot.model;

public class TrainContentCourse {
    private Integer courseId;

    private String cmeCourseId;

    private String courseName;

    private Integer subjectId;

    private Double score;

    private Integer status;

    private String type;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCmeCourseId() {
        return cmeCourseId;
    }

    public void setCmeCourseId(String cmeCourseId) {
        this.cmeCourseId = cmeCourseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}