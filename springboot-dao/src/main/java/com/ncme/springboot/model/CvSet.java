package com.ncme.springboot.model;

import java.util.Date;
import java.util.List;


public class CvSet {
    private Integer id;

    private String name;

    private Integer forma;

    private String code;

    private String filePath;

    private String introduction;

    private String announcement;

    private String knowledgeNeeded;

    private String knowledgeBase;

    private String reference;

    private String referenceLately;

    private String opinion;

    private String report;

    private String opinionType;

    private Integer status;

    private String serialNumber;

    private Integer level;

    private Double score;

    private Double cost;

    private Integer type;

    private Date startDate;

    private Date endDate;

    private Integer breakDays;

    private String maker;

    private String deliMan;

    private Date createDate;

    private Date deliDate;

    private String sign;

    private Integer provinceid;

    private Integer cityid;

    private String relationQuiz;

    private Integer cvSetType;

    private Integer costType;
    
    
    private List<PropUnit> courseList;
    //项目所属学科
    private String propName;
    
    private List<String> xuekeName;

    /**
	 * courseList
	 *
	 * @return  the courseList
	 * @since    Ver 1.0
	*/
	
	public List<PropUnit> getCourseList() {
		return courseList;
	}

	/**
	 * courseList
	 *
	 * @param   courseList    the courseList to set
	 * @since    Ver 1.0
	 */
	
	public void setCourseList(List<PropUnit> courseList) {
		this.courseList = courseList;
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

    public Integer getForma() {
        return forma;
    }

    public void setForma(Integer forma) {
        this.forma = forma;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public String getKnowledgeNeeded() {
        return knowledgeNeeded;
    }

    public void setKnowledgeNeeded(String knowledgeNeeded) {
        this.knowledgeNeeded = knowledgeNeeded;
    }

    public String getKnowledgeBase() {
        return knowledgeBase;
    }

    public void setKnowledgeBase(String knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceLately() {
        return referenceLately;
    }

    public void setReferenceLately(String referenceLately) {
        this.referenceLately = referenceLately;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getOpinionType() {
        return opinionType;
    }

    public void setOpinionType(String opinionType) {
        this.opinionType = opinionType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getBreakDays() {
        return breakDays;
    }

    public void setBreakDays(Integer breakDays) {
        this.breakDays = breakDays;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getDeliMan() {
        return deliMan;
    }

    public void setDeliMan(String deliMan) {
        this.deliMan = deliMan;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDeliDate() {
        return deliDate;
    }

    public void setDeliDate(Date deliDate) {
        this.deliDate = deliDate;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getRelationQuiz() {
        return relationQuiz;
    }

    public void setRelationQuiz(String relationQuiz) {
        this.relationQuiz = relationQuiz;
    }

    public Integer getCvSetType() {
        return cvSetType;
    }

    public void setCvSetType(Integer cvSetType) {
        this.cvSetType = cvSetType;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public List<String> getXuekeName() {
		return xuekeName;
	}

	public void setXuekeName(List<String> xuekeName) {
		this.xuekeName = xuekeName;
	}
	
}