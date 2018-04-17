package com.ncme.springboot.model;

import java.util.Date;

public class IcmeProjectScore {
    private Integer id;

    private Integer icmeUserId;

    private Integer icmeProjectId;

    private Integer orgProjectId;

    private Integer projectScoreType;

    private String scoreRemark;

    private Integer giveOrgId;

    private Integer fromOrgId;

    private Integer toOrgId;

    private Integer scoreCheckFlag;

    private Integer orgId;

    private Integer createUserId;

    private Date createDate;

    private Date lastUpdateDate;

    private Integer lastUpdateUserId;

    private Integer status;

    private Integer repeatFlag;

    private Integer sourceFlag;

    private Date scoreCheckDate;

    private Date cardBeginDate;

    private Date grantScoreDate;

    private String remoteAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIcmeUserId() {
        return icmeUserId;
    }

    public void setIcmeUserId(Integer icmeUserId) {
        this.icmeUserId = icmeUserId;
    }

    public Integer getIcmeProjectId() {
        return icmeProjectId;
    }

    public void setIcmeProjectId(Integer icmeProjectId) {
        this.icmeProjectId = icmeProjectId;
    }

    public Integer getOrgProjectId() {
        return orgProjectId;
    }

    public void setOrgProjectId(Integer orgProjectId) {
        this.orgProjectId = orgProjectId;
    }

    public Integer getProjectScoreType() {
        return projectScoreType;
    }

    public void setProjectScoreType(Integer projectScoreType) {
        this.projectScoreType = projectScoreType;
    }

    public String getScoreRemark() {
        return scoreRemark;
    }

    public void setScoreRemark(String scoreRemark) {
        this.scoreRemark = scoreRemark;
    }

    public Integer getGiveOrgId() {
        return giveOrgId;
    }

    public void setGiveOrgId(Integer giveOrgId) {
        this.giveOrgId = giveOrgId;
    }

    public Integer getFromOrgId() {
        return fromOrgId;
    }

    public void setFromOrgId(Integer fromOrgId) {
        this.fromOrgId = fromOrgId;
    }

    public Integer getToOrgId() {
        return toOrgId;
    }

    public void setToOrgId(Integer toOrgId) {
        this.toOrgId = toOrgId;
    }

    public Integer getScoreCheckFlag() {
        return scoreCheckFlag;
    }

    public void setScoreCheckFlag(Integer scoreCheckFlag) {
        this.scoreCheckFlag = scoreCheckFlag;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRepeatFlag() {
        return repeatFlag;
    }

    public void setRepeatFlag(Integer repeatFlag) {
        this.repeatFlag = repeatFlag;
    }

    public Integer getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(Integer sourceFlag) {
        this.sourceFlag = sourceFlag;
    }

    public Date getScoreCheckDate() {
        return scoreCheckDate;
    }

    public void setScoreCheckDate(Date scoreCheckDate) {
        this.scoreCheckDate = scoreCheckDate;
    }

    public Date getCardBeginDate() {
        return cardBeginDate;
    }

    public void setCardBeginDate(Date cardBeginDate) {
        this.cardBeginDate = cardBeginDate;
    }

    public Date getGrantScoreDate() {
        return grantScoreDate;
    }

    public void setGrantScoreDate(Date grantScoreDate) {
        this.grantScoreDate = grantScoreDate;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}