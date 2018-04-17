package com.ncme.springboot.model;

public class TrainContentSite {
    private Integer id;

    private String applicationId;

    private String siteName;

    private String siteLogo;

    private Integer siteVisit;

    private String siteFoot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteLogo() {
        return siteLogo;
    }

    public void setSiteLogo(String siteLogo) {
        this.siteLogo = siteLogo;
    }

    public Integer getSiteVisit() {
        return siteVisit;
    }

    public void setSiteVisit(Integer siteVisit) {
        this.siteVisit = siteVisit;
    }

    public String getSiteFoot() {
        return siteFoot;
    }

    public void setSiteFoot(String siteFoot) {
        this.siteFoot = siteFoot;
    }
}