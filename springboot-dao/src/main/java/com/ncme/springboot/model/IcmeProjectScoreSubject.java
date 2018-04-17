package com.ncme.springboot.model;

import java.util.Date;

public class IcmeProjectScoreSubject {
    private Integer id;

    private Integer projectScoreId;

    private Integer subjectId;

    private Integer swipeId;

    private Date cardBeginDate;

    private Date cardEndDate;

    private Integer status;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectScoreId() {
        return projectScoreId;
    }

    public void setProjectScoreId(Integer projectScoreId) {
        this.projectScoreId = projectScoreId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSwipeId() {
        return swipeId;
    }

    public void setSwipeId(Integer swipeId) {
        this.swipeId = swipeId;
    }

    public Date getCardBeginDate() {
        return cardBeginDate;
    }

    public void setCardBeginDate(Date cardBeginDate) {
        this.cardBeginDate = cardBeginDate;
    }

    public Date getCardEndDate() {
        return cardEndDate;
    }

    public void setCardEndDate(Date cardEndDate) {
        this.cardEndDate = cardEndDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}