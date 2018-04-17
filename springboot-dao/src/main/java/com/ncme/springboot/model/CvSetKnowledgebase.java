package com.ncme.springboot.model;

public class CvSetKnowledgebase {
    private Integer cvSetId;

    private String knowledgebaseName;

    private String knowledgebaseUrl;

    public Integer getCvSetId() {
        return cvSetId;
    }

    public void setCvSetId(Integer cvSetId) {
        this.cvSetId = cvSetId;
    }

    public String getKnowledgebaseName() {
        return knowledgebaseName;
    }

    public void setKnowledgebaseName(String knowledgebaseName) {
        this.knowledgebaseName = knowledgebaseName;
    }

    public String getKnowledgebaseUrl() {
        return knowledgebaseUrl;
    }

    public void setKnowledgebaseUrl(String knowledgebaseUrl) {
        this.knowledgebaseUrl = knowledgebaseUrl;
    }
}