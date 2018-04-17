package com.ncme.springboot.model;

public class QuestSooAtSqlExecError {
    private Integer traceFileId;

    private Integer sqlId;

    private Integer parseId;

    private Integer executionId;

    private String errorId;

    private Integer tim;

    private String err;

    private String sqlerrm;

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

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public Integer getTim() {
        return tim;
    }

    public void setTim(Integer tim) {
        this.tim = tim;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public String getSqlerrm() {
        return sqlerrm;
    }

    public void setSqlerrm(String sqlerrm) {
        this.sqlerrm = sqlerrm;
    }
}