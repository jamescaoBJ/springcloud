package com.ncme.springboot.model;

public class IcmeOrgType {
    private Integer id;

    private String orgTypeName;

    private Integer orgLevle;

    private Integer orgId;

    private Integer adminId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgTypeName() {
        return orgTypeName;
    }

    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }

    public Integer getOrgLevle() {
        return orgLevle;
    }

    public void setOrgLevle(Integer orgLevle) {
        this.orgLevle = orgLevle;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}