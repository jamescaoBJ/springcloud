package com.ncme.springboot.model;

import java.util.Date;

public class CvLive {
    private Integer id;

    private String classNo;

    private String className;

    private String number;

    private String teacherToken;

    private String assistantToken;

    private String studentToken;

    private String studentclientToken;

    private Date startDate;

    private Date invalidDate;

    private String teacherJoinUrl;

    private String studentJoinUrl;

    private Integer isWebJoin;

    private Integer isClientJoin;

    private Integer scene;

    private Integer cvId;

    private Date createDate;

    private Date modifyDate;

    private Integer courseMakeType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTeacherToken() {
        return teacherToken;
    }

    public void setTeacherToken(String teacherToken) {
        this.teacherToken = teacherToken;
    }

    public String getAssistantToken() {
        return assistantToken;
    }

    public void setAssistantToken(String assistantToken) {
        this.assistantToken = assistantToken;
    }

    public String getStudentToken() {
        return studentToken;
    }

    public void setStudentToken(String studentToken) {
        this.studentToken = studentToken;
    }

    public String getStudentclientToken() {
        return studentclientToken;
    }

    public void setStudentclientToken(String studentclientToken) {
        this.studentclientToken = studentclientToken;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    public String getTeacherJoinUrl() {
        return teacherJoinUrl;
    }

    public void setTeacherJoinUrl(String teacherJoinUrl) {
        this.teacherJoinUrl = teacherJoinUrl;
    }

    public String getStudentJoinUrl() {
        return studentJoinUrl;
    }

    public void setStudentJoinUrl(String studentJoinUrl) {
        this.studentJoinUrl = studentJoinUrl;
    }

    public Integer getIsWebJoin() {
        return isWebJoin;
    }

    public void setIsWebJoin(Integer isWebJoin) {
        this.isWebJoin = isWebJoin;
    }

    public Integer getIsClientJoin() {
        return isClientJoin;
    }

    public void setIsClientJoin(Integer isClientJoin) {
        this.isClientJoin = isClientJoin;
    }

    public Integer getScene() {
        return scene;
    }

    public void setScene(Integer scene) {
        this.scene = scene;
    }

    public Integer getCvId() {
        return cvId;
    }

    public void setCvId(Integer cvId) {
        this.cvId = cvId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getCourseMakeType() {
        return courseMakeType;
    }

    public void setCourseMakeType(Integer courseMakeType) {
        this.courseMakeType = courseMakeType;
    }
}