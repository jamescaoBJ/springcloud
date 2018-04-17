package com.ncme.springboot.model;

public class YhkQuestionProp {
    private Integer id;

    private Integer parentId;

    private String yhkPropName;

    private Integer yhkPropType;

    private Integer relation;

    private Integer state;

    private Integer seq;

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

    public String getYhkPropName() {
        return yhkPropName;
    }

    public void setYhkPropName(String yhkPropName) {
        this.yhkPropName = yhkPropName;
    }

    public Integer getYhkPropType() {
        return yhkPropType;
    }

    public void setYhkPropType(Integer yhkPropType) {
        this.yhkPropType = yhkPropType;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
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

    public Integer getSysProp() {
        return sysProp;
    }

    public void setSysProp(Integer sysProp) {
        this.sysProp = sysProp;
    }
}