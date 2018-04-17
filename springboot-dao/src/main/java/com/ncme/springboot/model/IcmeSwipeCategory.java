package com.ncme.springboot.model;

import java.util.Date;

public class IcmeSwipeCategory {
    private Integer id;

    private String swipeName;

    private Integer seq;

    private Integer status;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSwipeName() {
        return swipeName;
    }

    public void setSwipeName(String swipeName) {
        this.swipeName = swipeName;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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
}