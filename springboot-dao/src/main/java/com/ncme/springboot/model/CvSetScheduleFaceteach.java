package com.ncme.springboot.model;

import java.io.Serializable;
import java.util.Date;

public class CvSetScheduleFaceteach implements Serializable{
	
	/**
	 * 2018��1��10�� ����11:13:20
	 * @author ��ӡ��
	 */
	private static final long serialVersionUID = -1770537566052728945L;
	
	private Integer id;
	
    private Integer cvSetId;

    private String className;

    private Integer peopleNumber;

    private String trainPlace;

    private Date trainStarttime;

    private Date trainEndtime;
    
    private String lessionStarttime;
    
    private String lessionEndtime;

    private String contactWay;

    private Integer sequencenum;


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    
    public Integer getCvSetId() {
        return cvSetId;
    }

    public void setCvSetId(Integer cvSetId) {
        this.cvSetId = cvSetId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getTrainPlace() {
        return trainPlace;
    }

    public void setTrainPlace(String trainPlace) {
        this.trainPlace = trainPlace;
    }

    public Date getTrainStarttime() {
        return trainStarttime;
    }

    public void setTrainStarttime(Date trainStarttime) {
        this.trainStarttime = trainStarttime;
    }

    public Date getTrainEndtime() {
        return trainEndtime;
    }

    public void setTrainEndtime(Date trainEndtime) {
        this.trainEndtime = trainEndtime;
    }

	public String getLessionStarttime() {
		return lessionStarttime;
	}

	public void setLessionStarttime(String lessionStarttime) {
		this.lessionStarttime = lessionStarttime;
	}

	public String getLessionEndtime() {
		return lessionEndtime;
	}

	public void setLessionEndtime(String lessionEndtime) {
		this.lessionEndtime = lessionEndtime;
	}

	public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public Integer getSequencenum() {
        return sequencenum;
    }

    public void setSequencenum(Integer sequencenum) {
        this.sequencenum = sequencenum;
    }

}