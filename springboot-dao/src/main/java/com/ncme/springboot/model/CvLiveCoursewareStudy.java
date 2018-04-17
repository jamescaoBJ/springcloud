package com.ncme.springboot.model;

import java.util.Date;

public class CvLiveCoursewareStudy {
    private Integer id;

    private Long userId;

    private String coursewareid;

    private String username;

    private Long jointime;

    private Long leavetime;

    private String duration;

    private String ip;

    private Integer device;

    private Date recorddate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCoursewareid() {
        return coursewareid;
    }

    public void setCoursewareid(String coursewareid) {
        this.coursewareid = coursewareid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getJointime() {
        return jointime;
    }

    public void setJointime(Long jointime) {
        this.jointime = jointime;
    }

    public Long getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Long leavetime) {
        this.leavetime = leavetime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getDevice() {
        return device;
    }

    public void setDevice(Integer device) {
        this.device = device;
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }
}