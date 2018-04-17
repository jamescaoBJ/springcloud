package com.ncme.springboot.model;

import java.util.Date;

public class IcmeQaStandard {
    private Integer id;

    private Integer yearId;

    private Integer condition;

    private String expression;

    private Double score;

    private String specificProvisions;

    private String remark;

    private Date createDate;

    private Integer status;

    private Integer seq;

    private String replaceConditionRemark;

    private Date lastUpdateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getSpecificProvisions() {
        return specificProvisions;
    }

    public void setSpecificProvisions(String specificProvisions) {
        this.specificProvisions = specificProvisions;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getReplaceConditionRemark() {
        return replaceConditionRemark;
    }

    public void setReplaceConditionRemark(String replaceConditionRemark) {
        this.replaceConditionRemark = replaceConditionRemark;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}