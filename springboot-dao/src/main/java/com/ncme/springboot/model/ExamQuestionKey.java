package com.ncme.springboot.model;

public class ExamQuestionKey {
    private Integer id;

    private Integer questionId;

    private String content;

    private Integer isnotTrue;

    private Integer seq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsnotTrue() {
        return isnotTrue;
    }

    public void setIsnotTrue(Integer isnotTrue) {
        this.isnotTrue = isnotTrue;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}