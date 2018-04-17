package com.ncme.springboot.model;

import java.util.Date;

public class SystemBugLog {
    private Integer id;

    private String title;

    private String content;

    private Integer bugLevel;

    private Integer bugStatus;

    private Integer status;

    private String creator;

    private String finisher;

    private Date createDate;

    private Date updateDate;

    private String reply;

    private Integer type;

    private String filePath;

    private String filePathTwo;

    private String filePathThree;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBugLevel() {
        return bugLevel;
    }

    public void setBugLevel(Integer bugLevel) {
        this.bugLevel = bugLevel;
    }

    public Integer getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(Integer bugStatus) {
        this.bugStatus = bugStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getFinisher() {
        return finisher;
    }

    public void setFinisher(String finisher) {
        this.finisher = finisher;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePathTwo() {
        return filePathTwo;
    }

    public void setFilePathTwo(String filePathTwo) {
        this.filePathTwo = filePathTwo;
    }

    public String getFilePathThree() {
        return filePathThree;
    }

    public void setFilePathThree(String filePathThree) {
        this.filePathThree = filePathThree;
    }
}