package com.ncme.springboot.model;

public class QuestSooAtAppname {
    private String mod;

    private Integer mh;

    private String act;

    private Integer ah;

    private Integer traceFileId;

    private Integer sqlId;

    private Integer parseId;

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public Integer getMh() {
        return mh;
    }

    public void setMh(Integer mh) {
        this.mh = mh;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public Integer getAh() {
        return ah;
    }

    public void setAh(Integer ah) {
        this.ah = ah;
    }

    public Integer getTraceFileId() {
        return traceFileId;
    }

    public void setTraceFileId(Integer traceFileId) {
        this.traceFileId = traceFileId;
    }

    public Integer getSqlId() {
        return sqlId;
    }

    public void setSqlId(Integer sqlId) {
        this.sqlId = sqlId;
    }

    public Integer getParseId() {
        return parseId;
    }

    public void setParseId(Integer parseId) {
        this.parseId = parseId;
    }
}