package com.ncme.springboot.model;

import java.util.Date;

public class NcmeExpert {
    private Integer expId;

    private String expName;

    private String sex;

    private String type;

    private String workunit;

    private String birth;

    private String special;

    private String post;

    private String photourl;

    private String photourl2;

    private String gradsclDate;

    private String workstory;

    private String deptInfo;

    private Integer ballot;

    private String remark;

    private Date createDate;

    public Integer getExpId() {
        return expId;
    }

    public void setExpId(Integer expId) {
        this.expId = expId;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWorkunit() {
        return workunit;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getPhotourl2() {
        return photourl2;
    }

    public void setPhotourl2(String photourl2) {
        this.photourl2 = photourl2;
    }

    public String getGradsclDate() {
        return gradsclDate;
    }

    public void setGradsclDate(String gradsclDate) {
        this.gradsclDate = gradsclDate;
    }

    public String getWorkstory() {
        return workstory;
    }

    public void setWorkstory(String workstory) {
        this.workstory = workstory;
    }

    public String getDeptInfo() {
        return deptInfo;
    }

    public void setDeptInfo(String deptInfo) {
        this.deptInfo = deptInfo;
    }

    public Integer getBallot() {
        return ballot;
    }

    public void setBallot(Integer ballot) {
        this.ballot = ballot;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}