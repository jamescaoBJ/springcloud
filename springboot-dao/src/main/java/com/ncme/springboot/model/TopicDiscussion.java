package com.ncme.springboot.model;

import java.util.Date;

public class TopicDiscussion {
    private Integer id;

    private String talkContent;

    private Date createDate;

    private String createUser;

    private String talkAnsy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTalkContent() {
        return talkContent;
    }

    public void setTalkContent(String talkContent) {
        this.talkContent = talkContent;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getTalkAnsy() {
        return talkAnsy;
    }

    public void setTalkAnsy(String talkAnsy) {
        this.talkAnsy = talkAnsy;
    }
}