package com.ncme.springboot.model;

import java.util.Date;

public class SystemOperateLog {
    private Integer operateId;

    private String visitIp;

    private String requestUrl;

    private Integer userId;

    private String operateLoginName;

    private String operateType;

    private String operateContext;

    private String operatePlatform;

    private String moduleName;

    private Date operateTime;

    private Date createTime;

    public Integer getOperateId() {
        return operateId;
    }

    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }

    public String getVisitIp() {
        return visitIp;
    }

    public void setVisitIp(String visitIp) {
        this.visitIp = visitIp;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOperateLoginName() {
        return operateLoginName;
    }

    public void setOperateLoginName(String operateLoginName) {
        this.operateLoginName = operateLoginName;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getOperateContext() {
        return operateContext;
    }

    public void setOperateContext(String operateContext) {
        this.operateContext = operateContext;
    }

    public String getOperatePlatform() {
        return operatePlatform;
    }

    public void setOperatePlatform(String operatePlatform) {
        this.operatePlatform = operatePlatform;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}