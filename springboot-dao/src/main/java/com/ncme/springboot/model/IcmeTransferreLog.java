package com.ncme.springboot.model;

import java.util.Date;

public class IcmeTransferreLog {
    private Integer id;

    private Integer transOutOrgId;

    private Integer transInOrgId;

    private Date transOutDate;

    private Date transInDate;

    private Integer icmeUserId;

    private Integer transOutUserId;

    private Integer transInUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTransOutOrgId() {
        return transOutOrgId;
    }

    public void setTransOutOrgId(Integer transOutOrgId) {
        this.transOutOrgId = transOutOrgId;
    }

    public Integer getTransInOrgId() {
        return transInOrgId;
    }

    public void setTransInOrgId(Integer transInOrgId) {
        this.transInOrgId = transInOrgId;
    }

    public Date getTransOutDate() {
        return transOutDate;
    }

    public void setTransOutDate(Date transOutDate) {
        this.transOutDate = transOutDate;
    }

    public Date getTransInDate() {
        return transInDate;
    }

    public void setTransInDate(Date transInDate) {
        this.transInDate = transInDate;
    }

    public Integer getIcmeUserId() {
        return icmeUserId;
    }

    public void setIcmeUserId(Integer icmeUserId) {
        this.icmeUserId = icmeUserId;
    }

    public Integer getTransOutUserId() {
        return transOutUserId;
    }

    public void setTransOutUserId(Integer transOutUserId) {
        this.transOutUserId = transOutUserId;
    }

    public Integer getTransInUserId() {
        return transInUserId;
    }

    public void setTransInUserId(Integer transInUserId) {
        this.transInUserId = transInUserId;
    }
}