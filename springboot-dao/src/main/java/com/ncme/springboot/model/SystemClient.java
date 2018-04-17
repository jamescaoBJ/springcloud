package com.ncme.springboot.model;

public class SystemClient {
    private Integer id;

    private String clientName;

    private Integer orgId;

    private String contact;

    private String contactPhone;

    private String backupPhone;

    private String mainCharge;

    private String mainChargeContact;

    private String remark;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getBackupPhone() {
        return backupPhone;
    }

    public void setBackupPhone(String backupPhone) {
        this.backupPhone = backupPhone;
    }

    public String getMainCharge() {
        return mainCharge;
    }

    public void setMainCharge(String mainCharge) {
        this.mainCharge = mainCharge;
    }

    public String getMainChargeContact() {
        return mainChargeContact;
    }

    public void setMainChargeContact(String mainChargeContact) {
        this.mainChargeContact = mainChargeContact;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}