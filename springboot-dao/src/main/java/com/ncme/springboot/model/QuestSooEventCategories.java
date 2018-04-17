package com.ncme.springboot.model;

public class QuestSooEventCategories {
    private String name;

    private String topcategory;

    private String subcategory;

    private String category;

    private String segStat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopcategory() {
        return topcategory;
    }

    public void setTopcategory(String topcategory) {
        this.topcategory = topcategory;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSegStat() {
        return segStat;
    }

    public void setSegStat(String segStat) {
        this.segStat = segStat;
    }
}