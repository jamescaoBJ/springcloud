/**
 * 2018年1月10日 上午11:04:16
 * @author 王印涛
 * SystemUserFaceEntryMapper.java
 */
package com.ncme.springboot.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 王印涛
 * SystemUserFaceEntry.java
 * 2018年1月10日 上午11:04:16
 */
public class SystemUserFaceEntry implements Serializable{

	/**
	 * 2018年1月10日 上午11:11:38
	 * @author 王印涛
	 */
	private static final long serialVersionUID = -5648040437531885708L;
	
	private Integer userId; //用户ID
	
	private Integer fid;//面授报名ID
	
	private Date entryTime;//报名时间

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
    
	
}
