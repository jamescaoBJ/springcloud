package com.ncme.springboot.model;

public class IcmeOrgPost {
    private Integer id;

    private Integer parentOrgId;

    private String orgName;

    private Integer orgLevle;

    private Integer orgPost;

    private Integer status;

    private Integer seq;

    private String orgShort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(Integer parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getOrgLevle() {
        return orgLevle;
    }

    public void setOrgLevle(Integer orgLevle) {
        this.orgLevle = orgLevle;
    }

    public Integer getOrgPost() {
        return orgPost;
    }

    public void setOrgPost(Integer orgPost) {
        this.orgPost = orgPost;
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

    public String getOrgShort() {
        return orgShort;
    }

    public void setOrgShort(String orgShort) {
        this.orgShort = orgShort;
    }
}