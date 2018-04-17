package com.ncme.springboot.model;

import java.util.Date;

public class QuestSooAtSqlExecutions {
    private Integer traceFileId;

    private Integer sqlId;

    private Integer parseId;

    private Integer executionId;

    private Integer cpu;

    private Integer elapsed;

    private Integer physicalReads;

    private Integer consistentReads;

    private Integer currentReads;

    private Integer libcacheMisses;

    private Integer rowCount;

    private Integer depth;

    private Integer optimizerGoal;

    private Integer tim;

    private Date convertedTim;

    private Integer exebnd;

    private Integer lastTim;

    private String bindVals;

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

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getOptimizerGoal() {
        return optimizerGoal;
    }

    public void setOptimizerGoal(Integer optimizerGoal) {
        this.optimizerGoal = optimizerGoal;
    }

    public Integer getTim() {
        return tim;
    }

    public void setTim(Integer tim) {
        this.tim = tim;
    }

    public Date getConvertedTim() {
        return convertedTim;
    }

    public void setConvertedTim(Date convertedTim) {
        this.convertedTim = convertedTim;
    }

    public Integer getExebnd() {
        return exebnd;
    }

    public void setExebnd(Integer exebnd) {
        this.exebnd = exebnd;
    }

    public Integer getLastTim() {
        return lastTim;
    }

    public void setLastTim(Integer lastTim) {
        this.lastTim = lastTim;
    }

    public String getBindVals() {
        return bindVals;
    }

    public void setBindVals(String bindVals) {
        this.bindVals = bindVals;
    }
}