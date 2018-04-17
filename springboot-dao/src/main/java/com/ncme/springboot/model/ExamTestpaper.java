package com.ncme.springboot.model;

import java.util.Date;

public class ExamTestpaper {
    private Integer id;

    private Integer parentId;

    private Integer childPaperNum;

    private Integer typeId;

    private String name;

    private Double paperScore;

    private Integer paperMode;

    private Integer questionNum;

    private Date createDate;

    private Integer grade;

    private Integer state;

    private Date usefulDate;

    private Integer paperPlanType;

    private Integer examinationTime;

    private Integer redoNum;

    private Integer isnotViewScore;

    private Integer isnotExpPaper;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getChildPaperNum() {
        return childPaperNum;
    }

    public void setChildPaperNum(Integer childPaperNum) {
        this.childPaperNum = childPaperNum;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(Double paperScore) {
        this.paperScore = paperScore;
    }

    public Integer getPaperMode() {
        return paperMode;
    }

    public void setPaperMode(Integer paperMode) {
        this.paperMode = paperMode;
    }

    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getUsefulDate() {
        return usefulDate;
    }

    public void setUsefulDate(Date usefulDate) {
        this.usefulDate = usefulDate;
    }

    public Integer getPaperPlanType() {
        return paperPlanType;
    }

    public void setPaperPlanType(Integer paperPlanType) {
        this.paperPlanType = paperPlanType;
    }

    public Integer getExaminationTime() {
        return examinationTime;
    }

    public void setExaminationTime(Integer examinationTime) {
        this.examinationTime = examinationTime;
    }

    public Integer getRedoNum() {
        return redoNum;
    }

    public void setRedoNum(Integer redoNum) {
        this.redoNum = redoNum;
    }

    public Integer getIsnotViewScore() {
        return isnotViewScore;
    }

    public void setIsnotViewScore(Integer isnotViewScore) {
        this.isnotViewScore = isnotViewScore;
    }

    public Integer getIsnotExpPaper() {
        return isnotExpPaper;
    }

    public void setIsnotExpPaper(Integer isnotExpPaper) {
        this.isnotExpPaper = isnotExpPaper;
    }
}