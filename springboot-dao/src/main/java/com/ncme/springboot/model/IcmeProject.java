package com.ncme.springboot.model;

import java.util.Date;

public class IcmeProject {
    private Integer id;

    private String projectName;

    private String projectCode;

    private Integer orgId;

    private Integer projectTypeId;

    private Integer scoreTypeId;

    private Integer projectActivityId;

    private Integer yearId;

    private Integer siteId;

    private String projectHoldOrg;

    private Date projectHoldDate;

    private Date projectHoldEndDate;

    private String chargePerson;

    private Double projectClassHour;

    private Double projectClassScore;

    private Integer approvalOrgId;

    private String verifyCode;

    private Integer status;

    private Date createDate;

    private Integer createUserId;

    private Date lastUpdateDate;

    private Integer lastUpdateUserId;

    private Integer projectType;

    private Integer nprProjectId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Integer projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public Integer getScoreTypeId() {
        return scoreTypeId;
    }

    public void setScoreTypeId(Integer scoreTypeId) {
        this.scoreTypeId = scoreTypeId;
    }

    public Integer getProjectActivityId() {
        return projectActivityId;
    }

    public void setProjectActivityId(Integer projectActivityId) {
        this.projectActivityId = projectActivityId;
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getProjectHoldOrg() {
        return projectHoldOrg;
    }

    public void setProjectHoldOrg(String projectHoldOrg) {
        this.projectHoldOrg = projectHoldOrg;
    }

    public Date getProjectHoldDate() {
        return projectHoldDate;
    }

    public void setProjectHoldDate(Date projectHoldDate) {
        this.projectHoldDate = projectHoldDate;
    }

    public Date getProjectHoldEndDate() {
        return projectHoldEndDate;
    }

    public void setProjectHoldEndDate(Date projectHoldEndDate) {
        this.projectHoldEndDate = projectHoldEndDate;
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson;
    }

    public Double getProjectClassHour() {
        return projectClassHour;
    }

    public void setProjectClassHour(Double projectClassHour) {
        this.projectClassHour = projectClassHour;
    }

    public Double getProjectClassScore() {
        return projectClassScore;
    }

    public void setProjectClassScore(Double projectClassScore) {
        this.projectClassScore = projectClassScore;
    }

    public Integer getApprovalOrgId() {
        return approvalOrgId;
    }

    public void setApprovalOrgId(Integer approvalOrgId) {
        this.approvalOrgId = approvalOrgId;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public Integer getNprProjectId() {
        return nprProjectId;
    }

    public void setNprProjectId(Integer nprProjectId) {
        this.nprProjectId = nprProjectId;
    }
}