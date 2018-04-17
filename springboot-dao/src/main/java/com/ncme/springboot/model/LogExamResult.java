package com.ncme.springboot.model;

public class LogExamResult extends LogExamResultKey {
    private String questionResult;

    private Integer isnotRight;

    private Integer questionlabelId;

    private Integer seq;

    private Integer parentId;

    private String rightCount;

    private Double score;

    private Double realityscore;

    private String selectResult;

    public String getQuestionResult() {
        return questionResult;
    }

    public void setQuestionResult(String questionResult) {
        this.questionResult = questionResult;
    }

    public Integer getIsnotRight() {
        return isnotRight;
    }

    public void setIsnotRight(Integer isnotRight) {
        this.isnotRight = isnotRight;
    }

    public Integer getQuestionlabelId() {
        return questionlabelId;
    }

    public void setQuestionlabelId(Integer questionlabelId) {
        this.questionlabelId = questionlabelId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRightCount() {
        return rightCount;
    }

    public void setRightCount(String rightCount) {
        this.rightCount = rightCount;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getRealityscore() {
        return realityscore;
    }

    public void setRealityscore(Double realityscore) {
        this.realityscore = realityscore;
    }

    public String getSelectResult() {
        return selectResult;
    }

    public void setSelectResult(String selectResult) {
        this.selectResult = selectResult;
    }
}