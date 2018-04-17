package com.ncme.springboot.model;

import java.util.Date;

public class IcmeAwardScoreDetail {
    private Integer id;

    private Integer awardScoreStandardId;

    private String name;

    private Integer value;

    private String unit;

    private Double score;

    private String remark;

    private Double maxScoreLimit;

    private Date createDate;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAwardScoreStandardId() {
        return awardScoreStandardId;
    }

    public void setAwardScoreStandardId(Integer awardScoreStandardId) {
        this.awardScoreStandardId = awardScoreStandardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getMaxScoreLimit() {
        return maxScoreLimit;
    }

    public void setMaxScoreLimit(Double maxScoreLimit) {
        this.maxScoreLimit = maxScoreLimit;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}