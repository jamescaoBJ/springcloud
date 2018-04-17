package com.ncme.springboot.model;

import java.util.Date;

public class IcmeScoreType {
    private Integer id;

    private Integer parentId;

    private String scoreTypeName;

    private Integer projectType;

    private Integer isNoproject;

    private Integer yearId;

    private Integer status;

    private Date createDate;

    private Integer seq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getScoreTypeName() {
        return scoreTypeName;
    }

    public void setScoreTypeName(String scoreTypeName) {
        this.scoreTypeName = scoreTypeName;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public Integer getIsNoproject() {
        return isNoproject;
    }

    public void setIsNoproject(Integer isNoproject) {
        this.isNoproject = isNoproject;
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}