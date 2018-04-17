package com.ncme.springboot.model;

import java.util.Date;
import java.util.List;

public class Cv {
    private Integer id;

    private String name;

    private String serialNumber;

    private String brand;

    private String introduction;

    private String announcement;

    private String filePath;

    private Date createDate;

    private String creator;

    private Integer cvType;

    private List<CvUnit> cvUnitList;
    
    
    /**
	 * cvUnitList
	 *
	 * @return  the cvUnitList
	 * @since    Ver 1.0
	*/
	
	public List<CvUnit> getCvUnitList() {
		return cvUnitList;
	}

	/**
	 * cvUnitList
	 *
	 * @param   cvUnitList    the cvUnitList to set
	 * @since    Ver 1.0
	 */
	
	public void setCvUnitList(List<CvUnit> cvUnitList) {
		this.cvUnitList = cvUnitList;
	}

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getCvType() {
        return cvType;
    }

    public void setCvType(Integer cvType) {
        this.cvType = cvType;
    }
}