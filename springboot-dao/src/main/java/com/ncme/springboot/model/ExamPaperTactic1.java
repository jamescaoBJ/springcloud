package com.ncme.springboot.model;

public class ExamPaperTactic1 {
    private Integer tacticId;

    private Integer questionLabelId;

    private Integer num;

    private Double score;

    public Integer getTacticId() {
        return tacticId;
    }

    public void setTacticId(Integer tacticId) {
        this.tacticId = tacticId;
    }

    public Integer getQuestionLabelId() {
        return questionLabelId;
    }

    public void setQuestionLabelId(Integer questionLabelId) {
        this.questionLabelId = questionLabelId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}