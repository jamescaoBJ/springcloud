package com.ncme.springboot.model;

import java.util.Date;

public class CaseCase {
    private Integer id;

    private Integer pId;

    private Integer diseaseId;

    private Date createDate;

    private Date onlineDate;

    private Integer creator;

    private Integer state;

    private String deliOpinion;

    private String deliMan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getOnlineDate() {
        return onlineDate;
    }

    public void setOnlineDate(Date onlineDate) {
        this.onlineDate = onlineDate;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDeliOpinion() {
        return deliOpinion;
    }

    public void setDeliOpinion(String deliOpinion) {
        this.deliOpinion = deliOpinion;
    }

    public String getDeliMan() {
        return deliMan;
    }

    public void setDeliMan(String deliMan) {
        this.deliMan = deliMan;
    }
}