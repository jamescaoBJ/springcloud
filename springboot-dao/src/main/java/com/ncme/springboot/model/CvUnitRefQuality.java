package com.ncme.springboot.model;

public class CvUnitRefQuality extends CvUnitRefQualityKey {
    private Integer state;

    private Integer parentPropId;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getParentPropId() {
        return parentPropId;
    }

    public void setParentPropId(Integer parentPropId) {
        this.parentPropId = parentPropId;
    }
}