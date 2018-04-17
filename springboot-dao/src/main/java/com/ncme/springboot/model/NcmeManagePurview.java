package com.ncme.springboot.model;

public class NcmeManagePurview {
    private String loginName;

    private String funcId;

    private String funcAdd;

    private String funcUpdate;

    private String funcDel;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public String getFuncAdd() {
        return funcAdd;
    }

    public void setFuncAdd(String funcAdd) {
        this.funcAdd = funcAdd;
    }

    public String getFuncUpdate() {
        return funcUpdate;
    }

    public void setFuncUpdate(String funcUpdate) {
        this.funcUpdate = funcUpdate;
    }

    public String getFuncDel() {
        return funcDel;
    }

    public void setFuncDel(String funcDel) {
        this.funcDel = funcDel;
    }
}