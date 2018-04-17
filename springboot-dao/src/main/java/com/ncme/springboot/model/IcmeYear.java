package com.ncme.springboot.model;

import java.util.Date;

public class IcmeYear {
    private Integer id;

    private String year;

    private Integer status;

    private Date createDate;

    private Date startDate;

    private Date endDate;

    private Integer annualScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getAnnualScore() {
        return annualScore;
    }

    public void setAnnualScore(Integer annualScore) {
        this.annualScore = annualScore;
    }
}