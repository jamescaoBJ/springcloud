package com.ncme.springboot.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class LogStudyCvUnitVideo {
    private Integer id;

    private Integer logStudyCvUnitId;

    private Integer systemUserId;

    private Integer cvId;

    private Integer cvUnitId;

    private Date startDate;

    private Date endDate;

    @NotNull(message="视频总时长不能为空。")
    @Min(value = 0, message = "视频总时长不能小于0")
    private Integer videolength;
    
    @NotNull(message="视频播放长度不能为空。")
    @Min(value = 0, message = "视频总时长不能小于0")
    private Integer videoplaylength;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLogStudyCvUnitId() {
        return logStudyCvUnitId;
    }

    public void setLogStudyCvUnitId(Integer logStudyCvUnitId) {
        this.logStudyCvUnitId = logStudyCvUnitId;
    }

    public Integer getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    public Integer getCvId() {
        return cvId;
    }

    public void setCvId(Integer cvId) {
        this.cvId = cvId;
    }

    public Integer getCvUnitId() {
        return cvUnitId;
    }

    public void setCvUnitId(Integer cvUnitId) {
        this.cvUnitId = cvUnitId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getVideolength() {
        return videolength;
    }

    public void setVideolength(Integer videolength) {
        this.videolength = videolength;
    }

    public Integer getVideoplaylength() {
        return videoplaylength;
    }

    public void setVideoplaylength(Integer videoplaylength) {
        this.videoplaylength = videoplaylength;
    }
}