package com.ncme.springboot.model;

import java.util.Date;

public class StudyCourseType {
    private Integer id;

    private String courseTypeName;

    private Integer parentCourseTypeId;

    private Integer seq;

    private Integer allClassHours;

    private Integer type;

    private String examineRequire;

    private String trainPrinciples;

    private String introduction;

    private Integer status;

    private Date createDate;

    private Date lastUpdateDate;

    private Integer isLastLevel;

    private Integer lastUpdateUserId;

    private Integer createUserId;

    private Integer isFree;

    private Integer layer;

    private String subjectId;

    private String subjectName;

    private String subject2Id;

    private String subject2Name;

    private String guide;

    private String expId;

    private String keyGuide;

    private String pracGuide;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    public Integer getParentCourseTypeId() {
        return parentCourseTypeId;
    }

    public void setParentCourseTypeId(Integer parentCourseTypeId) {
        this.parentCourseTypeId = parentCourseTypeId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getAllClassHours() {
        return allClassHours;
    }

    public void setAllClassHours(Integer allClassHours) {
        this.allClassHours = allClassHours;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getExamineRequire() {
        return examineRequire;
    }

    public void setExamineRequire(String examineRequire) {
        this.examineRequire = examineRequire;
    }

    public String getTrainPrinciples() {
        return trainPrinciples;
    }

    public void setTrainPrinciples(String trainPrinciples) {
        this.trainPrinciples = trainPrinciples;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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

    public Integer getIsLastLevel() {
        return isLastLevel;
    }

    public void setIsLastLevel(Integer isLastLevel) {
        this.isLastLevel = isLastLevel;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubject2Id() {
        return subject2Id;
    }

    public void setSubject2Id(String subject2Id) {
        this.subject2Id = subject2Id;
    }

    public String getSubject2Name() {
        return subject2Name;
    }

    public void setSubject2Name(String subject2Name) {
        this.subject2Name = subject2Name;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getExpId() {
        return expId;
    }

    public void setExpId(String expId) {
        this.expId = expId;
    }

    public String getKeyGuide() {
        return keyGuide;
    }

    public void setKeyGuide(String keyGuide) {
        this.keyGuide = keyGuide;
    }

    public String getPracGuide() {
        return pracGuide;
    }

    public void setPracGuide(String pracGuide) {
        this.pracGuide = pracGuide;
    }
}