package com.ncme.springboot.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class LogStudyCvUnitVideoCensus {
    private Integer id;

    private Integer systemUserId;

    private Integer cvSetId;

    private Integer cvId;

    private Integer cvUnitId;

    private Date createDate;

    @NotNull(message="视频回放长度不能为空。")
    private Integer videoecholength;

    @NotNull(message="视频开始播放的长度不能为空。")
    private Integer videostartlength;

    @NotNull(message="视频结束播放的长度不能为空。")
    private Integer videoendlength;

    @NotNull(message="视频总时长不能为空。")
    private Integer videolength;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    public Integer getCvSetId() {
        return cvSetId;
    }

    public void setCvSetId(Integer cvSetId) {
        this.cvSetId = cvSetId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getVideoecholength() {
        return videoecholength;
    }

    public void setVideoecholength(Integer videoecholength) {
        this.videoecholength = videoecholength;
    }

    public Integer getVideostartlength() {
        return videostartlength;
    }

    public void setVideostartlength(Integer videostartlength) {
        this.videostartlength = videostartlength;
    }

    public Integer getVideoendlength() {
        return videoendlength;
    }

    public void setVideoendlength(Integer videoendlength) {
        this.videoendlength = videoendlength;
    }

    public Integer getVideolength() {
        return videolength;
    }

    public void setVideolength(Integer videolength) {
        this.videolength = videolength;
    }
}