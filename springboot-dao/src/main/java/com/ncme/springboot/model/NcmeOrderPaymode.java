package com.ncme.springboot.model;

public class NcmeOrderPaymode {
    private String paymodeCode;

    private String paymodeName;

    public String getPaymodeCode() {
        return paymodeCode;
    }

    public void setPaymodeCode(String paymodeCode) {
        this.paymodeCode = paymodeCode;
    }

    public String getPaymodeName() {
        return paymodeName;
    }

    public void setPaymodeName(String paymodeName) {
        this.paymodeName = paymodeName;
    }
}