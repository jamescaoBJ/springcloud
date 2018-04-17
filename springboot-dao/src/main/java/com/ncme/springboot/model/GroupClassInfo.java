package com.ncme.springboot.model;

import java.util.Date;

public class GroupClassInfo {
    private Long id;

    private Long classId;

    private String className;

    private Long classParentId;

    private String classParentName;

    private String classContent;

    private Integer state;

    private Date createDate;

    private String templateType;

    private String remark;

    private Integer compIndex;

    private String mediaType;

    private String mediaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getClassParentId() {
        return classParentId;
    }

    public void setClassParentId(Long classParentId) {
        this.classParentId = classParentId;
    }

    public String getClassParentName() {
        return classParentName;
    }

    public void setClassParentName(String classParentName) {
        this.classParentName = classParentName;
    }

    public String getClassContent() {
        return classContent;
    }

    public void setClassContent(String classContent) {
        this.classContent = classContent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCompIndex() {
        return compIndex;
    }

    public void setCompIndex(Integer compIndex) {
        this.compIndex = compIndex;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}