package com.ncme.springboot.model;

public class ExamQuestPropvalCascade {
    private Integer questionId;

    private String propvalName;

    private String propvalId;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getPropvalName() {
        return propvalName;
    }

    public void setPropvalName(String propvalName) {
        this.propvalName = propvalName;
    }

    public String getPropvalId() {
        return propvalId;
    }

    public void setPropvalId(String propvalId) {
        this.propvalId = propvalId;
    }
}