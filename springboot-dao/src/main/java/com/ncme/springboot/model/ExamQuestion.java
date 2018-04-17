package com.ncme.springboot.model;

import java.util.Date;

public class ExamQuestion {
    private Integer id;

    private Integer questionLabelId;

    private Integer parentId;

    private String content;

    private Integer state;

    private Integer grade;

    private Integer differ;

    private String analyse;

    private String source;

    private Integer seq;

    private Date createDate;

    private String author;

    private Date onlineDate;

    private Integer isnotMultimedia;

    private Double practiceScore;

    private Integer source2;

    private String checker;

    private String surname;

    private String opinion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionLabelId() {
        return questionLabelId;
    }

    public void setQuestionLabelId(Integer questionLabelId) {
        this.questionLabelId = questionLabelId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getDiffer() {
        return differ;
    }

    public void setDiffer(Integer differ) {
        this.differ = differ;
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getOnlineDate() {
        return onlineDate;
    }

    public void setOnlineDate(Date onlineDate) {
        this.onlineDate = onlineDate;
    }

    public Integer getIsnotMultimedia() {
        return isnotMultimedia;
    }

    public void setIsnotMultimedia(Integer isnotMultimedia) {
        this.isnotMultimedia = isnotMultimedia;
    }

    public Double getPracticeScore() {
        return practiceScore;
    }

    public void setPracticeScore(Double practiceScore) {
        this.practiceScore = practiceScore;
    }

    public Integer getSource2() {
        return source2;
    }

    public void setSource2(Integer source2) {
        this.source2 = source2;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}