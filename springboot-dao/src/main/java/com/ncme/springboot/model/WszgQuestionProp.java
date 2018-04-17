package com.ncme.springboot.model;

public class WszgQuestionProp {
    private Integer id;

    private Integer parentId;

    private String wszgPropName;

    private Integer wszgPropType;

    private Integer relation;

    private Integer sysProp;

    private Integer state;

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

    public String getWszgPropName() {
        return wszgPropName;
    }

    public void setWszgPropName(String wszgPropName) {
        this.wszgPropName = wszgPropName;
    }

    public Integer getWszgPropType() {
        return wszgPropType;
    }

    public void setWszgPropType(Integer wszgPropType) {
        this.wszgPropType = wszgPropType;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}