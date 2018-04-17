package com.ncme.springboot.model;

public class LogExamResultKey {
    private Integer logExamId;

    private Integer questionId;

    public Integer getLogExamId() {
        return logExamId;
    }

    public void setLogExamId(Integer logExamId) {
        this.logExamId = logExamId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}