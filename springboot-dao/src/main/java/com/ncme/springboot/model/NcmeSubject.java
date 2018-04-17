package com.ncme.springboot.model;

public class NcmeSubject {
    private String subjectId;

    private String subjectName;

    private String subject2Id;

    private String subject2Name;

    private String guide;

    private String expId;

    private String keyGuide;

    private String pracGuide;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubject2Id() {
        return subject2Id;
    }

    public void setSubject2Id(String subject2Id) {
        this.subject2Id = subject2Id;
    }

    public String getSubject2Name() {
        return subject2Name;
    }

    public void setSubject2Name(String subject2Name) {
        this.subject2Name = subject2Name;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getExpId() {
        return expId;
    }

    public void setExpId(String expId) {
        this.expId = expId;
    }

    public String getKeyGuide() {
        return keyGuide;
    }

    public void setKeyGuide(String keyGuide) {
        this.keyGuide = keyGuide;
    }

    public String getPracGuide() {
        return pracGuide;
    }

    public void setPracGuide(String pracGuide) {
        this.pracGuide = pracGuide;
    }
}