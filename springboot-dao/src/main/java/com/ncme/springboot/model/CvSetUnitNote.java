package com.ncme.springboot.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class CvSetUnitNote {
    private Integer id;
    
    @NotNull(message="项目id不能为空。")
    private Integer cvSetId;
    
    
    @NotNull(message="项目单元id不能为空。")

    private Integer cvUnitId;

    private Integer systemUserId;

    private Date noteDate;
    @NotBlank(message="请输入1~200字~")
    //@Size(min=1,max=200,message="请输入1~200字~")
    private String noteContent;

    private Integer status;
    @NotNull(message="笔记类型不能为空。")
    private Integer noteType;

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

    public Integer getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNoteType() {
        return noteType;
    }

    public void setNoteType(Integer noteType) {
        this.noteType = noteType;
    }
}