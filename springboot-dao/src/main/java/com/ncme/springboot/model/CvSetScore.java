package com.ncme.springboot.model;

import java.math.BigDecimal;

public class CvSetScore {
    private Integer cvSetId;

    private BigDecimal grade;

    private Integer studyTimes;

    private BigDecimal critiquescore1;

    private BigDecimal critiquescore2;

    private BigDecimal critiquescore3;

    private BigDecimal critiquescore4;

    public Integer getCvSetId() {
        return cvSetId;
    }

    public void setCvSetId(Integer cvSetId) {
        this.cvSetId = cvSetId;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public Integer getStudyTimes() {
        return studyTimes;
    }

    public void setStudyTimes(Integer studyTimes) {
        this.studyTimes = studyTimes;
    }

    public BigDecimal getCritiquescore1() {
        return critiquescore1;
    }

    public void setCritiquescore1(BigDecimal critiquescore1) {
        this.critiquescore1 = critiquescore1;
    }

    public BigDecimal getCritiquescore2() {
        return critiquescore2;
    }

    public void setCritiquescore2(BigDecimal critiquescore2) {
        this.critiquescore2 = critiquescore2;
    }

    public BigDecimal getCritiquescore3() {
        return critiquescore3;
    }

    public void setCritiquescore3(BigDecimal critiquescore3) {
        this.critiquescore3 = critiquescore3;
    }

    public BigDecimal getCritiquescore4() {
        return critiquescore4;
    }

    public void setCritiquescore4(BigDecimal critiquescore4) {
        this.critiquescore4 = critiquescore4;
    }
}