package com.ncme.springboot.model;

public class HysDataRoles {
    private Integer id;

    private Integer manageKind;

    private String controlAuth;

    private String statisticsAuth;

    private String variety;

    private Integer roleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManageKind() {
        return manageKind;
    }

    public void setManageKind(Integer manageKind) {
        this.manageKind = manageKind;
    }

    public String getControlAuth() {
        return controlAuth;
    }

    public void setControlAuth(String controlAuth) {
        this.controlAuth = controlAuth;
    }

    public String getStatisticsAuth() {
        return statisticsAuth;
    }

    public void setStatisticsAuth(String statisticsAuth) {
        this.statisticsAuth = statisticsAuth;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}