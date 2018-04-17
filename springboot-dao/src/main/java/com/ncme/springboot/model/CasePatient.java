package com.ncme.springboot.model;

import java.util.Date;

public class CasePatient {
    private Integer id;

    private Date diagdate;

    private String pname;

    private Integer sex;

    private Date birthday;

    private String certificate;

    private Integer nationalState;

    private Integer number1type;

    private String number1;

    private Integer number2type;

    private String number2;

    private String phonenumber1;

    private String phonenumber2;

    private String diagname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDiagdate() {
        return diagdate;
    }

    public void setDiagdate(Date diagdate) {
        this.diagdate = diagdate;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Integer getNationalState() {
        return nationalState;
    }

    public void setNationalState(Integer nationalState) {
        this.nationalState = nationalState;
    }

    public Integer getNumber1type() {
        return number1type;
    }

    public void setNumber1type(Integer number1type) {
        this.number1type = number1type;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public Integer getNumber2type() {
        return number2type;
    }

    public void setNumber2type(Integer number2type) {
        this.number2type = number2type;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getPhonenumber1() {
        return phonenumber1;
    }

    public void setPhonenumber1(String phonenumber1) {
        this.phonenumber1 = phonenumber1;
    }

    public String getPhonenumber2() {
        return phonenumber2;
    }

    public void setPhonenumber2(String phonenumber2) {
        this.phonenumber2 = phonenumber2;
    }

    public String getDiagname() {
        return diagname;
    }

    public void setDiagname(String diagname) {
        this.diagname = diagname;
    }
}