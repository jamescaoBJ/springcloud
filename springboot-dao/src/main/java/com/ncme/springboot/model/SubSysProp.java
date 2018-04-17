package com.ncme.springboot.model;

public class SubSysProp {
    private Integer id;

    private String name;

    private Integer relation;

    private Integer seq;

    private Integer upLevel;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getUpLevel() {
        return upLevel;
    }

    public void setUpLevel(Integer upLevel) {
        this.upLevel = upLevel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}