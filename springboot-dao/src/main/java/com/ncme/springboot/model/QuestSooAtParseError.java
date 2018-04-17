package com.ncme.springboot.model;

public class QuestSooAtParseError {
    private Integer traceFileId;

    private Integer sqlId;

    private Integer parseId;

    private Integer errorId;

    private Integer err;

    private Integer tim;

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

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public Integer getErr() {
        return err;
    }

    public void setErr(Integer err) {
        this.err = err;
    }

    public Integer getTim() {
        return tim;
    }

    public void setTim(Integer tim) {
        this.tim = tim;
    }

    public String getSqlerrm() {
        return sqlerrm;
    }

    public void setSqlerrm(String sqlerrm) {
        this.sqlerrm = sqlerrm;
    }
}