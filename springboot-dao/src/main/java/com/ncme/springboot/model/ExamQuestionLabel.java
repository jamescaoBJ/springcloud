package com.ncme.springboot.model;

public class ExamQuestionLabel {
    private Integer id;

    private String name;

    private Integer isChild;

    private Integer lType;

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

    public Integer getIsChild() {
        return isChild;
    }

    public void setIsChild(Integer isChild) {
        this.isChild = isChild;
    }

    public Integer getlType() {
        return lType;
    }

    public void setlType(Integer lType) {
        this.lType = lType;
    }
}