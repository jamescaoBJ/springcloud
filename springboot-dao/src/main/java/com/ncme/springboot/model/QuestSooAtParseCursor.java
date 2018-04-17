package com.ncme.springboot.model;

import java.util.Date;

public class QuestSooAtParseCursor {
    private Integer traceFileId;

    private Integer sqlId;

    private Integer parseId;

    private Integer sessionId;

    private Integer serialInt;

    private Integer cursorNo;

    private Integer len;

    private Integer dep;

    private Integer userid;

    private Integer oct;

    private Integer lid;

    private Integer tim;

    private Date adjustedTime;

    private Integer err;

    private Integer cpu;

    private Integer elapsed;

    private Integer physicalReads;

    private Integer consistentReads;

    private Integer currentReads;

    private Integer libcacheMisses;

    private Integer rowCount;

    private Integer optimizerGoal;

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

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getSerialInt() {
        return serialInt;
    }

    public void setSerialInt(Integer serialInt) {
        this.serialInt = serialInt;
    }

    public Integer getCursorNo() {
        return cursorNo;
    }

    public void setCursorNo(Integer cursorNo) {
        this.cursorNo = cursorNo;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public Integer getDep() {
        return dep;
    }

    public void setDep(Integer dep) {
        this.dep = dep;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOct() {
        return oct;
    }

    public void setOct(Integer oct) {
        this.oct = oct;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getTim() {
        return tim;
    }

    public void setTim(Integer tim) {
        this.tim = tim;
    }

    public Date getAdjustedTime() {
        return adjustedTime;
    }

    public void setAdjustedTime(Date adjustedTime) {
        this.adjustedTime = adjustedTime;
    }

    public Integer getErr() {
        return err;
    }

    public void setErr(Integer err) {
        this.err = err;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public Integer getElapsed() {
        return elapsed;
    }

    public void setElapsed(Integer elapsed) {
        this.elapsed = elapsed;
    }

    public Integer getPhysicalReads() {
        return physicalReads;
    }

    public void setPhysicalReads(Integer physicalReads) {
        this.physicalReads = physicalReads;
    }

    public Integer getConsistentReads() {
        return consistentReads;
    }

    public void setConsistentReads(Integer consistentReads) {
        this.consistentReads = consistentReads;
    }

    public Integer getCurrentReads() {
        return currentReads;
    }

    public void setCurrentReads(Integer currentReads) {
        this.currentReads = currentReads;
    }

    public Integer getLibcacheMisses() {
        return libcacheMisses;
    }

    public void setLibcacheMisses(Integer libcacheMisses) {
        this.libcacheMisses = libcacheMisses;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getOptimizerGoal() {
        return optimizerGoal;
    }

    public void setOptimizerGoal(Integer optimizerGoal) {
        this.optimizerGoal = optimizerGoal;
    }
}