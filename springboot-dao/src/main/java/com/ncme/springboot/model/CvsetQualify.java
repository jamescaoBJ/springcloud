package com.ncme.springboot.model;

public class CvsetQualify {
    private Integer cvSetId;

    private Integer deliManId;

    private String opinion;

    private String opinionType;

    public Integer getCvSetId() {
        return cvSetId;
    }

    public void setCvSetId(Integer cvSetId) {
        this.cvSetId = cvSetId;
    }

    public Integer getDeliManId() {
        return deliManId;
    }

    public void setDeliManId(Integer deliManId) {
        this.deliManId = deliManId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getOpinionType() {
        return opinionType;
    }

    public void setOpinionType(String opinionType) {
        this.opinionType = opinionType;
    }
}