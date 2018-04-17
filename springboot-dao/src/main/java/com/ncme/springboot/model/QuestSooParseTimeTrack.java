package com.ncme.springboot.model;

import java.util.Date;

public class QuestSooParseTimeTrack {
    private Integer parseTimeElapsed;

    private Date timeStamp;

    public Integer getParseTimeElapsed() {
        return parseTimeElapsed;
    }

    public void setParseTimeElapsed(Integer parseTimeElapsed) {
        this.parseTimeElapsed = parseTimeElapsed;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}