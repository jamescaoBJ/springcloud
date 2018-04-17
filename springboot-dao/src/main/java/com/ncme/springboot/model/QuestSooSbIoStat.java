package com.ncme.springboot.model;

public class QuestSooSbIoStat {
    private Integer fileNo;

    private String tablespaceName;

    private String fileName;

    private String deviceName;

    private String shortName;

    private Integer phywrts;

    private Integer phyrds;

    private Integer phyblkwrt;

    private Integer phyblkrd;

    private Integer blocks;

    private Integer totIo;

    private Integer readtim;

    private Integer writetim;

    public Integer getFileNo() {
        return fileNo;
    }

    public void setFileNo(Integer fileNo) {
        this.fileNo = fileNo;
    }

    public String getTablespaceName() {
        return tablespaceName;
    }

    public void setTablespaceName(String tablespaceName) {
        this.tablespaceName = tablespaceName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getPhywrts() {
        return phywrts;
    }

    public void setPhywrts(Integer phywrts) {
        this.phywrts = phywrts;
    }

    public Integer getPhyrds() {
        return phyrds;
    }

    public void setPhyrds(Integer phyrds) {
        this.phyrds = phyrds;
    }

    public Integer getPhyblkwrt() {
        return phyblkwrt;
    }

    public void setPhyblkwrt(Integer phyblkwrt) {
        this.phyblkwrt = phyblkwrt;
    }

    public Integer getPhyblkrd() {
        return phyblkrd;
    }

    public void setPhyblkrd(Integer phyblkrd) {
        this.phyblkrd = phyblkrd;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getTotIo() {
        return totIo;
    }

    public void setTotIo(Integer totIo) {
        this.totIo = totIo;
    }

    public Integer getReadtim() {
        return readtim;
    }

    public void setReadtim(Integer readtim) {
        this.readtim = readtim;
    }

    public Integer getWritetim() {
        return writetim;
    }

    public void setWritetim(Integer writetim) {
        this.writetim = writetim;
    }
}