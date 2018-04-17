package com.ncme.springboot.model;

import java.util.Date;

public class SystemStudyCredit {
    private Integer id;

    private Integer userId;

    private Integer courseId;

    private Integer orgId;

    private Integer applyYear;

    private String creditType;

    private String courseSerial;

    private Date applydate;

    private Date startdate;

    private Date passdate;

    private Integer answertimes;

    private String applyType;

    private String applySubtype;

    private String cardNo;

    private Double applyCredit;

    private Date senddate;

    private String serialInt;

    private String orderInt;

    private String operator;

    private Integer siteId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getApplyYear() {
        return applyYear;
    }

    public void setApplyYear(Integer applyYear) {
        this.applyYear = applyYear;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getCourseSerial() {
        return courseSerial;
    }

    public void setCourseSerial(String courseSerial) {
        this.courseSerial = courseSerial;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getPassdate() {
        return passdate;
    }

    public void setPassdate(Date passdate) {
        this.passdate = passdate;
    }

    public Integer getAnswertimes() {
        return answertimes;
    }

    public void setAnswertimes(Integer answertimes) {
        this.answertimes = answertimes;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getApplySubtype() {
        return applySubtype;
    }

    public void setApplySubtype(String applySubtype) {
        this.applySubtype = applySubtype;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Double getApplyCredit() {
        return applyCredit;
    }

    public void setApplyCredit(Double applyCredit) {
        this.applyCredit = applyCredit;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public String getSerialInt() {
        return serialInt;
    }

    public void setSerialInt(String serialInt) {
        this.serialInt = serialInt;
    }

    public String getOrderInt() {
        return orderInt;
    }

    public void setOrderInt(String orderInt) {
        this.orderInt = orderInt;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}