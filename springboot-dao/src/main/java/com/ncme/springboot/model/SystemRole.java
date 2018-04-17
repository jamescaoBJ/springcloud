package com.ncme.springboot.model;

public class SystemRole {
    private Integer roleId;

    private String roleName;

    private String roleNameDesc;

    private Integer status;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNameDesc() {
        return roleNameDesc;
    }

    public void setRoleNameDesc(String roleNameDesc) {
        this.roleNameDesc = roleNameDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}