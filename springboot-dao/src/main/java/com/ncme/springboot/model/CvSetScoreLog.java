package com.ncme.springboot.model;

import java.math.BigDecimal;
import java.util.Date;

public class CvSetScoreLog extends CvSetScoreLogKey {
	private Integer cvSetId;
	
	private Integer systemUserId;
	
    private BigDecimal score1;

    private BigDecimal score2;

    private BigDecimal score3;

    private BigDecimal score4;

    private Date scoreDate;

    private String scoreContent;
    
    
    

    public Integer getCvSetId() {
		return cvSetId;
	}

	public void setCvSetId(Integer cvSetId) {
		this.cvSetId = cvSetId;
	}

	public Integer getSystemUserId() {
		return systemUserId;
	}

	public void setSystemUserId(Integer systemUserId) {
		this.systemUserId = systemUserId;
	}

	public BigDecimal getScore1() {
        return score1;
    }

    public void setScore1(BigDecimal score1) {
        this.score1 = score1;
    }

    public BigDecimal getScore2() {
        return score2;
    }

    public void setScore2(BigDecimal score2) {
        this.score2 = score2;
    }

    public BigDecimal getScore3() {
        return score3;
    }

    public void setScore3(BigDecimal score3) {
        this.score3 = score3;
    }

    public BigDecimal getScore4() {
        return score4;
    }

    public void setScore4(BigDecimal score4) {
        this.score4 = score4;
    }

    public Date getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(Date scoreDate) {
        this.scoreDate = scoreDate;
    }

    public String getScoreContent() {
        return scoreContent;
    }

    public void setScoreContent(String scoreContent) {
        this.scoreContent = scoreContent;
    }
}