package com.ncme.springboot.model;

public class IcmeQaStandardScoreType {
    private Integer scoreTypeId;

    private Integer qaStandardId;

    public Integer getScoreTypeId() {
        return scoreTypeId;
    }

    public void setScoreTypeId(Integer scoreTypeId) {
        this.scoreTypeId = scoreTypeId;
    }

    public Integer getQaStandardId() {
        return qaStandardId;
    }

    public void setQaStandardId(Integer qaStandardId) {
        this.qaStandardId = qaStandardId;
    }
}