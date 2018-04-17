package com.ncme.springboot.model;

public class CvLiveStudyRef {
    private Integer id;

    private String classNo;

    private Long startTime;

    private Long endTime;

    private Integer totalLiveLength;

    private Integer audienceNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getTotalLiveLength() {
        return totalLiveLength;
    }

    public void setTotalLiveLength(Integer totalLiveLength) {
        this.totalLiveLength = totalLiveLength;
    }

    public Integer getAudienceNum() {
        return audienceNum;
    }

    public void setAudienceNum(Integer audienceNum) {
        this.audienceNum = audienceNum;
    }
}