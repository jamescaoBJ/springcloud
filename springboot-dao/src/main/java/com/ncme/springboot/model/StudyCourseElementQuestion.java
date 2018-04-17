package com.ncme.springboot.model;

public class StudyCourseElementQuestion {
    private Integer studyCourseElementId;

    private Integer studyCourseQuestionId;

    private Integer seq;

    public Integer getStudyCourseElementId() {
        return studyCourseElementId;
    }

    public void setStudyCourseElementId(Integer studyCourseElementId) {
        this.studyCourseElementId = studyCourseElementId;
    }

    public Integer getStudyCourseQuestionId() {
        return studyCourseQuestionId;
    }

    public void setStudyCourseQuestionId(Integer studyCourseQuestionId) {
        this.studyCourseQuestionId = studyCourseQuestionId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}