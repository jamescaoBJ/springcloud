package com.ncme.springboot.model;

public class CvUnit {
    private Integer id;

    private String name;

    private Integer type;

    private Integer point;

    private Integer state;

    private String content;

    private Integer isbound;

    private Double quota;

    private Integer sequencenum;

    private Integer unitMakeType;
    
    private Integer studyState;
    
    private String mediaType;

    private String videoUrl;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsbound() {
        return isbound;
    }

    public void setIsbound(Integer isbound) {
        this.isbound = isbound;
    }

    public Double getQuota() {
        return quota;
    }

    public void setQuota(Double quota) {
        this.quota = quota;
    }

    public Integer getSequencenum() {
        return sequencenum;
    }

    public void setSequencenum(Integer sequencenum) {
        this.sequencenum = sequencenum;
    }

    public Integer getUnitMakeType() {
        return unitMakeType;
    }

    public void setUnitMakeType(Integer unitMakeType) {
        this.unitMakeType = unitMakeType;
    }

	public Integer getStudyState() {
		return studyState;
	}

	public void setStudyState(Integer studyState) {
		this.studyState = studyState;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
}