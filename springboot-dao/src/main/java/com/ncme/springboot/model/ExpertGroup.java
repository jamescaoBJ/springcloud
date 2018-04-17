package com.ncme.springboot.model;

import java.util.Date;

public class ExpertGroup {
    private Integer id;

    private String name;

    private String contact;

    private Integer parent;

    private String phone1;

    private String phone2;

    private String email;

    private String address;

    private String summary;

    private String note;

    private Date organizedate;

    private Date breakdate;

    private Integer state;

    private String master;

    private Integer lockstate;

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getOrganizedate() {
        return organizedate;
    }

    public void setOrganizedate(Date organizedate) {
        this.organizedate = organizedate;
    }

    public Date getBreakdate() {
        return breakdate;
    }

    public void setBreakdate(Date breakdate) {
        this.breakdate = breakdate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public Integer getLockstate() {
        return lockstate;
    }

    public void setLockstate(Integer lockstate) {
        this.lockstate = lockstate;
    }
}