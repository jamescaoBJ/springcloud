package com.ncme.springboot.model;

public class QuestSooAtParseWaits {
    private Integer traceFileId;

    private Integer sqlId;

    private Integer parseId;

    private Integer waitId;

    private String nam;

    private Integer obj;

    private Integer waitCount;

    private Integer sumElapsed;

    private Integer sumsquaresElapsed;

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

    public Integer getWaitId() {
        return waitId;
    }

    public void setWaitId(Integer waitId) {
        this.waitId = waitId;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public Integer getObj() {
        return obj;
    }

    public void setObj(Integer obj) {
        this.obj = obj;
    }

    public Integer getWaitCount() {
        return waitCount;
    }

    public void setWaitCount(Integer waitCount) {
        this.waitCount = waitCount;
    }

    public Integer getSumElapsed() {
        return sumElapsed;
    }

    public void setSumElapsed(Integer sumElapsed) {
        this.sumElapsed = sumElapsed;
    }

    public Integer getSumsquaresElapsed() {
        return sumsquaresElapsed;
    }

    public void setSumsquaresElapsed(Integer sumsquaresElapsed) {
        this.sumsquaresElapsed = sumsquaresElapsed;
    }
}