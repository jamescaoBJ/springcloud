package com.ncme.springboot.model;

public class QuestSooSbBufferBusy {
    private String CLASS;

    private Integer waits;

    private Integer pctOfCount;

    private Integer pctOfTime;

    private Integer logicalReads;

    private Integer ratio;

    private String note;

    private Integer time;

    public String getCLASS() {
        return CLASS;
    }

    public void setCLASS(String CLASS) {
        this.CLASS = CLASS;
    }

    public Integer getWaits() {
        return waits;
    }

    public void setWaits(Integer waits) {
        this.waits = waits;
    }

    public Integer getPctOfCount() {
        return pctOfCount;
    }

    public void setPctOfCount(Integer pctOfCount) {
        this.pctOfCount = pctOfCount;
    }

    public Integer getPctOfTime() {
        return pctOfTime;
    }

    public void setPctOfTime(Integer pctOfTime) {
        this.pctOfTime = pctOfTime;
    }

    public Integer getLogicalReads() {
        return logicalReads;
    }

    public void setLogicalReads(Integer logicalReads) {
        this.logicalReads = logicalReads;
    }

    public Integer getRatio() {
        return ratio;
    }

    public void setRatio(Integer ratio) {
        this.ratio = ratio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}