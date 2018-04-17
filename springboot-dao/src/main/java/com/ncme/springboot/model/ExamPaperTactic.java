package com.ncme.springboot.model;

public class ExamPaperTactic {
    private Integer id;

    private Integer paperId;

    private String tacticName;

    private String questionTypeId;

    private String questionTypeName;

    private Integer examPaperTypeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getTacticName() {
        return tacticName;
    }

    public void setTacticName(String tacticName) {
        this.tacticName = tacticName;
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(String questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    public Integer getExamPaperTypeId() {
        return examPaperTypeId;
    }

    public void setExamPaperTypeId(Integer examPaperTypeId) {
        this.examPaperTypeId = examPaperTypeId;
    }
}