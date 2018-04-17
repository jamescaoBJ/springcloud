package com.ncme.springboot.model;

public class QuestSooSchemaVersions {
    private String schemaId;

    private Integer version;

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}