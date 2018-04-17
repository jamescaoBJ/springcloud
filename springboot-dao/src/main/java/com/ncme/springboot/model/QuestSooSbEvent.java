package com.ncme.springboot.model;

public class QuestSooSbEvent {
    private String event;

    private Integer totalWaits;

    private Integer timeWaited;

    private Integer averageWait;

    private Integer pctTimeWaited;

    private Integer pctTotalWaits;

    private Integer sumWaits;

    private Integer sumTimes;

    private String note;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Integer getTotalWaits() {
        return totalWaits;
    }

    public void setTotalWaits(Integer totalWaits) {
        this.totalWaits = totalWaits;
    }

    public Integer getTimeWaited() {
        return timeWaited;
    }

    public void setTimeWaited(Integer timeWaited) {
        this.timeWaited = timeWaited;
    }

    public Integer getAverageWait() {
        return averageWait;
    }

    public void setAverageWait(Integer averageWait) {
        this.averageWait = averageWait;
    }

    public Integer getPctTimeWaited() {
        return pctTimeWaited;
    }

    public void setPctTimeWaited(Integer pctTimeWaited) {
        this.pctTimeWaited = pctTimeWaited;
    }

    public Integer getPctTotalWaits() {
        return pctTotalWaits;
    }

    public void setPctTotalWaits(Integer pctTotalWaits) {
        this.pctTotalWaits = pctTotalWaits;
    }

    public Integer getSumWaits() {
        return sumWaits;
    }

    public void setSumWaits(Integer sumWaits) {
        this.sumWaits = sumWaits;
    }

    public Integer getSumTimes() {
        return sumTimes;
    }

    public void setSumTimes(Integer sumTimes) {
        this.sumTimes = sumTimes;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}