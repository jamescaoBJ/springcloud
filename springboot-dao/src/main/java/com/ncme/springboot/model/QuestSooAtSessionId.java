package com.ncme.springboot.model;

public class QuestSooAtSessionId {
    private Integer sessionId;

    private Integer sid;

    private Integer serial;

    private Integer traceFileId;

    private Integer sqlId;

    private Integer parseId;

    private Integer executionId;

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
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

    public Integer getExecutionId() {
        return executionId;
    }

    public void setExecutionId(Integer executionId) {
        this.executionId = executionId;
    }
}