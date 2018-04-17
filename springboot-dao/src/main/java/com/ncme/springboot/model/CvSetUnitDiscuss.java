package com.ncme.springboot.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class CvSetUnitDiscuss {
	
    private Integer id;
    @NotNull(message="项目id不能为空.")
    private Integer cvSetId;
    @NotNull(message="单元id不能为空.")
    private Integer cvUnitId;

    private Integer discussId;
    
    private Integer systemUserId;

    private Date discussDate;
    @NotBlank(message="请输入1~200字~")
    //@Size(min=0,max=200)
    private String discussContent;
    @NotNull(message="讨论类型不能为空.")
    private Integer discussType;
    @NotNull(message="病例id不能为空.")
    private Integer caseId;

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

    public Integer getCvUnitId() {
        return cvUnitId;
    }

    public void setCvUnitId(Integer cvUnitId) {
        this.cvUnitId = cvUnitId;
    }

    public Integer getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
    }

    public Integer getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    public Date getDiscussDate() {
        return discussDate;
    }

    public void setDiscussDate(Date discussDate) {
        this.discussDate = discussDate;
    }

    public String getDiscussContent() {
        return discussContent;
    }

    public void setDiscussContent(String discussContent) {
        this.discussContent = discussContent;
    }

    public Integer getDiscussType() {
        return discussType;
    }

    public void setDiscussType(Integer discussType) {
        this.discussType = discussType;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }
}