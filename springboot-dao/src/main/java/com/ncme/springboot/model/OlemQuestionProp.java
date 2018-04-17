package com.ncme.springboot.model;

public class OlemQuestionProp {
    private Integer id;

    private Integer parentId;

    private String olemPropName;

    private Integer olemPropType;

    private Integer relation;

    private Integer sysProp;

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

    public String getOlemPropName() {
        return olemPropName;
    }

    public void setOlemPropName(String olemPropName) {
        this.olemPropName = olemPropName;
    }

    public Integer getOlemPropType() {
        return olemPropType;
    }

    public void setOlemPropType(Integer olemPropType) {
        this.olemPropType = olemPropType;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public Integer getSysProp() {
        return sysProp;
    }

    public void setSysProp(Integer sysProp) {
        this.sysProp = sysProp;
    }
}