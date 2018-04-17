package com.ncme.springboot.model;

public class SubSysPropVal {
    private Integer id;

    private Integer sysPropId;

    private Integer propValId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSysPropId() {
        return sysPropId;
    }

    public void setSysPropId(Integer sysPropId) {
        this.sysPropId = sysPropId;
    }

    public Integer getPropValId() {
        return propValId;
    }

    public void setPropValId(Integer propValId) {
        this.propValId = propValId;
    }
}