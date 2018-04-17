package com.ncme.springboot.model;

public class XiangyiProvince {
    private Integer provinceId;

    private String provinceName;

    private Byte orderNumber;

    private String provinceCode;

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Byte getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Byte orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}