package com.ncme.springboot.model;

public class QuestSooAtSqlStmtPieces {
    private Integer traceFileId;

    private Integer sqlId;

    private Integer pieceNo;

    private String sqlText;

    public Integer getTraceFileId() {
        return traceFileId;
    }

    public void setTraceFileId(Integer traceFileId) {
        this.traceFileId = traceFileId;
    }

    public Integer getSqlId() {
        return sqlId;
    }

    public void setSqlId(Integer sqlId) {
        this.sqlId = sqlId;
    }

    public Integer getPieceNo() {
        return pieceNo;
    }

    public void setPieceNo(Integer pieceNo) {
        this.pieceNo = pieceNo;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }
}