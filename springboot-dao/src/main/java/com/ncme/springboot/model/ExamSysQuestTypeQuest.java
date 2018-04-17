package com.ncme.springboot.model;

public class ExamSysQuestTypeQuest {
    private Integer subTypeId;

    private Integer questionId;

    private Integer subSysId;

    private Integer state;

    public Integer getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(Integer subTypeId) {
        this.subTypeId = subTypeId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getSubSysId() {
        return subSysId;
    }

    public void setSubSysId(Integer subSysId) {
        this.subSysId = subSysId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}